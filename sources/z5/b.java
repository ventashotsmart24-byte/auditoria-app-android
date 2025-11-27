package z5;

import com.google.android.gms.cast.framework.CastStateListener;
import z5.c;

public final /* synthetic */ class b implements CastStateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.b f20262a;

    public /* synthetic */ b(c.b bVar) {
        this.f20262a = bVar;
    }

    public final void onCastStateChanged(int i10) {
        c.d(this.f20262a, i10);
    }
}
