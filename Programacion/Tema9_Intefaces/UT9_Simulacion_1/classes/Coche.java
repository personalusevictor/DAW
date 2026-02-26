package Tema9_Intefaces.UT9_Simulacion_1.classes;

import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Vehiculo;

public class Coche implements Vehiculo {
	static final int INT_DEFAULT = 0;
	
	private int velocidadActual;
	
	public Coche(int velocidadActual) {
		setVelocidadActual(velocidadActual);	
	}
	
	public void setVelocidadActual(int velocidadActual) {
		if (velocidadActual <= 0) {
				System.out.println("Error: la velocidad actual no es valida, inicializadola a'"+INT_DEFAULT+"'");
				this.velocidadActual = INT_DEFAULT;
		} else {
				this.velocidadActual = velocidadActual;
		}
	}
	
	public int getVelocidadActual() {
		return velocidadActual;
	}
	
	public void acelerar(int velocidad) {
		velocidadActual = velocidadActual + velocidad;
	}
	public void frenar() {
		System.out.println("Estoy frenando");
		velocidadActual = velocidadActual/2;
	}
	
	@Override
	public void detener() {
		velocidadActual = 0;
		Vehiculo.super.detener();
		System.out.println("La velocidad actual del vehículo es: "+velocidadActual);
	}
}
