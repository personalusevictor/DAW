package Tema11_Colecciones.UT11_Metodo_Generico;

import java.util.Arrays;

public class ArrayUtils {
    public static <T> T[] concatenar(T[] arr1, T[] arr2) {
        T[] resultado = Arrays.copyOf(arr1, arr1.length + arr2.length);
        System.arraycopy(arr2, 0, resultado, arr1.length, arr2.length);
        
        return resultado;
    }
    public static void main(String[] args) {
        String[] a1 = {"Hola", "Mundo!"};
        String[] a2 = {"Adios", "Mundo!"};
        String[] result = concatenar(a1, a2);
        System.out.println(Arrays.toString(result));
    }
}