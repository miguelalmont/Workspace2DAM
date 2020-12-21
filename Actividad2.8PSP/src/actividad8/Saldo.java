package actividad8;

public class Saldo {
	
	private int saldo;
	
	public Saldo(int saldo) {
		this.saldo = saldo;
	}
	
	public int getSaldo() {
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {}
		return saldo;
	}
	
	public void setSaldo(int saldo) {
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {}
		this.saldo = saldo;
	}
	
	synchronized public void incrementSaldo(String user, int increment) {
		System.out.println(user + ": SE VA A INGRESAR SALDO (ACTUAL ES: " + saldo +")");
		System.out.println("	" + user + " ingresa => " + increment + " ACTUAL(" + (saldo + increment) + ")");
		saldo += increment;
	}
	
}
