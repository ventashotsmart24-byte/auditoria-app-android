package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.message.UTrack;
import com.umeng.message.api.UPushInAppMessageCallback;
import com.umeng.message.api.UPushInAppMessageHandler;
import com.umeng.message.common.UPLog;

public final class aq {

    /* renamed from: a  reason: collision with root package name */
    protected ap f15404a;

    /* renamed from: b  reason: collision with root package name */
    public final at f15405b;

    /* renamed from: c  reason: collision with root package name */
    public final View.OnClickListener f15406c;

    /* renamed from: d  reason: collision with root package name */
    public int f15407d = bo.a(80.0f);

    public aq(Context context, final ap apVar) {
        this.f15404a = apVar;
        at atVar = new at(context, apVar);
        this.f15405b = atVar;
        atVar.setClipChildren(false);
        atVar.setClipToPadding(false);
        atVar.setClickable(true);
        atVar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    Activity activity = (Activity) view.getContext();
                    if (activity != null) {
                        UPLog.i("Pop", "click msgId:", apVar.f15401a.getMsgId());
                        v.a().getNotificationClickHandler().handleMessage(activity, apVar.f15401a);
                        UPushInAppMessageCallback inAppMessageCallback = v.a().getInAppMessageCallback();
                        if (inAppMessageCallback != null) {
                            inAppMessageCallback.onClick(y.a(), apVar.f15401a);
                        }
                        ak.a().a(activity);
                        UTrack.getInstance().trackInAppNotifyClick(apVar.f15401a);
                    }
                } catch (Throwable th) {
                    UPLog.e("Pop", th);
                }
            }
        });
        AnonymousClass2 r32 = new View.OnClickListener() {
            public final void onClick(View view) {
                try {
                    Activity activity = (Activity) view.getContext();
                    if (activity != null) {
                        UPLog.i("Pop", "close msgId:", apVar.f15401a.getMsgId());
                        ak.a().a(activity);
                    }
                } catch (Throwable th) {
                    UPLog.e("Pop", "onDismiss", th);
                }
            }
        };
        this.f15406c = r32;
        atVar.setDismissListener(r32);
        UPushInAppMessageHandler inAppMessageHandler = v.a().getInAppMessageHandler();
        if (inAppMessageHandler != null) {
            try {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f15407d);
                layoutParams.gravity = 17;
                View view = inAppMessageHandler.getView(context, apVar.f15401a, layoutParams);
                if (view != null) {
                    if (view.getParent() != null) {
                        ((ViewGroup) view.getParent()).removeView(view);
                    }
                    int i10 = layoutParams.height;
                    if (i10 > 0 && i10 != this.f15407d) {
                        this.f15407d = i10;
                    }
                    atVar.setBackgroundColor(0);
                    atVar.addView(view, layoutParams);
                    return;
                }
            } catch (Throwable th) {
                UPLog.e("Pop", "custom view error", th);
            }
        }
        final int a10 = bo.a(8.0f);
        if (Build.VERSION.SDK_INT >= 21) {
            float f10 = (float) a10;
            this.f15405b.setElevation(f10);
            this.f15405b.setTranslationZ(f10);
        }
        this.f15405b.setBackgroundDrawable(new ShapeDrawable(new RectShape() {
            public final void draw(Canvas canvas, Paint paint) {
                paint.setColor(-83886081);
                RectF rect = rect();
                int i10 = a10;
                canvas.drawRoundRect(rect, (float) i10, (float) i10, paint);
            }
        }));
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setPadding(bo.a(12.0f), 0, bo.a(26.0f), 0);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 16;
        linearLayout.setLayoutParams(layoutParams2);
        this.f15405b.addView(linearLayout);
        Bitmap a11 = a(context, apVar.f15401a);
        if (a11 != null && a11.getWidth() > 0 && a11.getHeight() > 0) {
            ImageView imageView = new ImageView(context);
            int a12 = bo.a(48.0f);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(Math.min(a12 * 2, (a11.getWidth() * a12) / a11.getHeight()), a12);
            layoutParams3.gravity = 16;
            layoutParams3.leftMargin = bo.a(4.0f);
            linearLayout.addView(imageView, layoutParams3);
            imageView.setImageDrawable(new au(a11, bo.a(8.0f)));
        }
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.gravity = 16;
        if (a11 != null) {
            layoutParams4.leftMargin = bo.a(10.0f);
        }
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout.addView(linearLayout2, layoutParams4);
        TextView textView = new TextView(context);
        textView.setText(apVar.f15401a.getTitle());
        textView.setSingleLine();
        textView.setMaxLines(1);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setTextColor(-14341836);
        textView.setTextSize(2, 16.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(context);
        textView2.setText(apVar.f15401a.getContent());
        textView2.setTextColor(-14341836);
        textView2.setSingleLine();
        textView2.setMaxLines(1);
        textView2.setTextSize(2, 14.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = bo.a(4.0f);
        linearLayout2.addView(textView2, layoutParams5);
        if (ak.a().c().f15394f) {
            int a13 = bo.a(24.0f);
            FrameLayout frameLayout = new FrameLayout(context);
            ar arVar = new ar(context);
            int a14 = bo.a(3.0f);
            int a15 = bo.a(8.0f);
            frameLayout.setPadding(a14, a15, a15, a14);
            frameLayout.addView(arVar);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(a13, a13);
            layoutParams6.gravity = BadgeDrawable.TOP_END;
            this.f15405b.addView(frameLayout, layoutParams6);
            frameLayout.setOnClickListener(this.f15406c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        r5 = r4.getPackageManager().getPackageInfo(r4.getPackageName(), 0).applicationInfo.icon;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[SYNTHETIC, Splitter:B:16:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005f A[Catch:{ all -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030 A[Catch:{ all -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap a(android.content.Context r4, com.umeng.message.entity.UMessage r5) {
        /*
            r0 = 0
            boolean r1 = r5.isLargeIconFromInternet()     // Catch:{ all -> 0x0068 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = r5.getLargeIconUrl()     // Catch:{ all -> 0x0068 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x0068 }
            if (r2 != 0) goto L_0x002d
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0068 }
            java.io.File r3 = com.umeng.message.proguard.f.g(r4)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = com.umeng.commonsdk.utils.UMUtils.MD5(r1)     // Catch:{ all -> 0x0068 }
            r2.<init>(r3, r1)     // Catch:{ all -> 0x0068 }
            r1 = 1111490560(0x42400000, float:48.0)
            int r3 = com.umeng.message.proguard.bo.a(r1)     // Catch:{ all -> 0x0068 }
            int r1 = com.umeng.message.proguard.bo.a(r1)     // Catch:{ all -> 0x0068 }
            android.graphics.Bitmap r1 = com.umeng.message.proguard.f.a((java.io.File) r2, (int) r3, (int) r1)     // Catch:{ all -> 0x0068 }
            goto L_0x002e
        L_0x002d:
            r1 = r0
        L_0x002e:
            if (r1 != 0) goto L_0x004a
            java.lang.String r5 = r5.getLargeIconDrawableName()     // Catch:{ all -> 0x0068 }
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0068 }
            if (r2 != 0) goto L_0x003f
            int r5 = com.umeng.message.proguard.a.c(r5)     // Catch:{ Exception -> 0x003f }
            goto L_0x0040
        L_0x003f:
            r5 = -1
        L_0x0040:
            if (r5 <= 0) goto L_0x004a
            android.content.res.Resources r1 = r4.getResources()     // Catch:{ all -> 0x0068 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r1, r5)     // Catch:{ all -> 0x0068 }
        L_0x004a:
            if (r1 != 0) goto L_0x0067
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = r4.getPackageName()     // Catch:{ all -> 0x0068 }
            r3 = 0
            android.content.pm.PackageInfo r5 = r5.getPackageInfo(r2, r3)     // Catch:{ all -> 0x0068 }
            android.content.pm.ApplicationInfo r5 = r5.applicationInfo     // Catch:{ all -> 0x0068 }
            int r5 = r5.icon     // Catch:{ all -> 0x0068 }
            if (r5 <= 0) goto L_0x0067
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0068 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeResource(r4, r5)     // Catch:{ all -> 0x0068 }
        L_0x0067:
            return r1
        L_0x0068:
            r4 = move-exception
            java.lang.String r5 = "Pop"
            com.umeng.message.common.UPLog.e((java.lang.String) r5, (java.lang.Throwable) r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.aq.a(android.content.Context, com.umeng.message.entity.UMessage):android.graphics.Bitmap");
    }

    public final ap b() {
        return this.f15404a;
    }

    public final String a() {
        return this.f15404a.f15401a.getMsgId();
    }
}
