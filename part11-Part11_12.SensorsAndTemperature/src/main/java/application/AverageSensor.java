
package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    
    private List<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
    @Override
    public boolean isOn() {
        boolean areTheyOn = true;
        for (Sensor s : this.sensors) {
            if (!s.isOn()) {
                areTheyOn = false;
            }
        }
        
        return areTheyOn;
    }
    
    @Override
    public void setOn() {
        for (Sensor s : this.sensors) {
            s.setOn();
        }
    }
    
    @Override
    public void setOff() {
        for (Sensor s : this.sensors) {
            s.setOff();
        }
    }
    
    @Override
    public int read() {
        if (isOn() == false) {
            throw new IllegalStateException("AverageSensor must be on to read tempurature.");
        }
        if (sensors.isEmpty()) {
            throw new IllegalStateException("AverageSensor must have at least one "
                                            + "sensor added to it to read tempurature.");
        }
        
        int avg = 0;
        for (Sensor s : this.sensors) {
            avg += s.read();
        }
        
        this.readings.add(avg / this.sensors.size());
        return avg / this.sensors.size();        
    }
    
}
