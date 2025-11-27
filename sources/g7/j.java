package g7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import s9.l;
import t9.i;

public final class j extends a {

    /* renamed from: a  reason: collision with root package name */
    public Disposable f17230a;

    public static final class a extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f17231a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar) {
            super(1);
            this.f17231a = jVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f17319a;
        }

        public final void invoke(Long l10) {
            this.f17231a.dismiss();
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f17232a = new b();

        public b() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context, String str, BaseQuickAdapter baseQuickAdapter) {
        super(context);
        i.g(context, f.X);
        i.g(str, "popTitle");
        i.g(baseQuickAdapter, "adapter");
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_landscape_quality, (ViewGroup) null);
        setContentView(inflate);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mRvQuality);
        ((TextView) inflate.findViewById(R.id.mTvTitle)).setText(str);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(baseQuickAdapter);
        setTouchInterceptor(new g(this));
        setClippingEnabled(false);
        j();
    }

    public static final boolean i(j jVar, View view, MotionEvent motionEvent) {
        i.g(jVar, "this$0");
        jVar.j();
        return false;
    }

    public static final void k(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public int b() {
        return R.style.RightPopAnimQuality;
    }

    public int c() {
        return -1;
    }

    public int d() {
        return AutoUtils.getPercentWidthSize(490);
    }

    public boolean e() {
        return true;
    }

    public final void j() {
        Disposable disposable = this.f17230a;
        if (disposable != null) {
            disposable.dispose();
        }
        this.f17230a = Observable.timer(5, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).subscribe(new h(new a(this)), new i(b.f17232a));
    }

    public final void m(Activity activity, int i10) {
        i.g(activity, "activity");
        View findViewById = activity.getWindow().getDecorView().findViewById(16908290);
        i.e(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        showAtLocation((ViewGroup) findViewById, i10, 0, 0);
    }
}
