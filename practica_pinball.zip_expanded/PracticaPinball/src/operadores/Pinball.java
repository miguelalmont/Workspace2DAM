package operadores;

import java.util.Scanner;

public class Pinball extends Game {

	// Declaración de atributos
	private Scanner sc;

	/**
	 * Comienza el juego lanzando una bola
	 */
	public void lanzarBola() {

		System.out.println("=======================");
		System.out.println("| ONE MILLION MACHINE |");
		System.out.println("=======================");

		// Por cada bola tienes un intento
		for (nBalls = 3; (nBalls) > 0; nBalls--) {
			System.out.println("\nNumero de bolas: " + nBalls);
			System.out.println("Pulsa ENTER para lanzar un bola.");

			// Instancia el objeto Scanner
			sc = new Scanner(System.in);

			// Verifica que se haya pulsado la tecla ENTER comprobando
			// si contiene un salto de linea
			if (sc.hasNextLine()) {
				juego();

				sc = null;
			}
		}

		// Si cumple las condiciones imprime un mensaje de felicitacion
		System.out.println(
				(totalScore >= 1000000) ? "\n********* ¡FELICIDADES! HAS SUPERADO EL MILLÓN DE PUNTOS *********"
						: "\nSigue intentandolo.");

		System.out.println("\n=============");
		System.out.println("| GAME OVER |");
		System.out.println("=============");
		System.exit(0);
	}

}
