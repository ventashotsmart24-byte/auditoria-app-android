package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import s9.l;
import t9.i;

public final class n3 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f17020a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17021b;

    /* renamed from: c  reason: collision with root package name */
    public l f17022c;

    /* renamed from: d  reason: collision with root package name */
    public int f17023d;

    public final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoFrameLayout f17024a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17025b;

        /* renamed from: c  reason: collision with root package name */
        public AutoLinearLayout f17026c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17027d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n3 f17028e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(n3 n3Var, View view) {
            super(view);
            i.g(view, "itemView");
            this.f17028e = n3Var;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f17024a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f17025b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mLlBg);
            i.f(findViewById3, "itemView.findViewById(R.id.mLlBg)");
            this.f17026c = (AutoLinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSelected);
            i.f(findViewById4, "itemView.findViewById(R.id.mIvSelected)");
            this.f17027d = (ImageView) findViewById4;
        }

        public final ImageView b() {
            return this.f17027d;
        }

        public final AutoFrameLayout c() {
            return this.f17024a;
        }

        public final AutoLinearLayout d() {
            return this.f17026c;
        }

        public final TextView e() {
            return this.f17025b;
        }
    }

    public n3(Context context, ArrayList arrayList, l lVar) {
        i.g(context, "mContext");
        i.g(arrayList, "mOptions");
        i.g(lVar, "mItemClickListener");
        this.f17020a = context;
        this.f17021b = arrayList;
        this.f17022c = lVar;
    }

    public static final void c(n3 n3Var, int i10, View view) {
        i.g(n3Var, "this$0");
        n3Var.f17023d = i10;
        n3Var.f17022c.invoke(Integer.valueOf(i10));
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i10) {
        int i11;
        i.g(aVar, "holder");
        Object obj = this.f17021b.get(i10);
        i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubtitleStyleBean");
        SubtitleStyleBean subtitleStyleBean = (SubtitleStyleBean) obj;
        aVar.e().setText(this.f17020a.getString(R.string.Aa));
        aVar.e().setTextColor(subtitleStyleBean.getColor());
        aVar.d().setBackgroundColor(subtitleStyleBean.getBackgrounrd());
        ImageView b10 = aVar.b();
        if (this.f17023d == i10) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        b10.setVisibility(i11);
        aVar.c().setOnClickListener(new m3(this, i10));
    }

    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17020a).inflate(R.layout.item_subtitle_style_options, viewGroup, false);
        i.f(inflate, "view");
        return new a(this, inflate);
    }

    public final void e(int i10) {
        this.f17023d = i10;
    }

    public int getItemCount() {
        return this.f17021b.size();
    }
}
