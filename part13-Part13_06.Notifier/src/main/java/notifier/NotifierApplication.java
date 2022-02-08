package notifier;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {
    
    @Override
    public void start(Stage window) {
        TextField text = new TextField();
        Label label = new Label();
        Button button = new Button("Update");
        
        button.setOnAction((event) -> {
            label.setText(text.getText());
        });
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(text, button, label);
        
        Scene scene = new Scene(vbox);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
        System.out.println("Hello world!");
    }

}
