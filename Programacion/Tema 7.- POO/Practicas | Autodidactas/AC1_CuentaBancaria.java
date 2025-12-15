import java.util.*;

class CuentaBancaria {
	
	private String titular;
	private double sueldo;
	
	public CuentaBancaria(String titular) {
		this.titular = titular;
		this.sueldo = 0;
	}
	
	public void ingresarDinero(double cantidadIngresar) {
		if(cantidadIngresar <=0) {
			System.out.println("Error: No puedes ingresar una cantidad menor o igual a 0€");
		} else {
			sueldo += cantidadIngresar;
		}
	}
	
	public void sacarDinero(double sueldoSacar) {
		if(sueldoSacar <= 0) {
			System.out.println("Error: No puedes sacar una cantidad menor o igual a 0€");
		} else if(sueldoSacar > sueldo) {
			System.out.println("Error: No puedes sacar una cantidad mayor a tu sueldo actual");
		} else {
			sueldo -= sueldoSacar;
		}
	}
	
	public double getSaldo() {
		return sueldo;
	}
	
	
	public String toString(){
		return "- Información de la cuenta -\nTitular: "+titular+"\nSueldo: "+sueldo+"$";
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
				case 1 -> {
					System.out.print("Que cantidad deseas ingresar: ");
					cuenta.ingresarDinero(sc.nextDouble());
					
				}
				case 2 -> {
					System.out.print("Que cantidad deseas sacar: ");
					cuenta.sacarDinero(sc.nextDouble());
				}
				case 3 -> System.out.println(cuenta);
				case 0 -> System.out.println("Saliendo del programa...");
				default -> System.out.println("Error: Valor invalido");
			}
		} while (opcion != 0);
	}
}