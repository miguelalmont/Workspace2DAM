package actividad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class EjecutaSumar {

	public static void main(String[] args) {
		
		Excepciones ex = new Excepciones();
		
		ProcessBuilder pb = new ProcessBuilder("java", "actividad6.SumarNumeros");
		
		pb.directory(new File(".\\bin"));
		
		
		Process proceso = null;
		try {
			
			// Iniciamos el proceso
			proceso = pb.start();
	
			int num1 = 0, num2 = 0;
			
			// Obtenemos los flujos de entrada/salida del proceso
			InputStream is = proceso.getInputStream();
			OutputStream os = proceso.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
			
			// Solicitamos los datos que necesita el proceso
			System.out.println("Introduce el primer numero:");
			num1 = ex.controlInt();
			System.out.println("Introduce el segundo numero:");;
			num2 = ex.controlInt();
			
			// Escribimos los datos de entrada del proceso y cerramos el flujo
			bw.write(num1+"\n");
			bw.flush();
			bw.write(num2+"\n");
			bw.flush();
			os.close();
			
			// Saltamos las dos primeras lineas, imprimimos la tercera (con el resultado)
			// y cerramos el flujo
			br.readLine();
			br.readLine();
			System.out.println(br.readLine());
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int exitVal;
		try {
			
			// Almacenamos e imprimimos el valor de salida del proceso
			exitVal = proceso.waitFor(); 

			System.out.println("Valor de salida: "+exitVal);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
