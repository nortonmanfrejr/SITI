package com.siti.connection;

import com.siti.service.Display;
import com.siti.view.MonitorHUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MonitorDAO {


    static String selectCommand = "SELECT * FROM tbMonitor WHERE patrimonio=?";
    static String tbCommand = "CREATE TABLE IF NOT EXISTS tbMonitor";

    static PreparedStatement pst = null;
    static ResultSet rs = null;

    /**
     *
     * @return new data monitor, case not exists tbMonitor he create.
     * */
    public static boolean createMonitor(){



    }

    /**
     * list monitor read
     * @return list monitors
     * */
    public static boolean readMonitor(){


        try{
            pst=ConnectionFactory.getConnection().prepareStatement(selectCommand);
            pst.setString(1, MonitorHUD.txfPatrimonio.getText());
            rs=pst.executeQuery();

            if (rs.next()){
                MonitorHUD.txfPatrimonio.setText(rs.getString(2));
            } else {
                Display.display("not have data","data not found");
            }
        } catch(Exception e){
            Display.display("Not found",String.format("DB Not Found, %s", e));
        }
        return true;
    }
}
