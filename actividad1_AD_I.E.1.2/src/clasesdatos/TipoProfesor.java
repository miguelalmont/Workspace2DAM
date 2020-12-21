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
 * <p>Clase Java para tipoProfesor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoProfesor"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoprofesor" type="{}tipoNumero"/&gt;
 *         &lt;element name="nombreprofesor" type="{}tipoCadena"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoProfesor", propOrder = {
    "codigoprofesor",
    "nombreprofesor"
})
public class TipoProfesor {

    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger codigoprofesor;
    @XmlElement(required = true)
    protected String nombreprofesor;

    /**
     * Obtiene el valor de la propiedad codigoprofesor.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCodigoprofesor() {
        return codigoprofesor;
    }

    /**
     * Define el valor de la propiedad codigoprofesor.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCodigoprofesor(BigInteger value) {
        this.codigoprofesor = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreprofesor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreprofesor() {
        return nombreprofesor;
    }

    /**
     * Define el valor de la propiedad nombreprofesor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreprofesor(String value) {
        this.nombreprofesor = value;
    }

}
