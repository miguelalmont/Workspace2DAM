//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantaci�n de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perder�n si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.05 a las 11:13:11 AM CEST 
//


package clasesdatos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clasesdatos package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Datoscentro_QNAME = new QName("", "datoscentro");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clasesdatos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TipoDatosCentro }
     * 
     */
    public TipoDatosCentro createTipoDatosCentro() {
        return new TipoDatosCentro();
    }

    /**
     * Create an instance of {@link TipoProfesor }
     * 
     */
    public TipoProfesor createTipoProfesor() {
        return new TipoProfesor();
    }

    /**
     * Create an instance of {@link TipoProfesores }
     * 
     */
    public TipoProfesores createTipoProfesores() {
        return new TipoProfesores();
    }

    /**
     * Create an instance of {@link TipoCentro }
     * 
     */
    public TipoCentro createTipoCentro() {
        return new TipoCentro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TipoDatosCentro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "datoscentro")
    public JAXBElement<TipoDatosCentro> createDatoscentro(TipoDatosCentro value) {
        return new JAXBElement<TipoDatosCentro>(_Datoscentro_QNAME, TipoDatosCentro.class, null, value);
    }

}
