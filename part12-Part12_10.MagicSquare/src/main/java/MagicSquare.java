
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int row = 0; row < this.square.length; row++) {
            int sum = 0;
            for (int col = 0; col < this.square.length; col++) {
                int old = sum;
                sum += this.square[row][col];
                System.out.println(old + " + " + square[row][col] + " = " + sum);
            }
            numbers.add(sum);
        }
        
        return numbers;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        for (int row = 0; row < square.length; row++) {
            int sum = 0;
            for (int col = 0; col < square.length; col++) {
                sum += this.square[col][row];
            }
            numbers.add(sum);
        }
        
        return numbers;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> numbers = new ArrayList<>();
        
        int sumOfDiagonalLeftRight = 0;
        int sumOfDiagonalRightLeft = 0;
        
        for (int row = 0; row < square.length; row++) { // need (0, 0), (1, 1), (2, 2), (0, 2), (2, 0)
            for (int col = 0; col < square.length; col++) {
                if (row == col) {
                    sumOfDiagonalLeftRight += square[row][col];
                }
                
                boolean isTwo = (row + col) == square.length - 1;
                if (isTwo) {
                    sumOfDiagonalRightLeft += square[row][col];
                }
            }
        }
        
        numbers.add(sumOfDiagonalLeftRight);
        numbers.add(sumOfDiagonalRightLeft);
        
        return numbers;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
