package org.simpleframework.xml.stream;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class DocumentReader implements EventReader {
    private static final String RESERVED = "xml";
    private EventNode peek;
    private NodeExtractor queue;
    private NodeStack stack;

    public static class End extends EventToken {
        private End() {
        }

        public boolean isEnd() {
            return true;
        }
    }

    public static class Entry extends EventAttribute {
        private final Node node;

        public Entry(Node node2) {
            this.node = node2;
        }

        public String getName() {
            return this.node.getLocalName();
        }

        public String getPrefix() {
            return this.node.getPrefix();
        }

        public String getReference() {
            return this.node.getNamespaceURI();
        }

        public Object getSource() {
            return this.node;
        }

        public String getValue() {
            return this.node.getNodeValue();
        }

        public boolean isReserved() {
            String prefix = getPrefix();
            String name = getName();
            if (prefix != null) {
                return prefix.startsWith(DocumentReader.RESERVED);
            }
            return name.startsWith(DocumentReader.RESERVED);
        }
    }

    public static class Start extends EventElement {
        private final Element element;

        public Start(Node node) {
            this.element = (Element) node;
        }

        public NamedNodeMap getAttributes() {
            return this.element.getAttributes();
        }

        public String getName() {
            return this.element.getLocalName();
        }

        public String getPrefix() {
            return this.element.getPrefix();
        }

        public String getReference() {
            return this.element.getNamespaceURI();
        }

        public Object getSource() {
            return this.element;
        }
    }

    public static class Text extends EventToken {
        private final Node node;

        public Text(Node node2) {
            this.node = node2;
        }

        public Object getSource() {
            return this.node;
        }

        public String getValue() {
            return this.node.getNodeValue();
        }

        public boolean isText() {
            return true;
        }
    }

    public DocumentReader(Document document) {
        this.queue = new NodeExtractor(document);
        NodeStack nodeStack = new NodeStack();
        this.stack = nodeStack;
        nodeStack.push(document);
    }

    private Entry attribute(Node node) {
        return new Entry(node);
    }

    private Start build(Start start) {
        NamedNodeMap attributes = start.getAttributes();
        int length = attributes.getLength();
        for (int i10 = 0; i10 < length; i10++) {
            Entry attribute = attribute(attributes.item(i10));
            if (!attribute.isReserved()) {
                start.add(attribute);
            }
        }
        return start;
    }

    private EventNode convert(Node node) {
        if (node.getNodeType() != 1) {
            return text(node);
        }
        this.stack.push(node);
        return start(node);
    }

    private End end() {
        return new End();
    }

    private EventNode read() {
        Node node = (Node) this.queue.peek();
        if (node == null) {
            return end();
        }
        return read(node);
    }

    private Start start(Node node) {
        Start start = new Start(node);
        if (start.isEmpty()) {
            return build(start);
        }
        return start;
    }

    private Text text(Node node) {
        return new Text(node);
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

    private EventNode read(Node node) {
        Node parentNode = node.getParentNode();
        Node node2 = (Node) this.stack.top();
        if (parentNode != node2) {
            if (node2 != null) {
                this.stack.pop();
            }
            return end();
        }
        this.queue.poll();
        return convert(node);
    }
}
