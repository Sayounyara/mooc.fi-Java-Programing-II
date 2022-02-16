package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        // Making the main layout
        BorderPane layout = new BorderPane();
        
        LineChart<Number, Number> lineChart = createLineChart();
        lineChart.setLegendVisible(false);
        lineChart.setAnimated(false);
        
        // Making the top vbox
        VBox sliderLayout = new VBox();
        
        // Making the first slider
        BorderPane savingsLayout = new BorderPane();
        Label savingsLabel = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        Label savingsMagnify = new Label(savingsSlider.getValue() + "");
        
        // Setting the slider up
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        
        // Setting the savings slider into the layout
        savingsLayout.setLeft(savingsLabel);
        savingsLayout.setCenter(savingsSlider);
        savingsLayout.setRight(savingsMagnify);
        
        // Making the second slider
        BorderPane interestLayout = new BorderPane();
        Label interestLabel = new Label("Yearly interest rate");
        Slider interestSlider = new Slider(0, 10, 0);
        Label interestMagnify = new Label(interestSlider.getValue() + "");
        
        // Setting the slider up
        interestSlider.setMajorTickUnit(1);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        
        // Setting the interest slider into the layout
        interestLayout.setLeft(interestLabel);
        interestLayout.setCenter(interestSlider);
        interestLayout.setRight(interestMagnify);
        
        // Setting up the vbox
        sliderLayout.setAlignment(Pos.CENTER);
        sliderLayout.setSpacing(20);
        sliderLayout.getChildren().addAll(savingsLayout, interestLayout);
        sliderLayout.setPadding(new Insets(10, 10, 10, 10));
        
        // Setting up the final layout
        layout.setTop(sliderLayout);
        layout.setCenter(lineChart);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        // Test
        lineChart.getData().add(sumMonthlySavings(savingsSlider.getValue()));
        lineChart.getData().add(sumMonthlySavingsWithInterest(100.0, 0.0));
        
        
        // Adding listening events to the sliders
        savingsSlider.valueProperty().addListener((event) -> {
            savingsMagnify.setText(savingsSlider.getValue() + "");
            lineChart.getData().set(0, sumMonthlySavings(savingsSlider.getValue()));
            lineChart.getData().set(1, sumMonthlySavingsWithInterest(savingsSlider.getValue(), interestSlider.getValue()));
        });
        interestSlider.valueProperty().addListener((event) -> {
            interestMagnify.setText(interestSlider.getValue() + "");
            lineChart.getData().set(0, sumMonthlySavings(savingsSlider.getValue()));
            lineChart.getData().set(1, sumMonthlySavingsWithInterest(savingsSlider.getValue(), interestSlider.getValue()));
        });
        
        Scene scene = new Scene(layout, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public LineChart<Number, Number> createLineChart() {
        // Making the basis of the line chart
        NumberAxis xAxis = new NumberAxis(0, 30, 0.2);
        NumberAxis yAxis = new NumberAxis();
        
        LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("Savings Counter");
        
        return lineChart;
    }
    
    public XYChart.Series sumMonthlySavings(double monthlySavings) {
        XYChart.Series data = new XYChart.Series();
        for (int i = 0; i <= 30; i++) {
            data.getData().add(new XYChart.Data(i, monthlySavings * (i * 12)));
        }
        return data;
    }
    
    public XYChart.Series sumMonthlySavingsWithInterest(double monthlySavings, double interestRate) {
        XYChart.Series data = new XYChart.Series();
        double totalBalance = 0;
        data.getData().add(new XYChart.Data(0, totalBalance));
        for (int i = 1; i <= 30; i++) {
            totalBalance += monthlySavings * 12 ;
            totalBalance *= (100.0 + interestRate) / 100.0;
            data.getData().add(new XYChart.Data(i, totalBalance));
        }
        return data;
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
        System.out.println("Hello world!");
    }

}
