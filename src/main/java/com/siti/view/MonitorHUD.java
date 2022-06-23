package com.siti.view;

import javafx.css.Style;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MonitorHUD {

    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);

    public static VBox monitor(){

        //#region service tag, patrimonio, departamento e setor
        Label patrimonio = new Label("Patrimonio ");
        patrimonio.setPadding(new Insets(4,0,0,0));
        Label servicetag = new Label("Service Tag");
        servicetag.setPadding(new Insets(4,0,0,0));
        TextField txfPatrimonio = new TextField();
        txfPatrimonio.setPromptText("M019771");
        txfPatrimonio.setPrefHeight(25);
        txfPatrimonio.setPrefWidth(115);
        TextField txfservicetag = new TextField();
        txfservicetag.setPromptText("H87Q9R2");
        txfservicetag.setPrefHeight(25);
        txfservicetag.setPrefWidth(115);

        ComboBox<String> departamento = new ComboBox<>(); // Adicionar na h3
        departamento.setPrefWidth(180);
        departamento.setPromptText("Departamento");
        departamento.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) ->{
            System.out.println(newValue);
        });

        ComboBox<String> setor = new ComboBox<>(); // Adicionar na h4
        setor.setPrefWidth(180);
        setor.setPromptText("Setor");
        setor.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) ->{
            System.out.println(newValue);
        });

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
        ComboBox<String> cbMarca = new ComboBox<>(); // Direto na V2
        cbMarca.setEditable(true);
        cbMarca.setPromptText("Marca");
        cbMarca.getItems().add("Dell");
        cbMarca.getSelectionModel().selectedItemProperty().addListener((options,oldvalue,newValue) ->{
            /**
             * Adiciona na Combo box caso ela não tenha o valor
             * */
            System.out.println("New item:" + newValue);
        });

        ComboBox<String> cbModelo = new ComboBox<>(); // Direto na V2
        cbModelo.setEditable(true);
        cbModelo.setPromptText("Modelo");
        cbModelo.getItems().add(cbModelo.getValue());
        cbModelo.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) ->{
            System.out.println(newValue);
        });

        Label ajustavel = new Label("Ajustavel"); // Adicionado na h5
        ajustavel.setPadding(new Insets(4,0,0,0));
        ComboBox<String> cbAjustavel = new ComboBox<>();
        cbAjustavel.setPromptText("Ajustavel ? ");
        cbAjustavel.getItems().addAll("Sim","Não");
        cbAjustavel.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) -> {
            System.out.println(newValue);
        });

        Label andar = new Label("Andar"); // Adicionado no h6
        andar.setPadding(new Insets(4,0,0,0));
        ComboBox<String> cbAndar = new ComboBox<>();
        cbAndar.setPromptText("Andar...");
        cbAndar.setPrefWidth(104);
        cbAndar.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) ->{
            System.out.println(newValue);
        });


        HBox h5 = new HBox(5);
        h5.getChildren().addAll(ajustavel,cbAjustavel);

        HBox h6 = new HBox(20);
        h6.getChildren().addAll(andar,cbAndar);

        VBox v2 = new VBox(15);
        v2.getChildren().addAll(cbMarca,cbModelo,h5,h6);
        //endregion


        //#region observações
        Label obs = new Label("Observações");
        obs.setPadding(new Insets(0,0,0,60));
        TextArea observacao = new TextArea();
        observacao.setPromptText("Digite observações aqui...");
        observacao.setPrefWidth(200);
        observacao.setPrefHeight(120);

        VBox v3 = new VBox(10);
        v3.getChildren().addAll(obs,observacao);
        //endregion

        HBox box1 = new HBox(10);
        box1.getChildren().addAll(v1,v2,v3);

        Label monitores = new Label("Monitores");
        monitores.setPadding(new Insets(0,0,0,10));
        monitores.setStyle("-fx-font: 24 arial");
        monitores.setPrefHeight(50);
        monitores.setPrefWidth(130);
        VBox box = new VBox(5);
        box.getChildren().addAll(monitores,box1);
        box.setPadding(new Insets(0,0,0,0));
        return box;
    }


    /**
     * @return tabpane with listviewer and count of monitors.
     * */
    public static VBox listas(){

        Tab active = new Tab("Ativo");
        Tab waste = new Tab("Sucata");
        Tab inventory = new Tab("Estoque");
        Tab maintenance = new Tab("Manutenção");

        TabPane tab = new TabPane();
        tab.getTabs().addAll(active,waste,inventory,maintenance);
        tab.setPrefWidth(1000);

        HBox box1 = new HBox(5);
        box1.getChildren().addAll(tab,vertical);

        VBox box = new VBox(5);
        box.getChildren().addAll(horizontal,box1);
        box.setPrefWidth(900);

        return box;
    }
}
