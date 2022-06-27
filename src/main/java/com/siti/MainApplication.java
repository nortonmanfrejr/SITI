package com.siti;

import com.siti.connection.ConnectionFactory;
import com.siti.service.Display;
import com.siti.view.MainHUD;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    /**
     * principal stage of application
     * */
    @Override
    public void start(Stage stage) throws IOException {
        ConnectionFactory.getConnection();
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
        root.getChildren().addAll(MainHUD.hud());
        window.setScene(scene);
        window.show();
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        ConnectionFactory.closeConnection();
    }


    private void close(){
        Boolean answer = Display.display("Encerrar","Deseja encerrar a aplicação?");
        if (answer)
            window.close();
    }

}