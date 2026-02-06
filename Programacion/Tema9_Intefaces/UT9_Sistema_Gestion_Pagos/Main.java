package Tema9_Intefaces.UT9_Sistema_Gestion_Pagos;

import Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Classes.*;
import Tema9_Intefaces.UT9_Sistema_Gestion_Pagos.Interfaces.MetodoPago;

public class Main {

	public static void main(String[] args) {

			MetodoPago[] metodosPago = {
					new Tarjeta("1234567812345678", "Víctor"),
					new PayPal("victor@email.com"),
					new Cripto("0xA1B2C3D4E5")
			};

			for (MetodoPago metodo : metodosPago) {
					metodo.mostrarSaludo();
					System.out.println("Método: " + metodo.obtenerNombre());
					metodo.procesarPago(150.75);
					System.out.println("-----------------------------");
			}
	}
}

