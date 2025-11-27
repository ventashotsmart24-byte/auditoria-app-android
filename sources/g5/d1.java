package g5;

import a7.e;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class d1 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16882a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16883b;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d1 f16884a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f16885b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d1 d1Var, BaseViewHolder baseViewHolder) {
            super(1);
            this.f16884a = d1Var;
            this.f16885b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context c10 = this.f16884a.mContext;
            i.f(c10, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f16885b.getView(R.id.mMyFavImage);
            i.f(view, "helper.getView(R.id.mMyFavImage)");
            eVar.b(c10, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f16886a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f16886a = baseViewHolder;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f16886a.getView(R.id.mMyFavImage)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d1(Context context) {
        super(R.layout.adapter_my_fav_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f16882a = context;
    }

    public static final void e(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void f(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b5  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void convert(com.chad.library.adapter.base.BaseViewHolder r10, mobile.com.requestframe.utils.response.Favorite r11) {
        /*
            r9 = this;
            java.lang.String r0 = "helper"
            t9.i.g(r10, r0)
            java.lang.String r0 = "item"
            t9.i.g(r11, r0)
            boolean r0 = r9.f16883b
            r1 = 2131362120(0x7f0a0148, float:1.8344012E38)
            r2 = 8
            r3 = 0
            if (r0 == 0) goto L_0x001e
            android.view.View r0 = r10.getView(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
            goto L_0x0027
        L_0x001e:
            android.view.View r0 = r10.getView(r1)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
        L_0x0027:
            r0 = 2131362571(0x7f0a030b, float:1.8344926E38)
            android.view.View r4 = r10.getView(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r3)
            java.lang.String r4 = r11.getType()
            java.lang.String r5 = "0"
            boolean r4 = t9.i.b(r4, r5)
            r5 = 2131362565(0x7f0a0305, float:1.8344914E38)
            r6 = 1
            if (r4 == 0) goto L_0x0086
            t9.z r4 = t9.z.f19601a
            android.content.Context r4 = r9.f16882a
            android.content.res.Resources r4 = r4.getResources()
            r7 = 2131821505(0x7f1103c1, float:1.9275755E38)
            java.lang.String r4 = r4.getString(r7)
            java.lang.String r7 = "context.resources.getStr…tring.recommend_episodes)"
            t9.i.f(r4, r7)
            java.lang.Object[] r7 = new java.lang.Object[r6]
            java.lang.Integer r8 = r11.getUpdateCount()
            r7[r3] = r8
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r4 = java.lang.String.format(r4, r7)
            java.lang.String r7 = "format(format, *args)"
            t9.i.f(r4, r7)
            r10.setText((int) r5, (java.lang.CharSequence) r4)
            android.content.Context r4 = r9.f16882a
            android.content.res.Resources r4 = r4.getResources()
            r7 = 2131099926(0x7f060116, float:1.781222E38)
            int r4 = r4.getColor(r7)
            r10.setTextColor(r5, r4)
            r10.setGone(r5, r6)
            r10.setGone(r0, r3)
            goto L_0x00b5
        L_0x0086:
            java.lang.Float r4 = r11.getScore()
            r7 = 0
            boolean r4 = t9.i.a(r4, r7)
            if (r4 == 0) goto L_0x009b
            android.view.View r4 = r10.getView(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r2)
            goto L_0x00a4
        L_0x009b:
            android.view.View r4 = r10.getView(r0)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r4.setVisibility(r3)
        L_0x00a4:
            java.lang.Float r4 = r11.getScore()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r10.setText((int) r0, (java.lang.CharSequence) r4)
            r10.setGone(r0, r6)
            r10.setGone(r5, r3)
        L_0x00b5:
            r0 = 2131362569(0x7f0a0309, float:1.8344922E38)
            android.view.View r0 = r10.getView(r0)
            java.lang.String r4 = "helper.getView(R.id.mMyFavName)"
            t9.i.f(r0, r4)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r4 = r11.getAlias()
            r5 = 0
            if (r4 == 0) goto L_0x00d3
            java.lang.CharSequence r4 = ba.t.W(r4)
            java.lang.String r4 = r4.toString()
            goto L_0x00d4
        L_0x00d3:
            r4 = r5
        L_0x00d4:
            java.lang.String r7 = r11.getName()
            if (r7 == 0) goto L_0x00e2
            java.lang.CharSequence r5 = ba.t.W(r7)
            java.lang.String r5 = r5.toString()
        L_0x00e2:
            com.mobile.brasiltv.utils.b0.d(r0, r4, r5)
            a7.d r0 = a7.d.f10697a
            java.util.List r4 = r11.getPosterList()
            java.lang.String r5 = r0.g()
            io.reactivex.Observable r0 = r0.l(r4, r5)
            g5.d1$a r4 = new g5.d1$a
            r4.<init>(r9, r10)
            g5.b1 r5 = new g5.b1
            r5.<init>(r4)
            g5.d1$b r4 = new g5.d1$b
            r4.<init>(r10)
            g5.c1 r7 = new g5.c1
            r7.<init>(r4)
            r0.subscribe(r5, r7)
            java.lang.String r0 = r11.getContentType()
            if (r0 == 0) goto L_0x0119
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0117
            goto L_0x0119
        L_0x0117:
            r0 = 0
            goto L_0x011a
        L_0x0119:
            r0 = 1
        L_0x011a:
            java.lang.String r4 = "1"
            r5 = 2131362330(0x7f0a021a, float:1.8344438E38)
            if (r0 != 0) goto L_0x0135
            java.lang.String r0 = r11.getContentType()
            boolean r0 = t9.i.b(r0, r4)
            if (r0 == 0) goto L_0x0135
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
            goto L_0x013e
        L_0x0135:
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
        L_0x013e:
            java.lang.Integer r0 = r11.getMoreSubtitle()
            r5 = 2131362304(0x7f0a0200, float:1.8344385E38)
            if (r0 != 0) goto L_0x0148
            goto L_0x0158
        L_0x0148:
            int r0 = r0.intValue()
            if (r0 != r6) goto L_0x0158
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
            goto L_0x0161
        L_0x0158:
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
        L_0x0161:
            java.lang.Integer r0 = r11.getMoreSubtitle()
            r5 = 2131362308(0x7f0a0204, float:1.8344393E38)
            if (r0 != 0) goto L_0x016b
            goto L_0x0171
        L_0x016b:
            int r0 = r0.intValue()
            if (r0 == r6) goto L_0x0195
        L_0x0171:
            java.lang.String r0 = r11.getContentType()
            if (r0 == 0) goto L_0x017f
            int r0 = r0.length()
            if (r0 != 0) goto L_0x017e
            goto L_0x017f
        L_0x017e:
            r6 = 0
        L_0x017f:
            if (r6 != 0) goto L_0x018b
            java.lang.String r0 = r11.getContentType()
            boolean r0 = t9.i.b(r0, r4)
            if (r0 != 0) goto L_0x0195
        L_0x018b:
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r2)
            goto L_0x019e
        L_0x0195:
            android.view.View r0 = r10.getView(r5)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r0.setVisibility(r3)
        L_0x019e:
            boolean r0 = r9.f16883b
            if (r0 == 0) goto L_0x01b5
            boolean r11 = r11.isSelect()
            if (r11 == 0) goto L_0x01b5
            android.view.View r10 = r10.getView(r1)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r11 = 2131231468(0x7f0802ec, float:1.8079018E38)
            r10.setImageResource(r11)
            goto L_0x01c1
        L_0x01b5:
            android.view.View r10 = r10.getView(r1)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r11 = 2131231456(0x7f0802e0, float:1.8078994E38)
            r10.setImageResource(r11)
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.d1.convert(com.chad.library.adapter.base.BaseViewHolder, mobile.com.requestframe.utils.response.Favorite):void");
    }

    public final void g(boolean z10) {
        this.f16883b = z10;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
