package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.c;
import h9.t;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import t9.z;

public final class y1 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17180a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17181b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17182c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f17183d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f17184e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17185f;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ y1 f17186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f17187b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(y1 y1Var, BaseViewHolder baseViewHolder) {
            super(1);
            this.f17186a = y1Var;
            this.f17187b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context d10 = this.f17186a.mContext;
            i.f(d10, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f17187b.getView(R.id.posterImageView);
            i.f(view, "helper.getView(R.id.posterImageView)");
            eVar.b(d10, fileUrl, (ImageView) view, R.drawable.special_cloumn_img_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f17188a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f17188a = baseViewHolder;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f17188a.getView(R.id.posterImageView)).setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ y1(Context context, int i10, boolean z10, boolean z11, boolean z12, String str, int i11, g gVar) {
        this(context, i10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? "" : str);
    }

    public static final void f(ShelveAsset shelveAsset, y1 y1Var, View view) {
        i.g(shelveAsset, "$item");
        i.g(y1Var, "this$0");
        d dVar = d.f10697a;
        String o10 = dVar.o(shelveAsset.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        StringBuilder sb = new StringBuilder();
        sb.append(shelveAsset.getType());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(shelveAsset.getProgramType());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(shelveAsset.getContentId());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        EnterType enterType = EnterType.CATEGORY;
        sb.append(enterType);
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(ba.t.W(shelveAsset.getAlias()).toString());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(ba.t.W(shelveAsset.getName()).toString());
        Context context = y1Var.mContext;
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.r((c) context, shelveAsset.getType(), shelveAsset.getProgramType(), shelveAsset.getContentId(), enterType, b0.c(ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString()), y1Var.f17184e, false, y1Var.f17181b, y1Var.f17185f, str);
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
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        String str;
        String str2;
        String str3;
        i.g(baseViewHolder, "helper");
        i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new v1(shelveAsset, this));
        boolean z10 = true;
        if (!i.b(shelveAsset.getType(), "0") || this.f17182c) {
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(8);
        } else {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                z zVar = z.f19601a;
                String string = this.f17180a.getResources().getString(R.string.recommend_episodes_all);
                i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                str3 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                i.f(str3, "format(format, *args)");
            } else {
                z zVar2 = z.f19601a;
                String string2 = this.f17180a.getResources().getString(R.string.recommend_episodes);
                i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                str3 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                i.f(str3, "format(format, *args)");
            }
            baseViewHolder.setText((int) R.id.mTvEpisodeInfo, (CharSequence) str3);
            baseViewHolder.setTextColor(R.id.mTvEpisodeInfo, this.f17180a.getResources().getColor(R.color.color_ffffff));
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(0);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
        }
        String contentType = shelveAsset.getContentType();
        if (!(contentType == null || contentType.length() == 0)) {
            z10 = false;
        }
        if (z10 || !i.b(shelveAsset.getContentType(), "1")) {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
        } else {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(0);
        }
        View view = baseViewHolder.getView(R.id.mPosterName);
        i.f(view, "helper.getView<TextView>(R.id.mPosterName)");
        b0.d((TextView) view, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        View view2 = baseViewHolder.getView(R.id.mPosterNameSpecial);
        i.f(view2, "helper.getView<TextView>(R.id.mPosterNameSpecial)");
        b0.d((TextView) view2, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        d dVar = d.f10697a;
        dVar.i();
        if (this.f17182c) {
            str = dVar.g();
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setPadding(7, 7, 7, 0);
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(R.drawable.bg_radius_white);
            ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setLayoutParams(new LinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(210), AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT)));
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(8);
        } else {
            if (!this.f17183d) {
                str2 = dVar.i();
            } else {
                str2 = dVar.g();
            }
            str = str2;
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(8);
        }
        dVar.l(shelveAsset.getPosterList(), str).subscribe(new w1(new a(this, baseViewHolder)), new x1(new b(baseViewHolder)));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y1(Context context, int i10, boolean z10, boolean z11, boolean z12, String str) {
        super(R.layout.adapter_recommend_horizontal_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        i.g(str, "tdcFrom");
        this.f17180a = context;
        this.f17181b = i10;
        this.f17182c = z10;
        this.f17183d = z11;
        this.f17184e = z12;
        this.f17185f = str;
    }
}
