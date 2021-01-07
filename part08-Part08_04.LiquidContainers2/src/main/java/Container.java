
public class Container {
    private int maximum;
    private int contains;
    
    public Container() {
        this.maximum = 100;
        this.contains = 0;
    }
    
    public void add(int amount) {
        if (isNegative(amount)) {
            return;
        }
        contains += amount;
        overfilled();
    }
    
    public void remove(int amount) {
        if (isNegative(amount)) {
            return;
        }
        contains -= amount;
        underfilled();
    }
    
    public int contains() {
        return this.contains;
    }
    
    @Override
    public String toString() {
        return this.contains + "/" + this.maximum;
    }
    
    private boolean isNegative(int number) {
        if (number < 0) {
            return true;
        }
        return false;
    }
    
    private void overfilled() {
        if (contains > maximum) {
            contains = maximum;
        }
    }
    
    private void underfilled() {
        if (contains < 0) {
            contains = 0;
        }
    }
}
