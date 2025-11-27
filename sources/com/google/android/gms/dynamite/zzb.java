package com.google.android.gms.dynamite;

import android.os.Looper;

public final class zzb {
    private static volatile ClassLoader zza;
    private static volatile Thread zzb;

    public static synchronized ClassLoader zza() {
        ClassLoader classLoader;
        synchronized (zzb.class) {
            if (zza == null) {
                zza = zzb();
            }
            classLoader = zza;
        }
        return classLoader;
    }

    private static synchronized ClassLoader zzb() {
        synchronized (zzb.class) {
            ClassLoader classLoader = null;
            if (zzb == null) {
                zzb = zzc();
                if (zzb == null) {
                    return null;
                }
            }
            synchronized (zzb) {
                try {
                    classLoader = zzb.getContextClassLoader();
                } catch (SecurityException e10) {
                    String message = e10.getMessage();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to get thread context classloader ");
                    sb.append(message);
                }
            }
            return classLoader;
        }
    }

    private static synchronized Thread zzc() {
        zza zza2;
        zza zza3;
        SecurityException e10;
        ThreadGroup threadGroup;
        synchronized (zzb.class) {
            ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
            if (threadGroup2 == null) {
                return null;
            }
            synchronized (Void.class) {
                try {
                    int activeGroupCount = threadGroup2.activeGroupCount();
                    ThreadGroup[] threadGroupArr = new ThreadGroup[activeGroupCount];
                    threadGroup2.enumerate(threadGroupArr);
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= activeGroupCount) {
                            threadGroup = null;
                            break;
                        }
                        threadGroup = threadGroupArr[i11];
                        if ("dynamiteLoader".equals(threadGroup.getName())) {
                            break;
                        }
                        i11++;
                    }
                    if (threadGroup == null) {
                        threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                    }
                    int activeCount = threadGroup.activeCount();
                    Thread[] threadArr = new Thread[activeCount];
                    threadGroup.enumerate(threadArr);
                    while (true) {
                        if (i10 >= activeCount) {
                            zza2 = null;
                            break;
                        }
                        zza2 = threadArr[i10];
                        if ("GmsDynamite".equals(zza2.getName())) {
                            break;
                        }
                        i10++;
                    }
                    if (zza2 == null) {
                        try {
                            zza3 = new zza(threadGroup, "GmsDynamite");
                            try {
                                zza3.setContextClassLoader((ClassLoader) null);
                                zza3.start();
                            } catch (SecurityException e11) {
                                e10 = e11;
                            }
                        } catch (SecurityException e12) {
                            e10 = e12;
                            zza3 = zza2;
                            String message = e10.getMessage();
                            StringBuilder sb = new StringBuilder();
                            sb.append("Failed to enumerate thread/threadgroup ");
                            sb.append(message);
                            zza2 = zza3;
                            return zza2;
                        }
                        zza2 = zza3;
                    }
                } catch (SecurityException e13) {
                    e10 = e13;
                    zza3 = null;
                    String message2 = e10.getMessage();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to enumerate thread/threadgroup ");
                    sb2.append(message2);
                    zza2 = zza3;
                    return zza2;
                }
            }
            return zza2;
        }
    }
}
