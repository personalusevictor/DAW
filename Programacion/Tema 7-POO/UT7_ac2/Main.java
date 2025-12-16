package UT7_ac2;

public class Main {
	public static void main(String[] args) {
		Perro perro1 = new Perro("Firulais", "Bulldog Frances");
		Perro perro2 = new Perro("Cometa", "Perro Salchicha", 10, "Negro");
		
		perro1.mostrarInfo();
		perro1.ladrar();
		perro1.comer();
		
		perro2.mostrarInfo();
		perro2.ladrar();
		perro2.comer();
	}
}
