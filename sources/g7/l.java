package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import h9.g;
import h9.h;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ProgramSeason;
import n6.g;
import t9.i;
import t9.j;

public final class l extends b {

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f17234b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f17235c;

    /* renamed from: d  reason: collision with root package name */
    public final g f17236d;

    /* renamed from: e  reason: collision with root package name */
    public b f17237e;

    public static final class a implements g.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f17238a;

        public a(l lVar) {
            this.f17238a = lVar;
        }

        public void a(int i10, ProgramSeason programSeason) {
            i.g(programSeason, "data");
            b h10 = this.f17238a.f17237e;
            if (h10 != null) {
                h10.a(i10, programSeason);
            }
        }
    }

    public interface b {
        void a(int i10, ProgramSeason programSeason);
    }

    public static final class c extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f17239a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Activity activity) {
            super(0);
            this.f17239a = activity;
        }

        /* renamed from: b */
        public final n6.g invoke() {
            return new n6.g(this.f17239a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Activity activity) {
        super(activity);
        i.g(activity, "activity");
        this.f17236d = h.b(new c(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_season, (ViewGroup) null);
        i.f(inflate, "from(activity).inflate(R…_pop_window_season, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        setHeight(activity.getResources().getDisplayMetrics().heightPixels - AutoUtils.getPercentHeightSize(448));
        View findViewById = inflate.findViewById(R.id.mRvSeason);
        i.f(findViewById, "view.findViewById(R.id.mRvSeason)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f17234b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mIvClose);
        i.f(findViewById2, "view.findViewById(R.id.mIvClose)");
        ImageView imageView = (ImageView) findViewById2;
        this.f17235c = imageView;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView.addItemDecoration(new VerticalItemDecoration(activity, 0, AutoUtils.getPercentHeightSize(70)));
        recyclerView.setAdapter(i());
        i().f(new a(this));
        imageView.setOnClickListener(new k(this));
    }

    public static final void g(l lVar, View view) {
        i.g(lVar, "this$0");
        lVar.dismiss();
    }

    public final n6.g i() {
        return (n6.g) this.f17236d.getValue();
    }

    public final void j(b bVar) {
        i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17237e = bVar;
    }

    public final void k(ArrayList arrayList, int i10) {
        i.g(arrayList, "data");
        i().e(arrayList);
        i().g(i10);
        this.f17234b.scrollToPosition(i10);
    }
}
