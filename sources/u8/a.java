package u8;

import android.os.Bundle;
import androidx.appcompat.app.d;
import io.reactivex.subjects.BehaviorSubject;
import s8.b;
import t8.c;

public abstract class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public final BehaviorSubject f19640a = BehaviorSubject.create();

    public final b O1() {
        return c.a(this.f19640a);
    }

    public final b P1(t8.a aVar) {
        return s8.d.c(this.f19640a, aVar);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19640a.onNext(t8.a.CREATE);
    }

    public void onDestroy() {
        this.f19640a.onNext(t8.a.DESTROY);
        super.onDestroy();
    }

    public void onPause() {
        this.f19640a.onNext(t8.a.PAUSE);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f19640a.onNext(t8.a.RESUME);
    }

    public void onStart() {
        super.onStart();
        this.f19640a.onNext(t8.a.START);
    }

    public void onStop() {
        this.f19640a.onNext(t8.a.STOP);
        super.onStop();
    }
}
