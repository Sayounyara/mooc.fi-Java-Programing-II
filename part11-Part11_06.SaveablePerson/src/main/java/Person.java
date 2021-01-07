
public class Person implements Saveable {
    
    private String name;
    private String address;
    
    @Override
    public void save() {
        System.out.println("Saving!");
    }
    
    @Override
    public void delete() {
        System.out.println("Deleting!");
    }
    
    @Override
    public void load(String address) {
        System.out.println("Loading " + address + "!");
    }
    
}
