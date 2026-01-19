public class Automovil extends Vehiculo{
	private int puertas;
	
	Automovil(String marca, String modelo, int año, int puertas) {
		super(marca, modelo, año);
		setPuertas(puertas);
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		if(puertas <= 0) {
			System.out.println("Error: El automovil debe tener más de 0 puertas");
		} else {
			this.puertas = puertas;
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format("\nEl automovil tiene: %d puertas", puertas);
	}
}
