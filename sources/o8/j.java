package o8;

import android.graphics.Bitmap;
import o8.k;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f19141a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f19142b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f19143c;

    public /* synthetic */ j(boolean z10, Bitmap bitmap, String str) {
        this.f19141a = z10;
        this.f19142b = bitmap;
        this.f19143c = str;
    }

    public final void run() {
        k.a.t(this.f19141a, this.f19142b, this.f19143c);
    }
}
