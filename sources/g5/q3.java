package g5;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import t9.i;

public final class q3 extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public Context f17055a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17056b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f17057c;

    /* renamed from: d  reason: collision with root package name */
    public a f17058d;

    public interface a {
        void a(int i10, SwitchAccountBean switchAccountBean);

        void b(int i10, String str, SwitchAccountBean switchAccountBean);

        void onBack();
    }

    public final class b {

        /* renamed from: a  reason: collision with root package name */
        public View f17059a;

        /* renamed from: b  reason: collision with root package name */
        public ImageView f17060b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17061c = ((TextView) this.f17059a.findViewById(R.id.mTvAccountName));

        /* renamed from: d  reason: collision with root package name */
        public TextView f17062d = ((TextView) this.f17059a.findViewById(R.id.mTvAccountId));

        /* renamed from: e  reason: collision with root package name */
        public TextView f17063e = ((TextView) this.f17059a.findViewById(R.id.mTvNickName));

        /* renamed from: f  reason: collision with root package name */
        public ImageView f17064f = ((ImageView) this.f17059a.findViewById(R.id.mIvStatus));

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ q3 f17065g;

        public b(q3 q3Var, View view) {
            i.g(view, "itemView");
            this.f17065g = q3Var;
            this.f17059a = view;
            this.f17060b = (ImageView) view.findViewById(R.id.mIvIcon);
            AutoUtils.auto(this.f17059a);
            this.f17059a.setTag(this);
        }

        public final View a() {
            return this.f17059a;
        }

        public final ImageView b() {
            return this.f17060b;
        }

        public final ImageView c() {
            return this.f17064f;
        }

        public final TextView d() {
            return this.f17062d;
        }

        public final TextView e() {
            return this.f17061c;
        }

        public final TextView f() {
            return this.f17063e;
        }
    }

    public q3(Context context) {
        i.g(context, f.X);
        this.f17055a = context;
    }

    public static final void e(SwitchAccountBean switchAccountBean, q3 q3Var, int i10, b bVar, View view) {
        a aVar;
        i.g(switchAccountBean, "$bean");
        i.g(q3Var, "this$0");
        i.g(bVar, "$holder");
        if (!switchAccountBean.isLogged() && q3Var.f17057c) {
            a aVar2 = q3Var.f17058d;
            if (aVar2 != null) {
                aVar2.b(i10, bVar.e().getText().toString(), switchAccountBean);
            }
        } else if (switchAccountBean.isLogged() && !q3Var.f17057c && (aVar = q3Var.f17058d) != null) {
            aVar.onBack();
        }
    }

    public static final void f(SwitchAccountBean switchAccountBean, q3 q3Var, int i10, View view) {
        a aVar;
        i.g(switchAccountBean, "$bean");
        i.g(q3Var, "this$0");
        if (switchAccountBean.isLogged() && !q3Var.f17057c) {
            a aVar2 = q3Var.f17058d;
            if (aVar2 != null) {
                aVar2.onBack();
            }
        } else if (!q3Var.f17057c && (aVar = q3Var.f17058d) != null) {
            aVar.a(i10, switchAccountBean);
        }
    }

    /* renamed from: c */
    public SwitchAccountBean getItem(int i10) {
        Object obj = this.f17056b.get(i10);
        i.f(obj, "mList[position]");
        return (SwitchAccountBean) obj;
    }

    public final ArrayList d() {
        return this.f17056b;
    }

    public final boolean g() {
        return this.f17057c;
    }

    public int getCount() {
        if (this.f17056b.size() >= 5) {
            return 5;
        }
        return this.f17056b.size();
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0195, code lost:
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PEERSTAR) == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x019c, code lost:
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a3, code lost:
        if (r1.equals("4") == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01aa, code lost:
        if (r1.equals("3") == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01ad, code lost:
        r13.b().setImageResource(com.msandroid.mobile.R.mipmap.ic_account_type_phone);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01d2, code lost:
        if (r1.equals("1") == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d5, code lost:
        r13.b().setImageResource(com.msandroid.mobile.R.mipmap.ic_account_type_id);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r11, android.view.View r12, android.view.ViewGroup r13) {
        /*
            r10 = this;
            if (r12 != 0) goto L_0x001b
            android.content.Context r12 = r10.f17055a
            android.view.LayoutInflater r12 = android.view.LayoutInflater.from(r12)
            r13 = 2131558679(0x7f0d0117, float:1.874268E38)
            r0 = 0
            android.view.View r12 = r12.inflate(r13, r0)
            java.lang.String r13 = "from(context).inflate(R.…tem_switch_account, null)"
            t9.i.f(r12, r13)
            g5.q3$b r13 = new g5.q3$b
            r13.<init>(r10, r12)
            goto L_0x0026
        L_0x001b:
            java.lang.Object r13 = r12.getTag()
            java.lang.String r0 = "null cannot be cast to non-null type com.mobile.brasiltv.adapter.SwitchAccountListAdapter.ViewHolder"
            t9.i.e(r13, r0)
            g5.q3$b r13 = (g5.q3.b) r13
        L_0x0026:
            java.util.ArrayList r0 = r10.f17056b
            java.lang.Object r0 = r0.get(r11)
            java.lang.String r1 = "mList[position]"
            t9.i.f(r0, r1)
            com.mobile.brasiltv.db.SwitchAccountBean r0 = (com.mobile.brasiltv.db.SwitchAccountBean) r0
            java.lang.String r1 = r0.getAccountType()
            java.lang.String r2 = "3"
            boolean r1 = t9.i.b(r1, r2)
            java.lang.String r3 = "google"
            java.lang.String r4 = "5"
            java.lang.String r5 = "4"
            r6 = 1
            r7 = 0
            if (r1 != 0) goto L_0x0090
            java.lang.String r1 = r0.getAccountType()
            boolean r1 = t9.i.b(r1, r5)
            if (r1 != 0) goto L_0x0090
            java.lang.String r1 = r0.getAccountType()
            boolean r1 = t9.i.b(r1, r4)
            if (r1 == 0) goto L_0x005c
            goto L_0x0090
        L_0x005c:
            java.lang.String r1 = r0.getAccountType()
            boolean r1 = t9.i.b(r1, r3)
            if (r1 == 0) goto L_0x0084
            android.widget.TextView r1 = r13.e()
            java.lang.String r8 = r0.getUserName()
            int r8 = r8.length()
            if (r8 <= 0) goto L_0x0076
            r8 = 1
            goto L_0x0077
        L_0x0076:
            r8 = 0
        L_0x0077:
            if (r8 == 0) goto L_0x007e
            java.lang.String r8 = r0.getUserName()
            goto L_0x0080
        L_0x007e:
            java.lang.String r8 = "Google"
        L_0x0080:
            r1.setText(r8)
            goto L_0x00b8
        L_0x0084:
            android.widget.TextView r1 = r13.e()
            java.lang.String r8 = r0.getUserName()
            r1.setText(r8)
            goto L_0x00b8
        L_0x0090:
            android.widget.TextView r1 = r13.e()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 43
            r8.append(r9)
            java.lang.String r9 = r0.getAreaCode()
            r8.append(r9)
            r9 = 32
            r8.append(r9)
            java.lang.String r9 = r0.getUserName()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r1.setText(r8)
        L_0x00b8:
            java.lang.String r1 = r0.getUserId()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x00c4
            r1 = 1
            goto L_0x00c5
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            if (r1 == 0) goto L_0x00f6
            java.lang.String r1 = r0.getUserName()
            java.lang.String r8 = r0.getUserId()
            boolean r1 = t9.i.b(r1, r8)
            if (r1 != 0) goto L_0x00f6
            android.widget.TextView r1 = r13.d()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r9 = 40
            r8.append(r9)
            java.lang.String r9 = r0.getUserId()
            r8.append(r9)
            r9 = 41
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r1.setText(r8)
        L_0x00f6:
            java.lang.String r1 = r0.getNickName()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0101
            goto L_0x0102
        L_0x0101:
            r6 = 0
        L_0x0102:
            r1 = 8
            if (r6 == 0) goto L_0x0119
            android.widget.TextView r6 = r13.f()
            java.lang.String r8 = r0.getNickName()
            r6.setText(r8)
            android.widget.TextView r6 = r13.f()
            r6.setVisibility(r7)
            goto L_0x0129
        L_0x0119:
            android.widget.TextView r6 = r13.f()
            java.lang.String r8 = ""
            r6.setText(r8)
            android.widget.TextView r6 = r13.f()
            r6.setVisibility(r1)
        L_0x0129:
            boolean r6 = r0.isLogged()
            if (r6 == 0) goto L_0x0141
            android.widget.ImageView r1 = r13.c()
            r1.setVisibility(r7)
            android.widget.ImageView r1 = r13.c()
            r6 = 2131623946(0x7f0e000a, float:1.8875058E38)
            r1.setImageResource(r6)
            goto L_0x0165
        L_0x0141:
            boolean r6 = r10.f17057c
            if (r6 == 0) goto L_0x0157
            android.widget.ImageView r1 = r13.c()
            r1.setVisibility(r7)
            android.widget.ImageView r1 = r13.c()
            r6 = 2131623947(0x7f0e000b, float:1.887506E38)
            r1.setImageResource(r6)
            goto L_0x0165
        L_0x0157:
            android.widget.ImageView r6 = r13.c()
            r6.setVisibility(r1)
            android.widget.ImageView r1 = r13.c()
            r1.setImageResource(r7)
        L_0x0165:
            java.lang.String r1 = r0.getAccountType()
            int r6 = r1.hashCode()
            r7 = -1240244679(0xffffffffb6135e39, float:-2.1959552E-6)
            r8 = 2131623950(0x7f0e000e, float:1.8875066E38)
            if (r6 == r7) goto L_0x01dd
            switch(r6) {
                case 49: goto L_0x01cc;
                case 50: goto L_0x01b8;
                case 51: goto L_0x01a6;
                case 52: goto L_0x019f;
                case 53: goto L_0x0198;
                case 54: goto L_0x018f;
                case 55: goto L_0x017a;
                default: goto L_0x0178;
            }
        L_0x0178:
            goto L_0x01e3
        L_0x017a:
            java.lang.String r2 = "7"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0183
            goto L_0x01e3
        L_0x0183:
            android.widget.ImageView r1 = r13.b()
            r2 = 2131623952(0x7f0e0010, float:1.887507E38)
            r1.setImageResource(r2)
            goto L_0x01f5
        L_0x018f:
            java.lang.String r2 = "6"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01d5
            goto L_0x01e3
        L_0x0198:
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x01ad
            goto L_0x01e3
        L_0x019f:
            boolean r1 = r1.equals(r5)
            if (r1 != 0) goto L_0x01ad
            goto L_0x01e3
        L_0x01a6:
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01ad
            goto L_0x01e3
        L_0x01ad:
            android.widget.ImageView r1 = r13.b()
            r2 = 2131623951(0x7f0e000f, float:1.8875068E38)
            r1.setImageResource(r2)
            goto L_0x01f5
        L_0x01b8:
            java.lang.String r2 = "2"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01c1
            goto L_0x01e3
        L_0x01c1:
            android.widget.ImageView r1 = r13.b()
            r2 = 2131623948(0x7f0e000c, float:1.8875062E38)
            r1.setImageResource(r2)
            goto L_0x01f5
        L_0x01cc:
            java.lang.String r2 = "1"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x01d5
            goto L_0x01e3
        L_0x01d5:
            android.widget.ImageView r1 = r13.b()
            r1.setImageResource(r8)
            goto L_0x01f5
        L_0x01dd:
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x01eb
        L_0x01e3:
            android.widget.ImageView r1 = r13.b()
            r1.setImageResource(r8)
            goto L_0x01f5
        L_0x01eb:
            android.widget.ImageView r1 = r13.b()
            r2 = 2131623949(0x7f0e000d, float:1.8875064E38)
            r1.setImageResource(r2)
        L_0x01f5:
            android.widget.ImageView r1 = r13.c()
            g5.o3 r2 = new g5.o3
            r2.<init>(r0, r10, r11, r13)
            r1.setOnClickListener(r2)
            android.view.View r13 = r13.a()
            g5.p3 r1 = new g5.p3
            r1.<init>(r0, r10, r11)
            r13.setOnClickListener(r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.q3.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void h(a aVar) {
        this.f17058d = aVar;
    }

    public final void i(ArrayList arrayList) {
        i.g(arrayList, "value");
        this.f17056b.clear();
        this.f17056b.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void j(boolean z10) {
        this.f17057c = z10;
    }
}
