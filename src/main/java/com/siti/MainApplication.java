package com.siti;

import com.siti.service.Display;
import com.siti.view.BPhud;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;
        Scene scene = new Scene(new Group(), 1280, 600);
        window.setTitle("SITI....");
        window.setResizable(false);

        //#region Functions called
        window.setOnCloseRequest( e -> {
            e.consume();
            close();
        });
        //endregion

        Group root = (Group) scene.getRoot();
        root.getChildren().addAll(BPhud.hud());
        window.setScene(scene);
        window.show();
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
    }


    private void close(){
        Boolean answer = Display.display("Encerrar","Deseja encerrar a aplicação?");
        if (answer)
            window.close();
    }

}