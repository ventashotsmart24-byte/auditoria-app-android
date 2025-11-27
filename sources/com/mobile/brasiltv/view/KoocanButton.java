package com.mobile.brasiltv.view;

import android.content.Context;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import com.umeng.analytics.pro.f;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class KoocanButton extends Button {
    public Map<Integer, View> _$_findViewCache;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public KoocanButton(Context context) {
        this(context, (AttributeSet) null, 2, (g) null);
        i.g(context, f.X);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setTransformationMethod((TransformationMethod) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KoocanButton(Context context, AttributeSet attributeSet, int i10, g gVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KoocanButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        setTransformationMethod((TransformationMethod) null);
    }
}
