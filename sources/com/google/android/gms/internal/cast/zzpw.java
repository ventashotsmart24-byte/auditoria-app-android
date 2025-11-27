package com.google.android.gms.internal.cast;

final class zzpw implements zzqq {
    private static final zzqc zza = new zzpu();
    private final zzqc zzb;

    public zzpw() {
        zzqc zzqc;
        zzqc[] zzqcArr = new zzqc[2];
        zzqcArr[0] = zzou.zza();
        try {
            zzqc = (zzqc) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            zzqc = zza;
        }
        zzqcArr[1] = zzqc;
        zzpv zzpv = new zzpv(zzqcArr);
        zzph.zzf(zzpv, "messageInfoFactory");
        this.zzb = zzpv;
    }

    private static boolean zzb(zzqb zzqb) {
        if (zzqb.zzc() == 1) {
            return true;
        }
        return false;
    }

    public final <T> zzqp<T> zza(Class<T> cls) {
        zzqr.zzE(cls);
        zzqb zzb2 = this.zzb.zzb(cls);
        Class<zzoy> cls2 = zzoy.class;
        if (zzb2.zzb()) {
            if (cls2.isAssignableFrom(cls)) {
                return zzqi.zzg(zzqr.zzB(), zzoq.zzb(), zzb2.zza());
            }
            return zzqi.zzg(zzqr.zzz(), zzoq.zza(), zzb2.zza());
        } else if (cls2.isAssignableFrom(cls)) {
            if (zzb(zzb2)) {
                return zzqh.zzg(cls, zzb2, zzqk.zzb(), zzps.zzd(), zzqr.zzB(), zzoq.zzb(), zzqa.zzb());
            }
            return zzqh.zzg(cls, zzb2, zzqk.zzb(), zzps.zzd(), zzqr.zzB(), (zzoo<?>) null, zzqa.zzb());
        } else if (zzb(zzb2)) {
            return zzqh.zzg(cls, zzb2, zzqk.zza(), zzps.zzc(), zzqr.zzz(), zzoq.zza(), zzqa.zza());
        } else {
            return zzqh.zzg(cls, zzb2, zzqk.zza(), zzps.zzc(), zzqr.zzA(), (zzoo<?>) null, zzqa.zza());
        }
    }
}
