package com.siti.connection;

import com.siti.service.Display;
import com.siti.view.MonitorHUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MonitorDAO {


//
//    static String createCommand = "INSERT INTO tbmonitor (?,?,?,?,?,?,?,?,?,?)," +
//            "VALUES "


    static PreparedStatement pst = null;
    static ResultSet rs = null;




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
                "observacao)" +
                "VALUES (?,?,?,?,?,?,?,?,?)";

        ConnectionFactory.tbMonitor();

        try {

            pst = ConnectionFactory.getConnection().prepareStatement(createCommand);

            pst.setInt(1, Integer.parseInt(MonitorHUD.txfPatrimonio.getText()));
            pst.setString(2, MonitorHUD.txfservicetag.getText());
            pst.setString(3,MonitorHUD.cbMarca.getSelectionModel().getSelectedItem().toString());
            pst.setString(4,MonitorHUD.cbModelo.getSelectionModel().getSelectedItem().toString());
            pst.setString(5,MonitorHUD.departamento.getSelectionModel().getSelectedItem().toString());
            pst.setString(6,MonitorHUD.setor.getSelectionModel().getSelectedItem().toString());
            pst.setString(7,MonitorHUD.cbAjustavel.getSelectionModel().getSelectedItem().toString());
            pst.setString(8,MonitorHUD.cbAndar.getSelectionModel().getSelectedItem().toString());
            pst.setString(9,MonitorHUD.observacao.getText());

            int create = pst.executeUpdate();

        } catch (SQLException e) {

            Display.display("Erro de inserção","Ocorreu um erro de inserção \n " + e);

        } finally {

            ConnectionFactory.closeConnection();

        }

        return true;

    }

    /**
     * list monitor read
     * @return list monitors
     * */
//    static String selectCommand = (patrimonio == null) ? "SELECT * FROM tbmonitor WHERE patrimonio = ?" : "SELECT * FROM tbmonitor WHERE serviceTag = ?";
//    public static boolean readMonitor(){
//
//        try{
//
//            pst=ConnectionFactory.getConnection().prepareStatement(selectCommand);
//            pst.setString(1, MonitorHUD.txfPatrimonio.getText());
//            rs=pst.executeQuery();
//
//            if (rs.next()){
//
//                MonitorHUD.txfPatrimonio.setText(rs.getString(2));
//
//            } else {
//
//                Display.display("not have data","data not found");
//
//            }
//        } catch(Exception e){
//
//            Display.display("Not found",String.format("DB Not Found, %s", e));
//
//        }
//
//        return true;
//
//    }

}
