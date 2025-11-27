package m6;

import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f18889a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f18890b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18891c;

    public /* synthetic */ i0(long j10, long j11, TitanPlayerController titanPlayerController) {
        this.f18889a = j10;
        this.f18890b = j11;
        this.f18891c = titanPlayerController;
    }

    public final void run() {
        TitanPlayerController.O2(this.f18889a, this.f18890b, this.f18891c);
    }
}
