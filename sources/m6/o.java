package m6;

import com.mobile.brasiltv.player.TitanPlayerController;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f18909a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f18910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TitanPlayerController f18911c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f18912d;

    public /* synthetic */ o(int i10, String str, TitanPlayerController titanPlayerController, String str2) {
        this.f18909a = i10;
        this.f18910b = str;
        this.f18911c = titanPlayerController;
        this.f18912d = str2;
    }

    public final void run() {
        TitanPlayerController.K2(this.f18909a, this.f18910b, this.f18911c, this.f18912d);
    }
}
