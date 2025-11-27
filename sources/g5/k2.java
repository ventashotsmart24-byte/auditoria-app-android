package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.i;
import t9.j;
import t9.w;
import t9.z;

public final class k2 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16965a;

    /* renamed from: b  reason: collision with root package name */
    public final int f16966b;

    /* renamed from: c  reason: collision with root package name */
    public List f16967c;

    /* renamed from: d  reason: collision with root package name */
    public final String f16968d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoCardView f16969a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f16970b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f16971c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16972d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f16973e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f16974f;

        /* renamed from: g  reason: collision with root package name */
        public ImageView f16975g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mLayout);
            i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f16969a = (AutoCardView) findViewById;
            View findViewById2 = view.findViewById(R.id.mIvPoster);
            i.f(findViewById2, "itemView.findViewById(R.id.mIvPoster)");
            this.f16970b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTvEpisodeInfo);
            i.f(findViewById3, "itemView.findViewById(R.id.mTvEpisodeInfo)");
            this.f16971c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mTvProgramName);
            i.f(findViewById4, "itemView.findViewById(R.id.mTvProgramName)");
            this.f16972d = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mIvCovered);
            i.f(findViewById5, "itemView.findViewById(R.id.mIvCovered)");
            this.f16973e = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.mIvTs);
            i.f(findViewById6, "itemView.findViewById(R.id.mIvTs)");
            this.f16974f = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.mIvTop);
            i.f(findViewById7, "itemView.findViewById(R.id.mIvTop)");
            this.f16975g = (ImageView) findViewById7;
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f16973e;
        }

        public final ImageView c() {
            return this.f16970b;
        }

        public final ImageView d() {
            return this.f16975g;
        }

        public final ImageView e() {
            return this.f16974f;
        }

        public final AutoCardView f() {
            return this.f16969a;
        }

        public final TextView g() {
            return this.f16971c;
        }

        public final TextView h() {
            return this.f16972d;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k2 f16976a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f16977b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k2 k2Var, a aVar) {
            super(1);
            this.f16976a = k2Var;
            this.f16977b = aVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            e.f10706a.b(this.f16976a.f16965a, shelvePoster.getFileUrl(), this.f16977b.c(), R.drawable.special_cloumn_img_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16978a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(1);
            this.f16978a = aVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f16978a.c().setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    public k2(Context context, int i10, List list, String str) {
        i.g(context, f.X);
        i.g(list, "homeAssetList");
        i.g(str, "tdcFrom");
        this.f16965a = context;
        this.f16966b = i10;
        this.f16967c = list;
        this.f16968d = str;
    }

    public static final void f(w wVar, k2 k2Var, View view) {
        List<ShelvePoster> list;
        String str;
        i.g(wVar, "$item");
        i.g(k2Var, "this$0");
        d dVar = d.f10697a;
        ShelveAsset shelveAsset = (ShelveAsset) wVar.f19600a;
        if (shelveAsset != null) {
            list = shelveAsset.getPosterList();
        } else {
            list = null;
        }
        String o10 = dVar.o(list, dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str2 = o10;
        Context context = k2Var.f16965a;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) context;
        String type = ((ShelveAsset) wVar.f19600a).getType();
        String programType = ((ShelveAsset) wVar.f19600a).getProgramType();
        String contentId = ((ShelveAsset) wVar.f19600a).getContentId();
        EnterType enterType = EnterType.HOME;
        String alias = ((ShelveAsset) wVar.f19600a).getAlias();
        if (alias == null) {
            str = ((ShelveAsset) wVar.f19600a).getName();
        } else {
            str = alias;
        }
        b0.r(cVar, type, programType, contentId, enterType, str, false, false, k2Var.f16966b, k2Var.f16968d, str2);
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
    public void onBindViewHolder(a aVar, int i10) {
        String str;
        String str2;
        i.g(aVar, "holder");
        w wVar = new w();
        wVar.f19600a = this.f16967c.get(i10);
        aVar.f().setOnClickListener(new h2(wVar, this));
        boolean z10 = true;
        if (i.b(((ShelveAsset) wVar.f19600a).getType(), "0")) {
            if (((ShelveAsset) wVar.f19600a).getUpdateCount() == ((ShelveAsset) wVar.f19600a).getVolumnCount()) {
                z zVar = z.f19601a;
                String string = this.f16965a.getResources().getString(R.string.recommend_episodes_all);
                i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                str2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(((ShelveAsset) wVar.f19600a).getVolumnCount())}, 1));
                i.f(str2, "format(format, *args)");
            } else {
                z zVar2 = z.f19601a;
                String string2 = this.f16965a.getResources().getString(R.string.recommend_episodes);
                i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                str2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(((ShelveAsset) wVar.f19600a).getUpdateCount())}, 1));
                i.f(str2, "format(format, *args)");
            }
            aVar.g().setText(str2);
            aVar.g().setVisibility(0);
            aVar.b().setVisibility(0);
        } else {
            aVar.g().setVisibility(8);
            aVar.b().setVisibility(8);
        }
        TextView h10 = aVar.h();
        String alias = ((ShelveAsset) wVar.f19600a).getAlias();
        if (alias != null) {
            str = ba.t.W(alias).toString();
        } else {
            str = null;
        }
        b0.d(h10, str, ba.t.W(((ShelveAsset) wVar.f19600a).getName()).toString());
        String contentType = ((ShelveAsset) wVar.f19600a).getContentType();
        if (!(contentType == null || contentType.length() == 0)) {
            z10 = false;
        }
        if (z10 || !i.b(((ShelveAsset) wVar.f19600a).getContentType(), "1")) {
            aVar.e().setVisibility(8);
        } else {
            aVar.e().setVisibility(0);
        }
        switch (i10) {
            case 0:
                aVar.d().setImageResource(R.drawable.icon_top_1);
                break;
            case 1:
                aVar.d().setImageResource(R.drawable.icon_top_2);
                break;
            case 2:
                aVar.d().setImageResource(R.drawable.icon_top_3);
                break;
            case 3:
                aVar.d().setImageResource(R.drawable.icon_top_4);
                break;
            case 4:
                aVar.d().setImageResource(R.drawable.icon_top_5);
                break;
            case 5:
                aVar.d().setImageResource(R.drawable.icon_top_6);
                break;
            case 6:
                aVar.d().setImageResource(R.drawable.icon_top_7);
                break;
            case 7:
                aVar.d().setImageResource(R.drawable.icon_top_8);
                break;
            case 8:
                aVar.d().setImageResource(R.drawable.icon_top_9);
                break;
            case 9:
                aVar.d().setImageResource(R.drawable.icon_top_10);
                break;
        }
        d dVar = d.f10697a;
        dVar.l(((ShelveAsset) wVar.f19600a).getPosterList(), dVar.g()).subscribe(new i2(new b(this, aVar)), new j2(new c(aVar)));
    }

    public int getItemCount() {
        if (this.f16967c.size() > 10) {
            return 10;
        }
        return this.f16967c.size();
    }

    /* renamed from: i */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f16965a).inflate(R.layout.adapter_home_top_new_item, viewGroup, false);
        AutoUtils.autoSize(inflate);
        i.f(inflate, "view");
        return new a(inflate);
    }
}
