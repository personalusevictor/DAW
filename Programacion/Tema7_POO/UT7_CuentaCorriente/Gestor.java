public class Gestor {
	public String nombre;
	public final String telefono;
	double importemaximo;
	
	Gestor(String nombre, String telefono) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.importemaximo = 10000;
	}
	
	Gestor(String nombre, String telefono, double importemaximo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.importemaximo = importemaximo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}
	
	private double getImporteMaximo() {
		return importemaximo;
	}
	
	public void mostrarGestor() {
		System.out.println("Información del Gestor: ");
		System.out.println("Nombre: "+getNombre());
		System.out.println("Telefono: "+getTelefono());
		System.out.println("Importe Maximo Permitido: "+getImporteMaximo());
	}
}
