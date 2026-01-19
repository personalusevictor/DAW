class Persona {
	private String nombre, dni;
	private int edad;
	private static int totalPersonas;
	
	public Persona(String nombre){
		this(nombre, 0, null);
	}
	
	public Persona(String nombre, int edad) {
		this(nombre, edad, null);
	}
	
	public Persona(String nombre, int edad, String dni) {
		this.nombre = nombre;
		this.edad = edad<0 ? 0 : edad;
		this.dni = dni;
		totalPersonas++;
	}
	
	public String toString() {
		return "Nombre: " +nombre+"\nEdad: "+edad+"\nDNI: "+(dni == null ? "DNI no asignado" : dni);
	}
	
	public static int getTotalPersonas() {
		return totalPersonas;
	}
	
}

public class AC2_Constructores_this {
	public static void main(String[] args) {
	}
}
