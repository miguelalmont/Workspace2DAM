package actividad6;

public class EjemploHiloPrioridad1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloPrioridad1 h1 = new HiloPrioridad1("Hilo1");
		HiloPrioridad1 h2 = new HiloPrioridad1("Hilo2");
		HiloPrioridad1 h3 = new HiloPrioridad1("Hilo3");
		
		h1.setPriority(Thread.MIN_PRIORITY);
		h2.setPriority(Thread.NORM_PRIORITY);
		h3.setPriority(Thread.MAX_PRIORITY);
		
		h2.start();
		h1.start();
		h3.start();
		
		try {
			Thread.sleep(10000);
		} catch (Exception e) {}
		
		h2.pararHilo();
		h1.pararHilo();
		h3.pararHilo();
		
		System.out.println("h2 (Prioridad Normal): "+h2.getContador());
		System.out.println("h1 (Prioridad Minima): "+h1.getContador());
		System.out.println("h3 (Prioridad Maxima): "+h3.getContador());
	}
}
