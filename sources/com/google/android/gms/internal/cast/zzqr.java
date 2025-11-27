package com.google.android.gms.internal.cast;

import java.util.List;

final class zzqr {
    private static final Class<?> zza;
    private static final zzrd<?, ?> zzb = zzZ(false);
    private static final zzrd<?, ?> zzc = zzZ(true);
    private static final zzrd<?, ?> zzd = new zzrf();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzrd<?, ?> zzA() {
        return zzc;
    }

    public static zzrd<?, ?> zzB() {
        return zzd;
    }

    public static <T, FT extends zzor<FT>> void zzC(zzoo<FT> zzoo, T t10, T t11) {
        zzoo.zza(t11);
        throw null;
    }

    public static <T, UT, UB> void zzD(zzrd<UT, UB> zzrd, T t10, T t11) {
        zzrd.zzf(t10, zzrd.zzd(zzrd.zzc(t10), zzrd.zzc(t11)));
    }

    public static void zzE(Class<?> cls) {
        Class<?> cls2;
        if (!zzoy.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean zzF(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static <T> void zzG(zzpz zzpz, T t10, T t11, long j10) {
        zzpy zzpy = (zzpy) zzrn.zzf(t10, j10);
        zzpy zzpy2 = (zzpy) zzrn.zzf(t11, j10);
        if (!zzpy2.isEmpty()) {
            if (!zzpy.zzd()) {
                zzpy = zzpy.zza();
            }
            zzpy.zzc(zzpy2);
        }
        zzrn.zzs(t10, j10, zzpy);
    }

    public static void zzH(int i10, List<Boolean> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzc(i10, list, z10);
        }
    }

    public static void zzI(int i10, List<zzoe> list, zzom zzom) {
        if (list != null && !list.isEmpty()) {
            zzom.zze(i10, list);
        }
    }

    public static void zzJ(int i10, List<Double> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzg(i10, list, z10);
        }
    }

    public static void zzK(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzi(i10, list, z10);
        }
    }

    public static void zzL(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzk(i10, list, z10);
        }
    }

    public static void zzM(int i10, List<Long> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzm(i10, list, z10);
        }
    }

    public static void zzN(int i10, List<Float> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzo(i10, list, z10);
        }
    }

    public static void zzO(int i10, List<?> list, zzom zzom, zzqp zzqp) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                zzom.zzp(i10, list.get(i11), zzqp);
            }
        }
    }

    public static void zzP(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzr(i10, list, z10);
        }
    }

    public static void zzQ(int i10, List<Long> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzt(i10, list, z10);
        }
    }

    public static void zzR(int i10, List<?> list, zzom zzom, zzqp zzqp) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                zzom.zzu(i10, list.get(i11), zzqp);
            }
        }
    }

    public static void zzS(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzw(i10, list, z10);
        }
    }

    public static void zzT(int i10, List<Long> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzy(i10, list, z10);
        }
    }

    public static void zzU(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzA(i10, list, z10);
        }
    }

    public static void zzV(int i10, List<Long> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzC(i10, list, z10);
        }
    }

    public static void zzW(int i10, List<String> list, zzom zzom) {
        if (list != null && !list.isEmpty()) {
            zzom.zzE(i10, list);
        }
    }

    public static void zzX(int i10, List<Integer> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzG(i10, list, z10);
        }
    }

    public static void zzY(int i10, List<Long> list, zzom zzom, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzom.zzI(i10, list, z10);
        }
    }

    private static zzrd<?, ?> zzZ(boolean z10) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzrd) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zza(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 1);
    }

    public static int zzb(List<?> list) {
        return list.size();
    }

    public static int zzc(int i10, List<zzoe> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzol.zzz(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzz += zzol.zzt(list.get(i11));
        }
        return zzz;
    }

    public static int zzd(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzol.zzz(i10));
    }

    public static int zze(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzoz = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(zzoz.zzd(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzol.zzv(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzf(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 4);
    }

    public static int zzg(List<?> list) {
        return list.size() * 4;
    }

    public static int zzh(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzol.zzA(i10 << 3) + 8);
    }

    public static int zzi(List<?> list) {
        return list.size() * 8;
    }

    public static int zzj(int i10, List<zzqe> list, zzqp zzqp) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzol.zzu(i10, list.get(i12), zzqp);
        }
        return i11;
    }

    public static int zzk(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzol.zzz(i10));
    }

    public static int zzl(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzoz = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzv(zzoz.zzd(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzol.zzv(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzm(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzol.zzz(i10));
    }

    public static int zzn(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzpt = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(zzpt.zzd(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzol.zzB(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzo(int i10, Object obj, zzqp zzqp) {
        if (!(obj instanceof zzpm)) {
            return zzol.zzA(i10 << 3) + zzol.zzx((zzqe) obj, zzqp);
        }
        int zzA = zzol.zzA(i10 << 3);
        int zza2 = ((zzpm) obj).zza();
        return zzA + zzol.zzA(zza2) + zza2;
    }

    public static int zzp(int i10, List<?> list, zzqp zzqp) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzol.zzz(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof zzpm) {
                i11 = zzol.zzw((zzpm) obj);
            } else {
                i11 = zzol.zzx((zzqe) obj, zzqp);
            }
            zzz += i11;
        }
        return zzz;
    }

    public static int zzq(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzol.zzz(i10));
    }

    public static int zzr(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzoz = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                int zzd2 = zzoz.zzd(i11);
                i10 += zzol.zzA((zzd2 >> 31) ^ (zzd2 + zzd2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = list.get(i11).intValue();
                i12 = i10 + zzol.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzs(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzol.zzz(i10));
    }

    public static int zzt(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzpt = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                long zzd2 = zzpt.zzd(i11);
                i10 += zzol.zzB((zzd2 >> 63) ^ (zzd2 + zzd2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = list.get(i11).longValue();
                i12 = i10 + zzol.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzu(int i10, List<?> list) {
        int i11;
        int i12;
        int size = list.size();
        int i13 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzol.zzz(i10) * size;
        if (list instanceof zzpo) {
            zzpo zzpo = (zzpo) list;
            while (i13 < size) {
                Object zze = zzpo.zze(i13);
                if (zze instanceof zzoe) {
                    i12 = zzol.zzt((zzoe) zze);
                } else {
                    i12 = zzol.zzy((String) zze);
                }
                zzz += i12;
                i13++;
            }
        } else {
            while (i13 < size) {
                Object obj = list.get(i13);
                if (obj instanceof zzoe) {
                    i11 = zzol.zzt((zzoe) obj);
                } else {
                    i11 = zzol.zzy((String) obj);
                }
                zzz += i11;
                i13++;
            }
        }
        return zzz;
    }

    public static int zzv(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzol.zzz(i10));
    }

    public static int zzw(List<Integer> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzoz) {
            zzoz zzoz = (zzoz) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzA(zzoz.zzd(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzol.zzA(list.get(i11).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzx(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzol.zzz(i10));
    }

    public static int zzy(List<Long> list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzpt) {
            zzpt zzpt = (zzpt) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzol.zzB(zzpt.zzd(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzol.zzB(list.get(i11).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzrd<?, ?> zzz() {
        return zzb;
    }
}
