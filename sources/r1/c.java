package r1;

import android.content.Context;
import android.widget.ImageView;
import r1.a;
import s9.l;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9004a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f9005b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9006c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f9007d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f9008e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Integer f9009f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f9010g;

    public /* synthetic */ c(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
        this.f9004a = context;
        this.f9005b = imageView;
        this.f9006c = str;
        this.f9007d = num;
        this.f9008e = lVar;
        this.f9009f = num2;
        this.f9010g = z10;
    }

    public final void run() {
        a.d.b(this.f9004a, this.f9005b, this.f9006c, this.f9007d, this.f9008e, this.f9009f, this.f9010g);
    }
}
