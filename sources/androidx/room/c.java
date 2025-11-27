package androidx.room;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import q0.e;
import t0.f;

public class c {

    /* renamed from: m  reason: collision with root package name */
    public static final String[] f3032m = {TriggerMethod.UPDATE, "DELETE", TriggerMethod.INSERT};

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f3033a;

    /* renamed from: b  reason: collision with root package name */
    public final String[] f3034b;

    /* renamed from: c  reason: collision with root package name */
    public Map f3035c;

    /* renamed from: d  reason: collision with root package name */
    public final e f3036d;

    /* renamed from: e  reason: collision with root package name */
    public AtomicBoolean f3037e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public volatile boolean f3038f = false;

    /* renamed from: g  reason: collision with root package name */
    public volatile f f3039g;

    /* renamed from: h  reason: collision with root package name */
    public b f3040h;

    /* renamed from: i  reason: collision with root package name */
    public final q0.c f3041i;

    /* renamed from: j  reason: collision with root package name */
    public final i.b f3042j = new i.b();

    /* renamed from: k  reason: collision with root package name */
    public d f3043k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f3044l = new a();

    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final Set a() {
            HashSet hashSet = new HashSet();
            Cursor p10 = c.this.f3036d.p(new t0.a("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (p10.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(p10.getInt(0)));
                } catch (Throwable th) {
                    p10.close();
                    throw th;
                }
            }
            p10.close();
            if (!hashSet.isEmpty()) {
                c.this.f3039g.executeUpdateDelete();
            }
            return hashSet;
        }

