package actividad6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumarNumeros {

	public static void main(String[] args) throws IOException {
		
		int num1 = 0, num2 = 0;
		
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader bf = new BufferedReader(is);
		
		boolean error = false;
		
		// Solicitamos el primer numero controlando que sea un entero y si no lo es
		// lo volvemos a pedir
		System.out.println("Introduce el primer número:");
		do {
			try {
				
				num1 =  Integer.parseInt(bf.readLine());
				error = false;
				
			} catch (NumberFormatException e) {
				System.err.println("Valor no valido. Vuelva a introducirlo: ");
				error = true;
			} 
		}while (error);
		
		// Solicitamos el segundo numero igual que el primero
		System.out.println("Introduce el segundo número:");
		do {
			try {
				
				num2 =  Integer.parseInt(bf.readLine());
				error = false;
				
			} catch (NumberFormatException e) {
				System.err.println("Valor no valido. Vuelva a introducirlo: ");
				error = true;
			}
			
		}while(error);
		
		// Cerramos el flujo de entrada
		is.close();
		
		// Imprimimos el resultado
		System.out.println("Su suma es: "+(num1+num2));
		
	}

}
