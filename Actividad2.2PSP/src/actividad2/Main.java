package actividad2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tic tic = new Tic();
		Tac tac = new Tac();
		
		new Thread(tic).start();
		new Thread(tac).start();
	}

}
