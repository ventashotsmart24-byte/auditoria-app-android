package org.simpleframework.xml.transform;

class FloatTransform implements Transform<Float> {
    public Float read(String str) {
        return Float.valueOf(str);
    }

    public String write(Float f10) {
        return f10.toString();
    }
}
