
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Traditional key signatures are represented by the number
 * of flats and sharps, plus an optional mode for major/
 * minor/mode distinctions. Negative numbers are used for
 * flats and positive numbers for sharps, reflecting the
 * key's placement within the circle of fifths (hence the
 * element name). A cancel element indicates that the old
 * key signature should be cancelled before the new one
 * appears. This will always happen when changing to C major
 * or A minor and need not be specified then. The cancel
 * value matches the fifths value of the cancelled key
 * signature (e.g., a cancel of -2 will provide an explicit
 * cancellation for changing from B flat major to F major).
 * 
 * Non-traditional key signatures can be represented using
 * the Humdrum/Scot concept of a list of altered tones.
 * The key-step and key-alter elements are represented the
 * same way as the step and alter elements are in the pitch
 * element in note.dtd. The different element names indicate
 * the different meaning of altering notes in a scale versus
 * altering a sounding pitch.
 * 
 * Valid mode values include major, minor, dorian, phrygian,
 * lydian, mixolydian, aeolian, ionian, and locrian.
 * 
 * The optional number attribute refers to staff numbers,
 * from top to bottom on the system. If absent, the key
 * signature applies to all staves in the part.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element ref="{}cancel" minOccurs="0"/>
 *           &lt;element ref="{}fifths"/>
 *           &lt;element ref="{}mode" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}key-step"/>
 *           &lt;element ref="{}key-alter"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cancel",
    "fifths",
    "mode",
    "keyStepAndKeyAlter"
})
@XmlRootElement(name = "key")
public class Key {

    protected Cancel cancel;
    protected Fifths fifths;
    protected Mode mode;
    @XmlElements({
        @XmlElement(name = "key-step", type = KeyStep.class),
        @XmlElement(name = "key-alter", type = KeyAlter.class)
    })
    protected List<Object> keyStepAndKeyAlter;
    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the cancel property.
     * 
     * @return
     *     possible object is
     *     {@link Cancel }
     *     
     */
    public Cancel getCancel() {
        return cancel;
    }

    /**
     * Sets the value of the cancel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cancel }
     *     
     */
    public void setCancel(Cancel value) {
        this.cancel = value;
    }

    /**
     * Gets the value of the fifths property.
     * 
     * @return
     *     possible object is
     *     {@link Fifths }
     *     
     */
    public Fifths getFifths() {
        return fifths;
    }

    /**
     * Sets the value of the fifths property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fifths }
     *     
     */
    public void setFifths(Fifths value) {
        this.fifths = value;
    }

    /**
     * Gets the value of the mode property.
     * 
     * @return
     *     possible object is
     *     {@link Mode }
     *     
     */
    public Mode getMode() {
        return mode;
    }

    /**
     * Sets the value of the mode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mode }
     *     
     */
    public void setMode(Mode value) {
        this.mode = value;
    }

    /**
     * Gets the value of the keyStepAndKeyAlter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the keyStepAndKeyAlter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKeyStepAndKeyAlter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link KeyStep }
     * {@link KeyAlter }
     * 
     * 
     */
    public List<Object> getKeyStepAndKeyAlter() {
        if (keyStepAndKeyAlter == null) {
            keyStepAndKeyAlter = new ArrayList<Object>();
        }
        return this.keyStepAndKeyAlter;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setNumber(java.lang.String value) {
        this.number = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

}
