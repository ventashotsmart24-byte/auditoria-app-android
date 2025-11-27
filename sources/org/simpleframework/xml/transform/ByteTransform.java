package org.simpleframework.xml.transform;

class ByteTransform implements Transform<Byte> {
    public Byte read(String str) {
        return Byte.valueOf(str);
    }

    public String write(Byte b10) {
        return b10.toString();
    }
}
