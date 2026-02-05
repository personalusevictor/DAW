package Tema8_Herencia.UT8_Computers_;

public class Sobremesa extends Ordenadores {
	private tipo_sobremesa tipo;
	
	public Sobremesa(int precio, tipo_sobremesa tipo) {
		super(precio);
		setTipo(tipo);
	}

	public tipo_sobremesa getTipo() {
		return tipo;
	}

	public void setTipo(tipo_sobremesa tipo) {
			this.tipo = tipo;
	}
	
	public String rendimiento() {
		return String.format("El rendimiento de este ordenador de sobremesa es de: 4000 pulsos");
	}
	
	public String eslogan() {
		return String.format("Es el que más pesa, pero el que menos cuesta");
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("Precio: %.2f\nTipo de Sobremesa: %s\n", precio, tipo) + eslogan() +"\n"+ rendimiento();
	}
}
