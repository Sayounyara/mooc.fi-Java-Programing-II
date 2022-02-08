package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {
    
    @Override
    public void start(Stage window) {
        Label text = new Label("Enter your name to start.");
        TextField enterName = new TextField();
        Button button = new Button("Start");
        
        GridPane layout = new GridPane();
        layout.add(text, 0, 0);
        layout.add(enterName, 0, 1);
        layout.add(button, 0, 2);
        
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        Label greetingText = new Label();
        StackPane greetingLayout = new StackPane();
        greetingLayout.setPrefSize(300, 180);
        greetingLayout.getChildren().add(greetingText);
        greetingLayout.setAlignment(Pos.CENTER);
        
        Scene enterScene = new Scene(layout);
        Scene greetingScene = new Scene(greetingLayout);
        
        button.setOnAction((event) -> {
            greetingText.setText("Welcome " + enterName.getText() + "!");
            window.setScene(greetingScene);
        });
        
        window.setScene(enterScene);
        window.show();
    }

    public static void main(String[] args) {
        System.out.println("Hellow world! :3");
        launch(GreeterApplication.class);
    }
}
