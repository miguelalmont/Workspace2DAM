package ejemplo2;



public class Libro {
	
	private String titulo;
	private String autor;
	private String isbn;
	private int paginas;
	
	
	public Libro() {
		
	}
	
	public Libro(String titulo, int paginas) {
		this.titulo = titulo;
		this.paginas = paginas;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getPaginas() {
		return paginas;
	}
	
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
}
