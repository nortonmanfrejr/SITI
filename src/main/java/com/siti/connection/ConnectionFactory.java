package com.siti.connection;

import com.siti.service.Display;

import java.sql.*;

public class ConnectionFactory {

    static PreparedStatement pst = null;
    static Connection connect;

    /**
     *
     * @return a connection with database, case database not exists he create a database
     * */
    public static Connection getConnection(){

        dbCreate();

        /**
         * connect in database inventory case exists
         * */

        try{

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory","root","");
            return connect;

        } catch (SQLException error){

            Display.display("Error",String.format("Erro ao acessar o banco de dados: %s", error));

        }

        return null;
    }


    /**
     * close connection with database and the server
     * */
    public static void closeConnection(){
        if(connect != null) {

            try {
                connect.close();
            } catch (SQLException e) {

                Display.display("Error", String.format("Error ==== %s", e));
            }

        }
    }

    /**
     * create database inventory case not exists
     */
    private static void dbCreate(){

        String command = "CREATE DATABASE IF NOT EXISTS inventory";

        try{

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
            pst = connect.prepareStatement(command);
            int create = pst.executeUpdate();

        } catch (Exception e){

            Display.display("Not found",String.format("Server not found, %s", e));

        } finally {
            closeConnection();
        }

    }

}
