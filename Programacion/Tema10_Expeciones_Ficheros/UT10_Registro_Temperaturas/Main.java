package Tema10_Expeciones_Ficheros.UT10_Registro_Temperaturas;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static Temperaturas[] temperaturas = new Temperaturas[0];
	private static Scanner sc = new Scanner(System.in);
	
	public static void añadirTemperaturas(Temperaturas nuevoRegistro) {
		temperaturas = Arrays.copyOf(temperaturas, temperaturas.length+1);
		temperaturas[temperaturas.length-1] = nuevoRegistro;
		
		try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("Registros.dat"))) {
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	public static void mostrarTemperaturas() {
		System.out.println("--- Registros Historicos ---");
		for (int i = 0; i < temperaturas.length; i++) {
				System.out.println(temperaturas[i]);
		}
	}
	
	public static void mostrarMenu() {
		System.out.println("=== Registros de Temperaturas ===");
		System.out.println("1.- Añadir registro de temperatura");
		System.out.println("2.- Mostrar registros de temperaturas historicos");
		System.out.println("3.- Salir");
		System.out.print("Elige una opción: ");
	}
	
	public static void main(String[] args) {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			
			switch (opcion) {
					case 1 -> {
						System.out.print("Cual es la temperatura que desea registrar: ");
						Temperaturas nuevoRegistro = new Temperaturas(sc.nextInt());
						añadirTemperaturas(nuevoRegistro);
					}
					case 2 -> mostrarTemperaturas();
					case 3 -> System.out.println("Saliendo del programa");
					default -> System.out.println("Error: el valor introducido no es valido");
			}
		} while (opcion != 3);
	}
}
