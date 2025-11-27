package org.simpleframework.xml.transform;

class DefaultMatcher implements Matcher {
    private Matcher array = new ArrayMatcher(this);
    private Matcher matcher;
    private Matcher primitive = new PrimitiveMatcher();
    private Matcher stock = new PackageMatcher();

    public DefaultMatcher(Matcher matcher2) {
        this.matcher = matcher2;
    }

    private Transform matchType(Class cls) {
        if (cls.isArray()) {
            return this.array.match(cls);
        }
        if (cls.isPrimitive()) {
            return this.primitive.match(cls);
        }
        return this.stock.match(cls);
    }

    public Transform match(Class cls) {
        Transform match = this.matcher.match(cls);
        if (match != null) {
            return match;
        }
        return matchType(cls);
    }
}
