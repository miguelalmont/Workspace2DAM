package prueba;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Prueba2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        String palabra, cadena;
        StringBuilder auxBuilder;
        long pos = 0;
        int indice;
        try {
            //se abre el fichero para lectura/escritura
            fichero = new RandomAccessFile("./ficheros/texto.txt", "rw");                                          

            //Se pide la palabra a buscar
            System.out.print("Introduce palabra: ");
            palabra = sc.nextLine();
           
            //lectura del fichero
            cadena = fichero.readLine(); //leemos la primera l�nea
            while(cadena!=null){         //mientras no lleguemos al final del fichero
                indice = cadena.indexOf(palabra); //buscamos la palabra en la l�nea le�da
                while(indice!=-1){ //mientras la l�nea contenga esa palabra (por si est� repetida)
                   
                    //paso la l�nea a un StringBuilder para modificarlo
                    auxBuilder = new StringBuilder(cadena); 
                    auxBuilder.replace(indice, indice+palabra.length(), palabra.toUpperCase());                   
                    cadena = auxBuilder.toString();
                    
                    //nos posicionamos al principio de la l�nea actual y se sobrescribe la
                    //l�nea completa
                    //La posici�n donde empieza la l�nea actual la estoy guardando
                    //en la variable pos
                    fichero.seek(pos);
                    fichero.writeBytes(cadena);
                   
                    //compruebo si se repite la misma palabra en la l�nea
                    indice = cadena.indexOf(palabra);
                }
                pos = fichero.getFilePointer(); //posici�n de la l�nea actual que voy a leer
                cadena = fichero.readLine();    //lectura de la l�nea
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}