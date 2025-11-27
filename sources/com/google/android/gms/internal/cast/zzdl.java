package com.google.android.gms.internal.cast;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

public final class zzdl {
    @CheckForNull
    public static String zza(@CheckForNull String str) {
        return zzdi.zza(str);
    }

    public static String zzb(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        String str3;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            length = objArr.length;
            if (i11 >= length) {
                break;
            }
            Object obj = objArr[i11];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e10) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    if (sb2.length() != 0) {
                        str3 = "Exception during lenientFormat for ".concat(sb2);
                    } else {
                        str3 = new String("Exception during lenientFormat for ");
                    }
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", str3, e10);
                    String name2 = e10.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(sb2.length() + 9 + name2.length());
                    sb3.append(Operator.Operation.LESS_THAN);
                    sb3.append(sb2);
                    sb3.append(" threw ");
                    sb3.append(name2);
                    sb3.append(Operator.Operation.GREATER_THAN);
                    str2 = sb3.toString();
                }
            }
            objArr[i11] = str2;
            i11++;
        }
        StringBuilder sb4 = new StringBuilder(str.length() + (length * 16));
        int i12 = 0;
        while (true) {
            length2 = objArr.length;
            if (i10 >= length2 || (indexOf = str.indexOf("%s", i12)) == -1) {
                sb4.append(str, i12, str.length());
            } else {
                sb4.append(str, i12, indexOf);
                sb4.append(objArr[i10]);
                int i13 = i10 + 1;
                i12 = indexOf + 2;
                i10 = i13;
            }
        }
        sb4.append(str, i12, str.length());
        if (i10 < length2) {
            sb4.append(" [");
            sb4.append(objArr[i10]);
            for (int i14 = i10 + 1; i14 < objArr.length; i14++) {
                sb4.append(", ");
                sb4.append(objArr[i14]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }
}
