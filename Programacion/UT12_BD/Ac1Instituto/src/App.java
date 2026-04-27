package src;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void mostrarDatos() {
        try (ResultSet rs = Conexion.getConexion().createStatement().executeQuery("SELECT * FROM alumnos;");) {
            while (rs.next()) {
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    System.out.print(rs.getObject(i) + "\t\t");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarDatos() throws ParseException {

        System.out.println("==== Insertar Datos | Alumnos ====");

        System.out.print("Número del Alumno: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre del Alumno: ");
        String nombre = sc.nextLine();

        System.out.print("Fecha de Nacimiento del Alumno (yyyy-MM-dd): ");
        String fnacString = sc.nextLine();
        java.sql.Date sqlDate = java.sql.Date.valueOf(fnacString);

        System.out.print("Nota media del Alumno: ");
        Double media = sc.nextDouble();

        System.out.print("Curso del Alumno: ");
        sc.nextLine();
        String curso = sc.nextLine();

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO alumnos (num, nombre, fnac, media, curso) VALUES (?, ?, ?, ?, ?)")) {

            ps.setInt(1, num);
            ps.setString(2, nombre);
            ps.setDate(3, sqlDate);
            ps.setDouble(4, media);
            ps.setString(5, curso);

            int filasAfectadas = ps.executeUpdate();
            System.out.println("Filas Afectadas: " + filasAfectadas);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*
        try (Connection con = Conexion.getConexion(); Statement stmt = con.createStatement()) {
            int filasAfectadas = stmt.executeUpdate("INSERT INTO alumnos VALUES (" + num + ", '" + nombre + "', '" + fnacString + "', " + media + ", '" + curso + "')");
            System.out.println("Filas Afectadas: " + filasAfectadas);
            
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        */
    }

    public static void main(String[] args) throws Exception {
        insertarDatos();
    }
}
