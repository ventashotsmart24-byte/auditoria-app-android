package h7;

import android.content.Context;
import android.text.TextUtils;
import b5.a;
import com.mobile.autoupdate.R$string;
import j7.g;

public class f implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17301a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17302b;

    public f(Context context, String str) {
        this.f17301a = context.getApplicationContext();
        this.f17302b = str;
    }

    public void A(long j10, long j11) {
    }

    public void onFailure(Exception exc) {
        Context context = this.f17301a;
        g.a(context, context.getString(R$string.common_upgrade_download_fail), 0);
        a.g().n(this);
    }

    public void onSuccess() {
        a.g().n(this);
        if (!TextUtils.isEmpty(this.f17302b)) {
            j7.a.c(this.f17301a, this.f17302b);
        }
    }

    public void z() {
        Context context = this.f17301a;
        g.a(context, context.getString(R$string.common_upgrade_downloading), 0);
    }
}
