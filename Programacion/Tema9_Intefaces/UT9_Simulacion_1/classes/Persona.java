package Tema9_Intefaces.UT9_Simulacion_1.classes;

public class Persona implements Comparable{
	static final String STRING_DEFAULT = "Desconocido";
	static final int INT_DEFAULT = 18;
	
	private String nombre;
	private int edad;
	
	public Persona(String nombre, int edad) {
		setNombre(nombre);
		setEdad(edad);
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
				System.out.println("Error: la edad no es valida, inicializadola a'"+INT_DEFAULT+"'");
				this.edad = INT_DEFAULT;
		} else {
				this.edad = edad;
		}
	}

	@Override
	public String toString() {
			return String.format("%n%n=====================%n=== Información Persona ===%nNombre: %s%nEdad: %d%n", nombre, edad);
	}
	
	@Override
	public int compareTo(Object obj) {
			return (edad - ((Persona)obj).edad)*-1;
	}
	
	
	
}
