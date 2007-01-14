
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Clefs are represented by the sign, line, and
 * clef-octave-change elements. Sign values include G, F, C,
 * percussion, TAB, and none. Line numbers are counted from
 * the bottom of the staff. Standard values are 2 for the
 * G sign (treble clef), 4 for the F sign (bass clef), 3
 * for the C sign (alto clef) and 5 for TAB (on a 6-line
 * staff). The clef-octave-change element is used for
 * transposing clefs (e.g., a treble clef for tenors would
 * have a clef-octave-change value of -1). The optional
 * number attribute refers to staff numbers, from top to
 * bottom on the system. A value of 1 is assumed if not
 * present.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}sign"/>
 *         &lt;element ref="{}line" minOccurs="0"/>
 *         &lt;element ref="{}clef-octave-change" minOccurs="0"/>
 *       &lt;/sequence>
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
    "sign",
    "line",
    "clefOctaveChange"
})
@XmlRootElement(name = "clef")
public class Clef {

    @XmlElement(required = true)
    protected Sign sign;
    protected Line line;
    @XmlElement(name = "clef-octave-change")
    protected ClefOctaveChange clefOctaveChange;
    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the sign property.
     * 
     * @return
     *     possible object is
     *     {@link Sign }
     *     
     */
    public Sign getSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sign }
     *     
     */
    public void setSign(Sign value) {
        this.sign = value;
    }

    /**
     * Gets the value of the line property.
     * 
     * @return
     *     possible object is
     *     {@link Line }
     *     
     */
    public Line getLine() {
        return line;
    }

    /**
     * Sets the value of the line property.
     * 
     * @param value
     *     allowed object is
     *     {@link Line }
     *     
     */
    public void setLine(Line value) {
        this.line = value;
    }

    /**
     * Gets the value of the clefOctaveChange property.
     * 
     * @return
     *     possible object is
     *     {@link ClefOctaveChange }
     *     
     */
    public ClefOctaveChange getClefOctaveChange() {
        return clefOctaveChange;
    }

    /**
     * Sets the value of the clefOctaveChange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClefOctaveChange }
     *     
     */
    public void setClefOctaveChange(ClefOctaveChange value) {
        this.clefOctaveChange = value;
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
