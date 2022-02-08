package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {
    
    @Override
    public void start(Stage window) {
        Label onFirstView = new Label("First view!");
        Button toSecondView = new Button("To the second view!");
        
        BorderPane borderLayout = new BorderPane();
        borderLayout.setTop(onFirstView);
        borderLayout.setCenter(toSecondView);
        
        Label onSecondView = new Label("Second view!");
        Button toThirdView = new Button("To the third view!");
        
        VBox vLayout = new VBox();
        vLayout.setSpacing(20);
        vLayout.getChildren().addAll(toThirdView, onSecondView);
        
        Label onThirdView = new Label("Third view!");
        Button toFirstView = new Button("To the first view!");
        
        GridPane gridLayout = new GridPane();
        gridLayout.add(onThirdView, 0, 0);
        gridLayout.add(toFirstView, 1, 1);
        
        Scene firstView = new Scene(borderLayout);
        Scene secondView = new Scene(vLayout);
        Scene thirdView = new Scene(gridLayout);
        
        toSecondView.setOnAction((event) -> {
            window.setScene(secondView);
        });
        
        toThirdView.setOnAction((event) -> {
            window.setScene(thirdView);
        });
        
        toFirstView.setOnAction((event) -> {
            window.setScene(firstView);
        });
        
        window.setScene(firstView);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
        System.out.println("Hello world!");
    }

}
