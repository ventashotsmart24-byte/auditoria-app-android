package anet.channel.util;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.statist.StrategyStatObject;
import java.io.File;
import java.io.Serializable;

public class SerializeHelper {
    private static final String TAG = "awcn.SerializeHelper";
    private static File cacheDir;

    public static File getCacheFiles(String str) {
        Context context;
        if (cacheDir == null && (context = GlobalAppRuntimeInfo.getContext()) != null) {
            cacheDir = context.getCacheDir();
        }
        return new File(cacheDir, str);
    }

    public static synchronized void persist(Serializable serializable, File file) {
        synchronized (SerializeHelper.class) {
            persist(serializable, file, (StrategyStatObject) null);
        }
    }

    public static synchronized <T> T restore(File file) {
        T restore;
        synchronized (SerializeHelper.class) {
            restore = restore(file, (StrategyStatObject) null);
        }
        return restore;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:43|(2:45|46)|47|48) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0034, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ae, code lost:
        if (r4 != null) goto L_0x008c;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00b9 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a9 A[Catch:{ all -> 0x00b3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized <T> T restore(java.io.File r14, anet.channel.statist.StrategyStatObject r15) {
        /*
            java.lang.Class<anet.channel.util.SerializeHelper> r0 = anet.channel.util.SerializeHelper.class
            monitor-enter(r0)
            if (r15 == 0) goto L_0x000f
            java.lang.String r1 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x000c }
            r15.readStrategyFilePath = r1     // Catch:{ all -> 0x000c }
            goto L_0x000f
        L_0x000c:
            r14 = move-exception
            goto L_0x00ba
        L_0x000f:
            r1 = 0
            r2 = 3
            r3 = 0
            boolean r4 = r14.exists()     // Catch:{ all -> 0x0095 }
            r5 = 2
            r6 = 1
            if (r4 != 0) goto L_0x0035
            boolean r4 = anet.channel.util.ALog.isPrintLog(r2)     // Catch:{ all -> 0x0095 }
            if (r4 == 0) goto L_0x0033
            java.lang.String r4 = "awcn.SerializeHelper"
            java.lang.String r7 = "file not exist."
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0095 }
            java.lang.String r8 = "file"
            r5[r1] = r8     // Catch:{ all -> 0x0095 }
            java.lang.String r14 = r14.getName()     // Catch:{ all -> 0x0095 }
            r5[r6] = r14     // Catch:{ all -> 0x0095 }
            anet.channel.util.ALog.w(r4, r7, r3, r5)     // Catch:{ all -> 0x0095 }
        L_0x0033:
            monitor-exit(r0)
            return r3
        L_0x0035:
            if (r15 == 0) goto L_0x0039
            r15.isFileExists = r6     // Catch:{ all -> 0x0095 }
        L_0x0039:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0095 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ all -> 0x0095 }
            r4.<init>(r14)     // Catch:{ all -> 0x0095 }
            java.io.ObjectInputStream r9 = new java.io.ObjectInputStream     // Catch:{ all -> 0x0092 }
            java.io.BufferedInputStream r10 = new java.io.BufferedInputStream     // Catch:{ all -> 0x0092 }
            r10.<init>(r4)     // Catch:{ all -> 0x0092 }
            r9.<init>(r10)     // Catch:{ all -> 0x0092 }
            java.lang.Object r10 = r9.readObject()     // Catch:{ all -> 0x0092 }
            r9.close()     // Catch:{ all -> 0x0090 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0090 }
            long r11 = r11 - r7
            if (r15 == 0) goto L_0x005e
            r15.isReadObjectSucceed = r6     // Catch:{ all -> 0x0090 }
            r15.readCostTime = r11     // Catch:{ all -> 0x0090 }
        L_0x005e:
            java.lang.String r7 = "awcn.SerializeHelper"
            java.lang.String r8 = "restore end."
            r9 = 6
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ all -> 0x0090 }
            java.lang.String r13 = "file"
            r9[r1] = r13     // Catch:{ all -> 0x0090 }
            java.io.File r13 = r14.getAbsoluteFile()     // Catch:{ all -> 0x0090 }
            r9[r6] = r13     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = "size"
            r9[r5] = r6     // Catch:{ all -> 0x0090 }
            long r5 = r14.length()     // Catch:{ all -> 0x0090 }
            java.lang.Long r14 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0090 }
            r9[r2] = r14     // Catch:{ all -> 0x0090 }
            java.lang.String r14 = "cost"
            r5 = 4
            r9[r5] = r14     // Catch:{ all -> 0x0090 }
            java.lang.Long r14 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0090 }
            r5 = 5
            r9[r5] = r14     // Catch:{ all -> 0x0090 }
            anet.channel.util.ALog.i(r7, r8, r3, r9)     // Catch:{ all -> 0x0090 }
        L_0x008c:
            r4.close()     // Catch:{ IOException -> 0x00b1 }
            goto L_0x00b1
        L_0x0090:
            r14 = move-exception
            goto L_0x0098
        L_0x0092:
            r14 = move-exception
            r10 = r3
            goto L_0x0098
        L_0x0095:
            r14 = move-exception
            r4 = r3
            r10 = r4
        L_0x0098:
            boolean r2 = anet.channel.util.ALog.isPrintLog(r2)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00a7
            java.lang.String r2 = "awcn.SerializeHelper"
            java.lang.String r5 = "restore file fail."
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00b3 }
            anet.channel.util.ALog.w(r2, r5, r3, r14, r1)     // Catch:{ all -> 0x00b3 }
        L_0x00a7:
            if (r15 == 0) goto L_0x00ae
            java.lang.String r1 = "SerializeHelper.restore()"
            r15.appendErrorTrace(r1, r14)     // Catch:{ all -> 0x00b3 }
        L_0x00ae:
            if (r4 == 0) goto L_0x00b1
            goto L_0x008c
        L_0x00b1:
            monitor-exit(r0)
            return r10
        L_0x00b3:
            r14 = move-exception
            if (r4 == 0) goto L_0x00b9
            r4.close()     // Catch:{ IOException -> 0x00b9 }
        L_0x00b9:
            throw r14     // Catch:{ all -> 0x000c }
        L_0x00ba:
            monitor-exit(r0)
            goto L_0x00bd
        L_0x00bc:
            throw r14
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.SerializeHelper.restore(java.io.File, anet.channel.statist.StrategyStatObject):java.lang.Object");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:67|68|(2:70|71)|72|73) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        r10 = null;
        r11 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:72:0x0108 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006e A[Catch:{ all -> 0x0101 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[SYNTHETIC, Splitter:B:30:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0080 A[Catch:{ Exception -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[Catch:{ Exception -> 0x00f6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0105 A[SYNTHETIC, Splitter:B:70:0x0105] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x0108=Splitter:B:72:0x0108, B:34:0x0079=Splitter:B:34:0x0079} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void persist(java.io.Serializable r17, java.io.File r18, anet.channel.statist.StrategyStatObject r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Class<anet.channel.util.SerializeHelper> r3 = anet.channel.util.SerializeHelper.class
            monitor-enter(r3)
            r4 = 0
            r5 = 0
            if (r0 == 0) goto L_0x0109
            if (r1 != 0) goto L_0x0011
            goto L_0x0109
        L_0x0011:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0114 }
            r8 = 2
            r9 = 1
            java.util.UUID r10 = java.util.UUID.randomUUID()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.lang.String r11 = "-"
            java.lang.String r12 = ""
            java.lang.String r10 = r10.replace(r11, r12)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            java.io.File r10 = getCacheFiles(r10)     // Catch:{ Exception -> 0x0056, all -> 0x0053 }
            r10.createNewFile()     // Catch:{ Exception -> 0x0050, all -> 0x0053 }
            r10.setReadable(r9)     // Catch:{ Exception -> 0x0050, all -> 0x0053 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0050, all -> 0x0053 }
            r11.<init>(r10)     // Catch:{ Exception -> 0x0050, all -> 0x0053 }
            java.io.ObjectOutputStream r12 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x004e }
            java.io.BufferedOutputStream r13 = new java.io.BufferedOutputStream     // Catch:{ Exception -> 0x004e }
            r13.<init>(r11)     // Catch:{ Exception -> 0x004e }
            r12.<init>(r13)     // Catch:{ Exception -> 0x004e }
            r12.writeObject(r0)     // Catch:{ Exception -> 0x004e }
            r12.flush()     // Catch:{ Exception -> 0x004e }
            r12.close()     // Catch:{ Exception -> 0x004e }
            r11.close()     // Catch:{ IOException -> 0x004c }
        L_0x004c:
            r0 = 1
            goto L_0x0079
        L_0x004e:
            r0 = move-exception
            goto L_0x0059
        L_0x0050:
            r0 = move-exception
            r11 = r4
            goto L_0x0059
        L_0x0053:
            r0 = move-exception
            goto L_0x0103
        L_0x0056:
            r0 = move-exception
            r10 = r4
            r11 = r10
        L_0x0059:
            java.lang.String r12 = "awcn.SerializeHelper"
            java.lang.String r13 = "persist fail. "
            java.lang.Object[] r14 = new java.lang.Object[r8]     // Catch:{ all -> 0x0101 }
            java.lang.String r15 = "file"
            r14[r5] = r15     // Catch:{ all -> 0x0101 }
            java.lang.String r15 = r18.getName()     // Catch:{ all -> 0x0101 }
            r14[r9] = r15     // Catch:{ all -> 0x0101 }
            anet.channel.util.ALog.e(r12, r13, r4, r0, r14)     // Catch:{ all -> 0x0101 }
            if (r2 == 0) goto L_0x0073
            java.lang.String r12 = "SerializeHelper.persist()"
            r2.appendErrorTrace(r12, r0)     // Catch:{ all -> 0x0101 }
        L_0x0073:
            if (r11 == 0) goto L_0x0078
            r11.close()     // Catch:{ IOException -> 0x0078 }
        L_0x0078:
            r0 = 0
        L_0x0079:
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0114 }
            long r11 = r11 - r6
            if (r2 == 0) goto L_0x0095
            java.lang.String r6 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x0114 }
            r2.writeTempFilePath = r6     // Catch:{ all -> 0x0114 }
            java.lang.String r6 = java.lang.String.valueOf(r18)     // Catch:{ all -> 0x0114 }
            r2.writeStrategyFilePath = r6     // Catch:{ all -> 0x0114 }
            if (r0 == 0) goto L_0x0090
            r6 = 1
            goto L_0x0091
        L_0x0090:
            r6 = 0
        L_0x0091:
            r2.isTempWriteSucceed = r6     // Catch:{ all -> 0x0114 }
            r2.writeCostTime = r11     // Catch:{ all -> 0x0114 }
        L_0x0095:
            if (r0 == 0) goto L_0x00ed
            boolean r6 = r10.renameTo(r1)     // Catch:{ all -> 0x0114 }
            if (r6 == 0) goto L_0x00cd
            java.lang.String r7 = "awcn.SerializeHelper"
            java.lang.String r13 = "persist end."
            r14 = 6
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ all -> 0x0114 }
            java.lang.String r15 = "file"
            r14[r5] = r15     // Catch:{ all -> 0x0114 }
            java.io.File r15 = r18.getAbsoluteFile()     // Catch:{ all -> 0x0114 }
            r14[r9] = r15     // Catch:{ all -> 0x0114 }
            java.lang.String r15 = "size"
            r14[r8] = r15     // Catch:{ all -> 0x0114 }
            long r15 = r18.length()     // Catch:{ all -> 0x0114 }
            java.lang.Long r1 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0114 }
            r8 = 3
            r14[r8] = r1     // Catch:{ all -> 0x0114 }
            java.lang.String r1 = "cost"
            r8 = 4
            r14[r8] = r1     // Catch:{ all -> 0x0114 }
            java.lang.Long r1 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0114 }
            r8 = 5
            r14[r8] = r1     // Catch:{ all -> 0x0114 }
            anet.channel.util.ALog.i(r7, r13, r4, r14)     // Catch:{ all -> 0x0114 }
            goto L_0x00d6
        L_0x00cd:
            java.lang.String r1 = "awcn.SerializeHelper"
            java.lang.String r7 = "rename failed."
            java.lang.Object[] r8 = new java.lang.Object[r5]     // Catch:{ all -> 0x0114 }
            anet.channel.util.ALog.e(r1, r7, r4, r8)     // Catch:{ all -> 0x0114 }
        L_0x00d6:
            if (r2 == 0) goto L_0x00ee
            if (r6 == 0) goto L_0x00dc
            r1 = 1
            goto L_0x00dd
        L_0x00dc:
            r1 = 0
        L_0x00dd:
            r2.isRenameSucceed = r1     // Catch:{ all -> 0x0114 }
            if (r6 == 0) goto L_0x00e2
            goto L_0x00e3
        L_0x00e2:
            r9 = 0
        L_0x00e3:
            r2.isSucceed = r9     // Catch:{ all -> 0x0114 }
            anet.channel.appmonitor.IAppMonitor r1 = anet.channel.appmonitor.AppMonitor.getInstance()     // Catch:{ all -> 0x0114 }
            r1.commitStat(r2)     // Catch:{ all -> 0x0114 }
            goto L_0x00ee
        L_0x00ed:
            r6 = 0
        L_0x00ee:
            if (r0 == 0) goto L_0x00f2
            if (r6 != 0) goto L_0x00ff
        L_0x00f2:
            r10.delete()     // Catch:{ Exception -> 0x00f6 }
            goto L_0x00ff
        L_0x00f6:
            java.lang.String r0 = "awcn.SerializeHelper"
            java.lang.String r1 = "delete failed."
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0114 }
            anet.channel.util.ALog.e(r0, r1, r4, r2)     // Catch:{ all -> 0x0114 }
        L_0x00ff:
            monitor-exit(r3)
            return
        L_0x0101:
            r0 = move-exception
            r4 = r11
        L_0x0103:
            if (r4 == 0) goto L_0x0108
            r4.close()     // Catch:{ IOException -> 0x0108 }
        L_0x0108:
            throw r0     // Catch:{ all -> 0x0114 }
        L_0x0109:
            java.lang.String r0 = "awcn.SerializeHelper"
            java.lang.String r1 = "persist fail. Invalid parameter"
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ all -> 0x0114 }
            anet.channel.util.ALog.e(r0, r1, r4, r2)     // Catch:{ all -> 0x0114 }
            monitor-exit(r3)
            return
        L_0x0114:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.SerializeHelper.persist(java.io.Serializable, java.io.File, anet.channel.statist.StrategyStatObject):void");
    }
}
