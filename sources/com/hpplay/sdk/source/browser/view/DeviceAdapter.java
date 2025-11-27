package com.hpplay.sdk.source.browser.view;

import android.content.Context;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hpplay.sdk.source.browser.a.a;
import com.hpplay.sdk.source.browser.b.b;
import com.hpplay.sdk.source.browser.b.c;
import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11620a = "DeviceAdapter";

    /* renamed from: b  reason: collision with root package name */
    private Context f11621b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f11622c;

    /* renamed from: d  reason: collision with root package name */
    private a f11623d;

    public static class ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public RelativeLayout f11624a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f11625b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f11626c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f11627d;

        /* renamed from: e  reason: collision with root package name */
        public ImageView f11628e;

        public ViewHolder(Context context) {
            RelativeLayout relativeLayout = new RelativeLayout(context);
            this.f11624a = relativeLayout;
            relativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(context);
            this.f11625b = linearLayout;
            linearLayout.setOrientation(0);
            this.f11625b.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            this.f11624a.addView(this.f11625b);
            ImageView imageView = new ImageView(context);
            this.f11626c = imageView;
            imageView.setId(c.a());
            this.f11626c.setPadding(b.a(context, 32.0d), b.a(context, 40.0d), b.a(context, 24.0d), b.a(context, 40.0d));
            this.f11625b.addView(this.f11626c, new LinearLayout.LayoutParams(-2, -2));
            TextView textView = new TextView(context);
            this.f11627d = textView;
            textView.setId(c.a());
            this.f11627d.setPadding(b.a(context, 20.0d), b.a(context, 44.0d), b.a(context, 20.0d), b.a(context, 44.0d));
            this.f11627d.setTextSize(2, 16.0f);
            this.f11627d.setTextColor(-1);
            this.f11627d.setGravity(8388627);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            this.f11625b.addView(this.f11627d, layoutParams);
            layoutParams.weight = 1.0f;
            this.f11628e = new ImageView(context);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b.a(context, 140.0d), b.a(context, 40.0d));
            layoutParams2.setMargins(b.a(context, 32.0d), b.a(context, 44.0d), b.a(context, 32.0d), b.a(context, 44.0d));
            this.f11625b.addView(this.f11628e, layoutParams2);
        }
    }

    public DeviceAdapter(Context context, List<a> list) {
        new ArrayList();
        this.f11621b = context;
        this.f11622c = list;
    }

    public void a(a aVar) {
        this.f11623d = aVar;
    }

    public int getCount() {
        List<a> list = this.f11622c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getItem(int i10) {
        return this.f11622c.get(i10);
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            if (r6 != 0) goto L_0x0012
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r6 = new com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder
            android.content.Context r7 = r4.f11621b
            r6.<init>(r7)
            android.widget.RelativeLayout r7 = r6.f11624a
            r7.setTag(r6)
        L_0x000e:
            r3 = r7
            r7 = r6
            r6 = r3
            goto L_0x0027
        L_0x0012:
            java.lang.Object r7 = r6.getTag()
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r7 = (com.hpplay.sdk.source.browser.view.DeviceAdapter.ViewHolder) r7
            if (r7 != 0) goto L_0x0027
            com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder r6 = new com.hpplay.sdk.source.browser.view.DeviceAdapter$ViewHolder
            android.content.Context r7 = r4.f11621b
            r6.<init>(r7)
            android.widget.RelativeLayout r7 = r6.f11624a
            r7.setTag(r6)
            goto L_0x000e
        L_0x0027:
            java.util.List<com.hpplay.sdk.source.browser.a.a> r0 = r4.f11622c     // Catch:{ Exception -> 0x00aa }
            java.lang.Object r5 = r0.get(r5)     // Catch:{ Exception -> 0x00aa }
            com.hpplay.sdk.source.browser.a.a r5 = (com.hpplay.sdk.source.browser.a.a) r5     // Catch:{ Exception -> 0x00aa }
            android.widget.ImageView r0 = r7.f11626c
            android.content.Context r1 = r4.f11621b
            java.lang.String r2 = "hpplay/device_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            android.widget.TextView r0 = r7.f11627d
            java.lang.String r1 = r5.b()
            r0.setText(r1)
            boolean r0 = r5.e()
            if (r0 == 0) goto L_0x0059
            android.widget.ImageView r0 = r7.f11628e
            android.content.Context r1 = r4.f11621b
            java.lang.String r2 = "hpplay/last_device_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            goto L_0x0088
        L_0x0059:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r1 = r5.c()
            r0.append(r1)
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            boolean r0 = com.hpplay.sdk.source.browser.b.c.b(r0)
            if (r0 == 0) goto L_0x0082
            android.widget.ImageView r0 = r7.f11628e
            android.content.Context r1 = r4.f11621b
            java.lang.String r2 = "hpplay/dongle_flag_icon.png"
            android.graphics.Bitmap r1 = com.hpplay.sdk.source.browser.b.c.a(r1, r2)
            r0.setImageBitmap(r1)
            goto L_0x0088
        L_0x0082:
            android.widget.ImageView r0 = r7.f11628e
            r1 = 0
            r0.setImageBitmap(r1)
        L_0x0088:
            com.hpplay.sdk.source.browser.a.a r0 = r4.f11623d
            if (r0 == 0) goto L_0x00a3
            java.lang.String r0 = r0.b()
            java.lang.String r5 = r5.b()
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x00a3
            android.widget.RelativeLayout r5 = r7.f11624a
            r7 = -15526892(0xffffffffff131414, float:-1.9550077E38)
            r5.setBackgroundColor(r7)
            goto L_0x00a9
        L_0x00a3:
            android.widget.RelativeLayout r5 = r7.f11624a
            r7 = 0
            r5.setBackgroundColor(r7)
        L_0x00a9:
            return r6
        L_0x00aa:
            r5 = move-exception
            java.lang.String r7 = "DeviceAdapter"
            com.hpplay.common.log.LeLog.w((java.lang.String) r7, (java.lang.Throwable) r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.browser.view.DeviceAdapter.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }
}
