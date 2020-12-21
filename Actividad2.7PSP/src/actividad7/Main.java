package actividad7;

public class Main {

	public static void main(String[] args) {
		
		Contador cont1 = new Contador();
		
		Hilo hilo1 = new Hilo("Hilo 1", cont1);
		Hilo hilo2 = new Hilo("Hilo 2", cont1);
		Hilo hilo3 = new Hilo("Hilo 3", cont1);
		Hilo hilo4 = new Hilo("Hilo 4", cont1);
		Hilo hilo5 = new Hilo("Hilo 5", cont1);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();
		hilo5.start();
		
		Contador cont2 = new Contador();
		
		RunnableImpl ri1 = new RunnableImpl("Runnable 1", cont2);
		RunnableImpl ri2 = new RunnableImpl("Runnable 2", cont2);
		RunnableImpl ri3 = new RunnableImpl("Runnable 3", cont2);
		RunnableImpl ri4 = new RunnableImpl("Runnable 4", cont2);
		RunnableImpl ri5 = new RunnableImpl("Runnable 5", cont2);
		
		ri1.run();
		ri2.run();
		ri3.run();
		ri4.run();
		ri5.run();
		
	}

}
