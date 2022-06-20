package com.siti.view;

import javafx.css.Stylesheet;
import javafx.geometry.Orientation;
import javafx.geometry.Point3D;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TabsLayout {


    public static TabPane tabPane(){
        TabPane tabpane = new TabPane();

        tabpane.getTabs().addAll(tab1());
        return tabpane;
    }



    //#region Tab de Ativos
    /**
     * Chama a tab de Equipamentos ativos
     * @return A pagina de ativos.
     * */
    private static Tab tab1(){
        // Separator

        Separator vSeparator = new Separator();
        vSeparator.setOrientation(Orientation.VERTICAL);

        //#region def
        /**
         * Definições da pré-definidas da TAB 1
         * */
        Tab tbAtivos = new Tab("Ativos");
        tbAtivos.setClosable(false);
        //endregion

        HBox hb1 = new HBox();
        hb1.getChildren().add(ButtonLayout.buttonBox());

        //#region Box mãe TAB ATIVOS

        // Inserção de layout
        VBox mainBox = new VBox();
        mainBox.getChildren().addAll(hb1, vSeparator, DataLayout.machineData());
        //endregion


        //#region tbAtivos Inserção de Layout
        tbAtivos.setContent(mainBox);
        //endregion

        return tbAtivos;
    }
    //endregion
}
