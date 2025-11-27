package com.google.common.xml;

import com.google.common.annotations.GwtCompatible;
import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class XmlEscapers {
    private static final char MAX_ASCII_CONTROL_CHAR = '\u001f';
    private static final char MIN_ASCII_CONTROL_CHAR = 0;
    private static final Escaper XML_ATTRIBUTE_ESCAPER;
    private static final Escaper XML_CONTENT_ESCAPER;
    private static final Escaper XML_ESCAPER;

    static {
        Escapers.Builder builder = Escapers.builder();
        builder.setSafeRange(0, 65533);
        builder.setUnsafeReplacement("�");
        for (char c10 = 0; c10 <= 31; c10 = (char) (c10 + 1)) {
            if (!(c10 == 9 || c10 == 10 || c10 == 13)) {
                builder.addEscape(c10, "�");
            }
        }
        builder.addEscape('&', "&amp;");
        builder.addEscape(ASCIIPropertyListParser.DATA_BEGIN_TOKEN, "&lt;");
        builder.addEscape(ASCIIPropertyListParser.DATA_END_TOKEN, "&gt;");
        XML_CONTENT_ESCAPER = builder.build();
        builder.addEscape('\'', "&apos;");
        builder.addEscape('\"', "&quot;");
        XML_ESCAPER = builder.build();
        builder.addEscape(9, "&#x9;");
        builder.addEscape(10, "&#xA;");
        builder.addEscape(ASCIIPropertyListParser.WHITESPACE_CARRIAGE_RETURN, "&#xD;");
        XML_ATTRIBUTE_ESCAPER = builder.build();
    }

    private XmlEscapers() {
    }

    public static Escaper xmlAttributeEscaper() {
        return XML_ATTRIBUTE_ESCAPER;
    }

    public static Escaper xmlContentEscaper() {
        return XML_CONTENT_ESCAPER;
    }
}
