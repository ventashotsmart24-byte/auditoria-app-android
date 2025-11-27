package q0;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import q0.e;
import t0.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final c.C0123c f8846a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f8847b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8848c;

    /* renamed from: d  reason: collision with root package name */
    public final e.d f8849d;

    /* renamed from: e  reason: collision with root package name */
    public final List f8850e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8851f;

    /* renamed from: g  reason: collision with root package name */
    public final e.c f8852g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f8853h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f8854i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f8855j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f8856k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f8857l;

    /* renamed from: m  reason: collision with root package name */
    public final Set f8858m;

    /* renamed from: n  reason: collision with root package name */
    public final String f8859n;

    /* renamed from: o  reason: collision with root package name */
    public final File f8860o;

    public a(Context context, String str, c.C0123c cVar, e.d dVar, List list, boolean z10, e.c cVar2, Executor executor, Executor executor2, boolean z11, boolean z12, boolean z13, Set set, String str2, File file) {
        this.f8846a = cVar;
        this.f8847b = context;
        this.f8848c = str;
        this.f8849d = dVar;
        this.f8850e = list;
        this.f8851f = z10;
        this.f8852g = cVar2;
        this.f8853h = executor;
        this.f8854i = executor2;
        this.f8855j = z11;
        this.f8856k = z12;
        this.f8857l = z13;
        this.f8858m = set;
        this.f8859n = str2;
        this.f8860o = file;
    }

    public boolean a(int i10, int i11) {
        boolean z10;
        Set set;
        if (i10 > i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        if ((!z10 || !this.f8857l) && this.f8856k && ((set = this.f8858m) == null || !set.contains(Integer.valueOf(i10)))) {
            return true;
        }
        return false;
    }
}
