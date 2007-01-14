
package proxymusic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>Comments from original DTD:
 * <pre>
 * Kind indicates the type of chord. Degree elements
 * can then add, subtract, or alter from these
 * starting points. Values include:
 * 
 * Triads:
 * major (major third, perfect fifth)
 * minor (minor third, perfect fifth)
 * augmented (major third, augmented fifth)
 * diminished (minor third, diminished fifth)
 * Sevenths:
 * dominant (major triad, minor seventh)
 * major-seventh (major triad, major seventh)
 * minor-seventh (minor triad, minor seventh)
 * diminished-seventh
 * (diminished triad, diminished seventh)
 * augmented-seventh
 * (augmented triad, minor seventh)
 * half-diminished
 * (diminished triad, minor seventh)
 * major-minor
 * (minor triad, major seventh)
 * Sixths:
 * major-sixth (major triad, added sixth)
 * minor-sixth (minor triad, added sixth)
 * Ninths:
 * dominant-ninth (dominant-seventh, major ninth)
 * major-ninth (major-seventh, major ninth)
 * minor-ninth (minor-seventh, minor ninth)
 * 11ths (usually as the basis for alteration):
 * dominant-11th (dominant-ninth, perfect 11th)
 * major-11th (major-ninth, perfect 11th)
 * minor-11th (minor-ninth, perfect 11th)
 * 13ths (usually as the basis for alteration):
 * dominant-13th (dominant-11th, major 13th)
 * major-13th (major-11th, major 13th)
 * minor-13th (minor-11th, major 13th)
 * Suspended:
 * suspended-second (major second, perfect fifth)
 * suspended-fourth (perfect fourth, perfect fifth)
 * Functional sixths:
 * Neapolitan
 * Italian
 * French
 * German
 * Other:
 * pedal (pedal-point bass)
 * Tristan
 * 
 * The "other" kind is used when the harmony is entirely
 * composed of add elements. The "none" kind is used to
 * explicitly encode absence of chords or functional
 * harmony.
 * 
 * The attributes are used to indicate the formatting
 * of the symbol. Since the kind element is the constant
 * in all the harmony-chord entities that can make up
 * a polychord, many formatting attributes are here.
 * 
 * The use-symbols attribute is yes if the kind should be
 * represented when possible with harmony symbols rather
 * than letters and numbers. These symbols include:
 * 
 * major: a triangle, like Unicode 25B3
 * minor: -, like Unicode 002D
 * augmented: +, like Unicode 002B
 * diminished: °, like Unicode 00B0
 * half-diminished: ø, like Unicode 00F8
 * 
 * The text attribute describes how the kind should be
 * spelled if not using symbols; it is ignored if use-symbols
 * is yes. The stack-degrees attribute is yes if the degree
 * elements should be stacked above each other. The
 * parentheses-degrees attribute is yes if all the degrees
 * should be in parentheses. The bracket-degrees attribute
 * is yes if all the degrees should be in a bracket. If not
 * specified, these values are implementation-specific.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="bracket-degrees">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="parentheses-degrees">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="stack-degrees">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="text" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="use-symbols">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="yes"/>
 *             &lt;enumeration value="no"/>
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
    "content"
})
@XmlRootElement(name = "kind")
public class Kind {

    @XmlValue
    protected java.lang.String content;
    @XmlAttribute(name = "bracket-degrees")
    protected java.lang.String bracketDegrees;
    @XmlAttribute(name = "parentheses-degrees")
    protected java.lang.String parenthesesDegrees;
    @XmlAttribute(name = "stack-degrees")
    protected java.lang.String stackDegrees;
    @XmlAttribute
    protected java.lang.String text;
    @XmlAttribute(name = "use-symbols")
    protected java.lang.String useSymbols;

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setContent(java.lang.String value) {
        this.content = value;
    }

    /**
     * Gets the value of the bracketDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getBracketDegrees() {
        return bracketDegrees;
    }

    /**
     * Sets the value of the bracketDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setBracketDegrees(java.lang.String value) {
        this.bracketDegrees = value;
    }

    /**
     * Gets the value of the parenthesesDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getParenthesesDegrees() {
        return parenthesesDegrees;
    }

    /**
     * Sets the value of the parenthesesDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setParenthesesDegrees(java.lang.String value) {
        this.parenthesesDegrees = value;
    }

    /**
     * Gets the value of the stackDegrees property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getStackDegrees() {
        return stackDegrees;
    }

    /**
     * Sets the value of the stackDegrees property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setStackDegrees(java.lang.String value) {
        this.stackDegrees = value;
    }

    /**
     * Gets the value of the text property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setText(java.lang.String value) {
        this.text = value;
    }

    /**
     * Gets the value of the useSymbols property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getUseSymbols() {
        return useSymbols;
    }

    /**
     * Sets the value of the useSymbols property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setUseSymbols(java.lang.String value) {
        this.useSymbols = value;
    }

}
