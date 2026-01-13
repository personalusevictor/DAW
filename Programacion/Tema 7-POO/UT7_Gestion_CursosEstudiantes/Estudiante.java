package UT7_Gestion_CursosEstudiantes;

public class Estudiante {
	private String nombre;
	private int edad;
	private double promedio;
	
	Estudiante (String nombre, int edad, double promedio) {
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setPromedio(promedio);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == null || nombre.trim().isEmpty()) {
			System.out.println("Error: El nombre no es valido");
		} else {
			this.nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1);
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad < 0 || edad > 150) {
			System.out.println("Error: La edad no es valida");
		} else {
			this.edad = edad;
		}
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		if(promedio <= 0 || promedio > 10.00) {
			System.out.println("Error: El promedio de calificaciones debe estar entre 0 y 10");
		} else {
		this.promedio = promedio;
		}
	}
	
	public void mostrarInformacion() {
		System.out.println("Nombre: " +getNombre());
		System.out.println("Edad: " +getEdad());
		System.out.println("Promedio de calificaciones: " +getPromedio());
	}
}
