package textstatistics;

import java.util.Arrays;
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
        Label letterCount = new Label("Letters: 0");
        Label wordCount = new Label("Words: 0");
        Label longestWord = new Label("The longest word is: ");
        
        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.getChildren().add(letterCount);
        hbox.getChildren().add(wordCount);
        hbox.getChildren().add(longestWord);
        
        TextArea text = new TextArea();
        
        text.textProperty().addListener((change, oldValue, newValue) -> {
            int letters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                .sorted((s1, s2) -> s2.length() - s1.length())
                .findFirst()
                .get();
            
            letterCount.setText("Letters: " + letters);
            wordCount.setText("Words: " + words);
            longestWord.setText("The longest word is: " + longest);
        });
        
        BorderPane layout = new BorderPane();
        layout.setCenter(text);
        layout.setBottom(hbox);
        
        Scene scene = new Scene(layout);
        
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
        System.out.println("Build Closed.");
    }

}
