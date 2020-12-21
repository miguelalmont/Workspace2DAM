package actividad8;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Saldo saldo = new Saldo(500);
		
		System.out.println("Saldo inicial: " + saldo.getSaldo() +"\n");
		
		IngresarDinero hilo1 = new IngresarDinero("Juan", saldo, 100);
		IngresarDinero hilo2 = new IngresarDinero("Ana", saldo, 250);
		IngresarDinero hilo3 = new IngresarDinero("Pepe", saldo, 600);
		IngresarDinero hilo4 = new IngresarDinero("Maria", saldo, 50);
		
		hilo1.run();
		hilo2.run();
		hilo3.run();
		hilo4.run();
		
		System.out.println("\nSaldo final: " + saldo.getSaldo());
		
	}

}
