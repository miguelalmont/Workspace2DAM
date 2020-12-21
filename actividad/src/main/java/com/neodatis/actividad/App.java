package com.neodatis.actividad;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

/**
 * @author: Miguel Alcántara
 *
 */
public class App {
	public static void main(String[] args) {
		
		
		Jugadores j1 = new Jugadores("Jhon", "Fútbol", "Toledo", 16);
		Jugadores j2 = new Jugadores("Pepa", "Piragüismo", "Sevilla", 19);
		Jugadores j3 = new Jugadores("Anton", "Volleyball", "Madrid", 23);
		Jugadores j4 = new Jugadores("Isabel", "Natación", "Cádiz", 20);
		
		ODB odb = ODBFactory.open("prueba.jugadores");
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		odb.close();
		
	}
}
