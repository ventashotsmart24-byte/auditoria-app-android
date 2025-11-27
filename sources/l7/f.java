package l7;

import t9.i;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public String f18687a = "";

    /* renamed from: b  reason: collision with root package name */
    public long f18688b;

    /* renamed from: c  reason: collision with root package name */
    public long f18689c;

    /* renamed from: d  reason: collision with root package name */
    public String f18690d = "";

    public final String a() {
        return this.f18690d;
    }

    public final long b() {
        return this.f18689c;
    }

    public final long c() {
        return this.f18688b;
    }

    public final void d(String str) {
        i.g(str, "<set-?>");
        this.f18690d = str;
    }

    public final void e(long j10) {
        this.f18689c = j10;
    }

    public final void f(String str) {
        i.g(str, "<set-?>");
        this.f18687a = str;
    }

    public final void g(long j10) {
        this.f18688b = j10;
    }

    public String toString() {
        return "SRT(node=" + this.f18687a + ", startTime=" + this.f18688b + ", endTime=" + this.f18689c + ", content='" + this.f18690d + "')";
    }
}
