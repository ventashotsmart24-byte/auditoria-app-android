package com.bigkoo.pickerview.lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bigkoo.pickerview.R$dimen;
import com.bigkoo.pickerview.R$styleable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import k2.c;

public class WheelView extends View {
    public int A;
    public int B = 0;
    public float C = 0.0f;
    public long D = 0;
    public int E;
    public int F = 17;
    public int G = 0;
    public int H = 0;
    public float I;

    /* renamed from: a  reason: collision with root package name */
    public b f5075a;

    /* renamed from: b  reason: collision with root package name */
    public Context f5076b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f5077c;

    /* renamed from: d  reason: collision with root package name */
    public GestureDetector f5078d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f5079e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f5080f = true;

    /* renamed from: g  reason: collision with root package name */
    public ScheduledExecutorService f5081g = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: h  reason: collision with root package name */
    public ScheduledFuture f5082h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f5083i;

    /* renamed from: j  reason: collision with root package name */
    public Paint f5084j;

    /* renamed from: k  reason: collision with root package name */
    public Paint f5085k;

    /* renamed from: l  reason: collision with root package name */
    public String f5086l;

    /* renamed from: m  reason: collision with root package name */
    public int f5087m = getResources().getDimensionPixelSize(R$dimen.pickerview_textsize);

    /* renamed from: n  reason: collision with root package name */
    public float f5088n;

    /* renamed from: o  reason: collision with root package name */
    public Typeface f5089o = Typeface.MONOSPACE;

    /* renamed from: p  reason: collision with root package name */
    public int f5090p = -5723992;

    /* renamed from: q  reason: collision with root package name */
    public int f5091q = -14013910;

    /* renamed from: r  reason: collision with root package name */
    public int f5092r = -2763307;

    /* renamed from: s  reason: collision with root package name */
    public float f5093s = 1.6f;

    /* renamed from: t  reason: collision with root package name */
    public boolean f5094t;

    /* renamed from: u  reason: collision with root package name */
    public float f5095u;

    /* renamed from: v  reason: collision with root package name */
    public int f5096v;

    /* renamed from: w  reason: collision with root package name */
    public int f5097w;

    /* renamed from: x  reason: collision with root package name */
    public int f5098x = 11;

    /* renamed from: y  reason: collision with root package name */
    public int f5099y;

    /* renamed from: z  reason: collision with root package name */
    public int f5100z;

    public enum a {
        CLICK,
        FLING,
        DAGGLE
    }

