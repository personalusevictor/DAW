package Tema11_Colecciones.Ac14_RepuestoAutomoviles;

import java.io.*;
import java.util.*;

public class TiendaRepuestos {

    private static final String FICHERO = "stock.dat";
    private static Map<String, Integer> stock = new HashMap<>();

    public static void main(String[] args) {
        cargarDatos();

        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n--- TIENDA DE REPUESTOS ---");
            System.out.println("1. Alta producto");
            System.out.println("2. Baja producto");
            System.out.println("3. Actualizar stock");
            System.out.println("4. Mostrar productos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1 -> alta(sc);
                case 2 -> baja(sc);
                case 3 -> actualizar(sc);
                case 4 -> mostrar();
                case 5 -> guardarDatos();
            }

        } while (op != 5);

        sc.close();
    }

    // ---------------- ALTA ----------------
    static void alta(Scanner sc) {
        System.out.print("Código producto: ");
        String codigo = sc.nextLine();

        if (stock.containsKey(codigo)) {
            System.out.println("El producto ya existe.");
            return;
        }

        System.out.print("Unidades iniciales: ");
        int unidades = Integer.parseInt(sc.nextLine());

        stock.put(codigo, unidades);
        System.out.println("Producto añadido.");
    }

    // ---------------- BAJA ----------------
    static void baja(Scanner sc) {
        System.out.print("Código producto: ");
        String codigo = sc.nextLine();

        if (stock.remove(codigo) != null) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No existe ese producto.");
        }
    }

    // ---------------- ACTUALIZAR STOCK ----------------
    static void actualizar(Scanner sc) {
        System.out.print("Código producto: ");
        String codigo = sc.nextLine();

        if (!stock.containsKey(codigo)) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Nuevo stock: ");
        int unidades = Integer.parseInt(sc.nextLine());

        stock.put(codigo, unidades);
        System.out.println("Stock actualizado.");
    }

    // ---------------- MOSTRAR ----------------
    static void mostrar() {
        System.out.println("\n--- INVENTARIO ---");

        if (stock.isEmpty()) {
            System.out.println("No hay productos.");
            return;
        }

        for (Map.Entry<String, Integer> e : stock.entrySet()) {
            System.out.println("Código: " + e.getKey() +
                    " | Stock: " + e.getValue());
        }
    }

    // ---------------- GUARDAR ----------------
    static void guardarDatos() {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(FICHERO))) {

            out.writeObject(stock);
            System.out.println("Datos guardados.");

        } catch (IOException e) {
            System.out.println("Error al guardar.");
        }
    }

    // ---------------- CARGAR ----------------
    @SuppressWarnings("unchecked")
    static void cargarDatos() {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(FICHERO))) {

            stock = (Map<String, Integer>) in.readObject();
            System.out.println("Datos cargados.");

        } catch (Exception e) {
            System.out.println("No hay datos previos.");
            stock = new HashMap<>();
        }
    }
}