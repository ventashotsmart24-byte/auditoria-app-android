package com.hpplay.component.protocol.plist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class NSSet extends NSObject {
    private boolean ordered;
    private Set<NSObject> set;

    public NSSet() {
        this.ordered = false;
        this.set = new LinkedHashSet();
    }

    public synchronized void addObject(NSObject nSObject) {
        this.set.add(nSObject);
    }

    public synchronized NSObject[] allObjects() {
        return (NSObject[]) this.set.toArray(new NSObject[count()]);
    }

    public synchronized NSObject anyObject() {
        if (this.set.isEmpty()) {
            return null;
        }
        return this.set.iterator().next();
    }

    public void assignIDs(BinaryPropertyListWriter binaryPropertyListWriter) {
        super.assignIDs(binaryPropertyListWriter);
        for (NSObject assignIDs : this.set) {
            assignIDs.assignIDs(binaryPropertyListWriter);
        }
    }

    public boolean containsObject(NSObject nSObject) {
        return this.set.contains(nSObject);
    }

    public synchronized int count() {
        return this.set.size();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Set<NSObject> set2 = this.set;
        Set<NSObject> set3 = ((NSSet) obj).set;
        if (set2 == set3 || (set2 != null && set2.equals(set3))) {
            return true;
        }
        return false;
    }

    public Set<NSObject> getSet() {
        return this.set;
    }

    public int hashCode() {
        int i10;
        Set<NSObject> set2 = this.set;
        if (set2 != null) {
            i10 = set2.hashCode();
        } else {
            i10 = 0;
        }
        return 203 + i10;
    }

    public synchronized boolean intersectsSet(NSSet nSSet) {
        for (NSObject containsObject : this.set) {
            if (nSSet.containsObject(containsObject)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean isSubsetOfSet(NSSet nSSet) {
        for (NSObject containsObject : this.set) {
            if (!nSSet.containsObject(containsObject)) {
                return false;
            }
        }
        return true;
    }

    public synchronized NSObject member(NSObject nSObject) {
        for (NSObject next : this.set) {
            if (next.equals(nSObject)) {
                return next;
            }
        }
        return null;
    }

    public synchronized Iterator<NSObject> objectIterator() {
        return this.set.iterator();
    }

    public synchronized void removeObject(NSObject nSObject) {
        this.set.remove(nSObject);
    }

    public void toASCII(StringBuilder sb, int i10) {
        indent(sb, i10);
        NSObject[] allObjects = allObjects();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        for (int i11 = 0; i11 < allObjects.length; i11++) {
            Class<?> cls = allObjects[i11].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
                allObjects[i11].toASCII(sb, i10 + 1);
            } else {
                if (i11 != 0) {
                    sb.append(' ');
                }
                allObjects[i11].toASCII(sb, 0);
            }
            if (i11 != allObjects.length - 1) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    public void toASCIIGnuStep(StringBuilder sb, int i10) {
        indent(sb, i10);
        NSObject[] allObjects = allObjects();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        int lastIndexOf = sb.lastIndexOf(NSObject.NEWLINE);
        for (int i11 = 0; i11 < allObjects.length; i11++) {
            Class<?> cls = allObjects[i11].getClass();
            if ((cls.equals(NSDictionary.class) || cls.equals(NSArray.class) || cls.equals(NSData.class)) && lastIndexOf != sb.length()) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
                allObjects[i11].toASCIIGnuStep(sb, i10 + 1);
            } else {
                if (i11 != 0) {
                    sb.append(' ');
                }
                allObjects[i11].toASCIIGnuStep(sb, 0);
            }
            if (i11 != allObjects.length - 1) {
                sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            }
            if (sb.length() - lastIndexOf > 80) {
                sb.append(NSObject.NEWLINE);
                lastIndexOf = sb.length();
            }
        }
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    public void toBinary(BinaryPropertyListWriter binaryPropertyListWriter) {
        if (this.ordered) {
            binaryPropertyListWriter.writeIntHeader(11, this.set.size());
        } else {
            binaryPropertyListWriter.writeIntHeader(12, this.set.size());
        }
        for (NSObject id : this.set) {
            binaryPropertyListWriter.writeID(binaryPropertyListWriter.getID(id));
        }
    }

    public void toXML(StringBuilder sb, int i10) {
        indent(sb, i10);
        sb.append("<array>");
        sb.append(NSObject.NEWLINE);
        for (NSObject xml : this.set) {
            xml.toXML(sb, i10 + 1);
            sb.append(NSObject.NEWLINE);
        }
        indent(sb, i10);
        sb.append("</array>");
    }

    public NSSet clone() {
        NSObject[] nSObjectArr = new NSObject[this.set.size()];
        Iterator<NSObject> it = this.set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            NSObject next = it.next();
            int i11 = i10 + 1;
            nSObjectArr[i10] = next != null ? next.clone() : null;
            i10 = i11;
        }
        return new NSSet(this.ordered, nSObjectArr);
    }

    public NSSet(boolean z10) {
        this.ordered = z10;
        if (!z10) {
            this.set = new LinkedHashSet();
        } else {
            this.set = new TreeSet();
        }
    }

    public NSSet(NSObject... nSObjectArr) {
        this.ordered = false;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.set = linkedHashSet;
        linkedHashSet.addAll(Arrays.asList(nSObjectArr));
    }

    public NSSet(boolean z10, NSObject... nSObjectArr) {
        this.ordered = z10;
        if (!z10) {
            this.set = new LinkedHashSet();
        } else {
            this.set = new TreeSet();
        }
        this.set.addAll(Arrays.asList(nSObjectArr));
    }
}
