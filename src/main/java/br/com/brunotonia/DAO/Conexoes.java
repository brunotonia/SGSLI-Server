package br.com.brunotonia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexoes {

    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://127.0.0.1:5432/sgsli";
    private final String usuario = "bruno";
    private final String password = "angra1";

    public Connection getConexao() throws Exception {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            return null;
        }

    }

}
