import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static void mostrarMenu() {
		System.out.println("\nMenu - appVehiculos");
		System.out.println("1.- Crear Motocicleta");
		System.out.println("2.- Crear Automovil");
		System.out.println("3.- Mostrar Información");
		System.out.print("Dime que opcion quieres elegir: ");
	}
	public static void main(String[] args) {
		Vehiculo[] appVehiculos = new Vehiculo[0];
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1 -> {
					appVehiculos = Arrays.copyOf(appVehiculos, appVehiculos.length + 1);
					System.out.print("De que marca es la Motocicleta: ");
					String marca = sc.next();
					System.out.print("De que modelo es la Motocicleta: ");
					String modelo = sc.next();
					System.out.print("De que año es la Motocicleta: ");
					int año = sc.nextInt();
					System.out.print("De que tipo es la Motocicleta: ");
					String tipo = sc.next();
					appVehiculos[appVehiculos.length - 1] = new Motocicleta(marca, modelo, año, tipo);
				}
			
				case 2 -> {
					appVehiculos = Arrays.copyOf(appVehiculos, appVehiculos.length + 1);
					System.out.print("De que marca es el Automovil: ");
					String marca = sc.next();
					System.out.print("De que modelo es el Automovil: ");
					String modelo = sc.next();
					System.out.print("De que año es el Automovil: ");
					int año = sc.nextInt();
					System.out.print("Cuentas puertas tiene el Automovil: ");
					int puertas = sc.nextInt();
					appVehiculos[appVehiculos.length - 1] = new Automovil(marca, modelo, año, puertas);
				}
				case 3 -> {
					for(int i=0; i<appVehiculos.length; i++) {
						System.out.println(appVehiculos[i]);
					}
				}
				case 0 -> System.out.println("Saliendo del programa...");
			}
			
		} while (opcion != 0);
	}
}
