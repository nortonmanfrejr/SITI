package com.siti.view;

import com.siti.model.Equipamento;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class DataLayout {


    //#region Campo de dados para Maquinas, Notebooks e Monitores

    /**
     * Função utilizada para criar os campos de inserção de dados de Monitores, Desktops e Notebooks.
     * @return Campos de inserção de dados
     * */

    public static ComboBox<String> cbMarca;
    public static ComboBox<String> cbModelo;
    public static HBox machineData(){

        //#region Identificadores
        /**
         * Nesta area é onde esta montado os Campos Patrimonio, Monitor1, Monitor2 e Nº Serie.
         * */

        //#region Patrimonio
        HBox cPatrimonio = new HBox();

        Label lPatrimonio = new Label("Patrimonio   ");
        lPatrimonio.setPadding(new Insets(4,0,0,5));

        //#region Campo de texto
        TextField tPatrimonio = new TextField();
        tPatrimonio.setPadding(new Insets(5,5,5,5));
        tPatrimonio.setPrefWidth(160);
        tPatrimonio.setPrefHeight(15);
        tPatrimonio.setPromptText("C023441");
        //endregion

        cPatrimonio.getChildren().addAll(lPatrimonio,tPatrimonio);
        //endregion

        //#region Monitor 1
        HBox cMonitor1 = new HBox();

        Label lMonitor1 = new Label("Monitor 1   ");
        lMonitor1.setPadding(new Insets(4,5,5,5));

        //#region Campo de texto
        TextField tMonitor1 = new TextField();
        tMonitor1.setPadding(new Insets(5,5,5,5));
        tMonitor1.setPrefWidth(160);
        tMonitor1.setPrefHeight(15);
        tMonitor1.setPromptText("M019555");
        //endregion

        cMonitor1.getChildren().addAll(lMonitor1, tMonitor1);
        //endregion

        //#region Monitor 2
        HBox cMonitor2 = new HBox();

        Label lMonitor2 = new Label("Monitor 2   ");
        lMonitor2.setPadding(new Insets(4,5,5,5));

        //#region Campo de texto
        TextField tMonitor2 = new TextField();
        tMonitor2.setPadding(new Insets(5,5,5,5));
        tMonitor2.setPrefWidth(160);
        tMonitor2.setPrefHeight(15);
        tMonitor2.setPromptText("Empty");
        //endregion

        cMonitor2.getChildren().addAll(lMonitor2, tMonitor2);
        //endregion

        //#region Numero de Série
        HBox cSerial = new HBox();

        Label lSerial = new Label("Service Tag  ");
        lSerial.setPadding(new Insets(4,5,5,0));

        //#region Campo de texto
        TextField tSerial = new TextField();
        tSerial.setPadding(new Insets(5,5,5,0));
        tSerial.setPrefWidth(160);
        tSerial.setPrefHeight(15);
        tSerial.setPromptText("H87Q9R2");
        //endregion

        cSerial.getChildren().addAll(lSerial, tSerial);
        //endregion

        VBox vBox1 = new VBox();
        vBox1.setSpacing(5);
        vBox1.getChildren().addAll(cPatrimonio,cMonitor1,cMonitor2,cSerial); // Adicionar os campos de Identificação aqui.

        //endregion

        //#region Modelo Maquina e Localização
        /**
         * Nesta area é onde esta montado os Campos Marca, Modelo,Tipo, Andar, Departamento e Setor.
         * Sendo o Andar um campo que filtra os Departamentos e Setores.
         * */

        //#region Marca
        HBox cBox1 = new HBox();

        Label lMarca = new Label("Marca  ");
        lMarca.setPadding(new Insets(4,10.5,0,5));

        //#region Combo Box marca
        cbMarca = new ComboBox<>();
        cbMarca.setEditable(true);
        cbMarca.setPrefWidth(120);
        //endregion
        cbMarca.getItems().addAll("Dell","Apple","HP");

        cBox1.getChildren().addAll(lMarca,cbMarca);
        //endregion

        //#region Modelo
        HBox cBox2 = new HBox();

        Label lModelo = new Label("Modelo   ");
        lModelo.setPadding(new Insets(4,0,0,5));


        //#region Combo Box Modelo
        cbModelo = new ComboBox<>();
        cbModelo.setEditable(true);
        cbModelo.setPrefWidth(120);
        //endregion
        cbModelo.getItems().addAll("Optiplex 3050","Optiplex 990","Optiplex 390");

        cBox2.getChildren().addAll(lModelo,cbModelo);
        //endregion

        //#region Andar e Tipo
        HBox cBox3 = new HBox();

        //#region Andar
        ComboBox<String> cbAndar = new ComboBox<>();
        cbAndar.getItems().addAll("3SS","TB","TA","3","4","5","6","7","8","9","12","13");
        cbAndar.setPromptText("Andar");
        cbAndar.setPrefWidth(75);
        //endregion

        //#region Tipo de Equipamento
        ComboBox<String> cbTipo = new ComboBox<>();
        cbTipo.getItems().addAll("Computador","Notebook","Monitor");
        cbTipo.setPromptText("Tipo");
        cbTipo.setPrefWidth(90);
        //endregion

        cBox3.setPadding(new Insets(4,0,0,5));
        cBox3.setSpacing(5);
        cBox3.getChildren().addAll(cbAndar,cbTipo);
        //endregion

        //#region Departamento e Setor
        HBox cBox4 = new HBox();

        //#region Departamento
        ComboBox<String> cDepart = new ComboBox<>();
        cDepart.setPromptText("Departamento");
        cDepart.setPrefWidth(90);
        //endregion
        //#region Setor
        ComboBox<String> cSetor = new ComboBox<>();
        cSetor.setPromptText("Setor");
        cSetor.setPrefWidth(75);
        //endregion

        cBox4.setSpacing(5);
        cBox4.setPadding(new Insets(4,0,0,5));
        cBox4.getChildren().addAll(cDepart,cSetor);
        //endregion
        VBox vBox2 = new VBox();
        vBox2.setSpacing(5);
        vBox2.getChildren().addAll(cBox1,cBox2,cBox3,cBox4);

        //endregion

        //#region HBox mãe atributos e Layout
        HBox dataLayout = new HBox();
        dataLayout.getChildren().addAll(vBox1,vBox2); // Adicionar as VBox aqui
        dataLayout.setPrefWidth(500);
        dataLayout.setPrefHeight(200);
        //endregion
        return dataLayout;
    }
    //endregion


}
