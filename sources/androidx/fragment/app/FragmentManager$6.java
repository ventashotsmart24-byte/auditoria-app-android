package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

class FragmentManager$6 implements e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1907a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f1908b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ o f1909c;

    public void a(g gVar, d.b bVar) {
        if (bVar == d.b.ON_START && ((Bundle) this.f1909c.f2084j.get(this.f1907a)) != null) {
            throw null;
        } else if (bVar == d.b.ON_DESTROY) {
            this.f1908b.c(this);
            this.f1909c.f2085k.remove(this.f1907a);
        }
    }
}
