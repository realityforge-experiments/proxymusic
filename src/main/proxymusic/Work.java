
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
 * Works and movements are optionally identified by number
 * and title. The work element also may indicate a link
 * to the opus document that composes multiple movements
 * into a collection.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}work-number" minOccurs="0"/>
 *         &lt;element ref="{}work-title" minOccurs="0"/>
 *         &lt;element ref="{}opus" minOccurs="0"/>
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
    "workNumber",
    "workTitle",
    "opus"
})
@XmlRootElement(name = "work")
public class Work {

    @XmlElement(name = "work-number")
    protected WorkNumber workNumber;
    @XmlElement(name = "work-title")
    protected WorkTitle workTitle;
    protected Opus opus;

    /**
     * Gets the value of the workNumber property.
     * 
     * @return
     *     possible object is
     *     {@link WorkNumber }
     *     
     */
    public WorkNumber getWorkNumber() {
        return workNumber;
    }

    /**
     * Sets the value of the workNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkNumber }
     *     
     */
    public void setWorkNumber(WorkNumber value) {
        this.workNumber = value;
    }

    /**
     * Gets the value of the workTitle property.
     * 
     * @return
     *     possible object is
     *     {@link WorkTitle }
     *     
     */
    public WorkTitle getWorkTitle() {
        return workTitle;
    }

    /**
     * Sets the value of the workTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkTitle }
     *     
     */
    public void setWorkTitle(WorkTitle value) {
        this.workTitle = value;
    }

    /**
     * Gets the value of the opus property.
     * 
     * @return
     *     possible object is
     *     {@link Opus }
     *     
     */
    public Opus getOpus() {
        return opus;
    }

    /**
     * Sets the value of the opus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Opus }
     *     
     */
    public void setOpus(Opus value) {
        this.opus = value;
    }

}
