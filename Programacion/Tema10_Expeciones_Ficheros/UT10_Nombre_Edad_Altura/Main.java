package Tema10_Expeciones_Ficheros.UT10_Nombre_Edad_Altura;

import java.io.*;

public class Main {
	public static void main(String[] args) {

		int sumaEdades = 0;
		double sumaEstaturas = 0;
		int contador = 0;

		try (PrintWriter pw = new PrintWriter(new FileWriter("Jugadores.txt"))) {
			pw.println("Juan 22 1.77");
			pw.println("Luis 22 1.80");
			pw.print("Pedro 20 1.73");
		} catch (IOException e) {
			System.out.println("ERROR: No se pudo escribir el fichero. " + e.getMessage());
		}

		try (BufferedReader br = new BufferedReader(new FileReader("Jugadores.txt"))) {
			System.out.println("\n\n--- Contenido del fichero ---");

			String linea = br.readLine();

			while (linea != null) {
				System.out.println(linea);
				String[] jugadores = linea.split(" ");

				if (jugadores.length == 3) {
					int edad = Integer.parseInt(jugadores[1]);
					double estatura = Double.parseDouble(jugadores[2]);

					sumaEdades += edad;
					sumaEstaturas += estatura;
					contador++;
				}

				linea = br.readLine();
			}
			
			System.out.println("\n--- Medias del Contenido ---");
			System.out.println("Media de Edades: "+sumaEdades/contador);
			System.out.printf("Media de Estatura: %.2f", sumaEstaturas/contador);

			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
