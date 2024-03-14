package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.*;

import static javafx.application.Application.launch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Values values = new Values();

//        values.addObserver(new ConsoleObserver());
//        values.addObserver(new GraphicalObserver(primaryStage));
//        double v = Math.random() * 360.0;
//        double r = Math.random() * 360.0;
//
//        Calc.init(Math.random() * 360.0, Math.random() * 360.0);
//        Calc.init(Math.random() * 360.0, Math.random() * 360.0);
//        Calc.init(Math.random() * 360.0, Math.random() * 360.0);
//        values.setValue(Calc.getResults());
//        Calc.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}