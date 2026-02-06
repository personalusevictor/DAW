package Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Classes;

import Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Interfaces.MetodoPago;

public class Tarjeta implements MetodoPago {

	private String numeroTarjeta;
	private String titular;

	public Tarjeta(String numeroTarjeta, String titular) {
			this.numeroTarjeta = numeroTarjeta;
			this.titular = titular;
	}

	@Override
	public void procesarPago(double importe) {
			if (numeroTarjeta.length() == 16) {
					System.out.println("Pago de " + importe + "€ realizado con Tarjeta a nombre de " + titular);
			} else {
					System.out.println("Error: número de tarjeta inválido");
			}
	}

	@Override
	public String obtenerNombre() {
			return "Tarjeta";
	}
}