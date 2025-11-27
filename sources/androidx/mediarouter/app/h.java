package androidx.mediarouter.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n0.p0;
import n0.s0;
import n0.t0;

public class h extends androidx.appcompat.app.j {
    public static final boolean O = Log.isLoggable("MediaRouteCtrlDialog", 3);
    public View A;
    public ImageView B;
    public TextView C;
    public TextView D;
    public String E;
    public MediaControllerCompat F;
    public e G;
    public MediaDescriptionCompat H;
    public d I;
    public Bitmap J;
    public Uri K;
    public boolean L;
    public Bitmap M;
    public int N;

    /* renamed from: a  reason: collision with root package name */
    public final t0 f2619a;

    /* renamed from: b  reason: collision with root package name */
    public final g f2620b;

    /* renamed from: c  reason: collision with root package name */
    public s0 f2621c;

    /* renamed from: d  reason: collision with root package name */
    public t0.i f2622d;

    /* renamed from: e  reason: collision with root package name */
    public final List f2623e;

    /* renamed from: f  reason: collision with root package name */
    public final List f2624f;

    /* renamed from: g  reason: collision with root package name */
    public final List f2625g;

    /* renamed from: h  reason: collision with root package name */
    public final List f2626h;

    /* renamed from: i  reason: collision with root package name */
    public Context f2627i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2628j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2629k;

    /* renamed from: l  reason: collision with root package name */
    public long f2630l;

    /* renamed from: m  reason: collision with root package name */
    public final Handler f2631m;

    /* renamed from: n  reason: collision with root package name */
    public RecyclerView f2632n;

    /* renamed from: o  reason: collision with root package name */
    public C0038h f2633o;

    /* renamed from: p  reason: collision with root package name */
    public j f2634p;

    /* renamed from: q  reason: collision with root package name */
    public Map f2635q;

    /* renamed from: r  reason: collision with root package name */
    public t0.i f2636r;

    /* renamed from: s  reason: collision with root package name */
    public Map f2637s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f2638t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f2639u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2640v;

    /* renamed from: w  reason: collision with root package name */
    public boolean f2641w;

    /* renamed from: x  reason: collision with root package name */
    public ImageButton f2642x;

    /* renamed from: y  reason: collision with root package name */
    public Button f2643y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f2644z;

