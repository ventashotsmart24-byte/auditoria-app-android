package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import d6.b;
import java.util.List;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.w;

public final class d0 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f16878a;

    /* renamed from: b  reason: collision with root package name */
    public List f16879b;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f16880a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f16881b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.g(view, "itemView");
            this.f16880a = (ImageView) view.findViewById(R.id.mIvGamePoster);
            this.f16881b = (TextView) view.findViewById(R.id.mTvAdFlag);
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f16880a;
        }

        public final TextView c() {
            return this.f16881b;
        }
    }

    public d0(Context context, List list) {
        i.g(context, f.X);
        i.g(list, "adInfoList");
        this.f16878a = context;
        this.f16879b = list;
    }

    public static final void c(w wVar, d0 d0Var, int i10, View view) {
        i.g(wVar, "$adInfo");
        i.g(d0Var, "this$0");
        if (i.b(((AdInfo) wVar.f19600a).getAction_type(), "1") && b0.H(((AdInfo) wVar.f19600a).getAction())) {
            b0.v(d0Var.f16878a, ((AdInfo) wVar.f19600a).getAction());
            q qVar = q.f9311a;
            Context context = d0Var.f16878a;
            qVar.m(context, a6.a.f10646a.e() + '_' + i10, b.f6366a.m(d0Var.f16878a), (AdInfo) wVar.f19600a);
        } else if (i.b(((AdInfo) wVar.f19600a).getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            b0.m(d0Var.f16878a);
        }
    }

    /* renamed from: b */
    public void onBindViewHolder(a aVar, int i10) {
        int i11 = i10;
        i.g(aVar, "holder");
        w wVar = new w();
        wVar.f19600a = this.f16879b.get(i11);
        m mVar = m.f9270a;
        Context context = this.f16878a;
        ImageView b10 = aVar.b();
        i.f(b10, "holder.mIvGamePoster");
        m.h0(mVar, context, b10, a6.a.f10646a.e(), (AdInfo) wVar.f19600a, (Integer) null, (l) null, (Integer) null, false, 0, 496, (Object) null);
        if (((AdInfo) wVar.f19600a).isShowFlag()) {
            aVar.c().setVisibility(0);
        } else {
            aVar.c().setVisibility(8);
        }
        aVar.b().setOnClickListener(new c0(wVar, this, i11));
    }

    /* renamed from: d */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f16878a).inflate(R.layout.adapter_free_game_item, viewGroup, false);
        i.f(inflate, "view");
        return new a(inflate);
    }

    public int getItemCount() {
        return this.f16879b.size();
    }
}
