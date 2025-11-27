package com.hpplay.common.asyncmanager;

import java.io.File;

public class FileRequest {
    public static final int TASKDONWLOADED = 1;
    public static final int TASKDONWLOADING = 0;
    public static final int TASKDOWNLOADCANCEL = 3;
    public static final int TASKDOWNLOADERROR = 2;
    private final String TAG = "FileRequest";
    private final String cacheName = ".cache";
    private boolean isShutDown = false;
    private DownloadListener mDownloadListener;
    private int mDownloadPercent;
    private long mDownloadedSize = 0;
    private String mLocalPath;
    private int mTaskCode = 0;
    private long mTotalSize;
    private String mURL;

    public interface DownloadListener {
        void onDownLoad(int i10, long j10, long j11, int i11);
    }

    public FileRequest(String str, String str2) {
        this.mLocalPath = str2;
        this.mURL = str;
    }

    private boolean renameToNewFile(String str, String str2) {
        return new File(str).renameTo(new File(str2));
    }

    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v9, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r2v16, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v20, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v24 */
    /* JADX WARNING: type inference failed for: r2v25 */
    /* JADX WARNING: type inference failed for: r2v45 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023a A[SYNTHETIC, Splitter:B:118:0x023a] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0245 A[SYNTHETIC, Splitter:B:123:0x0245] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0250 A[SYNTHETIC, Splitter:B:128:0x0250] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x025f A[SYNTHETIC, Splitter:B:136:0x025f] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x026a A[SYNTHETIC, Splitter:B:141:0x026a] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0275 A[SYNTHETIC, Splitter:B:146:0x0275] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0292 A[SYNTHETIC, Splitter:B:161:0x0292] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x029f A[SYNTHETIC, Splitter:B:166:0x029f] */
    /* JADX WARNING: Removed duplicated region for block: B:179:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean download() {
        /*
            r24 = this;
            r1 = r24
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r1.mLocalPath
            r2.append(r3)
            java.lang.String r3 = ".cache"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            boolean r2 = r0.exists()
            r4 = 0
            if (r2 == 0) goto L_0x0028
            r0.delete()
            r1.mDownloadedSize = r4
            goto L_0x002a
        L_0x0028:
            r1.mDownloadedSize = r4
        L_0x002a:
            java.io.File r2 = new java.io.File
            java.lang.String r6 = r1.mLocalPath
            r2.<init>(r6)
            boolean r6 = r2.exists()
            if (r6 == 0) goto L_0x003a
            r2.delete()
        L_0x003a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r6 = "mURL, "
            r2.append(r6)
            java.lang.String r6 = r1.mURL
            r2.append(r6)
            java.lang.String r6 = " downloadedSize, "
            r2.append(r6)
            long r6 = r1.mDownloadedSize
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            java.lang.String r6 = "FileRequest"
            com.hpplay.common.log.LeLog.i(r6, r2)
            r2 = 0
            r7 = 0
            java.net.URL r8 = new java.net.URL     // Catch:{ Exception -> 0x0289 }
            java.lang.String r9 = r1.mURL     // Catch:{ Exception -> 0x0289 }
            r8.<init>(r9)     // Catch:{ Exception -> 0x0289 }
            java.net.HttpURLConnection r9 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r8)     // Catch:{ Exception -> 0x0289 }
            java.lang.String r10 = "Accept-Encoding"
            java.lang.String r11 = "identity"
            r9.setRequestProperty(r10, r11)     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            int r10 = r9.getContentLength()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            long r10 = (long) r10     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r1.mTotalSize = r10     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r10.<init>()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            java.lang.String r11 = "totalSize, "
            r10.append(r11)     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            long r11 = r1.mTotalSize     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r10.append(r11)     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            com.hpplay.common.log.LeLog.i(r6, r10)     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            long r10 = r1.mTotalSize     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            int r12 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r12 != 0) goto L_0x00a0
            r24.makeDownLoadError()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r9.disconnect()     // Catch:{ Exception -> 0x009a }
            goto L_0x009f
        L_0x009a:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x009f:
            return r7
        L_0x00a0:
            long r12 = r1.mDownloadedSize     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r14 = 1
            int r15 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r15 != 0) goto L_0x00b1
            r9.disconnect()     // Catch:{ Exception -> 0x00ab }
            goto L_0x00b0
        L_0x00ab:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x00b0:
            return r14
        L_0x00b1:
            int r15 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x00c8
            boolean r0 = r0.delete()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            if (r0 != 0) goto L_0x00c8
            r24.makeDownLoadError()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r9.disconnect()     // Catch:{ Exception -> 0x00c2 }
            goto L_0x00c7
        L_0x00c2:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x00c7:
            return r7
        L_0x00c8:
            r9.disconnect()     // Catch:{ Exception -> 0x0283, all -> 0x027f }
            r9.disconnect()     // Catch:{ Exception -> 0x00cf }
            goto L_0x00d4
        L_0x00cf:
            r0 = move-exception
            r10 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r10)
        L_0x00d4:
            java.net.HttpURLConnection r9 = com.hpplay.common.utils.CertUtils.getHttpURLConnection(r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Accept"
            java.lang.String r8 = "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*"
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Accept-Language"
            java.lang.String r8 = "zh-CN"
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Referer"
            java.lang.String r8 = r1.mURL     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Charset"
            java.lang.String r8 = "UTF-8"
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Range"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            r8.<init>()     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r10 = "bytes="
            r8.append(r10)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            long r10 = r1.mDownloadedSize     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            r8.append(r10)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r10 = "-"
            r8.append(r10)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.lang.String r0 = "Connection"
            java.lang.String r8 = "Keep-Alive"
            r9.setRequestProperty(r0, r8)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            r0 = 30000(0x7530, float:4.2039E-41)
            r9.setConnectTimeout(r0)     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.io.InputStream r8 = r9.getInputStream()     // Catch:{ Exception -> 0x0229, all -> 0x0225 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            r10.<init>()     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            java.lang.String r11 = r1.mLocalPath     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            r10.append(r11)     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            r10.append(r3)     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            r0.<init>(r10)     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            java.io.RandomAccessFile r10 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            java.lang.String r11 = "rwd"
            r10.<init>(r0, r11)     // Catch:{ Exception -> 0x021e, all -> 0x0216 }
            long r11 = r1.mDownloadedSize     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            r10.seek(r11)     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            long r11 = r1.mTotalSize     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            int r0 = (int) r11     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            r2 = 1024(0x400, float:1.435E-42)
            int r0 = r0 / r2
            int r0 = r0 / 100
            byte[] r11 = new byte[r2]     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            r12 = 0
        L_0x014e:
            int r13 = r8.read(r11, r7, r2)     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            r15 = -1
            if (r13 == r15) goto L_0x019a
            boolean r15 = r1.isShutDown     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            if (r15 != 0) goto L_0x019a
            r10.write(r11, r7, r13)     // Catch:{ Exception -> 0x0212, all -> 0x020d }
            int r12 = r12 + r14
            if (r12 != r0) goto L_0x0187
            r22 = r8
            long r7 = r1.mDownloadedSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r23 = r3
            long r2 = r1.mTotalSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            int r15 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r15 >= 0) goto L_0x018b
            r15 = 100
            long r15 = r15 * r7
            long r14 = r15 / r2
            int r12 = (int) r14     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r1.mDownloadPercent = r12     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            com.hpplay.common.asyncmanager.FileRequest$DownloadListener r15 = r1.mDownloadListener     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            if (r15 == 0) goto L_0x0185
            int r12 = r1.mTaskCode     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r21 = 0
            r16 = r12
            r17 = r7
            r19 = r2
            r15.onDownLoad(r16, r17, r19, r21)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
        L_0x0185:
            r12 = 0
            goto L_0x018b
        L_0x0187:
            r23 = r3
            r22 = r8
        L_0x018b:
            long r2 = r1.mDownloadedSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            long r7 = (long) r13     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            long r2 = r2 + r7
            r1.mDownloadedSize = r2     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r8 = r22
            r3 = r23
            r2 = 1024(0x400, float:1.435E-42)
            r7 = 0
            r14 = 1
            goto L_0x014e
        L_0x019a:
            r23 = r3
            r22 = r8
            boolean r0 = r1.isShutDown     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            if (r0 == 0) goto L_0x01b3
            com.hpplay.common.asyncmanager.FileRequest$DownloadListener r11 = r1.mDownloadListener     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            if (r11 == 0) goto L_0x01b1
            int r12 = r1.mTaskCode     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            long r2 = r1.mTotalSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r17 = 3
            r13 = r2
            r15 = r2
            r11.onDownLoad(r12, r13, r15, r17)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
        L_0x01b1:
            r7 = 0
            goto L_0x01eb
        L_0x01b3:
            long r2 = r1.mDownloadedSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            long r7 = r1.mTotalSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 < 0) goto L_0x01db
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01db
            int r0 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x01db
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r0.<init>()     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            java.lang.String r2 = r1.mLocalPath     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r0.append(r2)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r2 = r23
            r0.append(r2)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            java.lang.String r2 = r1.mLocalPath     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r1.renameToNewFile(r0, r2)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
        L_0x01db:
            com.hpplay.common.asyncmanager.FileRequest$DownloadListener r11 = r1.mDownloadListener     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            if (r11 == 0) goto L_0x01ea
            int r12 = r1.mTaskCode     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            long r2 = r1.mTotalSize     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
            r17 = 1
            r13 = r2
            r15 = r2
            r11.onDownLoad(r12, r13, r15, r17)     // Catch:{ Exception -> 0x020b, all -> 0x0209 }
        L_0x01ea:
            r7 = 1
        L_0x01eb:
            r22.close()     // Catch:{ Exception -> 0x01ef }
            goto L_0x01f4
        L_0x01ef:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x01f4:
            r9.disconnect()     // Catch:{ Exception -> 0x01f8 }
            goto L_0x01fd
        L_0x01f8:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x01fd:
            r10.close()     // Catch:{ Exception -> 0x0202 }
            goto L_0x025a
        L_0x0202:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
            goto L_0x025a
        L_0x0209:
            r0 = move-exception
            goto L_0x0210
        L_0x020b:
            r0 = move-exception
            goto L_0x0222
        L_0x020d:
            r0 = move-exception
            r22 = r8
        L_0x0210:
            r3 = r0
            goto L_0x021b
        L_0x0212:
            r0 = move-exception
            r22 = r8
            goto L_0x0222
        L_0x0216:
            r0 = move-exception
            r22 = r8
            r3 = r0
            r10 = r2
        L_0x021b:
            r2 = r22
            goto L_0x025d
        L_0x021e:
            r0 = move-exception
            r22 = r8
            r10 = r2
        L_0x0222:
            r2 = r22
            goto L_0x022b
        L_0x0225:
            r0 = move-exception
            r3 = r0
            r10 = r2
            goto L_0x025d
        L_0x0229:
            r0 = move-exception
            r10 = r2
        L_0x022b:
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x025b }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x025b }
            com.hpplay.common.log.LeLog.i(r6, r0)     // Catch:{ all -> 0x025b }
            r24.makeDownLoadError()     // Catch:{ all -> 0x025b }
            if (r2 == 0) goto L_0x0243
            r2.close()     // Catch:{ Exception -> 0x023e }
            goto L_0x0243
        L_0x023e:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0243:
            if (r9 == 0) goto L_0x024e
            r9.disconnect()     // Catch:{ Exception -> 0x0249 }
            goto L_0x024e
        L_0x0249:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x024e:
            if (r10 == 0) goto L_0x0259
            r10.close()     // Catch:{ Exception -> 0x0254 }
            goto L_0x0259
        L_0x0254:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0259:
            r7 = 0
        L_0x025a:
            return r7
        L_0x025b:
            r0 = move-exception
            r3 = r0
        L_0x025d:
            if (r2 == 0) goto L_0x0268
            r2.close()     // Catch:{ Exception -> 0x0263 }
            goto L_0x0268
        L_0x0263:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0268:
            if (r9 == 0) goto L_0x0273
            r9.disconnect()     // Catch:{ Exception -> 0x026e }
            goto L_0x0273
        L_0x026e:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x0273:
            if (r10 == 0) goto L_0x027e
            r10.close()     // Catch:{ Exception -> 0x0279 }
            goto L_0x027e
        L_0x0279:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x027e:
            throw r3
        L_0x027f:
            r0 = move-exception
            r3 = r0
            r2 = r9
            goto L_0x029d
        L_0x0283:
            r0 = move-exception
            r2 = r9
            goto L_0x028a
        L_0x0286:
            r0 = move-exception
            r3 = r0
            goto L_0x029d
        L_0x0289:
            r0 = move-exception
        L_0x028a:
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0286 }
            r24.makeDownLoadError()     // Catch:{ all -> 0x0286 }
            if (r2 == 0) goto L_0x029b
            r2.disconnect()     // Catch:{ Exception -> 0x0296 }
            goto L_0x029b
        L_0x0296:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x029b:
            r2 = 0
            return r2
        L_0x029d:
            if (r2 == 0) goto L_0x02a8
            r2.disconnect()     // Catch:{ Exception -> 0x02a3 }
            goto L_0x02a8
        L_0x02a3:
            r0 = move-exception
            r2 = r0
            com.hpplay.common.log.LeLog.w((java.lang.String) r6, (java.lang.Throwable) r2)
        L_0x02a8:
            goto L_0x02aa
        L_0x02a9:
            throw r3
        L_0x02aa:
            goto L_0x02a9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.asyncmanager.FileRequest.download():boolean");
    }

    public void makeDownLoadError() {
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onDownLoad(this.mTaskCode, this.mDownloadedSize, this.mTotalSize, 2);
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public void setTaskCode(int i10) {
        this.mTaskCode = i10;
    }

    public void shutDown() {
        this.isShutDown = true;
    }
}
