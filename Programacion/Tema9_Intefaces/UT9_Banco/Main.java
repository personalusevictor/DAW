package Tema9_Intefaces.UT9_Banco;

import Tema9_Intefaces.UT9_Banco.Classes.Persona;

public class Main {
	public static void main(String[] args) {
		Persona personaClienteEmpleado = new Persona("42420057", "Víctor", 1000.0, 8);
		System.out.println(personaClienteEmpleado);
		personaClienteEmpleado.incrementarHoras();
		personaClienteEmpleado.incrementarSaldo();
		System.out.println(personaClienteEmpleado);
		
		Persona personaCliente = new Persona("42420056F", "Luis", 10.0);
		System.out.println(personaCliente);
		personaCliente.incrementarSaldo();
		System.out.println(personaCliente);
		
		Persona personaEmpleado = new Persona("42420055F", "Juan", 7);
		System.out.println(personaEmpleado);
		personaEmpleado.incrementarHoras();
		System.out.println(personaEmpleado);
		
	}
}
