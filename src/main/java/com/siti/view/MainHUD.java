package com.siti.view;

import com.siti.dao.DMonitor;
import com.siti.model.Monitor;
import com.siti.service.Display;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainHUD {



    static BorderPane bp;
    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);
    public static ComboBox<String> tipo;
    public static ComboBox<String> estado;




    /**
     * Attention to the design of the boxes, as they are separated into levels.
     * @return monitor data hud.
     * */
    public static BorderPane hud(){

        bp = new BorderPane();


        // combo box tipo tem de ser criado dentro do hud para que ocorra o efeito de troca de design da tela.
        tipo = new ComboBox<>();
        tipo.getItems().addAll("Monitor","Computador","Conjunto","Ferramenta");
        tipo.setPrefWidth(100);
        tipo.getSelectionModel().
                selectedItemProperty().
                addListener((options,oldValue,newValue) -> {
                    if(newValue.equals("Monitor")){

                        bp.setCenter(HMonitor.monitor());

                    } else if (newValue.equals("Computador")) {

                        bp.setCenter(HComputer.computer());

                    } else if (newValue.equals("Conjunto")) {
                        Display.confirmDisplay("Create a new couple?", "Create a new couple?");
                    } else if (newValue.equals("Ferramenta")) {
                        Display.confirmDisplay("Armario","Change to armario");
                    } else {
                        Display.confirmDisplay("default","default window");
                    }
                });

        estado = new ComboBox<>();
        estado.getItems().addAll("Ativo","Estoque","Sucata","Manutenção");
        estado.setPrefWidth(100);

        // button boxes
        VBox vbuttons = new VBox(10);
        vbuttons.getChildren().addAll(Buttons.buttonBox(),horizontal,tipo,estado,Buttons.xlsExport());
        HBox hbuttons = new HBox(10);
        hbuttons.setPadding(new Insets(5,0,10,10));
        hbuttons.getChildren().addAll(vbuttons, vertical);



        bp.setLeft(hbuttons);
        return bp;
    }

}
