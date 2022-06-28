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
        tbMonitor();

        /**
         * connect in database inventory case exists
         * */

        try{

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSITI","root","");
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
     * create lists of monitors in inventory database case not exists
     * */
    public static void tbMonitor(){

        String command = "CREATE TABLE IF NOT EXISTS tbMonitor (\n" +
                "    id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                "    patrimonio INTEGER UNIQUE,\n" +
                "    serviceTag TEXT UNIQUE,\n" +
                "    marca VARCHAR (20),\n" +
                "    modelo VARCHAR (50),\n" +
                "    departamento VARCHAR (50),\n" +
                "    setor VARCHAR (30),\n" +
                "    ajustavel VARCHAR (5),\n" +
                "    andar VARCHAR(30),\n" +
                "    observacao TEXT,\n" +
                "    tipo VARCHAR(20),\n" +
                "    estado VARCHAR(30)" +
                ")";
        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSITI","root","");
            pst = connect.prepareStatement(command);
            int create = pst.executeUpdate();

        } catch (Exception e) {

            Display.display("Not found", "Server not found");

        } finally {

            closeConnection();

        }
    }

    /**
     * create database inventory case not exists
     */
    private static void dbCreate(){

        String command = "CREATE DATABASE IF NOT EXISTS dbSITI";

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
