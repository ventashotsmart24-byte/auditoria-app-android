package com.google.android.gms.internal.measurement;

import javax.annotation.concurrent.GuardedBy;

public final class zzho {
    @GuardedBy("CachingReader.class")
    private static volatile zzig zza;

    private zzho() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x0153 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzig zza(android.content.Context r14) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzho> r0 = com.google.android.gms.internal.measurement.zzho.class
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzig r1 = zza     // Catch:{ all -> 0x016e }
            if (r1 != 0) goto L_0x016c
            java.lang.String r1 = android.os.Build.TYPE     // Catch:{ all -> 0x016e }
            java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "eng"
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x016e }
            if (r3 != 0) goto L_0x001b
            java.lang.String r3 = "userdebug"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x016e }
            if (r1 == 0) goto L_0x002c
        L_0x001b:
            java.lang.String r1 = "dev-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x016e }
            if (r1 != 0) goto L_0x0033
            java.lang.String r1 = "test-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x016e }
            if (r1 == 0) goto L_0x002c
            goto L_0x0033
        L_0x002c:
            com.google.android.gms.internal.measurement.zzig r14 = com.google.android.gms.internal.measurement.zzig.zzc()     // Catch:{ all -> 0x016e }
        L_0x0030:
            r1 = r14
            goto L_0x0164
        L_0x0033:
            boolean r1 = com.google.android.gms.internal.measurement.zzhb.zzb()     // Catch:{ all -> 0x016e }
            if (r1 == 0) goto L_0x0043
            boolean r1 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x016e }
            if (r1 != 0) goto L_0x0043
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x016e }
        L_0x0043:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x016e }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0167 }
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x0068 }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r4 = r14.getDir(r4, r2)     // Catch:{ RuntimeException -> 0x0068 }
            java.lang.String r5 = "overrides.txt"
            r3.<init>(r4, r5)     // Catch:{ RuntimeException -> 0x0068 }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0167 }
            if (r4 == 0) goto L_0x0063
            com.google.android.gms.internal.measurement.zzig r3 = com.google.android.gms.internal.measurement.zzig.zzd(r3)     // Catch:{ all -> 0x0167 }
            goto L_0x0074
        L_0x0063:
            com.google.android.gms.internal.measurement.zzig r3 = com.google.android.gms.internal.measurement.zzig.zzc()     // Catch:{ all -> 0x0167 }
            goto L_0x0074
        L_0x0068:
            r3 = move-exception
            java.lang.String r4 = "HermeticFileOverrides"
            java.lang.String r5 = "no data dir"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x0167 }
            com.google.android.gms.internal.measurement.zzig r3 = com.google.android.gms.internal.measurement.zzig.zzc()     // Catch:{ all -> 0x0167 }
        L_0x0074:
            boolean r4 = r3.zzb()     // Catch:{ all -> 0x0167 }
            if (r4 == 0) goto L_0x015b
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x0167 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0167 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0154 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0154 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0154 }
            r6.<init>(r3)     // Catch:{ IOException -> 0x0154 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0154 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0154 }
            r5 = 1
            androidx.collection.g r6 = new androidx.collection.g     // Catch:{ all -> 0x0138 }
            r6.<init>()     // Catch:{ all -> 0x0138 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0138 }
            r7.<init>()     // Catch:{ all -> 0x0138 }
        L_0x009a:
            java.lang.String r8 = r4.readLine()     // Catch:{ all -> 0x0138 }
            if (r8 == 0) goto L_0x010e
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x0138 }
            int r11 = r9.length     // Catch:{ all -> 0x0138 }
            if (r11 == r10) goto L_0x00c1
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            r9.<init>()     // Catch:{ all -> 0x0138 }
            java.lang.String r10 = "Invalid: "
            r9.append(r10)     // Catch:{ all -> 0x0138 }
            r9.append(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = "HermeticFileOverrides"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0138 }
            android.util.Log.e(r8, r9)     // Catch:{ all -> 0x0138 }
            goto L_0x009a
        L_0x00c1:
            r8 = r9[r2]     // Catch:{ all -> 0x0138 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0138 }
            r10.<init>(r8)     // Catch:{ all -> 0x0138 }
            r8 = r9[r5]     // Catch:{ all -> 0x0138 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0138 }
            r11.<init>(r8)     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0138 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x0138 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x0138 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0138 }
            if (r12 != 0) goto L_0x00f6
            r9 = r9[r11]     // Catch:{ all -> 0x0138 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0138 }
            r11.<init>(r9)     // Catch:{ all -> 0x0138 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0138 }
            int r9 = r12.length()     // Catch:{ all -> 0x0138 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00f3
            if (r12 != r11) goto L_0x00f6
        L_0x00f3:
            r7.put(r11, r12)     // Catch:{ all -> 0x0138 }
        L_0x00f6:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x0138 }
            if (r9 != 0) goto L_0x0104
            androidx.collection.g r9 = new androidx.collection.g     // Catch:{ all -> 0x0138 }
            r9.<init>()     // Catch:{ all -> 0x0138 }
            r6.put(r10, r9)     // Catch:{ all -> 0x0138 }
        L_0x0104:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x0138 }
            androidx.collection.g r9 = (androidx.collection.g) r9     // Catch:{ all -> 0x0138 }
            r9.put(r8, r12)     // Catch:{ all -> 0x0138 }
            goto L_0x009a
        L_0x010e:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0138 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x0138 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0138 }
            r7.<init>()     // Catch:{ all -> 0x0138 }
            java.lang.String r8 = "Parsed "
            r7.append(r8)     // Catch:{ all -> 0x0138 }
            r7.append(r3)     // Catch:{ all -> 0x0138 }
            java.lang.String r3 = " for Android package "
            r7.append(r3)     // Catch:{ all -> 0x0138 }
            r7.append(r14)     // Catch:{ all -> 0x0138 }
            com.google.android.gms.internal.measurement.zzhh r14 = new com.google.android.gms.internal.measurement.zzhh     // Catch:{ all -> 0x0138 }
            r14.<init>(r6)     // Catch:{ all -> 0x0138 }
            r4.close()     // Catch:{ IOException -> 0x0154 }
            com.google.android.gms.internal.measurement.zzig r14 = com.google.android.gms.internal.measurement.zzig.zzd(r14)     // Catch:{ all -> 0x0167 }
            goto L_0x015f
        L_0x0138:
            r14 = move-exception
            r4.close()     // Catch:{ all -> 0x013d }
            goto L_0x0153
        L_0x013d:
            r3 = move-exception
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0153 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            r4[r2] = r6     // Catch:{ Exception -> 0x0153 }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            java.lang.String r7 = "addSuppressed"
            java.lang.reflect.Method r4 = r6.getDeclaredMethod(r7, r4)     // Catch:{ Exception -> 0x0153 }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0153 }
            r5[r2] = r3     // Catch:{ Exception -> 0x0153 }
            r4.invoke(r14, r5)     // Catch:{ Exception -> 0x0153 }
        L_0x0153:
            throw r14     // Catch:{ IOException -> 0x0154 }
        L_0x0154:
            r14 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0167 }
            r2.<init>(r14)     // Catch:{ all -> 0x0167 }
            throw r2     // Catch:{ all -> 0x0167 }
        L_0x015b:
            com.google.android.gms.internal.measurement.zzig r14 = com.google.android.gms.internal.measurement.zzig.zzc()     // Catch:{ all -> 0x0167 }
        L_0x015f:
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x016e }
            goto L_0x0030
        L_0x0164:
            zza = r1     // Catch:{ all -> 0x016e }
            goto L_0x016c
        L_0x0167:
            r14 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x016e }
            throw r14     // Catch:{ all -> 0x016e }
        L_0x016c:
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return r1
        L_0x016e:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            goto L_0x0172
        L_0x0171:
            throw r14
        L_0x0172:
            goto L_0x0171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(android.content.Context):com.google.android.gms.internal.measurement.zzig");
    }
}
