package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public final Map f3271a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public View f3272b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f3273c = new ArrayList();

    public u(View view) {
        this.f3272b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (this.f3272b != uVar.f3272b || !this.f3271a.equals(uVar.f3271a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f3272b.hashCode() * 31) + this.f3271a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f3272b + "\n") + "    values:";
        for (String str2 : this.f3271a.keySet()) {
            str = str + "    " + str2 + ": " + this.f3271a.get(str2) + "\n";
        }
        return str;
    }
}
