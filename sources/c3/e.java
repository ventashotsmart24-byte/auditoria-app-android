package c3;

public enum e {
    UTF8("UTF-8", false, 8),
    UTF16_BE("UTF-16BE", true, 16),
    UTF16_LE("UTF-16LE", false, 16),
    UTF32_BE("UTF-32BE", true, 32),
    UTF32_LE("UTF-32LE", false, 32);
    

    /* renamed from: a  reason: collision with root package name */
    public final String f4691a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f4692b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4693c;

    /* access modifiers changed from: public */
    e(String str, boolean z10, int i10) {
        this.f4691a = str;
        this.f4692b = z10;
        this.f4693c = i10;
    }

    public String a() {
        return this.f4691a;
    }
}
