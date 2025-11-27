package c8;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.o;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f11376b = "b";

    /* renamed from: c  reason: collision with root package name */
    public static final Object f11377c = new Object();

    /* renamed from: a  reason: collision with root package name */
    public e f11378a;

    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        public e f11379a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f11380b;

        public a(o oVar) {
            this.f11380b = oVar;
        }

        /* renamed from: a */
        public synchronized e get() {
            if (this.f11379a == null) {
                this.f11379a = b.this.h(this.f11380b);
            }
            return this.f11379a;
        }
    }

    /* renamed from: c8.b$b  reason: collision with other inner class name */
    public class C0153b implements ObservableTransformer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f11382a;

        /* renamed from: c8.b$b$a */
        public class a implements Function {
            public a() {
            }

            /* renamed from: a */
            public ObservableSource apply(List list) {
                if (list.isEmpty()) {
                    return Observable.empty();
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((a) it.next()).f11374b) {
                        return Observable.just(Boolean.FALSE);
                    }
                }
                return Observable.just(Boolean.TRUE);
            }
        }

        public C0153b(String[] strArr) {
            this.f11382a = strArr;
        }

        public ObservableSource apply(Observable observable) {
            return b.this.n(observable, this.f11382a).buffer(this.f11382a.length).flatMap(new a());
        }
    }

    public class c implements ObservableTransformer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f11385a;

        public c(String[] strArr) {
            this.f11385a = strArr;
        }

        public ObservableSource apply(Observable observable) {
            return b.this.n(observable, this.f11385a);
        }
    }

    public class d implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String[] f11387a;

        public d(String[] strArr) {
            this.f11387a = strArr;
        }

        /* renamed from: a */
        public Observable apply(Object obj) {
            return b.this.q(this.f11387a);
        }
    }

    public interface e {
        Object get();
    }

    public b(androidx.fragment.app.e eVar) {
        this.f11378a = g(eVar.getSupportFragmentManager());
    }

    public ObservableTransformer d(String... strArr) {
        return new C0153b(strArr);
    }

    public ObservableTransformer e(String... strArr) {
        return new c(strArr);
    }

    public final e f(o oVar) {
        return (e) oVar.h0(f11376b);
    }

    public final e g(o oVar) {
        return new a(oVar);
    }

    public final e h(o oVar) {
        boolean z10;
        e f10 = f(oVar);
        if (f10 == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return f10;
        }
        e eVar = new e();
        oVar.m().e(eVar, f11376b).k();
        return eVar;
    }

    public boolean i(String str) {
        if (!j() || ((e) this.f11378a.get()).Q2(str)) {
            return true;
        }
        return false;
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    public boolean k(String str) {
        if (!j() || !((e) this.f11378a.get()).R2(str)) {
            return false;
        }
        return true;
    }

    public final Observable l(Observable observable, Observable observable2) {
        if (observable == null) {
            return Observable.just(f11377c);
        }
        return Observable.merge(observable, observable2);
    }

    public final Observable m(String... strArr) {
        for (String O2 : strArr) {
            if (!((e) this.f11378a.get()).O2(O2)) {
                return Observable.empty();
            }
        }
        return Observable.just(f11377c);
    }

    public final Observable n(Observable observable, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            return l(observable, m(strArr)).flatMap(new d(strArr));
        }
        throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }

    public Observable o(String... strArr) {
        return Observable.just(f11377c).compose(d(strArr));
    }

    public Observable p(String... strArr) {
        return Observable.just(f11377c).compose(e(strArr));
    }

    public final Observable q(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            ((e) this.f11378a.get()).S2("Requesting permission " + str);
            if (i(str)) {
                arrayList.add(Observable.just(new a(str, true, false)));
            } else if (k(str)) {
                arrayList.add(Observable.just(new a(str, false, false)));
            } else {
                PublishSubject P2 = ((e) this.f11378a.get()).P2(str);
                if (P2 == null) {
                    arrayList2.add(str);
                    P2 = PublishSubject.create();
                    ((e) this.f11378a.get()).V2(str, P2);
                }
                arrayList.add(P2);
            }
        }
        if (!arrayList2.isEmpty()) {
            r((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }

    public void r(String[] strArr) {
        ((e) this.f11378a.get()).S2("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        ((e) this.f11378a.get()).U2(strArr);
    }

    public Observable s(Activity activity, String... strArr) {
        if (!j()) {
            return Observable.just(Boolean.FALSE);
        }
        return Observable.just(Boolean.valueOf(t(activity, strArr)));
    }

    public final boolean t(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (!i(str) && !activity.shouldShowRequestPermissionRationale(str)) {
                return false;
            }
        }
        return true;
    }
}
