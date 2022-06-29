package com.siti.view;

import com.siti.dao.DMonitor;
import com.siti.model.Monitor;
import com.siti.repository.MonitorRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Informations {


    //#region Monitor Table


    public static TableView<Monitor> tableV;
    public static TableColumn<Monitor, String> columnTipo; // tipo
    public static TableColumn<Monitor, String> columnPatrimonio; // patrimonio
    public static TableColumn<Monitor, String> columnST; // servicetag
    public static TableColumn<Monitor, String> columnAndar; // andar
    public static TableColumn<Monitor, String> columnDepartamento; // departamento
    public static TableColumn<Monitor, String> columnSetor; // setor
    public static TableColumn<Monitor,String> columnMarca; // marca
    public static TableColumn<Monitor, String> columnModelo; // modelo
    public static TableColumn<Monitor, String> columnObservacao; // obs
    public static TableColumn<Monitor,String> columnStatus; // status
    public static TableColumn<Monitor, String> columnAjustavel;


    /**
     * @return tableview contains all data monitors
     * */
    public static TableView<Monitor> monitorTable(){

        columnTipo = new TableColumn<>("Tipo");
        columnTipo.setPrefWidth(100);
        columnTipo.setCellValueFactory(data-> {
            if (data.getValue() != null) {
                return new SimpleStringProperty(data.getValue().getTipo()); // Capturando o dado da base da dados e jogando na tabela
            } else {
                return new SimpleStringProperty("<NO DATA TYPE>"); // Caso não exista o tipo ele retorna no data type
            }
        });


        columnPatrimonio = new TableColumn<>("Patrimonio");
        columnPatrimonio.setPrefWidth(150);
        columnPatrimonio.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getPatrimonio());

            else

                return new SimpleStringProperty("<SEM PATRIMONIO>");

        });

        columnST = new TableColumn<>("Service Tag");
        columnST.setPrefWidth(150);
        columnST.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getServicetag());

            else

                return new SimpleStringProperty("<SEM SERVICE TAG>");

        });

        TableColumn<Monitor, TableColumn> columnIdentificacao = new TableColumn<>("Identificação");
        columnIdentificacao.setPrefWidth(300);
        columnIdentificacao.getColumns().addAll(columnPatrimonio,columnST);

        columnAndar = new TableColumn<>("Andar");
        columnAndar.setPrefWidth(100);
        columnAndar.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getAndar());

            else

                return new SimpleStringProperty("<SEM ANDAR>");

        });

        columnDepartamento = new TableColumn<>("Departamento");
        columnDepartamento.setPrefWidth(100);
        columnDepartamento.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getDepartamento());

            else

                return new SimpleStringProperty("<SEM DP>");

        });

        columnSetor = new TableColumn<>("Setor");
        columnSetor.setPrefWidth(100);
        columnSetor.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getSetor());

            else

                return new SimpleStringProperty("<SEM SETOR>");

        });

        TableColumn<Monitor, String> columnLocalizacao = new TableColumn<Monitor, String>("Localização");
        columnLocalizacao.setPrefWidth(300);
        columnLocalizacao.getColumns().addAll(columnAndar,columnDepartamento,columnSetor);

        columnMarca = new TableColumn<>("Marca");
        columnMarca.setPrefWidth(100);
        columnMarca.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getMarca());

            else

                return new SimpleStringProperty("<SEM MARCA>");

        });

        columnModelo = new TableColumn<>("Modelo");
        columnModelo.setPrefWidth(100);
        columnModelo.setCellValueFactory(data ->{
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().modelo);

            else

                return new SimpleStringProperty("<SEM MODELO>");

        });

        columnAjustavel = new TableColumn<>("Ajustavel");
        columnAjustavel.setPrefWidth(100);
        columnAjustavel.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getAjustavel());

            else

                return new SimpleStringProperty("<NULL>");

        });

        TableColumn<Monitor,String> columnFornecedor = new TableColumn<Monitor, String>("Maquina");
        columnFornecedor.setPrefWidth(300);
        columnFornecedor.getColumns().addAll(columnMarca,columnModelo,columnAjustavel);

        columnObservacao = new TableColumn<>("Observação");
        columnObservacao.setPrefWidth(150);
        columnObservacao.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getObservacao());

            else

                return new SimpleStringProperty("SEM OBSERVAÇÃO");

        });

        columnStatus = new TableColumn<>("Status");
        columnStatus.setPrefWidth(100);
        columnStatus.setCellValueFactory(data -> {
            if(data.getValue() != null)

                return new SimpleStringProperty(data.getValue().getEstado());

            else

                return new SimpleStringProperty("<SEM ESTADO>");

        });





        TableView<Monitor> tableV = new TableView();
        tableV.getColumns().addAll(columnTipo,columnIdentificacao,columnLocalizacao,columnFornecedor,columnObservacao,columnStatus);
        tableV.setEditable(false);
        tableV.setItems(MonitorRepository.obterTodos());

        return tableV;

    }

    //endregion

}
