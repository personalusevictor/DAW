import java.util.*;

class CuentaBancaria {
	
	static final Scanner sc = new Scanner(System.in);
	
	String titular;
	double sueldo;
	
	CuentaBancaria() {}
	CuentaBancaria(String titular) {
		this.titular = titular;
		this.sueldo = 0;
	}
	
	double ingresarDinero() {
		double sueldoIngresar;
		
		System.out.print("Cuanto dinero deseas ingresar: ");
		sueldoIngresar = sc.nextDouble();
		
		if(sueldoIngresar <= 0) {
			System.out.println("Error: No puedes ingresar un cantidad menor o igual a 0€");
			return 0;
		} else {
			return sueldoIngresar;
		}
	}
	
	double sacarDinero(double sueldo) {
		double sueldoSacar;
		
		System.out.print("Cuanto dinero deseas sacar: ");
		sueldoSacar = sc.nextDouble();
		
		if(sueldoSacar <= 0) {
			System.out.println("Error: No puedes sacar una cantidad menor o igual a 0€");
		} else if(sueldoSacar > sueldo) {
			System.out.println("Error: No puedes sacar una cantidad mayor a tu sueldo actual");
		} else {
			CuentaBancaria cuenta = new CuentaBancaria();
			cuenta.sueldo -= sueldoSacar;
			return sueldoSacar;
		}
		return 0;
	}
	
	void mostrarInfo(String titular, double sueldo) {
		System.out.println("- Información de la cuenta -");
		System.out.println("Titular: "+titular);
		System.out.println("Sueldo: "+sueldo+"€");
	}
}

public class AC1_CuentaBancaria {
	
	static final Scanner sc = new Scanner(System.in);
	
	static void mostrarMenu(){
		System.out.println("Menu - Cuenta Bancaría");
		System.out.println("1.- Ingresar Dinero");
		System.out.println("2.- Sacar Dinero");
		System.out.println("3.- Mostrar Información");
		System.out.println("0.- Salir");
		System.out.print("Que opción deseas elegir: ");
	}
	
	public static void main(String[] args) {
		String titular;
		int opcion;
		
		System.out.print("Dime cual es tu nombre, el cual será el nombre del titular: ");		
		titular = sc.next();
		
		CuentaBancaria cuenta = new CuentaBancaria(titular);
		System.out.println("Cuenta creada, tu sueldo inicial es de 0");
		
		do {
			System.out.println();
			mostrarMenu();
			opcion = sc.nextInt();
			System.out.println();
			
			switch (opcion) {
				case 1 -> cuenta.sueldo += cuenta.ingresarDinero();
				case 2 -> cuenta.sueldo -= cuenta.sacarDinero(cuenta.sueldo);
				case 3 -> cuenta.mostrarInfo(cuenta.titular, cuenta.sueldo);
				case 0 -> System.out.println("Saliendo del programa...");
				default -> System.out.println("Error: Valor invalido");
			}
		} while (opcion != 0);
	}
}