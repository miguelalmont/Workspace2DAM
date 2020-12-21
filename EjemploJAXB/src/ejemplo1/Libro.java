package ejemplo1;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Libro {
	
	private String titulo;
	private int paginas;
	
	public Libro() {
		
	}
	
	public Libro(String titulo, int paginas) {
		this.titulo = titulo;
		this.paginas = paginas;
	}

	@XmlElement
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@XmlElement
	public int getPaginas() {
		return paginas;
	}
	
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
