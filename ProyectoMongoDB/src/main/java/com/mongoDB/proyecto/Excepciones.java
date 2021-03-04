package com.mongoDB.proyecto;

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
	
	public double controlDouble() {
		double d = 0;
		do{
			try {
				d = entrada.nextDouble();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.out.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return d;
	}
	
	public float controlFloat() {
		float f = 0;
		do{
			try {
				f = entrada.nextFloat();
				entrada.nextLine();
				error = false;
			} catch (Exception ex){
				System.out.println("Valor no valido. Vuelva a introducir valor:");
				entrada.nextLine();
				error = true;
			}
		}while (error);
		return f;
	}
	
	public String controlString() {
		String str;
		do {
			str = entrada.nextLine();
			if (str.length() > 60) {
				System.out.println("Demasiado largo. El campo solo puede contener 60 caracteres. Vuelva a introducir el nombre:");
				error = true;
			}
		}while (error);
		return str;
	}
}