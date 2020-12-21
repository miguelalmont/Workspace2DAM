
public class LeerNombre {

	public static void main(String[] args) {
		
		// Si el metodo main no recibe argumentos, se sale del programa y devuelve -1 de valor de salida.
		if (args.length == 0)
			System.exit(-1);
		
		// Por otro lado, si sí tiene argumentos, los imprime y luego termina el programa
		// devolviendo 1 de valor de salida
		else {
			for (int i = 0; i<args.length;i++)
				System.out.println(args[i]);
			System.exit(0);
		}
	}

}
