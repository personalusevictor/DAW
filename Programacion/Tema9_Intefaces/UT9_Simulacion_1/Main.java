package Tema9_Intefaces.UT9_Simulacion_1;

import java.util.Arrays;
import java.util.Comparator;

//Triatleta
import Tema9_Intefaces.UT9_Simulacion_1.classes.Triatleta;
import Tema9_Intefaces.UT9_Simulacion_1.enums.Estados;
import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Corredor;
import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Nadador;
//Vehiculo
import Tema9_Intefaces.UT9_Simulacion_1.interfaces.Vehiculo;
//Persona
import Tema9_Intefaces.UT9_Simulacion_1.classes.Persona;
import Tema9_Intefaces.UT9_Simulacion_1.classes.Coche;
import Tema9_Intefaces.UT9_Simulacion_1.classes.ComparadorNombre;

public class Main {
	public static void main(String[] args) {
		System.out.println();
		
		//Triatleta
		Corredor corredor = new Triatleta(Estados.CORREDOR);
		Nadador nadador = new Triatleta(Estados.NADADOR);
		
		corredor.correr();
		nadador.nadar();
		
		//Vehiculo
		Vehiculo vehiculo = new Coche(50);
		
		vehiculo.acelerar(100);
		vehiculo.frenar();
		System.out.println("La velocidad actual del vehículo es: "+vehiculo.getVelocidadActual());
		vehiculo.detener();
		
		//Persona
		Persona[] personas = new Persona[5];
		personas[0] = new Persona("Víctor", 4);
		personas[1] = new Persona("Luis", 1);
		personas[2] = new Persona("Abilio", 3);
		personas[3] = new Persona("Berta", 2);
		personas[4] = new Persona("Camilla", 5);
		
		Arrays.sort(personas);
		System.out.println(Arrays.deepToString(personas));
		
		Arrays.sort(personas, new ComparadorNombre());
		System.out.println(Arrays.deepToString(personas));
		
		Arrays.sort(personas, new Comparator<Persona>() {
			public int compare(Persona obj1, Persona obj2) {
				int comparaEdad = obj1.compareTo(obj2.getEdad());
				int comparaNombre = obj1.compareTo(obj2.getNombre());
				
				return (comparaEdad == 0) ? comparaNombre : comparaNombre;
			};
		});
		System.out.println(Arrays.deepToString(personas));
	}
}
