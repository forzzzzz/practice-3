package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

import static javafx.application.Application.launch;

public class ConsoleObserver implements Observer {
    private final ListView<String> listView;
    public ConsoleObserver() {
        Stage stage = new Stage();
        VBox root = new VBox();
        listView = new ListView<>();
        root.getChildren().add(listView);

        Scene scene = new Scene(root, 300, 350);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void handleEvent(List<Item2d> results) {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Item2d result : results) {
            items.add(result.toString());
        }
        listView.setItems(items);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
