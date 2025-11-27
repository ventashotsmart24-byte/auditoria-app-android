package na;

import ba.t;
import java.util.List;
import t9.i;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f19081a = new g();

    public final String a(String str) {
        boolean z10;
        boolean z11;
        i.g(str, "str");
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        List M = t.M(str, new String[]{"."}, false, 0, 6, (Object) null);
        String str2 = (String) M.get(0);
        if (M.size() <= 1) {
            return str2;
        }
        CharSequence charSequence = (CharSequence) M.get(1);
        if (charSequence == null || charSequence.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return str2;
        }
        if (((String) M.get(1)).length() >= 3) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append('.');
            String substring = ((String) M.get(1)).substring(0, 3);
            i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            return sb.toString();
        }
        return str2 + '.' + ((String) M.get(1));
    }
}
