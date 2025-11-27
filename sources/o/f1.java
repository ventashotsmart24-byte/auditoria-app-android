package o;

import android.app.Notification;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.core.graphics.drawable.IconCompat;
import com.hpplay.cybergarage.upnp.Icon;
import java.util.List;
import o.s;

public abstract class f1 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8329a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f8330b = new Object();

    public static SparseArray a(List list) {
        int size = list.size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = (Bundle) list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle b(s.a aVar) {
        int i10;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat f10 = aVar.f();
        if (f10 != null) {
            i10 = f10.g();
        } else {
            i10 = 0;
        }
        bundle2.putInt(Icon.ELEM_NAME, i10);
        bundle2.putCharSequence("title", aVar.j());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", d(aVar.g()));
        bundle2.putBoolean("showsUserInterface", aVar.i());
        bundle2.putInt("semanticAction", aVar.h());
        return bundle2;
    }

    public static Bundle c(j1 j1Var) {
        new Bundle();
        throw null;
    }

    public static Bundle[] d(j1[] j1VarArr) {
        if (j1VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[j1VarArr.length];
        for (int i10 = 0; i10 < j1VarArr.length; i10++) {
            j1 j1Var = j1VarArr[i10];
            bundleArr[i10] = c((j1) null);
        }
        return bundleArr;
    }

    public static Bundle e(Notification.Builder builder, s.a aVar) {
        int i10;
        IconCompat f10 = aVar.f();
        if (f10 != null) {
            i10 = f10.g();
        } else {
            i10 = 0;
        }
        builder.addAction(i10, aVar.j(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.g() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", d(aVar.g()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", d(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
