package f5;

import com.mobile.brasiltv.activity.CastByNativeDeviceAty;
import java.util.List;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CastByNativeDeviceAty f16622a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f16623b;

    public /* synthetic */ l(CastByNativeDeviceAty castByNativeDeviceAty, List list) {
        this.f16622a = castByNativeDeviceAty;
        this.f16623b = list;
    }

    public final void run() {
        CastByNativeDeviceAty.c3(this.f16622a, this.f16623b);
    }
}
