package com.umeng.message.proguard;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.umeng.message.proguard.cc;

final class dr extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    final eh f15868a;

    /* renamed from: b  reason: collision with root package name */
    final ImageView f15869b;

    /* renamed from: c  reason: collision with root package name */
    final cl f15870c;

    /* renamed from: d  reason: collision with root package name */
    final LinearLayout f15871d;

    /* renamed from: e  reason: collision with root package name */
    int f15872e;

    /* renamed from: f  reason: collision with root package name */
    View.OnClickListener f15873f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Bitmap f15874g;

    /* renamed from: h  reason: collision with root package name */
    private cc.a f15875h;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00e7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public dr(android.content.Context r10, com.umeng.message.proguard.cl r11) {
        /*
            r9 = this;
            r9.<init>(r10)
            r0 = 1
            r9.requestWindowFeature(r0)
            com.umeng.message.proguard.eh r1 = new com.umeng.message.proguard.eh
            r1.<init>(r10)
            r9.f15868a = r1
            r9.setContentView(r1)
            r2 = 0
            r9.setCancelable(r2)
            r9.setCanceledOnTouchOutside(r2)
            r9.f15870c = r11
            int r3 = com.umeng.message.push.R.layout.umeng_interstitial_layout
            android.view.View.inflate(r10, r3, r1)
            int r1 = com.umeng.message.push.R.id.um_interstitial_content
            android.view.View r1 = r9.findViewById(r1)
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r9.f15871d = r1
            int r3 = com.umeng.message.push.R.id.um_interstitial_frame
            android.view.View r3 = r9.findViewById(r3)
            android.view.ViewGroup r3 = (android.view.ViewGroup) r3
            android.view.View r4 = r11.a()
            r3.addView(r4, r2)
            com.umeng.message.proguard.ck r3 = r11.f15625a
            int r4 = com.umeng.message.push.R.id.um_interstitial_mark
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            boolean r5 = r3.f()
            r6 = 8
            if (r5 == 0) goto L_0x0053
            int r5 = com.umeng.message.push.R.drawable.umeng_union_mark2
            r4.setImageResource(r5)
            r4.setVisibility(r2)
            goto L_0x0056
        L_0x0053:
            r4.setVisibility(r6)
        L_0x0056:
            int r4 = com.umeng.message.push.R.id.um_interstitial_iv_logo
            android.view.View r4 = r9.findViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            if (r4 == 0) goto L_0x0089
            r4.setVisibility(r6)
            org.json.JSONObject r5 = r3.f15606b
            java.lang.String r7 = "icon"
            java.lang.String r5 = r5.optString(r7)
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x0089
            com.umeng.message.proguard.dr$1 r7 = new com.umeng.message.proguard.dr$1
            r7.<init>(r4)
            r9.f15875h = r7
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r7)
            android.content.Context r7 = r10.getApplicationContext()
            com.umeng.message.proguard.cc$1 r8 = new com.umeng.message.proguard.cc$1
            r8.<init>(r7, r5, r4)
            com.umeng.message.proguard.cb.b(r8)
        L_0x0089:
            int r4 = com.umeng.message.push.R.id.um_interstitial_tv_title
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            if (r4 == 0) goto L_0x00a9
            java.lang.String r5 = r3.d()
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 == 0) goto L_0x00a1
            r4.setVisibility(r6)
            goto L_0x00a9
        L_0x00a1:
            r4.setVisibility(r2)
            r4.setText(r5)
            r4 = 1
            goto L_0x00aa
        L_0x00a9:
            r4 = 0
        L_0x00aa:
            int r5 = com.umeng.message.push.R.id.um_interstitial_tv_content
            android.view.View r5 = r9.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto L_0x00c9
            java.lang.String r3 = r3.e()
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 == 0) goto L_0x00c2
            r5.setVisibility(r6)
            goto L_0x00c9
        L_0x00c2:
            r5.setVisibility(r2)
            r5.setText(r3)
            goto L_0x00ca
        L_0x00c9:
            r0 = r4
        L_0x00ca:
            int r3 = com.umeng.message.push.R.id.um_interstitial_bottom
            android.view.View r3 = r9.findViewById(r3)
            if (r0 == 0) goto L_0x00d3
            r6 = 0
        L_0x00d3:
            r3.setVisibility(r6)
            int r0 = com.umeng.message.push.R.id.um_interstitial_iv_close
            android.view.View r0 = r9.findViewById(r0)
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            r9.f15869b = r0
            android.view.Window r0 = r9.getWindow()
            if (r0 != 0) goto L_0x00e7
            return
        L_0x00e7:
            android.graphics.drawable.ColorDrawable r3 = new android.graphics.drawable.ColorDrawable
            r3.<init>(r2)
            r0.setBackgroundDrawable(r3)
            android.view.WindowManager$LayoutParams r2 = r0.getAttributes()
            r3 = -1
            r2.width = r3
            r2.height = r3
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.alpha = r3
            r3 = 1058642330(0x3f19999a, float:0.6)
            r2.dimAmount = r3
            r0.setAttributes(r2)
            android.content.res.Resources r10 = r10.getResources()
            android.content.res.Configuration r10 = r10.getConfiguration()
            int r10 = r10.orientation
            r9.f15872e = r10
            r11.b()
            android.view.View r10 = r11.a()
            android.view.ViewGroup$LayoutParams r10 = r10.getLayoutParams()
            android.view.ViewGroup$LayoutParams r11 = r1.getLayoutParams()
            int r10 = r10.width
            r11.width = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.dr.<init>(android.content.Context, com.umeng.message.proguard.cl):void");
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Throwable th) {
            ce.d("Interstitial", "dismiss error:", th.getMessage());
        }
        this.f15875h = null;
        try {
            Bitmap bitmap = this.f15874g;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f15874g.recycle();
            }
        } catch (Throwable unused) {
        }
        this.f15874g = null;
    }

    public final void onBackPressed() {
    }

    public final void show() {
        try {
            super.show();
        } catch (Throwable th) {
            ce.d("Interstitial", "show error:", th.getMessage());
        }
    }
}
