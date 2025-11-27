package ba;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import t9.i;
import y9.e;

public abstract class s extends r {
    public static final boolean d(String str, String str2, boolean z10) {
        i.g(str, "<this>");
        i.g(str2, DynamicLink.Builder.KEY_SUFFIX);
        if (!z10) {
            return str.endsWith(str2);
        }
        return h(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean e(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return d(str, str2, z10);
    }

    public static final boolean f(String str, String str2, boolean z10) {
        if (str == null) {
            if (str2 == null) {
                return true;
            }
            return false;
        } else if (!z10) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ boolean g(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return f(str, str2, z10);
    }

    public static final boolean h(String str, int i10, String str2, int i11, int i12, boolean z10) {
        i.g(str, "<this>");
        i.g(str2, DispatchConstants.OTHER);
        if (!z10) {
            return str.regionMatches(i10, str2, i11, i12);
        }
        return str.regionMatches(z10, i10, str2, i11, i12);
    }

    public static final String i(String str, String str2, String str3, boolean z10) {
        i.g(str, "<this>");
        i.g(str2, "oldValue");
        i.g(str3, "newValue");
        int i10 = 0;
        int u10 = t.u(str, str2, 0, z10);
        if (u10 < 0) {
            return str;
        }
        int length = str2.length();
        int a10 = e.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append(str, i10, u10);
                sb.append(str3);
                i10 = u10 + length;
                if (u10 >= str.length() || (u10 = t.u(str, str2, u10 + a10, z10)) <= 0) {
                    sb.append(str, i10, str.length());
                    String sb2 = sb.toString();
                    i.f(sb2, "stringBuilder.append(this, i, length).toString()");
                }
                sb.append(str, i10, u10);
                sb.append(str3);
                i10 = u10 + length;
                break;
            } while ((u10 = t.u(str, str2, u10 + a10, z10)) <= 0);
            sb.append(str, i10, str.length());
            String sb22 = sb.toString();
            i.f(sb22, "stringBuilder.append(this, i, length).toString()");
            return sb22;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String j(String str, String str2, String str3, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return i(str, str2, str3, z10);
    }

    public static final boolean k(String str, String str2, boolean z10) {
        i.g(str, "<this>");
        i.g(str2, "prefix");
        if (!z10) {
            return str.startsWith(str2);
        }
        return h(str, 0, str2, 0, str2.length(), z10);
    }

    public static /* synthetic */ boolean l(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return k(str, str2, z10);
    }
}
