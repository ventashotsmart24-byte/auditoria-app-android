package f5;

import com.mobile.brasiltv.activity.PlayAty;

public final /* synthetic */ class x2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PlayAty f16713a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f16714b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f16715c;

    public /* synthetic */ x2(PlayAty playAty, boolean z10, String str) {
        this.f16713a = playAty;
        this.f16714b = z10;
        this.f16715c = str;
    }

    public final void run() {
        PlayAty.D3(this.f16713a, this.f16714b, this.f16715c);
    }
}
