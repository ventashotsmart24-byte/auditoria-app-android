package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class r extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f17066a;

    /* renamed from: b  reason: collision with root package name */
    public ChildColumnList f17067b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ r f17068a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f17069b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(r rVar, ImageView imageView) {
            super(1);
            this.f17068a = rVar;
            this.f17069b = imageView;
        }

        public final void b(PosterList posterList) {
            e eVar = e.f10706a;
            Context h10 = this.f17068a.h();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f17069b;
            i.f(imageView, "mIvPoster");
            eVar.b(h10, fileUrl, imageView, R.drawable.bg_cr_column_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f17070a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f17070a = imageView;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f17070a.setImageResource(R.drawable.bg_cr_column_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(Context context, ChildColumnList childColumnList) {
        super(R.layout.adapter_cr_column_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        i.g(childColumnList, "parentColumn");
        this.f17066a = context;
        this.f17067b = childColumnList;
    }

    public static final void e(r rVar, BaseViewHolder baseViewHolder, View view) {
        i.g(rVar, "this$0");
        i.g(baseViewHolder, "$helper");
        Context context = rVar.f17066a;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.k((c) context, rVar.f17067b, baseViewHolder.getAdapterPosition(), true);
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
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        textView.setText(b0.e(childColumnList.getAlias(), childColumnList.getName()));
        textView.setVisibility(0);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new o(this, baseViewHolder));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        d dVar = d.f10697a;
        dVar.c(childColumnList.getPosterList(), dVar.i()).subscribe(new p(new a(this, imageView)), new q(new b(imageView)));
    }

    public final Context h() {
        return this.f17066a;
    }
}
