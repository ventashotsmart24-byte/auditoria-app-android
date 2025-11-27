package k2;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

public final class a extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public float f7291a = 2.14748365E9f;

    /* renamed from: b  reason: collision with root package name */
    public final float f7292b;

    /* renamed from: c  reason: collision with root package name */
    public final WheelView f7293c;

    public a(WheelView wheelView, float f10) {
        this.f7293c = wheelView;
        this.f7292b = f10;
    }

    public final void run() {
        if (this.f7291a == 2.14748365E9f) {
            if (Math.abs(this.f7292b) <= 2000.0f) {
                this.f7291a = this.f7292b;
            } else if (this.f7292b > 0.0f) {
                this.f7291a = 2000.0f;
            } else {
                this.f7291a = -2000.0f;
            }
        }
        if (Math.abs(this.f7291a) < 0.0f || Math.abs(this.f7291a) > 20.0f) {
            WheelView wheelView = this.f7293c;
            float f10 = (float) ((int) ((this.f7291a * 10.0f) / 1000.0f));
            wheelView.f5095u -= f10;
            if (!wheelView.f5094t) {
                float f11 = wheelView.f5088n;
                float f12 = ((float) (-wheelView.f5096v)) * f11;
                WheelView wheelView2 = this.f7293c;
                float itemsCount = ((float) ((wheelView.getItemsCount() - 1) - wheelView2.f5096v)) * f11;
                float f13 = wheelView2.f5095u;
                double d10 = (double) f13;
                double d11 = (double) f11;
                Double.isNaN(d11);
                double d12 = d11 * 0.25d;
                Double.isNaN(d10);
                if (d10 - d12 < ((double) f12)) {
                    f12 = f13 + f10;
                } else {
                    double d13 = (double) f13;
                    Double.isNaN(d13);
                    if (d13 + d12 > ((double) itemsCount)) {
                        itemsCount = f13 + f10;
                    }
                }
                if (f13 <= f12) {
                    this.f7291a = 40.0f;
                    wheelView2.f5095u = (float) ((int) f12);
                } else if (f13 >= itemsCount) {
                    wheelView2.f5095u = (float) ((int) itemsCount);
                    this.f7291a = -40.0f;
                }
            }
            float f14 = this.f7291a;
            if (f14 < 0.0f) {
                this.f7291a = f14 + 20.0f;
            } else {
                this.f7291a = f14 - 20.0f;
            }
            this.f7293c.f5077c.sendEmptyMessage(1000);
            return;
        }
        this.f7293c.a();
        this.f7293c.f5077c.sendEmptyMessage(2000);
    }
}
