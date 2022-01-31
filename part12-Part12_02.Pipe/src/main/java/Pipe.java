import java.util.ArrayList;

public class Pipe<T> {
    private ArrayList<T> inPipe = new ArrayList<>();
    
    public Pipe() {
        
    }
    
    public void putIntoPipe(T value) {
        this.inPipe.add(value);
    }
    
    public boolean isInPipe() {
        return !this.inPipe.isEmpty();
    }
    
    public T takeFromPipe() {
        if (this.inPipe.isEmpty()) {
            return null;
        } else {
            T value = this.inPipe.get(0);
            this.inPipe.remove(0);
            return value;
        }
    }
    
}
