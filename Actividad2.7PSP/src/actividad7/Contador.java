package actividad7;

public class Contador {
	
	private int c = 0;
	
	public void incrementa() {
		c = c + 1;
	}
	
	public void decrementa() {
		c = c - 1;
	}
	
	public int valor() {
		return c;
	}
}
