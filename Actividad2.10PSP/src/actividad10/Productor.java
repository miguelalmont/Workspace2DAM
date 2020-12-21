package actividad10;

public class Productor extends Thread {
	
	private Cola cola;
	
	public Productor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		for (int i = 0; i < 15; i++) {
			cola.put(ping());
			cola.put(pong());
		}
	}
	
	public String ping() {
		return "ping";
	}
	
	public String pong() {
		return "pong";
	}
}
