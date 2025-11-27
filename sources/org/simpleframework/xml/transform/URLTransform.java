package org.simpleframework.xml.transform;

import java.net.URL;

class URLTransform implements Transform<URL> {
    public URL read(String str) {
        return new URL(str);
    }

    public String write(URL url) {
        return url.toString();
    }
}
