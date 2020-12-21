package actividad4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyHilo hilo = new MyHilo();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Inicia con [*]");
		
		if (sc.nextLine().contains("*"))
			hilo.start();
		
		System.out.println("Suspende con [s]");
		System.out.println("Reanuda con [r]");
		System.out.println("Salir con [e]");
		String resp;
		do {
			resp = sc.nextLine();
			if (resp.contains("s")) {
				hilo.suspende();
				System.out.println("Hilo suspendido");
				System.out.println("El contador ha llegado a " + hilo.getContador());
			}
			else if (resp.contains("r")) {
				hilo.reanuda();
				System.out.println("Hilo reanudado");
			}
		} while(!resp.contains("e"));
		
		hilo.stop();
		System.out.println("Programa terminado");
	}

}
