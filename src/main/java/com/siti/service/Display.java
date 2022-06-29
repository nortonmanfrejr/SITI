package com.siti.service;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Display {


    /***
     *
     * Um display feito para validação de ações. Ex: fechar a aplicação, sera chamado o display pedindo a confirmação
     * @param title Da alert box.
     * @param message a ser passada no Alert Box
     * @return Alert Box de validação
     */

    //#region Display
    static boolean answer;
    public static Boolean validDisplay(String title, String message){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);
        window.setMinHeight(150);
        window.setResizable(false);

        Label lMessage = new Label();
        lMessage.setText(message);

        Button yesButton = new Button("Sim...");
        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });


        Button noButton = new Button("Não...");
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });



        HBox box1 = new HBox(10);
        box1.getChildren().addAll(yesButton, noButton);
        box1.setAlignment(Pos.CENTER);


        VBox box = new VBox(10);
        box.getChildren().addAll(lMessage,box1);
        box.setAlignment(Pos.CENTER);


        Scene sceneLayout = new Scene(box);
        window.setScene(sceneLayout);
        window.showAndWait();

        return answer;
    }

    public static Boolean confirmDisplay(String title, String message){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);
        window.setMinHeight(150);
        window.setResizable(false);

        Label lMessage = new Label();
        lMessage.setText(message);
        lMessage.setAlignment(Pos.CENTER);

        Button okButton = new Button("Ok...");
        okButton.setOnAction(e -> {
            answer = true;
            window.close();
        });


        VBox box = new VBox(10);
        box.getChildren().addAll(lMessage, okButton);
        box.setAlignment(Pos.CENTER);


        Scene sceneLayout = new Scene(box);
        window.setScene(sceneLayout);
        window.showAndWait();

        return answer;

    }

    //endregion
}
