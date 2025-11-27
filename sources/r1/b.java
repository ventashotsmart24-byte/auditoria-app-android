package r1;

import android.content.Context;
import android.widget.ImageView;
import r1.a;
import s9.l;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f8997a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f8998b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f8999c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Integer f9000d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f9001e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Integer f9002f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f9003g;

    public /* synthetic */ b(Context context, ImageView imageView, String str, Integer num, l lVar, Integer num2, boolean z10) {
        this.f8997a = context;
        this.f8998b = imageView;
        this.f8999c = str;
        this.f9000d = num;
        this.f9001e = lVar;
        this.f9002f = num2;
        this.f9003g = z10;
    }

    public final void run() {
        a.c.b(this.f8997a, this.f8998b, this.f8999c, this.f9000d, this.f9001e, this.f9002f, this.f9003g);
    }
}
