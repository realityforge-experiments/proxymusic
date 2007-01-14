
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="make-time" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="slash">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="steal-time-following" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="steal-time-previous" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "grace")
public class Grace {

    @XmlAttribute(name = "make-time")
    protected java.lang.String makeTime;
    @XmlAttribute
    protected java.lang.String slash;
    @XmlAttribute(name = "steal-time-following")
    protected java.lang.String stealTimeFollowing;
    @XmlAttribute(name = "steal-time-previous")
    protected java.lang.String stealTimePrevious;

    /**
     * Gets the value of the makeTime property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getMakeTime() {
        return makeTime;
    }

    /**
     * Sets the value of the makeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setMakeTime(java.lang.String value) {
        this.makeTime = value;
    }

    /**
     * Gets the value of the slash property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getSlash() {
        return slash;
    }

    /**
     * Sets the value of the slash property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setSlash(java.lang.String value) {
        this.slash = value;
    }

    /**
     * Gets the value of the stealTimeFollowing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStealTimeFollowing() {
        return stealTimeFollowing;
    }

    /**
     * Sets the value of the stealTimeFollowing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStealTimeFollowing(java.lang.String value) {
        this.stealTimeFollowing = value;
    }

    /**
     * Gets the value of the stealTimePrevious property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStealTimePrevious() {
        return stealTimePrevious;
    }

    /**
     * Sets the value of the stealTimePrevious property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStealTimePrevious(java.lang.String value) {
        this.stealTimePrevious = value;
    }

}
