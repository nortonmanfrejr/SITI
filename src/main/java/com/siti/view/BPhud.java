package com.siti.view;

import com.siti.service.Display;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BPhud{


    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);



    /**
     * @return create data button.
     * */
    private static Button create(){
        Button b = new Button("Create...");
        b.setPrefWidth(100);
        return b;
    }

    /**
     * @return read data button.
     * */
    private static Button read(){
        Button b = new Button("Read...");
        b.setPrefWidth(100);
        return b;
    }
    /**
     * @return update data button.
     * */
    private static Button update(){
        Button b = new Button("Update...");
        b.setPrefWidth(100);
        return b;
    }

    /**
     * @return delete data button.
     * */
    private static Button delete(){
        Button b = new Button("Delete...");
        b.setPrefWidth(100);
        return b;
    }

    /**
     * Attention to the design of the boxes, as they are separated into levels.
     * @return monitor data hud.
     * */
    public static BorderPane hud(){
        BorderPane bp = new BorderPane();

        // combo box tipo tem de ser criado dentro do hud para que ocorra o efeito de troca de design da tela.
        ComboBox<String> tipo = new ComboBox<>();
        tipo.getItems().addAll("Monitor","Computador","Conjunto","Ferramenta");
        tipo.setPrefWidth(100);
        tipo.getSelectionModel().
                selectedItemProperty().
                addListener((options,oldValue,newValue) -> {
                    if(newValue.equals("Monitor")){
                        bp.setCenter(MonitorHUD.monitor());
                        bp.setBottom(MonitorHUD.listas());
                    } else if (newValue.equals("Computador")) {
                      Display.display("Computer not created", "Computer not created");
                    } else if (newValue.equals("Conjunto")) {
                        Display.display("Create a new couple?", "Create a new couple?");
                    } else if (newValue.equals("Ferramenta")) {
                        Display.display("Armario","Change to armario");
                    } else {
                        Display.display("default","default window");
                    }
                });

        ComboBox<String> status = new ComboBox<>();
        status.getItems().addAll("Ativo","Estoque","Sucata","Manutenção");
        status.setPrefWidth(100);

        // button boxes
        VBox vbuttons = new VBox(10);
        vbuttons.getChildren().addAll(create(),read(),update(),delete(),horizontal,tipo,status);
        HBox hbuttons = new HBox(10);
        hbuttons.setPadding(new Insets(5,0,10,10));
        hbuttons.getChildren().addAll(vbuttons, vertical);



        bp.setLeft(hbuttons);
        return bp;
    }


}
