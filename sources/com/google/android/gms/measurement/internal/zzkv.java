package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.internal.measurement.zzek;
import com.google.android.gms.internal.measurement.zzem;
import com.google.android.gms.internal.measurement.zzer;
import com.google.android.gms.internal.measurement.zzet;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgc;
import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgi;
import com.google.android.gms.internal.measurement.zzgk;
import com.google.android.gms.internal.measurement.zzgl;
import com.google.android.gms.internal.measurement.zzgm;
import com.google.android.gms.internal.measurement.zzjr;
import com.google.android.gms.internal.measurement.zzll;
import com.google.android.gms.internal.measurement.zzpd;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class zzkv extends zzkh {
    public zzkv(zzkt zzkt) {
        super(zzkt);
    }

    public static final boolean zzA(zzaw zzaw, zzq zzq) {
        Preconditions.checkNotNull(zzaw);
        Preconditions.checkNotNull(zzq);
        if (!TextUtils.isEmpty(zzq.zzb) || !TextUtils.isEmpty(zzq.zzq)) {
            return true;
        }
        return false;
    }

    public static final zzfx zzB(zzft zzft, String str) {
        for (zzfx zzfx : zzft.zzi()) {
            if (zzfx.zzg().equals(str)) {
                return zzfx;
            }
        }
        return null;
    }

    public static final Object zzC(zzft zzft, String str) {
        zzfx zzB = zzB(zzft, str);
        if (zzB == null) {
            return null;
        }
        if (zzB.zzy()) {
            return zzB.zzh();
        }
        if (zzB.zzw()) {
            return Long.valueOf(zzB.zzd());
        }
        if (zzB.zzu()) {
            return Double.valueOf(zzB.zza());
        }
        if (zzB.zzc() <= 0) {
            return null;
        }
        List<zzfx> zzi = zzB.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzfx zzfx : zzi) {
            if (zzfx != null) {
                Bundle bundle = new Bundle();
                for (zzfx zzfx2 : zzfx.zzi()) {
                    if (zzfx2.zzy()) {
                        bundle.putString(zzfx2.zzg(), zzfx2.zzh());
                    } else if (zzfx2.zzw()) {
                        bundle.putLong(zzfx2.zzg(), zzfx2.zzd());
                    } else if (zzfx2.zzu()) {
                        bundle.putDouble(zzfx2.zzg(), zzfx2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final void zzD(StringBuilder sb, int i10, List list) {
        String str;
        String str2;
        Long l10;
        if (list != null) {
            int i11 = i10 + 1;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzfx zzfx = (zzfx) it.next();
                if (zzfx != null) {
                    zzF(sb, i11);
                    sb.append("param {\n");
                    Double d10 = null;
                    if (zzfx.zzx()) {
                        str = this.zzt.zzj().zze(zzfx.zzg());
                    } else {
                        str = null;
                    }
                    zzI(sb, i11, "name", str);
                    if (zzfx.zzy()) {
                        str2 = zzfx.zzh();
                    } else {
                        str2 = null;
                    }
                    zzI(sb, i11, "string_value", str2);
                    if (zzfx.zzw()) {
                        l10 = Long.valueOf(zzfx.zzd());
                    } else {
                        l10 = null;
                    }
                    zzI(sb, i11, "int_value", l10);
                    if (zzfx.zzu()) {
                        d10 = Double.valueOf(zzfx.zza());
                    }
                    zzI(sb, i11, "double_value", d10);
                    if (zzfx.zzc() > 0) {
                        zzD(sb, i11, zzfx.zzi());
                    }
                    zzF(sb, i11);
                    sb.append("}\n");
                }
            }
        }
    }

    private final void zzE(StringBuilder sb, int i10, zzem zzem) {
        String str;
        if (zzem != null) {
            zzF(sb, i10);
            sb.append("filter {\n");
            if (zzem.zzh()) {
                zzI(sb, i10, "complement", Boolean.valueOf(zzem.zzg()));
            }
            if (zzem.zzj()) {
                zzI(sb, i10, "param_name", this.zzt.zzj().zze(zzem.zze()));
            }
            if (zzem.zzk()) {
                int i11 = i10 + 1;
                zzey zzd = zzem.zzd();
                if (zzd != null) {
                    zzF(sb, i11);
                    sb.append("string_filter {\n");
                    if (zzd.zzi()) {
                        switch (zzd.zzj()) {
                            case 1:
                                str = "UNKNOWN_MATCH_TYPE";
                                break;
                            case 2:
                                str = "REGEXP";
                                break;
                            case 3:
                                str = "BEGINS_WITH";
                                break;
                            case 4:
                                str = "ENDS_WITH";
                                break;
                            case 5:
                                str = "PARTIAL";
                                break;
                            case 6:
                                str = "EXACT";
                                break;
                            default:
                                str = "IN_LIST";
                                break;
                        }
                        zzI(sb, i11, "match_type", str);
                    }
                    if (zzd.zzh()) {
                        zzI(sb, i11, "expression", zzd.zzd());
                    }
                    if (zzd.zzg()) {
                        zzI(sb, i11, "case_sensitive", Boolean.valueOf(zzd.zzf()));
                    }
                    if (zzd.zza() > 0) {
                        zzF(sb, i11 + 1);
                        sb.append("expression_list {\n");
                        for (String append : zzd.zze()) {
                            zzF(sb, i11 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zzF(sb, i11);
                    sb.append("}\n");
                }
            }
            if (zzem.zzi()) {
                zzJ(sb, i10 + 1, "number_filter", zzem.zzc());
            }
            zzF(sb, i10);
            sb.append("}\n");
        }
    }

    private static final void zzF(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("  ");
        }
    }

    private static final String zzG(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append("Dynamic ");
        }
        if (z11) {
            sb.append("Sequence ");
        }
        if (z12) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static final void zzH(StringBuilder sb, int i10, String str, zzgi zzgi) {
        Integer num;
        Integer num2;
        Long l10;
        if (zzgi != null) {
            zzF(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzgi.zzb() != 0) {
                zzF(sb, 4);
                sb.append("results: ");
                int i11 = 0;
                for (Long l11 : zzgi.zzk()) {
                    int i12 = i11 + 1;
                    if (i11 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l11);
                    i11 = i12;
                }
                sb.append(10);
            }
            if (zzgi.zzd() != 0) {
                zzF(sb, 4);
                sb.append("status: ");
                int i13 = 0;
                for (Long l12 : zzgi.zzn()) {
                    int i14 = i13 + 1;
                    if (i13 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l12);
                    i13 = i14;
                }
                sb.append(10);
            }
            if (zzgi.zza() != 0) {
                zzF(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i15 = 0;
                for (zzfr zzfr : zzgi.zzj()) {
                    int i16 = i15 + 1;
                    if (i15 != 0) {
                        sb.append(", ");
                    }
                    if (zzfr.zzh()) {
                        num2 = Integer.valueOf(zzfr.zza());
                    } else {
                        num2 = null;
                    }
                    sb.append(num2);
                    sb.append(SOAP.DELIM);
                    if (zzfr.zzg()) {
                        l10 = Long.valueOf(zzfr.zzb());
                    } else {
                        l10 = null;
                    }
                    sb.append(l10);
                    i15 = i16;
                }
                sb.append("}\n");
            }
            if (zzgi.zzc() != 0) {
                zzF(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i17 = 0;
                for (zzgk zzgk : zzgi.zzm()) {
                    int i18 = i17 + 1;
                    if (i17 != 0) {
                        sb.append(", ");
                    }
                    if (zzgk.zzi()) {
                        num = Integer.valueOf(zzgk.zzb());
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(": [");
                    int i19 = 0;
                    for (Long longValue : zzgk.zzf()) {
                        long longValue2 = longValue.longValue();
                        int i20 = i19 + 1;
                        if (i19 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i19 = i20;
                    }
                    sb.append("]");
                    i17 = i18;
                }
                sb.append("}\n");
            }
            zzF(sb, 3);
            sb.append("}\n");
        }
    }

    private static final void zzI(StringBuilder sb, int i10, String str, Object obj) {
        if (obj != null) {
            zzF(sb, i10 + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static final void zzJ(StringBuilder sb, int i10, String str, zzer zzer) {
        String str2;
        if (zzer != null) {
            zzF(sb, i10);
            sb.append(str);
            sb.append(" {\n");
            if (zzer.zzg()) {
                int zzm = zzer.zzm();
                if (zzm == 1) {
                    str2 = "UNKNOWN_COMPARISON_TYPE";
                } else if (zzm == 2) {
                    str2 = "LESS_THAN";
                } else if (zzm == 3) {
                    str2 = "GREATER_THAN";
                } else if (zzm != 4) {
                    str2 = Operator.Operation.BETWEEN;
                } else {
                    str2 = "EQUAL";
                }
                zzI(sb, i10, "comparison_type", str2);
            }
            if (zzer.zzi()) {
                zzI(sb, i10, "match_as_float", Boolean.valueOf(zzer.zzf()));
            }
            if (zzer.zzh()) {
                zzI(sb, i10, "comparison_value", zzer.zzc());
            }
            if (zzer.zzk()) {
                zzI(sb, i10, "min_comparison_value", zzer.zze());
            }
            if (zzer.zzj()) {
                zzI(sb, i10, "max_comparison_value", zzer.zzd());
            }
            zzF(sb, i10);
            sb.append("}\n");
        }
    }

    public static int zza(zzgc zzgc, String str) {
        for (int i10 = 0; i10 < zzgc.zzb(); i10++) {
            if (str.equals(zzgc.zzao(i10).zzf())) {
                return i10;
            }
        }
        return -1;
    }

    public static zzll zzl(zzll zzll, byte[] bArr) {
        zzjr zza = zzjr.zza();
        if (zza != null) {
            return zzll.zzay(bArr, zza);
        }
        return zzll.zzax(bArr);
    }

    public static List zzr(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 * 64) + i11;
                if (i12 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i12)) {
                    j10 |= 1 << i11;
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    public static boolean zzv(List list, int i10) {
        if (i10 >= list.size() * 64) {
            return false;
        }
        if (((1 << (i10 % 64)) & ((Long) list.get(i10 / 64)).longValue()) != 0) {
            return true;
        }
        return false;
    }

    public static boolean zzx(String str) {
        if (str == null || !str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") || str.length() > 310) {
            return false;
        }
        return true;
    }

    public static final void zzz(zzfs zzfs, String str, Object obj) {
        List zzp = zzfs.zzp();
        int i10 = 0;
        while (true) {
            if (i10 >= zzp.size()) {
                i10 = -1;
                break;
            } else if (str.equals(((zzfx) zzp.get(i10)).zzg())) {
                break;
            } else {
                i10++;
            }
        }
        zzfw zze = zzfx.zze();
        zze.zzj(str);
        if (obj instanceof Long) {
            zze.zzi(((Long) obj).longValue());
        }
        if (i10 >= 0) {
            zzfs.zzj(i10, zze);
        } else {
            zzfs.zze(zze);
        }
    }

    public final boolean zzb() {
        return false;
    }

    public final long zzd(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.zzt.zzv().zzg();
        MessageDigest zzF = zzlb.zzF();
        if (zzF != null) {
            return zzlb.zzp(zzF.digest(bArr));
        }
        this.zzt.zzay().zzd().zza("Failed to get MD5");
        return 0;
    }

    public final Bundle zzf(Map map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    arrayList2.add(zzf((Map) arrayList.get(i10), false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r4.zzt.zzay().zzd().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Parcelable zzh(byte[] r5, android.os.Parcelable.Creator r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002f
        L_0x001c:
            com.google.android.gms.measurement.internal.zzfr r5 = r4.zzt     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzay()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzef r5 = r5.zzd()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002f:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzkv.zzh(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    public final zzaw zzi(zzaa zzaa) {
        String str;
        Object obj;
        Bundle zzf = zzf(zzaa.zze(), true);
        if (!zzf.containsKey("_o") || (obj = zzf.get("_o")) == null) {
            str = "app";
        } else {
            str = obj.toString();
        }
        String str2 = str;
        String zzb = zzgo.zzb(zzaa.zzd());
        if (zzb == null) {
            zzb = zzaa.zzd();
        }
        return new zzaw(zzb, new zzau(zzf), str2, zzaa.zza());
    }

    public final zzft zzj(zzar zzar) {
        zzfs zze = zzft.zze();
        zze.zzl(zzar.zze);
        zzat zzat = new zzat(zzar.zzf);
        while (zzat.hasNext()) {
            String zza = zzat.next();
            zzfw zze2 = zzfx.zze();
            zze2.zzj(zza);
            Object zzf = zzar.zzf.zzf(zza);
            Preconditions.checkNotNull(zzf);
            zzt(zze2, zzf);
            zze.zze(zze2);
        }
        return (zzft) zze.zzaC();
    }

    public final String zzm(zzgb zzgb) {
        Long l10;
        Long l11;
        Double d10;
        if (zzgb == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzgd zzgd : zzgb.zzd()) {
            if (zzgd != null) {
                zzF(sb, 1);
                sb.append("bundle {\n");
                if (zzgd.zzbj()) {
                    zzI(sb, 1, "protocol_version", Integer.valueOf(zzgd.zzd()));
                }
                zzpd.zzc();
                if (this.zzt.zzf().zzs((String) null, zzdu.zzal) && this.zzt.zzf().zzs(zzgd.zzx(), zzdu.zzan) && zzgd.zzbm()) {
                    zzI(sb, 1, "session_stitching_token", zzgd.zzK());
                }
                zzI(sb, 1, DispatchConstants.PLATFORM, zzgd.zzI());
                if (zzgd.zzbf()) {
                    zzI(sb, 1, "gmp_version", Long.valueOf(zzgd.zzm()));
                }
                if (zzgd.zzbq()) {
                    zzI(sb, 1, "uploading_gmp_version", Long.valueOf(zzgd.zzr()));
                }
                if (zzgd.zzbd()) {
                    zzI(sb, 1, "dynamite_version", Long.valueOf(zzgd.zzj()));
                }
                if (zzgd.zzba()) {
                    zzI(sb, 1, "config_version", Long.valueOf(zzgd.zzh()));
                }
                zzI(sb, 1, "gmp_app_id", zzgd.zzF());
                zzI(sb, 1, "admob_app_id", zzgd.zzw());
                zzI(sb, 1, "app_id", zzgd.zzx());
                zzI(sb, 1, "app_version", zzgd.zzA());
                if (zzgd.zzaY()) {
                    zzI(sb, 1, "app_version_major", Integer.valueOf(zzgd.zza()));
                }
                zzI(sb, 1, "firebase_instance_id", zzgd.zzE());
                if (zzgd.zzbc()) {
                    zzI(sb, 1, "dev_cert_hash", Long.valueOf(zzgd.zzi()));
                }
                zzI(sb, 1, "app_store", zzgd.zzz());
                if (zzgd.zzbp()) {
                    zzI(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgd.zzq()));
                }
                if (zzgd.zzbn()) {
                    zzI(sb, 1, "start_timestamp_millis", Long.valueOf(zzgd.zzp()));
                }
                if (zzgd.zzbe()) {
                    zzI(sb, 1, "end_timestamp_millis", Long.valueOf(zzgd.zzk()));
                }
                if (zzgd.zzbi()) {
                    zzI(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgd.zzo()));
                }
                if (zzgd.zzbh()) {
                    zzI(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgd.zzn()));
                }
                zzI(sb, 1, "app_instance_id", zzgd.zzy());
                zzI(sb, 1, "resettable_device_id", zzgd.zzJ());
                zzI(sb, 1, "ds_id", zzgd.zzD());
                if (zzgd.zzbg()) {
                    zzI(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgd.zzaW()));
                }
                zzI(sb, 1, bt.f13931y, zzgd.zzH());
                zzI(sb, 1, "device_model", zzgd.zzC());
                zzI(sb, 1, "user_default_language", zzgd.zzL());
                if (zzgd.zzbo()) {
                    zzI(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgd.zzf()));
                }
                if (zzgd.zzaZ()) {
                    zzI(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgd.zzb()));
                }
                if (zzgd.zzbl()) {
                    zzI(sb, 1, "service_upload", Boolean.valueOf(zzgd.zzaX()));
                }
                zzI(sb, 1, "health_monitor", zzgd.zzG());
                if (zzgd.zzbk()) {
                    zzI(sb, 1, IjkMediaPlayer.OnNativeInvokeListener.ARG_RETRY_COUNTER, Integer.valueOf(zzgd.zze()));
                }
                if (zzgd.zzbb()) {
                    zzI(sb, 1, "consent_signals", zzgd.zzB());
                }
                List<zzgm> zzO = zzgd.zzO();
                if (zzO != null) {
                    for (zzgm zzgm : zzO) {
                        if (zzgm != null) {
                            zzF(sb, 2);
                            sb.append("user_property {\n");
                            if (zzgm.zzs()) {
                                l10 = Long.valueOf(zzgm.zzc());
                            } else {
                                l10 = null;
                            }
                            zzI(sb, 2, "set_timestamp_millis", l10);
                            zzI(sb, 2, "name", this.zzt.zzj().zzf(zzgm.zzf()));
                            zzI(sb, 2, "string_value", zzgm.zzg());
                            if (zzgm.zzr()) {
                                l11 = Long.valueOf(zzgm.zzb());
                            } else {
                                l11 = null;
                            }
                            zzI(sb, 2, "int_value", l11);
                            if (zzgm.zzq()) {
                                d10 = Double.valueOf(zzgm.zza());
                            } else {
                                d10 = null;
                            }
                            zzI(sb, 2, "double_value", d10);
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzfp> zzM = zzgd.zzM();
                if (zzM != null) {
                    for (zzfp zzfp : zzM) {
                        if (zzfp != null) {
                            zzF(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzfp.zzk()) {
                                zzI(sb, 2, "audience_id", Integer.valueOf(zzfp.zza()));
                            }
                            if (zzfp.zzm()) {
                                zzI(sb, 2, "new_audience", Boolean.valueOf(zzfp.zzj()));
                            }
                            zzH(sb, 2, "current_data", zzfp.zzd());
                            if (zzfp.zzn()) {
                                zzH(sb, 2, "previous_data", zzfp.zze());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzft> zzN = zzgd.zzN();
                if (zzN != null) {
                    for (zzft zzft : zzN) {
                        if (zzft != null) {
                            zzF(sb, 2);
                            sb.append("event {\n");
                            zzI(sb, 2, "name", this.zzt.zzj().zzd(zzft.zzh()));
                            if (zzft.zzu()) {
                                zzI(sb, 2, "timestamp_millis", Long.valueOf(zzft.zzd()));
                            }
                            if (zzft.zzt()) {
                                zzI(sb, 2, "previous_timestamp_millis", Long.valueOf(zzft.zzc()));
                            }
                            if (zzft.zzs()) {
                                zzI(sb, 2, "count", Integer.valueOf(zzft.zza()));
                            }
                            if (zzft.zzb() != 0) {
                                zzD(sb, 2, zzft.zzi());
                            }
                            zzF(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zzF(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public final String zzo(zzek zzek) {
        if (zzek == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzek.zzp()) {
            zzI(sb, 0, "filter_id", Integer.valueOf(zzek.zzb()));
        }
        zzI(sb, 0, "event_name", this.zzt.zzj().zzd(zzek.zzg()));
        String zzG = zzG(zzek.zzk(), zzek.zzm(), zzek.zzn());
        if (!zzG.isEmpty()) {
            zzI(sb, 0, "filter_type", zzG);
        }
        if (zzek.zzo()) {
            zzJ(sb, 1, "event_count_filter", zzek.zzf());
        }
        if (zzek.zza() > 0) {
            sb.append("  filters {\n");
            for (zzem zzE : zzek.zzh()) {
                zzE(sb, 2, zzE);
            }
        }
        zzF(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public final String zzp(zzet zzet) {
        if (zzet == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzet.zzj()) {
            zzI(sb, 0, "filter_id", Integer.valueOf(zzet.zza()));
        }
        zzI(sb, 0, "property_name", this.zzt.zzj().zzf(zzet.zze()));
        String zzG = zzG(zzet.zzg(), zzet.zzh(), zzet.zzi());
        if (!zzG.isEmpty()) {
            zzI(sb, 0, "filter_type", zzG);
        }
        zzE(sb, 1, zzet.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    public final List zzq(List list, List list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                this.zzt.zzay().zzk().zzb("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    this.zzt.zzay().zzk().zzc("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (num.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i10);
    }

    public final Map zzs(Bundle bundle, boolean z10) {
        HashMap hashMap = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zzs((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            Object obj2 = arrayList2.get(i10);
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zzs((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zzs((Bundle) obj, false));
                    }
                    hashMap.put(str, arrayList);
                }
            } else if (obj != null) {
                hashMap.put(str, obj);
            }
        }
        return hashMap;
    }

    public final void zzt(zzfw zzfw, Object obj) {
        Preconditions.checkNotNull(obj);
        zzfw.zzg();
        zzfw.zze();
        zzfw.zzd();
        zzfw.zzf();
        if (obj instanceof String) {
            zzfw.zzk((String) obj);
        } else if (obj instanceof Long) {
            zzfw.zzi(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzfw.zzh(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzfw zze = zzfx.zze();
                    for (String str : bundle.keySet()) {
                        zzfw zze2 = zzfx.zze();
                        zze2.zzj(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zze2.zzi(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zze2.zzk((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zze2.zzh(((Double) obj2).doubleValue());
                        }
                        zze.zzc(zze2);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((zzfx) zze.zzaC());
                    }
                }
            }
            zzfw.zzb(arrayList);
        } else {
            this.zzt.zzay().zzd().zzb("Ignoring invalid (type) event param value", obj);
        }
    }

    public final void zzu(zzgl zzgl, Object obj) {
        Preconditions.checkNotNull(obj);
        zzgl.zzc();
        zzgl.zzb();
        zzgl.zza();
        if (obj instanceof String) {
            zzgl.zzh((String) obj);
        } else if (obj instanceof Long) {
            zzgl.zze(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzgl.zzd(((Double) obj).doubleValue());
        } else {
            this.zzt.zzay().zzd().zzb("Ignoring invalid (type) user attribute value", obj);
        }
    }

    public final boolean zzw(long j10, long j11) {
        if (j10 == 0 || j11 <= 0 || Math.abs(this.zzt.zzav().currentTimeMillis() - j10) > j11) {
            return true;
        }
        return false;
    }

    public final byte[] zzy(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            this.zzt.zzay().zzd().zzb("Failed to gzip content", e10);
            throw e10;
        }
    }
}
