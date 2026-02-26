package Tema9_Intefaces.UT9_Simulacion_1.classes;

import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Corredor;
import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Nadador;
import Tema9_Intefaces.UT9_Simulacion_1.enums.Estados;

public class Triatleta implements Corredor, Nadador{
	private Estados estado;
	
	public Triatleta(Estados estado) {
		
	}
	
	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		if (estado == null) {
				System.out.println("Error: el estado no es valido, inicializado a'"+Estados.CORREDOR+"'");
				this.estado = Estados.CORREDOR;
		} else {
				this.estado = estado;
		}
	}
	
	@Override
	public void correr() {
		if (estado.equals(Estados.CORREDOR)) {
			System.out.println("Estás corriendo");
		} else {
			System.out.println("No eres corredor");
		}
	}
	
	@Override
	public void nadar() {
		if (estado.equals(Estados.NADADOR)) {
			System.out.println("Estás nadando");
		} else {
			System.out.println("No eres nadador");
		}
	}
	
	@Override
	public String toString() {
			return String.format("=== Triatleta ===%nEstado: %s", estado);
	}

}
