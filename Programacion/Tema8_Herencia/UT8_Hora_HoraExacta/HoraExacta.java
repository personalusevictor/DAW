public class HoraExacta extends Hora {
	private int segundos;
	
	HoraExacta(int hora, int minutos, int segundos) {
		super(hora, minutos);
		this.setSegundos(segundos);
	}

	public int getSegundos() {
		return segundos;
	}

	public void setSegundos(int segundos) {
		while(segundos < 0 || segundos > 59) {
			System.out.println("Error: El valor introducido para los segundos no es valido");
			System.out.print("Introduzca un valor valido: ");
			segundos = sc.nextInt();
		}
		
		this.segundos = segundos;
	}
	
	public void incSegundos() {
		segundos++;
		
		if(segundos > 59) {
			minutos++;
			segundos = 0;
			if (minutos > 59) {
				hora++;
				minutos = 0;
				segundos = 0;
				if (hora > 23) {
					hora = 0;
					minutos = 0;
					segundos = 0;
				}
			} 
		}
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", getHora(), getMinutos(), getSegundos());
	}
	
}
