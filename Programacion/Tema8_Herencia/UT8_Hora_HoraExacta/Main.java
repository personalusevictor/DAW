package Tema8_Herencia.UT8_Hora_HoraExacta;

import java.util.*;

public class Main {
	static void mostrarMenu() {
		System.out.println("\n=== Menu | Actividad Hora | ===");
		System.out.println("1.- Incrementar minuto");
		System.out.println("2.- Incrementar segundos");
		System.out.println("3.- Mostrar hora");
		System.out.println("4.- Igualar horas");
		System.out.println("5.- Salir");
		System.out.print("Dime una opcion: ");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		System.out.println("\nVamos a hacer un reloj incremental por cada minuto");
		System.out.print("Dime la hora: ");
		int hora = sc.nextInt();
		System.out.print("Dime los minutos: ");
		int minutos = sc.nextInt();
		System.out.print("Dime los segundos: ");
		int segundos = sc.nextInt();
		
		HoraExacta reloj = new HoraExacta(hora, minutos, segundos);
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			switch (opcion) {
				case 1 -> reloj.inc();			
				case 2 -> reloj.incSegundos();
				case 3 -> System.out.println(reloj);
				case 4 -> {
					System.out.print("Que hora deseas igualar con la hora actual: ");
				}
				case 5 -> System.out.println("Saliendo del programa...");
				default -> System.out.println("Error: la opcion introducida no es valida");
			}
		} while (opcion != 4);
		
		sc.close();
		
	}	
}
