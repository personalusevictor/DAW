package Tema7_POO.Examen_UT7_UT8_Prueba;

import java.util.Scanner;

public class Caja {

	static Scanner sc = new Scanner(System.in);

	private int ancho;
	private int alto;
	private int fondo;
	private String etiqueta;
	private UnidadMedida medida;
	private double volumen;

	public Caja(int ancho, int alto, int fondo, String etiqueta, UnidadMedida medida) {
		setAncho(ancho);
		setAlto(alto);
		setFondo(fondo);
		setEtiqueta(etiqueta);
		setMedida(medida);
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		if (ancho <= 0) {
			System.out.println("Error: el ancho no es valido, inicializandolo a 1" + medida);
			this.ancho = 1;
		} else {
			this.ancho = ancho;
		}
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		if (alto <= 0) {
			System.out.println("Error: el alto no es valido, inicializandolo a 1" + medida);
			this.alto = 1;
		} else {
			this.alto = alto;
		}
	}

	public int getFondo() {
		return fondo;
	}

	public void setFondo(int fondo) {
		if (fondo <= 0) {
			System.out.println("Error: el fondo no es valido, inicializandolo a 1" + medida);
			this.fondo = 1;
		} else {
			this.fondo = fondo;
		}
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		if (etiqueta == null || etiqueta.trim().isEmpty()) {
			System.out.println("Error: la etiqueta no es valida");
			etiqueta = "Desconocida";
		} else {
			this.etiqueta = etiqueta.substring(0, 1).toUpperCase() + etiqueta.substring(1);
		}
	}

	public UnidadMedida getMedida() {
		return medida;
	}

	public void setMedida(UnidadMedida medida) {
		int opcion;
		

		do {
			System.out.println("\n=== Menu Seleccion para Unidad de Medida ===");
			System.out.println("1.- Unidad de Medida \"CM\"");
			System.out.println("2.- Unidad de Medida \"M\"");
			System.out.println("Elige una opcion: ");
			opcion = sc.nextInt();
			switch (opcion) {
				case 1 -> this.medida = UnidadMedida.CM;
				case 2 -> this.medida = UnidadMedida.M;
				default -> System.out.println("Error: la opcion no es valida, vuelva a introducirla correctamente");
			}

		} while (opcion == 1 || opcion == 2);
	}
	
	public double getVolumen() {
		if(this.medida == UnidadMedida.CM) {
			return this.volumen = ((this.ancho / 100) * (this.alto / 100) * (this.fondo / 100));
		} else {
			return this.volumen = ancho * alto * fondo;
		}
	}

	@Override
	public String toString() {
		return String.format("Ancho: %d\nAlto:%d\nFondo:%d\nEtiqueta: %s\nVolumen: %d %UnidadMedida", ancho, alto, fondo, etiqueta, volumen, medida);
	}
	
}