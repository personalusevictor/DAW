package Tema11_Colecciones.Ac13_SociosClub;

import java.io.*;
import java.util.*;

public class ClubSocios {

    private static final String FICHERO = "socios.dat";
    private static Set<Socio> socios = new HashSet<>();

    public static void main(String[] args) {
        cargarDatos();

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE SOCIOS ---");
            System.out.println("1. Alta socio");
            System.out.println("2. Baja socio");
            System.out.println("3. Modificar socio");
            System.out.println("4. Listar por nombre");
            System.out.println("5. Listar por antigüedad");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> alta(sc);
                case 2 -> baja(sc);
                case 3 -> modificar(sc);
                case 4 -> listarPorNombre();
                case 5 -> listarPorAntiguedad();
                case 6 -> guardarDatos();
            }

        } while (opcion != 6);

        sc.close();
    }

    // ---------------- ALTA ----------------
    static void alta(Scanner sc) {
        System.out.print("DNI: ");
        String dni = sc.nextLine();

        if (buscar(dni) != null) {
            System.out.println("Ya existe un socio con ese DNI.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Fecha alta (dd/MM/yyyy): ");
        String fecha = sc.nextLine();

        socios.add(new Socio(dni, nombre, fecha));
        System.out.println("Socio añadido.");
    }

    // ---------------- BAJA ----------------
    static void baja(Scanner sc) {
        System.out.print("DNI del socio a eliminar: ");
        String dni = sc.nextLine();

        Socio s = buscar(dni);
        if (s != null) {
            socios.remove(s);
            System.out.println("Socio eliminado.");
        } else {
            System.out.println("No existe ese socio.");
        }
    }

    // ---------------- MODIFICACIÓN ----------------
    static void modificar(Scanner sc) {
        System.out.print("DNI del socio a modificar: ");
        String dni = sc.nextLine();

        Socio s = buscar(dni);
        if (s == null) {
            System.out.println("No existe ese socio.");
            return;
        }

        System.out.print("Nuevo nombre: ");
        s.nombre = sc.nextLine();

        System.out.println("Socio actualizado.");
    }

    // ---------------- LISTAR POR NOMBRE ----------------
    static void listarPorNombre() {
        List<Socio> lista = new ArrayList<>(socios);
        lista.sort(Comparator.comparing(s -> s.nombre));

        System.out.println("\n--- SOCIOS POR NOMBRE ---");
        lista.forEach(System.out::println);
    }

    // ---------------- LISTAR POR ANTIGÜEDAD ----------------
    static void listarPorAntiguedad() {
        List<Socio> lista = new ArrayList<>(socios);
        lista.sort(Comparator.comparing(Socio::antiguedad).reversed());

        System.out.println("\n--- SOCIOS POR ANTIGÜEDAD ---");
        lista.forEach(System.out::println);
    }

    // ---------------- BUSCAR ----------------
    static Socio buscar(String dni) {
        for (Socio s : socios) {
            if (s.dni.equals(dni)) {
                return s;
            }
        }
        return null;
    }

    // ---------------- FICHERO: GUARDAR ----------------
    static void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(FICHERO))) {

            out.writeObject(socios);
            System.out.println("Datos guardados.");

        } catch (IOException e) {
            System.out.println("Error guardando datos.");
        }
    }

    // ---------------- FICHERO: CARGAR ----------------
    @SuppressWarnings("unchecked")
    static void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(FICHERO))) {

            socios = (Set<Socio>) in.readObject();
            System.out.println("Datos cargados.");

        } catch (Exception e) {
            System.out.println("No hay datos previos.");
            socios = new HashSet<>();
        }
    }
}