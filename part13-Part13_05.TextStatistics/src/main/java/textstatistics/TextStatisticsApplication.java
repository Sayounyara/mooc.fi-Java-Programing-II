package textstatistics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {
    
    @Override
    public void start(Stage window) {
        HBox textComponents = new HBox();
        textComponents.getChildren().add(new Label("Letters: 0"));
        textComponents.getChildren().add(new Label("Words: 0"));
        textComponents.getChildren().add(new Label("The longest word is:"));
        
        BorderPane layout = new BorderPane();
        layout.setCenter(new TextArea());
        layout.setBottom(textComponents);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Hello world!");
    }

}
