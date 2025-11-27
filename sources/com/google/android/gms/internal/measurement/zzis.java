package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

final class zzis {
    public static int zza(byte[] bArr, int i10, zzir zzir) {
        int zzj = zzj(bArr, i10, zzir);
        int i11 = zzir.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 > bArr.length - zzj) {
            throw zzkp.zzf();
        } else if (i11 == 0) {
            zzir.zzc = zzje.zzb;
            return zzj;
        } else {
            zzir.zzc = zzje.zzl(bArr, zzj, i11);
            return zzj + i11;
        }
    }

    public static int zzb(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i10] & UnsignedBytes.MAX_VALUE) | ((bArr[i10 + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i10 + 2] & UnsignedBytes.MAX_VALUE) << 16);
    }

    public static int zzc(zzlx zzlx, byte[] bArr, int i10, int i11, int i12, zzir zzir) {
        Object zze = zzlx.zze();
        int zzn = zzn(zze, zzlx, bArr, i10, i11, i12, zzir);
        zzlx.zzf(zze);
        zzir.zzc = zze;
        return zzn;
    }

    public static int zzd(zzlx zzlx, byte[] bArr, int i10, int i11, zzir zzir) {
        Object zze = zzlx.zze();
        int zzo = zzo(zze, zzlx, bArr, i10, i11, zzir);
        zzlx.zzf(zze);
        zzir.zzc = zze;
        return zzo;
    }

    public static int zze(zzlx zzlx, int i10, byte[] bArr, int i11, int i12, zzkm zzkm, zzir zzir) {
        int zzd = zzd(zzlx, bArr, i11, i12, zzir);
        zzkm.add(zzir.zzc);
        while (zzd < i12) {
            int zzj = zzj(bArr, zzd, zzir);
            if (i10 != zzir.zza) {
                break;
            }
            zzd = zzd(zzlx, bArr, zzj, i12, zzir);
            zzkm.add(zzir.zzc);
        }
        return zzd;
    }

    public static int zzf(byte[] bArr, int i10, zzkm zzkm, zzir zzir) {
        zzkg zzkg = (zzkg) zzkm;
        int zzj = zzj(bArr, i10, zzir);
        int i11 = zzir.zza + zzj;
        while (zzj < i11) {
            zzj = zzj(bArr, zzj, zzir);
            zzkg.zzh(zzir.zza);
        }
        if (zzj == i11) {
            return zzj;
        }
        throw zzkp.zzf();
    }

    public static int zzg(byte[] bArr, int i10, zzir zzir) {
        int zzj = zzj(bArr, i10, zzir);
        int i11 = zzir.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 == 0) {
            zzir.zzc = "";
            return zzj;
        } else {
            zzir.zzc = new String(bArr, zzj, i11, zzkn.zzb);
            return zzj + i11;
        }
    }

    public static int zzh(byte[] bArr, int i10, zzir zzir) {
        int zzj = zzj(bArr, i10, zzir);
        int i11 = zzir.zza;
        if (i11 < 0) {
            throw zzkp.zzd();
        } else if (i11 == 0) {
            zzir.zzc = "";
            return zzj;
        } else {
            zzir.zzc = zznd.zzd(bArr, zzj, i11);
            return zzj + i11;
        }
    }

    public static int zzi(int i10, byte[] bArr, int i11, int i12, zzmp zzmp, zzir zzir) {
        if ((i10 >>> 3) != 0) {
            int i13 = i10 & 7;
            if (i13 == 0) {
                int zzm = zzm(bArr, i11, zzir);
                zzmp.zzj(i10, Long.valueOf(zzir.zzb));
                return zzm;
            } else if (i13 == 1) {
                zzmp.zzj(i10, Long.valueOf(zzp(bArr, i11)));
                return i11 + 8;
            } else if (i13 == 2) {
                int zzj = zzj(bArr, i11, zzir);
                int i14 = zzir.zza;
                if (i14 < 0) {
                    throw zzkp.zzd();
                } else if (i14 <= bArr.length - zzj) {
                    if (i14 == 0) {
                        zzmp.zzj(i10, zzje.zzb);
                    } else {
                        zzmp.zzj(i10, zzje.zzl(bArr, zzj, i14));
                    }
                    return zzj + i14;
                } else {
                    throw zzkp.zzf();
                }
            } else if (i13 == 3) {
                int i15 = (i10 & -8) | 4;
                zzmp zzf = zzmp.zzf();
                int i16 = 0;
                while (true) {
                    if (i11 >= i12) {
                        break;
                    }
                    int zzj2 = zzj(bArr, i11, zzir);
                    int i17 = zzir.zza;
                    if (i17 == i15) {
                        i16 = i17;
                        i11 = zzj2;
                        break;
                    }
                    i16 = i17;
                    i11 = zzi(i17, bArr, zzj2, i12, zzf, zzir);
                }
                if (i11 > i12 || i16 != i15) {
                    throw zzkp.zze();
                }
                zzmp.zzj(i10, zzf);
                return i11;
            } else if (i13 == 5) {
                zzmp.zzj(i10, Integer.valueOf(zzb(bArr, i11)));
                return i11 + 4;
            } else {
                throw zzkp.zzb();
            }
        } else {
            throw zzkp.zzb();
        }
    }

    public static int zzj(byte[] bArr, int i10, zzir zzir) {
        int i11 = i10 + 1;
        byte b10 = bArr[i10];
        if (b10 < 0) {
            return zzk(b10, bArr, i11, zzir);
        }
        zzir.zza = b10;
        return i11;
    }

    public static int zzk(int i10, byte[] bArr, int i11, zzir zzir) {
        int i12 = i10 & 127;
        int i13 = i11 + 1;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            zzir.zza = i12 | (b10 << 7);
            return i13;
        }
        int i14 = i12 | ((b10 & Ascii.DEL) << 7);
        int i15 = i13 + 1;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            zzir.zza = i14 | (b11 << 14);
            return i15;
        }
        int i16 = i14 | ((b11 & Ascii.DEL) << 14);
        int i17 = i15 + 1;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            zzir.zza = i16 | (b12 << Ascii.NAK);
            return i17;
        }
        int i18 = i16 | ((b12 & Ascii.DEL) << Ascii.NAK);
        int i19 = i17 + 1;
        byte b13 = bArr[i17];
        if (b13 >= 0) {
            zzir.zza = i18 | (b13 << Ascii.FS);
            return i19;
        }
        int i20 = i18 | ((b13 & Ascii.DEL) << Ascii.FS);
        while (true) {
            int i21 = i19 + 1;
            if (bArr[i19] < 0) {
                i19 = i21;
            } else {
                zzir.zza = i20;
                return i21;
            }
        }
    }

    public static int zzl(int i10, byte[] bArr, int i11, int i12, zzkm zzkm, zzir zzir) {
        zzkg zzkg = (zzkg) zzkm;
        int zzj = zzj(bArr, i11, zzir);
        zzkg.zzh(zzir.zza);
        while (zzj < i12) {
            int zzj2 = zzj(bArr, zzj, zzir);
            if (i10 != zzir.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzir);
            zzkg.zzh(zzir.zza);
        }
        return zzj;
    }

    public static int zzm(byte[] bArr, int i10, zzir zzir) {
        int i11 = i10 + 1;
        long j10 = (long) bArr[i10];
        if (j10 >= 0) {
            zzir.zzb = j10;
            return i11;
        }
        int i12 = i11 + 1;
        byte b10 = bArr[i11];
        long j11 = (j10 & 127) | (((long) (b10 & Ascii.DEL)) << 7);
        int i13 = 7;
        while (b10 < 0) {
            int i14 = i12 + 1;
            byte b11 = bArr[i12];
            i13 += 7;
            j11 |= ((long) (b11 & Ascii.DEL)) << i13;
            int i15 = i14;
            b10 = b11;
            i12 = i15;
        }
        zzir.zzb = j11;
        return i12;
    }

    public static int zzn(Object obj, zzlx zzlx, byte[] bArr, int i10, int i11, int i12, zzir zzir) {
        int zzc = ((zzlp) zzlx).zzc(obj, bArr, i10, i11, i12, zzir);
        zzir.zzc = obj;
        return zzc;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzo(java.lang.Object r6, com.google.android.gms.internal.measurement.zzlx r7, byte[] r8, int r9, int r10, com.google.android.gms.internal.measurement.zzir r11) {
        /*
            int r0 = r9 + 1
            byte r9 = r8[r9]
            if (r9 >= 0) goto L_0x000c
            int r0 = zzk(r9, r8, r0, r11)
            int r9 = r11.zza
        L_0x000c:
            r3 = r0
            if (r9 < 0) goto L_0x001e
            int r10 = r10 - r3
            if (r9 > r10) goto L_0x001e
            int r9 = r9 + r3
            r0 = r7
            r1 = r6
            r2 = r8
            r4 = r9
            r5 = r11
            r0.zzh(r1, r2, r3, r4, r5)
            r11.zzc = r6
            return r9
        L_0x001e:
            com.google.android.gms.internal.measurement.zzkp r6 = com.google.android.gms.internal.measurement.zzkp.zzf()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzis.zzo(java.lang.Object, com.google.android.gms.internal.measurement.zzlx, byte[], int, int, com.google.android.gms.internal.measurement.zzir):int");
    }

    public static long zzp(byte[] bArr, int i10) {
        return ((((long) bArr[i10 + 7]) & 255) << 56) | (((long) bArr[i10]) & 255) | ((((long) bArr[i10 + 1]) & 255) << 8) | ((((long) bArr[i10 + 2]) & 255) << 16) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
    }
}
