package Tema9_Intefaces.UT9_Lista_String;

public class Main {
	public static void main(String[] args) {
		
		System.out.println();
		
		Lista p1 = new Lista();
		
		p1.apilar("Hola");
		p1.apilar("Adios");
		p1.apilar("Como estas");
		p1.desapilar();
		
		System.out.println(p1);
		
		
		Lista c1 = new Lista();
		
		c1.encolar("Hola");
		c1.encolar("Adios");
		c1.encolar("Como estas");
		c1.desencolar();
		
		System.out.println(c1);
		
		
	}
}
