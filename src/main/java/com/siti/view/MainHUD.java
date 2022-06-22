package com.siti.view;

import com.siti.service.lBox;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainHUD extends lBox{

    static BorderPane bp;

    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);

    /**
     * Attention to the design of the boxes, as they are separated into levels.
     * @return monitor data hud.
     * */
    public static VBox monitorHud(){

        //#region vb1 layout

        // hb1
        HBox hb1 = new HBox();
        Label l1 = new Label("Patrimonio  ");
        TextField txf1 = new TextField();
        txf1.setPromptText("Patrimonio: C023416");
        hb1.getChildren().addAll(l1, txf1);

        // hb2
        HBox hb2 = new HBox();
        Label l2 = new Label("Service Tag  ");
        TextField txf2 = new TextField();
        txf2.setPromptText("Service Tag: H87Q9R2");
        hb2.getChildren().addAll(l2,txf2);

        // vb1
        VBox vb1 = new VBox();
        vb1.getChildren().addAll(hb1,hb2);

        //endregion

        //#region vb2 layout
        // hb3
        HBox hb3 = new HBox();
        Label l3 = new Label("Marca  ");
        ComboBox<String> cb1 = new ComboBox<>();
        cb1.setEditable(true);
        cb1.setPromptText("Marca : AOC");
        hb1.getChildren().addAll(l3, cb1);

        // hb4
        HBox hb4 = new HBox();
        Label l4 = new Label("Service Tag  ");
        ComboBox<String> cb2 = new ComboBox<>();
        cb2.setEditable(true);
        cb2.setPromptText("Modelo : E943FWSK");
        hb2.getChildren().addAll(l4,cb2);

        // vb2
        VBox vb2 = new VBox();
        vb1.getChildren().addAll(hb3,hb4);
        //endregion

        //#region vb3 layout
        Label l5 = new Label("Observações");
        l5.setPrefWidth(70);
        l5.setPrefHeight(20);
        l5.setPadding(new Insets(0,0,0,60));

        TextArea txa1 = new TextArea();
        txa1.setPromptText("Digite observações aqui...");
        txa1.setPrefWidth(250);
        txa1.setPrefHeight(120);

        VBox vb3 = new VBox();
        vb3.getChildren().addAll(l5,txa1);
        //endregion

        //box n2
        HBox box1 = new HBox();
        box1.getChildren().addAll(vb1,vb2,vb3);

        // box n1
        VBox box = new VBox();
        box.getChildren().addAll(horizontal,box1);

        return box;
    }


    /**
     * The home screen is dynamic and built throug several conditionals, changes occur through functions.
     * @return a dynamic home screen.
     * */
    public static Scene hud(){

        bp = new BorderPane();
        bp.setRight(lBox.leftBox()); // Call Buttons


        Scene scene = new Scene(bp);

        return scene;
    }

}
