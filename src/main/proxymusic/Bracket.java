
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Brackets are combined with words in a variety of
 * modern directions. The line-end attribute specifies
 * if there is a jog up or down (or both), an arrow,
 * or nothing at the start or end of the bracket. If
 * the line-end is up or down, the length of the jog
 * can be specified using the end-length attribute.
 * The line-type is solid by default.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{}line-type"/>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attribute name="end-length" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="line-end" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="up"/>
 *             &lt;enumeration value="down"/>
 *             &lt;enumeration value="both"/>
 *             &lt;enumeration value="arrow"/>
 *             &lt;enumeration value="none"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="number">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="1"/>
 *             &lt;enumeration value="2"/>
 *             &lt;enumeration value="3"/>
 *             &lt;enumeration value="4"/>
 *             &lt;enumeration value="5"/>
 *             &lt;enumeration value="6"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="start"/>
 *             &lt;enumeration value="stop"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "bracket")
public class Bracket {

    @XmlAttribute(name = "end-length")
    protected java.lang.String endLength;
    @XmlAttribute(name = "line-end", required = true)
    protected java.lang.String lineEnd;
    @XmlAttribute
    protected java.lang.String number;
    @XmlAttribute(required = true)
    protected java.lang.String type;
    @XmlAttribute(name = "line-type")
    protected java.lang.String lineType;
    @XmlAttribute
    protected java.lang.String color;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;

    /**
     * Gets the value of the endLength property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getEndLength() {
        return endLength;
    }

    /**
     * Sets the value of the endLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setEndLength(java.lang.String value) {
        this.endLength = value;
    }

    /**
     * Gets the value of the lineEnd property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLineEnd() {
        return lineEnd;
    }

    /**
     * Sets the value of the lineEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLineEnd(java.lang.String value) {
        this.lineEnd = value;
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
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setType(java.lang.String value) {
        this.type = value;
    }

    /**
     * Gets the value of the lineType property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLineType() {
        return lineType;
    }

    /**
     * Sets the value of the lineType property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLineType(java.lang.String value) {
        this.lineType = value;
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

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultX(java.lang.String value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setDefaultY(java.lang.String value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeX(java.lang.String value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setRelativeY(java.lang.String value) {
        this.relativeY = value;
    }

}
