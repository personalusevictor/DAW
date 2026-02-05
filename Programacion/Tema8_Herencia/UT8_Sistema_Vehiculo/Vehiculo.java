package Tema8_Herencia.UT8_Sistema_Vehiculo;

public class Vehiculo {
	protected String marca;
	protected String modelo;
	protected int año;
	
	Vehiculo(String marca, String modelo, int año) {
		setMarca(marca);
		setModelo(modelo);
		setAño(año);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca == null || marca.trim().isEmpty()) {
			System.out.println("Error: La marca no puede estar vacio");
		} else {
			this.marca = marca;
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo == null || modelo.trim().isEmpty()) {
			System.out.println("Error: El modelo no puede estar vacio");
		} else {
			this.modelo = modelo;
		}
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		if(año < 0) {
			System.out.println("Error: Introduzca un año valido");
		} else {
			this.año = año;
		}
	}
	
	@Override
	public String toString() {
		return String.format("\nLa marca es: %s\nEl modelo es: %s\nEl año es: %d", marca, modelo, año);
	}
}
