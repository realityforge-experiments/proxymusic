
package proxymusic;

import java.util.ArrayList;
import java.util.List;
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
 * Collect score-wide defaults. This includes scaling
 * and layout, defined in layout.dtd, and default values
 * for the music font, word font, lyric font, and
 * lyric language. The number and name attributes in
 * lyric-font and lyric-language elements are typically
 * used when lyrics are provided in multiple languages.
 * If the number and name attributes are omitted, the
 * lyric-font and lyric-language values apply to all
 * numbers and names.
 * </pre>
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}scaling" minOccurs="0"/>
 *         &lt;element ref="{}page-layout" minOccurs="0"/>
 *         &lt;element ref="{}system-layout" minOccurs="0"/>
 *         &lt;element ref="{}staff-layout" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}music-font" minOccurs="0"/>
 *         &lt;element ref="{}word-font" minOccurs="0"/>
 *         &lt;element ref="{}lyric-font" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}lyric-language" maxOccurs="unbounded" minOccurs="0"/>
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
    "scaling",
    "pageLayout",
    "systemLayout",
    "staffLayout",
    "musicFont",
    "wordFont",
    "lyricFont",
    "lyricLanguage"
})
@XmlRootElement(name = "defaults")
public class Defaults {

    protected Scaling scaling;
    @XmlElement(name = "page-layout")
    protected PageLayout pageLayout;
    @XmlElement(name = "system-layout")
    protected SystemLayout systemLayout;
    @XmlElement(name = "staff-layout")
    protected List<StaffLayout> staffLayout;
    @XmlElement(name = "music-font")
    protected MusicFont musicFont;
    @XmlElement(name = "word-font")
    protected WordFont wordFont;
    @XmlElement(name = "lyric-font")
    protected List<LyricFont> lyricFont;
    @XmlElement(name = "lyric-language")
    protected List<LyricLanguage> lyricLanguage;

    /**
     * Gets the value of the scaling property.
     * 
     * @return
     *     possible object is
     *     {@link Scaling }
     *     
     */
    public Scaling getScaling() {
        return scaling;
    }

    /**
     * Sets the value of the scaling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Scaling }
     *     
     */
    public void setScaling(Scaling value) {
        this.scaling = value;
    }

    /**
     * Gets the value of the pageLayout property.
     * 
     * @return
     *     possible object is
     *     {@link PageLayout }
     *     
     */
    public PageLayout getPageLayout() {
        return pageLayout;
    }

    /**
     * Sets the value of the pageLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageLayout }
     *     
     */
    public void setPageLayout(PageLayout value) {
        this.pageLayout = value;
    }

    /**
     * Gets the value of the systemLayout property.
     * 
     * @return
     *     possible object is
     *     {@link SystemLayout }
     *     
     */
    public SystemLayout getSystemLayout() {
        return systemLayout;
    }

    /**
     * Sets the value of the systemLayout property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemLayout }
     *     
     */
    public void setSystemLayout(SystemLayout value) {
        this.systemLayout = value;
    }

    /**
     * Gets the value of the staffLayout property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the staffLayout property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStaffLayout().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StaffLayout }
     * 
     * 
     */
    public List<StaffLayout> getStaffLayout() {
        if (staffLayout == null) {
            staffLayout = new ArrayList<StaffLayout>();
        }
        return this.staffLayout;
    }

    /**
     * Gets the value of the musicFont property.
     * 
     * @return
     *     possible object is
     *     {@link MusicFont }
     *     
     */
    public MusicFont getMusicFont() {
        return musicFont;
    }

    /**
     * Sets the value of the musicFont property.
     * 
     * @param value
     *     allowed object is
     *     {@link MusicFont }
     *     
     */
    public void setMusicFont(MusicFont value) {
        this.musicFont = value;
    }

    /**
     * Gets the value of the wordFont property.
     * 
     * @return
     *     possible object is
     *     {@link WordFont }
     *     
     */
    public WordFont getWordFont() {
        return wordFont;
    }

    /**
     * Sets the value of the wordFont property.
     * 
     * @param value
     *     allowed object is
     *     {@link WordFont }
     *     
     */
    public void setWordFont(WordFont value) {
        this.wordFont = value;
    }

    /**
     * Gets the value of the lyricFont property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lyricFont property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLyricFont().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LyricFont }
     * 
     * 
     */
    public List<LyricFont> getLyricFont() {
        if (lyricFont == null) {
            lyricFont = new ArrayList<LyricFont>();
        }
        return this.lyricFont;
    }

    /**
     * Gets the value of the lyricLanguage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lyricLanguage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLyricLanguage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LyricLanguage }
     * 
     * 
     */
    public List<LyricLanguage> getLyricLanguage() {
        if (lyricLanguage == null) {
            lyricLanguage = new ArrayList<LyricLanguage>();
        }
        return this.lyricLanguage;
    }

}
