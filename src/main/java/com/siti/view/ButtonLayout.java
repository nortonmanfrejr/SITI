package com.siti.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class ButtonLayout {

    public static VBox buttonBox(){


        //#region Botao de Adicionar
        Button addButton = new Button("Adicionar");
        addButton.setPrefWidth(100);

        //endregion

        //#region Botao de Atualizar
        Button attButton = new Button("Atualizar");
        attButton.setPrefWidth(100);



        //endregion

        //#region Botao de Busca
        Button searchButton = new Button("Buscar");
        searchButton.setPrefWidth(100);
        //endregion

        //#region Botao de Deletar
        Button delButton = new Button("Deletar");
        delButton.setPrefWidth(100);
        //endregion

        //#region Mover Para

        //#region ComboBox Mover Para
        ComboBox<String> moveTo = new ComboBox<>();
        moveTo.setPromptText("Move to...");
        moveTo.getItems().addAll("Ativos","Sucata","Estoque");
        moveTo.setPrefWidth(100);
        //endregion

        //#region Botao de Mover
        Button moveButton = new Button("Mover");
        moveButton.setPrefWidth(100);
        //endregion

        //endregion

        VBox buttonLayout = new VBox(10);
        buttonLayout.setSpacing(5);
        buttonLayout.setPadding(new Insets(5,5,5,5));
        buttonLayout.getChildren().addAll(addButton,attButton,searchButton,delButton,new Separator(),moveTo,moveButton);
        return buttonLayout;
    }
}
