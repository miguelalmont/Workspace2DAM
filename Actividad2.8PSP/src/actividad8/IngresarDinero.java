package actividad8;

public class IngresarDinero extends Thread {
	
	private Saldo saldo;
	private int increment;
	
	
	public IngresarDinero(String user, Saldo saldo, int increment) {
		super(user);
		this.saldo = saldo;
		this.increment = increment;
	}
	
	@Override
	public void run() {
		saldo.incrementSaldo(getName(), increment);
	}
}
