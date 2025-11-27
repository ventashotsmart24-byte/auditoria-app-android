package g5;

import a6.d;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mobile.brasiltv.view.adView.CommAdShowControl;
import com.mobile.brasiltv.view.adView.IAdShowControl;
import t9.g;
import t9.i;

public final class e1 implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    public String f16894a;

    /* renamed from: b  reason: collision with root package name */
    public final String f16895b;

    /* renamed from: c  reason: collision with root package name */
    public final IAdShowControl f16896c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f16897d;

    public e1(String str, String str2, IAdShowControl iAdShowControl, boolean z10) {
        i.g(str, "adUnitId");
        i.g(iAdShowControl, "adControl");
        this.f16894a = str;
        this.f16895b = str2;
        this.f16896c = iAdShowControl;
        this.f16897d = z10;
    }

    public final IAdShowControl a() {
        return this.f16896c;
    }

    public final String b() {
        return this.f16895b;
    }

    public final String c() {
        return this.f16894a;
    }

    public final boolean d() {
        return this.f16897d;
    }

    public int getItemType() {
        return d.f10667a.h();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(String str, String str2, IAdShowControl iAdShowControl, boolean z10, int i10, g gVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? new CommAdShowControl() : iAdShowControl, (i10 & 8) != 0 ? false : z10);
    }
}
