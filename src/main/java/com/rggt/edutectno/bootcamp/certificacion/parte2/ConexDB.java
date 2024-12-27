package com.rggt.edutectno.bootcamp.certificacion.parte2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexDB {
    private static Connection c;
    private static final String url = "jdbc:mysql://localhost:3306/certificacionedu?serverTimezone=America/Santiago";
    private static final String usuario = "root";
    private static final String clave = "raf123";

    public static Connection getInstance() throws SQLException, ClassNotFoundException {
        if (c == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, usuario, clave);
        }
        return c;
    }
}
