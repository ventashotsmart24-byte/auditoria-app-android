package com.hpplay.component.protocol.plist;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class NSDictionary extends NSObject implements Map<String, NSObject> {
    private final HashMap<String, NSObject> dict = new LinkedHashMap();

    public String[] allKeys() {
        return (String[]) this.dict.keySet().toArray(new String[count()]);
    }

    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.assignIDs(binaryPropertyListWriter);
        for (Map.Entry<String, NSObject> key : this.dict.entrySet()) {
            new NSString((String) key.getKey()).assignIDs(binaryPropertyListWriter);
        }
        for (Map.Entry<String, NSObject> value : this.dict.entrySet()) {
            ((NSObject) value.getValue()).assignIDs(binaryPropertyListWriter);
        }
    }

    public void clear() {
        this.dict.clear();
    }

    public boolean containsKey(Object obj) {
        return this.dict.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        if (obj == null) {
            return false;
        }
        return this.dict.containsValue(NSObject.fromJavaObject(obj));
    }

    public int count() {
        return this.dict.size();
    }

    public Set<Map.Entry<String, NSObject>> entrySet() {
        return this.dict.entrySet();
    }

    public boolean equals(Object obj) {
        if (!obj.getClass().equals(getClass()) || !((NSDictionary) obj).dict.equals(this.dict)) {
            return false;
        }
        return true;
    }

    public HashMap<String, NSObject> getHashMap() {
        return this.dict;
    }

    public int hashCode() {
        return 581 + this.dict.hashCode();
    }

    public boolean isEmpty() {
        return this.dict.isEmpty();
    }

    public Set<String> keySet() {
        return this.dict.keySet();
    }

    public NSObject objectForKey(String str) {
        return this.dict.get(str);
    }

    public void putAll(Map<? extends String, ? extends NSObject> map) {
        for (Map.Entry next : map.entrySet()) {
            put((String) next.getKey(), (NSObject) next.getValue());
        }
    }

    public int size() {
        return this.dict.size();
    }

    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        sb.append(NSObject.NEWLINE);
        for (String str : allKeys()) {
            NSObject objectForKey = objectForKey(str);
            indent(sb, i10 + 1);
            sb.append('\"');
            sb.append(NSString.escapeStringForASCII(str));
            sb.append("\" =");
            Class<?> cls = objectForKey.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.NEWLINE);
                objectForKey.toASCII(sb, i10 + 2);
            } else {
                sb.append(' ');
                objectForKey.toASCII(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        sb.append(NSObject.NEWLINE);
        for (String str : (String[]) this.dict.keySet().toArray(new String[this.dict.size()])) {
            NSObject objectForKey = objectForKey(str);
            indent(sb, i10 + 1);
            sb.append('\"');
            sb.append(NSString.escapeStringForASCII(str));
            sb.append("\" =");
            Class<?> cls = objectForKey.getClass();
            if (cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) {
                sb.append(NSObject.NEWLINE);
                objectForKey.toASCIIGnuStep(sb, i10 + 2);
            } else {
                sb.append(' ');
                objectForKey.toASCIIGnuStep(sb, 0);
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
    }

    public String toASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCII(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        binaryPropertyListWriter.writeIntHeader(13, this.dict.size());
        Set<Map.Entry<String, NSObject>> entrySet = this.dict.entrySet();
        for (Map.Entry<String, NSObject> key : entrySet) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(new NSString((String) key.getKey())));
        }
        for (Map.Entry<String, NSObject> value : entrySet) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID((NSObject) value.getValue()));
        }
    }

    public String toGnuStepASCIIPropertyList() {
        StringBuilder sb = new StringBuilder();
        toASCIIGnuStep(sb, 0);
        sb.append(NSObject.NEWLINE);
        return sb.toString();
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<dict>");
        sb.append(NSObject.NEWLINE);
        for (String next : this.dict.keySet()) {
            NSObject objectForKey = objectForKey(next);
            int i11 = i10 + 1;
            indent(sb, i11);
            sb.append("<key>");
            if (next.contains(DispatchConstants.SIGN_SPLIT_SYMBOL) || next.contains(Operator.Operation.LESS_THAN) || next.contains(Operator.Operation.GREATER_THAN)) {
                sb.append("<![CDATA[");
                sb.append(next.replaceAll("]]>", "]]]]><![CDATA[>"));
                sb.append("]]>");
            } else {
                sb.append(next);
            }
            sb.append("</key>");
            String str = NSObject.NEWLINE;
            sb.append(str);
            objectForKey.toXML(sb, i11);
            sb.append(str);
        }
        indent(sb, i10);
        sb.append("</dict>");
    }

    public Collection<NSObject> values() {
        return this.dict.values();
    }

    public boolean containsKey(String str) {
        return this.dict.containsKey(str);
    }

    public NSObject get(Object obj) {
        return this.dict.get(obj);
    }

    public NSObject put(String str, NSObject nSObject) {
        if (str == null) {
            return null;
        }
        if (nSObject == null) {
            return this.dict.get(str);
        }
        return this.dict.put(str, nSObject);
    }

    public NSObject remove(String str) {
        return this.dict.remove(str);
    }

    public NSDictionary clone() {
        NSDictionary nSDictionary = new NSDictionary();
        for (Map.Entry next : this.dict.entrySet()) {
            nSDictionary.dict.put(next.getKey(), next.getValue() != null ? ((NSObject) next.getValue()).clone() : null);
        }
        return nSDictionary;
    }

    public boolean containsValue(NSObject nSObject) {
        return nSObject != null && this.dict.containsValue(nSObject);
    }

    public NSObject remove(Object obj) {
        return this.dict.remove(obj);
    }

    public boolean containsValue(String str) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSString.class) && ((NSString) next).getContent().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public NSObject put(String str, Object obj) {
        return put(str, NSObject.fromJavaObject(obj));
    }

    public boolean containsValue(long j10) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.isInteger() && ((long) nSNumber.intValue()) == j10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(double d10) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.isReal() && nSNumber.doubleValue() == d10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(boolean z10) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSNumber.class)) {
                NSNumber nSNumber = (NSNumber) next;
                if (nSNumber.isBoolean() && nSNumber.boolValue() == z10) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsValue(Date date) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSDate.class) && ((NSDate) next).getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValue(byte[] bArr) {
        for (NSObject next : this.dict.values()) {
            if (next.getClass().equals(NSData.class) && Arrays.equals(((NSData) next).bytes(), bArr)) {
                return true;
            }
        }
        return false;
    }
}
