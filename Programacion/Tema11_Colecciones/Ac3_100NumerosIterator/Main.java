package Tema11_Colecciones.Ac3_100NumerosIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();

        // Insertar 100 números entre 1 y 10
        for (int i = 0; i < 100; i++) {
            numeros.add(random.nextInt(10) + 1);
        }

        // Mostrar colección antes
        System.out.println("Antes de eliminar:");
        System.out.println(numeros);

        // Eliminar los 5 usando Iterator
        Iterator<Integer> it = numeros.iterator();

        while (it.hasNext()) {
            if (it.next() == 5) {
                it.remove();
            }
        }

        // Mostrar colección después
        System.out.println("Después de eliminar los 5:");
        System.out.println(numeros);
    }
}