
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int total = 0;
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == 0) {
                break;
            }
            if (input < 0) {
                continue;
            }
            
            sum += input;
            total++;
        }
        
        if (total == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            double avg = 1.0 * sum / total;
            System.out.println(avg);
        }
    }
}
