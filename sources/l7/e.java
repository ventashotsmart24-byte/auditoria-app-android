package l7;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f18677a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    public static final String f18678b = "ExternalSubtitles";

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList f18679c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static SimpleDateFormat f18680d = new SimpleDateFormat("HH:mm:ss,SSS", Locale.getDefault());

    /* renamed from: e  reason: collision with root package name */
    public static long f18681e;

    /* renamed from: f  reason: collision with root package name */
    public static Disposable f18682f;

    /* renamed from: g  reason: collision with root package name */
    public static Disposable f18683g;

    public static final class a {

        /* renamed from: l7.e$a$a  reason: collision with other inner class name */
        public static final class C0269a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ TextView f18684a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ long f18685b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0269a(TextView textView, long j10) {
                super(1);
                this.f18684a = textView;
                this.f18685b = j10;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                e.f18677a.j(this.f18684a, this.f18685b);
            }
        }

        public static final class b extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f18686a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f18686a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                e.f18677a.h(this.f18686a);
            }
        }

        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public static final void k(TextView textView) {
            i.g(textView, "$textView");
            textView.bringToFront();
            if (textView.getVisibility() == 0) {
                textView.setVisibility(4);
                textView.setText("");
            }
        }

        public static final void l(TextView textView, f fVar) {
            i.g(textView, "$textView");
            i.g(fVar, "$srt");
            textView.bringToFront();
            textView.setVisibility(0);
            textView.setText(Html.fromHtml(fVar.a()));
            String unused = e.f18678b;
            fVar.a();
        }

        public static final void n(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void p(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public final void f() {
            Disposable c10 = e.f18682f;
            if (c10 != null) {
                c10.dispose();
            }
            e.f18679c.clear();
            Disposable b10 = e.f18683g;
            if (b10 != null) {
                b10.dispose();
            }
            e.f18682f = null;
            e.f18683g = null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
            r6 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            r6 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
            r2.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x000c] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x004e  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0054  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String g(java.lang.String r6) {
            /*
                r5 = this;
                java.lang.String r0 = "UTF-8"
                r1 = 4096(0x1000, float:5.74E-42)
                r2 = 0
                byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0048 }
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0048 }
                r3.<init>(r6)     // Catch:{ Exception -> 0x0048 }
                za.c r6 = new za.c     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                r6.<init>(r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            L_0x0011:
                int r2 = r3.read(r1)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                if (r2 <= 0) goto L_0x0022
                boolean r4 = r6.d()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                if (r4 != 0) goto L_0x0022
                r4 = 0
                r6.c(r1, r4, r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                goto L_0x0011
            L_0x0022:
                r6.a()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                java.lang.String r1 = r6.b()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                java.lang.String r2 = "detector.detectedCharset"
                t9.i.f(r1, r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x003d, all -> 0x0040 }
                if (r2 == 0) goto L_0x0035
                goto L_0x0036
            L_0x0035:
                r0 = r1
            L_0x0036:
                r6.e()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
                r3.close()
                goto L_0x0051
            L_0x003d:
                r6 = move-exception
                r0 = r1
                goto L_0x0044
            L_0x0040:
                r6 = move-exception
                r2 = r3
                goto L_0x0052
            L_0x0043:
                r6 = move-exception
            L_0x0044:
                r2 = r3
                goto L_0x0049
            L_0x0046:
                r6 = move-exception
                goto L_0x0052
            L_0x0048:
                r6 = move-exception
            L_0x0049:
                r6.printStackTrace()     // Catch:{ all -> 0x0046 }
                if (r2 == 0) goto L_0x0051
                r2.close()
            L_0x0051:
                return r0
            L_0x0052:
                if (r2 == 0) goto L_0x0057
                r2.close()
            L_0x0057:
                goto L_0x0059
            L_0x0058:
                throw r6
            L_0x0059:
                goto L_0x0058
            */
            throw new UnsupportedOperationException("Method not decompiled: l7.e.a.g(java.lang.String):java.lang.String");
        }

        public final synchronized void h(String str) {
            Throwable th;
            String str2 = str;
            synchronized (this) {
                try {
                    e.f18679c.clear();
                    File file = new File(str2);
                    if (file.exists() && file.isFile()) {
                        StringBuffer stringBuffer = new StringBuffer();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str2), g(str)));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                i.f(readLine, "it.readLine() ?: break");
                                if (!i.b(readLine, "")) {
                                    stringBuffer.append(readLine);
                                    stringBuffer.append("@");
                                } else {
                                    List M = ba.t.M(stringBuffer, new String[]{"@"}, false, 0, 6, (Object) null);
                                    if (M.size() < 4) {
                                        stringBuffer.delete(0, stringBuffer.length());
                                    } else {
                                        f fVar = new f();
                                        fVar.f((String) M.get(0));
                                        List M2 = ba.t.M(ba.t.W((String) M.get(1)).toString(), new String[]{"-->"}, false, 0, 6, (Object) null);
                                        if (M2.size() == 2) {
                                            fVar.g(e.f18680d.parse((String) M2.get(0)).getTime() - e.f18680d.parse("00:00:00,000").getTime());
                                            fVar.e(e.f18680d.parse((String) M2.get(1)).getTime() - e.f18680d.parse("00:00:00,000").getTime());
                                        }
                                        StringBuffer stringBuffer2 = new StringBuffer();
                                        for (String append : M.subList(2, M.size() - 1)) {
                                            stringBuffer2.append(append);
                                            stringBuffer2.append("<br>");
                                        }
                                        String str3 = "";
                                        if (ba.t.o(stringBuffer2, "<br>", false, 2, (Object) null)) {
                                            str3 = stringBuffer2.substring(0, stringBuffer2.length() - 4);
                                            i.f(str3, "content.substring(0, con…t.length - \"<br>\".length)");
                                        }
                                        fVar.d(str3);
                                        stringBuffer.delete(0, stringBuffer.length());
                                        e.f18679c.add(fVar);
                                    }
                                }
                            } catch (Throwable th2) {
                                Throwable th3 = th2;
                                q9.a.a(bufferedReader, th);
                                throw th3;
                            }
                        }
                        t tVar = t.f17319a;
                        q9.a.a(bufferedReader, (Throwable) null);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return;
        }

        public final int i(long j10) {
            int size = e.f18679c.size() - 1;
            if (size == 0) {
                return -1;
            }
            int i10 = 0;
            while (i10 <= size) {
                int i11 = (i10 + size) / 2;
                if (j10 < ((f) e.f18679c.get(i11)).c()) {
                    size = i11 - 1;
                } else if (j10 <= ((f) e.f18679c.get(i11)).b()) {
                    return i11;
                } else {
                    i10 = i11 + 1;
                }
            }
            return -1;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x006b, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final synchronized void j(android.widget.TextView r4, long r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.String r0 = "textView"
                t9.i.g(r4, r0)     // Catch:{ all -> 0x006c }
                long r0 = l7.e.f18681e     // Catch:{ all -> 0x006c }
                int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
                if (r2 != 0) goto L_0x0010
                monitor-exit(r3)
                return
            L_0x0010:
                l7.e.f18681e = r5     // Catch:{ all -> 0x006c }
                java.lang.String unused = l7.e.f18678b     // Catch:{ all -> 0x006c }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
                r0.<init>()     // Catch:{ all -> 0x006c }
                java.lang.String r1 = "position: "
                r0.append(r1)     // Catch:{ all -> 0x006c }
                r0.append(r5)     // Catch:{ all -> 0x006c }
                java.lang.String r1 = ", size: "
                r0.append(r1)     // Catch:{ all -> 0x006c }
                java.util.ArrayList r1 = l7.e.f18679c     // Catch:{ all -> 0x006c }
                int r1 = r1.size()     // Catch:{ all -> 0x006c }
                r0.append(r1)     // Catch:{ all -> 0x006c }
                int r5 = r3.i(r5)     // Catch:{ all -> 0x006c }
                java.lang.String unused = l7.e.f18678b     // Catch:{ all -> 0x006c }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
                r6.<init>()     // Catch:{ all -> 0x006c }
                java.lang.String r0 = "searchPos: "
                r6.append(r0)     // Catch:{ all -> 0x006c }
                r6.append(r5)     // Catch:{ all -> 0x006c }
                r6 = -1
                if (r5 != r6) goto L_0x0053
                l7.c r5 = new l7.c     // Catch:{ all -> 0x006c }
                r5.<init>(r4)     // Catch:{ all -> 0x006c }
                r4.post(r5)     // Catch:{ all -> 0x006c }
                goto L_0x006a
            L_0x0053:
                java.util.ArrayList r6 = l7.e.f18679c     // Catch:{ all -> 0x006c }
                java.lang.Object r5 = r6.get(r5)     // Catch:{ all -> 0x006c }
                java.lang.String r6 = "subtitleList[searchPos]"
                t9.i.f(r5, r6)     // Catch:{ all -> 0x006c }
                l7.f r5 = (l7.f) r5     // Catch:{ all -> 0x006c }
                l7.d r6 = new l7.d     // Catch:{ all -> 0x006c }
                r6.<init>(r4, r5)     // Catch:{ all -> 0x006c }
                r4.post(r6)     // Catch:{ all -> 0x006c }
            L_0x006a:
                monitor-exit(r3)
                return
            L_0x006c:
                r4 = move-exception
                monitor-exit(r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: l7.e.a.j(android.widget.TextView, long):void");
        }

        public final void m(TextView textView, long j10) {
            Disposable b10;
            i.g(textView, "textView");
            Disposable b11 = e.f18683g;
            boolean z10 = false;
            if (b11 != null && !b11.isDisposed()) {
                z10 = true;
            }
            if (z10 && (b10 = e.f18683g) != null) {
                b10.dispose();
            }
            e.f18683g = Observable.just("").subscribeOn(Schedulers.io()).subscribe(new b(new C0269a(textView, j10)));
        }

        public final void o(String str) {
            i.g(str, "path");
            f();
            if (TextUtils.isEmpty(str)) {
                Log.e(e.f18678b, "sub path is NULL...");
            } else {
                e.f18682f = Observable.just("").subscribeOn(Schedulers.io()).subscribe(new a(new b(str)));
            }
        }
    }

    public static final void j() {
        f18677a.f();
    }

    public static final void k(TextView textView, long j10) {
        f18677a.m(textView, j10);
    }

    public static final void l(String str) {
        f18677a.o(str);
    }
}
