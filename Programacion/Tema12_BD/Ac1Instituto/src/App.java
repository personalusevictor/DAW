package src;

import java.sql.*;
import java.text.ParseException;
import java.util.Scanner;

public class App {

    public static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n==== Menu | Instituto =====");
        System.out.println("1. Mostrar Datos - Alumnos");
        System.out.println("2. Insertar Datos");
        System.out.println("3. Actualizar Datos");
        System.out.println("4. Eliminar Datos");
        System.out.println("5. Mostrar Datos - Curso");
        System.out.println("6. Mostrar Datos - Mejor y Peor Nota");
        System.out.println("7. Salir");
        System.out.print("Elige una opcion: ");
    }

    public static void read() {
        System.out.println("\nMostrar Datos | Alumnos\n");
        try (ResultSet rs = Conexion.getConexion().createStatement().executeQuery("SELECT * FROM alumnos;");) {
            System.out.printf("%-6s %-20s %-20s %-10s %-6s\n", "ID", "Nombre", "Fecha de Nacimiento", "Media",
                    "Curso");
            System.out.println(
                    "------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-6d %-20s %-20s %-10.2f %-6s\n", rs.getInt("num"), rs.getString("nombre"),
                        rs.getDate("fnac"), rs.getDouble("media"), rs.getString("curso"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void create() throws ParseException {

        System.out.println("\nInsertar Datos | Alumnos");

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

    public static void update() {
        System.out.println("\nActualizar Datos | Alumnos");
        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con
                        .prepareStatement("UPDATE alumnos SET media = media + 1 WHERE curso = ?;");) {

            ps.setObject(1, "1B");
            int filas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete() {
        System.out.println("\nEliminar Datos | Alumnos");
        System.out.print("Dime el numero del alumno: ");
        int num = sc.nextInt();
        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("DELETE FROM alumnos WHERE num = ?;")) {
            ps.setObject(1, num);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("\nAlumno eliminado correctamente");
            } else {
                System.out.println("\nError: No existe ningun alumno con ese número");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readCurso() {
        System.out.println("\nMostrar Datos | Curso\n");
        System.out.print("De que curso quieres mostrar los datos: ");
        String curso = sc.next();
        System.out.println();

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT nombre, fnac FROM alumnos WHERE curso = ?;")) {
            ps.setObject(1, curso);

            ResultSet rs = ps.executeQuery();

            System.out.printf("%-25s %-20s\n", "Nombre", "Fecha de Nacimiento");
            System.out.println("-----------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-25s %-20s\n", rs.getString("nombre"), rs.getDate("fnac"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void bestWorst() {

        try (Connection con = Conexion.getConexion();
                PreparedStatement ps = con.prepareStatement(
                        "(SELECT nombre, media FROM alumnos WHERE media = (SELECT MAX(media) FROM alumnos)) UNION (SELECT nombre, media FROM alumnos WHERE media = (SELECT MIN(media) FROM alumnos))",
                        ResultSet.TYPE_SCROLL_INSENSITIVE)) {
            read();
            ResultSet rs = ps.executeQuery();

            System.out.println("\nMostrar Datos - Mejor y Peor Nota | Alumnos\n");
            System.out.printf("%-25s %-6s\n", "Nombre", "Nota");
            System.out.println("--------------------------------------");
            while (rs.next()) {
                System.out.printf("%-25s %-6.2f\n", rs.getString("nombre"), rs.getDouble("media"));
            }
        } catch (SQLException e) {
        }

    }

    public static void main(String[] args) throws Exception {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> read();
                case 2 -> create();
                case 3 -> update();
                case 4 -> delete();
                case 5 -> readCurso();
                case 6 -> bestWorst();
                case 7 -> System.out.println("\nSaliendo del programa...");
                default -> System.out.println("\nError: la opcion introducida no es correcta");
            }
        } while (opcion != 6);
    }
}
