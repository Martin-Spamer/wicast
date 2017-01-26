//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2017.01.25 at 10:41:12 PM GMT
//

package net.wicast.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.jvnet.jaxb2_commons.lang.CopyStrategy2;
import org.jvnet.jaxb2_commons.lang.CopyTo2;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom2;
import org.jvnet.jaxb2_commons.lang.MergeStrategy2;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;

/**
 * <p>
 * Java class for anonymous complex type.
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://xml.wicast.net/xml}Id"/&gt;
 *         &lt;element ref="{http://xml.wicast.net/xml}Name"/&gt;
 *         &lt;element ref="{http://xml.wicast.net/xml}Title"/&gt;
 *         &lt;element ref="{http://xml.wicast.net/xml}Url"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "id",
        "name",
        "title",
        "url"
})
@XmlRootElement(name = "Licence")
public class Licence implements Cloneable, CopyTo2, Equals2, HashCode2, MergeFrom2, ToString2 {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Title", required = true)
    protected String title;
    @XmlElement(name = "Url", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String url;

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.ToString2#append(org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.StringBuilder, org.jvnet.jaxb2_commons.lang.ToStringStrategy2)
     */
    @Override
    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.ToString2#appendFields(org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.StringBuilder, org.jvnet.jaxb2_commons.lang.ToStringStrategy2)
     */
    @Override
    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            String theId;
            theId = getId();
            strategy.appendField(locator, this, "id", buffer, theId, id != null);
        }
        {
            String theName;
            theName = getName();
            strategy.appendField(locator, this, "name", buffer, theName, name != null);
        }
        {
            String theTitle;
            theTitle = getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle, title != null);
        }
        {
            String theUrl;
            theUrl = getUrl();
            strategy.appendField(locator, this, "url", buffer, theUrl, url != null);
        }
        return buffer;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() {
        return copyTo(createNewInstance());
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.CopyTo2#copyTo(java.lang.Object)
     */
    @Override
    public Object copyTo(Object target) {
        final CopyStrategy2 strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.CopyTo2#copyTo(org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.Object, org.jvnet.jaxb2_commons.lang.CopyStrategy2)
     */
    @Override
    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy2 strategy) {
        final Object draftCopy = target == null ? createNewInstance() : target;
        if (draftCopy instanceof Licence) {
            final Licence copy = (Licence) draftCopy;
            {
                final Boolean idShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, id != null);
                if (idShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceId;
                    sourceId = getId();
                    final String copyId = (String) strategy.copy(LocatorUtils.property(locator, "id", sourceId),
                            sourceId,
                            id != null);
                    copy.setId(copyId);
                } else {
                    if (idShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.id = null;
                    }
                }
            }
            {
                final Boolean nameShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, name != null);
                if (nameShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceName;
                    sourceName = getName();
                    final String copyName = (String) strategy.copy(LocatorUtils.property(locator, "name", sourceName),
                            sourceName,
                            name != null);
                    copy.setName(copyName);
                } else {
                    if (nameShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.name = null;
                    }
                }
            }
            {
                final Boolean titleShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, title != null);
                if (titleShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceTitle;
                    sourceTitle = getTitle();
                    final String copyTitle = (String) strategy.copy(
                            LocatorUtils.property(locator, "title", sourceTitle),
                            sourceTitle,
                            title != null);
                    copy.setTitle(copyTitle);
                } else {
                    if (titleShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.title = null;
                    }
                }
            }
            {
                final Boolean urlShouldBeCopiedAndSet = strategy.shouldBeCopiedAndSet(locator, url != null);
                if (urlShouldBeCopiedAndSet == Boolean.TRUE) {
                    String sourceUrl;
                    sourceUrl = getUrl();
                    final String copyUrl = (String) strategy.copy(LocatorUtils.property(locator, "url", sourceUrl),
                            sourceUrl,
                            url != null);
                    copy.setUrl(copyUrl);
                } else {
                    if (urlShouldBeCopiedAndSet == Boolean.FALSE) {
                        copy.url = null;
                    }
                }
            }
        }
        return draftCopy;
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.CopyTo2#createNewInstance()
     */
    @Override
    public Object createNewInstance() {
        return new Licence();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.Equals2#equals(org.jvnet.jaxb2_commons.locator.ObjectLocator, org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.Object, org.jvnet.jaxb2_commons.lang.EqualsStrategy2)
     */
    @Override
    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object,
            EqualsStrategy2 strategy) {
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Licence that = (Licence) object;
        {
            String lhsId;
            lhsId = getId();
            String rhsId;
            rhsId = that.getId();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "id", lhsId),
                    LocatorUtils.property(thatLocator, "id", rhsId),
                    lhsId,
                    rhsId,
                    id != null,
                    that.id != null)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName),
                    LocatorUtils.property(thatLocator, "name", rhsName),
                    lhsName,
                    rhsName,
                    name != null,
                    that.name != null)) {
                return false;
            }
        }
        {
            String lhsTitle;
            lhsTitle = getTitle();
            String rhsTitle;
            rhsTitle = that.getTitle();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "title", lhsTitle),
                    LocatorUtils.property(thatLocator, "title", rhsTitle),
                    lhsTitle,
                    rhsTitle,
                    title != null,
                    that.title != null)) {
                return false;
            }
        }
        {
            String lhsUrl;
            lhsUrl = getUrl();
            String rhsUrl;
            rhsUrl = that.getUrl();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "url", lhsUrl),
                    LocatorUtils.property(thatLocator, "url", rhsUrl),
                    lhsUrl,
                    rhsUrl,
                    url != null,
                    that.url != null)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the value of the title property.
     *
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the value of the url property.
     *
     * @return
     *         possible object is
     *         {@link String }
     */
    public String getUrl() {
        return url;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.HashCode2#hashCode(org.jvnet.jaxb2_commons.locator.ObjectLocator, org.jvnet.jaxb2_commons.lang.HashCodeStrategy2)
     */
    @Override
    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theId;
            theId = getId();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "id", theId),
                    currentHashCode,
                    theId,
                    id != null);
        }
        {
            String theName;
            theName = getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName),
                    currentHashCode,
                    theName,
                    name != null);
        }
        {
            String theTitle;
            theTitle = getTitle();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "title", theTitle),
                    currentHashCode,
                    theTitle,
                    title != null);
        }
        {
            String theUrl;
            theUrl = getUrl();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "url", theUrl),
                    currentHashCode,
                    theUrl,
                    url != null);
        }
        return currentHashCode;
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.MergeFrom2#mergeFrom(java.lang.Object, java.lang.Object)
     */
    @Override
    public void mergeFrom(Object left, Object right) {
        final MergeStrategy2 strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    /* (non-Javadoc)
     * @see org.jvnet.jaxb2_commons.lang.MergeFrom2#mergeFrom(org.jvnet.jaxb2_commons.locator.ObjectLocator, org.jvnet.jaxb2_commons.locator.ObjectLocator, java.lang.Object, java.lang.Object, org.jvnet.jaxb2_commons.lang.MergeStrategy2)
     */
    @Override
    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right,
            MergeStrategy2 strategy) {
        if (right instanceof Licence) {
            final Licence target = this;
            final Licence leftObject = (Licence) left;
            final Licence rightObject = (Licence) right;
            {
                final Boolean idShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator,
                        rightLocator,
                        leftObject.id != null,
                        rightObject.id != null);
                if (idShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsId;
                    lhsId = leftObject.getId();
                    String rhsId;
                    rhsId = rightObject.getId();
                    final String mergedId = (String) strategy.merge(LocatorUtils.property(leftLocator, "id", lhsId),
                            LocatorUtils.property(rightLocator, "id", rhsId),
                            lhsId,
                            rhsId,
                            leftObject.id != null,
                            rightObject.id != null);
                    target.setId(mergedId);
                } else {
                    if (idShouldBeMergedAndSet == Boolean.FALSE) {
                        target.id = null;
                    }
                }
            }
            {
                final Boolean nameShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator,
                        rightLocator,
                        leftObject.name != null,
                        rightObject.name != null);
                if (nameShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsName;
                    lhsName = leftObject.getName();
                    String rhsName;
                    rhsName = rightObject.getName();
                    final String mergedName = (String) strategy.merge(
                            LocatorUtils.property(leftLocator, "name", lhsName),
                            LocatorUtils.property(rightLocator, "name", rhsName),
                            lhsName,
                            rhsName,
                            leftObject.name != null,
                            rightObject.name != null);
                    target.setName(mergedName);
                } else {
                    if (nameShouldBeMergedAndSet == Boolean.FALSE) {
                        target.name = null;
                    }
                }
            }
            {
                final Boolean titleShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator,
                        rightLocator,
                        leftObject.title != null,
                        rightObject.title != null);
                if (titleShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsTitle;
                    lhsTitle = leftObject.getTitle();
                    String rhsTitle;
                    rhsTitle = rightObject.getTitle();
                    final String mergedTitle = (String) strategy.merge(
                            LocatorUtils.property(leftLocator, "title", lhsTitle),
                            LocatorUtils.property(rightLocator, "title", rhsTitle),
                            lhsTitle,
                            rhsTitle,
                            leftObject.title != null,
                            rightObject.title != null);
                    target.setTitle(mergedTitle);
                } else {
                    if (titleShouldBeMergedAndSet == Boolean.FALSE) {
                        target.title = null;
                    }
                }
            }
            {
                final Boolean urlShouldBeMergedAndSet = strategy.shouldBeMergedAndSet(leftLocator,
                        rightLocator,
                        leftObject.url != null,
                        rightObject.url != null);
                if (urlShouldBeMergedAndSet == Boolean.TRUE) {
                    String lhsUrl;
                    lhsUrl = leftObject.getUrl();
                    String rhsUrl;
                    rhsUrl = rightObject.getUrl();
                    final String mergedUrl = (String) strategy.merge(LocatorUtils.property(leftLocator, "url", lhsUrl),
                            LocatorUtils.property(rightLocator, "url", rhsUrl),
                            lhsUrl,
                            rhsUrl,
                            leftObject.url != null,
                            rightObject.url != null);
                    target.setUrl(mergedUrl);
                } else {
                    if (urlShouldBeMergedAndSet == Boolean.FALSE) {
                        target.url = null;
                    }
                }
            }
        }
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *            allowed object is
     *            {@link String }
     */
    public void setId(String value) {
        id = value;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *            allowed object is
     *            {@link String }
     */
    public void setName(String value) {
        name = value;
    }

    /**
     * Sets the value of the title property.
     *
     * @param value
     *            allowed object is
     *            {@link String }
     */
    public void setTitle(String value) {
        title = value;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *            allowed object is
     *            {@link String }
     */
    public void setUrl(String value) {
        url = value;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

}
