package Tema11_Colecciones.Ac10_ConjuntoClientes;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
        public static void main(String[] args) {

        // Conjunto original (sin orden)
        Set<Cliente> conjuntoClientes = new HashSet<>();

        conjuntoClientes.add(new Cliente("123A", "Juan", "01/01/2000"));
        conjuntoClientes.add(new Cliente("456B", "Ana", "15/05/1995"));
        conjuntoClientes.add(new Cliente("789C", "Luis", "20/10/2002"));

        // 🔽 Ordenados por EDAD
        Set<Cliente> porEdad = new TreeSet<>(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.edad() - c2.edad();
            }
        });

        porEdad.addAll(conjuntoClientes);

        // 🔽 Ordenados por NOMBRE
        Set<Cliente> porNombre = new TreeSet<>(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente c1, Cliente c2) {
                return c1.nombre.compareTo(c2.nombre);
            }
        });

        porNombre.addAll(conjuntoClientes);

        // Mostrar resultados
        System.out.println("Ordenados por edad:");
        System.out.println(porEdad);

        System.out.println("Ordenados por nombre:");
        System.out.println(porNombre);
    }
}
