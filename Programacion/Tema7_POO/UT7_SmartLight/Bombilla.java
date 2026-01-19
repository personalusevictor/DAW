class Bombilla {
	public String nombre;
	private boolean encendida;
	private int intensidad;
	
	Bombilla(String nombre) {
		this.nombre = nombre;
		this.encendida = false;
		this.intensidad = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean isEncendida() {
		return encendida;
	}
	
	
	public void setIntensidad(int intensidad) {
		if(intensidad > 100) {
			this.intensidad = 100;
		} else if(intensidad < 0) {
			this.intensidad = 0;
		} else {
			this.intensidad = intensidad;
		}
		
		this.encendida = (this.intensidad > 0);
	}
	
	public void imprimirEstado() {
		System.out.println("\n--- Estado ---");
		System.out.println("Nombre de la Bombilla: "+getNombre());
		String estado = (encendida) ? "Encendida" : "Apagada";
		System.out.println("La luz está: "+estado);
		System.out.println("La intensidad es: " +this.intensidad);
	}
}
