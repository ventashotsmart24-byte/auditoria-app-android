package o;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class s {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f8361a;

        /* renamed from: b  reason: collision with root package name */
        public IconCompat f8362b;

        /* renamed from: c  reason: collision with root package name */
        public final j1[] f8363c;

        /* renamed from: d  reason: collision with root package name */
        public final j1[] f8364d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8365e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f8366f;

        /* renamed from: g  reason: collision with root package name */
        public final int f8367g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean f8368h;

        /* renamed from: i  reason: collision with root package name */
        public int f8369i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f8370j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f8371k;

        /* renamed from: o.s$a$a  reason: collision with other inner class name */
        public static final class C0108a {

            /* renamed from: a  reason: collision with root package name */
            public final IconCompat f8372a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f8373b;

            /* renamed from: c  reason: collision with root package name */
            public final PendingIntent f8374c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f8375d;

            /* renamed from: e  reason: collision with root package name */
            public final Bundle f8376e;

            /* renamed from: f  reason: collision with root package name */
            public ArrayList f8377f;

            /* renamed from: g  reason: collision with root package name */
            public int f8378g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f8379h;

            /* renamed from: i  reason: collision with root package name */
            public boolean f8380i;

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public C0108a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i10 != 0 ? IconCompat.e((Resources) null, "", i10) : null, charSequence, pendingIntent, new Bundle(), (j1[]) null, true, 0, true, false);
            }

            /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object[]] */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public o.s.a a() {
                /*
                    r15 = this;
                    r15.b()
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    java.util.ArrayList r1 = new java.util.ArrayList
                    r1.<init>()
                    java.util.ArrayList r2 = r15.f8377f
                    r3 = 0
                    if (r2 == 0) goto L_0x0025
                    java.util.Iterator r2 = r2.iterator()
                    boolean r4 = r2.hasNext()
                    if (r4 != 0) goto L_0x001d
                    goto L_0x0025
                L_0x001d:
                    java.lang.Object r0 = r2.next()
                    androidx.appcompat.app.m.a(r0)
                    throw r3
                L_0x0025:
                    boolean r2 = r0.isEmpty()
                    if (r2 == 0) goto L_0x002d
                    r10 = r3
                    goto L_0x003a
                L_0x002d:
                    int r2 = r0.size()
                    o.j1[] r2 = new o.j1[r2]
                    java.lang.Object[] r0 = r0.toArray(r2)
                    o.j1[] r0 = (o.j1[]) r0
                    r10 = r0
                L_0x003a:
                    boolean r0 = r1.isEmpty()
                    if (r0 == 0) goto L_0x0041
                    goto L_0x004e
                L_0x0041:
                    int r0 = r1.size()
                    o.j1[] r0 = new o.j1[r0]
                    java.lang.Object[] r0 = r1.toArray(r0)
                    r3 = r0
                    o.j1[] r3 = (o.j1[]) r3
                L_0x004e:
                    r9 = r3
                    o.s$a r0 = new o.s$a
                    androidx.core.graphics.drawable.IconCompat r5 = r15.f8372a
                    java.lang.CharSequence r6 = r15.f8373b
                    android.app.PendingIntent r7 = r15.f8374c
                    android.os.Bundle r8 = r15.f8376e
                    boolean r11 = r15.f8375d
                    int r12 = r15.f8378g
                    boolean r13 = r15.f8379h
                    boolean r14 = r15.f8380i
                    r4 = r0
                    r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: o.s.a.C0108a.a():o.s$a");
            }

            public final void b() {
                if (this.f8380i && this.f8374c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C0108a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, j1[] j1VarArr, boolean z10, int i10, boolean z11, boolean z12) {
                ArrayList arrayList;
                this.f8375d = true;
                this.f8379h = true;
                this.f8372a = iconCompat;
                this.f8373b = e.h(charSequence);
                this.f8374c = pendingIntent;
                this.f8376e = bundle;
                if (j1VarArr == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList(Arrays.asList(j1VarArr));
                }
                this.f8377f = arrayList;
                this.f8375d = z10;
                this.f8378g = i10;
                this.f8379h = z11;
                this.f8380i = z12;
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.e((Resources) null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f8371k;
        }

        public boolean b() {
            return this.f8365e;
        }

        public j1[] c() {
            return this.f8364d;
        }

        public Bundle d() {
            return this.f8361a;
        }

        public int e() {
            return this.f8369i;
        }

        public IconCompat f() {
            int i10;
            if (this.f8362b == null && (i10 = this.f8369i) != 0) {
                this.f8362b = IconCompat.e((Resources) null, "", i10);
            }
            return this.f8362b;
        }

        public j1[] g() {
            return this.f8363c;
        }

        public int h() {
            return this.f8367g;
        }

        public boolean i() {
            return this.f8366f;
        }

        public CharSequence j() {
            return this.f8370j;
        }

        public boolean k() {
            return this.f8368h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (j1[]) null, (j1[]) null, true, 0, true, false);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, j1[] j1VarArr, j1[] j1VarArr2, boolean z10, int i10, boolean z11, boolean z12) {
            this.f8366f = true;
            this.f8362b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f8369i = iconCompat.g();
            }
            this.f8370j = e.h(charSequence);
            this.f8371k = pendingIntent;
            this.f8361a = bundle == null ? new Bundle() : bundle;
            this.f8363c = j1VarArr;
            this.f8364d = j1VarArr2;
            this.f8365e = z10;
            this.f8367g = i10;
            this.f8366f = z11;
            this.f8368h = z12;
        }
    }

    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        public Bitmap f8381e;

        /* renamed from: f  reason: collision with root package name */
        public IconCompat f8382f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f8383g;

        public static class a {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: o.s$b$b  reason: collision with other inner class name */
        public static class C0109b {
            public static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        public void b(r rVar) {
            int i10 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(rVar.a()).setBigContentTitle(this.f8412b).bigPicture(this.f8381e);
            if (this.f8383g) {
                IconCompat iconCompat = this.f8382f;
                Context context = null;
                if (iconCompat == null) {
                    a.a(bigPicture, (Bitmap) null);
                } else if (i10 >= 23) {
                    if (rVar instanceof e1) {
                        context = ((e1) rVar).f();
                    }
                    C0109b.a(bigPicture, this.f8382f.v(context));
                } else if (iconCompat.l() == 1) {
                    a.a(bigPicture, this.f8382f.f());
                } else {
                    a.a(bigPicture, (Bitmap) null);
                }
            }
            if (this.f8414d) {
                a.b(bigPicture, this.f8413c);
            }
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b m(Bitmap bitmap) {
            IconCompat iconCompat;
            if (bitmap == null) {
                iconCompat = null;
            } else {
                iconCompat = IconCompat.c(bitmap);
            }
            this.f8382f = iconCompat;
            this.f8383g = true;
            return this;
        }

        public b n(Bitmap bitmap) {
            this.f8381e = bitmap;
            return this;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f8384e;

        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f8384e);
            }
        }

        public void b(r rVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(rVar.a()).setBigContentTitle(this.f8412b).bigText(this.f8384e);
            if (this.f8414d) {
                bigText.setSummaryText(this.f8413c);
            }
        }

        public String h() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c m(CharSequence charSequence) {
            this.f8384e = e.h(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        public e f8411a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f8412b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f8413c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f8414d = false;

        public void a(Bundle bundle) {
            if (this.f8414d) {
                bundle.putCharSequence("android.summaryText", this.f8413c);
            }
            CharSequence charSequence = this.f8412b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String h10 = h();
            if (h10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", h10);
            }
        }

        public abstract void b(r rVar);

        /* JADX WARNING: Removed duplicated region for block: B:54:0x0158  */
        /* JADX WARNING: Removed duplicated region for block: B:60:0x0175  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x0199  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01dd  */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x01e2  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x01e4  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x01ee  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.widget.RemoteViews c(boolean r13, int r14, boolean r15) {
            /*
                r12 = this;
                o.s$e r0 = r12.f8411a
                android.content.Context r0 = r0.f8385a
                android.content.res.Resources r0 = r0.getResources()
                android.widget.RemoteViews r7 = new android.widget.RemoteViews
                o.s$e r1 = r12.f8411a
                android.content.Context r1 = r1.f8385a
                java.lang.String r1 = r1.getPackageName()
                r7.<init>(r1, r14)
                o.s$e r14 = r12.f8411a
                int r14 = r14.f()
                r8 = 1
                r9 = 0
                r1 = -1
                if (r14 >= r1) goto L_0x0022
                r14 = 1
                goto L_0x0023
            L_0x0022:
                r14 = 0
            L_0x0023:
                int r10 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r10 >= r2) goto L_0x004a
                java.lang.String r3 = "setBackgroundResource"
                if (r14 == 0) goto L_0x003c
                int r14 = androidx.core.R$id.notification_background
                int r4 = androidx.core.R$drawable.notification_bg_low
                r7.setInt(r14, r3, r4)
                int r14 = androidx.core.R$id.icon
                int r4 = androidx.core.R$drawable.notification_template_icon_low_bg
                r7.setInt(r14, r3, r4)
                goto L_0x004a
            L_0x003c:
                int r14 = androidx.core.R$id.notification_background
                int r4 = androidx.core.R$drawable.notification_bg
                r7.setInt(r14, r3, r4)
                int r14 = androidx.core.R$id.icon
                int r4 = androidx.core.R$drawable.notification_template_icon_bg
                r7.setInt(r14, r3, r4)
            L_0x004a:
                o.s$e r14 = r12.f8411a
                android.graphics.Bitmap r3 = r14.f8394j
                if (r3 == 0) goto L_0x00a1
                int r14 = androidx.core.R$id.icon
                r7.setViewVisibility(r14, r9)
                o.s$e r3 = r12.f8411a
                android.graphics.Bitmap r3 = r3.f8394j
                r7.setImageViewBitmap(r14, r3)
                if (r13 == 0) goto L_0x00e2
                o.s$e r13 = r12.f8411a
                android.app.Notification r13 = r13.R
                int r13 = r13.icon
                if (r13 == 0) goto L_0x00e2
                int r13 = androidx.core.R$dimen.notification_right_icon_size
                int r13 = r0.getDimensionPixelSize(r13)
                int r14 = androidx.core.R$dimen.notification_small_icon_background_padding
                int r14 = r0.getDimensionPixelSize(r14)
                int r14 = r14 * 2
                int r14 = r13 - r14
                if (r10 < r2) goto L_0x008c
                o.s$e r1 = r12.f8411a
                android.app.Notification r3 = r1.R
                int r3 = r3.icon
                int r1 = r1.d()
                android.graphics.Bitmap r13 = r12.g(r3, r13, r14, r1)
                int r14 = androidx.core.R$id.right_icon
                r7.setImageViewBitmap(r14, r13)
                goto L_0x009b
            L_0x008c:
                int r13 = androidx.core.R$id.right_icon
                o.s$e r14 = r12.f8411a
                android.app.Notification r14 = r14.R
                int r14 = r14.icon
                android.graphics.Bitmap r14 = r12.d(r14, r1)
                r7.setImageViewBitmap(r13, r14)
            L_0x009b:
                int r13 = androidx.core.R$id.right_icon
                r7.setViewVisibility(r13, r9)
                goto L_0x00e2
            L_0x00a1:
                if (r13 == 0) goto L_0x00e2
                android.app.Notification r13 = r14.R
                int r13 = r13.icon
                if (r13 == 0) goto L_0x00e2
                int r13 = androidx.core.R$id.icon
                r7.setViewVisibility(r13, r9)
                if (r10 < r2) goto L_0x00d5
                int r14 = androidx.core.R$dimen.notification_large_icon_width
                int r14 = r0.getDimensionPixelSize(r14)
                int r1 = androidx.core.R$dimen.notification_big_circle_margin
                int r1 = r0.getDimensionPixelSize(r1)
                int r14 = r14 - r1
                int r1 = androidx.core.R$dimen.notification_small_icon_size_as_large
                int r1 = r0.getDimensionPixelSize(r1)
                o.s$e r3 = r12.f8411a
                android.app.Notification r4 = r3.R
                int r4 = r4.icon
                int r3 = r3.d()
                android.graphics.Bitmap r14 = r12.g(r4, r14, r1, r3)
                r7.setImageViewBitmap(r13, r14)
                goto L_0x00e2
            L_0x00d5:
                o.s$e r14 = r12.f8411a
                android.app.Notification r14 = r14.R
                int r14 = r14.icon
                android.graphics.Bitmap r14 = r12.d(r14, r1)
                r7.setImageViewBitmap(r13, r14)
            L_0x00e2:
                o.s$e r13 = r12.f8411a
                java.lang.CharSequence r13 = r13.f8389e
                if (r13 == 0) goto L_0x00ed
                int r14 = androidx.core.R$id.title
                r7.setTextViewText(r14, r13)
            L_0x00ed:
                o.s$e r13 = r12.f8411a
                java.lang.CharSequence r13 = r13.f8390f
                if (r13 == 0) goto L_0x00fa
                int r14 = androidx.core.R$id.text
                r7.setTextViewText(r14, r13)
                r13 = 1
                goto L_0x00fb
            L_0x00fa:
                r13 = 0
            L_0x00fb:
                if (r10 >= r2) goto L_0x0105
                o.s$e r14 = r12.f8411a
                android.graphics.Bitmap r14 = r14.f8394j
                if (r14 == 0) goto L_0x0105
                r14 = 1
                goto L_0x0106
            L_0x0105:
                r14 = 0
            L_0x0106:
                o.s$e r1 = r12.f8411a
                java.lang.CharSequence r2 = r1.f8395k
                r11 = 8
                if (r2 == 0) goto L_0x0119
                int r13 = androidx.core.R$id.info
                r7.setTextViewText(r13, r2)
                r7.setViewVisibility(r13, r9)
            L_0x0116:
                r13 = 1
                r14 = 1
                goto L_0x0152
            L_0x0119:
                int r1 = r1.f8396l
                if (r1 <= 0) goto L_0x014d
                int r13 = androidx.core.R$integer.status_bar_notification_info_maxnum
                int r13 = r0.getInteger(r13)
                o.s$e r14 = r12.f8411a
                int r14 = r14.f8396l
                if (r14 <= r13) goto L_0x0135
                int r13 = androidx.core.R$id.info
                int r14 = androidx.core.R$string.status_bar_notification_info_overflow
                java.lang.String r14 = r0.getString(r14)
                r7.setTextViewText(r13, r14)
                goto L_0x0147
            L_0x0135:
                java.text.NumberFormat r13 = java.text.NumberFormat.getIntegerInstance()
                int r14 = androidx.core.R$id.info
                o.s$e r1 = r12.f8411a
                int r1 = r1.f8396l
                long r1 = (long) r1
                java.lang.String r13 = r13.format(r1)
                r7.setTextViewText(r14, r13)
            L_0x0147:
                int r13 = androidx.core.R$id.info
                r7.setViewVisibility(r13, r9)
                goto L_0x0116
            L_0x014d:
                int r1 = androidx.core.R$id.info
                r7.setViewVisibility(r1, r11)
            L_0x0152:
                o.s$e r1 = r12.f8411a
                java.lang.CharSequence r1 = r1.f8402r
                if (r1 == 0) goto L_0x0172
                int r2 = androidx.core.R$id.text
                r7.setTextViewText(r2, r1)
                o.s$e r1 = r12.f8411a
                java.lang.CharSequence r1 = r1.f8390f
                if (r1 == 0) goto L_0x016d
                int r2 = androidx.core.R$id.text2
                r7.setTextViewText(r2, r1)
                r7.setViewVisibility(r2, r9)
                r1 = 1
                goto L_0x0173
            L_0x016d:
                int r1 = androidx.core.R$id.text2
                r7.setViewVisibility(r1, r11)
            L_0x0172:
                r1 = 0
            L_0x0173:
                if (r1 == 0) goto L_0x018d
                if (r15 == 0) goto L_0x0183
                int r15 = androidx.core.R$dimen.notification_subtext_size
                int r15 = r0.getDimensionPixelSize(r15)
                float r15 = (float) r15
                int r0 = androidx.core.R$id.text
                r7.setTextViewTextSize(r0, r9, r15)
            L_0x0183:
                int r2 = androidx.core.R$id.line1
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r1 = r7
                r1.setViewPadding(r2, r3, r4, r5, r6)
            L_0x018d:
                o.s$e r15 = r12.f8411a
                long r0 = r15.g()
                r2 = 0
                int r15 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r15 == 0) goto L_0x01dd
                o.s$e r14 = r12.f8411a
                boolean r14 = r14.f8399o
                if (r14 == 0) goto L_0x01cc
                int r14 = androidx.core.R$id.chronometer
                r7.setViewVisibility(r14, r9)
                o.s$e r15 = r12.f8411a
                long r0 = r15.g()
                long r2 = android.os.SystemClock.elapsedRealtime()
                long r4 = java.lang.System.currentTimeMillis()
                long r2 = r2 - r4
                long r0 = r0 + r2
                java.lang.String r15 = "setBase"
                r7.setLong(r14, r15, r0)
                java.lang.String r15 = "setStarted"
                r7.setBoolean(r14, r15, r8)
                o.s$e r15 = r12.f8411a
                boolean r15 = r15.f8400p
                if (r15 == 0) goto L_0x01de
                r0 = 24
                if (r10 < r0) goto L_0x01de
                r7.setChronometerCountDown(r14, r15)
                goto L_0x01de
            L_0x01cc:
                int r14 = androidx.core.R$id.time
                r7.setViewVisibility(r14, r9)
                o.s$e r15 = r12.f8411a
                long r0 = r15.g()
                java.lang.String r15 = "setTime"
                r7.setLong(r14, r15, r0)
                goto L_0x01de
            L_0x01dd:
                r8 = r14
            L_0x01de:
                int r14 = androidx.core.R$id.right_side
                if (r8 == 0) goto L_0x01e4
                r15 = 0
                goto L_0x01e6
            L_0x01e4:
                r15 = 8
            L_0x01e6:
                r7.setViewVisibility(r14, r15)
                int r14 = androidx.core.R$id.line3
                if (r13 == 0) goto L_0x01ee
                goto L_0x01f0
            L_0x01ee:
                r9 = 8
            L_0x01f0:
                r7.setViewVisibility(r14, r9)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: o.s.f.c(boolean, int, boolean):android.widget.RemoteViews");
        }

        public Bitmap d(int i10, int i11) {
            return e(i10, i11, 0);
        }

        public final Bitmap e(int i10, int i11, int i12) {
            return f(IconCompat.d(this.f8411a.f8385a, i10), i11, i12);
        }

        public final Bitmap f(IconCompat iconCompat, int i10, int i11) {
            int i12;
            Drawable q10 = iconCompat.q(this.f8411a.f8385a);
            if (i11 == 0) {
                i12 = q10.getIntrinsicWidth();
            } else {
                i12 = i11;
            }
            if (i11 == 0) {
                i11 = q10.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(i12, i11, Bitmap.Config.ARGB_8888);
            q10.setBounds(0, 0, i12, i11);
            if (i10 != 0) {
                q10.mutate().setColorFilter(new PorterDuffColorFilter(i10, PorterDuff.Mode.SRC_IN));
            }
            q10.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        public final Bitmap g(int i10, int i11, int i12, int i13) {
            int i14 = R$drawable.notification_icon_background;
            if (i13 == 0) {
                i13 = 0;
            }
            Bitmap e10 = e(i14, i13, i11);
            Canvas canvas = new Canvas(e10);
            Drawable mutate = this.f8411a.f8385a.getResources().getDrawable(i10).mutate();
            mutate.setFilterBitmap(true);
            int i15 = (i11 - i12) / 2;
            int i16 = i12 + i15;
            mutate.setBounds(i15, i15, i16, i16);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return e10;
        }

        public String h() {
            return null;
        }

        public RemoteViews i(r rVar) {
            return null;
        }

        public RemoteViews j(r rVar) {
            return null;
        }

        public RemoteViews k(r rVar) {
            return null;
        }

        public void l(e eVar) {
            if (this.f8411a != eVar) {
                this.f8411a = eVar;
                if (eVar != null) {
                    eVar.D(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static class e {
        public boolean A;
        public boolean B;
        public boolean C;
        public String D;
        public Bundle E;
        public int F;
        public int G;
        public Notification H;
        public RemoteViews I;
        public RemoteViews J;
        public RemoteViews K;
        public String L;
        public int M;
        public String N;
        public long O;
        public int P;
        public boolean Q;
        public Notification R;
        public boolean S;
        public Icon T;
        public ArrayList U;

        /* renamed from: a  reason: collision with root package name */
        public Context f8385a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList f8386b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList f8387c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList f8388d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f8389e;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f8390f;

        /* renamed from: g  reason: collision with root package name */
        public PendingIntent f8391g;

        /* renamed from: h  reason: collision with root package name */
        public PendingIntent f8392h;

        /* renamed from: i  reason: collision with root package name */
        public RemoteViews f8393i;

        /* renamed from: j  reason: collision with root package name */
        public Bitmap f8394j;

        /* renamed from: k  reason: collision with root package name */
        public CharSequence f8395k;

        /* renamed from: l  reason: collision with root package name */
        public int f8396l;

        /* renamed from: m  reason: collision with root package name */
        public int f8397m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f8398n;

        /* renamed from: o  reason: collision with root package name */
        public boolean f8399o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f8400p;

        /* renamed from: q  reason: collision with root package name */
        public f f8401q;

        /* renamed from: r  reason: collision with root package name */
        public CharSequence f8402r;

        /* renamed from: s  reason: collision with root package name */
        public CharSequence f8403s;

        /* renamed from: t  reason: collision with root package name */
        public CharSequence[] f8404t;

        /* renamed from: u  reason: collision with root package name */
        public int f8405u;

        /* renamed from: v  reason: collision with root package name */
        public int f8406v;

        /* renamed from: w  reason: collision with root package name */
        public boolean f8407w;

        /* renamed from: x  reason: collision with root package name */
        public String f8408x;

        /* renamed from: y  reason: collision with root package name */
        public boolean f8409y;

        /* renamed from: z  reason: collision with root package name */
        public String f8410z;

        public e(Context context, String str) {
            this.f8386b = new ArrayList();
            this.f8387c = new ArrayList();
            this.f8388d = new ArrayList();
            this.f8398n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f8385a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f8397m = 0;
            this.U = new ArrayList();
            this.Q = true;
        }

        public static CharSequence h(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        public e A(boolean z10) {
            this.f8398n = z10;
            return this;
        }

        public e B(int i10) {
            this.R.icon = i10;
            return this;
        }

        public e C(Uri uri) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        public e D(f fVar) {
            if (this.f8401q != fVar) {
                this.f8401q = fVar;
                if (fVar != null) {
                    fVar.l(this);
                }
            }
            return this;
        }

        public e E(CharSequence charSequence) {
            this.R.tickerText = h(charSequence);
            return this;
        }

        public e F(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        public e G(int i10) {
            this.G = i10;
            return this;
        }

        public e H(long j10) {
            this.R.when = j10;
            return this;
        }

        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f8386b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f8386b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new e1(this).c();
        }

        public int d() {
            return this.F;
        }

        public Bundle e() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public int f() {
            return this.f8397m;
        }

        public long g() {
            if (this.f8398n) {
                return this.R.when;
            }
            return 0;
        }

        public final Bitmap i(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f8385a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d10 = (double) dimensionPixelSize;
            double max = (double) Math.max(1, bitmap.getWidth());
            Double.isNaN(d10);
            Double.isNaN(max);
            double d11 = d10 / max;
            double d12 = (double) dimensionPixelSize2;
            double max2 = (double) Math.max(1, bitmap.getHeight());
            Double.isNaN(d12);
            Double.isNaN(max2);
            double min = Math.min(d11, d12 / max2);
            double width = (double) bitmap.getWidth();
            Double.isNaN(width);
            double height = (double) bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(width * min), (int) Math.ceil(height * min), true);
        }

        public e j(boolean z10) {
            t(16, z10);
            return this;
        }

        public e k(String str) {
            this.D = str;
            return this;
        }

        public e l(String str) {
            this.L = str;
            return this;
        }

        public e m(int i10) {
            this.F = i10;
            return this;
        }

        public e n(PendingIntent pendingIntent) {
            this.f8391g = pendingIntent;
            return this;
        }

        public e o(CharSequence charSequence) {
            this.f8390f = h(charSequence);
            return this;
        }

        public e p(CharSequence charSequence) {
            this.f8389e = h(charSequence);
            return this;
        }

        public e q(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        public e r(int i10) {
            Notification notification = this.R;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e s(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public final void t(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.R;
                notification.flags = i10 | notification.flags;
                return;
            }
            Notification notification2 = this.R;
            notification2.flags = (i10 ^ -1) & notification2.flags;
        }

        public e u(Bitmap bitmap) {
            this.f8394j = i(bitmap);
            return this;
        }

        public e v(int i10, int i11, int i12) {
            int i13;
            Notification notification = this.R;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            if (i11 == 0 || i12 == 0) {
                i13 = 0;
            } else {
                i13 = 1;
            }
            notification.flags = i13 | (notification.flags & -2);
            return this;
        }

        public e w(boolean z10) {
            this.A = z10;
            return this;
        }

        public e x(int i10) {
            this.f8396l = i10;
            return this;
        }

        public e y(boolean z10) {
            t(2, z10);
            return this;
        }

        public e z(int i10) {
            this.f8397m = i10;
            return this;
        }

        public e(Context context) {
            this(context, (String) null);
        }
    }
}
