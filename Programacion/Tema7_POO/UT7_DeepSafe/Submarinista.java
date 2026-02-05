package Tema7_POO.UT7_DeepSafe;
import java.util.*;

public class Submarinista {
	static Scanner sc = new Scanner(System.in);
	
	private String nombre;
	private int oxigeno;
	private double profundidad;
	
	Submarinista(String nombre, int oxigeno, double profundidad) {
		setNombre(nombre);
		setOxigeno(oxigeno);
		setProfundidad(profundidad);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		while (nombre == null || nombre.trim().isEmpty()) {
			System.out.println("Error: El nombre introducido no es valido");
			System.out.print("Ingresa un nombre valido: ");
			nombre = sc.next();
		}
		this.nombre = nombre;
	}
	
	public int getOxigeno() {
		return oxigeno;
	}
	
	public void setOxigeno(int oxigeno) {
		if (oxigeno > 100) {
			this.oxigeno = 100;
		} else if (oxigeno < 0) {
			this.oxigeno = 0;
		} else {
			this.oxigeno = oxigeno;
		}
		
		if (oxigeno <= 20) {
			System.out.println("¡ALERTA! Nivel de oxigeno crítico");
		}
		
	}
	
	public double getProfundidad() {
		return profundidad;
	}
	
	public void setProfundidad(double profundidad) {
		if(profundidad < 0) {
			this.profundidad = 0;
		} else if (profundidad > 40) {
			this.profundidad = 40;
			System.out.println("Se ha alcanzado el limite de buceo recreativo");
		}
	}
	
	public void sumergirse(double metros) {
			if (metros <= 0) {
					System.out.println("La distancia a sumergir debe ser positiva.");
					return;
			}
	
			profundidad += metros;
	
			double perdida = (metros / 2.0) * 1.0;
	
			oxigeno -= perdida;
	
			if (oxigeno < 0) {
					oxigeno = 0;
			}
	
			System.out.println("Te has sumergido " + metros + " metros.");
			System.out.println("Profundidad actual: " + profundidad + " m");
			System.out.println("Oxígeno restante: " + oxigeno + "%");
	
	}
	
}
