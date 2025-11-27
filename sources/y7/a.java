package y7;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import t9.i;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    public final ApiException f19921a;

    public a(ApiException apiException) {
        i.g(apiException, "e");
        this.f19921a = apiException;
    }

    public boolean a() {
        if (this.f19921a.getStatusCode() == Status.RESULT_INTERNAL_ERROR.getStatusCode() || this.f19921a.getStatusCode() == Status.RESULT_TIMEOUT.getStatusCode() || this.f19921a.getStatusCode() == 7) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.f19921a.getStatusCode() == 12500) {
            return true;
        }
        return false;
    }
}
