package com.siti.dao;

import com.siti.connection.ConnectionFactory;
import com.siti.model.Monitor;
import com.siti.service.Display;
import com.siti.view.HMonitor;
import com.siti.view.MainHUD;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DMonitor {


    //#region obter  todos monitores
    /**
     * @return a observable list of monitors.
     */
    public static ObservableList<Monitor> obterLista(){

        ObservableList<Monitor> monitors = FXCollections.observableArrayList();

        ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String command = "SELECT * FROM tbMonitor;";

        try {


            pst = ConnectionFactory.getConnection().prepareStatement(command);
            rs = pst.executeQuery();


            while(rs.next()){

                Monitor monitor = new Monitor();

                monitor.setId(rs.getInt("id"));
                monitor.setPatrimonio(rs.getString("patrimonio"));
                monitor.setServicetag(rs.getString("serviceTag"));
                monitor.setMarca(rs.getString("marca"));
                monitor.setModelo(rs.getString("modelo"));
                monitor.setDepartamento(rs.getString("departamento"));
                monitor.setSetor(rs.getString("setor"));
                monitor.setAjustavel(rs.getString("ajustavel"));
                monitor.setAndar(rs.getString("andar"));
                monitor.setObservacao(rs.getString("observacao"));
                monitor.setTipo(rs.getString("tipo"));
                monitor.setEstado(rs.getString("estado"));

                monitors.add(monitor);

            }


        } catch (SQLException e) {

            Display.confirmDisplay("Erro","Erro: " + e);

        } finally {

            ConnectionFactory.closeConnection();

        }

        return monitors;
    }

    //endregion


    //#region obter 1 monitor
    /**
     * @return a observable list of monitors.
     */
    public static ObservableList<Monitor> obterIdentificacao(String str){

        ObservableList<Monitor> monitors = FXCollections.observableArrayList();

        ConnectionFactory.getConnection();
        ResultSet rs = null;
        PreparedStatement pst = null;
        String command = "SELECT * FROM tbMonitor WHERE patrimonio LIKE '%" + str +"%' OR servicetag LIKE '%" + str + "%';";

        try {


            pst = ConnectionFactory.getConnection().prepareStatement(command);
            rs = pst.executeQuery();


            while(rs.next()){


                Monitor monitor = new Monitor();

                monitor.setId(rs.getInt("id"));
                monitor.setPatrimonio(rs.getString("patrimonio"));
                monitor.setServicetag(rs.getString("serviceTag"));
                monitor.setMarca(rs.getString("marca"));
                monitor.setModelo(rs.getString("modelo"));
                monitor.setDepartamento(rs.getString("departamento"));
                monitor.setSetor(rs.getString("setor"));
                monitor.setAjustavel(rs.getString("ajustavel"));
                monitor.setAndar(rs.getString("andar"));
                monitor.setObservacao(rs.getString("observacao"));
                monitor.setTipo(rs.getString("tipo"));
                monitor.setEstado(rs.getString("estado"));

                monitors.add(monitor);


            }


        } catch (SQLException e) {

            Display.confirmDisplay("Erro","Erro: " + e);

        } finally {

            ConnectionFactory.closeConnection();

        }

        return monitors;
    }
    //endregion



    //#region criar monitor

    /**
     * Create monitor data and casa not exists tbMonitor he create.
     * */
    public static Boolean createMonitor(){

        PreparedStatement pst = null;

        ConnectionFactory.tbMonitor(); // Fun????o para criar a tbMonitor

        String command = "INSERT INTO tbMonitor(" +
                "patrimonio," +
                "servicetag," +
                "marca," +
                "modelo," +
                "departamento," +
                "setor," +
                "ajustavel," +
                "andar," +
                "observacao," +
                "tipo," +
                "estado)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {

            pst = ConnectionFactory.getConnection().prepareStatement(command);

            pst.setString(1, HMonitor.txfPatrimonio.getText());
            pst.setString(2, HMonitor.txfservicetag.getText());
            pst.setString(3, HMonitor.cbMarca.getSelectionModel().getSelectedItem().toString());
            pst.setString(4, HMonitor.cbModelo.getSelectionModel().getSelectedItem().toString());
            pst.setString(5, HMonitor.departamento.getSelectionModel().getSelectedItem().toString());
            pst.setString(6, HMonitor.setor.getSelectionModel().getSelectedItem().toString());
            pst.setString(7, HMonitor.cbAjustavel.getSelectionModel().getSelectedItem().toString());
            pst.setString(8, HMonitor.cbAndar.getSelectionModel().getSelectedItem().toString());
            pst.setString(9, HMonitor.observacao.getText());
            pst.setString(10, MainHUD.tipo.getValue().toString());
            pst.setString(11, MainHUD.estado.getValue().toString());

            int create = pst.executeUpdate();

        } catch (Exception e) {

            Display.confirmDisplay("Erro","Erro: " + e);

        } finally {

            ConnectionFactory.closeConnection();

        }


        return true;
    }

    //endregion

}