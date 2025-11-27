package f5;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import l5.a;

public abstract class d extends c {

    /* renamed from: k  reason: collision with root package name */
    public Map f16560k = new LinkedHashMap();

    public abstract void R2();

    public abstract a S2();

    public abstract int T2();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(T2());
        R2();
        S2().e();
    }

    public void onDestroy() {
        S2().g();
        super.onDestroy();
    }
}
