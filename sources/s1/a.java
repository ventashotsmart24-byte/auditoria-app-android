package s1;

import android.content.Context;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import s9.l;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9238a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f9239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdInfo f9240c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f9241d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Integer f9242e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l f9243f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f9244g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f9245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9246i;

    public /* synthetic */ a(Context context, String str, AdInfo adInfo, ImageView imageView, Integer num, l lVar, Integer num2, boolean z10, int i10) {
        this.f9238a = context;
        this.f9239b = str;
        this.f9240c = adInfo;
        this.f9241d = imageView;
        this.f9242e = num;
        this.f9243f = lVar;
        this.f9244g = num2;
        this.f9245h = z10;
        this.f9246i = i10;
    }

    public final void run() {
        m.i0(this.f9238a, this.f9239b, this.f9240c, this.f9241d, this.f9242e, this.f9243f, this.f9244g, this.f9245h, this.f9246i);
    }
}
