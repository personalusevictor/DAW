package Tema11_Colecciones.Ac5_MetodosGlobales;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numeros = generarNumeros();
        
        System.out.println("Antes de eliminar:");
        mostrarLista(numeros);

        eliminarCincos(numeros);

        System.out.println("Después de eliminar los 5:");
        mostrarLista(numeros);
    }

    // Método para generar los números
    public static ArrayList<Integer> generarNumeros() {
        ArrayList<Integer> lista = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            lista.add(random.nextInt(10) + 1);
        }

        return lista;
    }

    // Método para eliminar los 5 usando Iterator
    public static void eliminarCincos(ArrayList<Integer> lista) {
        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()) {
            if (it.next() == 5) {
                it.remove();
            }
        }
    }

    // Método para mostrar la lista
    public static void mostrarLista(ArrayList<Integer> lista) {
        System.out.println(lista);
    }
}
