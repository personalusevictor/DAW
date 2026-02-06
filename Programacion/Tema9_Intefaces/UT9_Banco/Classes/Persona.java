package Tema9_Intefaces.UT9_Banco.Classes;

import java.util.*;

import Tema9_Intefaces.UT9_Banco.Interfaces.Cliente;
import Tema9_Intefaces.UT9_Banco.Interfaces.Empleado;

public class Persona implements Cliente, Empleado{
	
	static Scanner sc = new Scanner(System.in);
	
	static final String STRING_DEFAULT = "Desconocido";
	static final double SALDO_DEFAULT = 1.0;
	static final int HORAS_TRABAJAS_DEFAULT = 1;
	
	private final String dni;
	private String nombre;
	private boolean esCliente;
	private boolean esEmpleado;
	private double saldo;
	private int numHorasTrabajadas;
	
	/**
	 * Constructor, para Persona que es Cliente y Empleado
	 *
	 * @param dni
	 * @param nombre nombre de la Persona en cuestión (el nombre no debe ser null o en vacio).
	 * @param saldo saldo de la cuenta del Cliente (el saldo no puede ser negativo o cero).
	 * @param numHorasTrabajadas Numero de las Horas Trabajas del Empleado (el numero de horas trabajadas no puede ser negativo o cero).
	 */
	public Persona(String dni, String nombre, double saldo, int numHorasTrabajadas) {
		this.dni = dni;
		setNombre(nombre);
		setSaldo(saldo);
		setNumHorasTrabajadas(numHorasTrabajadas);
		
		setEsCliente(true);
		setEsEmpleado(true);
	}
	
	/**
	 * Constructor, para Persona que es Cliente
	 *
	 * @param dni
	 * @param nombre nombre de la Persona en cuestión (el nombre no debe ser null o en vacio).
	 * @param saldo saldo de la cuenta del Cliente (el saldo no puede ser negativo o cero).
	 */
	public Persona(String dni, String nombre, double saldo) {
		this.dni = dni;
		setNombre(nombre);
		setSaldo(saldo);
		setEsCliente(true);
	}
	
	/**
	 * Constructor, para Persona que es Empleado
	 *
	 * @param dni
	 * @param nombre nombre de la Persona en cuestión (el nombre no debe ser null o en vacio).
	 * @param numHorasTrabajadas Numero de las Horas Trabajas del Empleado (el numero de horas trabajadas no puede ser negativo o cero).
	 */
	public Persona(String dni, String nombre, int numHorasTrabajadas) {
		this.dni = dni;
		this.nombre = nombre;
		setNumHorasTrabajadas(numHorasTrabajadas);
		setEsEmpleado(true);
	}
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
				System.out.println("Error: el nombre no es valido, inicializado a'"+STRING_DEFAULT+"'");
				this.nombre = STRING_DEFAULT;
		} else {
				this.nombre = nombre;
		}
	}

	public boolean isEsCliente() {
		return esCliente;
	}

	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}

	public boolean isEsEmpleado() {
		return esEmpleado;
	}

	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		if (saldo <= 0) {
				System.out.println("Error: el saldo no es valido, inicializado a'"+SALDO_DEFAULT+"'");
				this.saldo = SALDO_DEFAULT;
		} else {
				this.saldo = saldo;
		}
	}

	public int getNumHorasTrabajadas() {
		return numHorasTrabajadas;
	}

	public void setNumHorasTrabajadas(int numHorasTrabajadas) {
		if (numHorasTrabajadas <= 0) {
				System.out.println("Error: el numHorasTrabajadas no es valido, inicializado a'"+HORAS_TRABAJAS_DEFAULT+"'");
				this.numHorasTrabajadas = HORAS_TRABAJAS_DEFAULT;
		} else {
				this.numHorasTrabajadas = numHorasTrabajadas;
		}
	}
	
	public void incrementarHoras() {
		System.out.print("Cuantas horas más has trabajado: ");
		setNumHorasTrabajadas(numHorasTrabajadas + sc.nextInt());
	}
	
	public void incrementarSaldo() {
		System.out.print("Cuanto quieres incrementar tu saldo de la cuenta: ");
		setSaldo(saldo + sc.nextDouble());
	}
	
	@Override
	public String toString() {
		String persona = String.format("\n=== Información ===\nDNI: %s\nNombre: %s\n", dni, nombre);
		
			if (esCliente && esEmpleado) {
				return persona + String.format("Saldo de la Cuenta: %.2f\nNumero de horas Trabajadas: %d h\n",saldo, numHorasTrabajadas);
			} else if (esCliente) {
				return persona + String.format("Saldo de la Cuenta: %.2f\n",saldo);
			} else {
				return persona + String.format("Numero de horas Trabajadas: %d h\n",numHorasTrabajadas);
			}
	}
	
	
}