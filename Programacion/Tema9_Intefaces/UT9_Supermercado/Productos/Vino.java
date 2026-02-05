package Tema9_Intefaces.UT9_Supermercado.Productos;

import Tema9_Intefaces.UT9_Supermercado.Interfaces.ConDescuento;
import Tema9_Intefaces.UT9_Supermercado.Interfaces.EsLiquido;

public class Vino implements ConDescuento, EsLiquido{
	
	static final String STRING_DEFAULT = "Desconocido";
	static final double PRECIO_DEFAULT = 10.0;
	static final double VOLUMEN_DEFAULT = 1.0;
	static final double DESCUENTO_DEFAULT = 1.0;
	
	private String marca;
	private double precio;
	private double volumen;
	private String tipoEnvase;
	private double descuento;
	
	public Vino (String marca, double precio, double volumen, String tipoEnvase, double descuento) {
		setMarca(marca);
		setPrecio(precio);
		setVolumen(volumen);
		setTipoEnvase(tipoEnvase);
		setDescuento(descuento);
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
	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		if (volumen <= 0) {
			System.out.println("Error: el volumen no es valido, inicializado como'"+VOLUMEN_DEFAULT+"'");
			this.volumen = VOLUMEN_DEFAULT;
		} else {
			this.volumen = volumen;
		}
	}

	public String getTipoEnvase() {
		return tipoEnvase;
	}

	public void setTipoEnvase(String tipoEnvase) {
		if (tipoEnvase.equals(null) || tipoEnvase.trim().isEmpty()) {
			System.out.println("Error: el tipo de envase no es valido, inicializado como '"+STRING_DEFAULT+"'");
			this.tipoEnvase = STRING_DEFAULT;
		} else {
			this.tipoEnvase = tipoEnvase;
		}
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		if (descuento < 0) {
			System.out.println("Error: el descuento no es valido, inicializadolo a '"+DESCUENTO_DEFAULT+"'");
			this.descuento = DESCUENTO_DEFAULT;
		} else {
			this.descuento = descuento;
		}
	}
	
	@Override
	public double getPrecioDescuento() {
		return precio - precio * (descuento / 100);
	}
	
	@Override
	public String toString() {
		return String.format("\n=== Información Vino ===\nMarca: %s\nPrecio: %.2f\nVolumen: %.2f\nTipo de Envase: %s\nPrecio con Descuento: %.2f", marca, precio, volumen, tipoEnvase, getPrecioDescuento());
	}
}
