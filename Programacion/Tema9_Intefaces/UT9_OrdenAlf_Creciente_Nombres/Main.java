package Tema9_Intefaces.UT9_OrdenAlf_Creciente_Nombres;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) {
		Socio[] socios = {
			new Socio(1, "Aaa", "05-05-2000"),
			new Socio(2, "Bbb", "05-05-2000"),
			new Socio(3, "Ccc", "05-05-2000")
		};
		
		Comparator comparatorId = new Comparator() {
			public int compare (Object ob1, Object ob2) {
				return ((Socio)ob1).id - ((Socio)ob2).id;	
			}
		};
		
		Arrays.sort(socios, comparatorId);
		
		System.out.println(Arrays.toString(socios));
	}
}
