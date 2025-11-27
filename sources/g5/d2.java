package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.activity.SpecialAty;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.s0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class d2 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f16887a;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f16888a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f16888a = baseViewHolder;
        }

        /* renamed from: b */
        public final Intent invoke(Intent intent) {
            i.g(intent, "intent");
            Intent putExtra = intent.putExtra(SpecialAty.f12193q.a(), this.f16888a.getAdapterPosition());
            i.f(putExtra, "intent.putExtra(SpecialA…, helper.adapterPosition)");
            return putExtra;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d2 f16889a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f16890b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d2 d2Var, ImageView imageView) {
            super(1);
            this.f16889a = d2Var;
            this.f16890b = imageView;
        }

        public final void b(PosterList posterList) {
            e eVar = e.f10706a;
            Context h10 = this.f16889a.h();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f16890b;
            i.f(imageView, "mIvPoster");
            eVar.b(h10, fileUrl, imageView, R.drawable.bg_special_column_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f16891a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView) {
            super(1);
            this.f16891a = imageView;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f16891a.setImageResource(R.drawable.bg_special_column_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d2(Context context) {
        super(R.layout.adapter_recommend_horizontal_special_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f16887a = context;
    }

    public static final void e(d2 d2Var, BaseViewHolder baseViewHolder, View view) {
        i.g(d2Var, "this$0");
        i.g(baseViewHolder, "$helper");
        if (RootColumnId.specialColumn != null) {
            Context context = d2Var.f16887a;
            i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.d0((f5.c) context, SpecialAty.class, new a(baseViewHolder));
        }
    }

    public static final void f(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* renamed from: d */
    public void convert(BaseViewHolder baseViewHolder, ChildColumnList childColumnList) {
        i.g(baseViewHolder, "helper");
        i.g(childColumnList, PlistBuilder.KEY_ITEM);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setRadius((float) s0.a(this.f16887a, 4.0f));
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new a2(this, baseViewHolder));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        d dVar = d.f10697a;
        dVar.c(childColumnList.getPosterList(), dVar.j()).subscribe(new b2(new b(this, imageView)), new c2(new c(imageView)));
    }

    public final Context h() {
        return this.f16887a;
    }
}
