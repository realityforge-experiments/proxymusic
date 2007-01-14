
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * If the part is being encoded for a transposing instrument
 * in written vs. concert pitch, the transposition must be
 * encoded in the transpose element. The transposition is
 * represented by chromatic steps (required) and three
 * optional elements: diatonic pitch steps, octave changes,
 * and doubling an octave down. The chromatic and
 * octave-change elements are numeric values added to the
 * encoded pitch data to create the sounding pitch. The
 * diatonic element is also numeric and allows for correct
 * spelling of enharmonic transpositions.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}diatonic" minOccurs="0"/>
 *         &lt;element ref="{}chromatic"/>
 *         &lt;element ref="{}octave-change" minOccurs="0"/>
 *         &lt;element ref="{}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "diatonic",
    "chromatic",
    "octaveChange",
    "_double"
})
@XmlRootElement(name = "transpose")
public class Transpose {

    protected Diatonic diatonic;
    @XmlElement(required = true)
    protected Chromatic chromatic;
    @XmlElement(name = "octave-change")
    protected OctaveChange octaveChange;
    @XmlElement(name = "double")
    protected Double _double;

    /**
     * Gets the value of the diatonic property.
     * 
     * @return
     *     possible object is
     *     {@link Diatonic }
     *     
     */
    public Diatonic getDiatonic() {
        return diatonic;
    }

    /**
     * Sets the value of the diatonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Diatonic }
     *     
     */
    public void setDiatonic(Diatonic value) {
        this.diatonic = value;
    }

    /**
     * Gets the value of the chromatic property.
     * 
     * @return
     *     possible object is
     *     {@link Chromatic }
     *     
     */
    public Chromatic getChromatic() {
        return chromatic;
    }

    /**
     * Sets the value of the chromatic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Chromatic }
     *     
     */
    public void setChromatic(Chromatic value) {
        this.chromatic = value;
    }

    /**
     * Gets the value of the octaveChange property.
     * 
     * @return
     *     possible object is
     *     {@link OctaveChange }
     *     
     */
    public OctaveChange getOctaveChange() {
        return octaveChange;
    }

    /**
     * Sets the value of the octaveChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link OctaveChange }
     *     
     */
    public void setOctaveChange(OctaveChange value) {
        this.octaveChange = value;
    }

    /**
     * Gets the value of the double property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getDouble() {
        return _double;
    }

    /**
     * Sets the value of the double property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setDouble(Double value) {
        this._double = value;
    }

}
