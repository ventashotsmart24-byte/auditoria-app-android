package com.hpplay.glide.request.target;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;

public class SquaringDrawable extends GlideDrawable {
    private boolean mutated;
    private State state;
    private GlideDrawable wrapped;

    public static class State extends Drawable.ConstantState {
        /* access modifiers changed from: private */
        public final int side;
        /* access modifiers changed from: private */
        public final Drawable.ConstantState wrapped;

        public State(State state) {
            this(state.wrapped, state.side);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return newDrawable((Resources) null);
        }

        public State(Drawable.ConstantState constantState, int i10) {
            this.wrapped = constantState;
            this.side = i10;
        }

        public Drawable newDrawable(Resources resources) {
            return new SquaringDrawable(this, (GlideDrawable) null, resources);
        }
    }

    public SquaringDrawable(GlideDrawable glideDrawable, int i10) {
        this(new State(glideDrawable.getConstantState(), i10), glideDrawable, (Resources) null);
    }

    public void clearColorFilter() {
        this.wrapped.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        this.wrapped.draw(canvas);
    }

    public int getAlpha() {
        return this.wrapped.getAlpha();
    }

    public Drawable.Callback getCallback() {
        return this.wrapped.getCallback();
    }

    public int getChangingConfigurations() {
        return this.wrapped.getChangingConfigurations();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public Drawable getCurrent() {
        return this.wrapped.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.state.side;
    }

    public int getIntrinsicWidth() {
        return this.state.side;
    }

    public int getMinimumHeight() {
        return this.wrapped.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.wrapped.getMinimumWidth();
    }

    public int getOpacity() {
        return this.wrapped.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.wrapped.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.wrapped.invalidateSelf();
    }

    public boolean isAnimated() {
        return this.wrapped.isAnimated();
    }

    public boolean isRunning() {
        return this.wrapped.isRunning();
    }

    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.wrapped = (GlideDrawable) this.wrapped.mutate();
            this.state = new State(this.state);
            this.mutated = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long j10) {
        super.scheduleSelf(runnable, j10);
        this.wrapped.scheduleSelf(runnable, j10);
    }

    public void setAlpha(int i10) {
        this.wrapped.setAlpha(i10);
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        super.setBounds(i10, i11, i12, i13);
        this.wrapped.setBounds(i10, i11, i12, i13);
    }

    public void setChangingConfigurations(int i10) {
        this.wrapped.setChangingConfigurations(i10);
    }

    public void setColorFilter(int i10, PorterDuff.Mode mode) {
        this.wrapped.setColorFilter(i10, mode);
    }

    public void setDither(boolean z10) {
        this.wrapped.setDither(z10);
    }

    public void setFilterBitmap(boolean z10) {
        this.wrapped.setFilterBitmap(z10);
    }

    public void setLoopCount(int i10) {
        this.wrapped.setLoopCount(i10);
    }

    public boolean setVisible(boolean z10, boolean z11) {
        return this.wrapped.setVisible(z10, z11);
    }

    public void start() {
        this.wrapped.start();
    }

    public void stop() {
        this.wrapped.stop();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.wrapped.unscheduleSelf(runnable);
    }

    public SquaringDrawable(State state2, GlideDrawable glideDrawable, Resources resources) {
        this.state = state2;
        if (glideDrawable != null) {
            this.wrapped = glideDrawable;
        } else if (resources != null) {
            this.wrapped = (GlideDrawable) state2.wrapped.newDrawable(resources);
        } else {
            this.wrapped = (GlideDrawable) state2.wrapped.newDrawable();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.wrapped.setColorFilter(colorFilter);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.wrapped.setBounds(rect);
    }
}
