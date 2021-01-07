
import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;
    
    public ChangeHistory() {
        this.history = new ArrayList<>();
    }
    
    public void add(double status) {
        history.add(status);
    }
    
    public void clear() {
        history.clear();
    }
    
    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double max = history.get(0);
        for (double i: history) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    
    public double minValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double min = history.get(0);
        for (double i: history) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }
    
    public double average() {
        if (history.isEmpty()) {
            return 0;
        }
        double sum = 0;
        int total = 0;
        for (double i: history) {
            sum += i;
            total++;
        }
        return sum / total;
    }
    
    public String toString() {
        return history.toString();
    }
    
}
