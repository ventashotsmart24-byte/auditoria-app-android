package c8;

import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

public class e extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public Map f11389a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public boolean f11390b;

    public boolean O2(String str) {
        return this.f11389a.containsKey(str);
    }

    public PublishSubject P2(String str) {
        return (PublishSubject) this.f11389a.get(str);
    }

    public boolean Q2(String str) {
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("This fragment must be attached to an activity.");
        } else if (activity.checkSelfPermission(str) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean R2(String str) {
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            return activity.getPackageManager().isPermissionRevokedByPolicy(str, getActivity().getPackageName());
        }
        throw new IllegalStateException("This fragment must be attached to an activity.");
    }

    public void S2(String str) {
        if (this.f11390b) {
            String str2 = b.f11376b;
        }
    }

    public void T2(String[] strArr, int[] iArr, boolean[] zArr) {
        boolean z10;
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            S2("onRequestPermissionsResult  " + strArr[i10]);
            PublishSubject publishSubject = (PublishSubject) this.f11389a.get(strArr[i10]);
            if (publishSubject == null) {
                Log.e(b.f11376b, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                return;
            }
            this.f11389a.remove(strArr[i10]);
            if (iArr[i10] == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            publishSubject.onNext(new a(strArr[i10], z10, zArr[i10]));
            publishSubject.onComplete();
        }
    }

    public void U2(String[] strArr) {
        requestPermissions(strArr, 42);
    }

    public void V2(String str, PublishSubject publishSubject) {
        this.f11389a.put(str, publishSubject);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i11 = 0; i11 < strArr.length; i11++) {
                zArr[i11] = shouldShowRequestPermissionRationale(strArr[i11]);
            }
            T2(strArr, iArr, zArr);
        }
    }
}
