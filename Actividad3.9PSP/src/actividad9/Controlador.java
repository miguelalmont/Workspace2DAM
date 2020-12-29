package actividad9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Controlador implements ActionListener, MouseListener{
	
	private final Vista vista;
    private final Cliente cliente;

    public enum AccionMVC {
        send, out, clean
    }

    public Controlador(Vista vista, Cliente cliente) {
        this.vista = vista;
        this.cliente = cliente;
    }

    public void iniciar() throws IOException, ClassNotFoundException, UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {}

        this.vista.btnsend.setActionCommand("send");
        this.vista.btnsend.addActionListener(this);
        this.vista.btnout.setActionCommand("out");
        this.vista.btnout.addActionListener(this);
        this.vista.btnclean.setActionCommand("clean");
        this.vista.btnclean.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionMVC.valueOf(e.getActionCommand())) {
            case send:
                System.out.println(this.vista.textField1.getText());
                try {
                    this.cliente.enviar(this.vista.textField1.getText());
                    this.vista.textField2.setText(this.cliente.recibe());
                } catch (IOException e2) {
                }
                break;
            case out:
                try {
                    this.cliente.cerrar();
                } catch (IOException e2) {
                }
                System.exit(0);
                break;
            case clean:
                this.vista.textField1.setText("");
                this.vista.textField2.setText("");
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
