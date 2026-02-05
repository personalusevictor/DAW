package Tema7_POO.UT7_Lista;
import java.util.*;

public class Lista {
	static Scanner sc = new Scanner(System.in);
	
	private Integer[] tabla;
	private int size;

	public Lista() {
		tabla = new Integer[0];
		size = 0;
	}

	public int getNumeroElementos() {
		return size;
	}

	private void redimensionar(int nuevoTam) {
		Integer[] nuevaTabla = new Integer[nuevoTam];
		for (int i = 0; i < size; i++) {
			nuevaTabla[i] = tabla[i];
		}
		tabla = nuevaTabla;
	}

	public void insertarFinal(Integer numero) {
		redimensionar(size + 1);
		tabla[size] = numero;
		size++;
	}

	public void insertarInicio(Integer numero) {
		redimensionar(size + 1);
		for (int i = size; i > 0; i--) {
			tabla[i] = tabla[i - 1];
		}
		tabla[0] = numero;
		size++;
	}

	public void insertarEnIndice(int indice, Integer numero) {
		if (indice < 0 || indice > size) {
			return;
		}
		redimensionar(size + 1);
		for (int i = size; i > indice; i--) {
			tabla[i] = tabla[i - 1];
		}
		tabla[indice] = numero;
		size++;
	}

	public void añadirLista(Lista otraLista) {
		for (int i = 0; i < otraLista.size; i++) {
			insertarFinal(otraLista.tabla[i]);
		}
	}

	public void eliminar(int indice) {
		if (indice < 0 || indice >= size) {
			return;
		}
		for (int i = indice; i < size - 1; i++) {
			tabla[i] = tabla[i + 1];
		}
		size--;
		redimensionar(size);
	}

	public Integer getElemento(int indice) {
		if (indice < 0 || indice >= size) {
			return null;
		}
		return tabla[indice];
	}

	public int buscar(Integer numero) {
		for (int i = 0; i < size; i++) {
			if (tabla[i].equals(numero)) {
				return i;
			}
		}
		return -1;
	}
	
	static Lista concatena(Lista Lista1, Lista Lista2) {
		if(Lista1.size == 0 || Lista2.size == 0) {
			System.out.println("Una de las listas está vacia");
		}
		
		Lista ListaConcatenada = new Lista();
		ListaConcatenada.añadirLista(Lista1);
		ListaConcatenada.añadirLista(Lista2);
		
		System.out.println(ListaConcatenada);
		return ListaConcatenada;
	}
	
	
	public String toString() {
		if (size == 0) {
			System.out.println("La lista está vacía");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.println(tabla[i] + " ");
			}
		}
		return "";
	}
}