package com.hpplay.sdk.source.mirror.yim.render;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import com.hpplay.common.utils.ScreenUtil;
import com.hpplay.sdk.source.log.SourceLog;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f11875a = 1080;

    /* renamed from: b  reason: collision with root package name */
    private static final int f11876b = 1920;

    /* renamed from: c  reason: collision with root package name */
    private static final String f11877c = "DimensUtils";

    /* renamed from: d  reason: collision with root package name */
    private static int f11878d;

    /* renamed from: e  reason: collision with root package name */
    private static int f11879e;

    public static void a(Context context) {
        int[] relScreenSize = ScreenUtil.getRelScreenSize(context);
        f11879e = relScreenSize[0];
        f11878d = relScreenSize[1];
        SourceLog.i(f11877c, " mCurrentWidth  " + f11879e + " mCurrentHeight " + f11878d);
    }

    public static int b(int i10) {
        return (f11878d * i10) / f11876b;
    }

    public static int a(int i10) {
        return (f11879e * i10) / f11875a;
    }

    public static GradientDrawable a(int i10, int i11) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) i11);
        float a10 = (float) a(30);
        gradientDrawable.setCornerRadii(new float[]{a10, a10, a10, a10, 0.0f, 0.0f, 0.0f, 0.0f});
        gradientDrawable.setAlpha(160);
        gradientDrawable.setColor(i10);
        return gradientDrawable;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable a(android.content.Context r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "DimensUtils"
            r1 = 0
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r2.<init>()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            r2.append(r5)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.lang.String r3 = ".png"
            r2.append(r3)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            java.io.InputStream r4 = r4.open(r2)     // Catch:{ Exception -> 0x002f, all -> 0x002d }
            android.graphics.drawable.Drawable r5 = android.graphics.drawable.Drawable.createFromStream(r4, r5)     // Catch:{ Exception -> 0x002b }
            if (r4 == 0) goto L_0x002a
            r4.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x002a:
            return r5
        L_0x002b:
            r5 = move-exception
            goto L_0x0031
        L_0x002d:
            r5 = move-exception
            goto L_0x0041
        L_0x002f:
            r5 = move-exception
            r4 = r1
        L_0x0031:
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r5)     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x003e
            r4.close()     // Catch:{ Exception -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x003e:
            return r1
        L_0x003f:
            r5 = move-exception
            r1 = r4
        L_0x0041:
            if (r1 == 0) goto L_0x004b
            r1.close()     // Catch:{ Exception -> 0x0047 }
            goto L_0x004b
        L_0x0047:
            r4 = move-exception
            com.hpplay.sdk.source.log.SourceLog.w((java.lang.String) r0, (java.lang.Throwable) r4)
        L_0x004b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.mirror.yim.render.a.a(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }
}
