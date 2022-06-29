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

        } catch (SQLException e){

            Display.confirmDisplay("Erro","Erro: " + e);

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

                Display.confirmDisplay("Erro","Erro: " + e);

            }

        }

    }


    /**
     * create lists of monitors in inventory database case not exists
     * */
    public static void tbMonitor(){

        String command = "CREATE TABLE IF NOT EXISTS tbMonitor (\n" +
                "    id INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
                "    patrimonio VARCHAR(30) UNIQUE,\n" +
                "    serviceTag TEXT UNIQUE NOT NULL,\n" +
                "    marca VARCHAR (20) NOT NULL,\n" +
                "    modelo VARCHAR (50) NOT NULL,\n" +
                "    departamento VARCHAR (50),\n" +
                "    setor VARCHAR (30),\n" +
                "    ajustavel VARCHAR (5) NOT NULL,\n" +
                "    andar VARCHAR(30) NOT NULL,\n" +
                "    observacao TEXT,\n" +
                "    tipo VARCHAR(20) NOT NULL,\n" +
                "    estado VARCHAR(30) NOT NULL" +
                ")";
        try {

            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSITI","root","");
            pst = connect.prepareStatement(command);
            int create = pst.executeUpdate();

        } catch (Exception e) {

            Display.confirmDisplay("Erro","Erro: " + e);

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

            Display.confirmDisplay("Erro","Erro: " + e);

        } finally {

            closeConnection();

        }

    }

}
