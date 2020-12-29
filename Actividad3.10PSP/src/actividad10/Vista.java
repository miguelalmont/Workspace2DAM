package actividad10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.WindowConstants;

public class Vista extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public Vista() {
        initComponents();
    }

    public void initComponents() {

        jLabel1 = new JLabel();
        IDplayer = new JTextField();
        jLabel2 = new JLabel();
        trying = new JTextField();
        jLabel3 = new JLabel();
        numerotxt = new JTextField();
        btnAdivi = new JButton();
        result = new JTextField();
        btnout = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("ID JUGADOR:");
        IDplayer.setEditable(false);
        jLabel2.setText("INTENTOS:");
        trying.setEditable(false);
        jLabel3.setText("NUMERO A ADIVINAR");
        btnAdivi.setText("Enviar");
        result.setEditable(false);
        btnout.setText("Salir");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnout)
                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addComponent(result)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel1)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(IDplayer, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addGap(20, 20, 20)
                                                                        .addComponent(numerotxt, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(50, 50, 50)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(jLabel2)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(trying, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(btnAdivi)))))
                                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(IDplayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(trying, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(numerotxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAdivi))
                                .addGap(30, 30, 30)
                                .addComponent(result, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnout)
                                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }

    public void btnAdivinarActionPerformed(ActionEvent evt) {
        System.out.println("Acertaste");
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> {
            new Vista().setVisible(true);
        });
    }

    private JLabel jLabel1;
    public JTextField IDplayer;
    private JLabel jLabel2;
    public JTextField trying;
    private JLabel jLabel3;
    public JTextField numerotxt;
    public JButton btnAdivi;
    public JTextField result;
    public JButton btnout;
}
