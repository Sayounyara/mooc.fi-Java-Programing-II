
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<>();
        
        while (true) {
            System.out.println("Input numbers, type \"end\" to stop.");
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            
            values.add(Integer.valueOf(input));
        }
        
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String slct = scanner.nextLine();
        if (slct.equals("n")) {
            System.out.println("Average of the negative numbers: " 
                + values.stream().mapToInt(i -> i).filter(selection -> selection < 0).average().getAsDouble());
        } else {
            System.out.println("Average of the positive numbers: " 
                + values.stream().mapToInt(i -> i).filter(selection -> selection > 0).average().getAsDouble());
        }

    }
}
