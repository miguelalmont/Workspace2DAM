package actividad1;

public class Tic extends Thread{
	
	public void run() {
		
		while (true) {
			System.out.println("TIC");
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
