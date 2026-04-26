package Tema11_Colecciones.Ac6_MetodosArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {
        public static void main(String[] args) {

        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();

        // Insertar 20 números aleatorios (por ejemplo 1–100)
        for (int i = 0; i < 20; i++) {
            lista.add(random.nextInt(100) + 1);
        }

        System.out.println("Lista original:");
        System.out.println(lista);

        // 🔽 ORDENAR DE MENOR A MAYOR

        // Convertir a array
        Integer[] array = lista.toArray(new Integer[0]);

        // Ordenar array
        Arrays.sort(array);

        // Volver a colección
        lista = new ArrayList<>(Arrays.asList(array));

        System.out.println("\nOrdenado de menor a mayor:");
        System.out.println(lista);

        // 🔽 ORDENAR DE MAYOR A MENOR

        // Convertir otra vez a array
        array = lista.toArray(new Integer[0]);

        // Ordenar al revés
        Arrays.sort(array, Collections.reverseOrder());

        // Volver a colección
        lista = new ArrayList<>(Arrays.asList(array));

        System.out.println("\nOrdenado de mayor a menor:");
        System.out.println(lista);
    }
}
