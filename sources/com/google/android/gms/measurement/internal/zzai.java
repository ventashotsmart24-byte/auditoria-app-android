package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.EnumMap;

public final class zzai {
    public static final zzai zza = new zzai((Boolean) null, (Boolean) null);
    private final EnumMap zzb;

    public zzai(Boolean bool, Boolean bool2) {
        EnumMap enumMap = new EnumMap(zzah.class);
        this.zzb = enumMap;
        enumMap.put(zzah.AD_STORAGE, bool);
        enumMap.put(zzah.ANALYTICS_STORAGE, bool2);
    }

    public static zzai zza(Bundle bundle) {
        if (bundle == null) {
            return zza;
        }
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzah : zzah.values()) {
            enumMap.put(zzah, zzn(bundle.getString(zzah.zzd)));
        }
        return new zzai(enumMap);
    }

    public static zzai zzb(String str) {
        EnumMap enumMap = new EnumMap(zzah.class);
        if (str != null) {
            int i10 = 0;
            while (true) {
                zzah[] zzahArr = zzah.zzc;
                int length = zzahArr.length;
                if (i10 >= 2) {
                    break;
                }
                zzah zzah = zzahArr[i10];
                int i11 = i10 + 2;
                if (i11 < str.length()) {
                    char charAt = str.charAt(i11);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt == '0') {
                            bool = Boolean.FALSE;
                        } else if (charAt == '1') {
                            bool = Boolean.TRUE;
                        }
                    }
                    enumMap.put(zzah, bool);
                }
                i10++;
            }
        }
        return new zzai(enumMap);
    }

    public static String zzg(Bundle bundle) {
        String string;
        for (zzah zzah : zzah.values()) {
            if (bundle.containsKey(zzah.zzd) && (string = bundle.getString(zzah.zzd)) != null && zzn(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean zzj(int i10, int i11) {
        return i10 <= i11;
    }

    public static final int zzm(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        if (bool.booleanValue()) {
            return 1;
        }
        return 2;
    }

    private static Boolean zzn(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (str.equals(NetworkUtil.NETWORK_CLASS_DENIED)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzai)) {
            return false;
        }
        zzai zzai = (zzai) obj;
        for (zzah zzah : zzah.values()) {
            if (zzm((Boolean) this.zzb.get(zzah)) != zzm((Boolean) zzai.zzb.get(zzah))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i10 = 17;
        for (Boolean zzm : this.zzb.values()) {
            i10 = (i10 * 31) + zzm(zzm);
        }
        return i10;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("settings: ");
        zzah[] values = zzah.values();
        int length = values.length;
        for (int i10 = 0; i10 < length; i10++) {
            zzah zzah = values[i10];
            if (i10 != 0) {
                sb.append(", ");
            }
            sb.append(zzah.name());
            sb.append(Operator.Operation.EQUALS);
            Boolean bool = (Boolean) this.zzb.get(zzah);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                if (true != bool.booleanValue()) {
                    str = NetworkUtil.NETWORK_CLASS_DENIED;
                } else {
                    str = "granted";
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public final zzai zzc(zzai zzai) {
        boolean z10;
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzah : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzah);
            Boolean bool2 = (Boolean) zzai.zzb.get(zzah);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                if (!bool.booleanValue() || !bool2.booleanValue()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                bool = Boolean.valueOf(z10);
            }
            enumMap.put(zzah, bool);
        }
        return new zzai(enumMap);
    }

    public final zzai zzd(zzai zzai) {
        EnumMap enumMap = new EnumMap(zzah.class);
        for (zzah zzah : zzah.values()) {
            Boolean bool = (Boolean) this.zzb.get(zzah);
            if (bool == null) {
                bool = (Boolean) zzai.zzb.get(zzah);
            }
            enumMap.put(zzah, bool);
        }
        return new zzai(enumMap);
    }

    public final Boolean zze() {
        return (Boolean) this.zzb.get(zzah.AD_STORAGE);
    }

    public final Boolean zzf() {
        return (Boolean) this.zzb.get(zzah.ANALYTICS_STORAGE);
    }

    public final String zzh() {
        char c10;
        StringBuilder sb = new StringBuilder("G1");
        zzah[] zzahArr = zzah.zzc;
        int length = zzahArr.length;
        for (int i10 = 0; i10 < 2; i10++) {
            Boolean bool = (Boolean) this.zzb.get(zzahArr[i10]);
            if (bool == null) {
                c10 = ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER;
            } else if (bool.booleanValue()) {
                c10 = '1';
            } else {
                c10 = '0';
            }
            sb.append(c10);
        }
        return sb.toString();
    }

    public final boolean zzi(zzah zzah) {
        Boolean bool = (Boolean) this.zzb.get(zzah);
        if (bool == null || bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public final boolean zzk(zzai zzai) {
        return zzl(zzai, (zzah[]) this.zzb.keySet().toArray(new zzah[0]));
    }

    public final boolean zzl(zzai zzai, zzah... zzahArr) {
        for (zzah zzah : zzahArr) {
            Boolean bool = (Boolean) this.zzb.get(zzah);
            Boolean bool2 = (Boolean) zzai.zzb.get(zzah);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public zzai(EnumMap enumMap) {
        EnumMap enumMap2 = new EnumMap(zzah.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
    }
}
