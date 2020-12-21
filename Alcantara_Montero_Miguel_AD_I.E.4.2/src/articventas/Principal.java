package articventas;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class Principal {

	public static void main(String[] args) {
		
		// Descomentar si necesita crear la base de datos.
//		crearbd();

		mostrarVentas();

		mostrarSumaVentas();
		
		mostrarClientes();
		
		articMasVendido();
		
		mediaVentaPorArticulo();
		
		clienteMasVentas();
		
		pepe();

	}

	/////////////////////////////////////////
	public static void crearbd() {
		// creaci�n de registros en la BD
		File fichero = new File("ARTICVENTAS.DAT");
		if (fichero.delete())
			System.out.println("BD Borrada");
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		// creo los art�culos
		Articulos ar1 = new Articulos(1, "Mesas", 30, (float) 100.5);
		Articulos ar2 = new Articulos(2, "Pupitres", 10, (float) 150.7);
		Articulos ar3 = new Articulos(6, "Cuadernos", 100, (float) 4.5);
		Articulos ar4 = new Articulos(8, "Tabletas", 10, (float) 175.4);
		Articulos ar5 = new Articulos(9, "Bol�grafos", 100, (float) 3.5);
		Articulos ar6 = new Articulos(10, "Lapiceros", 300, (float) 2.5);
		Articulos ar7 = new Articulos(14, "Sillas", 30, (float) 120.5);
		Articulos ar8 = new Articulos(16, "Port�til", 25, (float) 400.5);

		Articulos ar11 = new Articulos(17, "Espejo ba�o", 20, (float) 100.5);
		Articulos ar21 = new Articulos(18, "Reloj cocina", 10, (float) 20.7);
		Articulos ar31 = new Articulos(20, "Tarjetero", 50, (float) 14.5);
		Articulos ar41 = new Articulos(22, "Estuches", 110, (float) 20.4);
		Articulos ar51 = new Articulos(23, "Libro BD", 10, (float) 23.5);
		Articulos ar61 = new Articulos(24, "Tijeras", 30, (float) 5.0);
		Articulos ar71 = new Articulos(25, "Cubiertos", 130, (float) 10.5);
		Articulos ar81 = new Articulos(26, "Teclado", 25, (float) 40.5);

		// Almacenamos art�culos 16 art�culos
		odb.store(ar1);
		odb.store(ar2);
		odb.store(ar3);
		odb.store(ar4);
		odb.store(ar5);
		odb.store(ar6);
		odb.store(ar7);
		odb.store(ar8);
		odb.store(ar11);
		odb.store(ar21);
		odb.store(ar31);
		odb.store(ar41);
		odb.store(ar51);
		odb.store(ar61);
		odb.store(ar71);
		odb.store(ar81);

		// Creo los Clientes 12 clientes, num, nom, pob

		Clientes cli1 = new Clientes(1, "Antonio Ruiz", "Talavera");
		Clientes cli2 = new Clientes(2, "La Alameda S.L.", "Talavera");
		Clientes cli3 = new Clientes(7, "Los molinos CB", "Madrid");
		Clientes cli4 = new Clientes(8, "Pedro Mor�n S.L.", "Talavera");
		Clientes cli5 = new Clientes(12, "Azulejos Mart�n S.L.", "Talavera");
		Clientes cli6 = new Clientes(15, "Bar Girasol", "Oropesa");
		Clientes cli7 = new Clientes(9, "Escuela Mayores", "Talavera");
		Clientes cli8 = new Clientes(17, "Galer�a Madrid S.L.", "Madrid");
		Clientes cli9 = new Clientes(19, "El corte Chino", "Talavera");
		Clientes cli10 = new Clientes(20, "UNICAS S.A.", "Oropesa");
		Clientes cli11 = new Clientes(21, "Deportivo SAS", "Talavera");
		Clientes cli12 = new Clientes(22, "Academia Padel", "Madrid");

		odb.store(cli1);
		odb.store(cli2);
		odb.store(cli3);
		odb.store(cli4);
		odb.store(cli5);
		odb.store(cli6);
		odb.store(cli7);
		odb.store(cli8);
		odb.store(cli9);
		odb.store(cli10);
		odb.store(cli11);
		odb.store(cli12);

		// crear unas ventas

		// ventas para el art�culo 1
		Ventas v1 = new Ventas(1, cli1, 5, "05/06/2014");
		Ventas v2 = new Ventas(2, cli2, 4, "15/06/2014");
		Ventas v3 = new Ventas(3, cli6, 3, "25/06/2014");

		Set<Ventas> vvvv = new HashSet<Ventas>();
		vvvv.add(v1);
		vvvv.add(v2);
		vvvv.add(v3);
		ar1.setCompras(vvvv);

		// ventas para el art�culo 2
		Ventas v4 = new Ventas(4, cli6, 5, "03/07/2014");
		Ventas v5 = new Ventas(5, cli7, 4, "11/08/2014");

		Set<Ventas> vv2 = new HashSet<Ventas>();
		vv2.add(v4);
		vv2.add(v5);
		ar2.setCompras(vv2);
		// ventas para el art�culo 3
		Ventas v6 = new Ventas(6, cli1, 3, "25/04/2014");
		Set<Ventas> vv3 = new HashSet<Ventas>();
		vv3.add(v6);
		ar3.setCompras(vv3);

		// ventas para el art�culo 4
		Ventas v7 = new Ventas(7, cli10, 3, "15/03/2014");
		Ventas v8 = new Ventas(8, cli10, 4, "01/05/2014");
		Ventas v9 = new Ventas(9, cli11, 6, "25/04/2014");
		Ventas v10 = new Ventas(10, cli12, 2, "20/05/2014");
		Set<Ventas> vv4 = new HashSet<Ventas>();
		vv4.add(v7);
		vv4.add(v8);
		vv4.add(v9);
		vv4.add(v10);
		ar4.setCompras(vv4);

		// ventas para el art�culo 5
		Ventas v11 = new Ventas(11, cli1, 1, "10/05/2014");
		Ventas v12 = new Ventas(12, cli7, 3, "01/06/2014");
		Ventas v13 = new Ventas(13, cli8, 6, "25/06/2014");
		Ventas v14 = new Ventas(14, cli9, 5, "10/07/2014");
		Ventas v15 = new Ventas(15, cli9, 4, "15/09/2014");
		Set<Ventas> vv5 = new HashSet<Ventas>();
		vv5.add(v11);
		vv5.add(v12);
		vv5.add(v13);
		vv5.add(v14);
		vv5.add(v15);
		ar5.setCompras(vv5);

		odb.store(v1);
		odb.store(v2);
		odb.store(v3);
		odb.store(v4);
		odb.store(v5);
		odb.store(v6);
		odb.store(v7);
		odb.store(v8);
		odb.store(v9);
		odb.store(v10);
		odb.store(v11);
		odb.store(v12);
		odb.store(v13);
		odb.store(v14);
		odb.store(v15);

		odb.store(ar1);
		odb.store(ar2);
		odb.store(ar3);
		odb.store(ar4);
		odb.store(ar5);

		odb.commit();

		odb.close();
		System.out.println("BASE DE DATOS CREADA");

	}

	/**
	 * Visualiza los datos de cada venta.
	 */
	public static void mostrarVentas() {
		
		// Abrimos la base de datos.
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos los valores que necesitamos especificando que el campo Compras no sea null.
		Values valores = odb.getValues(new ValuesCriteriaQuery(Articulos.class, Where.isNotNull("Compras"))
				.field("codarti").field("denom").field("pvp"));
		
		// Obtenemos las colecciones Ventas que contiene cada celda de Compras en una colecci�n de Objects,
		// especificando que el campo Compras no sea null.
		Objects<Articulos> listasVentas = odb
				.getObjects(new CriteriaQuery(Articulos.class, Where.isNotNull("Compras")));
		
		// Recorremos los valores obtenidos de la tabla Art�culos.
		while (valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();
			
			// Obtenemos la colecci�n de Ventas de esta fila.
			Set<Ventas> ventas = listasVentas.next().getCompras();
			
			System.out.println("***** INFORMACI�N DE CADA VENTA ARTICULO " + objectValues.getByIndex(0) + " *****");
			
			// Recorremos, ordenamos e imprimimos una l�nea con todos los datos solicitados.
			ventas.stream().sorted()
					.forEach(v -> System.out.printf(
							"C�digo Venta: %d, C�digo Art�culo: %d, Denominaci�n: %s, N�mero Cliente: %d, "
									+ "Nombre: %s, Fecha: %s, Univen: %d, Importe: %1.2f %n",
							v.getCodventa(), objectValues.getByIndex(0), objectValues.getByIndex(1),
							v.getNumcli().getNumcli(), v.getNumcli().getNombre(), v.getFecha(), v.getUniven(),
							v.getUniven() * (float) objectValues.getByIndex(2)));
		}
		
		// Cerramos la base de datos.
		odb.close();
	}

	/**
	 * Visualiza por cada articulo la suma de unidades vendidas, el importe, y el
	 * n�mero de ventas en las que se ha vendido.
	 */
	public static void mostrarSumaVentas() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos los valores que necesitamos de cada Art�culo.
		Values valores = odb.getValues(
				new ValuesCriteriaQuery(Articulos.class).field("codarti").field("denom").field("stock").field("pvp"));
		
		// Obtenemos las colecciones de Ventas especificando que el campo Compras no sea null.
		Objects<Articulos> listasVentas = odb
				.getObjects(new CriteriaQuery(Articulos.class, Where.isNotNull("Compras")));

		System.out.println("*****INFORMACI�N DE CADA ART�CULO*****");
		
		// Recorremos los valores.
		while (valores.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valores.next();

			int sumaUniven = 0;
			float sumaImporte = 0;
			int numVentas = 0;
			
			// Recorremos la segunda colecci�n que contiene todas las ventas.
			if (listasVentas.hasNext()) {
				
				// Obtenemos la colecci�n de ventas de esta fila.
				Set<Ventas> ventas = listasVentas.next().getCompras();
				
				// Por cada venta, incrementamos las unidades vendidas, almacenamos el importe total e
				// incrementamos el numero de ventas que contiene esta fila.
				for (Ventas venta : ventas) {
					sumaUniven += venta.getUniven();
					sumaImporte += venta.getUniven() * (float) objectValues.getByAlias("pvp");
					numVentas++;
				}
			}
			
			// Imprimimos la l�nea con los datos solicitados.
			System.out.printf(
					"C�digo Art�culo: %d, Denominaci�n: %s, Stock: %d, PVP: %1.2f, Suma Univen: %d , Importe: %1.2f, N�mero Ventas: %d %n",
					objectValues.getByAlias("codarti"), objectValues.getByAlias("denom"),
					objectValues.getByAlias("stock"), objectValues.getByAlias("pvp"), sumaUniven, sumaImporte,
					numVentas);
		}
		odb.close();
	}

	/**
	 * Visualiza informaci�n de cada cliente.
	 */
	public static void mostrarClientes() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos la colecci�n de valores que se nos solicita.
		Values valoresCli = odb.getValues(
				new ValuesCriteriaQuery(Clientes.class).field("numcli").field("nombre").field("pobla"));
		
		// Establecemos un criterio para la siguiente b�squeda.
		ICriterion criterio = Where.isNotNull("Compras");
		
		// Obtenemos las colecciones de Ventas a�adiendo el criterio anterior.
		Objects<Articulos> valoresVent = odb.getObjects(
				new CriteriaQuery(Articulos.class, criterio));
		
		System.out.println("***** INFORMACI�N DE CADA CLIENTE *****");
		
		// Recorremos y obtenemos los valores.
		while (valoresCli.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valoresCli.next();
			
			float importeTotal = 0;
			int numVentas = 0;
			
			// Recorremos cada Art�culo que contenga una o m�s Ventas.
			for (Articulos articulo : valoresVent) {
				
				// Contamos el total de ventas del cliente y lo almacenamos.
				numVentas += articulo.getCompras().stream().filter(v -> v.getNumcli().getNumcli() == (int) objectValues.getByAlias("numcli")).count();
				
				// Recuperamos y almacenamos la lista de ventas de ese cliente por cada campo.
				List<Ventas> ventaCliente = articulo.getCompras().stream().filter(v -> v.getNumcli().getNumcli() == (int) objectValues.getByAlias("numcli")).collect(Collectors.toList());
				
				// Recorremos esta nueva lista e incrementamos el importe total obtenido
				// de la multiplicaci�n unidades vendidas por pvp.
				for (Ventas venta : ventaCliente)
					importeTotal += venta.getUniven() * articulo.getPvp();
			}
			
			// Imprimimos la l�nea con los valores solicitados.
			System.out.printf(
					"N�mero Cliente: %d, Nombre: %s, Poblaci�n: %s, Importe Total: %1.2f, N�mero de Ventas: %d %n",
					objectValues.getByAlias("numcli"),
					objectValues.getByAlias("nombre"),
					objectValues.getByAlias("pobla"),
					importeTotal,
					numVentas
					);
		}
		odb.close();
	}

	/**
	 * Visualiza informaci�n del art�culo m�s vendido.
	 */
	public static void articMasVendido() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos los Art�culos que contengan Ventas estableciendo un criterio de b�squeda.
		ICriterion criterio = Where.isNotNull("Compras");
		Objects<Articulos> valoresVent = odb.getObjects(
				new CriteriaQuery(Articulos.class, criterio));
		
		System.out.println("***** ART�CULO M�S VENDIDO ******");
		
		int maxUniven = 0;
		Articulos maxVent = null;
		
		// Recorremos cada art�culo
		for (Articulos articulo : valoresVent) {
			
			int univen = 0;
			
			// Recorremos cada venta que contenga este art�culo e incrementamos
			// el n�mero de unidades vendidas.
			for (Ventas venta : articulo.getCompras())
				univen += venta.getUniven();
			
			// Si las ventas de este Art�culo son mayores que las del anterior,
			// almacenamos el Art�culo.
			if (univen > maxUniven) {
				maxUniven = univen;
				maxVent = articulo;
			}
		}
		
		// Imprimimos la l�nea con los datos solicitados.
		System.out.println("Nombre Art�culo: " + maxVent.getDenom() + ", Unidades Vendidas: " + maxUniven);
		odb.close();
	}

	/**
	 * Visualiza la media del importe de las ventas por cada art�culo.
	 */
	public static void mediaVentaPorArticulo() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos los Art�culos que contengan Ventas estableciendo un criterio de b�squeda.
		ICriterion criterio = Where.isNotNull("Compras");
		Objects<Articulos> valores = odb.getObjects(
				new CriteriaQuery(Articulos.class, criterio));
		
		System.out.println("***** MEDIA DEL IMPORTE DE LAS VENTAS POR ART�CULO *****");
		
		// Recorremos cada Art�culo
		for (Articulos articulo : valores) {
			
			float mediaImporte = 0;
			
			// Recorremos cada venta que contiene este Art�culo.
			for (Ventas venta : articulo.getCompras()) {
				
				// Almacenamos la media del precio por venta de cada art�culo.
				mediaImporte = (float) (venta.getUniven() * articulo.getPvp()) / articulo.getCompras().size();
			}
			
			// Imprimimos la l�nea con los datos solicitados.
			System.out.printf("C�digo Art�culo: %d, Media: %1.2f %n", articulo.getCodarti(), mediaImporte);
		}
		odb.close();
	}

	/**
	 * Visualiza informaci�n del cliente con m�s ventas.
	 */
	public static void clienteMasVentas() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		
		// Obtenemos los Art�culos que contengan Ventas estableciendo un criterio de b�squeda.
		ICriterion criterio = Where.isNotNull("Compras");
		Objects<Articulos> valores = odb.getObjects(
				new CriteriaQuery(Articulos.class, criterio));
		
		System.out.println("***** CLIENTE CON MAS VENTAS *****");
		
		int numVentas = 0;
		Clientes clienteMaxVentas = null;
		List<Clientes> clientes = new ArrayList<>();
		
		// Recorremos cada art�culo.
		for (Articulos articulo : valores) {
			
			// Recorremos cada venta que contiene este art�culo y
			// recuperamos y almacenamos en una lista cada Cliente.
			for (Ventas venta : articulo.getCompras()) {
				clientes.add(venta.getNumcli());
			}
			
		}
		
		// Recorremos la lista de Clientes reci�n creada comparando cada cliente con todos los dem�s,
		// si encuentra similitud, incrementa un contador y se almacena el cliente.
		for (Clientes cliente1 : clientes) {
			int contador = 0;
			Clientes cliente = null;
			for (Clientes cliente2 : clientes) {
				if (cliente1.compareTo(cliente2) == 0) {
					contador++;
					cliente = cliente1;
				}
			}
			
			// Si el contador es mayor al numero de ventas totales, almacenamos su valor
			// y el cliente.
			if (contador > numVentas) {
				numVentas = contador;
				clienteMaxVentas = cliente;
			}
		}
		
		// Imprimimos el nombre del cliente con mas ventas y el total de ventas
		// con las que est� relacionado.
		System.out.println("Nombre: " + clienteMaxVentas.getNombre() + ", Total Ventas: " + numVentas);
		
		odb.close();
	}
	
	public static void pepe() {
		ODB odb = ODBFactory.open("ARTICVENTAS.DAT");
		ICriterion criterio = Where.isNotNull("Compras");
		Values valoresCli = odb.getValues(
				new ValuesCriteriaQuery(Articulos.class, criterio).field("Compras"));
		
		while(valoresCli.hasNext()) {
			ObjectValues objectValues = (ObjectValues) valoresCli.next();
			
			System.out.println(objectValues.getByIndex(0));
		}
	}
}
