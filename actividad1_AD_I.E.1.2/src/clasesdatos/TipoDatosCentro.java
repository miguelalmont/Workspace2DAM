//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2020.10.05 a las 11:13:11 AM CEST 
//


package clasesdatos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoDatosCentro complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoDatosCentro"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="centro" type="{}tipoCentro"/&gt;
 *         &lt;element name="profesores" type="{}tipoProfesores"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoDatosCentro", propOrder = {
    "centro",
    "profesores"
})
public class TipoDatosCentro {

    @XmlElement(required = true)
    protected TipoCentro centro;
    @XmlElement(required = true)
    protected TipoProfesores profesores;

    /**
     * Obtiene el valor de la propiedad centro.
     * 
     * @return
     *     possible object is
     *     {@link TipoCentro }
     *     
     */
    public TipoCentro getCentro() {
        return centro;
    }

    /**
     * Define el valor de la propiedad centro.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCentro }
     *     
     */
    public void setCentro(TipoCentro value) {
        this.centro = value;
    }

    /**
     * Obtiene el valor de la propiedad profesores.
     * 
     * @return
     *     possible object is
     *     {@link TipoProfesores }
     *     
     */
    public TipoProfesores getProfesores() {
        return profesores;
    }

    /**
     * Define el valor de la propiedad profesores.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoProfesores }
     *     
     */
    public void setProfesores(TipoProfesores value) {
        this.profesores = value;
    }

}
