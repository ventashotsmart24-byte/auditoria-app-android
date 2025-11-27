package b6;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.view.vod.CouponFloatView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import t9.g;
import t9.i;

public interface q {

    public static final class a {

        /* renamed from: b6.q$a$a  reason: collision with other inner class name */
        public static final class C0146a extends RecyclerView.t {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ q f11063a;

            /* renamed from: b6.q$a$a$a  reason: collision with other inner class name */
            public static final class C0147a implements Observer {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ q f11064a;

                public C0147a(q qVar) {
                    this.f11064a = qVar;
                }

                public void a(long j10) {
                    CouponFloatView D0 = this.f11064a.D0();
                    if (D0 != null) {
                        CouponFloatView.slideOut$default(D0, 0, 1, (Object) null);
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    i.g(th, "e");
                }

                public /* bridge */ /* synthetic */ void onNext(Object obj) {
                    a(((Number) obj).longValue());
                }

                public void onSubscribe(Disposable disposable) {
                    i.g(disposable, "d");
                    this.f11064a.setDisposable(disposable);
                }
            }

            public C0146a(q qVar) {
                this.f11063a = qVar;
            }

            public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
                i.g(recyclerView, "recyclerView");
                if (this.f11063a.D0() != null) {
                    super.onScrollStateChanged(recyclerView, i10);
                    if (i10 == 0) {
                        Observable.timer(2, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0147a(this.f11063a));
                    } else if (i10 == 1 || i10 == 2) {
                        Disposable P1 = this.f11063a.P1();
                        if (P1 != null) {
                            P1.dispose();
                        }
                        CouponFloatView D0 = this.f11063a.D0();
                        if (D0 != null) {
                            CouponFloatView.slideIn$default(D0, 0, 1, (Object) null);
                        }
                    }
                }
            }
        }

        public static void a(q qVar, Context context, ViewGroup viewGroup) {
            i.g(viewGroup, "rootView");
            if (!w6.i.f9510g.L() && qVar.D0() == null && context != null) {
                qVar.Q1(new CouponFloatView(context, (AttributeSet) null, 0, 6, (g) null));
                CouponFloatView D0 = qVar.D0();
                if (D0 != null) {
                    D0.add(viewGroup);
                }
            }
        }

        public static RecyclerView.t b(q qVar) {
            return new C0146a(qVar);
        }

        public static void c(q qVar) {
            CouponFloatView D0 = qVar.D0();
            if (D0 != null) {
                D0.remove();
            }
            qVar.Q1((CouponFloatView) null);
        }
    }

    CouponFloatView D0();

    Disposable P1();

    void Q1(CouponFloatView couponFloatView);

    void setDisposable(Disposable disposable);
}
