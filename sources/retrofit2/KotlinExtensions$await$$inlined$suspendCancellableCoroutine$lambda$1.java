package retrofit2;

import h9.t;
import s9.l;
import t9.j;

public final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1 extends j implements l {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return t.f17319a;
    }

    public final void invoke(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
