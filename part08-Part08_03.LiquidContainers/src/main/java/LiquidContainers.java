
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int first = 0;
        int second = 0;
        while (true) {
            System.out.println("First: " + first + "/100");
            System.out.println("Second: " + second + "/100");
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] parts = input.split(" ");
            String command = parts[0];
            int number = Integer.valueOf(parts[1]);
            
            if (number < 0) {
                System.out.println();
                continue;
            }
            
            if (command.equals("add")) {
                if (first + number > 100) {
                    first = 100;
                    System.out.println();
                    continue;
                }
                first += number;
            }
            if (command.equals("move")) {
                if (first < number) {
                    second += first;
                    first = 0;
                    if (second > 100) {
                        second = 100;
                    }
                    System.out.println();
                    continue;
                }
                first -= number;
                second += number;
                if (second > 100) {
                    second = 100;
                }
            }
            if (command.equals("remove")) {
                if (second < number) {
                    second = 0;
                    System.out.println();
                    continue;
                }
                second -= number;
            }

            System.out.println();
        }
    }

}
