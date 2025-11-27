package s8;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import v8.a;

public final class b implements ObservableTransformer, FlowableTransformer, SingleTransformer, MaybeTransformer, CompletableTransformer {

    /* renamed from: a  reason: collision with root package name */
    public final Observable f19479a;

    public b(Observable observable) {
        a.a(observable, "observable == null");
        this.f19479a = observable;
    }

    public ObservableSource apply(Observable observable) {
        return observable.takeUntil(this.f19479a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        return this.f19479a.equals(((b) obj).f19479a);
    }

    public int hashCode() {
        return this.f19479a.hashCode();
    }

    public String toString() {
        return "LifecycleTransformer{observable=" + this.f19479a + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public fb.b apply(Flowable flowable) {
        return flowable.takeUntil((fb.b) this.f19479a.toFlowable(BackpressureStrategy.LATEST));
    }

    public SingleSource apply(Single single) {
        return single.takeUntil(this.f19479a.firstOrError());
    }

    public MaybeSource apply(Maybe maybe) {
        return maybe.takeUntil(this.f19479a.firstElement());
    }

    public CompletableSource apply(Completable completable) {
        return Completable.ambArray(completable, this.f19479a.flatMapCompletable(a.f19478c));
    }
}
