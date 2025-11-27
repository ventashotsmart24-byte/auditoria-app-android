package com.umeng.message.proguard;

import java.io.File;
import java.util.List;

final class cu {

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final File f15692a;

        public a(File file) {
            this.f15692a = file;
        }

        private static long a(List<File> list) {
            long j10 = 0;
            for (File length : list) {
                j10 += length.length();
            }
            return j10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0074 A[Catch:{ all -> 0x0062, all -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x007a A[Catch:{ all -> 0x0062, all -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0097 A[Catch:{ all -> 0x0062, all -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00c2 A[Catch:{ all -> 0x0062, all -> 0x00e2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0091 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r13 = this;
                java.lang.String r0 = ""
                java.io.File r1 = r13.f15692a
                if (r1 != 0) goto L_0x0007
                return
            L_0x0007:
                r2 = 1
                r3 = 0
                boolean r4 = r1.exists()     // Catch:{ all -> 0x00e2 }
                r5 = 0
                if (r4 == 0) goto L_0x0067
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e2 }
                long r8 = r1.lastModified()     // Catch:{ all -> 0x00e2 }
                long r8 = r6 - r8
                r10 = 60000(0xea60, double:2.9644E-319)
                int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r4 < 0) goto L_0x0067
                boolean r4 = r1.setLastModified(r6)     // Catch:{ all -> 0x00e2 }
                if (r4 != 0) goto L_0x0067
                long r6 = r1.length()     // Catch:{ all -> 0x00e2 }
                r8 = 0
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 != 0) goto L_0x0035
                r1.delete()     // Catch:{ all -> 0x00e2 }
                goto L_0x0067
            L_0x0035:
                java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0052 }
                java.lang.String r8 = "rwd"
                r4.<init>(r1, r8)     // Catch:{ all -> 0x0052 }
                r8 = 1
                long r6 = r6 - r8
                r4.seek(r6)     // Catch:{ all -> 0x0050 }
                byte r1 = r4.readByte()     // Catch:{ all -> 0x0050 }
                r4.seek(r6)     // Catch:{ all -> 0x0050 }
                r4.write(r1)     // Catch:{ all -> 0x0050 }
            L_0x004c:
                com.umeng.message.proguard.eb.a(r4)     // Catch:{ all -> 0x00e2 }
                goto L_0x0067
            L_0x0050:
                r1 = move-exception
                goto L_0x0054
            L_0x0052:
                r1 = move-exception
                r4 = r5
            L_0x0054:
                java.lang.String r6 = "FileUtils"
                java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x0062 }
                java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0062 }
                r7[r3] = r1     // Catch:{ all -> 0x0062 }
                com.umeng.message.proguard.ce.d(r6, r7)     // Catch:{ all -> 0x0062 }
                goto L_0x004c
            L_0x0062:
                r1 = move-exception
                com.umeng.message.proguard.eb.a(r4)     // Catch:{ all -> 0x00e2 }
                throw r1     // Catch:{ all -> 0x00e2 }
            L_0x0067:
                java.io.File r1 = r13.f15692a     // Catch:{ all -> 0x00e2 }
                java.io.File r1 = r1.getParentFile()     // Catch:{ all -> 0x00e2 }
                java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x00e2 }
                r4.<init>()     // Catch:{ all -> 0x00e2 }
                if (r1 == 0) goto L_0x0078
                java.io.File[] r5 = r1.listFiles()     // Catch:{ all -> 0x00e2 }
            L_0x0078:
                if (r5 == 0) goto L_0x0085
                java.util.Collections.addAll(r4, r5)     // Catch:{ all -> 0x00e2 }
                com.umeng.message.proguard.ea$1 r1 = new com.umeng.message.proguard.ea$1     // Catch:{ all -> 0x00e2 }
                r1.<init>()     // Catch:{ all -> 0x00e2 }
                java.util.Collections.sort(r4, r1)     // Catch:{ all -> 0x00e2 }
            L_0x0085:
                long r5 = a(r4)     // Catch:{ all -> 0x00e2 }
                int r1 = r4.size()     // Catch:{ all -> 0x00e2 }
                java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00e2 }
            L_0x0091:
                boolean r7 = r4.hasNext()     // Catch:{ all -> 0x00e2 }
                if (r7 == 0) goto L_0x00e1
                java.lang.Object r7 = r4.next()     // Catch:{ all -> 0x00e2 }
                java.io.File r7 = (java.io.File) r7     // Catch:{ all -> 0x00e2 }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00e2 }
                long r10 = r7.lastModified()     // Catch:{ all -> 0x00e2 }
                long r8 = r8 - r10
                r10 = 259200000(0xf731400, double:1.280618154E-315)
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 < 0) goto L_0x00af
            L_0x00ad:
                r8 = 0
                goto L_0x00c0
            L_0x00af:
                r8 = 268435456(0x10000000, double:1.32624737E-315)
                int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
                if (r10 < 0) goto L_0x00b7
                goto L_0x00ad
            L_0x00b7:
                long r8 = (long) r1     // Catch:{ all -> 0x00e2 }
                r10 = 30
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 < 0) goto L_0x00bf
                goto L_0x00ad
            L_0x00bf:
                r8 = 1
            L_0x00c0:
                if (r8 != 0) goto L_0x0091
                long r8 = r7.length()     // Catch:{ all -> 0x00e2 }
                boolean r10 = r7.delete()     // Catch:{ all -> 0x00e2 }
                if (r10 == 0) goto L_0x0091
                int r1 = r1 + -1
                long r5 = r5 - r8
                java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00e2 }
                java.lang.String r9 = "cache file deleted:"
                java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x00e2 }
                java.lang.String r7 = r9.concat(r7)     // Catch:{ all -> 0x00e2 }
                r8[r3] = r7     // Catch:{ all -> 0x00e2 }
                com.umeng.message.proguard.ce.a(r0, r8)     // Catch:{ all -> 0x00e2 }
                goto L_0x0091
            L_0x00e1:
                return
            L_0x00e2:
                r1 = move-exception
                r4 = 2
                java.lang.Object[] r4 = new java.lang.Object[r4]
                java.lang.String r5 = "check file error:"
                r4[r3] = r5
                java.lang.String r1 = r1.getMessage()
                r4[r2] = r1
                com.umeng.message.proguard.ce.d(r0, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.cu.a.run():void");
        }
    }

    public static void a(File file) {
        cb.b(new a(file));
    }
}
