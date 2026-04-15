package Tema11_Colecciones.UT11_leeCadena;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
       public static void main(String[] args) {

        List<Character> lista = leeCadena();

        System.out.println("Lista de caracteres:");
        System.out.println(lista);
    }

    // Función pedida
    public static List<Character> leeCadena() {

        Scanner sc = new Scanner(System.in);
        List<Character> lista = new ArrayList<>();

        System.out.print("Introduce una cadena: ");
        String cadena = sc.nextLine();

        // Convertir String a lista de caracteres
        for (int i = 0; i < cadena.length(); i++) {
            lista.add(cadena.charAt(i));
        }

        sc.close();
        return lista;

    }
}
