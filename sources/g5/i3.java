package g5;

import a7.d;
import a7.e;
import android.app.Activity;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.HorizontalItemDecoration;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.PosterList;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class i3 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final Activity f16936a;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i3 f16937a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f16938b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(i3 i3Var, ImageView imageView) {
            super(1);
            this.f16937a = i3Var;
            this.f16938b = imageView;
        }

        public final void b(PosterList posterList) {
            e eVar = e.f10706a;
            Activity f10 = this.f16937a.f();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f16938b;
            i.f(imageView, "mSpecialBgIv");
            eVar.b(f10, fileUrl, imageView, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f16939a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f16939a = imageView;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f16939a.setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i3(Activity activity) {
        super(R.layout.adapter_special_item, (List) null, 2, (g) null);
        i.g(activity, f.X);
        this.f16936a = activity;
    }

    public static final void d(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* renamed from: c */
    public void convert(BaseViewHolder baseViewHolder, j3 j3Var) {
        i.g(baseViewHolder, "helper");
        i.g(j3Var, "specialItem");
        baseViewHolder.setText((int) R.id.mSpecialTypeName, (CharSequence) b0.c(j3Var.a().getName(), j3Var.a().getAlias()));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mSpecialBgIv);
        d dVar = d.f10697a;
        dVar.c(j3Var.a().getPosterList(), dVar.e()).subscribe(new g3(new a(this, imageView)), new h3(new b(imageView)));
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mSpecialColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f16936a, 0, false));
        if (recyclerView.getAdapter() == null) {
            recyclerView.addItemDecoration(new HorizontalItemDecoration(this.f16936a, AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.DASH_NO_INIT)));
        }
        if (j3Var.b().isEmpty()) {
            baseViewHolder.setText((int) R.id.mSpecialVideoNum, (CharSequence) "");
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("");
            z1 z1Var = new z1(true);
            recyclerView.setAdapter(z1Var);
            z1Var.setNewData(arrayList);
            return;
        }
        baseViewHolder.setText((int) R.id.mSpecialVideoNum, (CharSequence) j3Var.b().size() + ' ' + this.f16936a.getResources().getString(R.string.videos));
        y1 y1Var = new y1(this.f16936a, j3Var.a().getId(), true, false, false, "special", 16, (g) null);
        recyclerView.setAdapter(y1Var);
        y1Var.setNewData(j3Var.b());
    }

    public final Activity f() {
        return this.f16936a;
    }
}
