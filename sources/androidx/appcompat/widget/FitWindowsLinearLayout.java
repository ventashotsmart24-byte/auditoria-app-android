package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.s1;

public class FitWindowsLinearLayout extends LinearLayout implements s1 {

    /* renamed from: a  reason: collision with root package name */
    public s1.a f1094a;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean fitSystemWindows(Rect rect) {
        s1.a aVar = this.f1094a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(s1.a aVar) {
        this.f1094a = aVar;
    }
}
