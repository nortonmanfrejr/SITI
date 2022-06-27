package com.siti.view;

import com.siti.model.Monitor;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;

public class HMonitor {

    static Separator vertical = new Separator(Orientation.VERTICAL);
    static Separator horizontal = new Separator(Orientation.HORIZONTAL);

    static TabPane tab;
    static Tab ativos,estoque,sucata,manutancao;

    public static ComboBox<String> cbModelo;
    public static ComboBox<String> cbMarca;
    public static TextField txfPatrimonio;
    public static TextField txfservicetag;
    public static ComboBox<String> departamento;
    public static ComboBox<String> setor;
    public static ComboBox<String> cbAjustavel;
    public static ComboBox<String> cbAndar;
    public static TextArea observacao;


    //#region monitor main layout
    /**
     * @return monitor scene.
     * */
    public static VBox monitor(){

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
        departamento.getSelectionModel().selectedItemProperty().addListener((options,oldValue,newValue) ->{
            System.out.println(newValue);
        });

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
             * Adiciona na Combo box caso ela não tenha o valor
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
        cbAjustavel.getItems().addAll("Sim","Não");
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


        //#region observações
        Label obs = new Label("Observações");
        obs.setPadding(new Insets(0,0,0,60));
        observacao = new TextArea();
        observacao.setPromptText("Digite observações aqui...");
        observacao.setPrefWidth(200);
        observacao.setPrefHeight(120);

        VBox v3 = new VBox(10);
        v3.getChildren().addAll(obs,observacao);
        //endregion

        HBox box1 = new HBox(15);
        box1.getChildren().addAll(v1,v2,v3,new Separator(Orientation.VERTICAL),new Separator(Orientation.VERTICAL));

        Label monitores = new Label("Monitores");
        monitores.setPadding(new Insets(0,0,0,15));
        monitores.setStyle("-fx-font: 24 arial");
        monitores.setPrefHeight(50);
        monitores.setPrefWidth(130);
        VBox box = new VBox(5);
        box.getChildren().addAll(monitores,new Separator(),box1);
        box.setPadding(new Insets(0,0,0,0));
        return box;
    }
    //endregion

    //#region Tables

    public static TableView<Monitor> tableV;
    public static TableColumn<Monitor, String> columnTipo; // tipo
    public static TableColumn<Monitor, Integer> columnPatrimonio; // patrimonio
    public static TableColumn<Monitor, String> columnST; // servicetag
    public static TableColumn<Monitor, String> columnAndar; // andar
    public static TableColumn<Monitor, String> columnDepartamento; // departamento
    public static TableColumn<Monitor, String> columnSetor; // setor
    public static TableColumn<Monitor,String> columnMarca; // marca
    public static TableColumn<Monitor, String> columnModelo; // modelo
    public static TableColumn<Monitor, String> columnObservacao; // obs
    public static TableColumn<Monitor,String> columnStatus; // status

    /**
     * @return tableview contains all data monitors
     * */
    private static TableView<Monitor> table(){

        columnTipo = new TableColumn<>("Tipo");
        columnTipo.setPrefWidth(100);
        columnTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

        columnPatrimonio = new TableColumn<>("Patrimonio");
        columnPatrimonio.setPrefWidth(150);
        columnPatrimonio.setCellValueFactory(new PropertyValueFactory<>("patrimonio"));


        columnST = new TableColumn<>("Service Tag");
        columnST.setPrefWidth(150);
        columnST.setCellValueFactory(new PropertyValueFactory<>("servicetag"));

        TableColumn<Monitor, TableColumn> columnIdentificacao = new TableColumn<>("Identificação");
        columnIdentificacao.setPrefWidth(300);
        columnIdentificacao.getColumns().addAll(columnPatrimonio,columnST);

        columnAndar = new TableColumn<>("Andar");
        columnAndar.setPrefWidth(100);
        columnAndar.setCellValueFactory(new PropertyValueFactory<>("andar"));

        columnDepartamento = new TableColumn<>("Departamento");
        columnDepartamento.setPrefWidth(100);
        columnDepartamento.setCellValueFactory(new PropertyValueFactory<>("departamento"));

        columnSetor = new TableColumn<>("Setor");
        columnSetor.setPrefWidth(100);
        columnSetor.setCellValueFactory(new PropertyValueFactory<>("setor"));

        TableColumn<Monitor, String> columnLocalizacao = new TableColumn<>("Localização");
        columnLocalizacao.setPrefWidth(300);
        columnLocalizacao.getColumns().addAll(columnAndar,columnDepartamento,columnSetor);

        columnMarca = new TableColumn<>("Marca");
        columnMarca.setPrefWidth(100);
        columnMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));

        columnModelo = new TableColumn<>("Modelo");
        columnModelo.setPrefWidth(100);
        columnModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));

        TableColumn<Monitor,String> columnFornecedor = new TableColumn<>("Maquina");
        columnFornecedor.setPrefWidth(200);
        columnFornecedor.getColumns().addAll(columnMarca,columnModelo);

        columnObservacao = new TableColumn<>("Observação");
        columnObservacao.setPrefWidth(150);
        columnObservacao.setCellValueFactory(new PropertyValueFactory<>("obs"));

        columnStatus = new TableColumn<>("Status");
        columnStatus.setPrefWidth(100);
        columnStatus.setCellValueFactory(new PropertyValueFactory<>("status"));


        TableView tableV = new TableView();
        tableV.getColumns().addAll(columnTipo,columnIdentificacao,columnLocalizacao,columnFornecedor,columnObservacao,columnStatus);
        tableV.setEditable(true);

        return tableV;
    }

    //endregion

    //#region detalhes

    public static Label lblTipo, lblPatrimonio, lblServicetag,
                        lblAndar, lblDepartamento, lblSetor,
                        lblMarca, lblModelo, lblObs, lblStatus;

    /**
     * @return box de detalhes dos itens, é um suporte para o callback tambem.
     * */
    private static VBox detalhe(){

        lblTipo = new Label("Tipo: ");
        lblPatrimonio = new Label("Patrimonio: ");
        lblServicetag = new Label("Service Tag: ");
        lblAndar = new Label("Andar: ");
        lblDepartamento = new Label("Departamento: ");
        lblSetor = new Label("Setor: ");
        lblMarca = new Label("Marca: ");
        lblModelo = new Label("Modelo: ");
        lblObs = new Label("Observação: ");
        lblStatus = new Label("Status: ");

        VBox box = new VBox(10);
        box.getChildren().addAll(
                lblTipo,
                lblPatrimonio,
                lblServicetag,
                lblAndar,
                lblDepartamento,
                lblSetor,
                lblMarca,
                lblModelo,
                lblStatus,
                lblObs);
        return box;
    }
    //endregion

    //#region tabs

    /**
     * @return box with tableviews and details of item
     * */
    public static HBox tabs(){


        Tab ativos = new Tab();
        ativos.setClosable(false);
        ativos.setContent(table());

        tab = new TabPane();
        tab.getTabs().add(ativos);

        HBox box = new HBox(10);
        box.getChildren().addAll(tab,new Separator(Orientation.VERTICAL),detalhe());
        return box;
    }


    //endregion
}
