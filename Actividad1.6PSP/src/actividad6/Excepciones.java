package actividad6;

import java.util.Scanner;

public class Excepciones {
	Scanner entrada = new Scanner(System.in);
	boolean error = false;
	
	public int controlInt() {
		int i = 0;
		do{
			try {
				i = entrada.nextInt();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.out.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return i;
	}
}
