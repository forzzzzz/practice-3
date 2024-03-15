package org.example;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;

public class GraphicalObserver implements Observer {
    private final LineChart<Number, Number> lineChart;

    public GraphicalObserver() {
        Stage stage = new Stage();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("R");
        yAxis.setLabel("V");

        lineChart = new LineChart<>(xAxis, yAxis);

        Scene scene = new Scene(lineChart, 800, 600);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handleEvent(List<Item2d> results) {
        lineChart.getData().clear();
        XYChart.Series<Number, Number> series = new XYChart.Series<>();

        if (results != null) {
            for (Item2d result : results) {
                series.getData().add(new XYChart.Data<>(result.getR(), result.getV()));
            }
            lineChart.getData().add(series);
        }
    }
}

