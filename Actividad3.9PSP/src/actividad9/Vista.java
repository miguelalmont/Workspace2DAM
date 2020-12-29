package actividad9;

import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class Vista extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel;
	public JTextField textField1;
	public JTextField textField2;
	public JButton btnsend;
	public JButton btnout;
	public JButton btnclean;

	Vista() {
		initComponents();
	}

	private void initComponents() {

		jLabel = new JLabel();
		textField1 = new JTextField();
		textField2 = new JTextField();
		btnsend = new JButton();
		btnout = new JButton();
		btnclean = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		jLabel.setText("Escribe Texto:");
		textField2.setEditable(false);
		btnsend.setText("Enviar");
		btnout.setText("Salir");
		btnclean.setText("Limpiar");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel).addComponent(textField1)
								.addComponent(textField2, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))
						.addGap(60, 60, 60)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(btnclean, GroupLayout.Alignment.TRAILING,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnout, GroupLayout.Alignment.TRAILING,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(btnsend, GroupLayout.Alignment.TRAILING,
										GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addGap(25, 25, 25)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel).addComponent(btnsend))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(textField1, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnout))
						.addGap(15, 15, 15)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(textField2, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnclean))
						.addGap(40, 40, 40)));

		pack();
	}

	public static void main(String args[]) {
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex) {
			Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
		}

		EventQueue.invokeLater(() -> {
			new Vista().setVisible(true);
		});
	}
}
