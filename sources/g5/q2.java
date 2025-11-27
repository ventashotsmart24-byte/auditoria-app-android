package g5;

import android.view.View;
import com.mobile.brasiltv.db.Album;
import g5.r2;

public final /* synthetic */ class q2 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ r2 f17051a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Album f17052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r2.c f17053c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f17054d;

    public /* synthetic */ q2(r2 r2Var, Album album, r2.c cVar, int i10) {
        this.f17051a = r2Var;
        this.f17052b = album;
        this.f17053c = cVar;
        this.f17054d = i10;
    }

    public final void onClick(View view) {
        r2.f(this.f17051a, this.f17052b, this.f17053c, this.f17054d, view);
    }
}
