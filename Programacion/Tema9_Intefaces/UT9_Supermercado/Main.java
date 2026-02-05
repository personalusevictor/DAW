package Tema9_Intefaces.UT9_Supermercado;

import java.time.LocalDate;

import Tema9_Intefaces.UT9_Supermercado.Productos.*;
import Tema9_Intefaces.UT9_Supermercado.Enum.*;

public class Main {
	public static void main(String[] args) {
		Cereales cereales = new Cereales("Lion", 10.0, TipoCereales.MAIZ, LocalDate.now());
		
		System.out.println(cereales);
		
		Detergente detergente = new Detergente("Colon", 20.0, 20.0, "Plástico", 20.0);
		
		System.out.println(detergente);
		
		Vino vino = new Vino("Vino Bach", 30.0, 30.0, "Vidrio", 30.0);
		
		System.out.println(vino);
	}
}
