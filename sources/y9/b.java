package y9;

import i9.w;
import java.util.NoSuchElementException;

public final class b extends w {

    /* renamed from: a  reason: collision with root package name */
    public final int f20253a;

    /* renamed from: b  reason: collision with root package name */
    public final int f20254b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20255c;

    /* renamed from: d  reason: collision with root package name */
    public int f20256d;

    public b(int i10, int i11, int i12) {
        this.f20253a = i12;
        this.f20254b = i11;
        boolean z10 = true;
        if (i12 <= 0 ? i10 < i11 : i10 > i11) {
            z10 = false;
        }
        this.f20255c = z10;
        this.f20256d = !z10 ? i11 : i10;
    }

    public int a() {
        int i10 = this.f20256d;
        if (i10 != this.f20254b) {
            this.f20256d = this.f20253a + i10;
        } else if (this.f20255c) {
            this.f20255c = false;
        } else {
            throw new NoSuchElementException();
        }
        return i10;
    }

    public boolean hasNext() {
        return this.f20255c;
    }
}
