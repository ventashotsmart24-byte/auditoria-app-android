package u8;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import io.reactivex.subjects.BehaviorSubject;
import t8.c;

public abstract class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public final BehaviorSubject f19641a = BehaviorSubject.create();

    public final s8.b O2() {
        return c.b(this.f19641a);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f19641a.onNext(t8.b.ATTACH);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19641a.onNext(t8.b.CREATE);
    }

    public void onDestroy() {
        this.f19641a.onNext(t8.b.DESTROY);
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f19641a.onNext(t8.b.DESTROY_VIEW);
        super.onDestroyView();
    }

    public void onDetach() {
        this.f19641a.onNext(t8.b.DETACH);
        super.onDetach();
    }

    public void onPause() {
        this.f19641a.onNext(t8.b.PAUSE);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f19641a.onNext(t8.b.RESUME);
    }

    public void onStart() {
        super.onStart();
        this.f19641a.onNext(t8.b.START);
    }

    public void onStop() {
        this.f19641a.onNext(t8.b.STOP);
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f19641a.onNext(t8.b.CREATE_VIEW);
    }
}
