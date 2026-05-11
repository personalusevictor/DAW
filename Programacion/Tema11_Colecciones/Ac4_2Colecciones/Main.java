package Tema11_Colecciones.Ac4_2Colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Double> positivos = new ArrayList<>();
        ArrayList<Double> negativos = new ArrayList<>();

        double num;

        // Leer números hasta que se introduzca 0
        do {
            System.out.print("Introduce un número (0 para terminar): ");
            num = sc.nextDouble();

            if (num > 0) {
                positivos.add(num);
            } else if (num < 0) {
                negativos.add(num);
            }

        } while (num != 0);

        // Mostrar colecciones
        System.out.println("\nPositivos: " + positivos);
        System.out.println("Negativos: " + negativos);

        // Calcular sumas
        double sumaPos = 0;
        double sumaNeg = 0;

        for (double n : positivos) {
            sumaPos += n;
        }

        for (double n : negativos) {
            sumaNeg += n;
        }

        System.out.println("Suma positivos: " + sumaPos);
        System.out.println("Suma negativos: " + sumaNeg);

        // Eliminar valores >10 o < -10 usando Iterator
        Iterator<Double> itPos = positivos.iterator();
        while (itPos.hasNext()) {
            double n = itPos.next();
            if (n > 10) {
                itPos.remove();
            }
        }

        Iterator<Double> itNeg = negativos.iterator();
        while (itNeg.hasNext()) {
            double n = itNeg.next();
            if (n < -10) {
                itNeg.remove();
            }
        }

        // Mostrar colecciones finales
        System.out.println("\nDespués de eliminar valores fuera de rango:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);

        sc.close();
    }
}
