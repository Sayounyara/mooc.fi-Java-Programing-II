
public class Literacy implements Comparable<Literacy> {
    
    private String country;
    private int year;
    private String gender;
    private double percent;
    
    public Literacy(String g, String c, int y, double p) {
        String[] actualG = g.split(" ");
        
        this.country = c;
        this.year = y;
        this.gender = actualG[1];
        this.percent = p;
    }
    
    public double getRate() {
        return this.percent;
    }
    
    @Override
    public String toString() {
        return this.country + " (" + this.year + "), " + this.gender + ", " + this.percent;
    }
    
    @Override
    public int compareTo(Literacy l) {
        return Double.compare(this.percent, l.getRate());
    }
    
}
