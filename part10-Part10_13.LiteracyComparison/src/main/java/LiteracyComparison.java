
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class LiteracyComparison {
    
    public static void main(String[] args) {
        ArrayList<Literacy> rows = new ArrayList<>();
        
        try {
            Files.lines(Paths.get("literacy.csv"))
                 .map(row -> row.split(","))
                 .forEach(row -> rows.add(new Literacy(row[2], row[3], Integer.valueOf(row[4]), Double.valueOf(row[5]))));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        rows.stream().sorted().forEach(s -> System.out.println(s));
        
    }
}
