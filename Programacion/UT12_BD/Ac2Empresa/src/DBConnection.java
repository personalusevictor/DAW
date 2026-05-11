package UT12_BD.Ac2Empresa.src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "root", "");
    }
}
