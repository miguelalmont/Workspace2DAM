package fpdualeveris;

import operadores.Game;
import operadores.Pinball;

public class FPDual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		practicaOperadores();
	}

	/**
	 * Instancia un objeto de clase Game/Pinball y lo inicia
	 */
	private static void practicaOperadores() {
		
		System.out.println("HOLA PRUEBA");
		
		Game juego = new Pinball();

		// Este 'instance of' esta metido con calzador
		if (juego instanceof Pinball) {
			((Pinball) juego).lanzarBola();
		}
	}
}
