package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import sun.misc.Unsafe;

final class zzrn {
    static final long zza = ((long) zzz(byte[].class));
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class<?> zzd = zznt.zza();
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzrm zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0136  */
    static {
        /*
            java.lang.Class<java.lang.Class> r0 = java.lang.Class.class
            sun.misc.Unsafe r1 = zzg()
            zzc = r1
            java.lang.Class r2 = com.google.android.gms.internal.cast.zznt.zza()
            zzd = r2
            java.lang.Class r2 = java.lang.Long.TYPE
            boolean r3 = zzv(r2)
            zze = r3
            java.lang.Class r4 = java.lang.Integer.TYPE
            boolean r4 = zzv(r4)
            zzf = r4
            r5 = 0
            if (r1 != 0) goto L_0x0022
            goto L_0x0031
        L_0x0022:
            if (r3 == 0) goto L_0x002a
            com.google.android.gms.internal.cast.zzrl r5 = new com.google.android.gms.internal.cast.zzrl
            r5.<init>(r1)
            goto L_0x0031
        L_0x002a:
            if (r4 == 0) goto L_0x0031
            com.google.android.gms.internal.cast.zzrk r5 = new com.google.android.gms.internal.cast.zzrk
            r5.<init>(r1)
        L_0x0031:
            zzg = r5
            java.lang.String r1 = "getLong"
            java.lang.String r3 = "objectFieldOffset"
            java.lang.Class<java.lang.reflect.Field> r4 = java.lang.reflect.Field.class
            r6 = 2
            java.lang.Class<java.lang.Object> r7 = java.lang.Object.class
            r8 = 1
            r9 = 0
            if (r5 != 0) goto L_0x0042
        L_0x0040:
            r2 = 0
            goto L_0x0069
        L_0x0042:
            sun.misc.Unsafe r5 = r5.zza
            if (r5 != 0) goto L_0x0047
            goto L_0x0040
        L_0x0047:
            java.lang.Class r5 = r5.getClass()     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r10 = new java.lang.Class[r8]     // Catch:{ all -> 0x0064 }
            r10[r9] = r4     // Catch:{ all -> 0x0064 }
            r5.getMethod(r3, r10)     // Catch:{ all -> 0x0064 }
            java.lang.Class[] r10 = new java.lang.Class[r6]     // Catch:{ all -> 0x0064 }
            r10[r9] = r7     // Catch:{ all -> 0x0064 }
            r10[r8] = r2     // Catch:{ all -> 0x0064 }
            r5.getMethod(r1, r10)     // Catch:{ all -> 0x0064 }
            java.lang.reflect.Field r2 = zzB()     // Catch:{ all -> 0x0064 }
            if (r2 != 0) goto L_0x0062
            goto L_0x0040
        L_0x0062:
            r2 = 1
            goto L_0x0069
        L_0x0064:
            r2 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.cast.zzrn.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r2.toString()))
            goto L_0x0040
        L_0x0069:
            zzh = r2
            com.google.android.gms.internal.cast.zzrm r2 = zzg
            if (r2 != 0) goto L_0x0071
        L_0x006f:
            r0 = 0
            goto L_0x00e5
        L_0x0071:
            sun.misc.Unsafe r2 = r2.zza
            if (r2 != 0) goto L_0x0076
            goto L_0x006f
        L_0x0076:
            java.lang.Class r2 = r2.getClass()     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r5 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e0 }
            r5[r9] = r4     // Catch:{ all -> 0x00e0 }
            r2.getMethod(r3, r5)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e0 }
            r3[r9] = r0     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "arrayBaseOffset"
            r2.getMethod(r4, r3)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r3 = new java.lang.Class[r8]     // Catch:{ all -> 0x00e0 }
            r3[r9] = r0     // Catch:{ all -> 0x00e0 }
            java.lang.String r0 = "arrayIndexScale"
            r2.getMethod(r0, r3)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r0 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e0 }
            r0[r9] = r7     // Catch:{ all -> 0x00e0 }
            java.lang.Class r3 = java.lang.Long.TYPE     // Catch:{ all -> 0x00e0 }
            r0[r8] = r3     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "getInt"
            r2.getMethod(r4, r0)     // Catch:{ all -> 0x00e0 }
            r0 = 3
            java.lang.Class[] r4 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e0 }
            r4[r9] = r7     // Catch:{ all -> 0x00e0 }
            r4[r8] = r3     // Catch:{ all -> 0x00e0 }
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch:{ all -> 0x00e0 }
            r4[r6] = r5     // Catch:{ all -> 0x00e0 }
            java.lang.String r5 = "putInt"
            r2.getMethod(r5, r4)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r4 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e0 }
            r4[r9] = r7     // Catch:{ all -> 0x00e0 }
            r4[r8] = r3     // Catch:{ all -> 0x00e0 }
            r2.getMethod(r1, r4)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e0 }
            r1[r9] = r7     // Catch:{ all -> 0x00e0 }
            r1[r8] = r3     // Catch:{ all -> 0x00e0 }
            r1[r6] = r3     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "putLong"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r1 = new java.lang.Class[r6]     // Catch:{ all -> 0x00e0 }
            r1[r9] = r7     // Catch:{ all -> 0x00e0 }
            r1[r8] = r3     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "getObject"
            r2.getMethod(r4, r1)     // Catch:{ all -> 0x00e0 }
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ all -> 0x00e0 }
            r0[r9] = r7     // Catch:{ all -> 0x00e0 }
            r0[r8] = r3     // Catch:{ all -> 0x00e0 }
            r0[r6] = r7     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = "putObject"
            r2.getMethod(r1, r0)     // Catch:{ all -> 0x00e0 }
            r0 = 1
            goto L_0x00e5
        L_0x00e0:
            r0 = move-exception
            java.util.logging.Logger.getLogger(com.google.android.gms.internal.cast.zzrn.class.getName()).logp(java.util.logging.Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(r0.toString()))
            goto L_0x006f
        L_0x00e5:
            zzi = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzz(r0)
            long r0 = (long) r0
            zza = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<int[]> r0 = int[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<long[]> r0 = long[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<float[]> r0 = float[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<double[]> r0 = double[].class
            zzz(r0)
            zzA(r0)
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            zzz(r0)
            zzA(r0)
            java.lang.reflect.Field r0 = zzB()
            if (r0 == 0) goto L_0x012d
            com.google.android.gms.internal.cast.zzrm r1 = zzg
            if (r1 == 0) goto L_0x012d
            r1.zzl(r0)
        L_0x012d:
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x0136
            goto L_0x0137
        L_0x0136:
            r8 = 0
        L_0x0137:
            zzb = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzrn.<clinit>():void");
    }

    private zzrn() {
    }

    private static int zzA(Class<?> cls) {
        if (zzi) {
            return zzg.zzi(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i10 = zznt.zza;
        Class<Buffer> cls = Buffer.class;
        Field zzC = zzC(cls, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(cls, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzD(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        zzrm zzrm = zzg;
        int i10 = ((((int) j10) ^ -1) & 3) << 3;
        zzrm.zzn(obj, j11, ((255 & b10) << i10) | (zzrm.zzj(obj, j11) & ((255 << i10) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzE(Object obj, long j10, byte b10) {
        long j11 = -4 & j10;
        zzrm zzrm = zzg;
        int i10 = (((int) j10) & 3) << 3;
        zzrm.zzn(obj, j11, ((255 & b10) << i10) | (zzrm.zzj(obj, j11) & ((255 << i10) ^ -1)));
    }

    public static double zza(Object obj, long j10) {
        return zzg.zza(obj, j10);
    }

    public static float zzb(Object obj, long j10) {
        return zzg.zzb(obj, j10);
    }

    public static int zzc(Object obj, long j10) {
        return zzg.zzj(obj, j10);
    }

    public static long zzd(Object obj, long j10) {
        return zzg.zzk(obj, j10);
    }

    public static <T> T zze(Class<T> cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static Object zzf(Object obj, long j10) {
        return zzg.zzm(obj, j10);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzrj());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzm(Object obj, long j10, boolean z10) {
        zzg.zzc(obj, j10, z10);
    }

    public static void zzn(byte[] bArr, long j10, byte b10) {
        zzg.zzd(bArr, zza + j10, b10);
    }

    public static void zzo(Object obj, long j10, double d10) {
        zzg.zze(obj, j10, d10);
    }

    public static void zzp(Object obj, long j10, float f10) {
        zzg.zzf(obj, j10, f10);
    }

    public static void zzq(Object obj, long j10, int i10) {
        zzg.zzn(obj, j10, i10);
    }

    public static void zzr(Object obj, long j10, long j11) {
        zzg.zzo(obj, j10, j11);
    }

    public static void zzs(Object obj, long j10, Object obj2) {
        zzg.zzp(obj, j10, obj2);
    }

    public static /* synthetic */ boolean zzt(Object obj, long j10) {
        if (((byte) ((zzg.zzj(obj, -4 & j10) >>> ((int) (((j10 ^ -1) & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ boolean zzu(Object obj, long j10) {
        if (((byte) ((zzg.zzj(obj, -4 & j10) >>> ((int) ((j10 & 3) << 3))) & 255)) != 0) {
            return true;
        }
        return false;
    }

    public static boolean zzv(Class<?> cls) {
        Class<byte[]> cls2 = byte[].class;
        int i10 = zznt.zza;
        try {
            Class<?> cls3 = zzd;
            Class cls4 = Boolean.TYPE;
            cls3.getMethod("peekLong", new Class[]{cls, cls4});
            cls3.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls4});
            Class cls5 = Integer.TYPE;
            cls3.getMethod("pokeInt", new Class[]{cls, cls5, cls4});
            cls3.getMethod("peekInt", new Class[]{cls, cls4});
            cls3.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls3.getMethod("peekByte", new Class[]{cls});
            cls3.getMethod("pokeByteArray", new Class[]{cls, cls2, cls5, cls5});
            cls3.getMethod("peekByteArray", new Class[]{cls, cls2, cls5, cls5});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzw(Object obj, long j10) {
        return zzg.zzg(obj, j10);
    }

    public static boolean zzx() {
        return zzi;
    }

    public static boolean zzy() {
        return zzh;
    }

    private static int zzz(Class<?> cls) {
        if (zzi) {
            return zzg.zzh(cls);
        }
        return -1;
    }
}
