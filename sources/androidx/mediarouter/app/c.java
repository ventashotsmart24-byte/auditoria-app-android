package androidx.mediarouter.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.mediarouter.R$dimen;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$integer;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.mediarouter.app.OverlayListView;
import com.google.common.primitives.Ints;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import n0.s0;
import n0.t0;

public class c extends androidx.appcompat.app.c {

    /* renamed from: v0  reason: collision with root package name */
    public static final boolean f2503v0 = Log.isLoggable("MediaRouteCtrlDialog", 3);

    /* renamed from: w0  reason: collision with root package name */
    public static final int f2504w0 = ((int) TimeUnit.SECONDS.toMillis(30));
    public OverlayListView A;
    public r B;
    public List C;
    public Set D;
    public Set E;
    public Set F;
    public SeekBar G;
    public q H;
    public t0.i I;
    public int J;
    public int K;
    public int L;
    public final int M;
    public Map N;
    public MediaControllerCompat O;
    public o Q;
    public PlaybackStateCompat S;
    public MediaDescriptionCompat V;
    public n W;
    public Bitmap X;
    public Uri Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public final t0 f2505a;

    /* renamed from: b  reason: collision with root package name */
    public final p f2506b;

    /* renamed from: c  reason: collision with root package name */
    public final t0.i f2507c;

    /* renamed from: d  reason: collision with root package name */
    public Context f2508d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2509e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2510f;

    /* renamed from: f0  reason: collision with root package name */
    public Bitmap f2511f0;

    /* renamed from: g  reason: collision with root package name */
    public int f2512g;

    /* renamed from: g0  reason: collision with root package name */
    public int f2513g0;

    /* renamed from: h  reason: collision with root package name */
    public View f2514h;

    /* renamed from: h0  reason: collision with root package name */
    public boolean f2515h0;

    /* renamed from: i  reason: collision with root package name */
    public Button f2516i;

    /* renamed from: i0  reason: collision with root package name */
    public boolean f2517i0;

    /* renamed from: j  reason: collision with root package name */
    public Button f2518j;

    /* renamed from: j0  reason: collision with root package name */
    public boolean f2519j0;

    /* renamed from: k  reason: collision with root package name */
    public ImageButton f2520k;

    /* renamed from: k0  reason: collision with root package name */
    public boolean f2521k0;

    /* renamed from: l  reason: collision with root package name */
    public ImageButton f2522l;

    /* renamed from: l0  reason: collision with root package name */
    public boolean f2523l0;

    /* renamed from: m  reason: collision with root package name */
    public MediaRouteExpandCollapseButton f2524m;

    /* renamed from: m0  reason: collision with root package name */
    public int f2525m0;

    /* renamed from: n  reason: collision with root package name */
    public FrameLayout f2526n;

    /* renamed from: n0  reason: collision with root package name */
    public int f2527n0;

    /* renamed from: o  reason: collision with root package name */
    public LinearLayout f2528o;

    /* renamed from: o0  reason: collision with root package name */
    public int f2529o0;

    /* renamed from: p  reason: collision with root package name */
    public FrameLayout f2530p;

    /* renamed from: p0  reason: collision with root package name */
    public Interpolator f2531p0;

    /* renamed from: q  reason: collision with root package name */
    public FrameLayout f2532q;

    /* renamed from: q0  reason: collision with root package name */
    public Interpolator f2533q0;

    /* renamed from: r  reason: collision with root package name */
    public ImageView f2534r;

    /* renamed from: r0  reason: collision with root package name */
    public Interpolator f2535r0;

    /* renamed from: s  reason: collision with root package name */
    public TextView f2536s;

    /* renamed from: s0  reason: collision with root package name */
    public Interpolator f2537s0;

    /* renamed from: t  reason: collision with root package name */
    public TextView f2538t;

    /* renamed from: t0  reason: collision with root package name */
    public final AccessibilityManager f2539t0;

    /* renamed from: u  reason: collision with root package name */
    public TextView f2540u;

    /* renamed from: u0  reason: collision with root package name */
    public Runnable f2541u0;

    /* renamed from: v  reason: collision with root package name */
    public boolean f2542v;

    /* renamed from: w  reason: collision with root package name */
    public LinearLayout f2543w;

    /* renamed from: x  reason: collision with root package name */
    public RelativeLayout f2544x;

    /* renamed from: y  reason: collision with root package name */
    public LinearLayout f2545y;

    /* renamed from: z  reason: collision with root package name */
    public View f2546z;

    public class a implements OverlayListView.a.C0035a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t0.i f2547a;

        public a(t0.i iVar) {
            this.f2547a = iVar;
        }

        public void onAnimationEnd() {
            c.this.F.remove(this.f2547a);
            c.this.B.notifyDataSetChanged();
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        public void onGlobalLayout() {
            c.this.A.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.x();
        }
    }

    /* renamed from: androidx.mediarouter.app.c$c  reason: collision with other inner class name */
    public class C0037c implements Animation.AnimationListener {
        public C0037c() {
        }

        public void onAnimationEnd(Animation animation) {
            c.this.h(true);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        public void run() {
            c.this.w();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            c.this.dismiss();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        public void onClick(View view) {
            PendingIntent c10;
            MediaControllerCompat mediaControllerCompat = c.this.O;
            if (mediaControllerCompat != null && (c10 = mediaControllerCompat.c()) != null) {
                try {
                    c10.send();
                    c.this.dismiss();
                } catch (PendingIntent.CanceledException unused) {
                    Log.e("MediaRouteCtrlDialog", c10 + " was not sent, it had been canceled.");
                }
            }
        }
    }

    public class h implements View.OnClickListener {
        public h() {
        }

        public void onClick(View view) {
            c cVar = c.this;
            boolean z10 = !cVar.f2519j0;
            cVar.f2519j0 = z10;
            if (z10) {
                cVar.A.setVisibility(0);
            }
            c.this.r();
            c.this.B(true);
        }
    }

    public class i implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2556a;

        public i(boolean z10) {
            this.f2556a = z10;
        }

        public void onGlobalLayout() {
            c.this.f2530p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c cVar = c.this;
            if (cVar.f2521k0) {
                cVar.f2523l0 = true;
            } else {
                cVar.C(this.f2556a);
            }
        }
    }

    public class j extends Animation {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f2558a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f2559b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f2560c;

