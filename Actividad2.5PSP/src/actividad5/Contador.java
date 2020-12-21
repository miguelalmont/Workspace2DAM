package actividad5;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class Contador extends Applet implements ActionListener{
	
	class HiloContador extends Thread {
		 
		private int contador;
		
		public HiloContador(int contador) {
			this.contador = contador;
		}
		
		public void run() {
			try {
				while (this == Thread.currentThread() && !isInterrupted()) {
					Thread.sleep(300);
					repaint();
					contador++;
				}
			} catch (InterruptedException e) {}
		}
		
		public int getContador() {
			return contador;
		}
		
	}
	
	private HiloContador h1  = new HiloContador(101);;
	private HiloContador h2  = new HiloContador(121);
	private Font fuente;
	private Button b1,b2;
	
	@Override
	public void start() {
		h1.start();
		h2.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			b1.setLabel("Finalizado Hilo 1");
			h1.interrupt();
		}
		if (e.getSource() == b2){
			b2.setLabel("Finalizado Hilo 2");
			h2.interrupt();
		}
		
	}
	
	@Override
	public void stop() {
		h1 = null;
		h2 = null;
	}
	
	@Override
	public void init() {
		setBackground(Color.yellow);
		add(b1 = new Button("Finalizar Hilo 1"));
		b1.addActionListener(this);
		add(b2 = new Button("Finalizar Hilo 2"));
		b2.addActionListener(this);
		fuente = new Font("Verdana", Font.BOLD, 26);
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 400, 600);
		g.setFont(fuente);
		g.drawString("Hilo 1: " + Integer.toString(h1.getContador()), 20, 100);
		g.drawString("Hilo 2: " + Integer.toString(h2.getContador()), 20, 140);
	}
	
}
