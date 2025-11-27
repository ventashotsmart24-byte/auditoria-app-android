package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.os.Build;
import android.util.Property;

public abstract class g {
    public static ObjectAnimator a(Object obj, Property property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(obj, property, (TypeConverter) null, path);
        }
        return ObjectAnimator.ofFloat(obj, new i(property, path), new float[]{0.0f, 1.0f});
    }
}
