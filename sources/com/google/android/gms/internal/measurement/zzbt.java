package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;

public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 6
            r3 = 0
            java.lang.String r4 = "JobSchedulerCompat"
            r5 = 0
            r6 = 24
            if (r1 < r6) goto L_0x0038
            r1 = 4
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.Class r7 = com.google.android.gms.internal.measurement.a.a()     // Catch:{ NoSuchMethodException -> 0x002c }
            r1[r3] = r7     // Catch:{ NoSuchMethodException -> 0x002c }
            r7 = 1
            r1[r7] = r0     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x002c }
            r8 = 2
            r1[r8] = r7     // Catch:{ NoSuchMethodException -> 0x002c }
            r7 = 3
            r1[r7] = r0     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.Class r0 = p.e.a()     // Catch:{ NoSuchMethodException -> 0x002c }
            java.lang.String r7 = "scheduleAsPackage"
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r7, r1)     // Catch:{ NoSuchMethodException -> 0x002c }
            goto L_0x0039
        L_0x002c:
            boolean r0 = android.util.Log.isLoggable(r4, r2)
            if (r0 == 0) goto L_0x0038
            java.lang.String r0 = "No scheduleAsPackage method available, falling back to schedule"
            android.util.Log.e(r4, r0)
        L_0x0038:
            r0 = r5
        L_0x0039:
            zza = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 < r6) goto L_0x0056
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.String r1 = "myUserId"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x004a }
            java.lang.reflect.Method r5 = r0.getDeclaredMethod(r1, r3)     // Catch:{ NoSuchMethodException -> 0x004a }
            goto L_0x0056
        L_0x004a:
            boolean r0 = android.util.Log.isLoggable(r4, r2)
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = "No myUserId method available"
            android.util.Log.e(r4, r0)
        L_0x0056:
            zzb = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.<clinit>():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(android.content.Context r5, android.app.job.JobInfo r6, java.lang.String r7, java.lang.String r8) {
        /*
            java.lang.String r7 = "jobscheduler"
            java.lang.Object r7 = r5.getSystemService(r7)
            android.app.job.JobScheduler r7 = e1.v.a(r7)
            r7.getClass()
            java.lang.reflect.Method r8 = zza
            if (r8 == 0) goto L_0x0076
            java.lang.String r8 = "android.permission.UPDATE_DEVICE_STATS"
            int r5 = r5.checkSelfPermission(r8)
            if (r5 == 0) goto L_0x001a
            goto L_0x0076
        L_0x001a:
            java.lang.reflect.Method r5 = zzb
            r8 = 0
            if (r5 == 0) goto L_0x0041
            java.lang.Class<android.os.UserHandle> r0 = android.os.UserHandle.class
            java.lang.Object[] r1 = new java.lang.Object[r8]     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            java.lang.Object r5 = r5.invoke(r0, r1)     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            if (r5 == 0) goto L_0x0041
            int r5 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x0032, InvocationTargetException -> 0x0030 }
            goto L_0x0042
        L_0x0030:
            r5 = move-exception
            goto L_0x0033
        L_0x0032:
            r5 = move-exception
        L_0x0033:
            r0 = 6
            java.lang.String r1 = "JobSchedulerCompat"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = "myUserId invocation illegal"
            android.util.Log.e(r1, r0, r5)
        L_0x0041:
            r5 = 0
        L_0x0042:
            java.lang.reflect.Method r0 = zza
            java.lang.String r1 = "com.google.android.gms"
            java.lang.String r2 = "UploadAlarm"
            if (r0 == 0) goto L_0x0071
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r3[r8] = r6     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r4 = 1
            r3[r4] = r1     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r1 = 2
            r3[r1] = r5     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            r5 = 3
            r3[r5] = r2     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.Object r5 = r0.invoke(r7, r3)     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            if (r5 == 0) goto L_0x0075
            int r8 = r5.intValue()     // Catch:{ IllegalAccessException -> 0x006b, InvocationTargetException -> 0x0069 }
            goto L_0x0075
        L_0x0069:
            r5 = move-exception
            goto L_0x006c
        L_0x006b:
            r5 = move-exception
        L_0x006c:
            java.lang.String r8 = "error calling scheduleAsPackage"
            android.util.Log.e(r2, r8, r5)
        L_0x0071:
            int r8 = r7.schedule(r6)
        L_0x0075:
            return r8
        L_0x0076:
            int r5 = r7.schedule(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzbt.zza(android.content.Context, android.app.job.JobInfo, java.lang.String, java.lang.String):int");
    }
}
