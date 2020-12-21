package operaciones;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import clasesdatos.Ventas.Venta;
import clasesdatos.*;

public class principal {
	
	// Variable que almacena el objeto jaxbElement que creamos con el metodo leerXML.
	private static JAXBElement jaxbElement;
	
	// Variable que almacena el objeto VentasType que nos servira para trabajar con los datos del XML
	// como objetos JAVA.
	private static VentasType totalVentas;
	
	public static void main(String[] args) {
		
		// Inserta venta (este metodo ya estaba hecho)
		insertarventa(30, "Cliente 2", 10, "16-12-2015");
		
		// Borramos la venta con numero de venta 30.
		borrarVenta(30);
		
		// Incrementamos el valor de Stock del articulo en 10.
		modificarStock(10);
		
		// Cambiamos los datos de la venta numero 10, por 15 unidades y una nueva fecha.
		System.out.println(cambiarDatosVenta(10, 15, "07/10/2020"));
		
		// Visualizamos el XML para ver los cambios (este metodo ya estaba hecho)
		visualizarxml();
	}

	////////////////////////////////////////
	public static void visualizarxml() {

		System.out.println("------------------------------ ");
		System.out.println("-------VISUALIZAR XML--------- ");
		System.out.println("------------------------------ ");
		try {
			// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

			// Crear un objeto de tipo Unmarshaller para convertir datos XML en
			// un árbol de objetos Java
			Unmarshaller u = jaxbContext.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML
			// en este caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(jaxbElement, System.out);

			// Si queremos operar con el documento obtenemos los
			// objetos del jaxbElement
			// El método getValue() retorna el modelo de contenido (content
			// model) y el valor de los atributos del elemento

			VentasType miventa =  totalVentas; //(VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			// Datos del artículo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();

			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Stock art: " + miartic.getStock());
			System.out.println("Ventas  del artículo , hay: " + listaVentas.size());

			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				System.out.println("Número de venta: " + ve.getNumventa() + ". Nombre cliente: " + ve.getNombrecliente()
						+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
			}

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}

	/////////////////////////////////////////////////
	private static void insertarventa(int numeventa, String nomcli, int uni, String fecha) {

		System.out.println("---------------------------- ");
		System.out.println("-------AÑADIR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el número de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}

			if (existe == 0) {
				// Crear el objeto Ventas.Venta, y si no existe se añade a la
				// lista

				Ventas.Venta ve = new Ventas.Venta();
				ve.setNombrecliente(nomcli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				// añadimos la venta a la lista

				listaVentas.add(ve);

				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));

				System.out.println("Venta añadida: " + numeventa);

			} else

				System.out.println("En número de venta ya existe: " + numeventa);

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
	/////////////////////////////
	
	// Metodo que lee el XML y almacena el jaxbElement y el VentasType que contiene.
	public static void leerXML() {
		JAXBContext jaxbContext;
		try {
			
			// Leemos el XML
			jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("./ventasarticulos.xml"));
			
			// Almacenamos el objeto VentasType que contiene toda la jerarquía
			// del XML transformados a objetos Java.
			totalVentas = (VentasType) jaxbElement.getValue();
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Metodo que escribe el contenido del objeto VentasType en el XML.
	public static void escribirXML() {
		
		// Almacenamos el objeto VentasType como valor de jaxbElement.
		jaxbElement.setValue(totalVentas);
		
		try {
			
			// Creamos el contexto JAXB para poder crear un Marshaller y escribir sobre el fichero XML
			// con el contenido de jaxbElement.
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(jaxbElement, new FileOutputStream("./ventasarticulos.xml"));
			
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Metodo que borra una venta del fichero XML.
	public static boolean borrarVenta(int numeroVenta) {
		
		// Llamamos al metodo que lee el archivo XML.
		leerXML();
		
		boolean flag = false;
		
		// Recuperamos el objeto Venta en caso de que coincida con el numero que pasamos por parametro,
		// en caso de que no exista, devuelve null;
		Ventas.Venta venta = totalVentas.getVentas().getVenta().stream()
							.filter(v -> v.getNumventa().intValue() == numeroVenta)
							.findAny().orElse(null);

		
		// Si la venta que recuperamos no es nula, se borra y
		// machacamos el nuevo contenido en el fichero XML.
		if (venta != null) {
			totalVentas.getVentas().getVenta().remove(venta);
			escribirXML();
			flag = true;
		}
		else {
			flag = false;
		}
		
		// Devolvemos true en caso de que se haya borrado y false en caso contrario.
		return flag;
		
	}
	
	// Metodo que incrementa el Stock del articulo del fichero XML.
	public static boolean modificarStock(int stock) {
		
		leerXML();
		
		// Recuperamos el articulo del objeto VentasType.
		DatosArtic articulo = totalVentas.getArticulo();
		boolean flag = false;
		
		// Si el articulo existe, añadimos la cantidad que recibimos por parametro al atributo Stock
		// y escribimos sobre el XML.
		if (articulo != null) {
			articulo.setStock(articulo.getStock().add(BigInteger.valueOf(stock)));
			escribirXML();
			flag = true;
		}
		else {
			flag = false;
		}
		
		// Devolvemos true en caso de que se haya modificado y false en caso contrario.
		return flag;
	}
	
	// Metodo que cambia los datos Unidades y Fecha de una Venta.
	public static boolean cambiarDatosVenta(int numeroVenta, int unidades, String fecha) {
		
		leerXML();
		
		boolean flag = false;
		
		// Recuperamos la venta si coincide con el parametro de entrada numeroVenta, y si no
		// devuelve null.
		Ventas.Venta venta = totalVentas.getVentas().getVenta().stream()
				.filter(v -> v.getNumventa().intValue() == numeroVenta)
				.findAny().orElse(null);
		
		// Si la venta existe, cambiamos los valores que recibimos como parametros de entrada,
		// y escribimos el nuevo contenido en el fichero XML.
		if (venta != null) {
			venta.setUnidades(unidades);
			venta.setFecha(fecha);
			escribirXML();
			flag = true;
		}
		else {
			flag = false;
		}
		
		// Devolvemos true en caso de que se haya podido modificar y false en caso contrario.
		return flag;
	}
	
}
