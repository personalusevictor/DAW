package Tema11_Colecciones.Ac12_NombreOrdenAlfabetico;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> nombres = new TreeSet<>();

        System.out.println("Introduce nombres (escribe 'fin' para terminar):");

        while (true) {
            String entrada = sc.nextLine();

            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            nombres.add(entrada);
        }

        System.out.println("\nNombres en orden alfabético (sin repetidos):");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        sc.close();
    }
}