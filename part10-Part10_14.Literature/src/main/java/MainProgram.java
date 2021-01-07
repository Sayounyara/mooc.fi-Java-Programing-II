
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        List<Book> books = new ArrayList<>();
        
        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String inpName = scanner.nextLine();
            if (inpName.isEmpty()) { break; }
            System.out.print("Input the age recommendation: ");
            int inpAge = Integer.valueOf(scanner.nextLine());
            
            books.add(new Book(inpName, inpAge));
            
            System.out.println();
        }
        
        System.out.println();
        if (books.size() == 1) {
            System.out.println("1 book in total.");
        } else {
            System.out.println(books.size() + " books in total.");
        }
        System.out.println();
        
        Comparator<Book> comparator = Comparator
                                   .comparing(Book::getAge)
                                   .thenComparing(Book::getName);
        
        Collections.sort(books, comparator);
        
        books.stream().forEach(b -> System.out.println(b));
        
    }

}
