package Tema11_Colecciones.Ac11_NombreOrdenInserccion;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> nombres = new LinkedHashSet<>();

        System.out.println("Introduce nombres (escribe 'fin' para terminar):");

        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            nombres.add(entrada);
        }

        System.out.println("\nNombres introducidos (sin repetidos y en orden):");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        sc.close();
    }
}