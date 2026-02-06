package Tema9_Intefaces.UT9_Supermercado.Productos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Tema9_Intefaces.UT9_Supermercado.Enum.TipoCereales;
import Tema9_Intefaces.UT9_Supermercado.Interfaces.EsAlimento;

public class Cereales implements EsAlimento{
	
	static final String STRING_DEFAULT = "Desconocido";
	static final double PRECIO_DEFAULT = 10.0;
	static final TipoCereales TIPO_DEFAULT = TipoCereales.OTROS;
	
	private String marca;
	private double precio;
	private TipoCereales tipo;
	private LocalDate caducidad;
	private int calorias;
	
	public Cereales (String marca, double precio, TipoCereales tipo, LocalDate caducidad) {
		setMarca(marca);
		setPrecio(precio);
		setTipo(tipo);
		setCaducidad(caducidad);
		setCalorias(calorias);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if (marca.equals(null) || marca.trim().isEmpty()) {
			System.out.println("Error: la marca no es valida, inicializando como '"+STRING_DEFAULT+"'");
			this.marca = STRING_DEFAULT;
		} else {
			this.marca = marca;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio <= 0) {
			System.out.println("Error: el precio no es valido, inicializado a '"+PRECIO_DEFAULT+"€'");
			this.precio = PRECIO_DEFAULT;
		} else {
			this.precio = precio;
		}
	}

	public TipoCereales getTipo() {
		return tipo;
	}

	public void setTipo(TipoCereales tipo) {
		if (tipo == null) {
			System.out.println("Error: el tipo de cereales no es valido, inicializado a 'OTROS'");
			this.tipo = TIPO_DEFAULT;
		} else {
			this.tipo = tipo;
		}
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		this.caducidad = caducidad;
	}

	public int getCalorias() {
		return calorias;
	}

	private int elegirCalorias() {
		switch (this.tipo) {
			case TipoCereales.ESPELTA: return 5;
			case TipoCereales.MAIZ: return 8;
			case TipoCereales.TRIGO: return 12;
			default: return 15;
		}
	}
	
	public void setCalorias(int calorias) {
		this.calorias = elegirCalorias();
	}
	
	@Override
	public String toString() {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	String caducidadString = caducidad.format(formatter);

		return String.format("\n=== Información Cereales ===\nMarca: %s\nPrecio: %.2f\nTipo de Cereales: %s\nCaducidad: %s\nCalorias: %d", marca, precio, tipo, caducidadString, calorias);
	}
	
}
