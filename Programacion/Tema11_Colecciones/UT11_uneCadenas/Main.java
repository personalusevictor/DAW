package Tema11_Colecciones.UT11_uneCadenas;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {

        List<Character> cad1 = new ArrayList<>();
        cad1.add('H');
        cad1.add('o');
        cad1.add('l');
        cad1.add('a');

        List<Character> cad2 = new ArrayList<>();
        cad2.add('!');
        cad2.add('!');

        List<Character> resultado = uneCadenas(cad1, cad2);

        System.out.println(resultado);
    }

    // Función pedida
    public static List<Character> uneCadenas(List<Character> cad1, List<Character> cad2) {

        List<Character> resultado = new ArrayList<>();

        // Añadir primera lista
        resultado.addAll(cad1);

        // Añadir segunda lista
        resultado.addAll(cad2);

        return resultado;
    }
}
