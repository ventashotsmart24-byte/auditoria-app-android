package g5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.o;
import b6.r0;
import java.util.List;

public class w0 extends t0 {
    public w0(o oVar, List list) {
        super(oVar, list);
    }

    public Fragment a(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("fragment_live_index", i10);
        r0 r0Var = new r0();
        r0Var.setArguments(bundle);
        return r0Var;
    }

    /* renamed from: c */
    public CharSequence b(String str) {
        return str;
    }
}
