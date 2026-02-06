package Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Interfaces;

public interface MetodoPago {
	
	abstract void procesarPago(double importe);
	abstract String obtenerNombre();
	default void mostrarSaludo() {
		System.out.println("=== Bienvenido al sistema de pago seguro ===");
	}
	
}
