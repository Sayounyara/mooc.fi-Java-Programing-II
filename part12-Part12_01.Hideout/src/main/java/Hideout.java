public class Hideout<T> {
    T hiding;
    T empty;
    
    public Hideout () {
        
    }
    
    public void putIntoHideout(T toHide) {
        this.hiding = toHide;
    }
    
    public T takeFromHideout() {
        T value;
        value = this.hiding;
        this.hiding = this.empty;
        return value;
    }
    
    public boolean isInHideout() {
        return  this.hiding != this.empty;
    }
    
}
