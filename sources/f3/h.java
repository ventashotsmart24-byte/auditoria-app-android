package f3;

import j3.a;
import j3.o;
import java.io.Writer;

public final class h extends Writer {

    /* renamed from: a  reason: collision with root package name */
    public final o f6598a;

    public h(a aVar) {
        this.f6598a = new o(aVar);
    }

    public String a() {
        String l10 = this.f6598a.l();
        this.f6598a.u();
        return l10;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(char[] cArr) {
        this.f6598a.c(cArr, 0, cArr.length);
    }

    public void write(char[] cArr, int i10, int i11) {
        this.f6598a.c(cArr, i10, i11);
    }

    public void write(int i10) {
        this.f6598a.a((char) i10);
    }

    public Writer append(char c10) {
        write((int) c10);
        return this;
    }

    public void write(String str) {
        this.f6598a.b(str, 0, str.length());
    }

    public Writer append(CharSequence charSequence) {
        String charSequence2 = charSequence.toString();
        this.f6598a.b(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void write(String str, int i10, int i11) {
        this.f6598a.b(str, i10, i11);
    }

    public Writer append(CharSequence charSequence, int i10, int i11) {
        String charSequence2 = charSequence.subSequence(i10, i11).toString();
        this.f6598a.b(charSequence2, 0, charSequence2.length());
        return this;
    }
}
