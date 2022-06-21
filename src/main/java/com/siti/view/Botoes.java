package com.siti.view;

import com.siti.model.Equipamento;
import com.siti.service.Display;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Botoes {

    /**
     * Uma HBox prédefinida para ser instanciada em qualquer canto da tela, caso deseje fazer alterações.
     * @return HBox com os botões prédefinidos.
     * */
    public static HBox buttons(){

        //#region Botão de adicionar
        Button addButton = new Button("Adicionar");


        //#region Definições de Design do botão.
        addButton.setPrefWidth(90);
        addButton.setPrefHeight(25);
        addButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        addButton.setOnAction(e -> System.out.println("Botão Funcional"));
        //endregion

        //endregion


        //#region Botão de Atualizar
        Button attButton = new Button("Atualizar");


        //#region Definições de Design do botão.
        attButton.setPrefWidth(90);
        attButton.setPrefHeight(25);
        attButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        attButton.setOnAction(e -> System.out.println("Botão Funcional"));
        //endregion
        //endregion


        //#region Botão de Buscar
        Button seaButton = new Button("Buscar");

        //#region Definições de Design do botão.
        seaButton.setPrefWidth(90);
        seaButton.setPrefHeight(25);
        seaButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        seaButton.setOnAction(e -> System.out.println("Botão Funcional"));
        //endregion

        //endregion


        //#region Botão de Deletar
        Button delButton = new Button("Deletar");


        //#region Definições de Design do botão.
        delButton.setPrefWidth(90);
        delButton.setPrefHeight(25);
        delButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        delButton.setOnAction(e -> System.out.println("Botão Funcional"));
        //endregion

        //endregion


        //#region Combo Box Tipo de Item
        ComboBox<String> cbTipo = new ComboBox<>();

        //#region Definições de Design do Combo Box
        cbTipo.setPromptText("Tipo");
        cbTipo.setPrefWidth(90);
        cbTipo.setPrefHeight(25);
        cbTipo.setPadding(new Insets(0,0,0,10));
        //endregion
        cbTipo.getItems().addAll("Notebook","Desktop","Monitor","Ferramenta");


        //#region Combo Box funções


        //endregion

        //endregion


        //#region Combo Box Adicionar ou Mover
        ComboBox<String> cbMove = new ComboBox<>();

        //#region Definições de Design do Combo Box
        cbMove.setPromptText("Adicionar em");
        cbMove.setPrefWidth(90);
        cbMove.setPrefHeight(25);
        cbMove.setPadding(new Insets(0,0,0,10));
        //endregion

        cbMove.getItems().addAll("Ativos","Sucata","Estoque");

        //#region Combo Box funções


        //endregion

        //endregion


        //#region Botão de Mover

        Button moveButton = new Button("Mover");


        //#region Definições de Design do botão.
        moveButton.setPrefWidth(90);
        moveButton.setPrefHeight(25);
        moveButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        moveButton.setOnAction(e -> System.out.println("Botão Funcional"));
        //endregion

        //endregion


        //#region Gerador de XLS

        Button xlsButton = new Button("Gerar XLS");


        //#region Definições de Design do botão.
        xlsButton.setPrefWidth(90);
        xlsButton.setPrefHeight(25);
        xlsButton.setPadding(new Insets(0,0,0,0));
        //endregion

        //#region Funções
        xlsButton.setOnAction( e -> {
            System.out.println("Botão Funcional");
        });
        //endregion

        //endregion


        //#region BOXS
        VBox b1 = new VBox(10);
        b1.setPrefWidth(120);
        b1.setPrefHeight(285);
        b1.setPadding(new Insets(10,10,0,10));
        b1.getChildren().addAll(addButton,attButton,seaButton,delButton, new Separator(),cbTipo,cbMove,moveButton,xlsButton);

        HBox b2 = new HBox();
        b2.setPrefWidth(120);
        b2.setPrefHeight(285);
        b2.getChildren().addAll(b1,new Separator(Orientation.VERTICAL));
        //endregion

        return b2;
    }


}
