package w1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import v1.b;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ f f9482a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f9483b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9484c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AdInfo f9485d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ b f9486e;

    public /* synthetic */ d(f fVar, Context context, String str, AdInfo adInfo, b bVar) {
        this.f9482a = fVar;
        this.f9483b = context;
        this.f9484c = str;
        this.f9485d = adInfo;
        this.f9486e = bVar;
    }

    public final void run() {
        f.e(this.f9482a, this.f9483b, this.f9484c, this.f9485d, this.f9486e);
    }
}
