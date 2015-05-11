
import com.trouch.webiopi.client.PiClient;
import com.trouch.webiopi.client.PiHttpClient;
import com.trouch.webiopi.client.devices.digital.GPIO;
import com.trouch.webiopi.client.devices.digital.NativeGPIO;

public class RaspiCar {
    
    private String host="";
    private PiClient client;
    private final NativeGPIO gpio;
    private final int forwardGPIO = 4;
    private final int backwardGPIO = 17;
    private final int leftGPIO = 27;
    private final int rightGPIO = 22;
    
    private boolean fwPinState = false;
    private boolean bwPinState = false;
    private boolean rPinState = false;
    private boolean lPinState = false;

    public RaspiCar(String host, int port, String username, String password) {
        this.host = host;
        client = new PiHttpClient(host, port);
        client.setCredentials(username, password);
        
        gpio = new NativeGPIO(client);
        
        gpio.setFunction(forwardGPIO, GPIO.OUT);
        gpio.setFunction(backwardGPIO, GPIO.OUT);
        gpio.setFunction(leftGPIO, GPIO.OUT);
        gpio.setFunction(rightGPIO, GPIO.OUT);
    }

    public boolean isFwPinState() {
        return fwPinState;
    }

    public void setFwPinState(boolean fwPinState) {
        this.fwPinState = fwPinState;
    }

    public boolean isBwPinState() {
        return bwPinState;
    }

    public void setBwPinState(boolean bwPinState) {
        this.bwPinState = bwPinState;
    }

    public boolean isrPinState() {
        return rPinState;
    }

    public void setrPinState(boolean rPinState) {
        this.rPinState = rPinState;
    }

    public boolean islPinState() {
        return lPinState;
    }

    public void setlPinState(boolean lPinState) {
        this.lPinState = lPinState;
    }
    
    public NativeGPIO getGpio() {
        return gpio;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public PiClient getClient() {
        return client;
    }

    public void setClient(PiClient client) {
        this.client = client;
    }

    public int getForwardGPIO() {
        return forwardGPIO;
    }

    public int getBackwardGPIO() {
        return backwardGPIO;
    }

    public int getLeftGPIO() {
        return leftGPIO;
    }

    public int getRightGPIO() {
        return rightGPIO;
    }
    
    public void moveForward(){
        if(fwPinState != true){
            gpio.digitalWrite(forwardGPIO, true);
            fwPinState = true;
        }
    }
    
    public void moveBackward(){
        if(bwPinState != true){
            gpio.digitalWrite(backwardGPIO, true);
            bwPinState = true;
        }
    }
    
    public void moveLeft(){
        if(lPinState != true){
            gpio.digitalWrite(leftGPIO, true);
            lPinState = true;
        }
    }
    
    public void moveRight(){
        if(rPinState != true){
            gpio.digitalWrite(rightGPIO, true);
            rPinState = true;
        }
    }
    
    public void stopFw(){
        if(fwPinState == true){
            gpio.digitalWrite(forwardGPIO, false);
            fwPinState = false;
        }
    }
    
    public void stopBw(){
        if(bwPinState == true){
            gpio.digitalWrite(backwardGPIO, false);
            bwPinState = false;
        }
    }
    
    public void stopLeft(){
        if(lPinState == true){
            gpio.digitalWrite(leftGPIO, false);
            lPinState = false;
        }
    }
    
    public void stopRight(){
        if(rPinState == true){
            gpio.digitalWrite(rightGPIO, false);
            rPinState = false;
        }
    }
    
    
}
