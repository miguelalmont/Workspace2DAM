package actividad7;

public class RunnableImpl implements Runnable {
	
	private Contador contador;
	private String name;
	
	public RunnableImpl(String n, Contador c) {
		setName(n);
		contador = c;
	}
	
	@Override
	public void run() {
		synchronized (contador) {
			for (int j = 0; j < 5000; j++) {
				contador.incrementa();
			}
			System.out.println(getName() + " contador vale " + contador.valor());
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
		
}
