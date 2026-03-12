package Tema10_Expeciones_Ficheros.UT10_Copia_Fichero;

import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Que fichero deseas copiar: ");
		String ruta = sc.next();
		
		try (
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			PrintWriter pw = new PrintWriter("copia_de_"+ruta.toLowerCase());
		){
			String linea = br.readLine();
			
			while (linea != null) {
					pw.println(linea);
					linea = br.readLine();
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}