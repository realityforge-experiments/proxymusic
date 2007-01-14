
package proxymusic;

import java.util.ArrayList;
import java.util.List;
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
 * <!-- Elements -->
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}bar-style" minOccurs="0"/>
 *         &lt;sequence>
 *           &lt;element ref="{}footnote" minOccurs="0"/>
 *           &lt;element ref="{}level" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}wavy-line" minOccurs="0"/>
 *         &lt;element ref="{}segno" minOccurs="0"/>
 *         &lt;element ref="{}coda" minOccurs="0"/>
 *         &lt;element ref="{}fermata" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}ending" minOccurs="0"/>
 *         &lt;element ref="{}repeat" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="location" default="right">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="right"/>
 *             &lt;enumeration value="left"/>
 *             &lt;enumeration value="middle"/>
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
@XmlType(name = "", propOrder = {
    "barStyle",
    "footnote",
    "level",
    "wavyLine",
    "segno",
    "coda",
    "fermata",
    "ending",
    "repeat"
})
@XmlRootElement(name = "barline")
public class Barline {

    @XmlElement(name = "bar-style")
    protected BarStyle barStyle;
    protected Footnote footnote;
    protected Level level;
    @XmlElement(name = "wavy-line")
    protected WavyLine wavyLine;
    protected Segno segno;
    protected Coda coda;
    protected List<Fermata> fermata;
    protected Ending ending;
    protected Repeat repeat;
    @XmlAttribute
    protected java.lang.String location;

    /**
     * Gets the value of the barStyle property.
     * 
     * @return
     *     possible object is
     *     {@link BarStyle }
     *     
     */
    public BarStyle getBarStyle() {
        return barStyle;
    }

    /**
     * Sets the value of the barStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link BarStyle }
     *     
     */
    public void setBarStyle(BarStyle value) {
        this.barStyle = value;
    }

    /**
     * Gets the value of the footnote property.
     * 
     * @return
     *     possible object is
     *     {@link Footnote }
     *     
     */
    public Footnote getFootnote() {
        return footnote;
    }

    /**
     * Sets the value of the footnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link Footnote }
     *     
     */
    public void setFootnote(Footnote value) {
        this.footnote = value;
    }

    /**
     * Gets the value of the level property.
     * 
     * @return
     *     possible object is
     *     {@link Level }
     *     
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     * @param value
     *     allowed object is
     *     {@link Level }
     *     
     */
    public void setLevel(Level value) {
        this.level = value;
    }

    /**
     * Gets the value of the wavyLine property.
     * 
     * @return
     *     possible object is
     *     {@link WavyLine }
     *     
     */
    public WavyLine getWavyLine() {
        return wavyLine;
    }

    /**
     * Sets the value of the wavyLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link WavyLine }
     *     
     */
    public void setWavyLine(WavyLine value) {
        this.wavyLine = value;
    }

    /**
     * Gets the value of the segno property.
     * 
     * @return
     *     possible object is
     *     {@link Segno }
     *     
     */
    public Segno getSegno() {
        return segno;
    }

    /**
     * Sets the value of the segno property.
     * 
     * @param value
     *     allowed object is
     *     {@link Segno }
     *     
     */
    public void setSegno(Segno value) {
        this.segno = value;
    }

    /**
     * Gets the value of the coda property.
     * 
     * @return
     *     possible object is
     *     {@link Coda }
     *     
     */
    public Coda getCoda() {
        return coda;
    }

    /**
     * Sets the value of the coda property.
     * 
     * @param value
     *     allowed object is
     *     {@link Coda }
     *     
     */
    public void setCoda(Coda value) {
        this.coda = value;
    }

    /**
     * Gets the value of the fermata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fermata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFermata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fermata }
     * 
     * 
     */
    public List<Fermata> getFermata() {
        if (fermata == null) {
            fermata = new ArrayList<Fermata>();
        }
        return this.fermata;
    }

    /**
     * Gets the value of the ending property.
     * 
     * @return
     *     possible object is
     *     {@link Ending }
     *     
     */
    public Ending getEnding() {
        return ending;
    }

    /**
     * Sets the value of the ending property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ending }
     *     
     */
    public void setEnding(Ending value) {
        this.ending = value;
    }

    /**
     * Gets the value of the repeat property.
     * 
     * @return
     *     possible object is
     *     {@link Repeat }
     *     
     */
    public Repeat getRepeat() {
        return repeat;
    }

    /**
     * Sets the value of the repeat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Repeat }
     *     
     */
    public void setRepeat(Repeat value) {
        this.repeat = value;
    }

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLocation() {
        if (location == null) {
            return "right";
        } else {
            return location;
        }
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLocation(java.lang.String value) {
        this.location = value;
    }

}
