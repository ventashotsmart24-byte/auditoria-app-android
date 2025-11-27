package b6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.f;
import java.util.LinkedHashMap;
import java.util.Map;
import l5.a;
import t9.i;

public abstract class e<P extends a> extends f {

    /* renamed from: e  reason: collision with root package name */
    public boolean f10947e = true;

    /* renamed from: f  reason: collision with root package name */
    public Activity f10948f;

    /* renamed from: g  reason: collision with root package name */
    public View f10949g;

    /* renamed from: h  reason: collision with root package name */
    public Map f10950h = new LinkedHashMap();

    public void X2() {
        this.f10950h.clear();
    }

    public abstract void Y2();

    public final Activity Z2() {
        Activity activity = this.f10948f;
        if (activity != null) {
            return activity;
        }
        i.w("mActivity");
        return null;
    }

    public abstract a a3();

    public View b3() {
        return this.f10949g;
    }

    public abstract int c3();

    public final void d3(Activity activity) {
        i.g(activity, "<set-?>");
        this.f10948f = activity;
    }

    public void e3(View view) {
        this.f10949g = view;
    }

    public void onAttach(Context context) {
        i.g(context, f.X);
        super.onAttach(context);
        androidx.fragment.app.e activity = getActivity();
        i.d(activity);
        d3(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        i.g(layoutInflater, "inflater");
        if (b3() == null) {
            e3(layoutInflater.inflate(c3(), viewGroup, false));
        }
        return b3();
    }

    public void onDestroy() {
        a3().g();
        super.onDestroy();
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    public void onViewCreated(View view, Bundle bundle) {
        i.g(view, "view");
        super.onViewCreated(view, bundle);
        if (this.f10947e) {
            this.f10947e = false;
            Y2();
            a3().e();
        }
    }
}
