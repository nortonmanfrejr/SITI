package com.siti;

import com.siti.connection.ConnectionFactory;
import com.siti.service.Display;
import com.siti.view.Botoes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        window.setTitle("SITI....");
        window.setResizable(false);

        //#region Montagem de layout

        BorderPane bp = new BorderPane();
        bp.setLeft(Botoes.buttons());



        Scene fixedLayout = new Scene(bp, 1000,460);
        //endregion

        //#region Functions called
        window.setOnCloseRequest( e -> {
            e.consume();
            close();
        });
        //endregion

        window.setScene(fixedLayout);
        window.show();
    }


    private void close(){
        Boolean answer = Display.display("Encerrar","Deseja encerrar a aplicação?");
        if (answer)
            window.close();
    }

}