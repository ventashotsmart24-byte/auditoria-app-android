package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import f5.c;
import h9.t;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.SearchShelveItem;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.i;
import t9.j;
import t9.z;

public final class b3 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final c f16860a;

    /* renamed from: b  reason: collision with root package name */
    public String f16861b = "";

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b3 f16862a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f16863b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b3 b3Var, BaseViewHolder baseViewHolder) {
            super(1);
            this.f16862a = b3Var;
            this.f16863b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context d10 = this.f16862a.mContext;
            i.f(d10, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f16863b.getView(R.id.posterImageView);
            i.f(view, "helper.getView(R.id.posterImageView)");
            eVar.b(d10, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f16864a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f16864a = baseViewHolder;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f16864a.getView(R.id.posterImageView)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b3(c cVar, List list) {
        super(R.layout.adapter_search_result_item, list);
        i.g(cVar, f.X);
        i.g(list, "datas");
        this.f16860a = cVar;
    }

    public static final void f(SearchShelveItem searchShelveItem, b3 b3Var, BaseViewHolder baseViewHolder, View view) {
        String str;
        b3 b3Var2 = b3Var;
        BaseViewHolder baseViewHolder2 = baseViewHolder;
        i.g(searchShelveItem, "$item");
        i.g(b3Var2, "this$0");
        i.g(baseViewHolder2, "$helper");
        d dVar = d.f10697a;
        String o10 = dVar.o(searchShelveItem.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str2 = o10;
        Context context = b3Var2.mContext;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        c cVar = (c) context;
        String type = searchShelveItem.getType();
        String programType = searchShelveItem.getProgramType();
        String contentId = searchShelveItem.getContentId();
        EnterType enterType = EnterType.SEARCH;
        String alias = searchShelveItem.getAlias();
        String str3 = null;
        if (alias != null) {
            str = ba.t.W(alias).toString();
        } else {
            str = null;
        }
        String name = searchShelveItem.getName();
        if (name != null) {
            str3 = ba.t.W(name).toString();
        }
        b0.t(cVar, type, programType, contentId, enterType, b0.c(str, str3), false, false, 0, FirebaseAnalytics.Event.SEARCH, str2, 224, (Object) null);
        i1.s(b3Var2.mContext, b3Var2.f16861b, ((TextView) baseViewHolder2.getView(R.id.mPosterName)).getText().toString());
        com.mobile.brasiltv.utils.f.f12516a.a(b3Var2.f16861b, ((TextView) baseViewHolder2.getView(R.id.mPosterName)).getText().toString(), baseViewHolder.getPosition() + 1);
    }

    public static final void g(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* renamed from: e */
    public void convert(BaseViewHolder baseViewHolder, SearchShelveItem searchShelveItem) {
        i.g(baseViewHolder, "helper");
        i.g(searchShelveItem, PlistBuilder.KEY_ITEM);
        ((TextView) baseViewHolder.getView(R.id.mPosterName)).setText(b0.e(searchShelveItem.getAlias(), searchShelveItem.getName()));
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new y2(searchShelveItem, this, baseViewHolder));
        if (i.b(searchShelveItem.getType(), "0")) {
            k(baseViewHolder, searchShelveItem);
        } else {
            j(baseViewHolder, searchShelveItem);
        }
        d dVar = d.f10697a;
        dVar.l(searchShelveItem.getPosterList(), dVar.g()).subscribe(new z2(new a(this, baseViewHolder)), new a3(new b(baseViewHolder)));
    }

    public final void i(List list, String str) {
        i.g(list, "data");
        i.g(str, "searchKey");
        this.f16861b = str;
        super.setNewData(list);
    }

    public final void j(BaseViewHolder baseViewHolder, SearchShelveItem searchShelveItem) {
        boolean z10;
        ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(8);
        ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
        if (searchShelveItem.getScore() == 0.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(8);
            return;
        }
        ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(0);
        baseViewHolder.setText((int) R.id.mScoreTv, (CharSequence) String.valueOf(searchShelveItem.getScore()));
    }

    public final void k(BaseViewHolder baseViewHolder, SearchShelveItem searchShelveItem) {
        String str;
        ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(8);
        if (searchShelveItem.getUpdateCount() == 0 && searchShelveItem.getVolumnCount() == 0) {
            ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            return;
        }
        if (searchShelveItem.getUpdateCount() == searchShelveItem.getVolumnCount()) {
            z zVar = z.f19601a;
            String string = this.f16860a.getResources().getString(R.string.recommend_episodes_all);
            i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
            str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(searchShelveItem.getVolumnCount())}, 1));
            i.f(str, "format(format, *args)");
        } else {
            z zVar2 = z.f19601a;
            String string2 = this.f16860a.getResources().getString(R.string.recommend_episodes);
            i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
            str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(searchShelveItem.getUpdateCount())}, 1));
            i.f(str, "format(format, *args)");
        }
        ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(0);
        baseViewHolder.setText((int) R.id.mSetInfo, (CharSequence) str);
        ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
    }
}
