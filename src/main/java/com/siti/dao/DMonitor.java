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

public class DMonitor {


    //#region obter  monitor
    /**
     * @return a observable list of monitors.
     * */
    public static ObservableList<Monitor> obterMonitor(){

        ObservableList<Monitor> monitors = FXCollections.observableArrayList();
        ResultSet rs = null;
        PreparedStatement pst = null;

        String command1 = "SELECT * FROM tbMonitor WHERE patrimonio = ?";
        String command2 = "SELECT * FROM tbMonitor WHERE servicetag = ?";

        try {


            pst = ConnectionFactory.getConnection().prepareStatement(command1);
            rs = pst.executeQuery();


            while(rs.next()){

                // jogando para detalhes

                HMonitor.lblTipo.setText(HMonitor.lblTipo.getText() + rs.getString("tipo"));
                HMonitor.lblPatrimonio.setText(HMonitor.lblPatrimonio.getText() + rs.getInt("patrimonio"));
                HMonitor.lblServicetag.setText(HMonitor.lblServicetag.getText() + rs.getString("servicetag"));
                HMonitor.lblAndar.setText(HMonitor.lblAndar.getText() + rs.getString("andar"));
                HMonitor.lblDepartamento.setText(HMonitor.lblDepartamento.getText() + rs.getString("departamento"));
                HMonitor.lblSetor.setText(HMonitor.lblSetor.getText() + rs.getString("setor"));
                HMonitor.lblMarca.setText(HMonitor.lblMarca.getText() + rs.getString("marca"));
                HMonitor.lblModelo.setText(HMonitor.lblModelo.getText() + rs.getString("modelo"));
                HMonitor.lblObs.setText(HMonitor.lblObs.getText() + rs.getString("observacao"));
                HMonitor.lblStatus.setText(HMonitor.lblStatus.getText() + rs.getString("estado"));

                monitors.add(new Monitor(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));

                HMonitor.tableV.setItems(monitors);

            }


        } catch (SQLException e) {

            throw new RuntimeException(e);

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

        ConnectionFactory.tbMonitor(); // Função para criar a tbMonitor

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

            pst.setInt(1, Integer.parseInt(HMonitor.txfPatrimonio.getText()));
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

            throw new RuntimeException(e);

        } finally {

            ConnectionFactory.closeConnection();

        }


        return true;
    }

    //endregion

}