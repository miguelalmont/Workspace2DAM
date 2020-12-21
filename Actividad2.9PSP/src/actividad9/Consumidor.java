package actividad9;

public class Consumidor extends Thread {
	
	private Cola cola;
	private int n;
	
	public Consumidor(Cola cola, int n) {
		this.cola = cola;
		this.n = n;
	}
	
	public void run() {
		int valor = 0;
		for (int i = 0; i < 5; i++) {
			valor = cola.get();
			System.out.println(i + "=>Consumidor: " + n + ", consume: " + valor);
			try {
				sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}