    public enum b {
        FILL,
        WRAP
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10 = getResources().getDisplayMetrics().density;
        if (f10 < 1.0f) {
            this.I = 2.4f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.I = 3.6f;
        } else if (1.0f <= f10 && f10 < 2.0f) {
            this.I = 4.5f;
        } else if (2.0f <= f10 && f10 < 3.0f) {
            this.I = 6.0f;
        } else if (f10 >= 3.0f) {
            this.I = f10 * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f5074a, 0, 0);
            this.F = obtainStyledAttributes.getInt(R$styleable.pickerview_pickerview_gravity, 17);
            this.f5090p = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_textColorOut, this.f5090p);
            this.f5091q = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_textColorCenter, this.f5091q);
            this.f5092r = obtainStyledAttributes.getColor(R$styleable.pickerview_pickerview_dividerColor, this.f5092r);
            this.f5087m = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.pickerview_pickerview_textSize, this.f5087m);
            this.f5093s = obtainStyledAttributes.getFloat(R$styleable.pickerview_pickerview_lineSpacingMultiplier, this.f5093s);
            obtainStyledAttributes.recycle();
        }
        d();
        b(context);
    }

    public void a() {
        ScheduledFuture scheduledFuture = this.f5082h;
        if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
            this.f5082h.cancel(true);
            this.f5082h = null;
        }
    }

    public final void b(Context context) {
        this.f5076b = context;
        this.f5077c = new a(this);
        GestureDetector gestureDetector = new GestureDetector(context, new k2.b(this));
        this.f5078d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(false);
        this.f5094t = true;
        this.f5095u = 0.0f;
        this.f5096v = -1;
        c();
    }

    public final void c() {
        Paint paint = new Paint();
        this.f5083i = paint;
        paint.setColor(this.f5090p);
        this.f5083i.setAntiAlias(true);
        this.f5083i.setTypeface(this.f5089o);
        this.f5083i.setTextSize((float) this.f5087m);
        Paint paint2 = new Paint();
        this.f5084j = paint2;
        paint2.setColor(this.f5091q);
        this.f5084j.setAntiAlias(true);
        this.f5084j.setTextScaleX(1.1f);
        this.f5084j.setTypeface(this.f5089o);
        this.f5084j.setTextSize((float) this.f5087m);
        Paint paint3 = new Paint();
        this.f5085k = paint3;
        paint3.setColor(this.f5092r);
        this.f5085k.setAntiAlias(true);
        setLayerType(1, (Paint) null);
    }

    public final void d() {
        float f10 = this.f5093s;
        if (f10 < 1.2f) {
            this.f5093s = 1.2f;
        } else if (f10 > 2.0f) {
            this.f5093s = 2.0f;
        }
    }

    public final void e() {
    }

    public final void f() {
    }

    public final void g(float f10) {
        a();
        this.f5082h = this.f5081g.scheduleWithFixedDelay(new k2.a(this, f10), 0, 5, TimeUnit.MILLISECONDS);
    }

    public final j2.a getAdapter() {
        return null;
    }

    public final int getCurrentItem() {
        return this.f5097w;
    }

    public int getItemsCount() {
        return 0;
    }

    public void h(a aVar) {
        a();
        if (aVar == a.FLING || aVar == a.DAGGLE) {
            float f10 = this.f5095u;
            float f11 = this.f5088n;
            int i10 = (int) (((f10 % f11) + f11) % f11);
            this.B = i10;
            if (((float) i10) > f11 / 2.0f) {
                this.B = (int) (f11 - ((float) i10));
            } else {
                this.B = -i10;
            }
        }
        this.f5082h = this.f5081g.scheduleWithFixedDelay(new c(this, this.B), 0, 10, TimeUnit.MILLISECONDS);
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i10, int i11) {
        this.E = i10;
        f();
        setMeasuredDimension(this.f5100z, this.f5099y);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.f5078d.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.D = System.currentTimeMillis();
            a();
            this.C = motionEvent.getRawY();
        } else if (action == 2) {
            this.C = motionEvent.getRawY();
            this.f5095u += this.C - motionEvent.getRawY();
            if (!this.f5094t) {
                throw null;
            }
        } else if (!onTouchEvent) {
            float y10 = motionEvent.getY();
            int i10 = this.A;
            double acos = Math.acos((double) ((((float) i10) - y10) / ((float) i10)));
            double d10 = (double) this.A;
            Double.isNaN(d10);
            double d11 = acos * d10;
            float f10 = this.f5088n;
            double d12 = (double) (f10 / 2.0f);
            Double.isNaN(d12);
            double d13 = d11 + d12;
            double d14 = (double) f10;
            Double.isNaN(d14);
            this.B = (int) ((((float) (((int) (d13 / d14)) - (this.f5098x / 2))) * f10) - (((this.f5095u % f10) + f10) % f10));
            if (System.currentTimeMillis() - this.D > 120) {
                h(a.DAGGLE);
            } else {
                h(a.CLICK);
            }
        }
        invalidate();
        return true;
    }

    public final void setAdapter(j2.a aVar) {
        f();
        invalidate();
    }

    public final void setCurrentItem(int i10) {
        this.f5097w = i10;
        this.f5096v = i10;
        this.f5095u = 0.0f;
        invalidate();
    }

    public final void setCyclic(boolean z10) {
        this.f5094t = z10;
    }

    public void setDividerColor(int i10) {
        if (i10 != 0) {
            this.f5092r = i10;
            this.f5085k.setColor(i10);
        }
    }

    public void setDividerType(b bVar) {
        this.f5075a = bVar;
    }

    public void setGravity(int i10) {
        this.F = i10;
    }

    public void setIsOptions(boolean z10) {
        this.f5079e = z10;
    }

    public void setLabel(String str) {
        this.f5086l = str;
    }

    public void setLineSpacingMultiplier(float f10) {
        if (f10 != 0.0f) {
            this.f5093s = f10;
            d();
        }
    }

    public final void setOnItemSelectedListener(l2.a aVar) {
    }

    public void setTextColorCenter(int i10) {
        if (i10 != 0) {
            this.f5091q = i10;
            this.f5084j.setColor(i10);
        }
    }

    public void setTextColorOut(int i10) {
        if (i10 != 0) {
            this.f5090p = i10;
            this.f5083i.setColor(i10);
        }
    }

    public final void setTextSize(float f10) {
        if (f10 > 0.0f) {
            int i10 = (int) (this.f5076b.getResources().getDisplayMetrics().density * f10);
            this.f5087m = i10;
            this.f5083i.setTextSize((float) i10);
            this.f5084j.setTextSize((float) this.f5087m);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.f5089o = typeface;
        this.f5083i.setTypeface(typeface);
        this.f5084j.setTypeface(this.f5089o);
    }
}
