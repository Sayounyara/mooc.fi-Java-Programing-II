
public class Cat extends Animal implements NoiseCapable {
    
    public Cat(String name) {
        super(name);
    }
    
    public Cat() {
        super("Dog");
    }
    
    public void purr() {
        System.out.println(this.name + " purrs");
    }
    
    @Override
    public void makeNoise() {
        purr();
    }
    
}
