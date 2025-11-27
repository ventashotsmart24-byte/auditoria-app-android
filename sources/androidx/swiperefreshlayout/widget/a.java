package androidx.swiperefreshlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import b0.c1;

public class a extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    public Animation.AnimationListener f3107a;

    /* renamed from: b  reason: collision with root package name */
    public int f3108b;

    /* renamed from: androidx.swiperefreshlayout.widget.a$a  reason: collision with other inner class name */
    public class C0051a extends OvalShape {

        /* renamed from: a  reason: collision with root package name */
        public RadialGradient f3109a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f3110b = new Paint();

        public C0051a(int i10) {
            a.this.f3108b = i10;
            a((int) rect().width());
        }

        public final void a(int i10) {
            float f10 = (float) (i10 / 2);
            RadialGradient radialGradient = new RadialGradient(f10, f10, (float) a.this.f3108b, new int[]{1023410176, 0}, (float[]) null, Shader.TileMode.CLAMP);
            this.f3109a = radialGradient;
            this.f3110b.setShader(radialGradient);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = a.this.getWidth() / 2;
            float f10 = (float) width;
            float height = (float) (a.this.getHeight() / 2);
            canvas.drawCircle(f10, height, f10, this.f3110b);
            canvas.drawCircle(f10, height, (float) (width - a.this.f3108b), paint);
        }

        public void onResize(float f10, float f11) {
            super.onResize(f10, f11);
            a((int) f10);
        }
    }

    public a(Context context, int i10) {
        super(context);
        ShapeDrawable shapeDrawable;
        float f10 = getContext().getResources().getDisplayMetrics().density;
        int i11 = (int) (1.75f * f10);
        int i12 = (int) (0.0f * f10);
        this.f3108b = (int) (3.5f * f10);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            c1.s0(this, f10 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new C0051a(this.f3108b));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer((float) this.f3108b, (float) i12, (float) i11, 503316480);
            int i13 = this.f3108b;
            setPadding(i13, i13, i13, i13);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i10);
        c1.o0(this, shapeDrawable);
    }

    public final boolean a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return true;
        }
        return false;
    }

    public void b(Animation.AnimationListener animationListener) {
        this.f3107a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f3107a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f3107a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (!a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f3108b * 2), getMeasuredHeight() + (this.f3108b * 2));
        }
    }

    public void setBackgroundColor(int i10) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i10);
        }
    }
}
