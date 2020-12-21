package operaciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import clasesdatos.ObjectFactory;
import clasesdatos.TipoCentro;
import clasesdatos.TipoDatosCentro;
import clasesdatos.TipoProfesor;
import clasesdatos.TipoProfesores;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generarXML();
	}
	
	// Este metodo genera un XML con el contenido que se pide en el ejercicio (3 profesores y el centro)
	public static void generarXML() {
		File micentro = new File(".\\src\\micentro.xml");
		
		ObjectFactory factory = new ObjectFactory();
		
		JAXBContext jaxbContext;
		try {
			
			// Instanciamos los objetos que vamos a usar con el metodo create de ObjectFactory.
			TipoCentro centro = factory.createTipoCentro();
			TipoProfesor prof1 = factory.createTipoProfesor();
			TipoProfesor prof2 = factory.createTipoProfesor();
			TipoProfesor prof3 = factory.createTipoProfesor();
			
			// Damos los datos pertinentes a cada objeto creado.
			centro.setNombrecentro("Salesianas Nervion");
			centro.setCodigocentro(BigInteger.valueOf(100));
			centro.setDireccion("Calle Maria Mazzarello");
			centro.setDirector(prof1);
			
			prof1.setCodigoprofesor(BigInteger.valueOf(1));
			prof1.setNombreprofesor("Tomas");
			
			prof2.setCodigoprofesor(BigInteger.valueOf(2));
			prof2.setNombreprofesor("Maria Jesus");
			
			prof3.setCodigoprofesor(BigInteger.valueOf(3));
			prof3.setNombreprofesor("Juan");
			
			// Instanciamos el objeto que contiene el array Profesor (que contiene una lista de
			// objetos TipoProfesor).
			TipoProfesores profesores = factory.createTipoProfesores();
			profesores.getProfesor().add(prof1);
			profesores.getProfesor().add(prof2);
			profesores.getProfesor().add(prof3);
			
			// Instanciamos el objeto que contiene todos los demas objetos y se convertira en la
			// etiqueta raiz del XML.
			TipoDatosCentro datoscentro = factory.createTipoDatosCentro();
			datoscentro.setCentro(centro);
			datoscentro.setProfesores(profesores);
			
			// Creamos el contexto de JAXB
			JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
			
			// Creamos el JAXBelement con el metodo create de ObjectFactory introduciendo como parametro
			//el objeto TipoDatosCentro que contiene toda la informacion introducida anteriormente.
			
	        JAXBElement<TipoDatosCentro> element = factory.createDatoscentro(datoscentro);
	        
	        // Creamos el Marshaller con sus propiedades y hacemos marshal del JAXBelement
	        // indicandole archivo con la ruta donde sera creado
	        Marshaller marshaller = context.createMarshaller();
	        marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
	        marshaller.marshal(element, new FileOutputStream(micentro));
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Error al acceder al archivo.");
		}
		
	}

}
