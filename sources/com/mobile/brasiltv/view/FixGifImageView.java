package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.q;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.umeng.analytics.pro.f;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.g;
import t9.i;

public final class FixGifImageView extends q {
    public Map<Integer, View> _$_findViewCache;
    private FixGifStateDrawable fixDrawable;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
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

    public void drawableStateChanged() {
        super.drawableStateChanged();
        if (isSelected()) {
            FixGifStateDrawable fixGifStateDrawable = this.fixDrawable;
            if (fixGifStateDrawable != null) {
                i.d(fixGifStateDrawable);
                super.setImageDrawable(fixGifStateDrawable.getSelectDrawable());
                FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
                i.d(fixGifStateDrawable2);
                if (fixGifStateDrawable2.getNormalDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
                    i.d(fixGifStateDrawable3);
                    Drawable normalDrawable = fixGifStateDrawable3.getNormalDrawable();
                    i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) normalDrawable).stop();
                }
                FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
                i.d(fixGifStateDrawable4);
                if (fixGifStateDrawable4.getSelectDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable5 = this.fixDrawable;
                    i.d(fixGifStateDrawable5);
                    Drawable selectDrawable = fixGifStateDrawable5.getSelectDrawable();
                    i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) selectDrawable).start();
                    return;
                }
                return;
            }
            return;
        }
        FixGifStateDrawable fixGifStateDrawable6 = this.fixDrawable;
        if (fixGifStateDrawable6 != null) {
            i.d(fixGifStateDrawable6);
            super.setImageDrawable(fixGifStateDrawable6.getNormalDrawable());
            FixGifStateDrawable fixGifStateDrawable7 = this.fixDrawable;
            i.d(fixGifStateDrawable7);
            if (fixGifStateDrawable7.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable8 = this.fixDrawable;
                i.d(fixGifStateDrawable8);
                Drawable normalDrawable2 = fixGifStateDrawable8.getNormalDrawable();
                i.e(normalDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable2).start();
            }
            FixGifStateDrawable fixGifStateDrawable9 = this.fixDrawable;
            i.d(fixGifStateDrawable9);
            if (fixGifStateDrawable9.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable10 = this.fixDrawable;
                i.d(fixGifStateDrawable10);
                Drawable selectDrawable2 = fixGifStateDrawable10.getSelectDrawable();
                i.e(selectDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable2).stop();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        FixGifStateDrawable fixGifStateDrawable = this.fixDrawable;
        if (fixGifStateDrawable != null) {
            i.d(fixGifStateDrawable);
            if (fixGifStateDrawable.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
                i.d(fixGifStateDrawable2);
                Drawable normalDrawable = fixGifStateDrawable2.getNormalDrawable();
                i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable).stop();
            }
            FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
            i.d(fixGifStateDrawable3);
            if (fixGifStateDrawable3.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
                i.d(fixGifStateDrawable4);
                Drawable selectDrawable = fixGifStateDrawable4.getSelectDrawable();
                i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable).stop();
            }
        }
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable instanceof FixGifStateDrawable) {
            FixGifStateDrawable fixGifStateDrawable = (FixGifStateDrawable) drawable;
            this.fixDrawable = fixGifStateDrawable;
            if (isSelected()) {
                super.setImageDrawable(fixGifStateDrawable.getSelectDrawable());
                FixGifStateDrawable fixGifStateDrawable2 = this.fixDrawable;
                i.d(fixGifStateDrawable2);
                if (fixGifStateDrawable2.getNormalDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable3 = this.fixDrawable;
                    i.d(fixGifStateDrawable3);
                    Drawable normalDrawable = fixGifStateDrawable3.getNormalDrawable();
                    i.e(normalDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) normalDrawable).stop();
                }
                FixGifStateDrawable fixGifStateDrawable4 = this.fixDrawable;
                i.d(fixGifStateDrawable4);
                if (fixGifStateDrawable4.getSelectDrawable() instanceof GifDrawable) {
                    FixGifStateDrawable fixGifStateDrawable5 = this.fixDrawable;
                    i.d(fixGifStateDrawable5);
                    Drawable selectDrawable = fixGifStateDrawable5.getSelectDrawable();
                    i.e(selectDrawable, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                    ((GifDrawable) selectDrawable).start();
                    return;
                }
                return;
            }
            super.setImageDrawable(fixGifStateDrawable.getNormalDrawable());
            FixGifStateDrawable fixGifStateDrawable6 = this.fixDrawable;
            i.d(fixGifStateDrawable6);
            if (fixGifStateDrawable6.getNormalDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable7 = this.fixDrawable;
                i.d(fixGifStateDrawable7);
                Drawable normalDrawable2 = fixGifStateDrawable7.getNormalDrawable();
                i.e(normalDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) normalDrawable2).start();
            }
            FixGifStateDrawable fixGifStateDrawable8 = this.fixDrawable;
            i.d(fixGifStateDrawable8);
            if (fixGifStateDrawable8.getSelectDrawable() instanceof GifDrawable) {
                FixGifStateDrawable fixGifStateDrawable9 = this.fixDrawable;
                i.d(fixGifStateDrawable9);
                Drawable selectDrawable2 = fixGifStateDrawable9.getSelectDrawable();
                i.e(selectDrawable2, "null cannot be cast to non-null type com.bumptech.glide.load.resource.gif.GifDrawable");
                ((GifDrawable) selectDrawable2).stop();
                return;
            }
            return;
        }
        super.setImageDrawable(drawable);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FixGifImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FixGifImageView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
