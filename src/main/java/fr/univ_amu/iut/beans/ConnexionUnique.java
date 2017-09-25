package fr.univ_amu.iut.beans;

import java.sql.Connection;

/**
 * Created by p16016063 on 25/09/17.
 */


public class ConnexionUnique {
    private Connection connection;
    private ConnexionUnique instance;
    private String CONNECT_URL;
    private String LOGIN;
    private String PASSWORD;
    public ConnexionUnique(){};
    public ConnexionUnique (Connection c, ConnexionUnique CU, String Co, String L, String P)
    {
        connection = c;
        instance = CU;
        CONNECT_URL = Co;
        LOGIN = L;
        PASSWORD = P;
    };

    public Connection GetConnection ()
    {
        return this.connection;
    }

    public ConnexionUnique getInstance()
    {
        return this.instance;
    }
}
