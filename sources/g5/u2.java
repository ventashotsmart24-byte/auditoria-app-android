package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.SearchBean;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;
import i9.j;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;
import t9.w;

public final class u2 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final String f17128a = "SearchAdapter";

    /* renamed from: b  reason: collision with root package name */
    public Context f17129b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f17130c;

    /* renamed from: d  reason: collision with root package name */
    public b f17131d;

    /* renamed from: e  reason: collision with root package name */
    public a f17132e;

    public interface a {
        void a(Channel channel, int i10);
    }

    public interface b {
        void a(Channel channel);
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17133a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17134b;

        /* renamed from: c  reason: collision with root package name */
        public AutoFrameLayout f17135c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17136d;

        /* renamed from: e  reason: collision with root package name */
        public ProgressBar f17137e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            i.g(view, "itemView");
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mIvChannelLogo);
            i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f17133a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTextName);
            i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f17134b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mFavWrapper);
            i.e(findViewById3, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout");
            this.f17135c = (AutoFrameLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvFav);
            i.e(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.f17136d = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mPbUnfav);
            i.e(findViewById5, "null cannot be cast to non-null type android.widget.ProgressBar");
            this.f17137e = (ProgressBar) findViewById5;
        }

        public final AutoFrameLayout b() {
            return this.f17135c;
        }

        public final ImageView c() {
            return this.f17133a;
        }

        public final ImageView d() {
            return this.f17136d;
        }

        public final ProgressBar e() {
            return this.f17137e;
        }

        public final TextView f() {
            return this.f17134b;
        }
    }

    public u2(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "data");
        this.f17129b = context;
        this.f17130c = arrayList;
    }

    public static final void d(u2 u2Var, w wVar, View view) {
        i.g(u2Var, "this$0");
        i.g(wVar, "$channel");
        b bVar = u2Var.f17131d;
        if (bVar != null) {
            bVar.a((Channel) wVar.f19600a);
        }
    }

    public static final void e(u2 u2Var, w wVar, int i10, View view) {
        i.g(u2Var, "this$0");
        i.g(wVar, "$channel");
        a aVar = u2Var.f17132e;
        if (aVar != null) {
            aVar.a((Channel) wVar.f19600a, i10);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0083  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(g5.u2.c r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "holder"
            t9.i.g(r7, r0)
            t9.w r0 = new t9.w
            r0.<init>()
            java.util.ArrayList r1 = r6.f17130c
            java.lang.Object r1 = r1.get(r8)
            com.mobile.brasiltv.bean.SearchBean r1 = (com.mobile.brasiltv.bean.SearchBean) r1
            mobile.com.requestframe.utils.response.Channel r1 = r1.getChannel()
            r0.f19600a = r1
            a7.e r2 = a7.e.f10706a
            android.content.Context r3 = r6.f17129b
            java.lang.String r1 = r1.getPosterUrl()
            android.widget.ImageView r4 = r7.c()
            r5 = 2131231382(0x7f080296, float:1.8078843E38)
            r2.b(r3, r1, r4, r5)
            boolean r1 = com.mobile.brasiltv.utils.f0.b()
            r2 = 0
            if (r1 != 0) goto L_0x0057
            java.lang.Object r1 = r0.f19600a
            mobile.com.requestframe.utils.response.Channel r1 = (mobile.com.requestframe.utils.response.Channel) r1
            java.lang.String r1 = r1.getAlias()
            if (r1 == 0) goto L_0x0044
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r1 = 0
            goto L_0x0045
        L_0x0044:
            r1 = 1
        L_0x0045:
            if (r1 != 0) goto L_0x0057
            android.widget.TextView r1 = r7.f()
            java.lang.Object r3 = r0.f19600a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getAlias()
            r1.setText(r3)
            goto L_0x0066
        L_0x0057:
            android.widget.TextView r1 = r7.f()
            java.lang.Object r3 = r0.f19600a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getName()
            r1.setText(r3)
        L_0x0066:
            android.view.View r1 = r7.itemView
            g5.s2 r3 = new g5.s2
            r3.<init>(r6, r0)
            r1.setOnClickListener(r3)
            d6.a r1 = d6.a.f16338a
            int r3 = r1.j()
            r4 = 3
            r5 = 8
            if (r3 == r4) goto L_0x0083
            com.zhy.autolayout.AutoFrameLayout r7 = r7.b()
            r7.setVisibility(r5)
            return
        L_0x0083:
            com.zhy.autolayout.AutoFrameLayout r3 = r7.b()
            r3.setVisibility(r2)
            java.lang.Object r3 = r0.f19600a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            boolean r3 = r1.g(r3)
            if (r3 == 0) goto L_0x009f
            android.widget.ImageView r3 = r7.d()
            r4 = 2131231406(0x7f0802ae, float:1.8078892E38)
            r3.setImageResource(r4)
            goto L_0x00a9
        L_0x009f:
            android.widget.ImageView r3 = r7.d()
            r4 = 2131231411(0x7f0802b3, float:1.8078902E38)
            r3.setImageResource(r4)
        L_0x00a9:
            java.lang.Object r3 = r0.f19600a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getChannelCode()
            boolean r1 = r1.l(r3)
            if (r1 == 0) goto L_0x00c6
            android.widget.ImageView r1 = r7.d()
            r1.setVisibility(r5)
            android.widget.ProgressBar r1 = r7.e()
            r1.setVisibility(r2)
            goto L_0x00d4
        L_0x00c6:
            android.widget.ImageView r1 = r7.d()
            r1.setVisibility(r2)
            android.widget.ProgressBar r1 = r7.e()
            r1.setVisibility(r5)
        L_0x00d4:
            com.zhy.autolayout.AutoFrameLayout r7 = r7.b()
            g5.t2 r1 = new g5.t2
            r1.<init>(r6, r0, r8)
            r7.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.u2.onBindViewHolder(g5.u2$c, int):void");
    }

    /* renamed from: f */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17129b).inflate(R.layout.adapter_search_item, viewGroup, false);
        i.f(inflate, "view");
        return new c(inflate);
    }

    public final void g(ArrayList arrayList) {
        i.g(arrayList, "data");
        this.f17130c = arrayList;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f17130c.size();
    }

    public final void h(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17132e = aVar;
    }

    public final void i(b bVar) {
        i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17131d = bVar;
    }

    public final void j(String str, int i10) {
        i.g(str, "channelCode");
        if (this.f17130c.size() > i10 && i.b(((SearchBean) this.f17130c.get(i10)).getChannel().getChannelCode(), str)) {
            notifyItemChanged(i10);
        }
    }

    public final void k(String str) {
        i.g(str, "channelCode");
        int i10 = 0;
        for (Object next : this.f17130c) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                j.j();
            }
            if (i.b(((SearchBean) next).getChannel().getChannelCode(), str)) {
                notifyItemChanged(i10);
                return;
            }
            i10 = i11;
        }
    }
}
