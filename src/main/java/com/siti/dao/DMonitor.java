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


//
//    static String createCommand = "INSERT INTO tbmonitor (?,?,?,?,?,?,?,?,?,?)," +
//            "VALUES "


    static PreparedStatement pst = null;
    static ResultSet rs = null;




    //#region insert region
    /**
     * insert data into tbMonitor, case table not exists he create the table.
     * @return true boolean
     * */
    public static boolean createCommand(){

        String createCommand = "INSERT INTO tbmonitor(" +
                "patrimonio," +
                "servicetag," +
                "marca," +
                "modelo," +
                "departamento," +
                "setor," +
                "ajustavel," +
                "andar," +
                "observacao," +
                "tipo)" +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        ConnectionFactory.tbMonitor();

        try {

            pst = ConnectionFactory.getConnection().prepareStatement(createCommand);

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

            int create = pst.executeUpdate();

        } catch (SQLException e) {

            Display.display("Erro de inserção","Ocorreu um erro de inserção \n " + e);

        } finally {

            ConnectionFactory.closeConnection();

        }

        return true;

    }

    //endregion


    //#region select region

    /**
     * obtain all monitors in a observable list
     * @return a observable list with contains all monitors
     * */
    public static ObservableList<Monitor> obtainAll(){

        ObservableList<Monitor> list = FXCollections.observableArrayList();

        String command = "SELECT * FROM tbmonitor WHERE patrimonio = ?";

        try {

            ConnectionFactory.getConnection();
            pst = ConnectionFactory.getConnection().prepareStatement(command);
            rs = pst.executeQuery();



            while(rs.next()) {
                /**
                 * Inserindo os dados nos labels de detalhes.
                 * */
                HMonitor.lblTipo.setText(HMonitor.lblTipo.getText() + rs.getString("tipo"));
                HMonitor.lblPatrimonio.setText(HMonitor.lblPatrimonio.getText() + rs.getInt("patrimonio"));
                HMonitor.lblServicetag.setText(HMonitor.lblServicetag.getText() + rs.getString("servicetag"));
                HMonitor.lblAndar.setText(HMonitor.lblAndar.getText() + rs.getString("andar"));
                HMonitor.lblDepartamento.setText(HMonitor.lblDepartamento.getText() + rs.getString("departamento"));
                HMonitor.lblSetor.setText(HMonitor.lblSetor.getText() + rs.getString("setor"));
                HMonitor.lblMarca.setText(HMonitor.lblMarca.getText() + rs.getString("marca"));
                HMonitor.lblModelo.setText(HMonitor.lblModelo.getText() + rs.getString("modelo"));
                HMonitor.lblObs.setText(HMonitor.lblObs.getText() + rs.getString("observacao"));
                HMonitor.lblStatus.setText(HMonitor.lblStatus.getText() + rs.getString("status"));

                /**
                 * Inserindo na table view.
                 * */
                list.add(new Monitor(
                        rs.getLong("id"),
                        rs.getInt("patrimonio"),
                        rs.getString("servicetag"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("departamento"),
                        rs.getString("setor"),
                        rs.getString("ajustavel"),
                        rs.getString("andar"),
                        rs.getString("observacao"),
                        rs.getString("tipo")
                ));
            }
            HMonitor.tableV.setItems(list);
        } catch (Exception e){

            throw new RuntimeException(e);

        } finally {
            ConnectionFactory.closeConnection();
        }

        return list;
    }


    //endregion

}
