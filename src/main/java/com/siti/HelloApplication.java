package com.siti;

import com.siti.view.ButtonLayout;
import com.siti.view.TabsLayout;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        VBox mainWindow = new VBox();
        mainWindow.getChildren().add(TabsLayout.tabPane());
        Scene scene = new Scene(mainWindow);
        stage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}