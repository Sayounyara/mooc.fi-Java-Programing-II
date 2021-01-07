
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    
    private Map<String, Item> items;
    
    public ShoppingCart() {
        this.items = new HashMap<>();
    }
    
    public void add(String product, int price) {
        if (this.items.containsKey(product)) {
            this.items.get(product).increaseQuantity();
            return;
        }
        this.items.put(product, new Item(product, 1, price)); //letz see if this works
    }
    
    public void print() {
        for (Item item : this.items.values()) {
            System.out.println(item);
        }
    }
    
    public int price() {
        int totalPrice = 0;
        Collection<Item> prices = this.items.values();
        for (Item item : prices) {
            totalPrice += item.price();
        }
        return totalPrice;
    }
    
}
