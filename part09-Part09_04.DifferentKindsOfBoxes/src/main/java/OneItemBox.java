
import java.util.ArrayList;

public class OneItemBox extends Box {
    
    private ArrayList<Item> item;
    
    public OneItemBox() {
        this.item = new ArrayList<>();
    }
    
    @Override
    public void add(Item item) {
        if (!(this.item.isEmpty())) {
            return;
        }
        this.item.add(item);
    }
    
    public boolean isInBox(Item item) {
        return this.item.contains(item);
    }

}
