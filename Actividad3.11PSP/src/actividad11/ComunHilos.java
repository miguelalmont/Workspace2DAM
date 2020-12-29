package actividad11;

import java.net.Socket;

public class ComunHilos {
	
	private int conexiones;
	private int actuales;
	private int maximo;
	Socket[] tabla = new Socket[maximo];
	private String mensajes;
	
	public ComunHilos(int maximo, int actuales, int conexiones, Socket[] tabla) {
		this.maximo = maximo;
		this.actuales = actuales;
		this.conexiones = conexiones;
		this.tabla = tabla;
		this.mensajes = "";
	}
	
	public ComunHilos() {
		super();
	}

	/**
	 * @return the conexiones
	 */
	public int getConexiones() {
		return conexiones;
	}

	/**
	 * @param conexiones the conexiones to set
	 */
	public synchronized void setConexiones(int conexiones) {
		this.conexiones = conexiones;
	}

	/**
	 * @return the actuales
	 */
	public int getActuales() {
		return actuales;
	}

	/**
	 * @param actuales the actuales to set
	 */
	public synchronized void setActuales(int actuales) {
		this.actuales = actuales;
	}

	/**
	 * @return the maximo
	 */
	public int getMaximo() {
		return maximo;
	}

	/**
	 * @param maximo the maximo to set
	 */
	public void setMaximo(int maximo) {
		this.maximo = maximo;
	}

	/**
	 * @return the tabla
	 */
	public Socket[] getTabla() {
		return tabla;
	}

	
	public synchronized void addTabla(Socket s, int i) {
		this.tabla[i] = s;
	}

	/**
	 * @return the mensajes
	 */
	public String getMensajes() {
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public synchronized void setMensajes(String mensajes) {
		this.mensajes = mensajes;
	}
	
	public Socket getElementoTabla(int i) {
		return tabla[i];
	}
	
}
