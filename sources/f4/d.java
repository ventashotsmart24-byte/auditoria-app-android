package f4;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.Interpolator;
import g4.b;
import h4.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public e f6610a;

    /* renamed from: b  reason: collision with root package name */
    public List f6611b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f6612c;

    /* renamed from: d  reason: collision with root package name */
    public int f6613d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f6614e = 2000;

    public d(e eVar) {
        this.f6610a = eVar;
    }

    public d a(float[] fArr, int... iArr) {
        g(fArr, e.D, iArr);
        return this;
    }

    public ObjectAnimator b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f6610a, (PropertyValuesHolder[]) this.f6611b.toArray(new PropertyValuesHolder[this.f6611b.size()]));
        ofPropertyValuesHolder.setDuration(this.f6614e);
        ofPropertyValuesHolder.setRepeatCount(this.f6613d);
        ofPropertyValuesHolder.setInterpolator(this.f6612c);
        return ofPropertyValuesHolder;
    }

    public d c(long j10) {
        this.f6614e = j10;
        return this;
    }

    public d d(float... fArr) {
        h(b.a(fArr));
        return this;
    }

    public final void e(int i10, int i11) {
        if (i10 != i11) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11)}));
        }
    }

    public PropertyValuesHolder f(float[] fArr, Property property, float[] fArr2) {
        e(fArr.length, fArr2.length);
        Keyframe[] keyframeArr = new Keyframe[fArr.length];
        for (int i10 = 0; i10 < fArr2.length; i10++) {
            keyframeArr[i10] = Keyframe.ofFloat(fArr[i10], fArr2[i10]);
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(property, keyframeArr);
        this.f6611b.add(ofKeyframe);
        return ofKeyframe;
    }

    public PropertyValuesHolder g(float[] fArr, Property property, int[] iArr) {
        e(fArr.length, iArr.length);
        Keyframe[] keyframeArr = new Keyframe[fArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            keyframeArr[i10] = Keyframe.ofInt(fArr[i10], iArr[i10]);
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(property, keyframeArr);
        this.f6611b.add(ofKeyframe);
        return ofKeyframe;
    }

    public d h(Interpolator interpolator) {
        this.f6612c = interpolator;
        return this;
    }

    public d i(float[] fArr, int... iArr) {
        g(fArr, e.f6929u, iArr);
        return this;
    }

    public d j(float[] fArr, int... iArr) {
        g(fArr, e.f6928t, iArr);
        return this;
    }

    public d k(float[] fArr, int... iArr) {
        g(fArr, e.f6930v, iArr);
        return this;
    }

    public d l(float[] fArr, float... fArr2) {
        f(fArr, e.C, fArr2);
        return this;
    }

    public d m(float[] fArr, float... fArr2) {
        f(fArr, e.f6933y, fArr2);
        return this;
    }

    public d n(float[] fArr, float... fArr2) {
        f(fArr, e.f6934z, fArr2);
        return this;
    }
}
