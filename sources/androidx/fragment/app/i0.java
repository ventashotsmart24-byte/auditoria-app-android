package androidx.fragment.app;

import java.io.Writer;

public final class i0 extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final String f2032a;

    /* renamed from: b  reason: collision with root package name */
    public StringBuilder f2033b = new StringBuilder(128);

    public i0(String str) {
        this.f2032a = str;
    }

    public final void a() {
        if (this.f2033b.length() > 0) {
            this.f2033b.toString();
            StringBuilder sb = this.f2033b;
            sb.delete(0, sb.length());
        }
    }

    public void close() {
        a();
    }

    public void flush() {
        a();
    }

    public void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == 10) {
                a();
            } else {
                this.f2033b.append(c10);
            }
        }
    }
}
