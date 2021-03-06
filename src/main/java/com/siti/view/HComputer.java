package com.siti.view;

import com.siti.dao.DMonitor;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HComputer {

    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);

    static TabPane tab;
    public static ComboBox<String> cbModelo;
    public static ComboBox<String> cbMarca;
    public static TextField txfPatrimonio;
    public static TextField txfservicetag;
    public static ComboBox<String> departamento;
    public static ComboBox<String> setor;
    public static ComboBox<String> cbAjustavel;
    public static ComboBox<String> cbAndar;
    public static TextArea observacao;
    public static TextField txfBuscar;



    public static VBox computer(){

        //#region service tag, patrimonio, departamento e setor
        Label patrimonio = new Label("Patrimonio ");
        patrimonio.setPadding(new Insets(4,0,0,0));
        Label servicetag = new Label("Service Tag");
        servicetag.setPadding(new Insets(4,0,0,0));
        txfPatrimonio = new TextField();
        txfPatrimonio.setPromptText("M019771");
        txfPatrimonio.setPrefHeight(25);
        txfPatrimonio.setPrefWidth(115);
        txfservicetag = new TextField();
        txfservicetag.setPromptText("H87Q9R2");
        txfservicetag.setPrefHeight(25);
        txfservicetag.setPrefWidth(115);

        departamento = new ComboBox<>(); // Adicionar na h3
        departamento.setPrefWidth(180);
        departamento.setPromptText("Departamento");
        departamento.getItems().addAll("Laboratorios","Direcao");


        setor = new ComboBox<>(); // Adicionar na h4
        setor.setPrefWidth(180);
        setor.setPromptText("Setor");
        setor.getItems().addAll("Redacao 1","Redacao 2","Redacao 3","Redacao 4","Tesouraria","Secretaria","Sala Professores");


        HBox h1 = new HBox(5);
        h1.getChildren().addAll(patrimonio,txfPatrimonio); // Box de patrimonio

        HBox h2 = new HBox(5);
        h2.getChildren().addAll(servicetag,txfservicetag); // Box de service tag

        HBox h3 = new HBox(5);
        h3.getChildren().addAll(departamento);

        HBox h4 = new HBox(5);
        h4.getChildren().addAll(setor);

        VBox v1 = new VBox(15);
        v1.getChildren().addAll(h1,h2,h3,h4);
        v1.setPadding(new Insets(0,0,0,15));
        //endregion


        //#region marca, modelo, andar e ajustavel
        cbMarca = new ComboBox<>(); // Direto na V2
        cbMarca.setEditable(true);
        cbMarca.setPromptText("Marca");
        cbMarca.getItems().add("Dell");
        cbMarca.getSelectionModel().selectedItemProperty().addListener((options,oldvalue,newValue) ->{
            /**
             * Adiciona na Combo box caso ela n??o tenha o valor
             * */
            System.out.println("New item:" + newValue);
        });

        cbModelo = new ComboBox<>(); // Direto na V2
        cbModelo.setEditable(true);
        cbModelo.setPromptText("Modelo");
        cbModelo.getItems().add(cbModelo.getValue());
        cbModelo.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) ->{
            System.out.println(newValue);
        });

        Label ajustavel = new Label("Ajustavel"); // Adicionado na h5
        ajustavel.setPadding(new Insets(4,0,0,5));
        cbAjustavel = new ComboBox<>();
        cbAjustavel.setPromptText("Ajustavel ? ");
        cbAjustavel.getItems().addAll("Sim","N??o");
        cbAjustavel.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) -> {
            System.out.println(newValue);
        });

        Label andar = new Label("Andar"); // Adicionado no h6
        andar.setPadding(new Insets(4,0,0,0));
        cbAndar = new ComboBox<>();
        cbAndar.setPromptText("Andar...");
        cbAndar.setPrefWidth(104);
        cbAndar.getItems().addAll("6");


        HBox h5 = new HBox(5);
        h5.getChildren().addAll(ajustavel,cbAjustavel);

        HBox h6 = new HBox(20);
        h6.getChildren().addAll(andar,cbAndar);

        VBox v2 = new VBox(15);
        v2.getChildren().addAll(cbMarca,cbModelo,h5,h6);
        v2.setPadding(new Insets(4,0,0,15));
        //endregion


        //#region observa????es
        Label obs = new Label("Observa????es");
        obs.setPadding(new Insets(0,0,0,60));
        observacao = new TextArea();
        observacao.setPromptText("Digite observa????es aqui...");
        observacao.setPrefWidth(200);
        observacao.setPrefHeight(120);

        VBox v3 = new VBox(10);
        v3.getChildren().addAll(obs,observacao);
        //endregion

        HBox box1 = new HBox(15);
        box1.getChildren().addAll(v1,v2,v3,new Separator(Orientation.VERTICAL));

        Label monitores = new Label("Maquinas");
        monitores.setPadding(new Insets(0,0,0,15));
        monitores.setStyle("-fx-font: 24 arial");
        monitores.setPrefHeight(50);
        monitores.setPrefWidth(130);
        txfBuscar = new TextField();
        txfBuscar.setPromptText("Buscar maquina");
        txfBuscar.setPrefWidth(100);
        txfBuscar.setPrefHeight(20);
        txfBuscar.setOnAction(e -> {
            e.consume();
            System.out.println(DMonitor.obterIdentificacao(txfBuscar.getText()));
        });

        HBox buscabox = new HBox();
        buscabox.getChildren().addAll(txfBuscar, Buttons.buscar());
        buscabox.setSpacing(10);
        buscabox.setPadding(new Insets(0,0,0,15));
        VBox box = new VBox(5);
        box.getChildren().addAll(monitores,buscabox,new Separator(),box1);
        box.setPadding(new Insets(0,0,0,0));
        return box;
    }
}
