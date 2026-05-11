package UT12_BD.Ac2Empresa.src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    private static Scanner sc = new Scanner(System.in);

    public static void mostrarMenu() {
        System.out.println("\n==== Menu Empresa ====");
        System.out.println("1. Mostrar Empleados");
        System.out.println("2. Mostrar Oficina Por Ciudad");
        System.out.println("3. Mostrar Empleados Por Edad");
        System.out.println("4. Salir");
        System.out.print("Elige una opcion: ");
    }

    public static void readEmpleados() {
        try (Connection con = DBConnection.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM empleados;");
                ResultSet rs = ps.executeQuery();) {

            System.out.println("\nLISTADO DE EMPLEADOS");
            System.out.printf("%-5s %-25s %-5s %-8s %-25s %-12s\n", "ID", "Nombre", "Edad", "Oficina", "Puesto",
                    "Contrato");
            System.out.println(
                    "------------------------------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-5d %-25s %-5d %-8s %-25s %-12s\n", rs.getInt("numemp"), rs.getString("nombre"),
                        rs.getInt("edad"), rs.getString("oficina"), rs.getString("puesto"), rs.getDate("contrato"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readOficinaspCiudad(String ciudad) {
        try (Connection con = DBConnection.getConexion();
                PreparedStatement ps = con.prepareStatement("SELECT * FROM oficinas WHERE LOWER(ciudad) = LOWER(?)");) {

            ps.setString(1, ciudad);
            ResultSet rs = ps.executeQuery();

            boolean found = false;

            System.out.println("\nOFICINAS EN " + ciudad.toUpperCase() + ": ");
            System.out.printf("%-10s %-15s %-15s %-10s\n", "Oficina", "Ciudad", "Superficie", "Ventas");
            System.out.println("--------------------------------------------------");
            while (rs.next()) {

                found = true;

                System.out.printf("%-10d %-15s %-15d %-10.2f\n", rs.getInt("oficina"), rs.getString("ciudad"),
                        rs.getInt("superficie"), rs.getDouble("ventas"));
            }

            if (!found) {
                System.out.println("Error: No hay oficinas en esa ciudad");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void readEmpleadospEdad(int min, int max) {

        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        try (Connection con = DBConnection.getConexion();
                PreparedStatement ps = con
                        .prepareStatement("SELECT nombre, edad FROM empleados WHERE edad BETWEEN ? AND ?")) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nEMPLEADOS ENTRE " + min + " Y " + max + ": ");
            System.out.printf("%-25s %-6s\n", "Nombre", "Edad");
            System.out.println("--------------------------------");

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%-25s %-6d\n", rs.getString("nombre"), rs.getInt("edad"));
            }

            if (!found) {
                System.out.println("Error: no hay ningún empleado con el rango de edad " + min + "/" + max);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> readEmpleados();
                case 2 -> {
                    System.out.print("\nDime una ciudad para filtrar las oficinas: ");
                    sc.nextLine();
                    readOficinaspCiudad(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("\nDime la edad mínima: ");
                    int min = sc.nextInt();
                    System.out.print("Dime la edad máxima: ");
                    int max = sc.nextInt();

                    readEmpleadospEdad(min, max);
                }
                case 4 -> System.out.println("\nSaliendo del programa...");
                default -> System.out.println("\nError: la opcion introducida no es valida");
            }
        } while (opcion != 4);
    }
}
