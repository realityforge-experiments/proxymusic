
package proxymusic;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * The part-list identifies the different musical parts in
 * this movement. Each part has an ID that is used later
 * within the musical data. Since parts may be encoded
 * separately and combined later, identification elements
 * are present at both the score and score-part levels.
 * There must be at least one score-part, combined as
 * desired with part-group elements that indicate braces
 * and brackets. Parts are ordered from top to bottom in
 * a score based on the order in which they appear in the
 * part-list.
 * 
 * Each MusicXML part corresponds to a track in a Standard
 * MIDI Format 1 file. The score-instrument elements are
 * used when there are multiple instruments per track.
 * The midi-device element is used to make a MIDI device
 * or port assignment for the given track. Initial
 * midi-instrument assignments may be made here as well.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}part-group" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}score-part"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}part-group"/>
 *           &lt;element ref="{}score-part"/>
 *         &lt;/choice>
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
    "partGroup",
    "scorePart",
    "partGroupOrScorePart"
})
@XmlRootElement(name = "part-list")
public class PartList {

    @XmlElement(name = "part-group")
    protected List<PartGroup> partGroup;
    @XmlElement(name = "score-part", required = true)
    protected ScorePart scorePart;
    @XmlElements({
        @XmlElement(name = "score-part", type = ScorePart.class),
        @XmlElement(name = "part-group", type = PartGroup.class)
    })
    protected List<Object> partGroupOrScorePart;

    /**
     * Gets the value of the partGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PartGroup }
     * 
     * 
     */
    public List<PartGroup> getPartGroup() {
        if (partGroup == null) {
            partGroup = new ArrayList<PartGroup>();
        }
        return this.partGroup;
    }

    /**
     * Gets the value of the scorePart property.
     * 
     * @return
     *     possible object is
     *     {@link ScorePart }
     *     
     */
    public ScorePart getScorePart() {
        return scorePart;
    }

    /**
     * Sets the value of the scorePart property.
     * 
     * @param value
     *     allowed object is
     *     {@link ScorePart }
     *     
     */
    public void setScorePart(ScorePart value) {
        this.scorePart = value;
    }

    /**
     * Gets the value of the partGroupOrScorePart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the partGroupOrScorePart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPartGroupOrScorePart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScorePart }
     * {@link PartGroup }
     * 
     * 
     */
    public List<Object> getPartGroupOrScorePart() {
        if (partGroupOrScorePart == null) {
            partGroupOrScorePart = new ArrayList<Object>();
        }
        return this.partGroupOrScorePart;
    }

}