        public j(int i10, int i11, View view) {
            this.f2558a = i10;
            this.f2559b = i11;
            this.f2560c = view;
        }

        public void applyTransformation(float f10, Transformation transformation) {
            int i10 = this.f2558a;
            c.u(this.f2560c, i10 - ((int) (((float) (i10 - this.f2559b)) * f10)));
        }
    }

    public class k implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Map f2562a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Map f2563b;

        public k(Map map, Map map2) {
            this.f2562a = map;
            this.f2563b = map2;
        }

        public void onGlobalLayout() {
            c.this.A.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            c.this.b(this.f2562a, this.f2563b);
        }
    }

    public class l implements Animation.AnimationListener {
        public l() {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
            c.this.A.b();
            c cVar = c.this;
            cVar.A.postDelayed(cVar.f2541u0, (long) cVar.f2525m0);
        }
    }

    public final class m implements View.OnClickListener {
        public m() {
        }

        public void onClick(View view) {
            PlaybackStateCompat playbackStateCompat;
            int id = view.getId();
            int i10 = 1;
            if (id == 16908313 || id == 16908314) {
                if (c.this.f2507c.C()) {
                    t0 t0Var = c.this.f2505a;
                    if (id == 16908313) {
                        i10 = 2;
                    }
                    t0Var.x(i10);
                }
                c.this.dismiss();
            } else if (id == R$id.mr_control_playback_ctrl) {
                c cVar = c.this;
                if (cVar.O != null && (playbackStateCompat = cVar.S) != null) {
                    int i11 = 0;
                    if (playbackStateCompat.g() != 3) {
                        i10 = 0;
                    }
                    if (i10 != 0 && c.this.n()) {
                        c.this.O.d().a();
                        i11 = R$string.mr_controller_pause;
                    } else if (i10 != 0 && c.this.p()) {
                        c.this.O.d().c();
                        i11 = R$string.mr_controller_stop;
                    } else if (i10 == 0 && c.this.o()) {
                        c.this.O.d().b();
                        i11 = R$string.mr_controller_play;
                    }
                    AccessibilityManager accessibilityManager = c.this.f2539t0;
                    if (accessibilityManager != null && accessibilityManager.isEnabled() && i11 != 0) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain(16384);
                        obtain.setPackageName(c.this.f2508d.getPackageName());
                        obtain.setClassName(m.class.getName());
                        obtain.getText().add(c.this.f2508d.getString(i11));
                        c.this.f2539t0.sendAccessibilityEvent(obtain);
                    }
                }
            } else if (id == R$id.mr_close) {
                c.this.dismiss();
            }
        }
    }

    public class n extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f2567a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f2568b;

        /* renamed from: c  reason: collision with root package name */
        public int f2569c;

        /* renamed from: d  reason: collision with root package name */
        public long f2570d;

        public n() {
            Bitmap bitmap;
            MediaDescriptionCompat mediaDescriptionCompat = c.this.V;
            Uri uri = null;
            if (mediaDescriptionCompat == null) {
                bitmap = null;
            } else {
                bitmap = mediaDescriptionCompat.b();
            }
            this.f2567a = c.l(bitmap) ? null : bitmap;
            MediaDescriptionCompat mediaDescriptionCompat2 = c.this.V;
            this.f2568b = mediaDescriptionCompat2 != null ? mediaDescriptionCompat2.c() : uri;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(6:4|5|(4:7|8|(2:10|11)|12)(3:14|15|(3:43|44|45)(8:19|20|21|22|(3:24|(2:26|27)|28)|30|31|(3:33|34|35)(5:37|38|39|40|42)))|50|51|(2:53|54)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:19|20|21|22|(3:24|(2:26|27)|28)|30|31|(3:33|34|35)(5:37|38|39|40|42)) */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a7, code lost:
            r9 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a8, code lost:
            r3 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            r3.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:50:0x0092 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x004a A[Catch:{ IOException -> 0x0092 }] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x00a1 A[SYNTHETIC, Splitter:B:53:0x00a1] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab A[SYNTHETIC, Splitter:B:59:0x00ab] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public android.graphics.Bitmap doInBackground(java.lang.Void... r9) {
            /*
                r8 = this;
                java.lang.String r9 = "Unable to open: "
                android.graphics.Bitmap r0 = r8.f2567a
                r1 = 0
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x000b
                goto L_0x00b0
            L_0x000b:
                android.net.Uri r0 = r8.f2568b
                if (r0 == 0) goto L_0x00af
                java.io.InputStream r0 = r8.e(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008f }
                if (r0 != 0) goto L_0x0028
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0092 }
                r4.<init>()     // Catch:{ IOException -> 0x0092 }
                r4.append(r9)     // Catch:{ IOException -> 0x0092 }
                android.net.Uri r5 = r8.f2568b     // Catch:{ IOException -> 0x0092 }
                r4.append(r5)     // Catch:{ IOException -> 0x0092 }
                if (r0 == 0) goto L_0x0027
                r0.close()     // Catch:{ IOException -> 0x0027 }
            L_0x0027:
                return r3
            L_0x0028:
                android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options     // Catch:{ IOException -> 0x0092 }
                r4.<init>()     // Catch:{ IOException -> 0x0092 }
                r4.inJustDecodeBounds = r2     // Catch:{ IOException -> 0x0092 }
                android.graphics.BitmapFactory.decodeStream(r0, r3, r4)     // Catch:{ IOException -> 0x0092 }
                int r5 = r4.outWidth     // Catch:{ IOException -> 0x0092 }
                if (r5 == 0) goto L_0x008b
                int r5 = r4.outHeight     // Catch:{ IOException -> 0x0092 }
                if (r5 != 0) goto L_0x003b
                goto L_0x008b
            L_0x003b:
                r0.reset()     // Catch:{ IOException -> 0x003f }
                goto L_0x005d
            L_0x003f:
                r0.close()     // Catch:{ IOException -> 0x0092 }
                android.net.Uri r5 = r8.f2568b     // Catch:{ IOException -> 0x0092 }
                java.io.InputStream r0 = r8.e(r5)     // Catch:{ IOException -> 0x0092 }
                if (r0 != 0) goto L_0x005d
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0092 }
                r4.<init>()     // Catch:{ IOException -> 0x0092 }
                r4.append(r9)     // Catch:{ IOException -> 0x0092 }
                android.net.Uri r5 = r8.f2568b     // Catch:{ IOException -> 0x0092 }
                r4.append(r5)     // Catch:{ IOException -> 0x0092 }
                if (r0 == 0) goto L_0x005c
                r0.close()     // Catch:{ IOException -> 0x005c }
            L_0x005c:
                return r3
            L_0x005d:
                r4.inJustDecodeBounds = r1     // Catch:{ IOException -> 0x0092 }
                androidx.mediarouter.app.c r5 = androidx.mediarouter.app.c.this     // Catch:{ IOException -> 0x0092 }
                int r6 = r4.outWidth     // Catch:{ IOException -> 0x0092 }
                int r7 = r4.outHeight     // Catch:{ IOException -> 0x0092 }
                int r5 = r5.i(r6, r7)     // Catch:{ IOException -> 0x0092 }
                int r6 = r4.outHeight     // Catch:{ IOException -> 0x0092 }
                int r6 = r6 / r5
                int r5 = java.lang.Integer.highestOneBit(r6)     // Catch:{ IOException -> 0x0092 }
                int r5 = java.lang.Math.max(r2, r5)     // Catch:{ IOException -> 0x0092 }
                r4.inSampleSize = r5     // Catch:{ IOException -> 0x0092 }
                boolean r5 = r8.isCancelled()     // Catch:{ IOException -> 0x0092 }
                if (r5 == 0) goto L_0x0080
                r0.close()     // Catch:{ IOException -> 0x007f }
            L_0x007f:
                return r3
            L_0x0080:
                android.graphics.Bitmap r9 = android.graphics.BitmapFactory.decodeStream(r0, r3, r4)     // Catch:{ IOException -> 0x0092 }
                r0.close()     // Catch:{ IOException -> 0x0088 }
                goto L_0x0089
            L_0x0088:
            L_0x0089:
                r0 = r9
                goto L_0x00b0
            L_0x008b:
                r0.close()     // Catch:{ IOException -> 0x008e }
            L_0x008e:
                return r3
            L_0x008f:
                r9 = move-exception
                goto L_0x00a9
            L_0x0091:
                r0 = r3
            L_0x0092:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a7 }
                r4.<init>()     // Catch:{ all -> 0x00a7 }
                r4.append(r9)     // Catch:{ all -> 0x00a7 }
                android.net.Uri r9 = r8.f2568b     // Catch:{ all -> 0x00a7 }
                r4.append(r9)     // Catch:{ all -> 0x00a7 }
                if (r0 == 0) goto L_0x00af
                r0.close()     // Catch:{ IOException -> 0x00a5 }
                goto L_0x00af
            L_0x00a5:
                goto L_0x00af
            L_0x00a7:
                r9 = move-exception
                r3 = r0
            L_0x00a9:
                if (r3 == 0) goto L_0x00ae
                r3.close()     // Catch:{ IOException -> 0x00ae }
            L_0x00ae:
                throw r9
            L_0x00af:
                r0 = r3
            L_0x00b0:
                boolean r9 = androidx.mediarouter.app.c.l(r0)
                if (r9 == 0) goto L_0x00c4
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                java.lang.String r1 = "Can't use recycled bitmap: "
                r9.append(r1)
                r9.append(r0)
                return r3
            L_0x00c4:
                if (r0 == 0) goto L_0x00f8
                int r9 = r0.getWidth()
                int r3 = r0.getHeight()
                if (r9 >= r3) goto L_0x00f8
                p0.b$b r9 = new p0.b$b
                r9.<init>(r0)
                p0.b$b r9 = r9.c(r2)
                p0.b r9 = r9.a()
                java.util.List r2 = r9.f()
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L_0x00e8
                goto L_0x00f6
            L_0x00e8:
                java.util.List r9 = r9.f()
                java.lang.Object r9 = r9.get(r1)
                p0.b$d r9 = (p0.b.d) r9
                int r1 = r9.e()
            L_0x00f6:
                r8.f2569c = r1
            L_0x00f8:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.n.doInBackground(java.lang.Void[]):android.graphics.Bitmap");
        }

        public Bitmap b() {
            return this.f2567a;
        }

        public Uri c() {
            return this.f2568b;
        }

        /* renamed from: d */
        public void onPostExecute(Bitmap bitmap) {
            c cVar = c.this;
            cVar.W = null;
            if (!a0.c.a(cVar.X, this.f2567a) || !a0.c.a(c.this.Y, this.f2568b)) {
                c cVar2 = c.this;
                cVar2.X = this.f2567a;
                cVar2.f2511f0 = bitmap;
                cVar2.Y = this.f2568b;
                cVar2.f2513g0 = this.f2569c;
                boolean z10 = true;
                cVar2.Z = true;
                long uptimeMillis = SystemClock.uptimeMillis() - this.f2570d;
                c cVar3 = c.this;
                if (uptimeMillis <= 120) {
                    z10 = false;
                }
                cVar3.y(z10);
            }
        }

        public final InputStream e(Uri uri) {
            InputStream inputStream;
            String lowerCase = uri.getScheme().toLowerCase();
            if ("android.resource".equals(lowerCase) || "content".equals(lowerCase) || "file".equals(lowerCase)) {
                inputStream = c.this.f2508d.getContentResolver().openInputStream(uri);
            } else {
                URLConnection openConnection = new URL(uri.toString()).openConnection();
                int i10 = c.f2504w0;
                openConnection.setConnectTimeout(i10);
                openConnection.setReadTimeout(i10);
                inputStream = openConnection.getInputStream();
            }
            if (inputStream == null) {
                return null;
            }
            return new BufferedInputStream(inputStream);
        }

        public void onPreExecute() {
            this.f2570d = SystemClock.uptimeMillis();
            c.this.f();
        }
    }

    public final class o extends MediaControllerCompat.a {
        public o() {
        }

        public void d(MediaMetadataCompat mediaMetadataCompat) {
            MediaDescriptionCompat mediaDescriptionCompat;
            c cVar = c.this;
            if (mediaMetadataCompat == null) {
                mediaDescriptionCompat = null;
            } else {
                mediaDescriptionCompat = mediaMetadataCompat.e();
            }
            cVar.V = mediaDescriptionCompat;
            c.this.z();
            c.this.y(false);
        }

        public void e(PlaybackStateCompat playbackStateCompat) {
            c cVar = c.this;
            cVar.S = playbackStateCompat;
            cVar.y(false);
        }

        public void i() {
            c cVar = c.this;
            MediaControllerCompat mediaControllerCompat = cVar.O;
            if (mediaControllerCompat != null) {
                mediaControllerCompat.g(cVar.Q);
                c.this.O = null;
            }
        }
    }

    public final class p extends t0.b {
        public p() {
        }

        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            c.this.y(true);
        }

        public void onRouteUnselected(t0 t0Var, t0.i iVar) {
            c.this.y(false);
        }

        public void onRouteVolumeChanged(t0 t0Var, t0.i iVar) {
            SeekBar seekBar = (SeekBar) c.this.N.get(iVar);
            int s10 = iVar.s();
            if (c.f2503v0) {
                StringBuilder sb = new StringBuilder();
                sb.append("onRouteVolumeChanged(), route.getVolume:");
                sb.append(s10);
            }
            if (seekBar != null && c.this.I != iVar) {
                seekBar.setProgress(s10);
            }
        }
    }

    public class q implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f2574a = new a();

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                c cVar = c.this;
                if (cVar.I != null) {
                    cVar.I = null;
                    if (cVar.f2515h0) {
                        cVar.y(cVar.f2517i0);
                    }
                }
            }
        }

        public q() {
        }

        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                t0.i iVar = (t0.i) seekBar.getTag();
                if (c.f2503v0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("onProgressChanged(): calling MediaRouter.RouteInfo.requestSetVolume(");
                    sb.append(i10);
                    sb.append(")");
                }
                iVar.G(i10);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
            c cVar = c.this;
            if (cVar.I != null) {
                cVar.G.removeCallbacks(this.f2574a);
            }
            c.this.I = (t0.i) seekBar.getTag();
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            c.this.G.postDelayed(this.f2574a, 500);
        }
    }

    public class r extends ArrayAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final float f2577a;

        public r(Context context, List list) {
            super(context, 0, list);
            this.f2577a = i.h(context);
        }

        public View getView(int i10, View view, ViewGroup viewGroup) {
            int i11;
            int i12 = 0;
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mr_controller_volume_item, viewGroup, false);
            } else {
                c.this.G(view);
            }
            t0.i iVar = (t0.i) getItem(i10);
            if (iVar != null) {
                boolean x10 = iVar.x();
                TextView textView = (TextView) view.findViewById(R$id.mr_name);
                textView.setEnabled(x10);
                textView.setText(iVar.m());
                MediaRouteVolumeSlider mediaRouteVolumeSlider = (MediaRouteVolumeSlider) view.findViewById(R$id.mr_volume_slider);
                i.w(viewGroup.getContext(), mediaRouteVolumeSlider, c.this.A);
                mediaRouteVolumeSlider.setTag(iVar);
                c.this.N.put(iVar, mediaRouteVolumeSlider);
                mediaRouteVolumeSlider.c(!x10);
                mediaRouteVolumeSlider.setEnabled(x10);
                if (x10) {
                    if (c.this.q(iVar)) {
                        mediaRouteVolumeSlider.setMax(iVar.u());
                        mediaRouteVolumeSlider.setProgress(iVar.s());
                        mediaRouteVolumeSlider.setOnSeekBarChangeListener(c.this.H);
                    } else {
                        mediaRouteVolumeSlider.setMax(100);
                        mediaRouteVolumeSlider.setProgress(100);
                        mediaRouteVolumeSlider.setEnabled(false);
                    }
                }
                ImageView imageView = (ImageView) view.findViewById(R$id.mr_volume_item_icon);
                if (x10) {
                    i11 = 255;
                } else {
                    i11 = (int) (this.f2577a * 255.0f);
                }
                imageView.setAlpha(i11);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.volume_item_container);
                if (c.this.F.contains(iVar)) {
                    i12 = 4;
                }
                linearLayout.setVisibility(i12);
                Set set = c.this.D;
                if (set != null && set.contains(iVar)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration(0);
                    alphaAnimation.setFillEnabled(true);
                    alphaAnimation.setFillAfter(true);
                    view.clearAnimation();
                    view.startAnimation(alphaAnimation);
                }
            }
            return view;
        }

        public boolean isEnabled(int i10) {
            return false;
        }
    }

    public c(Context context) {
        this(context, 0);
    }

    public static boolean H(Uri uri, Uri uri2) {
        if (uri != null && uri.equals(uri2)) {
            return true;
        }
        if (uri == null && uri2 == null) {
            return true;
        }
        return false;
    }

    public static int j(View view) {
        return view.getLayoutParams().height;
    }

    public static boolean l(Bitmap bitmap) {
        if (bitmap == null || !bitmap.isRecycled()) {
            return false;
        }
        return true;
    }

    public static void u(View view, int i10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i10;
        view.setLayoutParams(layoutParams);
    }

    public void A() {
        int b10 = f.b(this.f2508d);
        getWindow().setLayout(b10, -2);
        View decorView = getWindow().getDecorView();
        this.f2512g = (b10 - decorView.getPaddingLeft()) - decorView.getPaddingRight();
        Resources resources = this.f2508d.getResources();
        this.J = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_icon_size);
        this.K = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_item_height);
        this.L = resources.getDimensionPixelSize(R$dimen.mr_controller_volume_group_list_max_height);
        this.X = null;
        this.Y = null;
        z();
        y(false);
    }

    public void B(boolean z10) {
        this.f2530p.requestLayout();
        this.f2530p.getViewTreeObserver().addOnGlobalLayoutListener(new i(z10));
    }

    public void C(boolean z10) {
        int i10;
        int i11;
        boolean z11;
        Bitmap bitmap;
        ImageView.ScaleType scaleType;
        int j10 = j(this.f2543w);
        u(this.f2543w, -1);
        D(d());
        View decorView = getWindow().getDecorView();
        boolean z12 = false;
        decorView.measure(View.MeasureSpec.makeMeasureSpec(getWindow().getAttributes().width, Ints.MAX_POWER_OF_TWO), 0);
        u(this.f2543w, j10);
        if (this.f2514h != null || !(this.f2534r.getDrawable() instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) this.f2534r.getDrawable()).getBitmap()) == null) {
            i10 = 0;
        } else {
            i10 = i(bitmap.getWidth(), bitmap.getHeight());
            ImageView imageView = this.f2534r;
            if (bitmap.getWidth() >= bitmap.getHeight()) {
                scaleType = ImageView.ScaleType.FIT_XY;
            } else {
                scaleType = ImageView.ScaleType.FIT_CENTER;
            }
            imageView.setScaleType(scaleType);
        }
        int k10 = k(d());
        int size = this.C.size();
        if (this.f2507c.y()) {
            i11 = this.K * this.f2507c.l().size();
        } else {
            i11 = 0;
        }
        if (size > 0) {
            i11 += this.M;
        }
        int min = Math.min(i11, this.L);
        if (!this.f2519j0) {
            min = 0;
        }
        int max = Math.max(i10, min) + k10;
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        int height = rect.height() - (this.f2528o.getMeasuredHeight() - this.f2530p.getMeasuredHeight());
        if (this.f2514h != null || i10 <= 0 || max > height) {
            if (j(this.A) + this.f2543w.getMeasuredHeight() >= this.f2530p.getMeasuredHeight()) {
                this.f2534r.setVisibility(8);
            }
            max = min + k10;
            i10 = 0;
        } else {
            this.f2534r.setVisibility(0);
            u(this.f2534r, i10);
        }
        if (!d() || max > height) {
            this.f2544x.setVisibility(8);
        } else {
            this.f2544x.setVisibility(0);
        }
        if (this.f2544x.getVisibility() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        D(z11);
        if (this.f2544x.getVisibility() == 0) {
            z12 = true;
        }
        int k11 = k(z12);
        int max2 = Math.max(i10, min) + k11;
        if (max2 > height) {
            min -= max2 - height;
        } else {
            height = max2;
        }
        this.f2543w.clearAnimation();
        this.A.clearAnimation();
        this.f2530p.clearAnimation();
        if (z10) {
            c(this.f2543w, k11);
            c(this.A, min);
            c(this.f2530p, height);
        } else {
            u(this.f2543w, k11);
            u(this.A, min);
            u(this.f2530p, height);
        }
        u(this.f2526n, rect.height());
        t(z10);
    }

    public final void D(boolean z10) {
        int i10;
        View view = this.f2546z;
        int i11 = 0;
        if (this.f2545y.getVisibility() != 0 || !z10) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        view.setVisibility(i10);
        LinearLayout linearLayout = this.f2543w;
        if (this.f2545y.getVisibility() == 8 && !z10) {
            i11 = 8;
        }
        linearLayout.setVisibility(i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E() {
        /*
            r8 = this;
            boolean r0 = r8.d()
            if (r0 == 0) goto L_0x00ed
            android.support.v4.media.MediaDescriptionCompat r0 = r8.V
            r1 = 0
            if (r0 != 0) goto L_0x000d
            r0 = r1
            goto L_0x0011
        L_0x000d:
            java.lang.CharSequence r0 = r0.f()
        L_0x0011:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            r3 = 1
            r2 = r2 ^ r3
            android.support.v4.media.MediaDescriptionCompat r4 = r8.V
            if (r4 != 0) goto L_0x001c
            goto L_0x0020
        L_0x001c:
            java.lang.CharSequence r1 = r4.e()
        L_0x0020:
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r4 = r4 ^ r3
            n0.t0$i r5 = r8.f2507c
            int r5 = r5.p()
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L_0x0039
            android.widget.TextView r0 = r8.f2536s
            int r1 = androidx.mediarouter.R$string.mr_controller_casting_screen
            r0.setText(r1)
        L_0x0036:
            r0 = 1
        L_0x0037:
            r1 = 0
            goto L_0x006b
        L_0x0039:
            android.support.v4.media.session.PlaybackStateCompat r5 = r8.S
            if (r5 == 0) goto L_0x0063
            int r5 = r5.g()
            if (r5 != 0) goto L_0x0044
            goto L_0x0063
        L_0x0044:
            if (r2 != 0) goto L_0x0050
            if (r4 != 0) goto L_0x0050
            android.widget.TextView r0 = r8.f2536s
            int r1 = androidx.mediarouter.R$string.mr_controller_no_info_available
            r0.setText(r1)
            goto L_0x0036
        L_0x0050:
            if (r2 == 0) goto L_0x0059
            android.widget.TextView r2 = r8.f2536s
            r2.setText(r0)
            r0 = 1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            if (r4 == 0) goto L_0x0037
            android.widget.TextView r2 = r8.f2538t
            r2.setText(r1)
            r1 = 1
            goto L_0x006b
        L_0x0063:
            android.widget.TextView r0 = r8.f2536s
            int r1 = androidx.mediarouter.R$string.mr_controller_no_media_selected
            r0.setText(r1)
            goto L_0x0036
        L_0x006b:
            android.widget.TextView r2 = r8.f2536s
            r4 = 8
            if (r0 == 0) goto L_0x0073
            r0 = 0
            goto L_0x0075
        L_0x0073:
            r0 = 8
        L_0x0075:
            r2.setVisibility(r0)
            android.widget.TextView r0 = r8.f2538t
            if (r1 == 0) goto L_0x007e
            r1 = 0
            goto L_0x0080
        L_0x007e:
            r1 = 8
        L_0x0080:
            r0.setVisibility(r1)
            android.support.v4.media.session.PlaybackStateCompat r0 = r8.S
            if (r0 == 0) goto L_0x00ed
            int r0 = r0.g()
            r1 = 6
            if (r0 == r1) goto L_0x009a
            android.support.v4.media.session.PlaybackStateCompat r0 = r8.S
            int r0 = r0.g()
            r1 = 3
            if (r0 != r1) goto L_0x0098
            goto L_0x009a
        L_0x0098:
            r0 = 0
            goto L_0x009b
        L_0x009a:
            r0 = 1
        L_0x009b:
            android.widget.ImageButton r1 = r8.f2520k
            android.content.Context r1 = r1.getContext()
            if (r0 == 0) goto L_0x00ae
            boolean r2 = r8.n()
            if (r2 == 0) goto L_0x00ae
            int r0 = androidx.mediarouter.R$attr.mediaRoutePauseDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_pause
            goto L_0x00cb
        L_0x00ae:
            if (r0 == 0) goto L_0x00bb
            boolean r2 = r8.p()
            if (r2 == 0) goto L_0x00bb
            int r0 = androidx.mediarouter.R$attr.mediaRouteStopDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_stop
            goto L_0x00cb
        L_0x00bb:
            if (r0 != 0) goto L_0x00c8
            boolean r0 = r8.o()
            if (r0 == 0) goto L_0x00c8
            int r0 = androidx.mediarouter.R$attr.mediaRoutePlayDrawable
            int r2 = androidx.mediarouter.R$string.mr_controller_play
            goto L_0x00cb
        L_0x00c8:
            r0 = 0
            r2 = 0
            r3 = 0
        L_0x00cb:
            android.widget.ImageButton r5 = r8.f2520k
            if (r3 == 0) goto L_0x00d0
            goto L_0x00d2
        L_0x00d0:
            r7 = 8
        L_0x00d2:
            r5.setVisibility(r7)
            if (r3 == 0) goto L_0x00ed
            android.widget.ImageButton r3 = r8.f2520k
            int r0 = androidx.mediarouter.app.i.p(r1, r0)
            r3.setImageResource(r0)
            android.widget.ImageButton r0 = r8.f2520k
            android.content.res.Resources r1 = r1.getResources()
            java.lang.CharSequence r1 = r1.getText(r2)
            r0.setContentDescription(r1)
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.E():void");
    }

    public final void F() {
        int i10 = 8;
        if (!q(this.f2507c)) {
            this.f2545y.setVisibility(8);
        } else if (this.f2545y.getVisibility() == 8) {
            this.f2545y.setVisibility(0);
            this.G.setMax(this.f2507c.u());
            this.G.setProgress(this.f2507c.s());
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = this.f2524m;
            if (this.f2507c.y()) {
                i10 = 0;
            }
            mediaRouteExpandCollapseButton.setVisibility(i10);
        }
    }

    public void G(View view) {
        u((LinearLayout) view.findViewById(R$id.volume_item_container), this.K);
        View findViewById = view.findViewById(R$id.mr_volume_item_icon);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        int i10 = this.J;
        layoutParams.width = i10;
        layoutParams.height = i10;
        findViewById.setLayoutParams(layoutParams);
    }

    public final void a(Map map, Map map2) {
        this.A.setEnabled(false);
        this.A.requestLayout();
        this.f2521k0 = true;
        this.A.getViewTreeObserver().addOnGlobalLayoutListener(new k(map, map2));
    }

    public void b(Map map, Map map2) {
        OverlayListView.a aVar;
        int i10;
        Map map3 = map;
        Set set = this.D;
        if (set != null && this.E != null) {
            int size = set.size() - this.E.size();
            l lVar = new l();
            int firstVisiblePosition = this.A.getFirstVisiblePosition();
            boolean z10 = false;
            for (int i11 = 0; i11 < this.A.getChildCount(); i11++) {
                View childAt = this.A.getChildAt(i11);
                t0.i iVar = (t0.i) this.B.getItem(firstVisiblePosition + i11);
                Rect rect = (Rect) map3.get(iVar);
                int top = childAt.getTop();
                if (rect != null) {
                    i10 = rect.top;
                } else {
                    i10 = (this.K * size) + top;
                }
                AnimationSet animationSet = new AnimationSet(true);
                Set set2 = this.D;
                if (set2 != null && set2.contains(iVar)) {
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.0f);
                    alphaAnimation.setDuration((long) this.f2527n0);
                    animationSet.addAnimation(alphaAnimation);
                    i10 = top;
                }
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (i10 - top), 0.0f);
                translateAnimation.setDuration((long) this.f2525m0);
                animationSet.addAnimation(translateAnimation);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                animationSet.setInterpolator(this.f2531p0);
                if (!z10) {
                    animationSet.setAnimationListener(lVar);
                    z10 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
                map3.remove(iVar);
                map2.remove(iVar);
            }
            Map map4 = map2;
            for (Map.Entry entry : map2.entrySet()) {
                t0.i iVar2 = (t0.i) entry.getKey();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) entry.getValue();
                Rect rect2 = (Rect) map3.get(iVar2);
                if (this.E.contains(iVar2)) {
                    aVar = new OverlayListView.a(bitmapDrawable, rect2).c(1.0f, 0.0f).e((long) this.f2529o0).f(this.f2531p0);
                } else {
                    aVar = new OverlayListView.a(bitmapDrawable, rect2).g(this.K * size).e((long) this.f2525m0).f(this.f2531p0).d(new a(iVar2));
                    this.F.add(iVar2);
                }
                this.A.a(aVar);
            }
        }
    }

    public final void c(View view, int i10) {
        j jVar = new j(j(view), i10, view);
        jVar.setDuration((long) this.f2525m0);
        if (Build.VERSION.SDK_INT >= 21) {
            jVar.setInterpolator(this.f2531p0);
        }
        view.startAnimation(jVar);
    }

    public final boolean d() {
        if (this.f2514h != null || (this.V == null && this.S == null)) {
            return false;
        }
        return true;
    }

    public void e(boolean z10) {
        Set set;
        int firstVisiblePosition = this.A.getFirstVisiblePosition();
        for (int i10 = 0; i10 < this.A.getChildCount(); i10++) {
            View childAt = this.A.getChildAt(i10);
            t0.i iVar = (t0.i) this.B.getItem(firstVisiblePosition + i10);
            if (!z10 || (set = this.D) == null || !set.contains(iVar)) {
                ((LinearLayout) childAt.findViewById(R$id.volume_item_container)).setVisibility(0);
                AnimationSet animationSet = new AnimationSet(true);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation.setDuration(0);
                animationSet.addAnimation(alphaAnimation);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0);
                animationSet.setFillAfter(true);
                animationSet.setFillEnabled(true);
                childAt.clearAnimation();
                childAt.startAnimation(animationSet);
            }
        }
        this.A.c();
        if (!z10) {
            h(false);
        }
    }

    public void f() {
        this.Z = false;
        this.f2511f0 = null;
        this.f2513g0 = 0;
    }

    public final void g() {
        C0037c cVar = new C0037c();
        int firstVisiblePosition = this.A.getFirstVisiblePosition();
        boolean z10 = false;
        for (int i10 = 0; i10 < this.A.getChildCount(); i10++) {
            View childAt = this.A.getChildAt(i10);
            r rVar = this.B;
            if (this.D.contains((t0.i) rVar.getItem(firstVisiblePosition + i10))) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration((long) this.f2527n0);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillAfter(true);
                if (!z10) {
                    alphaAnimation.setAnimationListener(cVar);
                    z10 = true;
                }
                childAt.clearAnimation();
                childAt.startAnimation(alphaAnimation);
            }
        }
    }

    public void h(boolean z10) {
        this.D = null;
        this.E = null;
        this.f2521k0 = false;
        if (this.f2523l0) {
            this.f2523l0 = false;
            B(z10);
        }
        this.A.setEnabled(true);
    }

    public int i(int i10, int i11) {
        if (i10 >= i11) {
            return (int) (((((float) this.f2512g) * ((float) i11)) / ((float) i10)) + 0.5f);
        }
        return (int) (((((float) this.f2512g) * 9.0f) / 16.0f) + 0.5f);
    }

    public final int k(boolean z10) {
        if (!z10 && this.f2545y.getVisibility() != 0) {
            return 0;
        }
        int paddingTop = 0 + this.f2543w.getPaddingTop() + this.f2543w.getPaddingBottom();
        if (z10) {
            paddingTop += this.f2544x.getMeasuredHeight();
        }
        if (this.f2545y.getVisibility() == 0) {
            paddingTop += this.f2545y.getMeasuredHeight();
        }
        if (!z10 || this.f2545y.getVisibility() != 0) {
            return paddingTop;
        }
        return paddingTop + this.f2546z.getMeasuredHeight();
    }

    public final boolean m() {
        Bitmap bitmap;
        Bitmap bitmap2;
        Uri uri;
        MediaDescriptionCompat mediaDescriptionCompat = this.V;
        Uri uri2 = null;
        if (mediaDescriptionCompat == null) {
            bitmap = null;
        } else {
            bitmap = mediaDescriptionCompat.b();
        }
        MediaDescriptionCompat mediaDescriptionCompat2 = this.V;
        if (mediaDescriptionCompat2 != null) {
            uri2 = mediaDescriptionCompat2.c();
        }
        n nVar = this.W;
        if (nVar == null) {
            bitmap2 = this.X;
        } else {
            bitmap2 = nVar.b();
        }
        n nVar2 = this.W;
        if (nVar2 == null) {
            uri = this.Y;
        } else {
            uri = nVar2.c();
        }
        if (bitmap2 != bitmap) {
            return true;
        }
        if (bitmap2 != null || H(uri, uri2)) {
            return false;
        }
        return true;
    }

    public boolean n() {
        if ((this.S.b() & 514) != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.S.b() & 516) != 0) {
            return true;
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2510f = true;
        this.f2505a.b(s0.f8047c, this.f2506b, 2);
        v(this.f2505a.j());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawableResource(17170445);
        setContentView(R$layout.mr_controller_material_dialog_b);
        findViewById(16908315).setVisibility(8);
        m mVar = new m();
        FrameLayout frameLayout = (FrameLayout) findViewById(R$id.mr_expandable_area);
        this.f2526n = frameLayout;
        frameLayout.setOnClickListener(new e());
        LinearLayout linearLayout = (LinearLayout) findViewById(R$id.mr_dialog_area);
        this.f2528o = linearLayout;
        linearLayout.setOnClickListener(new f());
        int d10 = i.d(this.f2508d);
        Button button = (Button) findViewById(16908314);
        this.f2516i = button;
        button.setText(R$string.mr_controller_disconnect);
        this.f2516i.setTextColor(d10);
        this.f2516i.setOnClickListener(mVar);
        Button button2 = (Button) findViewById(16908313);
        this.f2518j = button2;
        button2.setText(R$string.mr_controller_stop_casting);
        this.f2518j.setTextColor(d10);
        this.f2518j.setOnClickListener(mVar);
        this.f2540u = (TextView) findViewById(R$id.mr_name);
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_close);
        this.f2522l = imageButton;
        imageButton.setOnClickListener(mVar);
        this.f2532q = (FrameLayout) findViewById(R$id.mr_custom_control);
        this.f2530p = (FrameLayout) findViewById(R$id.mr_default_control);
        g gVar = new g();
        ImageView imageView = (ImageView) findViewById(R$id.mr_art);
        this.f2534r = imageView;
        imageView.setOnClickListener(gVar);
        findViewById(R$id.mr_control_title_container).setOnClickListener(gVar);
        this.f2543w = (LinearLayout) findViewById(R$id.mr_media_main_control);
        this.f2546z = findViewById(R$id.mr_control_divider);
        this.f2544x = (RelativeLayout) findViewById(R$id.mr_playback_control);
        this.f2536s = (TextView) findViewById(R$id.mr_control_title);
        this.f2538t = (TextView) findViewById(R$id.mr_control_subtitle);
        ImageButton imageButton2 = (ImageButton) findViewById(R$id.mr_control_playback_ctrl);
        this.f2520k = imageButton2;
        imageButton2.setOnClickListener(mVar);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R$id.mr_volume_control);
        this.f2545y = linearLayout2;
        linearLayout2.setVisibility(8);
        SeekBar seekBar = (SeekBar) findViewById(R$id.mr_volume_slider);
        this.G = seekBar;
        seekBar.setTag(this.f2507c);
        q qVar = new q();
        this.H = qVar;
        this.G.setOnSeekBarChangeListener(qVar);
        this.A = (OverlayListView) findViewById(R$id.mr_volume_group_list);
        this.C = new ArrayList();
        r rVar = new r(this.A.getContext(), this.C);
        this.B = rVar;
        this.A.setAdapter(rVar);
        this.F = new HashSet();
        i.u(this.f2508d, this.f2543w, this.A, this.f2507c.y());
        i.w(this.f2508d, (MediaRouteVolumeSlider) this.G, this.f2543w);
        HashMap hashMap = new HashMap();
        this.N = hashMap;
        hashMap.put(this.f2507c, this.G);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = (MediaRouteExpandCollapseButton) findViewById(R$id.mr_group_expand_collapse);
        this.f2524m = mediaRouteExpandCollapseButton;
        mediaRouteExpandCollapseButton.setOnClickListener(new h());
        r();
        this.f2525m0 = this.f2508d.getResources().getInteger(R$integer.mr_controller_volume_group_list_animation_duration_ms);
        this.f2527n0 = this.f2508d.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_in_duration_ms);
        this.f2529o0 = this.f2508d.getResources().getInteger(R$integer.mr_controller_volume_group_list_fade_out_duration_ms);
        View s10 = s(bundle);
        this.f2514h = s10;
        if (s10 != null) {
            this.f2532q.addView(s10);
            this.f2532q.setVisibility(0);
        }
        this.f2509e = true;
        A();
    }

    public void onDetachedFromWindow() {
        this.f2505a.q(this.f2506b);
        v((MediaSessionCompat.Token) null);
        this.f2510f = false;
        super.onDetachedFromWindow();
    }

    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        int i11;
        if (i10 != 25 && i10 != 24) {
            return super.onKeyDown(i10, keyEvent);
        }
        t0.i iVar = this.f2507c;
        if (i10 == 25) {
            i11 = -1;
        } else {
            i11 = 1;
        }
        iVar.H(i11);
        return true;
    }

    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 == 25 || i10 == 24) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    public boolean p() {
        if ((this.S.b() & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean q(t0.i iVar) {
        if (!this.f2542v || iVar.t() != 1) {
            return false;
        }
        return true;
    }

    public void r() {
        Interpolator interpolator;
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f2519j0) {
                interpolator = this.f2533q0;
            } else {
                interpolator = this.f2535r0;
            }
            this.f2531p0 = interpolator;
            return;
        }
        this.f2531p0 = this.f2537s0;
    }

    public View s(Bundle bundle) {
        return null;
    }

    public final void t(boolean z10) {
        HashMap hashMap;
        HashMap hashMap2;
        List l10 = this.f2507c.l();
        if (l10.isEmpty()) {
            this.C.clear();
            this.B.notifyDataSetChanged();
        } else if (f.i(this.C, l10)) {
            this.B.notifyDataSetChanged();
        } else {
            if (z10) {
                hashMap = f.e(this.A, this.B);
            } else {
                hashMap = null;
            }
            if (z10) {
                hashMap2 = f.d(this.f2508d, this.A, this.B);
            } else {
                hashMap2 = null;
            }
            this.D = f.f(this.C, l10);
            this.E = f.g(this.C, l10);
            this.C.addAll(0, this.D);
            this.C.removeAll(this.E);
            this.B.notifyDataSetChanged();
            if (!z10 || !this.f2519j0 || this.D.size() + this.E.size() <= 0) {
                this.D = null;
                this.E = null;
                return;
            }
            a(hashMap, hashMap2);
        }
    }

    public final void v(MediaSessionCompat.Token token) {
        MediaControllerCompat mediaControllerCompat = this.O;
        MediaDescriptionCompat mediaDescriptionCompat = null;
        if (mediaControllerCompat != null) {
            mediaControllerCompat.g(this.Q);
            this.O = null;
        }
        if (token != null && this.f2510f) {
            MediaControllerCompat mediaControllerCompat2 = new MediaControllerCompat(this.f2508d, token);
            this.O = mediaControllerCompat2;
            mediaControllerCompat2.e(this.Q);
            MediaMetadataCompat a10 = this.O.a();
            if (a10 != null) {
                mediaDescriptionCompat = a10.e();
            }
            this.V = mediaDescriptionCompat;
            this.S = this.O.b();
            z();
            y(false);
        }
    }

    public void w() {
        e(true);
        this.A.requestLayout();
        this.A.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    public void x() {
        Set set = this.D;
        if (set == null || set.size() == 0) {
            h(true);
        } else {
            g();
        }
    }

    public void y(boolean z10) {
        if (this.I != null) {
            this.f2515h0 = true;
            this.f2517i0 = z10 | this.f2517i0;
            return;
        }
        int i10 = 0;
        this.f2515h0 = false;
        this.f2517i0 = false;
        if (!this.f2507c.C() || this.f2507c.w()) {
            dismiss();
        } else if (this.f2509e) {
            this.f2540u.setText(this.f2507c.m());
            Button button = this.f2516i;
            if (!this.f2507c.a()) {
                i10 = 8;
            }
            button.setVisibility(i10);
            if (this.f2514h == null && this.Z) {
                if (l(this.f2511f0)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't set artwork image with recycled bitmap: ");
                    sb.append(this.f2511f0);
                } else {
                    this.f2534r.setImageBitmap(this.f2511f0);
                    this.f2534r.setBackgroundColor(this.f2513g0);
                }
                f();
            }
            F();
            E();
            B(z10);
        }
    }

    public void z() {
        if (this.f2514h == null && m()) {
            n nVar = this.W;
            if (nVar != null) {
                nVar.cancel(true);
            }
            n nVar2 = new n();
            this.W = nVar2;
            nVar2.execute(new Void[0]);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 1
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            r1.f2542v = r0
            androidx.mediarouter.app.c$d r3 = new androidx.mediarouter.app.c$d
            r3.<init>()
            r1.f2541u0 = r3
            android.content.Context r3 = r1.getContext()
            r1.f2508d = r3
            androidx.mediarouter.app.c$o r3 = new androidx.mediarouter.app.c$o
            r3.<init>()
            r1.Q = r3
            android.content.Context r3 = r1.f2508d
            n0.t0 r3 = n0.t0.i(r3)
            r1.f2505a = r3
            androidx.mediarouter.app.c$p r0 = new androidx.mediarouter.app.c$p
            r0.<init>()
            r1.f2506b = r0
            n0.t0$i r0 = r3.m()
            r1.f2507c = r0
            android.support.v4.media.session.MediaSessionCompat$Token r3 = r3.j()
            r1.v(r3)
            android.content.Context r3 = r1.f2508d
            android.content.res.Resources r3 = r3.getResources()
            int r0 = androidx.mediarouter.R$dimen.mr_controller_volume_group_list_padding_top
            int r3 = r3.getDimensionPixelSize(r0)
            r1.M = r3
            android.content.Context r3 = r1.f2508d
            java.lang.String r0 = "accessibility"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r3 = (android.view.accessibility.AccessibilityManager) r3
            r1.f2539t0 = r3
            int r3 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r3 < r0) goto L_0x006e
            int r3 = androidx.mediarouter.R$interpolator.mr_linear_out_slow_in
            android.view.animation.Interpolator r3 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f2533q0 = r3
            int r3 = androidx.mediarouter.R$interpolator.mr_fast_out_slow_in
            android.view.animation.Interpolator r2 = android.view.animation.AnimationUtils.loadInterpolator(r2, r3)
            r1.f2535r0 = r2
        L_0x006e:
            android.view.animation.AccelerateDecelerateInterpolator r2 = new android.view.animation.AccelerateDecelerateInterpolator
            r2.<init>()
            r1.f2537s0 = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.c.<init>(android.content.Context, int):void");
    }
}
