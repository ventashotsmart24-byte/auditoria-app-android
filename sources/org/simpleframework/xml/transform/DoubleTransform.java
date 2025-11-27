package org.simpleframework.xml.transform;

class DoubleTransform implements Transform<Double> {
    public Double read(String str) {
        return Double.valueOf(str);
    }

    public String write(Double d10) {
        return d10.toString();
    }
}
