package com.hpplay.cybergarage.util;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.net.HostInterface;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

public class OnlineCheckUtil {
    private static final String TAG = "OnlineCheckUtil";
    private static final int TCP_TIMEOUT = 3000;

    public static int getAvailablePort() {
        Random random = new Random();
        int i10 = 10090;
        try {
            i10 = random.nextInt(10000) + 10000 + random.nextInt(100);
            int i11 = i10;
            while (i11 <= 65535) {
                try {
                    new ServerSocket(i11).close();
                    CLog.i(TAG, "get availabel port " + i11);
                    return i11;
                } catch (IOException unused) {
                    i11++;
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return i10;
    }

    private static String matchLocalIp(String str) {
        String str2 = null;
        try {
            String substring = str.substring(0, str.lastIndexOf("."));
            int nHostAddresses = HostInterface.getNHostAddresses();
            for (int i10 = 0; i10 < nHostAddresses; i10++) {
                String hostAddress = HostInterface.getHostAddress(i10);
                if (hostAddress.contains(substring)) {
                    str2 = hostAddress;
                }
                CLog.i(TAG, "check local host ====> " + hostAddress.replace(".", ""));
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return str2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        com.hpplay.component.common.utils.CLog.w(TAG, (java.lang.Throwable) r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0050 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0073 A[SYNTHETIC, Splitter:B:21:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0093 A[SYNTHETIC, Splitter:B:29:0x0093] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean tcpCheckTvState(java.lang.String r8, int r9) {
        /*
            java.lang.String r0 = "OnlineCheckUtil"
            r1 = 0
            java.net.Socket r2 = new java.net.Socket     // Catch:{ Exception -> 0x0050 }
            r2.<init>()     // Catch:{ Exception -> 0x0050 }
            r1 = 1
            r2.setReuseAddress(r1)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r3 = 3000(0xbb8, float:4.204E-42)
            r2.setSoTimeout(r3)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.lang.String r4 = matchLocalIp(r8)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            if (r5 != 0) goto L_0x0038
            java.net.InetAddress r5 = java.net.InetAddress.getByName(r8)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.net.InetAddress r4 = java.net.InetAddress.getByName(r4)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            int r7 = getAvailablePort()     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r6.<init>(r4, r7)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r2.bind(r6)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r4.<init>(r5, r9)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r2.connect(r4, r3)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            goto L_0x0040
        L_0x0038:
            java.net.InetSocketAddress r4 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r4.<init>(r8, r9)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
            r2.connect(r4, r3)     // Catch:{ Exception -> 0x004c, all -> 0x0049 }
        L_0x0040:
            r2.close()     // Catch:{ IOException -> 0x0044 }
            goto L_0x007c
        L_0x0044:
            r8 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r8)
            goto L_0x007c
        L_0x0049:
            r8 = move-exception
            r1 = r2
            goto L_0x0091
        L_0x004c:
            r1 = r2
            goto L_0x0050
        L_0x004e:
            r8 = move-exception
            goto L_0x0091
        L_0x0050:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x004e }
            r9.<init>()     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "local device : "
            r9.append(r2)     // Catch:{ all -> 0x004e }
            java.lang.String r2 = "."
            java.lang.String r3 = ""
            java.lang.String r8 = r8.replace(r2, r3)     // Catch:{ all -> 0x004e }
            r9.append(r8)     // Catch:{ all -> 0x004e }
            java.lang.String r8 = " is offline"
            r9.append(r8)     // Catch:{ all -> 0x004e }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x004e }
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.String) r8)     // Catch:{ all -> 0x004e }
            if (r1 == 0) goto L_0x007b
            r1.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x007b
        L_0x0077:
            r8 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r8)
        L_0x007b:
            r1 = 0
        L_0x007c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "  check dev state "
            r8.append(r9)
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            com.hpplay.component.common.utils.CLog.i(r0, r8)
            return r1
        L_0x0091:
            if (r1 == 0) goto L_0x009b
            r1.close()     // Catch:{ IOException -> 0x0097 }
            goto L_0x009b
        L_0x0097:
            r9 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x009b:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.util.OnlineCheckUtil.tcpCheckTvState(java.lang.String, int):boolean");
    }
}
