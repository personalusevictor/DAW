package Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Classes;

import Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Interfaces.MetodoPago;

public class PayPal implements MetodoPago {

	private String email;

	public PayPal(String email) {
			this.email = email;
	}

	@Override
	public void procesarPago(double importe) {
			if (email.contains("@")) {
					System.out.println("Pago de " + importe + "€ realizado con PayPal (" + email + ")");
			} else {
					System.out.println("Error: email no válido");
			}
	}

	@Override
	public String obtenerNombre() {
			return "PayPal";
	}
}