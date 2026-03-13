import java.time.LocalDateTime;

public class Temperaturas {
	static final int INT_DEFAULT = 0;
	
	private int temperatura;
	private LocalDateTime fechaHora;
	
	public Temperaturas(int temperatura) {
		setTemperatura(temperatura);
		this.fechaHora = LocalDateTime.now();
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		if (temperatura <= -50 || temperatura >= 70) {
				System.out.println("Error: la temperatura no es valida, inicializadola a'"+INT_DEFAULT+"'");
				this.temperatura = INT_DEFAULT;
		} else {
				this.temperatura = temperatura;
		}
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = LocalDateTime.now();
	}
	
}