
public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;
    
    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        super.addToWarehouse(initialBalance);
        this.history = new ChangeHistory();
        history.add(initialBalance);
    }
    
    @Override
    public void addToWarehouse(double amount) {
        if (amount + super.getBalance() > super.getCapacity()) {
            return;
        }
        super.addToWarehouse(amount);
        history.add(super.getCapacity() - super.howMuchSpaceLeft());
    }
    
    @Override
    public double takeFromWarehouse(double amount) {
        if (amount > super.getBalance()) {
            double allThatWeCan = super.getBalance();
            super.takeFromWarehouse(allThatWeCan);
            return allThatWeCan;
        }
        super.takeFromWarehouse(amount);
        history.add(super.getCapacity() - super.howMuchSpaceLeft());
        return amount;
    }
    
    public void printAnalysis() {
        System.out.println("Product: " + getName());
        System.out.println("History: " + history());
        System.out.println("Largest amount of product: " + history.maxValue());
        System.out.println("Smallest amount of product: " + history.minValue());
        System.out.println("Average: " + history.average());
    }
    
    public String history() {
        return history.toString();
    }
    
}
