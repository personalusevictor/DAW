package Ac1MapIntoFichero;

import java.util.Map;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class App {
    static final String URL_FILE = "./Programacion/Ac1MapIntoFichero/ficheros.bin";
    static Map<Integer, Integer> m = new HashMap<>();

    private static void write() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(URL_FILE))) {
            oos.writeObject(m);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private static void read() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(URL_FILE))) {
            m = (Map<Integer, Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static double media() {
        if (m.isEmpty()) {
            return 0;
        }

        Integer numMedia = 0;
        for (Integer i : m.values()) {
            numMedia += i;
        }

        return numMedia / m.size();
    }

    private static void mostrarInvertida() {
        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            System.out.println(e.getValue() + " " + e.getKey());
        }
    }

    public static void main(String[] args) {
        read();
        System.out.println("La media es: " + media());
        mostrarInvertida();
        write();
    }
}