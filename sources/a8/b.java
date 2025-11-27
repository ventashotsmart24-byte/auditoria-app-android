package a8;

import android.app.Activity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class b implements OnCompleteListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f10710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f10711b;

    public /* synthetic */ b(d dVar, Activity activity) {
        this.f10710a = dVar;
        this.f10711b = activity;
    }

    public final void onComplete(Task task) {
        d.l(this.f10710a, this.f10711b, task);
    }
}
