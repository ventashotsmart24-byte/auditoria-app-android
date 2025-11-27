package s1;

import android.content.Context;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import java.io.File;
import s9.l;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f9252a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageView f9253b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AdInfo f9254c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ File f9255d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Integer f9256e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ l f9257f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f9258g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f9259h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f9260i;

    public /* synthetic */ g(Context context, ImageView imageView, AdInfo adInfo, File file, Integer num, l lVar, Integer num2, boolean z10, int i10) {
        this.f9252a = context;
        this.f9253b = imageView;
        this.f9254c = adInfo;
        this.f9255d = file;
        this.f9256e = num;
        this.f9257f = lVar;
        this.f9258g = num2;
        this.f9259h = z10;
        this.f9260i = i10;
    }

    public final void run() {
        m.j0(this.f9252a, this.f9253b, this.f9254c, this.f9255d, this.f9256e, this.f9257f, this.f9258g, this.f9259h, this.f9260i);
    }
}
