package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.n;
import androidx.transition.u;
import java.util.Map;

public class TextScale extends n {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(u uVar) {
        View view = uVar.f3272b;
        if (view instanceof TextView) {
            uVar.f3271a.put(PROPNAME_SCALE, Float.valueOf(((TextView) view).getScaleX()));
        }
    }

    public void captureEndValues(u uVar) {
        captureValues(uVar);
    }

    public void captureStartValues(u uVar) {
        captureValues(uVar);
    }

    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        float f10;
        if (uVar == null || uVar2 == null || !(uVar.f3272b instanceof TextView)) {
            return null;
        }
        View view = uVar2.f3272b;
        if (!(view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) view;
        Map map = uVar.f3271a;
        Map map2 = uVar2.f3271a;
        float f11 = 1.0f;
        if (map.get(PROPNAME_SCALE) != null) {
            f10 = ((Float) map.get(PROPNAME_SCALE)).floatValue();
        } else {
            f10 = 1.0f;
        }
        if (map2.get(PROPNAME_SCALE) != null) {
            f11 = ((Float) map2.get(PROPNAME_SCALE)).floatValue();
        }
        if (f10 == f11) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{f10, f11});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
