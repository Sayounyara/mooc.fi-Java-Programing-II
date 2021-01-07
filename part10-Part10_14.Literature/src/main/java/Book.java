
public class Book {
    
    private String name;
    private int ageRec;
    
    public Book(String name, int age) {
        this.name = name;
        this.ageRec = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.ageRec;
    }
    
    @Override
    public String toString() {
        return this.name + " (recommended for " + this.ageRec + " year-olds or older)";
    }
    
}
