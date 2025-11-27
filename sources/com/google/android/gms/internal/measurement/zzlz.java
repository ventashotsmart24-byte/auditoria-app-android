package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzlz {
    private static final Class zza;
    private static final zzmo zzb = zzab(false);
    private static final zzmo zzc = zzab(true);
    private static final zzmo zzd = new zzmq();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        zza = cls;
    }

    public static zzmo zzA() {
        return zzc;
    }

    public static zzmo zzB() {
        return zzd;
    }

    public static Object zzC(Object obj, int i10, List list, zzkj zzkj, Object obj2, zzmo zzmo) {
        Object obj3 = null;
        if (zzkj == null) {
            return null;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                int intValue = ((Integer) list.get(i12)).intValue();
                if (zzkj.zza(intValue)) {
                    if (i12 != i11) {
                        list.set(i11, Integer.valueOf(intValue));
                    }
                    i11++;
                } else {
                    obj3 = zzD(obj, i10, intValue, obj3, zzmo);
                }
            }
            if (i11 != size) {
                list.subList(i11, size).clear();
                return obj3;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!zzkj.zza(intValue2)) {
                    obj3 = zzD(obj, i10, intValue2, obj3, zzmo);
                    it.remove();
                }
            }
        }
        return obj3;
    }

    public static Object zzD(Object obj, int i10, int i11, Object obj2, zzmo zzmo) {
        if (obj2 == null) {
            obj2 = zzmo.zzc(obj);
        }
        zzmo.zzf(obj2, i10, (long) i11);
        return obj2;
    }

    public static void zzE(zzjs zzjs, Object obj, Object obj2) {
        zzjs.zza(obj2);
        throw null;
    }

    public static void zzF(zzmo zzmo, Object obj, Object obj2) {
        zzmo.zzh(obj, zzmo.zze(zzmo.zzd(obj), zzmo.zzd(obj2)));
    }

    public static void zzG(Class cls) {
        Class cls2;
        if (!zzkf.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzH(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzc(i10, list, z10);
        }
    }

    public static void zzI(int i10, List list, zzng zzng) {
        if (list != null && !list.isEmpty()) {
            zzng.zze(i10, list);
        }
    }

    public static void zzJ(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzg(i10, list, z10);
        }
    }

    public static void zzK(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzj(i10, list, z10);
        }
    }

    public static void zzL(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzl(i10, list, z10);
        }
    }

    public static void zzM(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzn(i10, list, z10);
        }
    }

    public static void zzN(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzp(i10, list, z10);
        }
    }

    public static void zzO(int i10, List list, zzng zzng, zzlx zzlx) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzjn) zzng).zzq(i10, list.get(i11), zzlx);
            }
        }
    }

    public static void zzP(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzs(i10, list, z10);
        }
    }

    public static void zzQ(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzu(i10, list, z10);
        }
    }

    public static void zzR(int i10, List list, zzng zzng, zzlx zzlx) {
        if (list != null && !list.isEmpty()) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                ((zzjn) zzng).zzv(i10, list.get(i11), zzlx);
            }
        }
    }

    public static void zzS(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzx(i10, list, z10);
        }
    }

    public static void zzT(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzz(i10, list, z10);
        }
    }

    public static void zzU(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzB(i10, list, z10);
        }
    }

    public static void zzV(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzD(i10, list, z10);
        }
    }

    public static void zzW(int i10, List list, zzng zzng) {
        if (list != null && !list.isEmpty()) {
            zzng.zzG(i10, list);
        }
    }

    public static void zzX(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzI(i10, list, z10);
        }
    }

    public static void zzY(int i10, List list, zzng zzng, boolean z10) {
        if (list != null && !list.isEmpty()) {
            zzng.zzK(i10, list, z10);
        }
    }

    public static boolean zzZ(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || !obj.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static int zza(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 1);
    }

    public static void zzaa(zzlh zzlh, Object obj, Object obj2, long j10) {
        zzmy.zzs(obj, j10, zzlh.zzb(zzmy.zzf(obj, j10), zzmy.zzf(obj2, j10)));
    }

    private static zzmo zzab(boolean z10) {
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
            return (zzmo) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z10)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int zzb(List list) {
        return list.size();
    }

    public static int zzc(int i10, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzjm.zzz(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzz += zzjm.zzt((zzje) list.get(i11));
        }
        return zzz;
    }

    public static int zzd(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzjm.zzz(i10));
    }

    public static int zze(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(zzkg.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzf(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 4);
    }

    public static int zzg(List list) {
        return list.size() * 4;
    }

    public static int zzh(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzjm.zzA(i10 << 3) + 8);
    }

    public static int zzi(List list) {
        return list.size() * 8;
    }

    public static int zzj(int i10, List list, zzlx zzlx) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzjm.zzu(i10, (zzlm) list.get(i12), zzlx);
        }
        return i11;
    }

    public static int zzk(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzl(list) + (size * zzjm.zzz(i10));
    }

    public static int zzl(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzv(zzkg.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzv(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzm(int i10, List list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        return zzn(list) + (list.size() * zzjm.zzz(i10));
    }

    public static int zzn(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(zzlb.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzo(int i10, Object obj, zzlx zzlx) {
        if (!(obj instanceof zzks)) {
            return zzjm.zzA(i10 << 3) + zzjm.zzx((zzlm) obj, zzlx);
        }
        int zzA = zzjm.zzA(i10 << 3);
        int zza2 = ((zzks) obj).zza();
        return zzA + zzjm.zzA(zza2) + zza2;
    }

    public static int zzp(int i10, List list, zzlx zzlx) {
        int i11;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        for (int i12 = 0; i12 < size; i12++) {
            Object obj = list.get(i12);
            if (obj instanceof zzks) {
                i11 = zzjm.zzw((zzks) obj);
            } else {
                i11 = zzjm.zzx((zzlm) obj, zzlx);
            }
            zzz += i11;
        }
        return zzz;
    }

    public static int zzq(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzjm.zzz(i10));
    }

    public static int zzr(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                int zze = zzkg.zze(i11);
                i10 += zzjm.zzA((zze >> 31) ^ (zze + zze));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                int intValue = ((Integer) list.get(i11)).intValue();
                i12 = i10 + zzjm.zzA((intValue >> 31) ^ (intValue + intValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzs(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzjm.zzz(i10));
    }

    public static int zzt(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                long zza2 = zzlb.zza(i11);
                i10 += zzjm.zzB((zza2 >> 63) ^ (zza2 + zza2));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                long longValue = ((Long) list.get(i11)).longValue();
                i12 = i10 + zzjm.zzB((longValue >> 63) ^ (longValue + longValue));
                i11++;
            }
        }
        return i10;
    }

    public static int zzu(int i10, List list) {
        int i11;
        int i12;
        int size = list.size();
        int i13 = 0;
        if (size == 0) {
            return 0;
        }
        int zzz = zzjm.zzz(i10) * size;
        if (list instanceof zzku) {
            zzku zzku = (zzku) list;
            while (i13 < size) {
                Object zzf = zzku.zzf(i13);
                if (zzf instanceof zzje) {
                    i12 = zzjm.zzt((zzje) zzf);
                } else {
                    i12 = zzjm.zzy((String) zzf);
                }
                zzz += i12;
                i13++;
            }
        } else {
            while (i13 < size) {
                Object obj = list.get(i13);
                if (obj instanceof zzje) {
                    i11 = zzjm.zzt((zzje) obj);
                } else {
                    i11 = zzjm.zzy((String) obj);
                }
                zzz += i11;
                i13++;
            }
        }
        return zzz;
    }

    public static int zzv(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzjm.zzz(i10));
    }

    public static int zzw(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzkg) {
            zzkg zzkg = (zzkg) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzA(zzkg.zze(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzA(((Integer) list.get(i11)).intValue());
                i11++;
            }
        }
        return i10;
    }

    public static int zzx(int i10, List list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzy(list) + (size * zzjm.zzz(i10));
    }

    public static int zzy(List list) {
        int i10;
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzlb) {
            zzlb zzlb = (zzlb) list;
            i10 = 0;
            while (i11 < size) {
                i10 += zzjm.zzB(zzlb.zza(i11));
                i11++;
            }
        } else {
            int i12 = 0;
            while (i11 < size) {
                i12 = i10 + zzjm.zzB(((Long) list.get(i11)).longValue());
                i11++;
            }
        }
        return i10;
    }

    public static zzmo zzz() {
        return zzb;
    }
}
