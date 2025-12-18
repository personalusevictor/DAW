package UT7_ac1;
import java.util.*;
public class Main {
	static final Scanner sc = new Scanner(System.in);
	
		/*  ----------------------
		FUNCION - MOSTRAR MENU
	    ---------------------- */
	static void mostrarMenu() {
		System.out.println("Banco de Víctor - Cuenta Corriente");
		System.out.println("1.- Crear Cuenta");
		System.out.println("2.- Sacar Dinero");
		System.out.println("3.- Ingresar Dinero");
		System.out.println("4.- Mostrar Información");
		System.out.println("5.- Modificar Banco");
		System.out.println("0.- Salir");
		System.out.print("Que opción deseas elegir: ");
	}

	public static void main(String[] args) {
		int opcion;
		
		do {
			System.out.println();
			mostrarMenu();
			opcion = sc.nextInt();
			System.out.println();
			
			switch(opcion) {
				case 1 -> CuentaCorriente.crearCuenta();
				case 2 -> CuentaCorriente.sacarDinero();
				case 3 -> CuentaCorriente.ingresarDinero();
				case 4 -> CuentaCorriente.mostrarInformacion();
				case 5 -> {
					System.out.println("Vas a modificar el nombre del banco, como se llama el nombre del nuevo banco: ");
					CuentaCorriente.setNombreBanco(sc.next());
				}
				case 0 -> System.out.println("Saliendo del programa...");
			}
		} while (opcion != 0);
	}
}
