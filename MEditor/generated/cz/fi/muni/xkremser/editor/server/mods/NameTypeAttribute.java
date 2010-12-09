//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.11.14 at 07:28:52 PM CET 
//


package cz.fi.muni.xkremser.editor.server.mods;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nameTypeAttribute.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="nameTypeAttribute">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="personal"/>
 *     &lt;enumeration value="corporate"/>
 *     &lt;enumeration value="conference"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "nameTypeAttribute")
@XmlEnum
public enum NameTypeAttribute {


    /**
     *  100, 700
     * 
     */
    @XmlEnumValue("personal")
    PERSONAL("personal"),

    /**
     *  110, 710.
     * 
     */
    @XmlEnumValue("corporate")
    CORPORATE("corporate"),

    /**
     *  111, 711
     * 
     */
    @XmlEnumValue("conference")
    CONFERENCE("conference");
    private final String value;

    NameTypeAttribute(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NameTypeAttribute fromValue(String v) {
        for (NameTypeAttribute c: NameTypeAttribute.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
