package Tema8_Herencia.UT8_Computers_;

public abstract class Ordenadores {
	protected int codigo;
	protected double precio;

	public Ordenadores(int precio) {
		this.codigo = (int) (Math.random()*999)+1;
		setPrecio(precio);
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if(precio<=0) {
			System.out.println("Error: el precio no es valido");
			return;
		} else {
			this.precio = precio;
		}
	}

	public abstract String rendimiento();
	
	public abstract String eslogan();
	
	@Override
	public String toString() {
		return String.format("Codigo: %03d \nPrecio: $.2f",codigo, precio);
	}
}
