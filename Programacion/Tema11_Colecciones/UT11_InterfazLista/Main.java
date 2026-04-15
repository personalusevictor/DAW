package Tema11_Colecciones.UT11_InterfazLista;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        int num;

        // Leer números hasta que se introduzca uno negativo
        do {
            System.out.print("Introduce un número (negativo para terminar): ");
            num = sc.nextInt();

            if (num >= 0) {
                lista.add(num);
            }

        } while (num >= 0);

        // Recorrer la lista
        System.out.println("\nÍndices de números pares multiplicados por 100:");

        for (int i = 0; i < lista.size(); i++) {
            int valor = lista.get(i);

            if (valor % 2 == 0) {
                System.out.println("Índice: " + i + " → " + (valor * 100));
            }
        }

        sc.close();
    }
}
