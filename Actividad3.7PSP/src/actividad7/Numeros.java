package actividad7;

import java.io.Serializable;

public class Numeros implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	int numero;
	long cuadrado;
	long cubo;
	
	public Numeros() {}

	public Numeros(int numero, long cuadrado, long cubo) {
		this.numero = numero;
		this.cuadrado = cuadrado;
		this.cubo = cubo;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the cuadrado
	 */
	public long getCuadrado() {
		return cuadrado;
	}

	/**
	 * @param cuadrado the cuadrado to set
	 */
	public void setCuadrado(long cuadrado) {
		this.cuadrado = cuadrado;
	}

	/**
	 * @return the cubo
	 */
	public long getCubo() {
		return cubo;
	}

	/**
	 * @param cubo the cubo to set
	 */
	public void setCubo(long cubo) {
		this.cubo = cubo;
	}
	

}
