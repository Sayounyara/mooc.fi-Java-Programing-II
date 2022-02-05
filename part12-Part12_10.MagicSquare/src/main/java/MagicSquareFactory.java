
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        int row = size / 2;
        int col = 0;
        
        square.placeValue(row, col, 1);
        for (int i = 2; i <= size * size; i++) {
            int curRow = row;
            int curCol = col;
            row++;
            col--;
            if (row >= size) {
                row = 0;
            }
            if (col <= -1) {
                col = size - 1;
            }
            
            if (square.readValue(row, col) != 0) {
                row = curRow;
                col = curCol + 1;
            }
            
            square.placeValue(row, col, i);
        }
        
        return square;
    }

}
