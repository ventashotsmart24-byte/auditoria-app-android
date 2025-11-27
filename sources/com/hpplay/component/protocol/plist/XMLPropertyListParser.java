package com.hpplay.component.protocol.plist;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

public class XMLPropertyListParser {
    private static final DocumentBuilderFactory FACTORY;

    public static class PlistDtdResolver implements EntityResolver {
        private static final String PLIST_PUBLIC_ID_1 = "-//Lebo Computer//DTD PLIST 1.0//EN";
        private static final String PLIST_PUBLIC_ID_2 = "-//Lebo//DTD PLIST 1.0//EN";

        public InputSource resolveEntity(String str, String str2) {
            if (PLIST_PUBLIC_ID_1.equals(str) || PLIST_PUBLIC_ID_2.equals(str)) {
                return new InputSource(new ByteArrayInputStream(new byte[0]));
            }
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|(2:7|8)|9|11) */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0013 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x001a */
    static {
        /*
            javax.xml.parsers.DocumentBuilderFactory r0 = javax.xml.parsers.DocumentBuilderFactory.newInstance()
            FACTORY = r0
            r1 = 0
            java.lang.String r2 = "http://apache.org/xml/features/nonvalidating/load-external-dtd"
            r0.setFeature(r2, r1)     // Catch:{ ParserConfigurationException -> 0x000c }
        L_0x000c:
            javax.xml.parsers.DocumentBuilderFactory r0 = FACTORY     // Catch:{ ParserConfigurationException -> 0x0013 }
            java.lang.String r2 = "http://xml.org/sax/features/external-general-entities"
            r0.setFeature(r2, r1)     // Catch:{ ParserConfigurationException -> 0x0013 }
        L_0x0013:
            javax.xml.parsers.DocumentBuilderFactory r0 = FACTORY     // Catch:{ ParserConfigurationException -> 0x001a }
            java.lang.String r2 = "http://xml.org/sax/features/external-parameter-entities"
            r0.setFeature(r2, r1)     // Catch:{ ParserConfigurationException -> 0x001a }
        L_0x001a:
            javax.xml.parsers.DocumentBuilderFactory r0 = FACTORY     // Catch:{ UnsupportedOperationException -> 0x001f }
            r0.setXIncludeAware(r1)     // Catch:{ UnsupportedOperationException -> 0x001f }
        L_0x001f:
            javax.xml.parsers.DocumentBuilderFactory r0 = FACTORY
            r0.setExpandEntityReferences(r1)
            r0.setNamespaceAware(r1)
            r2 = 1
            r0.setIgnoringComments(r2)
            r0.setCoalescing(r2)
            r0.setValidating(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.plist.XMLPropertyListParser.<clinit>():void");
    }

    private static List<Node> filterElementNodes(NodeList nodeList) {
        ArrayList arrayList = new ArrayList(nodeList.getLength());
        for (int i10 = 0; i10 < nodeList.getLength(); i10++) {
            if (nodeList.item(i10).getNodeType() == 1) {
                arrayList.add(nodeList.item(i10));
            }
        }
        return arrayList;
    }

    public static DocumentBuilder getDocBuilder() {
        DocumentBuilder newDocumentBuilder = FACTORY.newDocumentBuilder();
        newDocumentBuilder.setEntityResolver(new PlistDtdResolver());
        return newDocumentBuilder;
    }

    private static String getNodeTextContents(Node node) {
        if (node.getNodeType() == 3 || node.getNodeType() == 4) {
            String wholeText = ((Text) node).getWholeText();
            if (wholeText == null) {
                return "";
            }
            return wholeText;
        }
        if (node.hasChildNodes()) {
            NodeList childNodes = node.getChildNodes();
            for (int i10 = 0; i10 < childNodes.getLength(); i10++) {
                Node item = childNodes.item(i10);
                if (item.getNodeType() == 3 || item.getNodeType() == 4) {
                    String wholeText2 = ((Text) item).getWholeText();
                    if (wholeText2 == null) {
                        return "";
                    }
                    return wholeText2;
                }
            }
        }
        return "";
    }

    public static NSObject parse(File file) {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(getDocBuilder().parse(fileInputStream));
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static NSObject parseObject(Node node) {
        String nodeName = node.getNodeName();
        int i10 = 0;
        if (nodeName.equals("dict")) {
            NSDictionary nSDictionary = new NSDictionary();
            List<Node> filterElementNodes = filterElementNodes(node.getChildNodes());
            while (i10 < filterElementNodes.size()) {
                nSDictionary.put(getNodeTextContents(filterElementNodes.get(i10)), parseObject(filterElementNodes.get(i10 + 1)));
                i10 += 2;
            }
            return nSDictionary;
        } else if (nodeName.equals("array")) {
            List<Node> filterElementNodes2 = filterElementNodes(node.getChildNodes());
            NSArray nSArray = new NSArray(filterElementNodes2.size());
            while (i10 < filterElementNodes2.size()) {
                nSArray.setValue(i10, parseObject(filterElementNodes2.get(i10)));
                i10++;
            }
            return nSArray;
        } else if (nodeName.equals("true")) {
            return new NSNumber(true);
        } else {
            if (nodeName.equals("false")) {
                return new NSNumber(false);
            }
            if (nodeName.equals("integer")) {
                return new NSNumber(getNodeTextContents(node));
            }
            if (nodeName.equals("real")) {
                return new NSNumber(getNodeTextContents(node));
            }
            if (nodeName.equals("string")) {
                return new NSString(getNodeTextContents(node));
            }
            if (nodeName.equals("data")) {
                return new NSData(getNodeTextContents(node));
            }
            if (nodeName.equals("date")) {
                return new NSDate(getNodeTextContents(node));
            }
            return null;
        }
    }

    public static NSObject parse(byte[] bArr) {
        return parse((InputStream) new ByteArrayInputStream(bArr));
    }

    public static NSObject parse(InputStream inputStream) {
        return parse(getDocBuilder().parse(inputStream));
    }

    public static NSObject parse(Document document) {
        Node node;
        DocumentType doctype = document.getDoctype();
        if (doctype == null) {
            if (!document.getDocumentElement().getNodeName().equals("plist")) {
                throw new UnsupportedOperationException("The given XML document is not a property list.");
            }
        } else if (!doctype.getName().equals("plist")) {
            throw new UnsupportedOperationException("The given XML document is not a property list.");
        }
        if (document.getDocumentElement().getNodeName().equals("plist")) {
            List<Node> filterElementNodes = filterElementNodes(document.getDocumentElement().getChildNodes());
            if (filterElementNodes.isEmpty()) {
                throw new PropertyListFormatException("The given XML property list has no root element!");
            } else if (filterElementNodes.size() == 1) {
                node = filterElementNodes.get(0);
            } else {
                throw new PropertyListFormatException("The given XML property list has more than one root element!");
            }
        } else {
            node = document.getDocumentElement();
        }
        return parseObject(node);
    }
}
