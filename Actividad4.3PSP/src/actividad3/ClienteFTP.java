package actividad3;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class ClienteFTP extends JFrame {

	/** SERIAL UID */
	private static final long serialVersionUID = 1L;

	static JTextField cab = new JTextField();
	static JTextField cab2 = new JTextField();
	static JTextField cab3 = new JTextField();

	private static JTextField campo = new JTextField();
	private static JTextField campo2 = new JTextField();

	JButton botonDescargar = new JButton("Descargar fichero");
	JButton botonSalir = new JButton("Salir");

	JButton botonlogin = new JButton("login");

	@SuppressWarnings("rawtypes")
	static JList direcciones = new JList();

	private final Container c = getContentPane();

	static FTPClient cliente = new FTPClient();
	String servidor = "localhost";
	String usuario = "";
	String pass = "";
	boolean login;

	static String direccionInicio = "/";
	static String dirSeleccion = direccionInicio;
	static String archivoSeleccionado = "";

	public ClienteFTP() throws SocketException, IOException {
		cliente.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		cliente.connect(servidor);
		cliente.enterLocalPassiveMode();

		JFrame loginPanel = new JFrame();
		JLabel userLabel = new JLabel("Usuario:");
		JLabel passLabel = new JLabel("Password:");
		JTextField userField = new JTextField();
		JPasswordField passField = new JPasswordField();

		loginPanel.setSize(400, 400);
		loginPanel.setVisible(true);

		loginPanel.add(userLabel);
		loginPanel.add(passLabel);
		loginPanel.add(userField);
		loginPanel.add(passField);
		loginPanel.add(botonlogin);

		Dimension userSize = userLabel.getPreferredSize();
		userLabel.setBounds(50, 90, userSize.width, userSize.height);
		userLabel.setVisible(true);

		Dimension contraTamanio = passLabel.getPreferredSize();
		passLabel.setBounds(50, 130, contraTamanio.width, contraTamanio.height);

		userField.setBounds(130, 90, 180, 20);
		userField.setVisible(true);

		passField.setBounds(130, 130, 180, 20);
		passField.setVisible(true);

		botonlogin.setBounds(120, 300, 130, 30);

		direcciones.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent lse) {
				if (lse.getValueIsAdjusting()) {
					archivoSeleccionado = "";

					String fic = direcciones.getSelectedValue().toString();

					if (direcciones.getSelectedIndex() == 0) {
						if (!fic.equals(direccionInicio)) {
							try {
								cliente.changeToParentDirectory();
								dirSeleccion = cliente.printWorkingDirectory();
								FTPFile[] ff2 = null;

								cliente.changeWorkingDirectory(dirSeleccion);
								ff2 = cliente.listFiles();
								campo.setText("");

								createList(ff2, dirSeleccion);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					} else {
						if (fic.substring(0, 6).equals("(DIR) ")) {
							try {
								fic = fic.substring(6);
								String dirSeleccion2 = "";
								if (dirSeleccion.equals("/"))
									dirSeleccion2 = dirSeleccion + fic;
								else
									dirSeleccion2 = dirSeleccion + "/" + fic;

								cliente.changeWorkingDirectory(dirSeleccion2);
								FTPFile[] ff2 = cliente.listFiles();
								campo.setText("DIRECTORIO: " + fic + ", " + ff2.length + " elementos");
								dirSeleccion = dirSeleccion2;
								createList(ff2, dirSeleccion);
							} catch (IOException e2) {
								e2.printStackTrace();
							}
						} else {
							archivoSeleccionado = dirSeleccion;
							if (dirSeleccion.equals("/"))
								archivoSeleccionado += fic;
							else
								archivoSeleccionado += "/" + fic;
						}
					}
					campo2.setText("DIRECTORIO ACTUAL: " + dirSeleccion);
				}
			}
		});

		botonSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.disconnect();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				System.exit(0);

			}
		});

		botonlogin.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				usuario = userField.getText();
				pass = passField.getText();
				System.out.println("PASS==>" + pass);
				try {
					login(usuario, pass, loginPanel);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		botonDescargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String directorio = dirSeleccion;
				if (!dirSeleccion.equals("/"))
					directorio = directorio + "/";
				if (!archivoSeleccionado.contentEquals("")) {
					download(directorio + archivoSeleccionado, archivoSeleccionado);
				}

			}
		});
	}

	private void login(String usuario, String pass, JFrame loginPanel) throws IOException {
		login = cliente.login(usuario, pass);
		if (login) {
			loginPanel.setVisible(false);
			cliente.changeWorkingDirectory(direccionInicio);

			FTPFile[] files = cliente.listFiles();

			createList(files, direccionInicio);

			campo.setText("<<ARBOL DE DIRECTORIOS CONSTRUIDO>>");
			cab.setText("Servidor FTP: " + servidor);
			cab2.setText("Usuario: " + usuario);
			cab3.setText("DIRECTORIO RAIZ: " + direccionInicio);

			direcciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JScrollPane barraDesplazamiento = new JScrollPane(direcciones);
			barraDesplazamiento.setPreferredSize(new Dimension(335, 420));
			barraDesplazamiento.setBounds(new Rectangle(5, 65, 335, 420));
			c.add(barraDesplazamiento);
			c.setLayout(null);

			botonDescargar.setBounds(370, 115, 150, 30);
			add(botonDescargar);

			botonSalir.setBounds(370, 315, 150, 30);
			add(botonSalir);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(580, 600);
			setVisible(true);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void createList(FTPFile[] files, String direc2) {
		if (files == null)
			return;

		DefaultListModel lista = new DefaultListModel();

		direcciones.setForeground(Color.blue);
		Font fuente = new Font("Courier", Font.PLAIN, 12);
		direcciones.setFont(fuente);

		direcciones.removeAll();

		try {
			cliente.changeWorkingDirectory(direc2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dirSeleccion = direc2;

		lista.addElement(direc2);

		for (int i = 0; i < files.length; i++) {
			if (!(files[i].getName()).equals(".") && !(files[i].getName()).equals("..")) {
				String f = files[i].getName();

				if (files[i].isDirectory())
					f = "(DIR) " + f;

				lista.addElement(f);
			}
		}

		try {
			direcciones.setModel(lista);
		} catch (NullPointerException n) {
			;
		}
	}

	private void download(String nombreCompleto, String nombreFichero) {
		String destino = "";
		String directorioDestino = "";
		JFileChooser f = new JFileChooser();

		f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		f.setDialogTitle("Selecciona el Directorio donde DESCARGAR el fichero");

		int returnVal = f.showDialog(null, "Descargar");
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = f.getSelectedFile();
			directorioDestino = (file.getAbsolutePath()).toString();
			destino = directorioDestino + File.separator + nombreFichero;
			try {
				cliente.setFileType(FTP.BINARY_FILE_TYPE);
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destino));
				if (cliente.retrieveFile(nombreCompleto, out))
					JOptionPane.showMessageDialog(null, nombreFichero + " se ha descargado con exito");
				else
					JOptionPane.showMessageDialog(null, "No se ha podido descargar: " + nombreFichero);
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) throws SocketException, IOException {
		new ClienteFTP();
	}
}
