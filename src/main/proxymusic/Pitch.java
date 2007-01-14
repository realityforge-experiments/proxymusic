
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
 * Pitch is represented as a combination of the step of the
 * diatonic scale, the chromatic alteration, and the octave.
 * The step element uses the English letters A through G.
 * The alter element represents chromatic alteration in
 * number of semitones (e.g., -1 for flat, 1 for sharp).
 * Decimal values like 0.5 (quarter tone sharp) may be
 * used for microtones. The octave element is represented
 * by the numbers 0 to 9, where 4 indicates the octave
 * started by middle C.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}step"/>
 *         &lt;element ref="{}alter" minOccurs="0"/>
 *         &lt;element ref="{}octave"/>
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
    "step",
    "alter",
    "octave"
})
@XmlRootElement(name = "pitch")
public class Pitch {

    @XmlElement(required = true)
    protected Step step;
    protected Alter alter;
    @XmlElement(required = true)
    protected Octave octave;

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link Step }
     *     
     */
    public Step getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link Step }
     *     
     */
    public void setStep(Step value) {
        this.step = value;
    }

    /**
     * Gets the value of the alter property.
     * 
     * @return
     *     possible object is
     *     {@link Alter }
     *     
     */
    public Alter getAlter() {
        return alter;
    }

    /**
     * Sets the value of the alter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Alter }
     *     
     */
    public void setAlter(Alter value) {
        this.alter = value;
    }

    /**
     * Gets the value of the octave property.
     * 
     * @return
     *     possible object is
     *     {@link Octave }
     *     
     */
    public Octave getOctave() {
        return octave;
    }

    /**
     * Sets the value of the octave property.
     * 
     * @param value
     *     allowed object is
     *     {@link Octave }
     *     
     */
    public void setOctave(Octave value) {
        this.octave = value;
    }

}
