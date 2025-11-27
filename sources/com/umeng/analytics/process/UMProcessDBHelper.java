package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private InsertEventCallback ekvCallBack = new InsertEventCallback();
    /* access modifiers changed from: private */
    public Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();

    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        public boolean onFileLock(File file, int i10) {
            return false;
        }

        public boolean onFileLock(String str) {
            return false;
        }

        public boolean onFileLock(String str, Object obj) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = a.f14485c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(a.f14486d, ""), (JSONArray) obj);
            return true;
        }
    }

    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        public boolean onFileLock(File file, int i10) {
            return false;
        }

        public boolean onFileLock(String str, Object obj) {
            return false;
        }

        public boolean onFileLock(String str) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = a.f14485c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(a.f14486d, ""));
            return true;
        }
    }

    public class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        int f14474a;

        /* renamed from: b  reason: collision with root package name */
        String f14475b;

        /* renamed from: c  reason: collision with root package name */
        String f14476c;

        /* renamed from: d  reason: collision with root package name */
        String f14477d;

        /* renamed from: e  reason: collision with root package name */
        int f14478e;

        /* renamed from: f  reason: collision with root package name */
        String f14479f;

        /* renamed from: g  reason: collision with root package name */
        String f14480g;

        /* renamed from: h  reason: collision with root package name */
        String f14481h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                a aVar = new a();
                aVar.f14476c = jSONObject.optString("id");
                aVar.f14480g = UMUtils.getAppVersionName(this.mContext);
                aVar.f14481h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f14475b = jSONObject.optString("__i");
                aVar.f14478e = jSONObject.optInt("__t");
                aVar.f14479f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f14477d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            if (new File(b.b(this.mContext, str)).exists()) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0082, code lost:
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r0.endTransaction();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087 A[SYNTHETIC, Splitter:B:29:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0096 A[SYNTHETIC, Splitter:B:36:0x0096] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean insertEvents_(java.lang.String r8, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> r9) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            r1 = 1
            if (r0 != 0) goto L_0x00a4
            if (r9 == 0) goto L_0x00a4
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L_0x0011
            goto L_0x00a4
        L_0x0011:
            r0 = 0
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x0094, all -> 0x0084 }
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0094, all -> 0x0084 }
            android.database.sqlite.SQLiteDatabase r2 = r2.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0094, all -> 0x0084 }
            r2.beginTransaction()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
        L_0x0023:
            boolean r3 = r9.hasNext()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            if (r3 == 0) goto L_0x006f
            java.lang.Object r3 = r9.next()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            com.umeng.analytics.process.UMProcessDBHelper$a r3 = (com.umeng.analytics.process.UMProcessDBHelper.a) r3     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.<init>()     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__i"
            java.lang.String r6 = r3.f14475b     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__e"
            java.lang.String r6 = r3.f14476c     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__t"
            int r6 = r3.f14478e     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__pn"
            java.lang.String r6 = r3.f14479f     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__av"
            java.lang.String r6 = r3.f14480g     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__vc"
            java.lang.String r6 = r3.f14481h     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r6)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r5 = "__s"
            java.lang.String r3 = r3.f14477d     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            java.lang.String r3 = "__et_p"
            r2.insert(r3, r0, r4)     // Catch:{ Exception -> 0x0023, all -> 0x007f }
            goto L_0x0023
        L_0x006f:
            r2.setTransactionSuccessful()     // Catch:{ Exception -> 0x0082, all -> 0x007f }
            r2.endTransaction()     // Catch:{ all -> 0x0075 }
        L_0x0075:
            android.content.Context r9 = r7.mContext
            com.umeng.analytics.process.c r9 = com.umeng.analytics.process.c.a((android.content.Context) r9)
            r9.b(r8)
            return r1
        L_0x007f:
            r9 = move-exception
            r0 = r2
            goto L_0x0085
        L_0x0082:
            r0 = r2
            goto L_0x0094
        L_0x0084:
            r9 = move-exception
        L_0x0085:
            if (r0 == 0) goto L_0x008a
            r0.endTransaction()     // Catch:{ all -> 0x008a }
        L_0x008a:
            android.content.Context r0 = r7.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a((android.content.Context) r0)
            r0.b(r8)
            throw r9
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r0.endTransaction()     // Catch:{ all -> 0x0099 }
        L_0x0099:
            android.content.Context r9 = r7.mContext
            com.umeng.analytics.process.c r9 = com.umeng.analytics.process.c.a((android.content.Context) r9)
            r9.b(r8)
            r8 = 0
            return r8
        L_0x00a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.insertEvents_(java.lang.String, java.util.List):boolean");
    }

    private boolean processIsService(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void processToMain(String str) {
        if (dbIsExists(str)) {
            List<a> readEventByProcess = readEventByProcess(str);
            if (!readEventByProcess.isEmpty() && insertEvents_(a.f14490h, readEventByProcess)) {
                deleteEventDatas(str, (String) null, readEventByProcess);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00aa, code lost:
        if (r2 != null) goto L_0x00ac;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a7 A[SYNTHETIC, Splitter:B:24:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00bd A[SYNTHETIC, Splitter:B:34:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2 A[Catch:{ Exception -> 0x00c5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.Context r2 = r12.mContext     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a((android.content.Context) r2)     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            android.database.sqlite.SQLiteDatabase r2 = r2.a((java.lang.String) r13)     // Catch:{ Exception -> 0x009e, all -> 0x009b }
            r2.beginTransaction()     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            java.lang.String r4 = "__et_p"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r3 = r2
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0096, all -> 0x0094 }
            if (r3 == 0) goto L_0x008e
        L_0x0022:
            boolean r4 = r3.moveToNext()     // Catch:{ Exception -> 0x008c }
            if (r4 == 0) goto L_0x008e
            com.umeng.analytics.process.UMProcessDBHelper$a r4 = new com.umeng.analytics.process.UMProcessDBHelper$a     // Catch:{ Exception -> 0x008c }
            r4.<init>()     // Catch:{ Exception -> 0x008c }
            r5 = 0
            int r5 = r3.getInt(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14474a = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__i"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14475b = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__e"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14476c = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__s"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14477d = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__t"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            int r5 = r3.getInt(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14478e = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__pn"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14479f = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__av"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14480g = r5     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = "__vc"
            int r5 = r3.getColumnIndex(r5)     // Catch:{ Exception -> 0x008c }
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x008c }
            r4.f14481h = r5     // Catch:{ Exception -> 0x008c }
            r0.add(r4)     // Catch:{ Exception -> 0x008c }
            goto L_0x0022
        L_0x008c:
            r1 = move-exception
            goto L_0x00a2
        L_0x008e:
            if (r3 == 0) goto L_0x00ac
            r3.close()     // Catch:{ Exception -> 0x00af }
            goto L_0x00ac
        L_0x0094:
            r0 = move-exception
            goto L_0x00bb
        L_0x0096:
            r3 = move-exception
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x00a2
        L_0x009b:
            r0 = move-exception
            r2 = r1
            goto L_0x00bb
        L_0x009e:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L_0x00a2:
            r1.printStackTrace()     // Catch:{ all -> 0x00b9 }
            if (r3 == 0) goto L_0x00aa
            r3.close()     // Catch:{ Exception -> 0x00af }
        L_0x00aa:
            if (r2 == 0) goto L_0x00af
        L_0x00ac:
            r2.endTransaction()     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a((android.content.Context) r1)
            r1.b(r13)
            return r0
        L_0x00b9:
            r0 = move-exception
            r1 = r3
        L_0x00bb:
            if (r1 == 0) goto L_0x00c0
            r1.close()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c0:
            if (r2 == 0) goto L_0x00c5
            r2.endTransaction()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c5:
            android.content.Context r1 = r12.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a((android.content.Context) r1)
            r1.b(r13)
            goto L_0x00d0
        L_0x00cf:
            throw r0
        L_0x00d0:
            goto L_0x00cf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteEventDatas(java.lang.String r5, java.lang.String r6, java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> r7) {
        /*
            r4 = this;
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 == 0) goto L_0x0007
            return
        L_0x0007:
            r6 = 0
            android.content.Context r0 = r4.mContext     // Catch:{ Exception -> 0x0060, all -> 0x004e }
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a((android.content.Context) r0)     // Catch:{ Exception -> 0x0060, all -> 0x004e }
            android.database.sqlite.SQLiteDatabase r0 = r0.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0060, all -> 0x004e }
            r0.beginTransaction()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            int r1 = r7.size()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            if (r1 <= 0) goto L_0x003d
            r6 = 0
        L_0x001c:
            if (r6 >= r1) goto L_0x0042
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2.<init>()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r3 = "delete from __et_p where rowid="
            r2.append(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.Object r3 = r7.get(r6)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            com.umeng.analytics.process.UMProcessDBHelper$a r3 = (com.umeng.analytics.process.UMProcessDBHelper.a) r3     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            int r3 = r3.f14474a     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r2.append(r3)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r0.execSQL(r2)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            int r6 = r6 + 1
            goto L_0x001c
        L_0x003d:
            java.lang.String r7 = "__et_p"
            r0.delete(r7, r6, r6)     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
        L_0x0042:
            r0.setTransactionSuccessful()     // Catch:{ Exception -> 0x004b, all -> 0x0049 }
            r0.endTransaction()
            goto L_0x0066
        L_0x0049:
            r6 = move-exception
            goto L_0x0051
        L_0x004b:
            r6 = r0
            goto L_0x0061
        L_0x004e:
            r7 = move-exception
            r0 = r6
            r6 = r7
        L_0x0051:
            if (r0 == 0) goto L_0x0056
            r0.endTransaction()
        L_0x0056:
            android.content.Context r7 = r4.mContext
            com.umeng.analytics.process.c r7 = com.umeng.analytics.process.c.a((android.content.Context) r7)
            r7.b(r5)
            throw r6
        L_0x0060:
        L_0x0061:
            if (r6 == 0) goto L_0x0066
            r6.endTransaction()
        L_0x0066:
            android.content.Context r6 = r4.mContext
            com.umeng.analytics.process.c r6 = com.umeng.analytics.process.c.a((android.content.Context) r6)
            r6.b(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteEventDatas(java.lang.String, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
        if (r1 == null) goto L_0x004c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteMainProcessEventDatasByIds(java.util.List<java.lang.Integer> r8) {
        /*
            r7 = this;
            java.lang.String r0 = "_main_"
            r1 = 0
            android.content.Context r2 = r7.mContext     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            com.umeng.analytics.process.c r2 = com.umeng.analytics.process.c.a((android.content.Context) r2)     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            android.database.sqlite.SQLiteDatabase r1 = r2.a((java.lang.String) r0)     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            r1.beginTransaction()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
        L_0x0014:
            boolean r2 = r8.hasNext()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            if (r2 == 0) goto L_0x0032
            java.lang.Object r2 = r8.next()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            java.lang.String r3 = "__et_p"
            java.lang.String r4 = "id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            r6 = 0
            r5[r6] = r2     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            r1.delete(r3, r4, r5)     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            goto L_0x0014
        L_0x0032:
            r1.setTransactionSuccessful()     // Catch:{ Exception -> 0x0046, all -> 0x0036 }
            goto L_0x0049
        L_0x0036:
            r8 = move-exception
            if (r1 == 0) goto L_0x003c
            r1.endTransaction()
        L_0x003c:
            android.content.Context r1 = r7.mContext
            com.umeng.analytics.process.c r1 = com.umeng.analytics.process.c.a((android.content.Context) r1)
            r1.b(r0)
            throw r8
        L_0x0046:
            if (r1 == 0) goto L_0x004c
        L_0x0049:
            r1.endTransaction()
        L_0x004c:
            android.content.Context r8 = r7.mContext
            com.umeng.analytics.process.c r8 = com.umeng.analytics.process.c.a((android.content.Context) r8)
            r8.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.deleteMainProcessEventDatasByIds(java.util.List):void");
    }

    public void insertEvents(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, (FileLockCallback) this.ekvCallBack, (Object) jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() {
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), (Object) null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v8 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0187 A[SYNTHETIC, Splitter:B:76:0x0187] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x0149=Splitter:B:52:0x0149, B:66:0x016d=Splitter:B:66:0x016d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) {
        /*
            r19 = this;
            r1 = r19
            java.lang.String r0 = "pn"
            java.lang.String r2 = "_main_"
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            r4 = 0
            android.content.Context r5 = r1.mContext     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            com.umeng.analytics.process.c r5 = com.umeng.analytics.process.c.a((android.content.Context) r5)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            android.database.sqlite.SQLiteDatabase r5 = r5.a((java.lang.String) r2)     // Catch:{ Exception -> 0x0158, all -> 0x0155 }
            r5.beginTransaction()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r7 = "__et_p"
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r6 = r5
            android.database.Cursor r4 = r6.query(r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r4 == 0) goto L_0x0141
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r6.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r7 = ""
        L_0x002f:
            boolean r8 = r4.moveToNext()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r8 == 0) goto L_0x0100
            java.lang.String r8 = "id"
            int r8 = r4.getColumnIndex(r8)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            int r8 = r4.getInt(r8)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r9 = "__t"
            int r9 = r4.getColumnIndex(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            int r9 = r4.getInt(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r10 = "__i"
            int r10 = r4.getColumnIndex(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r10 = r4.getString(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r11 = "__s"
            int r11 = r4.getColumnIndex(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r11 = r4.getString(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r12 = "__pn"
            int r12 = r4.getColumnIndex(r12)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r12 = r4.getString(r12)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r13 = "__av"
            int r13 = r4.getColumnIndex(r13)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r13 = r4.getString(r13)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            boolean r14 = android.text.TextUtils.isEmpty(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r14 == 0) goto L_0x0078
            goto L_0x002f
        L_0x0078:
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r14 == 0) goto L_0x007f
            r7 = r13
        L_0x007f:
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r14 != 0) goto L_0x00fc
            r14 = 2049(0x801, float:2.871E-42)
            if (r9 != r14) goto L_0x00fc
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            com.umeng.common.a r14 = com.umeng.common.a.a()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r11 = r14.b(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r9.<init>(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r11 = r9.optString(r0)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r14 != 0) goto L_0x00a8
            java.lang.String r14 = "unknown"
            boolean r11 = r14.equals(r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r11 == 0) goto L_0x00c5
        L_0x00a8:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            android.content.Context r14 = r1.mContext     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.append(r14)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r14 = ":"
            r11.append(r14)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.append(r12)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r9.put(r0, r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
        L_0x00c5:
            boolean r11 = r6.has(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r11 == 0) goto L_0x00d0
            org.json.JSONArray r11 = r6.optJSONArray(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            goto L_0x00d5
        L_0x00d0:
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
        L_0x00d5:
            long r14 = com.umeng.analytics.pro.s.a((org.json.JSONArray) r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            long r16 = com.umeng.analytics.pro.s.a((org.json.JSONObject) r9)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            long r16 = r16 + r14
            int r12 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r12 <= 0) goto L_0x00e4
            goto L_0x0100
        L_0x00e4:
            boolean r12 = r7.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r12 != 0) goto L_0x00eb
            goto L_0x0100
        L_0x00eb:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r12 = r22
            r12.add(r8)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.put(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r6.put(r10, r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            goto L_0x002f
        L_0x00fc:
            r12 = r22
            goto L_0x002f
        L_0x0100:
            int r0 = r6.length()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r0 <= 0) goto L_0x0141
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r0.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.util.Iterator r7 = r6.keys()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
        L_0x010f:
            boolean r8 = r7.hasNext()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r8 == 0) goto L_0x0136
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r8.<init>()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.Object r9 = r7.next()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            java.lang.String r10 = r6.optString(r9)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r11.<init>(r10)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            r8.put(r9, r11)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            int r9 = r8.length()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r9 <= 0) goto L_0x010f
            r0.put(r8)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            goto L_0x010f
        L_0x0136:
            int r6 = r0.length()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r6 <= 0) goto L_0x0141
            java.lang.String r6 = "ekv"
            r3.put(r6, r0)     // Catch:{ Exception -> 0x014f, all -> 0x014d }
        L_0x0141:
            r5.setTransactionSuccessful()     // Catch:{ Exception -> 0x014f, all -> 0x014d }
            if (r4 == 0) goto L_0x0149
            r4.close()
        L_0x0149:
            r5.endTransaction()     // Catch:{ all -> 0x0170 }
            goto L_0x0170
        L_0x014d:
            r0 = move-exception
            goto L_0x0180
        L_0x014f:
            r18 = r5
            r5 = r4
            r4 = r18
            goto L_0x0159
        L_0x0155:
            r0 = move-exception
            r5 = r4
            goto L_0x0180
        L_0x0158:
            r5 = r4
        L_0x0159:
            java.lang.String r0 = "MobclickRT"
            java.lang.String r6 = "--->>> 构建子进程事件数据异常，清除数据库数据。"
            com.umeng.commonsdk.debug.UMRTLog.e(r0, r6)     // Catch:{ all -> 0x017a }
            java.lang.String r0 = "delete from __et_p"
            r4.execSQL(r0)     // Catch:{ all -> 0x017a }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x017a }
            if (r5 == 0) goto L_0x016d
            r5.close()
        L_0x016d:
            r4.endTransaction()     // Catch:{ all -> 0x0170 }
        L_0x0170:
            android.content.Context r0 = r1.mContext
            com.umeng.analytics.process.c r0 = com.umeng.analytics.process.c.a((android.content.Context) r0)
            r0.b(r2)
            return r3
        L_0x017a:
            r0 = move-exception
            r18 = r5
            r5 = r4
            r4 = r18
        L_0x0180:
            if (r4 == 0) goto L_0x0185
            r4.close()
        L_0x0185:
            if (r5 == 0) goto L_0x018a
            r5.endTransaction()     // Catch:{ all -> 0x018a }
        L_0x018a:
            android.content.Context r3 = r1.mContext
            com.umeng.analytics.process.c r3 = com.umeng.analytics.process.c.a((android.content.Context) r3)
            r3.b(r2)
            goto L_0x0195
        L_0x0194:
            throw r0
        L_0x0195:
            goto L_0x0194
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r3v4, types: [org.json.JSONObject] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: type inference failed for: r3v9 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005d, code lost:
        r3 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0060, code lost:
        r5 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c A[ExcHandler: all (th java.lang.Throwable), Splitter:B:6:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0083 A[SYNTHETIC, Splitter:B:39:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0088 A[Catch:{ Exception -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0099 A[SYNTHETIC, Splitter:B:47:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009e A[Catch:{ Exception -> 0x00a1 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.json.JSONObject readVersionInfoFromColumId(java.lang.Integer r14) {
        /*
            r13 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.lang.String r2 = "_main_"
            r3 = 0
            android.content.Context r4 = r13.mContext     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            com.umeng.analytics.process.c r4 = com.umeng.analytics.process.c.a((android.content.Context) r4)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            android.database.sqlite.SQLiteDatabase r4 = r4.a((java.lang.String) r2)     // Catch:{ Exception -> 0x007b, all -> 0x0078 }
            r4.beginTransaction()     // Catch:{ Exception -> 0x0075 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ Exception -> 0x0075 }
            java.lang.String r6 = "__et_p"
            r7 = 0
            java.lang.String r8 = "rowid=?"
            java.lang.String[] r9 = new java.lang.String[]{r14}     // Catch:{ Exception -> 0x0075 }
            r10 = 0
            r11 = 0
            r12 = 0
            r5 = r4
            android.database.Cursor r14 = r5.query(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ Exception -> 0x0075 }
            if (r14 == 0) goto L_0x0063
            boolean r5 = r14.moveToNext()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            if (r5 == 0) goto L_0x0063
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            r5.<init>()     // Catch:{ Exception -> 0x005f, all -> 0x005c }
            int r3 = r14.getColumnIndex(r1)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            java.lang.String r3 = r14.getString(r3)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            int r6 = r14.getColumnIndex(r0)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            java.lang.String r6 = r14.getString(r6)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            boolean r7 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            if (r7 != 0) goto L_0x004f
            r5.put(r1, r3)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
        L_0x004f:
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
            if (r1 != 0) goto L_0x0058
            r5.put(r0, r6)     // Catch:{ Exception -> 0x005a, all -> 0x005c }
        L_0x0058:
            r3 = r5
            goto L_0x0063
        L_0x005a:
            r0 = move-exception
            goto L_0x0061
        L_0x005c:
            r0 = move-exception
            r3 = r14
            goto L_0x0097
        L_0x005f:
            r0 = move-exception
            r5 = r3
        L_0x0061:
            r3 = r14
            goto L_0x007e
        L_0x0063:
            if (r14 == 0) goto L_0x0068
            r14.close()     // Catch:{ Exception -> 0x006b }
        L_0x0068:
            r4.endTransaction()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            android.content.Context r14 = r13.mContext
            com.umeng.analytics.process.c r14 = com.umeng.analytics.process.c.a((android.content.Context) r14)
            r14.b(r2)
            goto L_0x0095
        L_0x0075:
            r0 = move-exception
            r5 = r3
            goto L_0x007e
        L_0x0078:
            r0 = move-exception
            r4 = r3
            goto L_0x0097
        L_0x007b:
            r0 = move-exception
            r4 = r3
            r5 = r4
        L_0x007e:
            r0.printStackTrace()     // Catch:{ all -> 0x0096 }
            if (r3 == 0) goto L_0x0086
            r3.close()     // Catch:{ Exception -> 0x008b }
        L_0x0086:
            if (r4 == 0) goto L_0x008b
            r4.endTransaction()     // Catch:{ Exception -> 0x008b }
        L_0x008b:
            android.content.Context r14 = r13.mContext
            com.umeng.analytics.process.c r14 = com.umeng.analytics.process.c.a((android.content.Context) r14)
            r14.b(r2)
            r3 = r5
        L_0x0095:
            return r3
        L_0x0096:
            r0 = move-exception
        L_0x0097:
            if (r3 == 0) goto L_0x009c
            r3.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x009c:
            if (r4 == 0) goto L_0x00a1
            r4.endTransaction()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            android.content.Context r14 = r13.mContext
            com.umeng.analytics.process.c r14 = com.umeng.analytics.process.c.a((android.content.Context) r14)
            r14.b(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readVersionInfoFromColumId(java.lang.Integer):org.json.JSONObject");
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
