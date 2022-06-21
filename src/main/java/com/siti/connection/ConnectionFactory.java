package com.siti.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
        } catch (SQLException error){
            throw new RuntimeException(error);
        }
    }
}
