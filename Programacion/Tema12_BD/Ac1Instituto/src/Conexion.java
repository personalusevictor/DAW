package src;

import java.sql.*;

public class Conexion {
    public static Connection getConexion() throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/instituto", "root", "");
    }
}
