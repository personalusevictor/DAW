package Tema9_Intefaces.UT9_Mamiferos;

public class Ornitorrinco extends Mamifero implements Oviparos{
	
	@Override
	protected void amamantarCrias() {
		System.out.println("El ornitorrinco amamantan a sus crías");
	}
	
	@Override
	public void ponerHuevos() {
		System.out.println("El ornitorrinco ponen huevos");
	}
	
}
