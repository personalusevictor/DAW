package Tema9_Intefaces.UT9_Simulacion_1.classes;

import java.util.Comparator;

public class ComparadorNombre implements Comparator{
	@Override
	public int compare(Object obj1, Object obj2) {
		return ((Persona)obj1).getNombre().compareTo(((Persona)obj2).getNombre());
		
	}
}
