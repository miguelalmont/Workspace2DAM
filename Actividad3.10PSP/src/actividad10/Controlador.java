package actividad10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controlador implements ActionListener, MouseListener {

	private final Vista vista;
	private final JugadorAdivina jugador;
	private boolean boo = false;

	public Controlador(Vista vista, JugadorAdivina jugador) {
		this.vista = vista;
		this.jugador = jugador;
	}

	public enum AccionMVC {
		tryingd
	}

	public void iniciar() throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(vista);
			vista.setVisible(true);
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
				| IllegalAccessException ex) {
		}

		jugador.Conectar();
		this.vista.IDplayer.setText(Integer.toString(jugador.getIdentificador()));
		this.vista.trying.setText("0");
		this.vista.result.setText("Adivina un numero entre 1 y 25");

		this.vista.btnAdivi.setActionCommand("tryingd");
		this.vista.btnAdivi.addActionListener(this);
		this.vista.btnout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case tryingd:
			if (boo && jugador.getDatos().getIntentos() > 5) {
				JOptionPane.showMessageDialog(null, "Ha alcanzado el maximo numero de intentos");
			} else {
				try {
					jugador.EnviarNumero(this.vista.numerotxt.getText());
					boo = true;
					this.vista.result.setText(jugador.getCadena());
					this.vista.trying.setText(Integer.toString(jugador.getDatos().getIntentos()));
				} catch (IOException | ClassNotFoundException e2) {
				}
			}
			break;
		}
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void mousePressed(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void mouseExited(MouseEvent me) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
