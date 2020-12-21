package actividad10;

public class Consumidor extends Thread {
	
	private Cola cola;
	private String cadena;
	
	public Consumidor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		for (int i = 0; i < 30; i++) {
			cadena = cola.get();
			System.out.print(cadena);
		}
	}
}
