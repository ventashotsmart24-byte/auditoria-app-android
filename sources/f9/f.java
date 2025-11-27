package f9;

import com.google.common.collect.ImmutableList;
import f9.e;
import java.util.List;

public abstract /* synthetic */ class f {
    public static List a(e.g gVar) {
        ImmutableList.Builder builder = ImmutableList.builder();
        if (gVar.f16793e != null) {
            builder.add((Object) new e.k(gVar));
        }
        if (gVar.f16794f != null) {
            builder.add((Object) new e.f(gVar));
        }
        return builder.build();
    }
}
