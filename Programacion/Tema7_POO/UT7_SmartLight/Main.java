import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nComo quieres llamar a la bombilla: ");
		Bombilla salon = new Bombilla(sc.next());
		
		
		System.out.print("Que intensidad quieres ponerle a la bombilla: ");
		salon.setIntensidad(sc.nextInt());
		
		salon.imprimirEstado();
		
		sc.close();
	}
}
