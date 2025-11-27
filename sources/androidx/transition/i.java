package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

public class i extends Property {

    /* renamed from: a  reason: collision with root package name */
    public final Property f3211a;

    /* renamed from: b  reason: collision with root package name */
    public final PathMeasure f3212b;

    /* renamed from: c  reason: collision with root package name */
    public final float f3213c;

    /* renamed from: d  reason: collision with root package name */
    public final float[] f3214d = new float[2];

    /* renamed from: e  reason: collision with root package name */
    public final PointF f3215e = new PointF();

    /* renamed from: f  reason: collision with root package name */
    public float f3216f;

    public i(Property property, Path path) {
        super(Float.class, property.getName());
        this.f3211a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f3212b = pathMeasure;
        this.f3213c = pathMeasure.getLength();
    }

    /* renamed from: a */
    public Float get(Object obj) {
        return Float.valueOf(this.f3216f);
    }

    /* renamed from: b */
    public void set(Object obj, Float f10) {
        this.f3216f = f10.floatValue();
        this.f3212b.getPosTan(this.f3213c * f10.floatValue(), this.f3214d, (float[]) null);
        PointF pointF = this.f3215e;
        float[] fArr = this.f3214d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f3211a.set(obj, pointF);
    }
}
