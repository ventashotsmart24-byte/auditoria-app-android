package com.google.android.gms.measurement.internal;

import androidx.collection.a;
import com.google.android.gms.internal.measurement.zzfo;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgh;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgj;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zznz;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzu {
    final /* synthetic */ zzaa zza;
    private String zzb;
    private boolean zzc;
    private zzgi zzd;
    /* access modifiers changed from: private */
    public BitSet zze;
    private BitSet zzf;
    private Map zzg;
    private Map zzh;

    public /* synthetic */ zzu(zzaa zzaa, String str, zzt zzt) {
        this.zza = zzaa;
        this.zzb = str;
        this.zzc = true;
        this.zze = new BitSet();
        this.zzf = new BitSet();
        this.zzg = new a();
        this.zzh = new a();
    }

    public final zzfp zza(int i10) {
        ArrayList arrayList;
        List list;
        zzfo zzb2 = zzfp.zzb();
        zzb2.zza(i10);
        zzb2.zzc(this.zzc);
        zzgi zzgi = this.zzd;
        if (zzgi != null) {
            zzb2.zzd(zzgi);
        }
        zzgh zzf2 = zzgi.zzf();
        zzf2.zzb(zzkv.zzr(this.zze));
        zzf2.zzd(zzkv.zzr(this.zzf));
        Map map = this.zzg;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer intValue : this.zzg.keySet()) {
                int intValue2 = intValue.intValue();
                Long l10 = (Long) this.zzg.get(Integer.valueOf(intValue2));
                if (l10 != null) {
                    zzfq zzc2 = zzfr.zzc();
                    zzc2.zzb(intValue2);
                    zzc2.zza(l10.longValue());
                    arrayList2.add((zzfr) zzc2.zzaC());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzf2.zza(arrayList);
        }
        Map map2 = this.zzh;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzh.keySet()) {
                zzgj zzd2 = zzgk.zzd();
                zzd2.zzb(num.intValue());
                List list2 = (List) this.zzh.get(num);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd2.zza(list2);
                }
                arrayList3.add((zzgk) zzd2.zzaC());
            }
            list = arrayList3;
        }
        zzf2.zzc(list);
        zzb2.zzb(zzf2);
        return (zzfp) zzb2.zzaC();
    }

    public final void zzc(zzy zzy) {
        int zza2 = zzy.zza();
        Boolean bool = zzy.zzd;
        if (bool != null) {
            this.zzf.set(zza2, bool.booleanValue());
        }
        Boolean bool2 = zzy.zze;
        if (bool2 != null) {
            this.zze.set(zza2, bool2.booleanValue());
        }
        if (zzy.zzf != null) {
            Map map = this.zzg;
            Integer valueOf = Integer.valueOf(zza2);
            Long l10 = (Long) map.get(valueOf);
            long longValue = zzy.zzf.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                this.zzg.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzy.zzg != null) {
            Map map2 = this.zzh;
            Integer valueOf2 = Integer.valueOf(zza2);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.zzh.put(valueOf2, list);
            }
            if (zzy.zzc()) {
                list.clear();
            }
            zznz.zzc();
            zzag zzf2 = this.zza.zzt.zzf();
            String str = this.zzb;
            zzdt zzdt = zzdu.zzW;
            if (zzf2.zzs(str, zzdt) && zzy.zzb()) {
                list.clear();
            }
            zznz.zzc();
            if (this.zza.zzt.zzf().zzs(this.zzb, zzdt)) {
                Long valueOf3 = Long.valueOf(zzy.zzg.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzy.zzg.longValue() / 1000));
        }
    }

    public /* synthetic */ zzu(zzaa zzaa, String str, zzgi zzgi, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zzt) {
        this.zza = zzaa;
        this.zzb = str;
        this.zze = bitSet;
        this.zzf = bitSet2;
        this.zzg = map;
        this.zzh = new a();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.zzh.put(num, arrayList);
        }
        this.zzc = false;
        this.zzd = zzgi;
    }
}
