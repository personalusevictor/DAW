package Tema9_Intefaces.UT9_Futbol;

public class Futbolista implements Comparable{
	static final String STRING_DEFAULT = "Desconocido";
	static final int INT_DEFAULT = 0;
	
	private final String dni;
	private String nombre;
	private int edad;
	private int numGoles;
	
	public Futbolista(String dni, String nombre, int edad, int numGoles) {
		this.dni = dni;
		setNombre(nombre);
		setEdad(edad);
		setNumGoles(numGoles);
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad <= 0) {
				System.out.println("Error: la edad no es valida, inicializado a'"+INT_DEFAULT+"'");
				this.edad = INT_DEFAULT;
		} else {
				this.edad = edad;
		}
	}

	public int getNumGoles() {
		return numGoles;
	}

	public void setNumGoles(int numGoles) {
		if (numGoles < 0) {
				System.out.println("Error: el numero de goles no es valido, inicializado a'"+INT_DEFAULT+"'");
				this.numGoles = INT_DEFAULT;
		} else {
				this.numGoles = numGoles;
		}
	}
	
	@Override
	public String toString() {
			return String.format("%n===INFORMACION===%nDNI: %s%nNombre: %s%nEdad: %d%nNumero de Goles: %d%n", dni, nombre, edad, numGoles);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Futbolista) {
			return true;
		}
		
		if (obj == null) {
			return false;
		}
		
		Futbolista otroFutbolista = (Futbolista)obj;
		
		if (dni.equals(otroFutbolista.dni)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Object obj) {
		return dni.compareTo(((Futbolista)obj).dni);
	}
	
	
	
}
