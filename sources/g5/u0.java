package g5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import b6.r;
import java.util.List;

public class u0 extends t0 {
    public u0(o oVar, List list) {
        super(oVar, list);
    }

    public Fragment a(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("fragment_live_tab_index", i10);
        r rVar = new r();
        rVar.setArguments(bundle);
        return rVar;
    }

    /* renamed from: c */
    public CharSequence b(String str) {
        return str;
    }
}
