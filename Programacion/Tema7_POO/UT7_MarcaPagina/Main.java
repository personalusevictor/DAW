import java.util.*;

public class Main {
	public static void Menu() {
		System.out.println("Menu - Marca Pagina");
		System.out.println("1.- Incrementar Pagina");
		System.out.println("2.- Ultima Pagina");
		System.out.println("3.- Reestablecer Lectura");
		System.out.println("4.- Salir");
		System.out.println("Que opción quieres elegir:");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion;
		
		System.out.println("Cual es el nombre del Libro: ");
		MarcaPagina libro = new MarcaPagina(sc.next());
		
		do {
			System.out.println("");
			Menu();	
			opcion = sc.nextInt();
			
			switch (opcion) {
				case 1-> {
					System.out.print("\nCuantas páginas quieres incrementar: ");
					libro.incrementarPagina(sc.nextInt());
				}
			}
		} while (opcion!=4);
		
		sc.close();
	}
}
