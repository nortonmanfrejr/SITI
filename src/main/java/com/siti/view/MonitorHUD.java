package com.siti.view;

import com.siti.model.Monitor;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class MonitorHUD extends Monitor{


    //#region Constructor Monitor HUD
    public MonitorHUD(Integer id,
                      String patrimonio,
                      String serviceTag,
                      String marca,
                      String modelo,
                      String andar,
                      String departamento,
                      String setor,
                      String status) {
        super(id, patrimonio, serviceTag, marca, modelo, andar, departamento, setor, status);
    }
    //endregion


    /**
     * @return HUD de dados dos monitores
     * */
    public static VBox hud(){

        //#region BOX N4

        //#region B1N4 - B2N4

        HBox b1n4 = new HBox(2);
        Label lPatrimonio = new Label("Patrimonio ");
        TextField tfPatrimonio = new TextField();
        tfPatrimonio.setPromptText("C023416");


        HBox b2n4 = new HBox(2);
        Label lServiceTag = new Label("Service Tag");
        TextField tfServiceTag = new TextField();
        tfServiceTag.setPromptText("H87Q9R2");
        //endregion



        //endregion


        //#region BOX N3

        //#region v1
        VBox v1 = new VBox();

        v1.getChildren().addAll(b1n4,b2n4);
        v1.setPrefWidth(200);
        v1.setPrefHeight(200);
        //endregion


        //#region v2
        VBox v2 = new VBox();
        Label lMarca = new Label("Marca   ");
        ComboBox<String> cbMarca = new ComboBox<>();

        //#region Configs
        cbMarca.setEditable(true);
        cbMarca.setPromptText("Marca");
        cbMarca.setPrefHeight(25);
        cbMarca.setPrefWidth(145);
        cbMarca.setPadding(new Insets(5,5,5,5));
        //endregion

        cbMarca.getItems().addAll("AOC","DELL");

        //endregion

        //endregion


        //#region BOX N2
        /**
         * Box N2 -> Caixa intermediaria do HUD, onde se é encaixado as Box N3.
         * */
        HBox h1 = new HBox();
        h1.getChildren().addAll(v1,v2,v3,v4);
        //endregion


        //#region BOX N1
        /**
         * Box N1 -> Caixa principal do HUD.
         * */
        VBox b = new VBox();
        b.getChildren().addAll(new Separator(),h1);
        b.setPrefHeight(150);
        b.setPrefWidth(600);
        //endregion

        return b;
    }
}
