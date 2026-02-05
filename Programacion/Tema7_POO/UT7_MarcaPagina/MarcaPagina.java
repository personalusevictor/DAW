package Tema7_POO.UT7_MarcaPagina;

public class MarcaPagina {
	public String nombre;
	private int pagina;
	
	MarcaPagina(String nombre) {
		this.nombre = nombre;
		this.pagina = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public void incrementarPagina(int incremento) {
		if(incremento < 0) {
			System.out.println("Error: El valor debe ser mayor a cero: ");
		} else {
			this.pagina += incremento;	
		}
	}
	
	public void ultimaPagina() {
		System.out.println("La ultima página que haz leido del libro: "+getNombre()+"\nEs la página: "+getPagina());
	}
	
	public void reestablecerLectura() {
		setPagina(0);
	}
}
