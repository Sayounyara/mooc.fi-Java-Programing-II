package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {
        
    boolean isTurnX = true;
    boolean gameWon = false;
    int turnCount = 0;
    
    @Override
    public void start(Stage view) {
        BorderPane layout = new BorderPane();
        
        // Creating TicTacToe Board
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        
        // Array time
        Button[][] boardSpaces = new Button[3][3];
        
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boardSpaces[row][col] = createSpace();
                board.add(boardSpaces[row][col], row, col);
            }
        }
        
        // Sets the gaps of the game board
        board.setHgap(10);
        board.setVgap(10);
        
        // Just extra stuff for the main layout thing
        Label turn = new Label("Turn: X");
        turn.setFont(Font.font("Monospaced", 40));
        layout.setTop(turn);
        layout.setCenter(board);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // ALL the actions
        /*
        **!##
        **### (0, 0)
        **###
        */
        boardSpaces[0][0].setOnAction((event) -> {
            System.out.println(turnCount);
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[0][0].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[0][0].setText("X");
            } else {
                boardSpaces[0][0].setText("O");
            }
                
            // This tile can win with (0, 1) and (0, 2) || (1, 1) and (2, 2) || (1, 0) and (2, 0)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 0, 0, 0, 1, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 0, 1, 1, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 0, 1, 0, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if O has won yet
                if (wonWith(boardSpaces, 0, 0, 0, 1, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 0, 1, 1, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 0, 1, 0, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **!## (0, 1)
        **###
        */
        boardSpaces[0][1].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[0][1].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[0][1].setText("X");
            } else {
                boardSpaces[0][1].setText("O");
            }
                
            // This tile can win with (0, 0) and (0, 2) || (1, 1) and (2, 1)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 0, 1, 0, 0, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 1, 1, 1, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 0, 1, 0, 0, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 1, 1, 1, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if O, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **### (0, 2)
        **!##
        */
        boardSpaces[0][2].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[0][2].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[0][2].setText("X");
            } else {
                boardSpaces[0][2].setText("O");
            }
            
            // This tile can win with (0, 0) and (0, 1) || (1, 1) and (2, 0) || (1, 2) and (2, 2)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 0, 2, 0, 0, 0, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 2, 1, 1, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 2, 1, 2, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 0, 2, 0, 0, 0, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 2, 1, 1, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 0, 2, 1, 2, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **#!#
        **### (1, 0)
        **###
        */
        boardSpaces[1][0].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[1][0].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[1][0].setText("X");
            } else {
                boardSpaces[1][0].setText("O");
            }
                
            // This tile can win with (0, 0) and (2, 0) || (1, 1) and (1, 2)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 1, 0, 0, 0, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 0, 1, 1, 1, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 1, 0, 0, 0, 2, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 0, 1, 1, 1, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **#!# (1, 1)
        **###
        */
        boardSpaces[1][1].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[1][1].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[1][1].setText("X");
            } else {
                boardSpaces[1][1].setText("O");
            }
                
            // This tile can win with (0, 1) and (2, 1) || (0, 0) and (2, 2) || (1, 0) and (1, 2) || (2, 0) and (0, 2)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 1, 1, 0, 1, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 0, 0, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 1, 0, 1, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 2, 0, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 1, 1, 0, 1, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 0, 0, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 1, 0, 1, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 1, 2, 0, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **### (1, 2)
        **#!#
        */
        boardSpaces[1][2].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[1][2].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[1][2].setText("X");
            } else {
                boardSpaces[1][2].setText("O");
            }
                
            // This tile can win with (0, 2) and (2, 2) || (1, 0) and (1, 1)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 1, 2, 0, 2, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 2, 1, 0, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 1, 2, 0, 2, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 1, 2, 1, 0, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **##!
        **### (2, 0)
        **###
        */
        boardSpaces[2][0].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[2][0].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[2][0].setText("X");
            } else {
                boardSpaces[2][0].setText("O");
            }
                
            // This tile can win with (0, 0) and (1, 0) || (1, 1) and (0, 2) || (2, 1) and (2, 2)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 2, 0, 0, 0, 1, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 0, 1, 1, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 0, 2, 1, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 2, 0, 0, 0, 1, 0)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 0, 1, 1, 0, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 0, 2, 1, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **##! (2,1)
        **###
        */
        boardSpaces[2][1].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[2][1].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[2][1].setText("X");
            } else {
                boardSpaces[2][1].setText("O");
            }
                
            // This tile can win with (0, 1) and (1, 1) || (2, 0) and (2, 2)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 2, 1, 0, 1, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 1, 2, 0, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 2, 1, 0, 1, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 1, 2, 0, 2, 2)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        /*
        **###
        **### (2, 2)
        **##!
        */
        boardSpaces[2][2].setOnAction((event) -> {
            // Check if all tiles are covered (in theory) or if someone has already won
            if (turnCount == 9 || gameWon) {
                return;
            }
            
            // Check if the space has already been used
            if (!boardSpaces[2][2].getText().equals(" ")) {
                return;
            }
            
            // If passed both those statement, the current players token is typed into the slot
            if (isTurnX) {
                boardSpaces[2][2].setText("X");
            } else {
                boardSpaces[2][2].setText("O");
            }
                
            // This tile can win with (2, 0) and (2, 1) || (0, 0) and (1, 1) || (2, 0) and (2, 1)
            if (isTurnX) { // Checks to see if X has won yet
                if (wonWith(boardSpaces, 2, 2, 2, 0, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 2, 0, 0, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 2, 2, 0, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            } else { // Checks to see if 0 has won yet
                if (wonWith(boardSpaces, 2, 2, 2, 0, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 2, 0, 0, 1, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                } else if (wonWith(boardSpaces, 2, 2, 2, 0, 2, 1)) {
                    turn.setText("The end!");
                    this.gameWon = true;
                    return;
                }
            }
            
            // Adds a turn to the counter
            if (isTurnX) { // Changes the current player to X if 0, and vice versa
                this.isTurnX = false;
                turn.setText("Turn: O");
            } else {
                this.isTurnX = true;
                turn.setText("Turn: X");
            }
            this.turnCount++;
            if (turnCount == 9) { // Checks if all spaces are (theoretically) full
                turn.setText("The end!");
            }
        });
        
        // Setting the layout in the scene
        Scene scene = new Scene(layout);
        
        // Final Init to set title, scene, and showing the window
        view.setTitle("Tic-tac-toe");
        view.setScene(scene);
        view.show();
    }
    
    private Button createSpace() {
        Button button = new Button(" ");
        button.setFont(Font.font("Monospaced", 40));
        return button;
    }
    
    private boolean wonWith(Button[][] spaces, int selfX, int selfY, int x, int y, int secX, int secY) {
        String self = spaces[selfX][selfY].getText();
        boolean first = spaces[x][y].getText().equals(self);
        boolean second = spaces[secX][secY].getText().equals(self);
        
        return first == true && second == true;
    }

    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
        System.out.println("Hello world!");
    }

}
