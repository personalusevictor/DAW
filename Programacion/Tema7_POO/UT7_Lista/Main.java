package Tema7_POO.UT7_Lista;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Lista lista = new Lista();
		int opcion;

		do {
			System.out.println("\n--- MENÚ LISTA ---");
			System.out.println("1. Insertar al final");
			System.out.println("2. Insertar al inicio");
			System.out.println("3. Insertar en índice");
			System.out.println("4. Eliminar por índice");
			System.out.println("5. Obtener elemento");
			System.out.println("6. Buscar número");
			System.out.println("7. Mostrar lista");
			System.out.println("8. Concatenar listas");
			System.out.println("0. Salir");
			System.out.print("Opción: ");

			opcion = sc.nextInt();

			switch (opcion) {

				case 1:
					System.out.print("Número: ");
					lista.insertarFinal(sc.nextInt());
					break;

				case 2:
					System.out.print("Número: ");
					lista.insertarInicio(sc.nextInt());
					break;

				case 3:
					System.out.print("Índice: ");
					int indice = sc.nextInt();
					System.out.print("Número: ");
					int numero = sc.nextInt();
					lista.insertarEnIndice(indice, numero);
					break;

				case 4:
					System.out.print("Índice: ");
					lista.eliminar(sc.nextInt());
					break;

				case 5:
					System.out.print("Índice: ");
					Integer elemento = lista.getElemento(sc.nextInt());
					if (elemento != null) {
						System.out.println("Elemento: " + elemento);
					} else {
						System.out.println("Índice incorrecto");
					}
					break;

				case 6:
					System.out.print("Número: ");
					int pos = lista.buscar(sc.nextInt());
					System.out.println("Posición: " + pos);
					break;

				case 7:
					System.out.println(lista);
					break;
				
				case 8:
					System.out.println("Vamos a crear la lista2 para concatenarla a la lista creada anteriormente: ");
					Lista lista2 = new Lista();
					for(int i = 0; i<10; i++) {
						lista2.insertarFinal((int)(Math.random()*999));
					}
					System.out.println(lista2);
					Lista.concatena(lista, lista2);
					break;
					
				case 0:
					System.out.println("Programa finalizado");
					break;

				default:
					System.out.println("Opción no válida");
			}

		} while (opcion != 0);

		sc.close();
	}
}
