
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
 * The rest element indicates notated rests or silences.
 * Rest are usually empty, but placement on the staff can
 * be specified using display-step and display-octave
 * elements.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;element ref="{}display-step"/>
 *           &lt;element ref="{}display-octave"/>
 *         &lt;/sequence>
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
    "displayStep",
    "displayOctave"
})
@XmlRootElement(name = "rest")
public class Rest {

    @XmlElement(name = "display-step")
    protected DisplayStep displayStep;
    @XmlElement(name = "display-octave")
    protected DisplayOctave displayOctave;

    /**
     * Gets the value of the displayStep property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayStep }
     *     
     */
    public DisplayStep getDisplayStep() {
        return displayStep;
    }

    /**
     * Sets the value of the displayStep property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayStep }
     *     
     */
    public void setDisplayStep(DisplayStep value) {
        this.displayStep = value;
    }

    /**
     * Gets the value of the displayOctave property.
     * 
     * @return
     *     possible object is
     *     {@link DisplayOctave }
     *     
     */
    public DisplayOctave getDisplayOctave() {
        return displayOctave;
    }

    /**
     * Sets the value of the displayOctave property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisplayOctave }
     *     
     */
    public void setDisplayOctave(DisplayOctave value) {
        this.displayOctave = value;
    }

}
