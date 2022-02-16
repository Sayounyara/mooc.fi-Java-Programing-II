package application;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {
    
    @Override
    public void start(Stage stage) {
        // Creating the chart axis
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        // Creating the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        // Creating the map
        Map<String, Map<Integer, Double>> values = new HashMap<>();
        
        // Storing all of the data
        String partySupport = "KOK	16.1	18.1	20.9	22.9	23.0	22.9	19.1	21.6	20.8	21.8	23.4";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "SDP	23.9	27.1	24.8	25.5	24.7	25.2	27.1	24.5	23.0	24.1	21.2";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "KESK	18.9	18.0	18.4	18.7	20.2	21.1	19.2	21.8	23.8	22.8	20.1";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "VIHR	-	-	-	-	2.8	2.3	6.9	6.3	7.7	7.4	8.9";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "VAS	16.9	17.5	18.5	16.6	13.1	12.6	11.7	10.4	9.9	9.6	8.8";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "PS	7.3	5.0	2.1	3.0	5.3	3.6	2.4	0.9	0.7	0.9	5.4";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        partySupport = "RKP	5.6	5.2	4.7	4.7	5.1	5.3	5.0	5.4	5.1	5.2	4.7";
        values.put(partySupport.split("\t")[0], createSupportMap(partySupport.split("\t")));
        
        // Go through the parties and add them to the chart
        values.keySet().stream().forEach(party -> {
            // A different data set for every party
            XYChart.Series data = new XYChart.Series();
            data.setName(party);
            
            // Add teh party's support numbers to the data set
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            
            // Add the data set to the line chart
            lineChart.getData().add(data);
        });
        
        Scene scene = new Scene(lineChart, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    private Map<Integer, Double> createSupportMap(String[] party) {
        Map<Integer, Double> values = new HashMap<>();
        
        for (int i = 1; i < party.length; i++) {
            if (party[i].equals("-")) {
                values.put(1964 + (4 * i), null);
            } else {
                values.put(1964 + (4 * i), Double.valueOf(party[i]));
            }
        }
        
        return values;
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
        System.out.println("Hello world!");
    }

}
