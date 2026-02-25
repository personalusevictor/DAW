package Tema9_Intefaces.UT9_Futbol;

import java.util.Comparator;

public class ComparaEdades implements Comparator {
	@Override
	public int compare(Object o1, Object o2) {
		return ((Futbolista)o1).getEdad() - ((Futbolista)o2).getEdad();
	}
}
