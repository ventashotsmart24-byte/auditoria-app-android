package z5;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import z5.c;

public final /* synthetic */ class a implements RemoteMediaClient.ProgressListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c.e f20261a;

    public /* synthetic */ a(c.e eVar) {
        this.f20261a = eVar;
    }

    public final void onProgressUpdated(long j10, long j11) {
        c.f(this.f20261a, j10, j11);
    }
}
