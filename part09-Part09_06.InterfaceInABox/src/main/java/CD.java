
public class CD implements Packable{
    
    private String artist;
    private String name;
    private int publicationYear;
    private double weight;
    
    public CD(String artist, String name, int pubYear) {
        this.artist = artist;
        this.name = name;
        this.publicationYear = pubYear;
        this.weight = 0.1;
    }
    
    
    public double weight() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return this.artist + ": " + this.name + " (" + this.publicationYear + ")";
    }
    
}
