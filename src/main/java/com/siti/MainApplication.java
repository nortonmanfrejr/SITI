package com.siti;

import com.siti.service.lBox;
import com.siti.service.Display;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {

        window = stage;
        Scene scene = new Scene(new Group(), 450, 250);
        window.setTitle("SITI....");
        window.setResizable(false);

        //#region Montagem de layout
        BorderPane bp = new BorderPane();
        bp.setLeft(lBox.leftBox());



        //endregion

        //#region Functions called
        window.setOnCloseRequest( e -> {
            e.consume();
            close();
        });
        //endregion

        Group root = (Group) scene.getRoot();
        root.getChildren().addAll(bp);
        window.setScene(scene);
        window.show();

    }


    private void close(){
        Boolean answer = Display.display("Encerrar","Deseja encerrar a aplicação?");
        if (answer)
            window.close();
    }

}