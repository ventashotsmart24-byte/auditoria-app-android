package org.simpleframework.xml.stream;

import org.xmlpull.v1.XmlPullParser;

class PullReader implements EventReader {
    private XmlPullParser parser;
    private EventNode peek;

    public static class End extends EventToken {
        private End() {
        }

        public boolean isEnd() {
            return true;
        }
    }

    public static class Entry extends EventAttribute {
        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;
        private final String value;

        public Entry(XmlPullParser xmlPullParser, int i10) {
            this.reference = xmlPullParser.getAttributeNamespace(i10);
            this.prefix = xmlPullParser.getAttributePrefix(i10);
            this.value = xmlPullParser.getAttributeValue(i10);
            this.name = xmlPullParser.getAttributeName(i10);
            this.source = xmlPullParser;
        }

        public String getName() {
            return this.name;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getReference() {
            return this.reference;
        }

        public Object getSource() {
            return this.source;
        }

        public String getValue() {
            return this.value;
        }

        public boolean isReserved() {
            return false;
        }
    }

    public static class Start extends EventElement {
        private final int line;
        private final String name;
        private final String prefix;
        private final String reference;
        private final XmlPullParser source;

        public Start(XmlPullParser xmlPullParser) {
            this.reference = xmlPullParser.getNamespace();
            this.line = xmlPullParser.getLineNumber();
            this.prefix = xmlPullParser.getPrefix();
            this.name = xmlPullParser.getName();
            this.source = xmlPullParser;
        }

        public int getLine() {
            return this.line;
        }

        public String getName() {
            return this.name;
        }

        public String getPrefix() {
            return this.prefix;
        }

        public String getReference() {
            return this.reference;
        }

        public Object getSource() {
            return this.source;
        }
    }

    public static class Text extends EventToken {
        private final XmlPullParser source;
        private final String text;

        public Text(XmlPullParser xmlPullParser) {
            this.text = xmlPullParser.getText();
            this.source = xmlPullParser;
        }

        public Object getSource() {
            return this.source;
        }

        public String getValue() {
            return this.text;
        }

        public boolean isText() {
            return true;
        }
    }

    public PullReader(XmlPullParser xmlPullParser) {
        this.parser = xmlPullParser;
    }

    private Entry attribute(int i10) {
        return new Entry(this.parser, i10);
    }

    private Start build(Start start) {
        int attributeCount = this.parser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            Entry attribute = attribute(i10);
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private End end() {
        return new End();
    }

    private EventNode read() {
        int next = this.parser.next();
        if (next == 1) {
            return null;
        }
        if (next == 2) {
            return start();
        }
        if (next == 4) {
            return text();
        }
        if (next == 3) {
            return end();
        }
        return read();
    }

    private Start start() {
        Start start = new Start(this.parser);
        if (start.isEmpty()) {
            return build(start);
        }
        return start;
    }

    private Text text() {
        return new Text(this.parser);
    }

    public EventNode next() {
        EventNode eventNode = this.peek;
        if (eventNode == null) {
            return read();
        }
        this.peek = null;
        return eventNode;
    }

    public EventNode peek() {
        if (this.peek == null) {
            this.peek = next();
        }
        return this.peek;
    }
}
