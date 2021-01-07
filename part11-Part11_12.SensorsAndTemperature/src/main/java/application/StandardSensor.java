
package application;

public class StandardSensor implements Sensor {
    
    private int temp;
    
    public StandardSensor(int temp) {
        this.temp = temp;
    }
    
    @Override
    public boolean isOn() {
        return true;
    }
    
    @Override
    public void setOn() {
        
    }
    
    @Override
    public void setOff() {
        
    }
    
    @Override
    public int read() {
        return this.temp;
    }
    
}
