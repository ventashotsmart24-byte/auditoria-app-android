package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzqh<T> implements zzqp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzrn.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final zzqe zze;
    private final boolean zzf;
    private final boolean zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzps zzk;
    private final zzrd<?, ?> zzl;
    private final zzoo<?> zzm;
    private final zzqj zzn;
    private final zzpz zzo;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.google.android.gms.internal.cast.zzqe} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.google.android.gms.internal.cast.zzqj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.internal.cast.zzpz} */
    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.internal.cast.zzoo, com.google.android.gms.internal.cast.zzoo<?>] */
    /* JADX WARNING: type inference failed for: r3v6, types: [int] */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.cast.zzps] */
    /* JADX WARNING: type inference failed for: r3v10, types: [com.google.android.gms.internal.cast.zzrd<?, ?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzqh(int[] r6, int[] r7, java.lang.Object[] r8, int r9, int r10, com.google.android.gms.internal.cast.zzqe r11, boolean r12, boolean r13, int[] r14, int r15, int r16, com.google.android.gms.internal.cast.zzqj r17, com.google.android.gms.internal.cast.zzps r18, com.google.android.gms.internal.cast.zzrd<?, ?> r19, com.google.android.gms.internal.cast.zzoo<?> r20, com.google.android.gms.internal.cast.zzpz r21) {
        /*
            r5 = this;
            r0 = r5
            r1 = r10
            r2 = r19
            r5.<init>()
            r3 = r6
            r0.zzc = r3
            r3 = r7
            r0.zzd = r3
            r3 = r11
            r0.zzg = r3
            r3 = 0
            if (r2 == 0) goto L_0x001a
            boolean r4 = r2.zzc(r10)
            if (r4 == 0) goto L_0x001a
            r3 = 1
        L_0x001a:
            r0.zzf = r3
            r3 = r13
            r0.zzh = r3
            r3 = r14
            r0.zzi = r3
            r3 = r15
            r0.zzj = r3
            r3 = r16
            r0.zzn = r3
            r3 = r17
            r0.zzk = r3
            r3 = r18
            r0.zzl = r3
            r0.zzm = r2
            r0.zze = r1
            r1 = r20
            r0.zzo = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqh.<init>(int[], java.lang.Object[], int, int, com.google.android.gms.internal.cast.zzqe, boolean, boolean, int[], int, int, com.google.android.gms.internal.cast.zzqj, com.google.android.gms.internal.cast.zzps, com.google.android.gms.internal.cast.zzrd, com.google.android.gms.internal.cast.zzoo, com.google.android.gms.internal.cast.zzpz, byte[]):void");
    }

    private final boolean zzA(T t10, int i10) {
        int zzo2 = zzo(i10);
        long j10 = (long) (zzo2 & 1048575);
        if (j10 == 1048575) {
            int zzq = zzq(i10);
            long j11 = (long) (zzq & 1048575);
            switch (zzp(zzq)) {
                case 0:
                    if (Double.doubleToRawLongBits(zzrn.zza(t10, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 1:
                    if (Float.floatToRawIntBits(zzrn.zzb(t10, j11)) != 0) {
                        return true;
                    }
                    return false;
                case 2:
                    if (zzrn.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (zzrn.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (zzrn.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return zzrn.zzw(t10, j11);
                case 8:
                    Object zzf2 = zzrn.zzf(t10, j11);
                    if (zzf2 instanceof String) {
                        if (!((String) zzf2).isEmpty()) {
                            return true;
                        }
                        return false;
                    } else if (!(zzf2 instanceof zzoe)) {
                        throw new IllegalArgumentException();
                    } else if (!zzoe.zzb.equals(zzf2)) {
                        return true;
                    } else {
                        return false;
                    }
                case 9:
                    if (zzrn.zzf(t10, j11) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    if (!zzoe.zzb.equals(zzrn.zzf(t10, j11))) {
                        return true;
                    }
                    return false;
                case 11:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (zzrn.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (zzrn.zzc(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (zzrn.zzd(t10, j11) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (zzrn.zzf(t10, j11) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
        } else if ((zzrn.zzc(t10, j10) & (1 << (zzo2 >>> 20))) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean zzB(T t10, int i10, int i11, int i12, int i13) {
        if (i11 == 1048575) {
            return zzA(t10, i10);
        }
        if ((i12 & i13) != 0) {
            return true;
        }
        return false;
    }

    private static boolean zzC(Object obj, int i10, zzqp zzqp) {
        return zzqp.zzf(zzrn.zzf(obj, (long) (i10 & 1048575)));
    }

    private final boolean zzD(T t10, int i10, int i11) {
        if (zzrn.zzc(t10, (long) (zzo(i11) & 1048575)) == i10) {
            return true;
        }
        return false;
    }

    private static <T> boolean zzE(T t10, long j10) {
        return ((Boolean) zzrn.zzf(t10, j10)).booleanValue();
    }

    private final void zzF(T t10, zzom zzom) {
        int i10;
        T t11 = t10;
        zzom zzom2 = zzom;
        if (!this.zzf) {
            int length = this.zzc.length;
            Unsafe unsafe = zzb;
            int i11 = 1048575;
            int i12 = 0;
            int i13 = 0;
            int i14 = 1048575;
            while (i12 < length) {
                int zzq = zzq(i12);
                int i15 = this.zzc[i12];
                int zzp = zzp(zzq);
                if (zzp <= 17) {
                    int i16 = this.zzc[i12 + 2];
                    int i17 = i16 & i11;
                    if (i17 != i14) {
                        i13 = unsafe.getInt(t11, (long) i17);
                        i14 = i17;
                    }
                    i10 = 1 << (i16 >>> 20);
                } else {
                    i10 = 0;
                }
                long j10 = (long) (zzq & i11);
                switch (zzp) {
                    case 0:
                        if ((i13 & i10) == 0) {
                            break;
                        } else {
                            zzom2.zzf(i15, zzrn.zza(t11, j10));
                            continue;
                        }
                    case 1:
                        if ((i13 & i10) != 0) {
                            zzom2.zzn(i15, zzrn.zzb(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 2:
                        if ((i13 & i10) != 0) {
                            zzom2.zzs(i15, unsafe.getLong(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 3:
                        if ((i13 & i10) != 0) {
                            zzom2.zzH(i15, unsafe.getLong(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 4:
                        if ((i13 & i10) != 0) {
                            zzom2.zzq(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 5:
                        if ((i13 & i10) != 0) {
                            zzom2.zzl(i15, unsafe.getLong(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 6:
                        if ((i13 & i10) != 0) {
                            zzom2.zzj(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 7:
                        if ((i13 & i10) != 0) {
                            zzom2.zzb(i15, zzrn.zzw(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 8:
                        if ((i13 & i10) != 0) {
                            zzH(i15, unsafe.getObject(t11, j10), zzom2);
                            break;
                        } else {
                            continue;
                        }
                    case 9:
                        if ((i13 & i10) != 0) {
                            zzom2.zzu(i15, unsafe.getObject(t11, j10), zzs(i12));
                            break;
                        } else {
                            continue;
                        }
                    case 10:
                        if ((i13 & i10) != 0) {
                            zzom2.zzd(i15, (zzoe) unsafe.getObject(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if ((i13 & i10) != 0) {
                            zzom2.zzF(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 12:
                        if ((i13 & i10) != 0) {
                            zzom2.zzh(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 13:
                        if ((i13 & i10) != 0) {
                            zzom2.zzv(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 14:
                        if ((i13 & i10) != 0) {
                            zzom2.zzx(i15, unsafe.getLong(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 15:
                        if ((i13 & i10) != 0) {
                            zzom2.zzz(i15, unsafe.getInt(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 16:
                        if ((i13 & i10) != 0) {
                            zzom2.zzB(i15, unsafe.getLong(t11, j10));
                            break;
                        } else {
                            continue;
                        }
                    case 17:
                        if ((i13 & i10) != 0) {
                            zzom2.zzp(i15, unsafe.getObject(t11, j10), zzs(i12));
                            break;
                        } else {
                            continue;
                        }
                    case 18:
                        zzqr.zzJ(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 19:
                        zzqr.zzN(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 20:
                        zzqr.zzQ(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 21:
                        zzqr.zzY(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 22:
                        zzqr.zzP(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 23:
                        zzqr.zzM(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 24:
                        zzqr.zzL(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 25:
                        zzqr.zzH(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        continue;
                    case 26:
                        zzqr.zzW(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2);
                        break;
                    case 27:
                        zzqr.zzR(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, zzs(i12));
                        break;
                    case 28:
                        zzqr.zzI(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2);
                        break;
                    case 29:
                        zzqr.zzX(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 30:
                        zzqr.zzK(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 31:
                        zzqr.zzS(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 32:
                        zzqr.zzT(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 33:
                        zzqr.zzU(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 34:
                        zzqr.zzV(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, false);
                        break;
                    case 35:
                        zzqr.zzJ(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 36:
                        zzqr.zzN(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 37:
                        zzqr.zzQ(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 38:
                        zzqr.zzY(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 39:
                        zzqr.zzP(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 40:
                        zzqr.zzM(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 41:
                        zzqr.zzL(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 42:
                        zzqr.zzH(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 43:
                        zzqr.zzX(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 44:
                        zzqr.zzK(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 45:
                        zzqr.zzS(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 46:
                        zzqr.zzT(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 47:
                        zzqr.zzU(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 48:
                        zzqr.zzV(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, true);
                        break;
                    case 49:
                        zzqr.zzO(this.zzc[i12], (List) unsafe.getObject(t11, j10), zzom2, zzs(i12));
                        break;
                    case 50:
                        zzG(zzom2, i15, unsafe.getObject(t11, j10), i12);
                        break;
                    case 51:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzf(i15, zzj(t11, j10));
                            break;
                        }
                        break;
                    case 52:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzn(i15, zzk(t11, j10));
                            break;
                        }
                        break;
                    case 53:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzs(i15, zzr(t11, j10));
                            break;
                        }
                        break;
                    case 54:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzH(i15, zzr(t11, j10));
                            break;
                        }
                        break;
                    case 55:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzq(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 56:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzl(i15, zzr(t11, j10));
                            break;
                        }
                        break;
                    case 57:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzj(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 58:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzb(i15, zzE(t11, j10));
                            break;
                        }
                        break;
                    case 59:
                        if (zzD(t11, i15, i12)) {
                            zzH(i15, unsafe.getObject(t11, j10), zzom2);
                            break;
                        }
                        break;
                    case 60:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzu(i15, unsafe.getObject(t11, j10), zzs(i12));
                            break;
                        }
                        break;
                    case 61:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzd(i15, (zzoe) unsafe.getObject(t11, j10));
                            break;
                        }
                        break;
                    case 62:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzF(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 63:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzh(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 64:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzv(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 65:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzx(i15, zzr(t11, j10));
                            break;
                        }
                        break;
                    case 66:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzz(i15, zzn(t11, j10));
                            break;
                        }
                        break;
                    case 67:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzB(i15, zzr(t11, j10));
                            break;
                        }
                        break;
                    case 68:
                        if (zzD(t11, i15, i12)) {
                            zzom2.zzp(i15, unsafe.getObject(t11, j10), zzs(i12));
                            break;
                        }
                        break;
                }
                i12 += 3;
                i11 = 1048575;
            }
            zzrd<?, ?> zzrd = this.zzl;
            zzrd.zzg(zzrd.zzc(t11), zzom2);
            return;
        }
        this.zzm.zza(t11);
        throw null;
    }

    private final <K, V> void zzG(zzom zzom, int i10, Object obj, int i11) {
        if (obj != null) {
            zzpx zzpx = (zzpx) zzt(i11);
            throw null;
        }
    }

    private static final void zzH(int i10, Object obj, zzom zzom) {
        if (obj instanceof String) {
            zzom.zzD(i10, (String) obj);
        } else {
            zzom.zzd(i10, (zzoe) obj);
        }
    }

    public static <T> zzqh<T> zzg(Class<T> cls, zzqb zzqb, zzqj zzqj, zzps zzps, zzrd<?, ?> zzrd, zzoo<?> zzoo, zzpz zzpz) {
        if (zzqb instanceof zzqo) {
            return zzh((zzqo) zzqb, zzqj, zzps, zzrd, zzoo, zzpz);
        }
        zzra zzra = (zzra) zzqb;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x025d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032f  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0378  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> com.google.android.gms.internal.cast.zzqh<T> zzh(com.google.android.gms.internal.cast.zzqo r34, com.google.android.gms.internal.cast.zzqj r35, com.google.android.gms.internal.cast.zzps r36, com.google.android.gms.internal.cast.zzrd<?, ?> r37, com.google.android.gms.internal.cast.zzoo<?> r38, com.google.android.gms.internal.cast.zzpz r39) {
        /*
            int r0 = r34.zzc()
            r1 = 2
            r2 = 0
            if (r0 != r1) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = 0
        L_0x000b:
            java.lang.String r0 = r34.zzd()
            int r1 = r0.length()
            char r4 = r0.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r5) goto L_0x0027
            r4 = 1
        L_0x001d:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0028
            r4 = r6
            goto L_0x001d
        L_0x0027:
            r6 = 1
        L_0x0028:
            int r4 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0047
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0034:
            int r9 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0044
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r8
            r6 = r6 | r4
            int r8 = r8 + 13
            r4 = r9
            goto L_0x0034
        L_0x0044:
            int r4 = r4 << r8
            r6 = r6 | r4
            r4 = r9
        L_0x0047:
            if (r6 != 0) goto L_0x0056
            int[] r6 = zza
            r13 = r6
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r14 = 0
            r16 = 0
            goto L_0x0165
        L_0x0056:
            int r6 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x0075
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r8 = 13
        L_0x0062:
            int r9 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0072
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            int r6 = r6 << r8
            r4 = r4 | r6
            int r8 = r8 + 13
            r6 = r9
            goto L_0x0062
        L_0x0072:
            int r6 = r6 << r8
            r4 = r4 | r6
            r6 = r9
        L_0x0075:
            int r8 = r6 + 1
            char r6 = r0.charAt(r6)
            if (r6 < r5) goto L_0x0094
            r6 = r6 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x0081:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x0091
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r6 = r6 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0081
        L_0x0091:
            int r8 = r8 << r9
            r6 = r6 | r8
            r8 = r11
        L_0x0094:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r5) goto L_0x00b3
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x00a0:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00b0
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x00a0
        L_0x00b0:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x00b3:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r5) goto L_0x00d2
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00bf:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00cf
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x00bf
        L_0x00cf:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x00d2:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r5) goto L_0x00f1
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00de:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x00ee
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00de
        L_0x00ee:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00f1:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r5) goto L_0x0110
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00fd:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x010d
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00fd
        L_0x010d:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x0110:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r5) goto L_0x0131
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x011c:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x012d
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x011c
        L_0x012d:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x0131:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r5) goto L_0x0154
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x013d:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r5) goto L_0x014f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x013d
        L_0x014f:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0154:
            int r16 = r14 + r12
            int r13 = r16 + r13
            int[] r13 = new int[r13]
            int r16 = r4 + r4
            int r16 = r16 + r6
            r6 = r4
            r4 = r15
            r33 = r12
            r12 = r9
            r9 = r33
        L_0x0165:
            sun.misc.Unsafe r15 = zzb
            java.lang.Object[] r17 = r34.zze()
            com.google.android.gms.internal.cast.zzqe r18 = r34.zza()
            java.lang.Class r2 = r18.getClass()
            int r7 = r11 * 3
            int[] r7 = new int[r7]
            int r11 = r11 + r11
            java.lang.Object[] r11 = new java.lang.Object[r11]
            int r21 = r14 + r9
            r22 = r14
            r23 = r21
            r9 = 0
            r20 = 0
        L_0x0183:
            if (r4 >= r1) goto L_0x03ca
            int r24 = r4 + 1
            char r4 = r0.charAt(r4)
            if (r4 < r5) goto L_0x01ab
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r3 = r24
            r24 = 13
        L_0x0193:
            int r26 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01a5
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r24
            r4 = r4 | r3
            int r24 = r24 + 13
            r3 = r26
            goto L_0x0193
        L_0x01a5:
            int r3 = r3 << r24
            r4 = r4 | r3
            r3 = r26
            goto L_0x01ad
        L_0x01ab:
            r3 = r24
        L_0x01ad:
            int r24 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r5) goto L_0x01da
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r5 = r24
            r24 = 13
        L_0x01bb:
            int r27 = r5 + 1
            char r5 = r0.charAt(r5)
            r28 = r1
            r1 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r1) goto L_0x01d4
            r1 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r1 = r1 << r24
            r3 = r3 | r1
            int r24 = r24 + 13
            r5 = r27
            r1 = r28
            goto L_0x01bb
        L_0x01d4:
            int r1 = r5 << r24
            r3 = r3 | r1
            r1 = r27
            goto L_0x01de
        L_0x01da:
            r28 = r1
            r1 = r24
        L_0x01de:
            r5 = r3 & 255(0xff, float:3.57E-43)
            r24 = r14
            r14 = r3 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x01ec
            int r14 = r20 + 1
            r13[r20] = r9
            r20 = r14
        L_0x01ec:
            r14 = 51
            if (r5 < r14) goto L_0x0295
            int r14 = r1 + 1
            char r1 = r0.charAt(r1)
            r27 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r14) goto L_0x0222
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r14 = r27
            r27 = 13
        L_0x0203:
            int r31 = r14 + 1
            char r14 = r0.charAt(r14)
            r32 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r14 < r12) goto L_0x021c
            r12 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r27
            r1 = r1 | r12
            int r27 = r27 + 13
            r14 = r31
            r12 = r32
            goto L_0x0203
        L_0x021c:
            int r12 = r14 << r27
            r1 = r1 | r12
            r14 = r31
            goto L_0x0226
        L_0x0222:
            r32 = r12
            r14 = r27
        L_0x0226:
            int r12 = r5 + -51
            r27 = r14
            r14 = 9
            if (r12 == r14) goto L_0x0247
            r14 = 17
            if (r12 != r14) goto L_0x0233
            goto L_0x0247
        L_0x0233:
            r14 = 12
            if (r12 != r14) goto L_0x0256
            if (r10 != 0) goto L_0x0256
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
            goto L_0x0254
        L_0x0247:
            int r12 = r9 / 3
            int r14 = r16 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r16 = r17[r16]
            r11[r12] = r16
        L_0x0254:
            r16 = r14
        L_0x0256:
            int r1 = r1 + r1
            r12 = r17[r1]
            boolean r14 = r12 instanceof java.lang.reflect.Field
            if (r14 == 0) goto L_0x0260
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x0268
        L_0x0260:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zzu(r2, r12)
            r17[r1] = r12
        L_0x0268:
            r31 = r7
            r14 = r8
            long r7 = r15.objectFieldOffset(r12)
            int r8 = (int) r7
            int r1 = r1 + 1
            r7 = r17[r1]
            boolean r12 = r7 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x027b
            java.lang.reflect.Field r7 = (java.lang.reflect.Field) r7
            goto L_0x0283
        L_0x027b:
            java.lang.String r7 = (java.lang.String) r7
            java.lang.reflect.Field r7 = zzu(r2, r7)
            r17[r1] = r7
        L_0x0283:
            r1 = r8
            long r7 = r15.objectFieldOffset(r7)
            int r8 = (int) r7
            r30 = r0
            r0 = r6
            r7 = r8
            r29 = r11
            r25 = 1
            r8 = r1
            r1 = 0
            goto L_0x0391
        L_0x0295:
            r31 = r7
            r14 = r8
            r32 = r12
            int r7 = r16 + 1
            r8 = r17[r16]
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zzu(r2, r8)
            r12 = 9
            if (r5 == r12) goto L_0x030d
            r12 = 17
            if (r5 != r12) goto L_0x02ad
            goto L_0x030d
        L_0x02ad:
            r12 = 27
            if (r5 == r12) goto L_0x02fd
            r12 = 49
            if (r5 != r12) goto L_0x02b6
            goto L_0x02fd
        L_0x02b6:
            r12 = 12
            if (r5 == r12) goto L_0x02ed
            r12 = 30
            if (r5 == r12) goto L_0x02ed
            r12 = 44
            if (r5 != r12) goto L_0x02c3
            goto L_0x02ed
        L_0x02c3:
            r12 = 50
            if (r5 != r12) goto L_0x02e3
            int r12 = r22 + 1
            r13[r22] = r9
            int r22 = r9 / 3
            int r22 = r22 + r22
            int r27 = r7 + 1
            r7 = r17[r7]
            r11[r22] = r7
            r7 = r3 & 2048(0x800, float:2.87E-42)
            if (r7 == 0) goto L_0x02e6
            int r7 = r27 + 1
            int r22 = r22 + 1
            r27 = r17[r27]
            r11[r22] = r27
            r22 = r12
        L_0x02e3:
            r25 = 1
            goto L_0x031a
        L_0x02e6:
            r22 = r12
            r12 = r27
            r25 = 1
            goto L_0x031b
        L_0x02ed:
            if (r10 != 0) goto L_0x02e3
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            r25 = 1
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
            goto L_0x030a
        L_0x02fd:
            r25 = 1
            int r12 = r9 / 3
            int r27 = r7 + 1
            int r12 = r12 + r12
            int r12 = r12 + 1
            r7 = r17[r7]
            r11[r12] = r7
        L_0x030a:
            r12 = r27
            goto L_0x031b
        L_0x030d:
            r25 = 1
            int r12 = r9 / 3
            int r12 = r12 + r12
            int r12 = r12 + 1
            java.lang.Class r27 = r8.getType()
            r11[r12] = r27
        L_0x031a:
            r12 = r7
        L_0x031b:
            long r7 = r15.objectFieldOffset(r8)
            int r8 = (int) r7
            r7 = r3 & 4096(0x1000, float:5.74E-42)
            r27 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r11
            r11 = 4096(0x1000, float:5.74E-42)
            if (r7 != r11) goto L_0x0378
            r7 = 17
            if (r5 > r7) goto L_0x0378
            int r7 = r1 + 1
            char r1 = r0.charAt(r1)
            r11 = 55296(0xd800, float:7.7486E-41)
            if (r1 < r11) goto L_0x0354
            r1 = r1 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
        L_0x033e:
            int r27 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r11) goto L_0x0350
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r26
            r1 = r1 | r7
            int r26 = r26 + 13
            r7 = r27
            goto L_0x033e
        L_0x0350:
            int r7 = r7 << r26
            r1 = r1 | r7
            goto L_0x0356
        L_0x0354:
            r27 = r7
        L_0x0356:
            int r7 = r6 + r6
            int r26 = r1 / 32
            int r7 = r7 + r26
            r11 = r17[r7]
            r30 = r0
            boolean r0 = r11 instanceof java.lang.reflect.Field
            if (r0 == 0) goto L_0x0367
            java.lang.reflect.Field r11 = (java.lang.reflect.Field) r11
            goto L_0x036f
        L_0x0367:
            java.lang.String r11 = (java.lang.String) r11
            java.lang.reflect.Field r11 = zzu(r2, r11)
            r17[r7] = r11
        L_0x036f:
            r0 = r6
            long r6 = r15.objectFieldOffset(r11)
            int r7 = (int) r6
            int r1 = r1 % 32
            goto L_0x0381
        L_0x0378:
            r30 = r0
            r0 = r6
            r27 = r1
            r1 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0381:
            r6 = 18
            if (r5 < r6) goto L_0x038f
            r6 = 49
            if (r5 > r6) goto L_0x038f
            int r6 = r23 + 1
            r13[r23] = r8
            r23 = r6
        L_0x038f:
            r16 = r12
        L_0x0391:
            int r6 = r9 + 1
            r31[r9] = r4
            int r4 = r6 + 1
            r9 = r3 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x039e
            r9 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x039f
        L_0x039e:
            r9 = 0
        L_0x039f:
            r3 = r3 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x03a6
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03a7
        L_0x03a6:
            r3 = 0
        L_0x03a7:
            r3 = r3 | r9
            int r5 = r5 << 20
            r3 = r3 | r5
            r3 = r3 | r8
            r31[r6] = r3
            int r9 = r4 + 1
            int r1 = r1 << 20
            r1 = r1 | r7
            r31[r4] = r1
            r6 = r0
            r8 = r14
            r14 = r24
            r4 = r27
            r1 = r28
            r11 = r29
            r0 = r30
            r7 = r31
            r12 = r32
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0183
        L_0x03ca:
            r31 = r7
            r29 = r11
            r32 = r12
            r24 = r14
            r14 = r8
            com.google.android.gms.internal.cast.zzqh r0 = new com.google.android.gms.internal.cast.zzqh
            r4 = r0
            com.google.android.gms.internal.cast.zzqe r9 = r34.zza()
            r11 = 0
            r1 = r29
            r20 = 0
            r5 = r31
            r6 = r1
            r7 = r14
            r8 = r32
            r12 = r13
            r13 = r24
            r14 = r21
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqh.zzh(com.google.android.gms.internal.cast.zzqo, com.google.android.gms.internal.cast.zzqj, com.google.android.gms.internal.cast.zzps, com.google.android.gms.internal.cast.zzrd, com.google.android.gms.internal.cast.zzoo, com.google.android.gms.internal.cast.zzpz):com.google.android.gms.internal.cast.zzqh");
    }

    private static <T> double zzj(T t10, long j10) {
        return ((Double) zzrn.zzf(t10, j10)).doubleValue();
    }

    private static <T> float zzk(T t10, long j10) {
        return ((Float) zzrn.zzf(t10, j10)).floatValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0304, code lost:
        r8 = r8 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x046b, code lost:
        r8 = r8 + (r9 + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x04b5, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04e0, code lost:
        r8 = r8 + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x04e1, code lost:
        r4 = r4 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0508, code lost:
        r7 = r7 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x0515, code lost:
        r7 = r7 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0523, code lost:
        r7 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0527, code lost:
        r3 = r3 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzl(T r15) {
        /*
            r14 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x000c:
            int[] r7 = r14.zzc
            int r7 = r7.length
            if (r3 >= r7) goto L_0x052b
            int r7 = r14.zzq(r3)
            int[] r8 = r14.zzc
            r8 = r8[r3]
            int r9 = zzp(r7)
            r10 = 17
            r11 = 1
            if (r9 > r10) goto L_0x0037
            int[] r10 = r14.zzc
            int r12 = r3 + 2
            r10 = r10[r12]
            r12 = r10 & r2
            int r10 = r10 >>> 20
            int r10 = r11 << r10
            if (r12 == r6) goto L_0x0038
            long r5 = (long) r12
            int r5 = r0.getInt(r15, r5)
            r6 = r12
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r7 = r7 & r2
            long r12 = (long) r7
            r7 = 63
            switch(r9) {
                case 0: goto L_0x0519;
                case 1: goto L_0x050b;
                case 2: goto L_0x04f6;
                case 3: goto L_0x04e3;
                case 4: goto L_0x04ce;
                case 5: goto L_0x04c3;
                case 6: goto L_0x04b8;
                case 7: goto L_0x04ab;
                case 8: goto L_0x0481;
                case 9: goto L_0x046f;
                case 10: goto L_0x0453;
                case 11: goto L_0x043f;
                case 12: goto L_0x042b;
                case 13: goto L_0x041f;
                case 14: goto L_0x0413;
                case 15: goto L_0x03fa;
                case 16: goto L_0x03e2;
                case 17: goto L_0x03cf;
                case 18: goto L_0x03c2;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03ac;
                case 21: goto L_0x03a1;
                case 22: goto L_0x0396;
                case 23: goto L_0x038b;
                case 24: goto L_0x0380;
                case 25: goto L_0x0375;
                case 26: goto L_0x036a;
                case 27: goto L_0x035b;
                case 28: goto L_0x034f;
                case 29: goto L_0x0343;
                case 30: goto L_0x0337;
                case 31: goto L_0x032b;
                case 32: goto L_0x031f;
                case 33: goto L_0x0313;
                case 34: goto L_0x0307;
                case 35: goto L_0x02f0;
                case 36: goto L_0x02db;
                case 37: goto L_0x02c6;
                case 38: goto L_0x02b1;
                case 39: goto L_0x029c;
                case 40: goto L_0x0287;
                case 41: goto L_0x0271;
                case 42: goto L_0x025b;
                case 43: goto L_0x0245;
                case 44: goto L_0x022f;
                case 45: goto L_0x0219;
                case 46: goto L_0x0203;
                case 47: goto L_0x01ed;
                case 48: goto L_0x01d7;
                case 49: goto L_0x01c7;
                case 50: goto L_0x01ba;
                case 51: goto L_0x01ac;
                case 52: goto L_0x019e;
                case 53: goto L_0x0188;
                case 54: goto L_0x0172;
                case 55: goto L_0x015c;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0132;
                case 59: goto L_0x0104;
                case 60: goto L_0x00f0;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00be;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x0071;
                case 67: goto L_0x0057;
                case 68: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0527
        L_0x0041:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzqe r7 = (com.google.android.gms.internal.cast.zzqe) r7
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzol.zzu(r8, r7, r9)
            goto L_0x03cc
        L_0x0057:
            boolean r9 = r14.zzD(r15, r8, r3)
            if (r9 == 0) goto L_0x0527
            long r9 = zzr(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.cast.zzol.zzB(r9)
            goto L_0x04e0
        L_0x0071:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x04e0
        L_0x008c:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0523
        L_0x009a:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0515
        L_0x00a8:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzv(r7)
            goto L_0x04e0
        L_0x00be:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x04e0
        L_0x00d4:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzoe r7 = (com.google.android.gms.internal.cast.zzoe) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x046b
        L_0x00f0:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzqr.zzo(r8, r7, r9)
            goto L_0x03cc
        L_0x0104:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.cast.zzoe
            if (r9 == 0) goto L_0x0124
            com.google.android.gms.internal.cast.zzoe r7 = (com.google.android.gms.internal.cast.zzoe) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x046b
        L_0x0124:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzy(r7)
            goto L_0x04e0
        L_0x0132:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x04b5
        L_0x0140:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0515
        L_0x014e:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0523
        L_0x015c:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = zzn(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzv(r7)
            goto L_0x04e0
        L_0x0172:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            long r9 = zzr(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            int r8 = com.google.android.gms.internal.cast.zzol.zzB(r9)
            goto L_0x0508
        L_0x0188:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            long r9 = zzr(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            int r8 = com.google.android.gms.internal.cast.zzol.zzB(r9)
            goto L_0x0508
        L_0x019e:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0515
        L_0x01ac:
            boolean r7 = r14.zzD(r15, r8, r3)
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0523
        L_0x01ba:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.lang.Object r9 = r14.zzt(r3)
            com.google.android.gms.internal.cast.zzpz.zza(r8, r7, r9)
            goto L_0x0527
        L_0x01c7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzqr.zzj(r8, r7, r9)
            goto L_0x03cc
        L_0x01d7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzt(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x01ed:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzr(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x0203:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzi(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x0219:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzg(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x022f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zze(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x0245:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzw(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x025b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzb(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x0271:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzg(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x0287:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzi(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x029c:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzl(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x02b1:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzy(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x02c6:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzn(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x02db:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzg(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0304
        L_0x02f0:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzi(r7)
            if (r7 <= 0) goto L_0x0527
            int r8 = com.google.android.gms.internal.cast.zzol.zzz(r8)
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
        L_0x0304:
            int r8 = r8 + r9
            goto L_0x04e0
        L_0x0307:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzs(r8, r7, r1)
            goto L_0x03cc
        L_0x0313:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzq(r8, r7, r1)
            goto L_0x03cc
        L_0x031f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzh(r8, r7, r1)
            goto L_0x03cc
        L_0x032b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzf(r8, r7, r1)
            goto L_0x03cc
        L_0x0337:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzd(r8, r7, r1)
            goto L_0x03cc
        L_0x0343:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzv(r8, r7, r1)
            goto L_0x03cc
        L_0x034f:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzc(r8, r7)
            goto L_0x03cc
        L_0x035b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzqr.zzp(r8, r7, r9)
            goto L_0x03cc
        L_0x036a:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzu(r8, r7)
            goto L_0x03cc
        L_0x0375:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zza(r8, r7, r1)
            goto L_0x03cc
        L_0x0380:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzf(r8, r7, r1)
            goto L_0x03cc
        L_0x038b:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzh(r8, r7, r1)
            goto L_0x03cc
        L_0x0396:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzk(r8, r7, r1)
            goto L_0x03cc
        L_0x03a1:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzx(r8, r7, r1)
            goto L_0x03cc
        L_0x03ac:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzm(r8, r7, r1)
            goto L_0x03cc
        L_0x03b7:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzf(r8, r7, r1)
            goto L_0x03cc
        L_0x03c2:
            java.lang.Object r7 = r0.getObject(r15, r12)
            java.util.List r7 = (java.util.List) r7
            int r7 = com.google.android.gms.internal.cast.zzqr.zzh(r8, r7, r1)
        L_0x03cc:
            int r4 = r4 + r7
            goto L_0x0527
        L_0x03cf:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzqe r7 = (com.google.android.gms.internal.cast.zzqe) r7
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzol.zzu(r8, r7, r9)
            goto L_0x03cc
        L_0x03e2:
            r9 = r5 & r10
            if (r9 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            long r11 = r9 + r9
            long r9 = r9 >> r7
            long r9 = r9 ^ r11
            int r7 = com.google.android.gms.internal.cast.zzol.zzB(r9)
            goto L_0x04e0
        L_0x03fa:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r9 = r7 + r7
            int r7 = r7 >> 31
            r7 = r7 ^ r9
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x04e0
        L_0x0413:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0523
        L_0x041f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0515
        L_0x042b:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzv(r7)
            goto L_0x04e0
        L_0x043f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x04e0
        L_0x0453:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzoe r7 = (com.google.android.gms.internal.cast.zzoe) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
        L_0x046b:
            int r9 = r9 + r7
            int r8 = r8 + r9
            goto L_0x04e1
        L_0x046f:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            com.google.android.gms.internal.cast.zzqp r9 = r14.zzs(r3)
            int r7 = com.google.android.gms.internal.cast.zzqr.zzo(r8, r7, r9)
            goto L_0x03cc
        L_0x0481:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            java.lang.Object r7 = r0.getObject(r15, r12)
            boolean r9 = r7 instanceof com.google.android.gms.internal.cast.zzoe
            if (r9 == 0) goto L_0x049e
            com.google.android.gms.internal.cast.zzoe r7 = (com.google.android.gms.internal.cast.zzoe) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = r7.zzd()
            int r9 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x046b
        L_0x049e:
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzy(r7)
            goto L_0x04e0
        L_0x04ab:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
        L_0x04b5:
            int r7 = r7 + r11
            goto L_0x03cc
        L_0x04b8:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0515
        L_0x04c3:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            goto L_0x0523
        L_0x04ce:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r0.getInt(r15, r12)
            int r8 = r8 << 3
            int r8 = com.google.android.gms.internal.cast.zzol.zzA(r8)
            int r7 = com.google.android.gms.internal.cast.zzol.zzv(r7)
        L_0x04e0:
            int r8 = r8 + r7
        L_0x04e1:
            int r4 = r4 + r8
            goto L_0x0527
        L_0x04e3:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            int r8 = com.google.android.gms.internal.cast.zzol.zzB(r9)
            goto L_0x0508
        L_0x04f6:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            long r9 = r0.getLong(r15, r12)
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
            int r8 = com.google.android.gms.internal.cast.zzol.zzB(r9)
        L_0x0508:
            int r7 = r7 + r8
            goto L_0x03cc
        L_0x050b:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
        L_0x0515:
            int r7 = r7 + 4
            goto L_0x03cc
        L_0x0519:
            r7 = r5 & r10
            if (r7 == 0) goto L_0x0527
            int r7 = r8 << 3
            int r7 = com.google.android.gms.internal.cast.zzol.zzA(r7)
        L_0x0523:
            int r7 = r7 + 8
            goto L_0x03cc
        L_0x0527:
            int r3 = r3 + 3
            goto L_0x000c
        L_0x052b:
            com.google.android.gms.internal.cast.zzrd<?, ?> r0 = r14.zzl
            java.lang.Object r1 = r0.zzc(r15)
            int r0 = r0.zza(r1)
            int r4 = r4 + r0
            boolean r0 = r14.zzf
            if (r0 != 0) goto L_0x053b
            return r4
        L_0x053b:
            com.google.android.gms.internal.cast.zzoo<?> r0 = r14.zzm
            r0.zza(r15)
            r15 = 0
            goto L_0x0543
        L_0x0542:
            throw r15
        L_0x0543:
            goto L_0x0542
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqh.zzl(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02fc, code lost:
        r5 = r5 + r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0474, code lost:
        r5 = r5 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x04c4, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x04f6, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x04f7, code lost:
        r3 = r3 + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x0522, code lost:
        r3 = r3 + (r6 + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0531, code lost:
        r4 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0541, code lost:
        r4 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0545, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzm(T r12) {
        /*
            r11 = this;
            sun.misc.Unsafe r0 = zzb
            r1 = 0
            r2 = 0
            r3 = 0
        L_0x0005:
            int[] r4 = r11.zzc
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0549
            int r4 = r11.zzq(r2)
            int r5 = zzp(r4)
            int[] r6 = r11.zzc
            r6 = r6[r2]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r7 = (long) r4
            com.google.android.gms.internal.cast.zzot r4 = com.google.android.gms.internal.cast.zzot.DOUBLE_LIST_PACKED
            int r4 = r4.zza()
            if (r5 < r4) goto L_0x0031
            com.google.android.gms.internal.cast.zzot r4 = com.google.android.gms.internal.cast.zzot.SINT64_LIST_PACKED
            int r4 = r4.zza()
            if (r5 > r4) goto L_0x0031
            int[] r4 = r11.zzc
            int r9 = r2 + 2
            r4 = r4[r9]
        L_0x0031:
            r4 = 63
            switch(r5) {
                case 0: goto L_0x0535;
                case 1: goto L_0x0525;
                case 2: goto L_0x050e;
                case 3: goto L_0x04f9;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d5;
                case 6: goto L_0x04c8;
                case 7: goto L_0x04b8;
                case 8: goto L_0x048c;
                case 9: goto L_0x0478;
                case 10: goto L_0x045a;
                case 11: goto L_0x0444;
                case 12: goto L_0x042e;
                case 13: goto L_0x0420;
                case 14: goto L_0x0412;
                case 15: goto L_0x03f7;
                case 16: goto L_0x03dc;
                case 17: goto L_0x03c7;
                case 18: goto L_0x03ba;
                case 19: goto L_0x03af;
                case 20: goto L_0x03a4;
                case 21: goto L_0x0399;
                case 22: goto L_0x038e;
                case 23: goto L_0x0383;
                case 24: goto L_0x0378;
                case 25: goto L_0x036d;
                case 26: goto L_0x0362;
                case 27: goto L_0x0353;
                case 28: goto L_0x0347;
                case 29: goto L_0x033b;
                case 30: goto L_0x032f;
                case 31: goto L_0x0323;
                case 32: goto L_0x0317;
                case 33: goto L_0x030b;
                case 34: goto L_0x02ff;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d3;
                case 37: goto L_0x02be;
                case 38: goto L_0x02a9;
                case 39: goto L_0x0294;
                case 40: goto L_0x027f;
                case 41: goto L_0x0269;
                case 42: goto L_0x0253;
                case 43: goto L_0x023d;
                case 44: goto L_0x0227;
                case 45: goto L_0x0211;
                case 46: goto L_0x01fb;
                case 47: goto L_0x01e5;
                case 48: goto L_0x01cf;
                case 49: goto L_0x01bf;
                case 50: goto L_0x01b2;
                case 51: goto L_0x01a4;
                case 52: goto L_0x0196;
                case 53: goto L_0x0180;
                case 54: goto L_0x016a;
                case 55: goto L_0x0154;
                case 56: goto L_0x0146;
                case 57: goto L_0x0138;
                case 58: goto L_0x012a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00cc;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a0;
                case 64: goto L_0x0092;
                case 65: goto L_0x0084;
                case 66: goto L_0x0069;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x0545
        L_0x0038:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzqe r4 = (com.google.android.gms.internal.cast.zzqe) r4
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzol.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x004e:
            boolean r5 = r11.zzD(r12, r6, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = zzr(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r6)
            goto L_0x04f6
        L_0x0069:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x04f6
        L_0x0084:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0541
        L_0x0092:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0531
        L_0x00a0:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzv(r4)
            goto L_0x04f6
        L_0x00b6:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x04f6
        L_0x00cc:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzoe r4 = (com.google.android.gms.internal.cast.zzoe) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0474
        L_0x00e8:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzqr.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x00fc:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.cast.zzoe
            if (r5 == 0) goto L_0x011c
            com.google.android.gms.internal.cast.zzoe r4 = (com.google.android.gms.internal.cast.zzoe) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0474
        L_0x011c:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzy(r4)
            goto L_0x04f6
        L_0x012a:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x04c4
        L_0x0138:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0531
        L_0x0146:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0541
        L_0x0154:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = zzn(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzv(r4)
            goto L_0x04f6
        L_0x016a:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzr(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r6)
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r4)
            goto L_0x0522
        L_0x0180:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = zzr(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r6)
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r4)
            goto L_0x0522
        L_0x0196:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0531
        L_0x01a4:
            boolean r4 = r11.zzD(r12, r6, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0541
        L_0x01b2:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.lang.Object r5 = r11.zzt(r2)
            com.google.android.gms.internal.cast.zzpz.zza(r6, r4, r5)
            goto L_0x0545
        L_0x01bf:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzqr.zzj(r6, r4, r5)
            goto L_0x03c4
        L_0x01cf:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzt(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x01e5:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzr(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x01fb:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x0211:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x0227:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zze(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x023d:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzw(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x0253:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzb(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x0269:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x027f:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x0294:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzl(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x02a9:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzy(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x02be:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzn(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x02d3:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzg(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x02fc
        L_0x02e8:
            java.lang.Object r4 = r0.getObject(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzi(r4)
            if (r4 <= 0) goto L_0x0545
            int r5 = com.google.android.gms.internal.cast.zzol.zzz(r6)
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
        L_0x02fc:
            int r5 = r5 + r6
            goto L_0x04f6
        L_0x02ff:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzs(r6, r4, r1)
            goto L_0x03c4
        L_0x030b:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzq(r6, r4, r1)
            goto L_0x03c4
        L_0x0317:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x0323:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x032f:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzd(r6, r4, r1)
            goto L_0x03c4
        L_0x033b:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzv(r6, r4, r1)
            goto L_0x03c4
        L_0x0347:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzc(r6, r4)
            goto L_0x03c4
        L_0x0353:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzqr.zzp(r6, r4, r5)
            goto L_0x03c4
        L_0x0362:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzu(r6, r4)
            goto L_0x03c4
        L_0x036d:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zza(r6, r4, r1)
            goto L_0x03c4
        L_0x0378:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x0383:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzh(r6, r4, r1)
            goto L_0x03c4
        L_0x038e:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzk(r6, r4, r1)
            goto L_0x03c4
        L_0x0399:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzx(r6, r4, r1)
            goto L_0x03c4
        L_0x03a4:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzm(r6, r4, r1)
            goto L_0x03c4
        L_0x03af:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzf(r6, r4, r1)
            goto L_0x03c4
        L_0x03ba:
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.cast.zzqr.zzh(r6, r4, r1)
        L_0x03c4:
            int r3 = r3 + r4
            goto L_0x0545
        L_0x03c7:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzqe r4 = (com.google.android.gms.internal.cast.zzqe) r4
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzol.zzu(r6, r4, r5)
            goto L_0x03c4
        L_0x03dc:
            boolean r5 = r11.zzA(r12, r2)
            if (r5 == 0) goto L_0x0545
            long r7 = com.google.android.gms.internal.cast.zzrn.zzd(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            long r9 = r7 + r7
            long r6 = r7 >> r4
            long r6 = r6 ^ r9
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r6)
            goto L_0x04f6
        L_0x03f7:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.cast.zzrn.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r6 = r4 + r4
            int r4 = r4 >> 31
            r4 = r4 ^ r6
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x04f6
        L_0x0412:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0541
        L_0x0420:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0531
        L_0x042e:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.cast.zzrn.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzv(r4)
            goto L_0x04f6
        L_0x0444:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.cast.zzrn.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x04f6
        L_0x045a:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzoe r4 = (com.google.android.gms.internal.cast.zzoe) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
        L_0x0474:
            int r6 = r6 + r4
            int r5 = r5 + r6
            goto L_0x04f7
        L_0x0478:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            com.google.android.gms.internal.cast.zzqp r5 = r11.zzs(r2)
            int r4 = com.google.android.gms.internal.cast.zzqr.zzo(r6, r4, r5)
            goto L_0x03c4
        L_0x048c:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            java.lang.Object r4 = com.google.android.gms.internal.cast.zzrn.zzf(r12, r7)
            boolean r5 = r4 instanceof com.google.android.gms.internal.cast.zzoe
            if (r5 == 0) goto L_0x04ab
            com.google.android.gms.internal.cast.zzoe r4 = (com.google.android.gms.internal.cast.zzoe) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = r4.zzd()
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0474
        L_0x04ab:
            java.lang.String r4 = (java.lang.String) r4
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzy(r4)
            goto L_0x04f6
        L_0x04b8:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
        L_0x04c4:
            int r4 = r4 + 1
            goto L_0x03c4
        L_0x04c8:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0531
        L_0x04d5:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
            goto L_0x0541
        L_0x04e2:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = com.google.android.gms.internal.cast.zzrn.zzc(r12, r7)
            int r5 = r6 << 3
            int r5 = com.google.android.gms.internal.cast.zzol.zzA(r5)
            int r4 = com.google.android.gms.internal.cast.zzol.zzv(r4)
        L_0x04f6:
            int r5 = r5 + r4
        L_0x04f7:
            int r3 = r3 + r5
            goto L_0x0545
        L_0x04f9:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.cast.zzrn.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r6)
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r4)
            goto L_0x0522
        L_0x050e:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            long r4 = com.google.android.gms.internal.cast.zzrn.zzd(r12, r7)
            int r6 = r6 << 3
            int r6 = com.google.android.gms.internal.cast.zzol.zzA(r6)
            int r4 = com.google.android.gms.internal.cast.zzol.zzB(r4)
        L_0x0522:
            int r6 = r6 + r4
            int r3 = r3 + r6
            goto L_0x0545
        L_0x0525:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
        L_0x0531:
            int r4 = r4 + 4
            goto L_0x03c4
        L_0x0535:
            boolean r4 = r11.zzA(r12, r2)
            if (r4 == 0) goto L_0x0545
            int r4 = r6 << 3
            int r4 = com.google.android.gms.internal.cast.zzol.zzA(r4)
        L_0x0541:
            int r4 = r4 + 8
            goto L_0x03c4
        L_0x0545:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0549:
            com.google.android.gms.internal.cast.zzrd<?, ?> r0 = r11.zzl
            java.lang.Object r12 = r0.zzc(r12)
            int r12 = r0.zza(r12)
            int r3 = r3 + r12
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqh.zzm(java.lang.Object):int");
    }

    private static <T> int zzn(T t10, long j10) {
        return ((Integer) zzrn.zzf(t10, j10)).intValue();
    }

    private final int zzo(int i10) {
        return this.zzc[i10 + 2];
    }

    private static int zzp(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzq(int i10) {
        return this.zzc[i10 + 1];
    }

    private static <T> long zzr(T t10, long j10) {
        return ((Long) zzrn.zzf(t10, j10)).longValue();
    }

    private final zzqp zzs(int i10) {
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzqp zzqp = (zzqp) this.zzd[i12];
        if (zzqp != null) {
            return zzqp;
        }
        zzqp zzb2 = zzqm.zza().zzb((Class) this.zzd[i12 + 1]);
        this.zzd[i12] = zzb2;
        return zzb2;
    }

    private final Object zzt(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private static Field zzu(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final void zzv(T t10, T t11, int i10) {
        long zzq = (long) (zzq(i10) & 1048575);
        if (zzA(t11, i10)) {
            Object zzf2 = zzrn.zzf(t10, zzq);
            Object zzf3 = zzrn.zzf(t11, zzq);
            if (zzf2 != null && zzf3 != null) {
                zzrn.zzs(t10, zzq, zzph.zzg(zzf2, zzf3));
                zzx(t10, i10);
            } else if (zzf3 != null) {
                zzrn.zzs(t10, zzq, zzf3);
                zzx(t10, i10);
            }
        }
    }

    private final void zzw(T t10, T t11, int i10) {
        Object obj;
        int zzq = zzq(i10);
        int i11 = this.zzc[i10];
        long j10 = (long) (zzq & 1048575);
        if (zzD(t11, i11, i10)) {
            if (zzD(t10, i11, i10)) {
                obj = zzrn.zzf(t10, j10);
            } else {
                obj = null;
            }
            Object zzf2 = zzrn.zzf(t11, j10);
            if (obj != null && zzf2 != null) {
                zzrn.zzs(t10, j10, zzph.zzg(obj, zzf2));
                zzy(t10, i11, i10);
            } else if (zzf2 != null) {
                zzrn.zzs(t10, j10, zzf2);
                zzy(t10, i11, i10);
            }
        }
    }

    private final void zzx(T t10, int i10) {
        int zzo2 = zzo(i10);
        long j10 = (long) (1048575 & zzo2);
        if (j10 != 1048575) {
            zzrn.zzq(t10, j10, (1 << (zzo2 >>> 20)) | zzrn.zzc(t10, j10));
        }
    }

    private final void zzy(T t10, int i10, int i11) {
        zzrn.zzq(t10, (long) (zzo(i11) & 1048575), i10);
    }

    private final boolean zzz(T t10, T t11, int i10) {
        if (zzA(t10, i10) == zzA(t11, i10)) {
            return true;
        }
        return false;
    }

    public final int zza(T t10) {
        if (this.zzg) {
            return zzm(t10);
        }
        return zzl(t10);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c2, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0226, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0227, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022b
            int r3 = r8.zzq(r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            int r3 = zzp(r3)
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0218;
                case 1: goto L_0x020d;
                case 2: goto L_0x0202;
                case 3: goto L_0x01f7;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01e5;
                case 6: goto L_0x01de;
                case 7: goto L_0x01d3;
                case 8: goto L_0x01c6;
                case 9: goto L_0x01b8;
                case 10: goto L_0x01ac;
                case 11: goto L_0x01a4;
                case 12: goto L_0x019c;
                case 13: goto L_0x0194;
                case 14: goto L_0x0188;
                case 15: goto L_0x0180;
                case 16: goto L_0x0174;
                case 17: goto L_0x0169;
                case 18: goto L_0x015d;
                case 19: goto L_0x015d;
                case 20: goto L_0x015d;
                case 21: goto L_0x015d;
                case 22: goto L_0x015d;
                case 23: goto L_0x015d;
                case 24: goto L_0x015d;
                case 25: goto L_0x015d;
                case 26: goto L_0x015d;
                case 27: goto L_0x015d;
                case 28: goto L_0x015d;
                case 29: goto L_0x015d;
                case 30: goto L_0x015d;
                case 31: goto L_0x015d;
                case 32: goto L_0x015d;
                case 33: goto L_0x015d;
                case 34: goto L_0x015d;
                case 35: goto L_0x015d;
                case 36: goto L_0x015d;
                case 37: goto L_0x015d;
                case 38: goto L_0x015d;
                case 39: goto L_0x015d;
                case 40: goto L_0x015d;
                case 41: goto L_0x015d;
                case 42: goto L_0x015d;
                case 43: goto L_0x015d;
                case 44: goto L_0x015d;
                case 45: goto L_0x015d;
                case 46: goto L_0x015d;
                case 47: goto L_0x015d;
                case 48: goto L_0x015d;
                case 49: goto L_0x015d;
                case 50: goto L_0x0151;
                case 51: goto L_0x013b;
                case 52: goto L_0x0129;
                case 53: goto L_0x0117;
                case 54: goto L_0x0105;
                case 55: goto L_0x00f7;
                case 56: goto L_0x00e5;
                case 57: goto L_0x00d7;
                case 58: goto L_0x00c5;
                case 59: goto L_0x00b1;
                case 60: goto L_0x009f;
                case 61: goto L_0x008d;
                case 62: goto L_0x007f;
                case 63: goto L_0x0071;
                case 64: goto L_0x0063;
                case 65: goto L_0x0051;
                case 66: goto L_0x0043;
                case 67: goto L_0x0031;
                case 68: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0227
        L_0x001f:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0031:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0043:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0051:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0063:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0071:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x007f:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x008d:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x009f:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00b1:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x00c5:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            boolean r3 = zzE(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zza(r3)
            goto L_0x0226
        L_0x00d7:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x00e5:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x00f7:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            int r3 = zzn(r9, r5)
            goto L_0x0226
        L_0x0105:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0117:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            long r3 = zzr(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0129:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            float r3 = zzk(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x013b:
            boolean r3 = r8.zzD(r9, r4, r1)
            if (r3 == 0) goto L_0x0227
            int r2 = r2 * 53
            double r3 = zzj(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0151:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x015d:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x0169:
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
            goto L_0x01c2
        L_0x0174:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzrn.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0180:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x0188:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzrn.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0194:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x019c:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x01a4:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x01ac:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01b8:
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c2
            int r7 = r3.hashCode()
        L_0x01c2:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0227
        L_0x01c6:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.cast.zzrn.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0226
        L_0x01d3:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.cast.zzrn.zzw(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zza(r3)
            goto L_0x0226
        L_0x01de:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x01e5:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzrn.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x01f0:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.cast.zzrn.zzc(r9, r5)
            goto L_0x0226
        L_0x01f7:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzrn.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x0202:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.cast.zzrn.zzd(r9, r5)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
            goto L_0x0226
        L_0x020d:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.cast.zzrn.zzb(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0226
        L_0x0218:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.cast.zzrn.zza(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.cast.zzph.zzc(r3)
        L_0x0226:
            int r2 = r2 + r3
        L_0x0227:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022b:
            int r2 = r2 * 53
            com.google.android.gms.internal.cast.zzrd<?, ?> r0 = r8.zzl
            java.lang.Object r0 = r0.zzc(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzf
            if (r0 != 0) goto L_0x023d
            return r2
        L_0x023d:
            com.google.android.gms.internal.cast.zzoo<?> r0 = r8.zzm
            r0.zza(r9)
            r9 = 0
            goto L_0x0245
        L_0x0244:
            throw r9
        L_0x0245:
            goto L_0x0244
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzqh.zzb(java.lang.Object):int");
    }

    public final void zzc(T t10) {
        int i10;
        int i11 = this.zzi;
        while (true) {
            i10 = this.zzj;
            if (i11 >= i10) {
                break;
            }
            long zzq = (long) (zzq(this.zzh[i11]) & 1048575);
            Object zzf2 = zzrn.zzf(t10, zzq);
            if (zzf2 != null) {
                ((zzpy) zzf2).zzb();
                zzrn.zzs(t10, zzq, zzf2);
            }
            i11++;
        }
        int length = this.zzh.length;
        while (i10 < length) {
            this.zzk.zza(t10, (long) this.zzh[i10]);
            i10++;
        }
        this.zzl.zze(t10);
        if (this.zzf) {
            this.zzm.zzb(t10);
        }
    }

    public final void zzd(T t10, T t11) {
        t11.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int zzq = zzq(i10);
            long j10 = (long) (1048575 & zzq);
            int i11 = this.zzc[i10];
            switch (zzp(zzq)) {
                case 0:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzo(t10, j10, zzrn.zza(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 1:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzp(t10, j10, zzrn.zzb(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 2:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 3:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 4:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 5:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 6:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 7:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzm(t10, j10, zzrn.zzw(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 8:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 9:
                    zzv(t10, t11, i10);
                    break;
                case 10:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 11:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 12:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 13:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 14:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 15:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzq(t10, j10, zzrn.zzc(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 16:
                    if (!zzA(t11, i10)) {
                        break;
                    } else {
                        zzrn.zzr(t10, j10, zzrn.zzd(t11, j10));
                        zzx(t10, i10);
                        break;
                    }
                case 17:
                    zzv(t10, t11, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(t10, t11, j10);
                    break;
                case 50:
                    zzqr.zzG(this.zzo, t10, t11, j10);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zzD(t11, i11, i10)) {
                        break;
                    } else {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzy(t10, i11, i10);
                        break;
                    }
                case 60:
                    zzw(t10, t11, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zzD(t11, i11, i10)) {
                        break;
                    } else {
                        zzrn.zzs(t10, j10, zzrn.zzf(t11, j10));
                        zzy(t10, i11, i10);
                        break;
                    }
                case 68:
                    zzw(t10, t11, i10);
                    break;
            }
        }
        zzqr.zzD(this.zzl, t10, t11);
        if (this.zzf) {
            zzqr.zzC(this.zzm, t10, t11);
        }
    }

    public final boolean zze(T t10, T t11) {
        boolean z10;
        int length = this.zzc.length;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int zzq = zzq(i10);
            long j10 = (long) (zzq & 1048575);
            switch (zzp(zzq)) {
                case 0:
                    if (zzz(t10, t11, i10) && Double.doubleToLongBits(zzrn.zza(t10, j10)) == Double.doubleToLongBits(zzrn.zza(t11, j10))) {
                        continue;
                    }
                case 1:
                    if (zzz(t10, t11, i10) && Float.floatToIntBits(zzrn.zzb(t10, j10)) == Float.floatToIntBits(zzrn.zzb(t11, j10))) {
                        continue;
                    }
                case 2:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                case 3:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                case 4:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 5:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                case 6:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 7:
                    if (zzz(t10, t11, i10) && zzrn.zzw(t10, j10) == zzrn.zzw(t11, j10)) {
                        continue;
                    }
                case 8:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                case 9:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                case 10:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                case 11:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 12:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 13:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 14:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                case 15:
                    if (zzz(t10, t11, i10) && zzrn.zzc(t10, j10) == zzrn.zzc(t11, j10)) {
                        continue;
                    }
                case 16:
                    if (zzz(t10, t11, i10) && zzrn.zzd(t10, j10) == zzrn.zzd(t11, j10)) {
                        continue;
                    }
                case 17:
                    if (zzz(t10, t11, i10) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    z10 = zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10));
                    break;
                case 50:
                    z10 = zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long zzo2 = (long) (zzo(i10) & 1048575);
                    if (zzrn.zzc(t10, zzo2) == zzrn.zzc(t11, zzo2) && zzqr.zzF(zzrn.zzf(t10, j10), zzrn.zzf(t11, j10))) {
                        continue;
                    }
            }
            if (!z10) {
                return false;
            }
        }
        if (!this.zzl.zzc(t10).equals(this.zzl.zzc(t11))) {
            return false;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t10);
        this.zzm.zza(t11);
        throw null;
    }

    public final boolean zzf(T t10) {
        int i10;
        int i11;
        T t11 = t10;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.zzi) {
            int i15 = this.zzh[i14];
            int i16 = this.zzc[i15];
            int zzq = zzq(i15);
            int i17 = this.zzc[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = zzb.getInt(t11, (long) i18);
                }
                i10 = i13;
                i11 = i18;
            } else {
                i11 = i12;
                i10 = i13;
            }
            if ((268435456 & zzq) != 0 && !zzB(t10, i15, i11, i10, i19)) {
                return false;
            }
            int zzp = zzp(zzq);
            if (zzp != 9 && zzp != 17) {
                if (zzp != 27) {
                    if (zzp == 60 || zzp == 68) {
                        if (zzD(t11, i16, i15) && !zzC(t11, zzq, zzs(i15))) {
                            return false;
                        }
                    } else if (zzp != 49) {
                        if (zzp == 50 && !((zzpy) zzrn.zzf(t11, (long) (zzq & 1048575))).isEmpty()) {
                            zzpx zzpx = (zzpx) zzt(i15);
                            throw null;
                        }
                    }
                }
                List list = (List) zzrn.zzf(t11, (long) (zzq & 1048575));
                if (!list.isEmpty()) {
                    zzqp zzs = zzs(i15);
                    for (int i20 = 0; i20 < list.size(); i20++) {
                        if (!zzs.zzf(list.get(i20))) {
                            return false;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            } else if (zzB(t10, i15, i11, i10, i19) && !zzC(t11, zzq, zzs(i15))) {
                return false;
            }
            i14++;
            i12 = i11;
            i13 = i10;
        }
        if (!this.zzf) {
            return true;
        }
        this.zzm.zza(t11);
        throw null;
    }

    public final void zzi(T t10, zzom zzom) {
        if (!this.zzg) {
            zzF(t10, zzom);
        } else if (!this.zzf) {
            int length = this.zzc.length;
            for (int i10 = 0; i10 < length; i10 += 3) {
                int zzq = zzq(i10);
                int i11 = this.zzc[i10];
                switch (zzp(zzq)) {
                    case 0:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzf(i11, zzrn.zza(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 1:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzn(i11, zzrn.zzb(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 2:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzs(i11, zzrn.zzd(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 3:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzH(i11, zzrn.zzd(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 4:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzq(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 5:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzl(i11, zzrn.zzd(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 6:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzj(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 7:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzb(i11, zzrn.zzw(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 8:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzH(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzom);
                            break;
                        }
                    case 9:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzu(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzs(i10));
                            break;
                        }
                    case 10:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzd(i11, (zzoe) zzrn.zzf(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 11:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzF(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 12:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzh(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 13:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzv(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 14:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzx(i11, zzrn.zzd(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 15:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzz(i11, zzrn.zzc(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 16:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzB(i11, zzrn.zzd(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 17:
                        if (!zzA(t10, i10)) {
                            break;
                        } else {
                            zzom.zzp(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzs(i10));
                            break;
                        }
                    case 18:
                        zzqr.zzJ(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 19:
                        zzqr.zzN(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 20:
                        zzqr.zzQ(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 21:
                        zzqr.zzY(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 22:
                        zzqr.zzP(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 23:
                        zzqr.zzM(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 24:
                        zzqr.zzL(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 25:
                        zzqr.zzH(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 26:
                        zzqr.zzW(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom);
                        break;
                    case 27:
                        zzqr.zzR(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, zzs(i10));
                        break;
                    case 28:
                        zzqr.zzI(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom);
                        break;
                    case 29:
                        zzqr.zzX(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 30:
                        zzqr.zzK(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 31:
                        zzqr.zzS(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 32:
                        zzqr.zzT(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 33:
                        zzqr.zzU(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 34:
                        zzqr.zzV(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, false);
                        break;
                    case 35:
                        zzqr.zzJ(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 36:
                        zzqr.zzN(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 37:
                        zzqr.zzQ(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 38:
                        zzqr.zzY(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 39:
                        zzqr.zzP(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 40:
                        zzqr.zzM(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 41:
                        zzqr.zzL(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 42:
                        zzqr.zzH(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 43:
                        zzqr.zzX(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 44:
                        zzqr.zzK(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 45:
                        zzqr.zzS(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 46:
                        zzqr.zzT(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 47:
                        zzqr.zzU(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 48:
                        zzqr.zzV(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, true);
                        break;
                    case 49:
                        zzqr.zzO(this.zzc[i10], (List) zzrn.zzf(t10, (long) (zzq & 1048575)), zzom, zzs(i10));
                        break;
                    case 50:
                        zzG(zzom, i11, zzrn.zzf(t10, (long) (zzq & 1048575)), i10);
                        break;
                    case 51:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzf(i11, zzj(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 52:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzn(i11, zzk(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 53:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzs(i11, zzr(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 54:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzH(i11, zzr(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 55:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzq(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 56:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzl(i11, zzr(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 57:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzj(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 58:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzb(i11, zzE(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 59:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzH(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzom);
                            break;
                        }
                    case 60:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzu(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzs(i10));
                            break;
                        }
                    case 61:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzd(i11, (zzoe) zzrn.zzf(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 62:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzF(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 63:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzh(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 64:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzv(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 65:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzx(i11, zzr(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 66:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzz(i11, zzn(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 67:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzB(i11, zzr(t10, (long) (zzq & 1048575)));
                            break;
                        }
                    case 68:
                        if (!zzD(t10, i11, i10)) {
                            break;
                        } else {
                            zzom.zzp(i11, zzrn.zzf(t10, (long) (zzq & 1048575)), zzs(i10));
                            break;
                        }
                }
            }
            zzrd<?, ?> zzrd = this.zzl;
            zzrd.zzg(zzrd.zzc(t10), zzom);
        } else {
            this.zzm.zza(t10);
            throw null;
        }
    }
}
