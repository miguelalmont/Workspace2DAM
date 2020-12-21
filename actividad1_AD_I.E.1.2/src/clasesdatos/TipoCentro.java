//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.05 a las 11:13:11 AM CEST 
//


package clasesdatos;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoCentro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoCentro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigocentro" type="{}tipoNumero"/&gt;
 *         &lt;element name="nombrecentro" type="{}tipoCadena"/&gt;
 *         &lt;element name="direccion" type="{}tipoCadena"/&gt;
 *         &lt;element name="director" type="{}tipoProfesor"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoCentro", propOrder = {
    "codigocentro",
    "nombrecentro",
    "direccion",
    "director"
})
public class TipoCentro {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger codigocentro;
    @XmlElement(required = true)
    protected String nombrecentro;
    @XmlElement(required = true)
    protected String direccion;
    @XmlElement(required = true)
    protected TipoProfesor director;

    /**
     * Obtiene el valor de la propiedad codigocentro.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodigocentro() {
        return codigocentro;
    }

    /**
     * Define el valor de la propiedad codigocentro.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigocentro(BigInteger value) {
        this.codigocentro = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrecentro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombrecentro() {
        return nombrecentro;
    }

    /**
     * Define el valor de la propiedad nombrecentro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombrecentro(String value) {
        this.nombrecentro = value;
    }

    /**
     * Obtiene el valor de la propiedad direccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Define el valor de la propiedad direccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDireccion(String value) {
        this.direccion = value;
    }

    /**
     * Obtiene el valor de la propiedad director.
     * 
     * @return
     *     possible object is
     *     {@link TipoProfesor }
     *     
     */
    public TipoProfesor getDirector() {
        return director;
    }

    /**
     * Define el valor de la propiedad director.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProfesor }
     *     
     */
    public void setDirector(TipoProfesor value) {
        this.director = value;
    }

}
