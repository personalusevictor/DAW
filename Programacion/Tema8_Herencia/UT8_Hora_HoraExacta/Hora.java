package Tema8_Herencia.UT8_Hora_HoraExacta;

import java.util.*;

public class Hora {
	Scanner sc = new Scanner(System.in);
	
	protected int hora, minutos;
	
	Hora(int hora, int minutos) {
		while(!this.setHora(hora)) {
			System.out.println("Error: La hora no es valida");
			System.out.print("Diga una hora valida: ");
			hora = sc.nextInt();
		}
		
		while(!this.setMinutos(minutos)) {
			System.out.println("\nError: Los minutos no son validos");
			System.out.print("Diga unos minutos validos: ");
			minutos = sc.nextInt();
		}
			
	}

	public int getHora() {
		return hora;
	}

	public boolean setHora(int hora) {
		if (hora < 0 || hora > 23) {
			return false;
		} else {
			this.hora = hora;
			return true;
		}
	}

	public int getMinutos() {
		return minutos;
	}

	public boolean setMinutos(int minutos) {
		if(minutos < 0 || minutos > 59) {
			return false;
		} else {
			this.minutos = minutos;
			return true;
		}
	}
	
	public void inc() {
		minutos++;
		
		if(minutos > 59) {
			hora++;
			minutos = 0;
			if (hora > 23) {
				hora = 0; 
			}
		}
	}
	
	
	public String toString() {
		return String.format("%02d:%02d", getHora(), getMinutos());
	}
}
