package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;
import s9.l;
import t9.i;

public final class l3 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f16989a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f16990b;

    /* renamed from: c  reason: collision with root package name */
    public l f16991c;

    /* renamed from: d  reason: collision with root package name */
    public int f16992d;

    public final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoFrameLayout f16993a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16994b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f16995c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ l3 f16996d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l3 l3Var, View view) {
            super(view);
            i.g(view, "itemView");
            this.f16996d = l3Var;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f16993a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f16994b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mIvSelected);
            i.f(findViewById3, "itemView.findViewById(R.id.mIvSelected)");
            this.f16995c = (ImageView) findViewById3;
        }

        public final ImageView b() {
            return this.f16995c;
        }

        public final AutoFrameLayout c() {
            return this.f16993a;
        }

        public final TextView d() {
            return this.f16994b;
        }
    }

    public l3(Context context, String[] strArr, l lVar) {
        i.g(context, "mContext");
        i.g(strArr, "mOptions");
        i.g(lVar, "mItemClickListener");
        this.f16989a = context;
        this.f16990b = strArr;
        this.f16991c = lVar;
    }

    public static final void c(l3 l3Var, int i10, View view) {
        i.g(l3Var, "this$0");
        l3Var.f16992d = i10;
        l3Var.f16991c.invoke(Integer.valueOf(i10));
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i10) {
        int i11;
        i.g(aVar, "holder");
        aVar.d().setText(this.f16990b[i10]);
        ImageView b10 = aVar.b();
        if (this.f16992d == i10) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        b10.setVisibility(i11);
        aVar.c().setOnClickListener(new k3(this, i10));
    }

    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f16989a).inflate(R.layout.item_subtitle_options, viewGroup, false);
        i.f(inflate, "view");
        return new a(this, inflate);
    }

    public final void e(int i10) {
        this.f16992d = i10;
    }

    public int getItemCount() {
        return this.f16990b.length;
    }
}
