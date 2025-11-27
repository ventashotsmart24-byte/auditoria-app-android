package k2;

import com.bigkoo.pickerview.lib.WheelView;
import java.util.TimerTask;

public final class c extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public int f7295a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    public int f7296b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f7297c;

    /* renamed from: d  reason: collision with root package name */
    public final WheelView f7298d;

    public c(WheelView wheelView, int i10) {
        this.f7298d = wheelView;
        this.f7297c = i10;
    }

    public final void run() {
        if (this.f7295a == Integer.MAX_VALUE) {
            this.f7295a = this.f7297c;
        }
        int i10 = this.f7295a;
        int i11 = (int) (((float) i10) * 0.1f);
        this.f7296b = i11;
        if (i11 == 0) {
            if (i10 < 0) {
                this.f7296b = -1;
            } else {
                this.f7296b = 1;
            }
        }
        if (Math.abs(i10) <= 1) {
            this.f7298d.a();
            this.f7298d.f5077c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f7298d;
        wheelView.f5095u += (float) this.f7296b;
        if (!wheelView.f5094t) {
            float f10 = wheelView.f5088n;
            float f11 = ((float) (-wheelView.f5096v)) * f10;
            WheelView wheelView2 = this.f7298d;
            float itemsCount = ((float) ((wheelView.getItemsCount() - 1) - wheelView2.f5096v)) * f10;
            float f12 = wheelView2.f5095u;
            if (f12 <= f11 || f12 >= itemsCount) {
                wheelView2.f5095u = f12 - ((float) this.f7296b);
                wheelView2.a();
                this.f7298d.f5077c.sendEmptyMessage(3000);
                return;
            }
        }
        this.f7298d.f5077c.sendEmptyMessage(1000);
        this.f7295a -= this.f7296b;
    }
}
