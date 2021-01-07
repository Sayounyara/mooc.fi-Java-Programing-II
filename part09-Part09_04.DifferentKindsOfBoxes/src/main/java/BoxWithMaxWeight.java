import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    
    private ArrayList<Item> items;
    private int capacity;
    
    public BoxWithMaxWeight(int capacity) {
        this.items = new ArrayList<>();
        this.capacity = capacity;
    }
    
    @Override
    public void add(Item item) {
        if (item.getWeight() + balance() > this.capacity) {
            return;
        }
        this.items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return this.items.contains(item);
    }
    
    public int balance() {
        int balance = 0;
        int i = 0;
        while (i < this.items.size()) {
            balance += this.items.get(i).getWeight();
            System.out.println(this.items.get(i).getWeight());
            System.out.println("Current Balance: " + balance);
            i++;
        }
        return balance;
    }

}
