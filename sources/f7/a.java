package f7;

import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.mobile.brasiltv.utils.zxing.view.ViewfinderView;

public final class a implements ResultPointCallback {

    /* renamed from: a  reason: collision with root package name */
    public final ViewfinderView f16750a;

    public a(ViewfinderView viewfinderView) {
        this.f16750a = viewfinderView;
    }

    public void foundPossibleResultPoint(ResultPoint resultPoint) {
        this.f16750a.a(resultPoint);
    }
}
