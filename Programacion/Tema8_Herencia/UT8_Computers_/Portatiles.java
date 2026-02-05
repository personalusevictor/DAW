package Tema8_Herencia.UT8_Computers_;

public class Portatiles extends Ordenadores {
	private double peso;
	
	public Portatiles(int precio, double peso) {
		super(precio);
		setPeso(peso);
	}

	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		if(peso <= 0) {
			System.out.println("Error: El peso no es valido");
		} else {
			this.peso = peso;
		}
	}
	
	public String rendimiento() {
		return String.format("El rendimiento de este portatil es de: 2000 pulsos");
	}
	
	public String eslogan() {
		return String.format("Ideal para tus viajes");
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Precio: %.2f\nPeso: %.2f\n", precio, peso) + eslogan() +"\n"+ rendimiento();
	}
	
}
