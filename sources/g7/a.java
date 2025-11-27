package g7;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import com.umeng.analytics.pro.f;
import t9.i;

public abstract class a extends PopupWindow {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        i.g(context, f.X);
        setWidth(d());
        setHeight(c());
        setAnimationStyle(b());
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
    }

    public final void a(View view) {
        if (view != null) {
            view.setSystemUiVisibility(5894);
        }
    }

    public abstract int b();

    public abstract int c();

    public abstract int d();

    public abstract boolean e();

    public void showAsDropDown(View view) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view);
    }

    public void showAtLocation(View view, int i10, int i11, int i12) {
        if (e()) {
            setFocusable(false);
            super.showAtLocation(view, i10, i11, i12);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAtLocation(view, i10, i11, i12);
    }

    public void showAsDropDown(View view, int i10, int i11) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view, i10, i11);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view, i10, i11);
    }

    public void showAsDropDown(View view, int i10, int i11, int i12) {
        if (e()) {
            setFocusable(false);
            super.showAsDropDown(view, i10, i11, i12);
            a(getContentView());
            setFocusable(true);
            return;
        }
        super.showAsDropDown(view, i10, i11, i12);
    }
}
