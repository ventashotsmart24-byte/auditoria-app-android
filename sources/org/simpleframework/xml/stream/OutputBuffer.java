package org.simpleframework.xml.stream;

import java.io.Writer;

class OutputBuffer {
    private StringBuilder text = new StringBuilder();

    public void append(char c10) {
        this.text.append(c10);
    }

    public void clear() {
        this.text.setLength(0);
    }

    public void write(Writer writer) {
        writer.append(this.text);
    }

    public void append(String str) {
        this.text.append(str);
    }

    public void append(char[] cArr) {
        this.text.append(cArr, 0, cArr.length);
    }

    public void append(char[] cArr, int i10, int i11) {
        this.text.append(cArr, i10, i11);
    }

    public void append(String str, int i10, int i11) {
        this.text.append(str, i10, i11);
    }
}
