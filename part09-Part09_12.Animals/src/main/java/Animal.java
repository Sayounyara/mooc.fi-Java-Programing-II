
public abstract class Animal {
    
     protected String name;
    
    public Animal(String name) {
        this.name = name;
    }
    
    public void eat() {
        System.out.println(this.name + " eats");
    }
    
    public void sleep() {
        System.out.println(this.name + " sleeps");
    }
    
    public String getName() {
        return this.name;
    }
    
}
