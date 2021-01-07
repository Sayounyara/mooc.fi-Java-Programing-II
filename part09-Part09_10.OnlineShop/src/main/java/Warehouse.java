
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> stock;
    
    public Warehouse() {
        this.products = new HashMap<>();
        this.stock = new HashMap<>();
    }
    
    public void addProduct(String product, int price, int stock) {
        this.products.put(product, price);
        this.stock.put(product, stock);
    }
    
    public boolean take(String product) {
        if (!this.stock.containsKey(product)) {
            return false;
        }
        if (this.stock.get(product) > 0) {
            int newStock = this.stock.get(product) - 1;
            this.stock.replace(product, newStock);
            return true;
        }
        return false;
    }
    
    public Set<String> products() {
        return this.products.keySet();
    }
    
    public int price(String product) {
        return this.products.getOrDefault(product, -99);
    }
    
    public int stock(String product) {
        return this.stock.getOrDefault(product, 0);
    }
    
}
