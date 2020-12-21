package articventas;

public class Clientes implements Comparable<Clientes> {

	private int numcli ;
	private String nombre;
    private String pobla;
    
    public Clientes(){}
    
	public Clientes(int numcli, String nombre, String pobla) {
		super();
		this.numcli = numcli;
		this.nombre = nombre;
		this.pobla = pobla;
	}

     
	public int getNumcli() {
		return numcli;
	}
	public void setNumcli(int numcli) {
		this.numcli = numcli;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPobla() {
		return pobla;
	}
	public void setPobla(String pobla) {
		this.pobla = pobla;
	}

	@Override
	public int compareTo(Clientes o) {
		if (this.getNumcli() < o.getNumcli())
			return -1;
		else if (this.getNumcli() == o.getNumcli())
			return 0;
		else
			return 1;
	}
}
