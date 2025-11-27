package org.simpleframework.xml.stream;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

class HyphenBuilder implements Style {

    public class Parser extends Splitter {
        public void commit(char[] cArr, int i10, int i11) {
            this.builder.append(cArr, i10, i11);
            if (i10 + i11 < this.count) {
                this.builder.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            }
        }

        public void parse(char[] cArr, int i10, int i11) {
            cArr[i10] = toLower(cArr[i10]);
        }

        private Parser(String str) {
            super(str);
        }
    }

    public String getAttribute(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }

    public String getElement(String str) {
        if (str != null) {
            return new Parser(str).process();
        }
        return null;
    }
}
