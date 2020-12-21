package neodatis;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jugadores j1 = new Jugadores("Jhon", "F�tbol", "Toledo", 16);
		Jugadores j2 = new Jugadores("Pepa", "Pirag�ismo", "Sevilla", 19);
		Jugadores j3 = new Jugadores("Anton", "Volleyball", "Madrid", 23);
		Jugadores j4 = new Jugadores("Isabel", "Nataci�n", "C�diz", 20);
		
		ODB odb = ODBFactory.open("test");
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		odb.close();
	}

}