    public class a extends Handler {
        public a() {
        }

        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1) {
                h.this.o();
            } else if (i10 == 2) {
                h hVar = h.this;
                if (hVar.f2636r != null) {
                    hVar.f2636r = null;
                    hVar.p();
                }
            }
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            h.this.dismiss();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            if (h.this.f2622d.C()) {
                h.this.f2619a.x(2);
            }
            h.this.dismiss();
        }
    }

    public class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f2648a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f2649b;

        /* renamed from: c  reason: collision with root package name */
        public int f2650c;

        public d() {
            Bitmap bitmap;
            MediaDescriptionCompat mediaDescriptionCompat = h.this.H;
            Uri uri = null;
            if (mediaDescriptionCompat == null) {
                bitmap = null;
            } else {
                bitmap = mediaDescriptionCompat.b();
            }
            this.f2648a = h.d(bitmap) ? null : bitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = h.this.H;
            this.f2649b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : uri;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:19|20|21|22|(3:24|(2:26|27)|28)|30|31|(3:33|34|35)(5:37|38|39|40|42)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0096 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[Catch:{ IOException -> 0x0096 }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00a5 A[SYNTHETIC, Splitter:B:53:0x00a5] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00af A[SYNTHETIC, Splitter:B:59:0x00af] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                java.lang.String r8 = "Unable to open: "
                android.graphics.Bitmap r0 = r7.f2648a
                r1 = 0
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x000b
                goto L_0x00b4
            L_0x000b:
                android.net.Uri r0 = r7.f2649b
                if (r0 == 0) goto L_0x00b3
                java.io.InputStream r0 = r7.e(r0)     // Catch:{ IOException -> 0x0095, all -> 0x0093 }
                if (r0 != 0) goto L_0x0028
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0096 }
                r4.<init>()     // Catch:{ IOException -> 0x0096 }
                r4.append(r8)     // Catch:{ IOException -> 0x0096 }
                android.net.Uri r5 = r7.f2649b     // Catch:{ IOException -> 0x0096 }
                r4.append(r5)     // Catch:{ IOException -> 0x0096 }
                if (r0 == 0) goto L_0x0027
                r0.close()     // Catch:{ IOException -> 0x0027 }
            L_0x0027:
                return r3
            L_0x0028:
                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0096 }
                r4.<init>()     // Catch:{ IOException -> 0x0096 }
                r4.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x0096 }
                android.graphics.BitmapFactory.decodeStream(r0, r3, r4)     // Catch:{ IOException -> 0x0096 }
                int r5 = r4.outWidth     // Catch:{ IOException -> 0x0096 }
                if (r5 == 0) goto L_0x008f
                int r5 = r4.outHeight     // Catch:{ IOException -> 0x0096 }
                if (r5 != 0) goto L_0x003b
                goto L_0x008f
            L_0x003b:
                r0.reset()     // Catch:{ IOException -> 0x003f }
                goto L_0x005d
            L_0x003f:
                r0.close()     // Catch:{ IOException -> 0x0096 }
                android.net.Uri r5 = r7.f2649b     // Catch:{ IOException -> 0x0096 }
                java.io.InputStream r0 = r7.e(r5)     // Catch:{ IOException -> 0x0096 }
                if (r0 != 0) goto L_0x005d
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0096 }
                r4.<init>()     // Catch:{ IOException -> 0x0096 }
                r4.append(r8)     // Catch:{ IOException -> 0x0096 }
                android.net.Uri r5 = r7.f2649b     // Catch:{ IOException -> 0x0096 }
                r4.append(r5)     // Catch:{ IOException -> 0x0096 }
                if (r0 == 0) goto L_0x005c
                r0.close()     // Catch:{ IOException -> 0x005c }
            L_0x005c:
                return r3
            L_0x005d:
                r4.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x0096 }
                androidx.mediarouter.app.h r5 = androidx.mediarouter.app.h.this     // Catch:{ IOException -> 0x0096 }
                android.content.Context r5 = r5.f2627i     // Catch:{ IOException -> 0x0096 }
                android.content.res.Resources r5 = r5.getResources()     // Catch:{ IOException -> 0x0096 }
                int r6 = androidx.mediarouter.R$dimen.mr_cast_meta_art_size     // Catch:{ IOException -> 0x0096 }
                int r5 = r5.getDimensionPixelSize(r6)     // Catch:{ IOException -> 0x0096 }
                int r6 = r4.outHeight     // Catch:{ IOException -> 0x0096 }
                int r6 = r6 / r5
                int r5 = java.lang.Integer.highestOneBit(r6)     // Catch:{ IOException -> 0x0096 }
                int r5 = java.lang.Math.max(r2, r5)     // Catch:{ IOException -> 0x0096 }
                r4.inSampleSize = r5     // Catch:{ IOException -> 0x0096 }
                boolean r5 = r7.isCancelled()     // Catch:{ IOException -> 0x0096 }
                if (r5 == 0) goto L_0x0084
                r0.close()     // Catch:{ IOException -> 0x0083 }
            L_0x0083:
                return r3
            L_0x0084:
                android.graphics.Bitmap r8 = android.graphics.BitmapFactory.decodeStream(r0, r3, r4)     // Catch:{ IOException -> 0x0096 }
                r0.close()     // Catch:{ IOException -> 0x008c }
                goto L_0x008d
            L_0x008c:
            L_0x008d:
                r0 = r8
                goto L_0x00b4
            L_0x008f:
                r0.close()     // Catch:{ IOException -> 0x0092 }
            L_0x0092:
                return r3
            L_0x0093:
                r8 = move-exception
                goto L_0x00ad
            L_0x0095:
                r0 = r3
            L_0x0096:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ab }
                r4.<init>()     // Catch:{ all -> 0x00ab }
                r4.append(r8)     // Catch:{ all -> 0x00ab }
                android.net.Uri r8 = r7.f2649b     // Catch:{ all -> 0x00ab }
                r4.append(r8)     // Catch:{ all -> 0x00ab }
                if (r0 == 0) goto L_0x00b3
                r0.close()     // Catch:{ IOException -> 0x00a9 }
                goto L_0x00b3
            L_0x00a9:
                goto L_0x00b3
            L_0x00ab:
                r8 = move-exception
                r3 = r0
            L_0x00ad:
                if (r3 == 0) goto L_0x00b2
                r3.close()     // Catch:{ IOException -> 0x00b2 }
            L_0x00b2:
                throw r8
            L_0x00b3:
                r0 = r3
            L_0x00b4:
                boolean r8 = androidx.mediarouter.app.h.d(r0)
                if (r8 == 0) goto L_0x00c8
                java.lang.StringBuilder r8 = new java.lang.StringBuilder
                r8.<init>()
                java.lang.String r1 = "Can't use recycled bitmap: "
                r8.append(r1)
                r8.append(r0)
                return r3
            L_0x00c8:
                if (r0 == 0) goto L_0x00fc
                int r8 = r0.getWidth()
                int r3 = r0.getHeight()
                if (r8 >= r3) goto L_0x00fc
                p0.b$b r8 = new p0.b$b
                r8.<init>(r0)
                p0.b$b r8 = r8.c(r2)
                p0.b r8 = r8.a()
                java.util.List r2 = r8.f()
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x00ec
                goto L_0x00fa
            L_0x00ec:
                java.util.List r8 = r8.f()
                java.lang.Object r8 = r8.get(r1)
                p0.b$d r8 = (p0.b.d) r8
                int r1 = r8.e()
            L_0x00fa:
                r7.f2650c = r1
            L_0x00fc:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.d.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.f2648a;
        }

        public Uri c() {
            return this.f2649b;
        }

        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            h hVar = h.this;
            hVar.I = null;
            if (!a0.c.a(hVar.J, this.f2648a) || !a0.c.a(h.this.K, this.f2649b)) {
                h hVar2 = h.this;
                hVar2.J = this.f2648a;
                hVar2.M = bitmap;
                hVar2.K = this.f2649b;
                hVar2.N = this.f2650c;
                hVar2.L = true;
                hVar2.m();
            }
        }

        public final InputStream e(Uri uri) {
            InputStream inputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStream = h.this.f2627i.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                openConnection.setConnectTimeout(30000);
                openConnection.setReadTimeout(30000);
                inputStream = openConnection.getInputStream();
            }
            if (inputStream == null) {
                return null;
            }
            return new BufferedInputStream(inputStream);
        }

        public void onPreExecute() {
            h.this.b();
        }
    }

    public final class e extends MediaControllerCompat.a {
        public e() {
        }

        public void d(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat mediaDescriptionCompat;
            h hVar = h.this;
            if (mediaMetadataCompat == null) {
                mediaDescriptionCompat = null;
            } else {
                mediaDescriptionCompat = mediaMetadataCompat.e();
            }
            hVar.H = mediaDescriptionCompat;
            h.this.g();
            h.this.m();
        }

        public void i() {
            h hVar = h.this;
            MediaControllerCompat mediaControllerCompat = hVar.F;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.g(hVar.G);
                h.this.F = null;
            }
        }
    }

    public abstract class f extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public t0.i f2653a;

        /* renamed from: b  reason: collision with root package name */
        public final ImageButton f2654b;

        /* renamed from: c  reason: collision with root package name */
        public final MediaRouteVolumeSlider f2655c;

        public class a implements View.OnClickListener {
            public a() {
            }

            public void onClick(View view) {
                int i10;
                h hVar = h.this;
                if (hVar.f2636r != null) {
                    hVar.f2631m.removeMessages(2);
                }
                f fVar = f.this;
                h.this.f2636r = fVar.f2653a;
                boolean z10 = !view.isActivated();
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = f.this.c();
                }
                f.this.d(z10);
                f.this.f2655c.setProgress(i10);
                f.this.f2653a.G(i10);
                h.this.f2631m.sendEmptyMessageDelayed(2, 500);
            }
        }

        public f(View view, ImageButton imageButton, MediaRouteVolumeSlider mediaRouteVolumeSlider) {
            super(view);
            this.f2654b = imageButton;
            this.f2655c = mediaRouteVolumeSlider;
            imageButton.setImageDrawable(i.k(h.this.f2627i));
            i.v(h.this.f2627i, mediaRouteVolumeSlider);
        }

        public void b(t0.i iVar) {
            boolean z10;
            this.f2653a = iVar;
            int s10 = iVar.s();
            if (s10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f2654b.setActivated(z10);
            this.f2654b.setOnClickListener(new a());
            this.f2655c.setTag(this.f2653a);
            this.f2655c.setMax(iVar.u());
            this.f2655c.setProgress(s10);
            this.f2655c.setOnSeekBarChangeListener(h.this.f2634p);
        }

        public int c() {
            Integer num = (Integer) h.this.f2637s.get(this.f2653a.k());
            if (num == null) {
                return 1;
            }
            return Math.max(1, num.intValue());
        }

        public void d(boolean z10) {
            if (this.f2654b.isActivated() != z10) {
                this.f2654b.setActivated(z10);
                if (z10) {
                    h.this.f2637s.put(this.f2653a.k(), Integer.valueOf(this.f2655c.getProgress()));
                } else {
                    h.this.f2637s.remove(this.f2653a.k());
                }
            }
        }

        public void e() {
            boolean z10;
            int s10 = this.f2653a.s();
            if (s10 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            d(z10);
            this.f2655c.setProgress(s10);
        }
    }

    public final class g extends t0.b {
        public g() {
        }

        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            boolean z10;
            t0.i.a h10;
            if (iVar == h.this.f2622d && iVar.g() != null) {
                Iterator it = iVar.q().f().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    t0.i iVar2 = (t0.i) it.next();
                    if (!h.this.f2622d.l().contains(iVar2) && (h10 = h.this.f2622d.h(iVar2)) != null && h10.b() && !h.this.f2624f.contains(iVar2)) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            if (z10) {
                h.this.p();
                h.this.n();
                return;
            }
            h.this.o();
        }

        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            h hVar = h.this;
            hVar.f2622d = iVar;
            hVar.f2638t = false;
            hVar.p();
            h.this.n();
        }

        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            h.this.o();
        }

        public void onRouteVolumeChanged(t0 t0Var, t0.i iVar) {
            f fVar;
            int s10 = iVar.s();
            if (h.O) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRouteVolumeChanged(), route.getVolume:");
                sb.append(s10);
            }
            h hVar = h.this;
            if (hVar.f2636r != iVar && (fVar = (f) hVar.f2635q.get(iVar.k())) != null) {
                fVar.e();
            }
        }
    }

    /* renamed from: androidx.mediarouter.app.h$h  reason: collision with other inner class name */
    public final class C0038h extends RecyclerView.g {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList f2659a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f2660b;

        /* renamed from: c  reason: collision with root package name */
        public final Drawable f2661c;

        /* renamed from: d  reason: collision with root package name */
        public final Drawable f2662d;

        /* renamed from: e  reason: collision with root package name */
        public final Drawable f2663e;

        /* renamed from: f  reason: collision with root package name */
        public final Drawable f2664f;

        /* renamed from: g  reason: collision with root package name */
        public f f2665g;

        /* renamed from: h  reason: collision with root package name */
        public final int f2666h;

        /* renamed from: i  reason: collision with root package name */
        public final Interpolator f2667i;

        /* renamed from: androidx.mediarouter.app.h$h$a */
        public class a extends Animation {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ int f2669a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ int f2670b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ View f2671c;

            public a(int i10, int i11, View view) {
                this.f2669a = i10;
                this.f2670b = i11;
                this.f2671c = view;
            }

            public void applyTransformation(float f10, Transformation transformation) {
                int i10 = this.f2669a;
                int i11 = this.f2670b;
                h.h(this.f2671c, i11 + ((int) (((float) (i10 - i11)) * f10)));
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$b */
        public class b implements Animation.AnimationListener {
            public b() {
            }

            public void onAnimationEnd(Animation animation) {
                h hVar = h.this;
                hVar.f2639u = false;
                hVar.p();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                h.this.f2639u = true;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$c */
        public class c extends RecyclerView.d0 {

            /* renamed from: a  reason: collision with root package name */
            public final View f2674a;

            /* renamed from: b  reason: collision with root package name */
            public final ImageView f2675b;

            /* renamed from: c  reason: collision with root package name */
            public final ProgressBar f2676c;

            /* renamed from: d  reason: collision with root package name */
            public final TextView f2677d;

            /* renamed from: e  reason: collision with root package name */
            public final float f2678e;

            /* renamed from: f  reason: collision with root package name */
            public t0.i f2679f;

            /* renamed from: androidx.mediarouter.app.h$h$c$a */
            public class a implements View.OnClickListener {
                public a() {
                }

                public void onClick(View view) {
                    c cVar = c.this;
                    h.this.f2619a.w(cVar.f2679f);
                    c.this.f2675b.setVisibility(4);
                    c.this.f2676c.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.f2674a = view;
                this.f2675b = (ImageView) view.findViewById(R$id.mr_cast_group_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_group_progress_bar);
                this.f2676c = progressBar;
                this.f2677d = (TextView) view.findViewById(R$id.mr_cast_group_name);
                this.f2678e = i.h(h.this.f2627i);
                i.t(h.this.f2627i, progressBar);
            }

            public void b(f fVar) {
                float f10;
                t0.i iVar = (t0.i) fVar.a();
                this.f2679f = iVar;
                this.f2675b.setVisibility(0);
                this.f2676c.setVisibility(4);
                boolean c10 = c(iVar);
                View view = this.f2674a;
                if (c10) {
                    f10 = 1.0f;
                } else {
                    f10 = this.f2678e;
                }
                view.setAlpha(f10);
                this.f2674a.setOnClickListener(new a());
                this.f2675b.setImageDrawable(C0038h.this.c(iVar));
                this.f2677d.setText(iVar.m());
            }

            public final boolean c(t0.i iVar) {
                List l10 = h.this.f2622d.l();
                if (l10.size() == 1 && l10.get(0) == iVar) {
                    return false;
                }
                return true;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$d */
        public class d extends f {

            /* renamed from: e  reason: collision with root package name */
            public final TextView f2682e;

            /* renamed from: f  reason: collision with root package name */
            public final int f2683f;

            public d(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f2682e = (TextView) view.findViewById(R$id.mr_group_volume_route_name);
                Resources resources = h.this.f2627i.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_volume_group_list_item_height, typedValue, true);
                this.f2683f = (int) typedValue.getDimension(displayMetrics);
            }

            public void f(f fVar) {
                int i10;
                View view = this.itemView;
                if (C0038h.this.e()) {
                    i10 = this.f2683f;
                } else {
                    i10 = 0;
                }
                h.h(view, i10);
                t0.i iVar = (t0.i) fVar.a();
                super.b(iVar);
                this.f2682e.setText(iVar.m());
            }

            public int g() {
                return this.f2683f;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$e */
        public class e extends RecyclerView.d0 {

            /* renamed from: a  reason: collision with root package name */
            public final TextView f2685a;

            public e(View view) {
                super(view);
                this.f2685a = (TextView) view.findViewById(R$id.mr_cast_header_name);
            }

            public void b(f fVar) {
                this.f2685a.setText(fVar.a().toString());
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$f */
        public class f {

            /* renamed from: a  reason: collision with root package name */
            public final Object f2687a;

            /* renamed from: b  reason: collision with root package name */
            public final int f2688b;

            public f(Object obj, int i10) {
                this.f2687a = obj;
                this.f2688b = i10;
            }

            public Object a() {
                return this.f2687a;
            }

            public int b() {
                return this.f2688b;
            }
        }

        /* renamed from: androidx.mediarouter.app.h$h$g */
        public class g extends f {

            /* renamed from: e  reason: collision with root package name */
            public final View f2690e;

            /* renamed from: f  reason: collision with root package name */
            public final ImageView f2691f;

            /* renamed from: g  reason: collision with root package name */
            public final ProgressBar f2692g;

            /* renamed from: h  reason: collision with root package name */
            public final TextView f2693h;

            /* renamed from: i  reason: collision with root package name */
            public final RelativeLayout f2694i;

            /* renamed from: j  reason: collision with root package name */
            public final CheckBox f2695j;

            /* renamed from: k  reason: collision with root package name */
            public final float f2696k;

            /* renamed from: l  reason: collision with root package name */
            public final int f2697l;

            /* renamed from: m  reason: collision with root package name */
            public final int f2698m;

            /* renamed from: n  reason: collision with root package name */
            public final View.OnClickListener f2699n = new a();

            /* renamed from: androidx.mediarouter.app.h$h$g$a */
            public class a implements View.OnClickListener {
                public a() {
                }

                public void onClick(View view) {
                    g gVar = g.this;
                    boolean z10 = !gVar.h(gVar.f2653a);
                    boolean y10 = g.this.f2653a.y();
                    if (z10) {
                        g gVar2 = g.this;
                        h.this.f2619a.c(gVar2.f2653a);
                    } else {
                        g gVar3 = g.this;
                        h.this.f2619a.r(gVar3.f2653a);
                    }
                    g.this.i(z10, !y10);
                    if (y10) {
                        List l10 = h.this.f2622d.l();
                        for (t0.i iVar : g.this.f2653a.l()) {
                            if (l10.contains(iVar) != z10) {
                                f fVar = (f) h.this.f2635q.get(iVar.k());
                                if (fVar instanceof g) {
                                    ((g) fVar).i(z10, true);
                                }
                            }
                        }
                    }
                    g gVar4 = g.this;
                    C0038h.this.f(gVar4.f2653a, z10);
                }
            }

            public g(View view) {
                super(view, (ImageButton) view.findViewById(R$id.mr_cast_mute_button), (MediaRouteVolumeSlider) view.findViewById(R$id.mr_cast_volume_slider));
                this.f2690e = view;
                this.f2691f = (ImageView) view.findViewById(R$id.mr_cast_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_cast_route_progress_bar);
                this.f2692g = progressBar;
                this.f2693h = (TextView) view.findViewById(R$id.mr_cast_route_name);
                this.f2694i = (RelativeLayout) view.findViewById(R$id.mr_cast_volume_layout);
                CheckBox checkBox = (CheckBox) view.findViewById(R$id.mr_cast_checkbox);
                this.f2695j = checkBox;
                checkBox.setButtonDrawable(i.e(h.this.f2627i));
                i.t(h.this.f2627i, progressBar);
                this.f2696k = i.h(h.this.f2627i);
                Resources resources = h.this.f2627i.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                TypedValue typedValue = new TypedValue();
                resources.getValue(R$dimen.mr_dynamic_dialog_row_height, typedValue, true);
                this.f2697l = (int) typedValue.getDimension(displayMetrics);
                this.f2698m = 0;
            }

            public void f(f fVar) {
                boolean z10;
                int i10;
                float f10;
                t0.i iVar = (t0.i) fVar.a();
                if (iVar == h.this.f2622d && iVar.l().size() > 0) {
                    Iterator it = iVar.l().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        t0.i iVar2 = (t0.i) it.next();
                        if (!h.this.f2624f.contains(iVar2)) {
                            iVar = iVar2;
                            break;
                        }
                    }
                }
                b(iVar);
                this.f2691f.setImageDrawable(C0038h.this.c(iVar));
                this.f2693h.setText(iVar.m());
                boolean z11 = false;
                this.f2695j.setVisibility(0);
                boolean h10 = h(iVar);
                boolean g10 = g(iVar);
                this.f2695j.setChecked(h10);
                this.f2692g.setVisibility(4);
                this.f2691f.setVisibility(0);
                this.f2690e.setEnabled(g10);
                this.f2695j.setEnabled(g10);
                ImageButton imageButton = this.f2654b;
                if (g10 || h10) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                imageButton.setEnabled(z10);
                MediaRouteVolumeSlider mediaRouteVolumeSlider = this.f2655c;
                if (g10 || h10) {
                    z11 = true;
                }
                mediaRouteVolumeSlider.setEnabled(z11);
                this.f2690e.setOnClickListener(this.f2699n);
                this.f2695j.setOnClickListener(this.f2699n);
                RelativeLayout relativeLayout = this.f2694i;
                if (!h10 || this.f2653a.y()) {
                    i10 = this.f2698m;
                } else {
                    i10 = this.f2697l;
                }
                h.h(relativeLayout, i10);
                View view = this.f2690e;
                float f11 = 1.0f;
                if (g10 || h10) {
                    f10 = 1.0f;
                } else {
                    f10 = this.f2696k;
                }
                view.setAlpha(f10);
                CheckBox checkBox = this.f2695j;
                if (!g10 && h10) {
                    f11 = this.f2696k;
                }
                checkBox.setAlpha(f11);
            }

            public final boolean g(t0.i iVar) {
                if (h.this.f2626h.contains(iVar)) {
                    return false;
                }
                if (h(iVar) && h.this.f2622d.l().size() < 2) {
                    return false;
                }
                if (!h(iVar)) {
                    return true;
                }
                t0.i.a h10 = h.this.f2622d.h(iVar);
                if (h10 == null || !h10.d()) {
                    return false;
                }
                return true;
            }

            public boolean h(t0.i iVar) {
                if (iVar.C()) {
                    return true;
                }
                t0.i.a h10 = h.this.f2622d.h(iVar);
                if (h10 == null || h10.a() != 3) {
                    return false;
                }
                return true;
            }

            public void i(boolean z10, boolean z11) {
                int i10;
                this.f2695j.setEnabled(false);
                this.f2690e.setEnabled(false);
                this.f2695j.setChecked(z10);
                if (z10) {
                    this.f2691f.setVisibility(4);
                    this.f2692g.setVisibility(0);
                }
                if (z11) {
                    C0038h hVar = C0038h.this;
                    RelativeLayout relativeLayout = this.f2694i;
                    if (z10) {
                        i10 = this.f2697l;
                    } else {
                        i10 = this.f2698m;
                    }
                    hVar.a(relativeLayout, i10);
                }
            }
        }

        public C0038h() {
            this.f2660b = LayoutInflater.from(h.this.f2627i);
            this.f2661c = i.g(h.this.f2627i);
            this.f2662d = i.q(h.this.f2627i);
            this.f2663e = i.m(h.this.f2627i);
            this.f2664f = i.n(h.this.f2627i);
            this.f2666h = h.this.f2627i.getResources().getInteger(R$integer.mr_cast_volume_slider_layout_animation_duration_ms);
            this.f2667i = new AccelerateDecelerateInterpolator();
            h();
        }

        public void a(View view, int i10) {
            a aVar = new a(i10, view.getLayoutParams().height, view);
            aVar.setAnimationListener(new b());
            aVar.setDuration((long) this.f2666h);
            aVar.setInterpolator(this.f2667i);
            view.startAnimation(aVar);
        }

        public final Drawable b(t0.i iVar) {
            int f10 = iVar.f();
            if (f10 == 1) {
                return this.f2662d;
            }
            if (f10 == 2) {
                return this.f2663e;
            }
            if (iVar.y()) {
                return this.f2664f;
            }
            return this.f2661c;
        }

        public Drawable c(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(h.this.f2627i.getContentResolver().openInputStream(j10), (String) null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ");
                    sb.append(j10);
                }
            }
            return b(iVar);
        }

        public f d(int i10) {
            if (i10 == 0) {
                return this.f2665g;
            }
            return (f) this.f2659a.get(i10 - 1);
        }

        public boolean e() {
            if (h.this.f2622d.l().size() > 1) {
                return true;
            }
            return false;
        }

        public void f(t0.i iVar, boolean z10) {
            int i10;
            List l10 = h.this.f2622d.l();
            boolean z11 = true;
            int max = Math.max(1, l10.size());
            int i11 = -1;
            if (iVar.y()) {
                for (t0.i contains : iVar.l()) {
                    if (l10.contains(contains) != z10) {
                        if (z10) {
                            i10 = 1;
                        } else {
                            i10 = -1;
                        }
                        max += i10;
                    }
                }
            } else {
                if (z10) {
                    i11 = 1;
                }
                max += i11;
            }
            boolean e10 = e();
            int i12 = 0;
            if (max < 2) {
                z11 = false;
            }
            if (e10 != z11) {
                RecyclerView.d0 findViewHolderForAdapterPosition = h.this.f2632n.findViewHolderForAdapterPosition(0);
                if (findViewHolderForAdapterPosition instanceof d) {
                    d dVar = (d) findViewHolderForAdapterPosition;
                    View view = dVar.itemView;
                    if (z11) {
                        i12 = dVar.g();
                    }
                    a(view, i12);
                }
            }
        }

        public void g() {
            h.this.f2626h.clear();
            h hVar = h.this;
            hVar.f2626h.addAll(f.g(hVar.f2624f, hVar.c()));
            notifyDataSetChanged();
        }

        public int getItemCount() {
            return this.f2659a.size() + 1;
        }

        public int getItemViewType(int i10) {
            return d(i10).b();
        }

        public void h() {
            String str;
            String str2;
            this.f2659a.clear();
            this.f2665g = new f(h.this.f2622d, 1);
            if (!h.this.f2623e.isEmpty()) {
                for (t0.i fVar : h.this.f2623e) {
                    this.f2659a.add(new f(fVar, 3));
                }
            } else {
                this.f2659a.add(new f(h.this.f2622d, 3));
            }
            boolean z10 = false;
            if (!h.this.f2624f.isEmpty()) {
                boolean z11 = false;
                for (t0.i iVar : h.this.f2624f) {
                    if (!h.this.f2623e.contains(iVar)) {
                        if (!z11) {
                            p0.b g10 = h.this.f2622d.g();
                            if (g10 != null) {
                                str2 = g10.j();
                            } else {
                                str2 = null;
                            }
                            if (TextUtils.isEmpty(str2)) {
                                str2 = h.this.f2627i.getString(R$string.mr_dialog_groupable_header);
                            }
                            this.f2659a.add(new f(str2, 2));
                            z11 = true;
                        }
                        this.f2659a.add(new f(iVar, 3));
                    }
                }
            }
            if (!h.this.f2625g.isEmpty()) {
                for (t0.i iVar2 : h.this.f2625g) {
                    t0.i iVar3 = h.this.f2622d;
                    if (iVar3 != iVar2) {
                        if (!z10) {
                            p0.b g11 = iVar3.g();
                            if (g11 != null) {
                                str = g11.k();
                            } else {
                                str = null;
                            }
                            if (TextUtils.isEmpty(str)) {
                                str = h.this.f2627i.getString(R$string.mr_dialog_transferable_header);
                            }
                            this.f2659a.add(new f(str, 2));
                            z10 = true;
                        }
                        this.f2659a.add(new f(iVar2, 4));
                    }
                }
            }
            g();
        }

        public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
            int itemViewType = getItemViewType(i10);
            f d10 = d(i10);
            if (itemViewType == 1) {
                h.this.f2635q.put(((t0.i) d10.a()).k(), (f) d0Var);
                ((d) d0Var).f(d10);
            } else if (itemViewType == 2) {
                ((e) d0Var).b(d10);
            } else if (itemViewType == 3) {
                h.this.f2635q.put(((t0.i) d10.a()).k(), (f) d0Var);
                ((g) d0Var).f(d10);
            } else if (itemViewType == 4) {
                ((c) d0Var).b(d10);
            }
        }

        public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 1) {
                return new d(this.f2660b.inflate(R$layout.mr_cast_group_volume_item, viewGroup, false));
            }
            if (i10 == 2) {
                return new e(this.f2660b.inflate(R$layout.mr_cast_header_item, viewGroup, false));
            }
            if (i10 == 3) {
                return new g(this.f2660b.inflate(R$layout.mr_cast_route_item, viewGroup, false));
            }
            if (i10 != 4) {
                return null;
            }
            return new c(this.f2660b.inflate(R$layout.mr_cast_group_item, viewGroup, false));
        }

        public void onViewRecycled(RecyclerView.d0 d0Var) {
            super.onViewRecycled(d0Var);
            h.this.f2635q.values().remove(d0Var);
        }
    }

    public static final class i implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final i f2702a = new i();

        /* renamed from: a */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public class j implements SeekBar.OnSeekBarChangeListener {
        public j() {
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            boolean z11;
            if (z10) {
                t0.i iVar = (t0.i) seekBar.getTag();
                f fVar = (f) h.this.f2635q.get(iVar.k());
                if (fVar != null) {
                    if (i10 == 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    fVar.d(z11);
                }
                iVar.G(i10);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            h hVar = h.this;
            if (hVar.f2636r != null) {
                hVar.f2631m.removeMessages(2);
            }
            h.this.f2636r = (t0.i) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            h.this.f2631m.sendEmptyMessageDelayed(2, 500);
        }
    }

    public h(Context context) {
        this(context, 0);
    }

    public static Bitmap a(Bitmap bitmap, float f10, Context context) {
        RenderScript create = RenderScript.create(context);
        Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
        Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
        ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
        create2.setRadius(f10);
        create2.setInput(createFromBitmap);
        create2.forEach(createTyped);
        Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
        createTyped.copyTo(copy);
        createFromBitmap.destroy();
        createTyped.destroy();
        create2.destroy();
        create.destroy();
        return copy;
    }

    public static boolean d(Bitmap bitmap) {
        if (bitmap == null || !bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static void h(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public void b() {
        this.L = false;
        this.M = null;
        this.N = 0;
    }

    public List c() {
        ArrayList arrayList = new ArrayList();
        for (t0.i iVar : this.f2622d.q().f()) {
            t0.i.a h10 = this.f2622d.h(iVar);
            if (h10 != null && h10.b()) {
                arrayList.add(iVar);
            }
        }
        return arrayList;
    }

    public boolean e(t0.i iVar) {
        if (iVar.w() || !iVar.x() || !iVar.E(this.f2621c) || this.f2622d == iVar) {
            return false;
        }
        return true;
    }

    public void f(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            if (!e((t0.i) list.get(size))) {
                list.remove(size);
            }
        }
    }

    public void g() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.H;
        Uri uri2 = null;
        if (mediaDescriptionCompat == null) {
            bitmap = null;
        } else {
            bitmap = mediaDescriptionCompat.b();
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = this.H;
        if (mediaDescriptionCompat2 != null) {
            uri2 = mediaDescriptionCompat2.c();
        }
        d dVar = this.I;
        if (dVar == null) {
            bitmap2 = this.J;
        } else {
            bitmap2 = dVar.b();
        }
        d dVar2 = this.I;
        if (dVar2 == null) {
            uri = this.K;
        } else {
            uri = dVar2.c();
        }
        if (bitmap2 != bitmap || (bitmap2 == null && !a0.c.a(uri, uri2))) {
            d dVar3 = this.I;
            if (dVar3 != null) {
                dVar3.cancel(true);
            }
            d dVar4 = new d();
            this.I = dVar4;
            dVar4.execute(new Void[0]);
        }
    }

    public final void i(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.F;
        MediaDescriptionCompat mediaDescriptionCompat = null;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.g(this.G);
            this.F = null;
        }
        if (token != null && this.f2629k) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f2627i, token);
            this.F = mediaControllerCompat2;
            mediaControllerCompat2.e(this.G);
            MediaMetadataCompat a10 = this.F.a();
            if (a10 != null) {
                mediaDescriptionCompat = a10.e();
            }
            this.H = mediaDescriptionCompat;
            g();
            m();
        }
    }

    public void j(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        } else if (!this.f2621c.equals(s0Var)) {
            this.f2621c = s0Var;
            if (this.f2629k) {
                this.f2619a.q(this.f2620b);
                this.f2619a.b(s0Var, this.f2620b, 1);
                n();
            }
        }
    }

    public final boolean k() {
        if (this.f2636r != null || this.f2638t || this.f2639u) {
            return true;
        }
        return !this.f2628j;
    }

    public void l() {
        getWindow().setLayout(f.c(this.f2627i), f.a(this.f2627i));
        this.J = null;
        this.K = null;
        g();
        m();
        o();
    }

    public void m() {
        CharSequence charSequence;
        if (k()) {
            this.f2641w = true;
            return;
        }
        this.f2641w = false;
        if (!this.f2622d.C() || this.f2622d.w()) {
            dismiss();
        }
        CharSequence charSequence2 = null;
        if (!this.L || d(this.M) || this.M == null) {
            if (d(this.M)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can't set artwork image with recycled bitmap: ");
                sb.append(this.M);
            }
            this.B.setVisibility(8);
            this.A.setVisibility(8);
            this.f2644z.setImageBitmap((Bitmap) null);
        } else {
            this.B.setVisibility(0);
            this.B.setImageBitmap(this.M);
            this.B.setBackgroundColor(this.N);
            this.A.setVisibility(0);
            this.f2644z.setImageBitmap(a(this.M, 10.0f, this.f2627i));
        }
        b();
        MediaDescriptionCompat mediaDescriptionCompat = this.H;
        if (mediaDescriptionCompat == null) {
            charSequence = null;
        } else {
            charSequence = mediaDescriptionCompat.f();
        }
        boolean z10 = !TextUtils.isEmpty(charSequence);
        MediaDescriptionCompat mediaDescriptionCompat2 = this.H;
        if (mediaDescriptionCompat2 != null) {
            charSequence2 = mediaDescriptionCompat2.e();
        }
        boolean isEmpty = true ^ TextUtils.isEmpty(charSequence2);
        if (z10) {
            this.C.setText(charSequence);
        } else {
            this.C.setText(this.E);
        }
        if (isEmpty) {
            this.D.setText(charSequence2);
            this.D.setVisibility(0);
            return;
        }
        this.D.setVisibility(8);
    }

    public void n() {
        this.f2623e.clear();
        this.f2624f.clear();
        this.f2625g.clear();
        this.f2623e.addAll(this.f2622d.l());
        for (t0.i iVar : this.f2622d.q().f()) {
            t0.i.a h10 = this.f2622d.h(iVar);
            if (h10 != null) {
                if (h10.b()) {
                    this.f2624f.add(iVar);
                }
                if (h10.c()) {
                    this.f2625g.add(iVar);
                }
            }
        }
        f(this.f2624f);
        f(this.f2625g);
        List list = this.f2623e;
        i iVar2 = i.f2702a;
        Collections.sort(list, iVar2);
        Collections.sort(this.f2624f, iVar2);
        Collections.sort(this.f2625g, iVar2);
        this.f2633o.h();
    }

    public void o() {
        if (!this.f2629k) {
            return;
        }
        if (SystemClock.uptimeMillis() - this.f2630l < 300) {
            this.f2631m.removeMessages(1);
            this.f2631m.sendEmptyMessageAtTime(1, this.f2630l + 300);
        } else if (k()) {
            this.f2640v = true;
        } else {
            this.f2640v = false;
            if (!this.f2622d.C() || this.f2622d.w()) {
                dismiss();
            }
            this.f2630l = SystemClock.uptimeMillis();
            this.f2633o.g();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2629k = true;
        this.f2619a.b(this.f2621c, this.f2620b, 1);
        n();
        i(this.f2619a.j());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_cast_dialog);
        i.s(this.f2627i, this);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_cast_close_button);
        this.f2642x = imageButton;
        imageButton.setColorFilter(-1);
        this.f2642x.setOnClickListener(new b());
        Button button = (Button) findViewById(R$id.mr_cast_stop_button);
        this.f2643y = button;
        button.setTextColor(-1);
        this.f2643y.setOnClickListener(new c());
        this.f2633o = new C0038h();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_cast_list);
        this.f2632n = recyclerView;
        recyclerView.setAdapter(this.f2633o);
        this.f2632n.setLayoutManager(new LinearLayoutManager(this.f2627i));
        this.f2634p = new j();
        this.f2635q = new HashMap();
        this.f2637s = new HashMap();
        this.f2644z = (ImageView) findViewById(R$id.mr_cast_meta_background);
        this.A = findViewById(R$id.mr_cast_meta_black_scrim);
        this.B = (ImageView) findViewById(R$id.mr_cast_meta_art);
        TextView textView = (TextView) findViewById(R$id.mr_cast_meta_title);
        this.C = textView;
        textView.setTextColor(-1);
        TextView textView2 = (TextView) findViewById(R$id.mr_cast_meta_subtitle);
        this.D = textView2;
        textView2.setTextColor(-1);
        this.E = this.f2627i.getResources().getString(R$string.mr_cast_dialog_title_view_placeholder);
        this.f2628j = true;
        l();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2629k = false;
        this.f2619a.q(this.f2620b);
        this.f2631m.removeCallbacksAndMessages((Object) null);
        i((MediaSessionCompat.Token) null);
    }

    public void p() {
        if (this.f2640v) {
            o();
        }
        if (this.f2641w) {
            m();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            n0.s0 r2 = n0.s0.f8047c
            r1.f2621c = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2623e = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2624f = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2625g = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f2626h = r2
            androidx.mediarouter.app.h$a r2 = new androidx.mediarouter.app.h$a
            r2.<init>()
            r1.f2631m = r2
            android.content.Context r2 = r1.getContext()
            r1.f2627i = r2
            n0.t0 r2 = n0.t0.i(r2)
            r1.f2619a = r2
            androidx.mediarouter.app.h$g r3 = new androidx.mediarouter.app.h$g
            r3.<init>()
            r1.f2620b = r3
            n0.t0$i r3 = r2.m()
            r1.f2622d = r3
            androidx.mediarouter.app.h$e r3 = new androidx.mediarouter.app.h$e
            r3.<init>()
            r1.G = r3
            android.support.v4.media.session.MediaSessionCompat$Token r2 = r2.j()
            r1.i(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.h.<init>(android.content.Context, int):void");
    }
}
