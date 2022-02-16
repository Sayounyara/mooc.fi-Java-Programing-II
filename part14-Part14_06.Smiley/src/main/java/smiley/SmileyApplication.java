package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        
        BorderPane layout = new BorderPane();
        layout.setCenter(canvas);
        
        // Draws the left eye
        graphics.fillRect(100, 50, 50, 50);
        // Draws the right eye
        graphics.fillRect(250, 50, 50, 50);
        
        // Draws the mouth (Left to Right)
        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(100, 250, 50, 50);
        graphics.fillRect(150, 250, 50, 50);
        graphics.fillRect(200, 250, 50, 50);
        graphics.fillRect(250, 250, 50, 50);
        graphics.fillRect(300, 200, 50, 50);
        
        Scene scene = new Scene(layout);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
        System.out.println("Hello world!");
    }

}
