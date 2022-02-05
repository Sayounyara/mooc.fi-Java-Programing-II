
import java.util.ArrayList;
import java.util.Random;

public class LotteryRow {

    private ArrayList<Integer> numbers;

    public LotteryRow() {
        // Draw the numbers when the LotteryRow is created
        this.randomizeNumbers();
    }

    public ArrayList<Integer> numbers() {
        return this.numbers;
    }

    public void randomizeNumbers() {
        // Initialize the list for numbers
        this.numbers = new ArrayList<>();
        Random rand = new Random();
        
        
        for (int i = 0; i < 7; i++) {
            int newRoll = rand.nextInt(40) + 1;
            
            while (this.numbers.contains(newRoll)) {
                newRoll = rand.nextInt(40) + 1;
            }
            
            this.numbers.add(newRoll);
        }
        // Implement the random number generation here
        // the method containsNumber is probably useful
    }

    public boolean containsNumber(int number) {
        return this.numbers.contains(number);
    }
}

