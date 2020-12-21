package proyecto_oracle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author Miguel Alcantara
 *
 */
public class Excepciones {
	Scanner entrada = new Scanner(System.in);
	boolean error = false;
	
	/**
	 * Solicita un entero por teclado y controla excepciones.
	 * @return int
	 */
	public int controlInt() {
		int i = 0;
		do{
			try {
				i = entrada.nextInt();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.err.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return i;
	}
	
	/**
	 * Solicita un double por teclado y controla excepciones.
	 * @return double
	 */
	public double controlDouble() {
		double d = 0;
		do{
			try {
				d = entrada.nextDouble();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.err.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return d;
	}
	
	/**
	 * Solicita un float por teclado y controla excepciones.
	 * @return float
	 */
	public float controlFloat() {
		float f = 0;
		do{
			try {
				f = entrada.nextFloat();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.err.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return f;
	}
	
	/**
	 * Solicita un char por teclado y controla excepciones.
	 * @return char
	 */
	public char controlChar() {
		String str;
		do {
			str = entrada.nextLine();
			error = false;
			if (str.length() > 1) {
				System.err.println("El campo solo puede contener 1 caracter. Vuelva a introducir el valor:");
				error = true;
			}
		}while (error);
		return str.charAt(0);
	}
	
	/**
	 * Solicita una cadena por teclado y limita el numero de caracteres que retorna.
	 * @param limite Limita el numero de caracteres que retorna.
	 * @return String
	 */
	public String limitaString(int limite) {
		String str;
		do {
			str = entrada.nextLine();
			error = false;
			if (str.length() > limite) {
				System.err.println("Demasiado largo. El campo solo puede contener "+limite+" caracteres. Vuelva a introducir el campo:");
				error = true;
			}
		}while (error);
		return str;
	}
	
	/**
	 * Solicita un entero por teclado y limita la longitud que retorna.
	 * @param limite Limita la longitud del entero que retorna.
	 * @return int
	 */
	public int limitaInt(int limite) {
		int i = 0;
		do{
			try {
				i = entrada.nextInt();
				entrada.nextLine();
				error = false;
				if (Integer.valueOf(i).toString().length() > limite) {
					System.err.println("Demasiado largo. El campo solo puede contener "+limite+" digitos. Vuelva a introducir el numero:");
				}
			} catch (Exception ex){
				System.err.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return i;
	}
	
	/**
	 * Solicita tres valores (dia, mes, anio) y controla excepciones.
	 * @return LocalDate
	 */
	public LocalDate controlDate() {
		LocalDate fechaFormateada = null;
		do {
			try {
				System.out.println("-Inserte el dia:");
				int dia = entrada.nextInt();
				System.out.println("-Inserte el mes:");
				int mes = entrada.nextInt();
				System.out.println("-Inserte el anio:");
				int anio = entrada.nextInt();
				
				String fechaCadena = anio +"-"+mes+"-"+dia;
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
				fechaFormateada = LocalDate.parse(fechaCadena, formatter);
				error = false;
			} catch (Exception ex) {
				System.err.println("La fecha introducida no es correcta. Vuelva a introducirla correctamente:");
				error = true;
			}
			
		}while (error);
		return fechaFormateada;
	}
}