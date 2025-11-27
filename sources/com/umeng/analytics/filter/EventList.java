package com.umeng.analytics.filter;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.f;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.FileOutputStream;

public class EventList extends c implements FileLockCallback {
    private static final int DELETE_LIST_DATA = 2;
    private static final int LOAD_LIST_DATA = 1;
    private static final int SAVE_LIST_DATA = 0;
    private Context mAppContext;
    protected String mEventList;
    protected String mEventListKey;
    protected String mEventListName;
    protected String mEventListVersionKey;
    private FileLockUtil mFileLock = new FileLockUtil();

    public EventList(String str, String str2) {
        this.mEventListName = str;
        this.mEventListKey = str;
        this.mEventListVersionKey = str2;
    }

    private void deleteDataFile(File file) {
        if (this.mAppContext != null) {
            synchronized (this.mFileLock) {
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00af A[SYNTHETIC, Splitter:B:53:0x00af] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean loadEventListFromFile(android.content.Context r9, java.io.File r10) {
        /*
            r8 = this;
            boolean r0 = r10.exists()
            r1 = 0
            if (r0 == 0) goto L_0x00c4
            java.lang.String r0 = r8.mEventList
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x00c4
            r0 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ all -> 0x00a6 }
            r2.<init>(r10)     // Catch:{ all -> 0x00a6 }
            java.io.BufferedReader r10 = new java.io.BufferedReader     // Catch:{ all -> 0x00a6 }
            r10.<init>(r2)     // Catch:{ all -> 0x00a6 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r0.<init>()     // Catch:{ all -> 0x00a4 }
        L_0x001f:
            java.lang.String r2 = r10.readLine()     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0029
            r0.append(r2)     // Catch:{ all -> 0x00a4 }
            goto L_0x001f
        L_0x0029:
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a4 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00a4 }
            if (r2 != 0) goto L_0x00a0
            java.lang.String r2 = com.umeng.commonsdk.statistics.common.HelperUtils.getMD5(r0)     // Catch:{ all -> 0x00a4 }
            java.lang.String r3 = r8.mEventListVersionKey     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = ""
            java.lang.String r3 = com.umeng.commonsdk.framework.UMEnvelopeBuild.imprintProperty(r9, r3, r4)     // Catch:{ all -> 0x00a4 }
            r8.mEventList = r0     // Catch:{ all -> 0x00a4 }
            r8.eventListChange()     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = "MobclickRT"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a4 }
            r5.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r6 = "--->>> loadEventListFromFile: mEventList = "
            r5.append(r6)     // Catch:{ all -> 0x00a4 }
            java.lang.String r6 = r8.mEventList     // Catch:{ all -> 0x00a4 }
            r5.append(r6)     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00a4 }
            com.umeng.commonsdk.debug.UMRTLog.i(r4, r5)     // Catch:{ all -> 0x00a4 }
            boolean r4 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r9)     // Catch:{ all -> 0x00a4 }
            r5 = 1
            if (r4 == 0) goto L_0x0083
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0077
            r8.mEventList = r0     // Catch:{ all -> 0x00a4 }
            r8.setMD5ClearFlag(r1)     // Catch:{ all -> 0x00a4 }
            r10.close()     // Catch:{ all -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L_0x0076:
            return r5
        L_0x0077:
            r8.setMD5ClearFlag(r5)     // Catch:{ all -> 0x00a4 }
            r10.close()     // Catch:{ all -> 0x007e }
            goto L_0x0082
        L_0x007e:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L_0x0082:
            return r1
        L_0x0083:
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ all -> 0x00a4 }
            if (r2 == 0) goto L_0x0097
            r8.mEventList = r0     // Catch:{ all -> 0x00a4 }
            r8.eventListChange()     // Catch:{ all -> 0x00a4 }
            r10.close()     // Catch:{ all -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L_0x0096:
            return r5
        L_0x0097:
            r10.close()     // Catch:{ all -> 0x009b }
            goto L_0x009f
        L_0x009b:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L_0x009f:
            return r1
        L_0x00a0:
            r10.close()     // Catch:{ all -> 0x00b3 }
            goto L_0x00c4
        L_0x00a4:
            r0 = move-exception
            goto L_0x00aa
        L_0x00a6:
            r10 = move-exception
            r7 = r0
            r0 = r10
            r10 = r7
        L_0x00aa:
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r0)     // Catch:{ all -> 0x00b8 }
            if (r10 == 0) goto L_0x00c4
            r10.close()     // Catch:{ all -> 0x00b3 }
            goto L_0x00c4
        L_0x00b3:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
            goto L_0x00c4
        L_0x00b8:
            r0 = move-exception
            if (r10 == 0) goto L_0x00c3
            r10.close()     // Catch:{ all -> 0x00bf }
            goto L_0x00c3
        L_0x00bf:
            r10 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r9, r10)
        L_0x00c3:
            throw r0
        L_0x00c4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.filter.EventList.loadEventListFromFile(android.content.Context, java.io.File):boolean");
    }

    private void saveEventListToFile(Context context, File file) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(this.mEventList.getBytes());
            fileOutputStream.close();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public boolean enabled() {
        synchronized (this) {
            if (this.mEventList == null) {
                return false;
            }
            return true;
        }
    }

    public void eventListChange() {
    }

    public boolean matchHit(String str) {
        return false;
    }

    public boolean onFileLock(String str) {
        return false;
    }

    public void onImprintValueChanged(String str, String str2) {
        if (f.at.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable black list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), (FileLockCallback) this, 2);
        }
        if (f.au.equals(str) && str2 == null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> disable white list for ekv.");
            this.mFileLock.doFileOperateion(new File(this.mAppContext.getFilesDir(), this.mEventListName), (FileLockCallback) this, 2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:6|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0062, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0063, code lost:
        com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r3.mAppContext, r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreProcessImprintKey(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L_0x0071
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto L_0x0071
            int r0 = r5.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "--->>> onPreProcessImprintKey: key = "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = "; len of value="
            r1.append(r4)
            r1.append(r0)
            java.lang.String r4 = r1.toString()
            java.lang.String r0 = "MobclickRT"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "--->>> onPreProcessImprintKey: value = "
            r4.append(r1)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r4)
            r3.mEventList = r5
            r3.eventListChange()
            java.io.File r4 = new java.io.File
            android.content.Context r5 = r3.mAppContext
            java.io.File r5 = r5.getFilesDir()
            java.lang.String r0 = r3.mEventListName
            r4.<init>(r5, r0)
            boolean r5 = r4.exists()
            if (r5 != 0) goto L_0x0068
            r4.createNewFile()     // Catch:{ IOException -> 0x005e }
            goto L_0x0068
        L_0x005e:
            r4.createNewFile()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0068
        L_0x0062:
            r5 = move-exception
            android.content.Context r0 = r3.mAppContext
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r0, r5)
        L_0x0068:
            com.umeng.commonsdk.utils.FileLockUtil r5 = r3.mFileLock
            r0 = 0
            r5.doFileOperateion((java.io.File) r4, (com.umeng.commonsdk.utils.FileLockCallback) r3, (int) r0)
            r3.setMD5ClearFlag(r0)
        L_0x0071:
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.filter.EventList.onPreProcessImprintKey(java.lang.String, java.lang.String):boolean");
    }

    public void register(Context context) {
        if (this.mAppContext == null) {
            this.mAppContext = context.getApplicationContext();
        }
        File file = new File(this.mAppContext.getFilesDir(), this.mEventListName);
        if (!TextUtils.isEmpty(UMEnvelopeBuild.imprintProperty(this.mAppContext, this.mEventListVersionKey, ""))) {
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, (FileLockCallback) this, 1);
            } else {
                setMD5ClearFlag(true);
            }
        }
        if (UMUtils.isMainProgress(this.mAppContext)) {
            ImprintHandler.getImprintService(this.mAppContext).registPreProcessCallback(this.mEventListKey, this);
            ImprintHandler.getImprintService(this.mAppContext).registImprintCallback(this.mEventListVersionKey, this);
        }
    }

    public void setMD5ClearFlag(boolean z10) {
    }

    public String toString() {
        if (TextUtils.isEmpty(this.mEventListName) || TextUtils.isEmpty(this.mEventListKey)) {
            return "Uninitialized EventList.";
        }
        StringBuilder sb = new StringBuilder("[");
        sb.append("EventListName:" + this.mEventListName + ",");
        sb.append("listKey:" + this.mEventListKey + ",");
        if (!TextUtils.isEmpty(this.mEventList)) {
            sb.append("listKeyValue:" + this.mEventList + "]");
        } else {
            sb.append("listKeyValue:empty,");
        }
        if (!TextUtils.isEmpty(this.mEventListVersionKey)) {
            sb.append("listKeyVer:" + this.mEventListVersionKey + "]");
        } else {
            sb.append("listKeyVer:empty]");
        }
        return sb.toString();
    }

    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            synchronized (this) {
                saveEventListToFile(this.mAppContext, file);
            }
        } else if (i10 == 1) {
            synchronized (this) {
                if (loadEventListFromFile(this.mAppContext, file)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> find event list data file, load it.");
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> can't find event list file.");
                }
            }
        } else if (i10 == 2) {
            synchronized (this) {
                this.mEventList = null;
                deleteDataFile(file);
            }
        }
        return true;
    }
}
