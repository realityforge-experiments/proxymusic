
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
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Text underlays for lyrics, based on Humdrum with support
 * for other formats. The lyric number indicates multiple
 * lines, though a name can be used as well (as in Finale's
 * verse/chorus/section specification). Word extensions are
 * represented using the extend element. Hyphenation is
 * indicated by the syllabic element, which can be single,
 * begin, end, or middle. These represent single-syllable
 * words, word-beginning syllables, word-ending syllables,
 * and mid-word syllables. Multiple syllables on a single
 * note are separated by elision elements. A hyphen in the
 * text element should only be used for an actual hyphenated
 * word. Humming and laughing representations are taken from
 * Humdrum. The end-line and end-paragraph elements come
 * from RP-017 for Standard MIDI File Lyric meta-events;
 * they help facilitate lyric display for Karaoke and
 * similar applications. Language names for text elements
 * come from ISO 639, with optional country subcodes from
 * ISO 3166. Justification is center by default; placement is
 * below by default.
 * 
 * Original definition was:
 * 
 * <!ELEMENT lyric
 * ((((syllabic?, text),
 * (elision, syllabic?, text)*, extend?) |
 * extend | laughing | humming),
 * end-line?, end-paragraph?, %editorial;)>
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *               &lt;element ref="{}elision" minOccurs="0"/>
 *               &lt;element ref="{}syllabic" minOccurs="0"/>
 *               &lt;element ref="{}text"/>
 *             &lt;/sequence>
 *             &lt;element ref="{}extend" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element ref="{}laughing"/>
 *           &lt;element ref="{}humming"/>
 *         &lt;/choice>
 *         &lt;element ref="{}end-line" minOccurs="0"/>
 *         &lt;element ref="{}end-paragraph" minOccurs="0"/>
 *         &lt;sequence>
 *           &lt;element ref="{}footnote" minOccurs="0"/>
 *           &lt;element ref="{}level" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}position"/>
 *       &lt;attGroup ref="{}placement"/>
 *       &lt;attGroup ref="{}justify"/>
 *       &lt;attGroup ref="{}color"/>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="number" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "elisionAndSyllabicAndText",
    "extend",
    "laughing",
    "humming",
    "endLine",
    "endParagraph",
    "footnote",
    "level"
})
@XmlRootElement(name = "lyric")
public class Lyric {

    @XmlElements({
        @XmlElement(name = "elision", type = Elision.class),
        @XmlElement(name = "text", type = Text.class),
        @XmlElement(name = "syllabic", type = Syllabic.class)
    })
    protected List<Object> elisionAndSyllabicAndText;
    protected Extend extend;
    protected Laughing laughing;
    protected Humming humming;
    @XmlElement(name = "end-line")
    protected EndLine endLine;
    @XmlElement(name = "end-paragraph")
    protected EndParagraph endParagraph;
    protected Footnote footnote;
    protected Level level;
    @XmlAttribute
    protected java.lang.String name;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String number;
    @XmlAttribute(name = "default-x")
    protected java.lang.String defaultX;
    @XmlAttribute(name = "default-y")
    protected java.lang.String defaultY;
    @XmlAttribute(name = "relative-x")
    protected java.lang.String relativeX;
    @XmlAttribute(name = "relative-y")
    protected java.lang.String relativeY;
    @XmlAttribute
    protected java.lang.String placement;
    @XmlAttribute
    protected java.lang.String justify;
    @XmlAttribute
    protected java.lang.String color;

    /**
     * Gets the value of the elisionAndSyllabicAndText property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elisionAndSyllabicAndText property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElisionAndSyllabicAndText().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Elision }
     * {@link Text }
     * {@link Syllabic }
     * 
     * 
     */
    public List<Object> getElisionAndSyllabicAndText() {
        if (elisionAndSyllabicAndText == null) {
            elisionAndSyllabicAndText = new ArrayList<Object>();
        }
        return this.elisionAndSyllabicAndText;
    }

    /**
     * Gets the value of the extend property.
     * 
     * @return
     *     possible object is
     *     {@link Extend }
     *     
     */
    public Extend getExtend() {
        return extend;
    }

    /**
     * Sets the value of the extend property.
     * 
     * @param value
     *     allowed object is
     *     {@link Extend }
     *     
     */
    public void setExtend(Extend value) {
        this.extend = value;
    }

    /**
     * Gets the value of the laughing property.
     * 
     * @return
     *     possible object is
     *     {@link Laughing }
     *     
     */
    public Laughing getLaughing() {
        return laughing;
    }

    /**
     * Sets the value of the laughing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Laughing }
     *     
     */
    public void setLaughing(Laughing value) {
        this.laughing = value;
    }

    /**
     * Gets the value of the humming property.
     * 
     * @return
     *     possible object is
     *     {@link Humming }
     *     
     */
    public Humming getHumming() {
        return humming;
    }

    /**
     * Sets the value of the humming property.
     * 
     * @param value
     *     allowed object is
     *     {@link Humming }
     *     
     */
    public void setHumming(Humming value) {
        this.humming = value;
    }

    /**
     * Gets the value of the endLine property.
     * 
     * @return
     *     possible object is
     *     {@link EndLine }
     *     
     */
    public EndLine getEndLine() {
        return endLine;
    }

    /**
     * Sets the value of the endLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndLine }
     *     
     */
    public void setEndLine(EndLine value) {
        this.endLine = value;
    }

    /**
     * Gets the value of the endParagraph property.
     * 
     * @return
     *     possible object is
     *     {@link EndParagraph }
     *     
     */
    public EndParagraph getEndParagraph() {
        return endParagraph;
    }

    /**
     * Sets the value of the endParagraph property.
     * 
     * @param value
     *     allowed object is
     *     {@link EndParagraph }
     *     
     */
    public void setEndParagraph(EndParagraph value) {
        this.endParagraph = value;
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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setName(java.lang.String value) {
        this.name = value;
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

    /**
     * Gets the value of the placement property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getPlacement() {
        return placement;
    }

    /**
     * Sets the value of the placement property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setPlacement(java.lang.String value) {
        this.placement = value;
    }

    /**
     * Gets the value of the justify property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getJustify() {
        return justify;
    }

    /**
     * Sets the value of the justify property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setJustify(java.lang.String value) {
        this.justify = value;
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
