package Tema7_POO.UT7_Gestion_CursosEstudiantes;

import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static void mostrarMenu() {
		System.out.println("\n===== Menu - Gestión de Cursos y Estudiantes ====");
		System.out.println("1.- Crear un curso");
		System.out.println("2.- Crear un estudiante e incribirlo en un curso");
		System.out.println("3.- Mostrar información de un curso");
		System.out.println("4.- Mostrar información de todos los cursos");
		System.out.println("5.- Mostrar información de un estudiante");
		System.out.println("0.- Salir");
		System.out.print("Dime una opcion: ");
	}
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 0 -> System.out.println("Saliendo del programa...");
				default -> System.out.println("Error: El valor introducido es incorrecto");
			}
		} while (opcion != 0);
	}
}
