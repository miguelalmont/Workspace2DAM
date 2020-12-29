package actividad9;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			new Controlador(new Vista(), new Cliente()).iniciar();
		} catch (UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
