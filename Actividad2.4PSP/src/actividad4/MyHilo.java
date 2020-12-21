package actividad4;

public class MyHilo extends Thread{
	
	private SolicitaSuspender suspender = new SolicitaSuspender();
	private int contador = 0;
	
	public void suspende() {
		suspender.set(true);
	}
	
	public void reanuda() {
		suspender.set(false);
	}
	
	public void run() {
		try {
			while (true) {
				contador++;
				sleep(300);
				suspender.esperandoParaReanudar();
			}
		} catch (InterruptedException e) {}
	}
	
	public int getContador() {
		return contador;
	}

}
