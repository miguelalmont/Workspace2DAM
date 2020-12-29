package actividad10;

public class ObjetoCompartido {

	private final int numero;
	private boolean acabo;
	private int ganador;

	public ObjetoCompartido(int numero) {
		this.numero = numero;
		this.acabo = false;
	}

	public boolean seAcabo() {
		return acabo;
	}

	public int getGanador() {
		return ganador;
	}

	public synchronized String nuevaJugada(int jugador, int suNumero) {
		String cad = "";
		if (!seAcabo()) {
			if (suNumero > numero) {
				cad = "Numero demasiado grande";
			}
			if (suNumero < numero) {
				cad = "Numero demasiado pequeño";
			}

			if (suNumero == numero) {
				cad = "Jugador " + jugador + " gana, adivino el numero: " + numero;
				acabo = true;
				ganador = jugador;
			}

		} else {
			cad = "Jugador " + ganador + " adivino el numero: " + numero;
		}

		return cad;
	}
}
