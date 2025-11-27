package a1;

import androidx.work.b;
import java.util.List;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f111a = k.f("InputMerger");

    public static h a(String str) {
        try {
            return (h) Class.forName(str).newInstance();
        } catch (Exception e10) {
            k c10 = k.c();
            String str2 = f111a;
            c10.b(str2, "Trouble instantiating + " + str, e10);
            return null;
        }
    }

    public abstract b b(List list);
}
