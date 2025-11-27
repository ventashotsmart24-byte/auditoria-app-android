package m3;

import java.io.Serializable;

public abstract class c implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    public static final int f7824c = e.values().length;

    /* renamed from: a  reason: collision with root package name */
    public Boolean f7825a = Boolean.FALSE;

    /* renamed from: b  reason: collision with root package name */
    public final b[] f7826b = new b[f7824c];

    public b a(e eVar) {
        return this.f7826b[eVar.ordinal()];
    }

    public Boolean b() {
        return this.f7825a;
    }
}
