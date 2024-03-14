package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        Values values = new Values();

        values.addObserver(new ConsoleObserver());
        values.addObserver(new GraphicalObserver());

        Button generateButton = new Button("Generate");
        generateButton.setOnAction(event -> {
                double v = Math.random() * 360.0;
                double r = Math.random() * 360.0;

                Calc.init(v, r);
                values.setValue(Calc.getResults());
        });

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
                try {
                    Calc.save();
                    values.setValue(Calc.getResults());
                } catch (Exception e) {
                    System.out.println("Serialization error: " + e);
                }
        });

        Button restoreButton = new Button("Restore");
        restoreButton.setOnAction(event -> {
                try {
                    Calc.restore();
                    values.setValue(Calc.getResults());
                } catch (Exception e) {
                    System.out.println("Serialization error: " + e);
                }
        });

        Label resultLabel = new Label();

        VBox vBox = new VBox(10);
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(generateButton, saveButton, restoreButton, resultLabel);

        Scene scene = new Scene(vBox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}