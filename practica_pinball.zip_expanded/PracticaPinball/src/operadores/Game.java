package operadores;

public class Game {

	// Declaración de atributos
	public int nBalls;
	public int score;
	public long totalScore;

	/**
	 * Realiza todos las funciones que tiene un intento o juego
	 */
	public void juego() {

		// Inicia la puntuacion con cantidad aleatoria
		score = (int) (Math.random() * 100000);

		// Si queda solo una bola posibilita ganar una bola extra
		if (nBalls < 3)
			bolaExtra(40000);

		// Si la puntuacion es mayor a cero se llama a los bonos
		System.out.println((score > 0) ? bonoPuntos() : "Se te va la bola...");

		// Se realiza el metodo multiplicador() y si devuelve true
		// imprime por pantalla la puntuacion
		System.out.println((multiplicador(30000, 2)) ? "\n¡HAS DUPLICADO TU PUNTUACION!" : "\nLa bola a caido....");

		// Si la puntuacion es negativa se pone a 0
		if (score < 0)
			score = 0;

		// Se añade la puntuacion al total
		totalScore += score;

		System.out.println("\nPuntuacion de partida: " + score);

		// Si es la ultima se muestra tambien la puntuacion total
		if (nBalls == 1)
			System.out.println("\nPUNTUACION TOTAL: " + totalScore);
		// Y si el total es mayor a la puntuacion de partida, se muestra como acumulado
		else if (totalScore > score)
			System.out.println("Puntuacion acumulada: " + totalScore);

	}

	/**
	 * Incrementa el numero de bolas
	 * 
	 * @param requirement Requisito
	 * @return Devuelve true si se cumple y false si no se cumple
	 */
	public boolean bolaExtra(int requirement) {

		// Si se cumple la condicion se incremente la bola en 1
		if (score > requirement) {
			nBalls++;
			System.out.println("¡BOLA EXTRA!");
			return true;
		}

		else {
			return false;
		}
	}

	/**
	 * Multiplica o resta la puntuación
	 * 
	 * @param requirement Requisito
	 * @param multiplier  El numero por el que se va a multiplicar
	 * @return Devuelve true si se cumple o false si no se cumple
	 */
	public boolean multiplicador(int requirement, int multiplier) {

		// Si se cumple la condicion multiplica puntuacion
		if (score > requirement) {
			score *= multiplier;
			return true;
		}

		// Si es igual resta 1000 puntos
		else if (score == requirement) {
			score -= 10000;
			return false;
		}

		// Si no se cumple divide la puntuacion
		else {
			score /= 2;
			return false;
		}
	}

	/**
	 * Entra en segun que caso aleatoriamente
	 * 
	 * @return Devuelve un String generico
	 */
	public String bonoPuntos() {

		// Inicializa un entero aleatorio
		int random = (int) (Math.random() * 10);

		// Segun el caso realiza una accion
		switch (random) {

		// Multiplica la puntuacion por 5
		case 1:
			System.out.println("\nBONO X5 ¡¡¡¡BRILLANTE!!!!");
			multiplicador(0, 5);
			break;

		// Multiplica la puntuacion por 4
		case 2:
			System.out.println("\nBONO X4 ¡¡¡EXCELENTE!!!");
			multiplicador(0, 4);
			break;

		// Multiplica la puntuacion por 3
		case 3:
			System.out.println("\nBONO X3 ¡¡BUENA JUGADA!!");
			multiplicador(0, 3);
			break;

		// Multiplica la puntuacion por 2
		case 4:
			System.out.println("\nBONO X2 ¡BIEN!");
			multiplicador(0, 2);
			break;

		// Multiplica la puntuacion por 7
		case 7:
			System.out.println("\nBONO X7 ¡¡¡¡¡INCREIBLE!!!!!");

			int requirement = 20000;
			int round = 0;

			// Entra en un bucle que se repite 3 veces y añade bolas extras
			// si se cumple el requisito, que se va incrementando en cada vuelta
			do {

				bolaExtra(requirement);
				requirement += 20000;
				round++;

			} while (round < 3);

			multiplicador(0, 7);
			break;

		// Reduce la puntuacion a 0
		case 0:
			System.out.println("\nBANCARROTA ¡PUNTUACION REDUCIDA A CERO! :(");
			multiplicador(0, 0);
			break;

		// No hace nada
		default:
			System.out.println("\nBONO X1. NO HAY SUERTE...");
			break;
		}

		return "\nRonda de bonos finalizada";
	}

}
