package org.simpleframework.xml.transform;

class LongTransform implements Transform<Long> {
    public Long read(String str) {
        return Long.valueOf(str);
    }

    public String write(Long l10) {
        return l10.toString();
    }
}
