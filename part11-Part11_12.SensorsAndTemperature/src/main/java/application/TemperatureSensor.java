
package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    
    private boolean on;
    
    public TemperatureSensor() {
        this.on = false;
    }
    
    @Override
    public boolean isOn() {
        return this.on;
    }
    
    @Override
    public void setOn() {
        this.on = true;
    }
    
    @Override
    public void setOff() {
        this.on = false;
    }
    
    @Override
    public int read() {
        if (on == false) {
            throw new IllegalStateException("TempuratureSensor must be on to read tempurature.");
        }
        int range = new Random().nextInt(61);
        return range - 30;
    }
    
}
