package fr.univ_amu.iut.beans;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by p16016063 on 26/09/17.
 */


public class ConnexionUnique {
    private Connection connection;
    private static ConnexionUnique instance;
    private static final String CONNECT_URL = "jdbc:mysql://mysql-jeremie.alwaysdata.net:3306/jeremie_passeratbd";
    private static final String LOGIN = "user1" +
            "";
    private static final String PASSWORD = "123";
    public  Connection getConnection() {return connection;}
    public static ConnexionUnique getInstance() {
        if(instance == null)
            instance = new ConnexionUnique();
        return instance;}

    public ConnexionUnique() {
        try {
            connection = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD);        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
