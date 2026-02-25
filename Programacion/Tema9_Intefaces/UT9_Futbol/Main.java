package Tema9_Intefaces.UT9_Futbol;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Futbolista[] futbolistas = new Futbolista[5];
	
		futbolistas[1] = new Futbolista("42420057F", "Víctor", 19, 5);
		futbolistas[0] = new Futbolista("42420056F", "Luis", 9, 15);
		futbolistas[2] = new Futbolista("42420055F", "Jose", 10, 25);
		futbolistas[3] = new Futbolista("42420054F", "María", 15, 15);
		futbolistas[4] = new Futbolista("42420053F", "Pedro", 20, 50);
		
		Arrays.sort(futbolistas);
		System.out.println("\n===========================");
		System.out.println(Arrays.deepToString(futbolistas));
		
		Arrays.sort(futbolistas, new ComparaEdades());
		System.out.println("\n===========================");
		System.out.println(Arrays.deepToString(futbolistas));
		
		Arrays.sort(futbolistas, new ComparaNombre());
		System.out.println("\n===========================");
		System.out.println(Arrays.deepToString(futbolistas));
	}
}
