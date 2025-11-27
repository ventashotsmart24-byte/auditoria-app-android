package t0;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.File;

public interface c extends Closeable {

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f9341a;

        public a(int i10) {
            this.f9341a = i10;
        }

        public final void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("deleting the database file: ");
                sb.append(str);
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public void b(b bVar) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0034, code lost:
            if (r0 != null) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
            r3 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
            if (r3.hasNext() != false) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
            a((java.lang.String) ((android.util.Pair) r3.next()).second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
            a(r3.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0055, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0030 */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:7:0x002e A[ExcHandler: all (r1v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v10 java.util.List) = (r0v3 java.util.List), (r0v4 java.util.List), (r0v4 java.util.List) binds: [B:5:0x0029, B:8:0x0030, B:9:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0029] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void c(t0.b r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Corruption reported by sqlite on database: "
                r0.append(r1)
                java.lang.String r1 = r3.getPath()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                java.lang.String r1 = "SupportSQLite"
                android.util.Log.e(r1, r0)
                boolean r0 = r3.isOpen()
                if (r0 != 0) goto L_0x0028
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
                return
            L_0x0028:
                r0 = 0
                java.util.List r0 = r3.i()     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
                goto L_0x0030
            L_0x002e:
                r1 = move-exception
                goto L_0x0034
            L_0x0030:
                r3.close()     // Catch:{ IOException -> 0x0056, all -> 0x002e }
                goto L_0x0057
            L_0x0034:
                if (r0 == 0) goto L_0x004e
                java.util.Iterator r3 = r0.iterator()
            L_0x003a:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0055
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x003a
            L_0x004e:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x0055:
                throw r1
            L_0x0056:
            L_0x0057:
                if (r0 == 0) goto L_0x0071
                java.util.Iterator r3 = r0.iterator()
            L_0x005d:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x0078
                java.lang.Object r0 = r3.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r2.a(r0)
                goto L_0x005d
            L_0x0071:
                java.lang.String r3 = r3.getPath()
                r2.a(r3)
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t0.c.a.c(t0.b):void");
        }

        public abstract void d(b bVar);

        public abstract void e(b bVar, int i10, int i11);

        public void f(b bVar) {
        }

        public abstract void g(b bVar, int i10, int i11);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9342a;

        /* renamed from: b  reason: collision with root package name */
        public final String f9343b;

        /* renamed from: c  reason: collision with root package name */
        public final a f9344c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f9345d;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public Context f9346a;

            /* renamed from: b  reason: collision with root package name */
            public String f9347b;

            /* renamed from: c  reason: collision with root package name */
            public a f9348c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f9349d;

            public a(Context context) {
                this.f9346a = context;
            }

            public b a() {
                if (this.f9348c == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.f9346a == null) {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                } else if (!this.f9349d || !TextUtils.isEmpty(this.f9347b)) {
                    return new b(this.f9346a, this.f9347b, this.f9348c, this.f9349d);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            public a b(a aVar) {
                this.f9348c = aVar;
                return this;
            }

            public a c(String str) {
                this.f9347b = str;
                return this;
            }

            public a d(boolean z10) {
                this.f9349d = z10;
                return this;
            }
        }

        public b(Context context, String str, a aVar, boolean z10) {
            this.f9342a = context;
            this.f9343b = str;
            this.f9344c = aVar;
            this.f9345d = z10;
        }

        public static a a(Context context) {
            return new a(context);
        }
    }

    /* renamed from: t0.c$c  reason: collision with other inner class name */
    public interface C0123c {
        c a(b bVar);
    }

    b A();

    void close();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z10);
}
