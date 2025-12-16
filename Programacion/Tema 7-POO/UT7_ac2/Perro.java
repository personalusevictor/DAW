package UT7_ac2;

public class Perro {
		
	//Atributos
	String nombre, raza, color;
	int edad;
	
	//Constructores
	Perro() {}
	
	Perro(String nombre, String raza) {
		this(nombre, raza, 0, null);
	}
	
	Perro(String nombre, String raza, int edad, String color) {
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.color = color;
	}
	
	void ladrar() {
		System.out.println("El perro " + nombre + " está ladrando");
	}
	
	void comer() {
		System.out.println("El perro " + nombre + " está comiendo");
	}
	
	void mostrarInfo() {
		System.out.println("--- Información de Perros ---");
		System.out.println("Nombre: " + nombre);
		System.out.println("Raza: " + raza);
		System.out.println("Edad: " + edad);
		System.out.println("Color: " + color);
		System.out.println("------------------------- \n");
	}
}
