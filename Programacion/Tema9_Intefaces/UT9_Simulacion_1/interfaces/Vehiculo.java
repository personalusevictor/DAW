package Tema9_Intefaces.UT9_Simulacion_1.interfaces;

public interface Vehiculo {
	public void acelerar(int velocidad);
	public void frenar();
	public int getVelocidadActual();
	public default void detener() {
		System.out.println("El vehículo se ha detenido");
	}
}
