
import java.util.ArrayList;

public class Box implements Packable {
    
    private ArrayList<Packable> items;
    private double capacity;
    
    public Box(double max) {
        this.items = new ArrayList<>();
        this.capacity = max;
    }
    
    public void add(Packable packable) {
        if (boxWeight() + packable.weight() > this.capacity) {
            return;
        }
        this.items.add(packable);
    }
    
    public double weight() {
        return boxWeight();
    }
    
    private double boxWeight() {
        double weight = 0;
        for (Packable i : this.items) {
            weight += i.weight();
        }
        return weight;
    }
    
    @Override
    public String toString() {
        return "Box: " + this.items.size() + " items, total weight " + boxWeight() + " kg";
    }
    
}
