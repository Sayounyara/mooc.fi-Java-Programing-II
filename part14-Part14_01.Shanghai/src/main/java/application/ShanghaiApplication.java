package application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        // Creating the chart axis
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        // Set the names of the axis
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        // Creating the line chart
        LineChart<Number, Number> lineChart = new LineChart(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        // Creating the map of variables
        Map<Integer, Integer> values = new HashMap<>();
        
        // An attempt at converting raw data into something the code can read
        int[] rawData = {2007, 73, 2008, 68, 2009, 72, 2010, 72, 2011, 74, 2012, 73, 2013, 76, 2014, 73, 2015, 67, 2016, 56, 2017, 56};
        int inHolding = 0;
        for (int i = 0; i < rawData.length; i++) {
            if (i % 2 == 0) {
                inHolding = rawData[i];
            } else {
                values.put(inHolding, rawData[i]);
                System.out.println(values);
            }
        }
        
        // Making the data chart
        XYChart.Series data = new XYChart.Series();
        
        // Adding the data to the line chart
        values.keySet().stream().forEach(year -> {
            // Adding data to the chart
            data.getData().add(new XYChart.Data(year, values.get(year)));
            
        });
        
        // Adding the xy chart to the line chart
        lineChart.getData().add(data);
        
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
        System.out.println("Hello world!");
    }

}
