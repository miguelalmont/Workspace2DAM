package actividad10;

import java.io.IOException;

import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, IOException, UnsupportedLookAndFeelException {
		new Controlador(new Vista(), new JugadorAdivina()).iniciar();
	}
}
