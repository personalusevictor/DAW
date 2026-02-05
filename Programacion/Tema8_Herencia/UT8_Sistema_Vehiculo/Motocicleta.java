package Tema8_Herencia.UT8_Sistema_Vehiculo;

import java.util.*;

public class Motocicleta extends Vehiculo{
	Scanner sc = new Scanner(System.in);
	private String tipo;
	
	Motocicleta(String marca, String modelo, int año, String tipo) {
		super(marca, modelo, año);
		setTipo(tipo);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		while(tipo == null || tipo.trim().isEmpty() || (!tipo.equalsIgnoreCase("deportiva") && !tipo.equalsIgnoreCase("crucero")) ) {
			System.out.println("\nError: El tipo de motocicleta no es valida");
			System.out.print("Introduzca un tipo de motocicleta valida: ");
			tipo = sc.next();
		}
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nEl tipo de moto es: %s", tipo);
	}
}
