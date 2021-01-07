
public class Book implements Packable {
    
    private String author;
    private String name;
    private double weight;
    
    public Book(String auth, String name, double weight) {
        this.author = auth;
        this.name = name;
        this.weight = weight;
    }
    
    public double weight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return this.author + ": " + this.name;
    }
    
}
