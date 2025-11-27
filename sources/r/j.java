package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import java.io.IOException;
import java.io.InputStream;
import q.d;
import y.f;

public class j extends k {
    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        int i11;
        try {
            d.c[] a10 = bVar.a();
            int length = a10.length;
            int i12 = 0;
            FontFamily.Builder builder = null;
            int i13 = 0;
            while (true) {
                int i14 = 1;
                if (i13 >= length) {
                    break;
                }
                d.c cVar = a10[i13];
                try {
                    Font.Builder weight = new Font.Builder(resources, cVar.b()).setWeight(cVar.e());
                    if (!cVar.f()) {
                        i14 = 0;
                    }
                    Font build = weight.setSlant(i14).setTtcIndex(cVar.c()).setFontVariationSettings(cVar.d()).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i13++;
            }
            if (builder == null) {
                return null;
            }
            if ((i10 & 1) != 0) {
                i11 = 700;
            } else {
                i11 = 400;
            }
            if ((i10 & 2) != 0) {
                i12 = 1;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i11, i12)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x005f, code lost:
        if (r4 != null) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0061, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        if ((r14 & 1) == 0) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0068, code lost:
        r12 = 700;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x006b, code lost:
        r12 = 400;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006f, code lost:
        if ((r14 & 2) == 0) goto L_0x0072;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0071, code lost:
        r2 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0086, code lost:
        return new android.graphics.Typeface.CustomFallbackBuilder(r4.build()).setStyle(new android.graphics.fonts.FontStyle(r12, r2)).build();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface c(android.content.Context r11, android.os.CancellationSignal r12, y.f.b[] r13, int r14) {
        /*
            r10 = this;
            android.content.ContentResolver r11 = r11.getContentResolver()
            r0 = 0
            int r1 = r13.length     // Catch:{ Exception -> 0x0087 }
            r2 = 0
            r4 = r0
            r3 = 0
        L_0x0009:
            r5 = 1
            if (r3 >= r1) goto L_0x005f
            r6 = r13[r3]     // Catch:{ Exception -> 0x0087 }
            android.net.Uri r7 = r6.d()     // Catch:{ IOException -> 0x005c }
            java.lang.String r8 = "r"
            android.os.ParcelFileDescriptor r7 = r11.openFileDescriptor(r7, r8, r12)     // Catch:{ IOException -> 0x005c }
            if (r7 != 0) goto L_0x0020
            if (r7 == 0) goto L_0x005c
        L_0x001c:
            r7.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x005c
        L_0x0020:
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch:{ all -> 0x0052 }
            r8.<init>(r7)     // Catch:{ all -> 0x0052 }
            int r9 = r6.e()     // Catch:{ all -> 0x0052 }
            android.graphics.fonts.Font$Builder r8 = r8.setWeight(r9)     // Catch:{ all -> 0x0052 }
            boolean r9 = r6.f()     // Catch:{ all -> 0x0052 }
            if (r9 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r5 = 0
        L_0x0035:
            android.graphics.fonts.Font$Builder r5 = r8.setSlant(r5)     // Catch:{ all -> 0x0052 }
            int r6 = r6.c()     // Catch:{ all -> 0x0052 }
            android.graphics.fonts.Font$Builder r5 = r5.setTtcIndex(r6)     // Catch:{ all -> 0x0052 }
            android.graphics.fonts.Font r5 = r5.build()     // Catch:{ all -> 0x0052 }
            if (r4 != 0) goto L_0x004e
            android.graphics.fonts.FontFamily$Builder r6 = new android.graphics.fonts.FontFamily$Builder     // Catch:{ all -> 0x0052 }
            r6.<init>(r5)     // Catch:{ all -> 0x0052 }
            r4 = r6
            goto L_0x001c
        L_0x004e:
            r4.addFont(r5)     // Catch:{ all -> 0x0052 }
            goto L_0x001c
        L_0x0052:
            r5 = move-exception
            r7.close()     // Catch:{ all -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r6 = move-exception
            r5.addSuppressed(r6)     // Catch:{ IOException -> 0x005c }
        L_0x005b:
            throw r5     // Catch:{ IOException -> 0x005c }
        L_0x005c:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x005f:
            if (r4 != 0) goto L_0x0062
            return r0
        L_0x0062:
            android.graphics.fonts.FontStyle r11 = new android.graphics.fonts.FontStyle     // Catch:{ Exception -> 0x0087 }
            r12 = r14 & 1
            if (r12 == 0) goto L_0x006b
            r12 = 700(0x2bc, float:9.81E-43)
            goto L_0x006d
        L_0x006b:
            r12 = 400(0x190, float:5.6E-43)
        L_0x006d:
            r13 = r14 & 2
            if (r13 == 0) goto L_0x0072
            r2 = 1
        L_0x0072:
            r11.<init>(r12, r2)     // Catch:{ Exception -> 0x0087 }
            android.graphics.Typeface$CustomFallbackBuilder r12 = new android.graphics.Typeface$CustomFallbackBuilder     // Catch:{ Exception -> 0x0087 }
            android.graphics.fonts.FontFamily r13 = r4.build()     // Catch:{ Exception -> 0x0087 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x0087 }
            android.graphics.Typeface$CustomFallbackBuilder r11 = r12.setStyle(r11)     // Catch:{ Exception -> 0x0087 }
            android.graphics.Typeface r11 = r11.build()     // Catch:{ Exception -> 0x0087 }
            return r11
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: r.j.c(android.content.Context, android.os.CancellationSignal, y.f$b[], int):android.graphics.Typeface");
    }

    public Typeface d(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        try {
            Font build = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    public f.b h(f.b[] bVarArr, int i10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
