package actividad9;

public class Produc_Consum {
	
	public static void main(String[] args) {
		Cola cola = new Cola();
		Productor p = new Productor(cola, 1);
		Consumidor c = new Consumidor(cola, 1);
		p.start();
		c.start();
		
//		Se obtiene una salida aleatoria tanto a�adiendo el m�todo sleep()
//		a Productor, a Consumidor, a ambos o a ninguno.
//		Para obtener el resultado ordenado,
//		habr�a que declarar los m�todos get() y put() como synchronized.
	}
}