        public void run() {
            t0.b A;
            Lock h10 = c.this.f3036d.h();
            Set set = null;
            try {
                h10.lock();
                if (!c.this.c()) {
                    h10.unlock();
                } else if (!c.this.f3037e.compareAndSet(true, false)) {
                    h10.unlock();
                } else if (c.this.f3036d.k()) {
                    h10.unlock();
                } else {
                    e eVar = c.this.f3036d;
                    if (eVar.f8869g) {
                        A = eVar.i().A();
                        A.beginTransaction();
                        set = a();
                        A.setTransactionSuccessful();
                        A.endTransaction();
                    } else {
                        set = a();
                    }
                    h10.unlock();
                    if (set != null && !set.isEmpty()) {
                        synchronized (c.this.f3042j) {
                            Iterator it = c.this.f3042j.iterator();
                            while (it.hasNext()) {
                                ((d) ((Map.Entry) it.next()).getValue()).a(set);
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e10) {
                try {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                } catch (Throwable th) {
                    h10.unlock();
                    throw th;
                }
            } catch (Throwable th2) {
                A.endTransaction();
                throw th2;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f3046a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f3047b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f3048c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3049d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f3050e;

        public b(int i10) {
            long[] jArr = new long[i10];
            this.f3046a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f3047b = zArr;
            this.f3048c = new int[i10];
            Arrays.fill(jArr, 0);
            Arrays.fill(zArr, false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0040, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int[] a() {
            /*
                r9 = this;
                monitor-enter(r9)
                boolean r0 = r9.f3049d     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x003f
                boolean r0 = r9.f3050e     // Catch:{ all -> 0x0042 }
                if (r0 == 0) goto L_0x000a
                goto L_0x003f
            L_0x000a:
                long[] r0 = r9.f3046a     // Catch:{ all -> 0x0042 }
                int r0 = r0.length     // Catch:{ all -> 0x0042 }
                r1 = 0
                r2 = 0
            L_0x000f:
                r3 = 1
                if (r2 >= r0) goto L_0x0037
                long[] r4 = r9.f3046a     // Catch:{ all -> 0x0042 }
                r5 = r4[r2]     // Catch:{ all -> 0x0042 }
                r7 = 0
                int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r4 <= 0) goto L_0x001e
                r4 = 1
                goto L_0x001f
            L_0x001e:
                r4 = 0
            L_0x001f:
                boolean[] r5 = r9.f3047b     // Catch:{ all -> 0x0042 }
                boolean r6 = r5[r2]     // Catch:{ all -> 0x0042 }
                if (r4 == r6) goto L_0x002e
                int[] r6 = r9.f3048c     // Catch:{ all -> 0x0042 }
                if (r4 == 0) goto L_0x002a
                goto L_0x002b
            L_0x002a:
                r3 = 2
            L_0x002b:
                r6[r2] = r3     // Catch:{ all -> 0x0042 }
                goto L_0x0032
            L_0x002e:
                int[] r3 = r9.f3048c     // Catch:{ all -> 0x0042 }
                r3[r2] = r1     // Catch:{ all -> 0x0042 }
            L_0x0032:
                r5[r2] = r4     // Catch:{ all -> 0x0042 }
                int r2 = r2 + 1
                goto L_0x000f
            L_0x0037:
                r9.f3050e = r3     // Catch:{ all -> 0x0042 }
                r9.f3049d = r1     // Catch:{ all -> 0x0042 }
                int[] r0 = r9.f3048c     // Catch:{ all -> 0x0042 }
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                return r0
            L_0x003f:
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                r0 = 0
                return r0
            L_0x0042:
                r0 = move-exception
                monitor-exit(r9)     // Catch:{ all -> 0x0042 }
                goto L_0x0046
            L_0x0045:
                throw r0
            L_0x0046:
                goto L_0x0045
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.c.b.a():int[]");
        }

        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3046a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        z10 = true;
                        this.f3049d = true;
                    }
                }
            }
            return z10;
        }

        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f3046a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        z10 = true;
                        this.f3049d = true;
                    }
                }
            }
            return z10;
        }

        public void d() {
            synchronized (this) {
                this.f3050e = false;
            }
        }
    }

    /* renamed from: androidx.room.c$c  reason: collision with other inner class name */
    public static abstract class C0048c {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f3051a;

        public C0048c(String[] strArr) {
            this.f3051a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract boolean a();

        public abstract void b(Set set);
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f3052a;

        /* renamed from: b  reason: collision with root package name */
        public final String[] f3053b;

        /* renamed from: c  reason: collision with root package name */
        public final C0048c f3054c;

        /* renamed from: d  reason: collision with root package name */
        public final Set f3055d;

        public d(C0048c cVar, int[] iArr, String[] strArr) {
            this.f3054c = cVar;
            this.f3052a = iArr;
            this.f3053b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.f3055d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.f3055d = null;
        }

        public void a(Set set) {
            int length = this.f3052a.length;
            Set set2 = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f3052a[i10]))) {
                    if (length == 1) {
                        set2 = this.f3055d;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet(length);
                        }
                        set2.add(this.f3053b[i10]);
                    }
                }
            }
            if (set2 != null) {
                this.f3054c.b(set2);
            }
        }

        public void b(String[] strArr) {
            Set set = null;
            if (this.f3053b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    } else if (strArr[i10].equalsIgnoreCase(this.f3053b[0])) {
                        set = this.f3055d;
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f3053b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length2) {
                            break;
                        }
                        String str2 = strArr2[i11];
                        if (str2.equalsIgnoreCase(str)) {
                            hashSet.add(str2);
                            break;
                        }
                        i11++;
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f3054c.b(set);
            }
        }
    }

    public c(e eVar, Map map, Map map2, String... strArr) {
        this.f3036d = eVar;
        this.f3040h = new b(strArr.length);
        this.f3033a = new HashMap();
        this.f3035c = map2;
        this.f3041i = new q0.c(eVar);
        int length = strArr.length;
        this.f3034b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3033a.put(lowerCase, Integer.valueOf(i10));
            String str2 = (String) map.get(strArr[i10]);
            if (str2 != null) {
                this.f3034b[i10] = str2.toLowerCase(locale);
            } else {
                this.f3034b[i10] = lowerCase;
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = ((String) entry.getValue()).toLowerCase(locale2);
            if (this.f3033a.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) entry.getKey()).toLowerCase(locale2);
                HashMap hashMap = this.f3033a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    public static void b(StringBuilder sb, String str, String str2) {
        sb.append("`");
        sb.append("room_table_modification_trigger_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        sb.append("`");
    }

    public void a(C0048c cVar) {
        d dVar;
        String[] h10 = h(cVar.f3051a);
        int[] iArr = new int[h10.length];
        int length = h10.length;
        int i10 = 0;
        while (i10 < length) {
            Integer num = (Integer) this.f3033a.get(h10[i10].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i10] = num.intValue();
                i10++;
            } else {
                throw new IllegalArgumentException("There is no table with name " + h10[i10]);
            }
        }
        d dVar2 = new d(cVar, iArr, h10);
        synchronized (this.f3042j) {
            dVar = (d) this.f3042j.f(cVar, dVar2);
        }
        if (dVar == null && this.f3040h.b(iArr)) {
            l();
        }
    }

    public boolean c() {
        if (!this.f3036d.o()) {
            return false;
        }
        if (!this.f3038f) {
            this.f3036d.i().A();
        }
        if (this.f3038f) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    public void d(t0.b bVar) {
        synchronized (this) {
            if (this.f3038f) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            bVar.execSQL("PRAGMA temp_store = MEMORY;");
            bVar.execSQL("PRAGMA recursive_triggers='ON';");
            bVar.execSQL("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
            m(bVar);
            this.f3039g = bVar.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
            this.f3038f = true;
        }
    }

    public void e(String... strArr) {
        synchronized (this.f3042j) {
            Iterator it = this.f3042j.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (!((C0048c) entry.getKey()).a()) {
                    ((d) entry.getValue()).b(strArr);
                }
            }
        }
    }

    public void f() {
        if (this.f3037e.compareAndSet(false, true)) {
            this.f3036d.j().execute(this.f3044l);
        }
    }

    public void g(C0048c cVar) {
        d dVar;
        synchronized (this.f3042j) {
            dVar = (d) this.f3042j.g(cVar);
        }
        if (dVar != null && this.f3040h.c(dVar.f3052a)) {
            l();
        }
    }

    public final String[] h(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f3035c.containsKey(lowerCase)) {
                hashSet.addAll((Collection) this.f3035c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void i(Context context, String str) {
        this.f3043k = new d(context, str, this, this.f3036d.j());
    }

    public final void j(t0.b bVar, int i10) {
        bVar.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f3034b[i10];
        StringBuilder sb = new StringBuilder();
        for (String str2 : f3032m) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            b(sb, str, str2);
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i10);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            bVar.execSQL(sb.toString());
        }
    }

    public final void k(t0.b bVar, int i10) {
        String str = this.f3034b[i10];
        StringBuilder sb = new StringBuilder();
        for (String b10 : f3032m) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            b(sb, str, b10);
            bVar.execSQL(sb.toString());
        }
    }

    public void l() {
        if (this.f3036d.o()) {
            m(this.f3036d.i().A());
        }
    }

    public void m(t0.b bVar) {
        if (!bVar.G()) {
            while (true) {
                try {
                    Lock h10 = this.f3036d.h();
                    h10.lock();
                    try {
                        int[] a10 = this.f3040h.a();
                        if (a10 == null) {
                            h10.unlock();
                            return;
                        }
                        int length = a10.length;
                        bVar.beginTransaction();
                        for (int i10 = 0; i10 < length; i10++) {
                            int i11 = a10[i10];
                            if (i11 == 1) {
                                j(bVar, i10);
                            } else if (i11 == 2) {
                                k(bVar, i10);
                            }
                        }
                        bVar.setTransactionSuccessful();
                        bVar.endTransaction();
                        this.f3040h.d();
                        h10.unlock();
                    } catch (Throwable th) {
                        h10.unlock();
                        throw th;
                    }
                } catch (SQLiteException | IllegalStateException e10) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e10);
                    return;
                }
            }
        }
    }
}
