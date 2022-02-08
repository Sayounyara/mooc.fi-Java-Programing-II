package title;

import java.util.Scanner;
import javafx.application.Application;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("OK desu ka?");
        String title = "--title=" + scanner.nextLine();
        
        Application.launch(UserTitle.class,
            title);
        System.out.println("Hello world!");

    }

}
