package com.mobile.brasiltv.view.login;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.mobile.brasiltv.utils.j;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.umeng.analytics.pro.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.a;
import t9.g;
import t9.i;

public final class ScrollableImageView extends View {
    private final String COLOR_FILTER;
    private final long DURATING_SCROLL_ANIM;
    private final int STATE_ANIMING;
    private final int STATE_ANIM_DESTROY;
    private final int STATE_ANIM_PAUSE;
    private final int STATE_ANIM_START;
    private final int STATE_NORMAL;
    public Map<Integer, View> _$_findViewCache;
    private final Paint mBitmapPaint;
    private final Rect mBottomDrawRect;
    private final Rect mBottomViewRect;
    private int mImageHeight;
    private int mImageWidth;
    private Bitmap mLongPicBitmap;
    /* access modifiers changed from: private */
    public a mMeasureListener;
    private ValueAnimator mScrollAnim;
    private boolean mSetPicResource;
    private int mState;
    private final Rect mTopDrawRect;
    private final Rect mTopViewRect;
    private int mViewHeight;
    private int mViewWidth;
    private BitmapFactory.Options options;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
        i.g(context, f.X);
    }

    private final void registerScheduleScroll() {
        if (this.mViewWidth == 0 || this.mViewHeight == 0) {
            this.mMeasureListener = new ScrollableImageView$registerScheduleScroll$1(this);
        } else {
            scheduleScroll();
        }
    }

    /* access modifiers changed from: private */
    public final void scheduleScroll() {
        int i10 = (int) (((((float) this.mImageWidth) * 1.0f) * ((float) this.mViewHeight)) / ((float) this.mViewWidth));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.mImageHeight - 1});
        this.mScrollAnim = ofInt;
        if (ofInt != null) {
            ofInt.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator2 = this.mScrollAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(this.DURATING_SCROLL_ANIM);
        }
        ValueAnimator valueAnimator3 = this.mScrollAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new u(i10, this));
        }
        ValueAnimator valueAnimator4 = this.mScrollAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        this.mState = this.STATE_ANIM_START;
    }

    /* access modifiers changed from: private */
    public static final void scheduleScroll$lambda$0(int i10, ScrollableImageView scrollableImageView, ValueAnimator valueAnimator) {
        i.g(scrollableImageView, "this$0");
        i.g(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        i.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        int i11 = intValue + i10;
        int i12 = scrollableImageView.mImageHeight;
        if (i11 <= i12) {
            scrollableImageView.mTopDrawRect.set(0, intValue, scrollableImageView.mImageWidth, i11);
            scrollableImageView.mTopViewRect.set(0, 0, scrollableImageView.mViewWidth, scrollableImageView.mViewHeight);
            scrollableImageView.mBottomDrawRect.setEmpty();
            scrollableImageView.mBottomViewRect.setEmpty();
        } else {
            scrollableImageView.mTopDrawRect.set(0, intValue, scrollableImageView.mImageWidth, i12);
            int i13 = (int) (((((float) (scrollableImageView.mImageHeight - intValue)) * 1.0f) / ((float) i10)) * ((float) scrollableImageView.mViewHeight));
            scrollableImageView.mTopViewRect.set(0, 0, scrollableImageView.mViewWidth, i13);
            scrollableImageView.mBottomDrawRect.set(0, 0, scrollableImageView.mImageWidth, i11 - scrollableImageView.mImageHeight);
            scrollableImageView.mBottomViewRect.set(0, i13, scrollableImageView.mViewWidth, scrollableImageView.mViewHeight);
        }
        scrollableImageView.mState = scrollableImageView.STATE_ANIMING;
        scrollableImageView.invalidate();
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

    public final void destroy() {
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mScrollAnim = null;
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mSetPicResource = false;
        Bitmap bitmap = this.mLongPicBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mState = this.STATE_NORMAL;
    }

    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        i.g(canvas, "canvas");
        super.onDraw(canvas);
        int i10 = this.mState;
        if (i10 == this.STATE_NORMAL || i10 == this.STATE_ANIM_START || i10 == this.STATE_ANIM_DESTROY) {
            canvas.drawColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        } else if ((i10 == this.STATE_ANIMING || i10 == this.STATE_ANIM_PAUSE) && (bitmap = this.mLongPicBitmap) != null) {
            canvas.drawBitmap(bitmap, this.mTopDrawRect, this.mTopViewRect, this.mBitmapPaint);
            if (!this.mBottomDrawRect.isEmpty() && !this.mBottomViewRect.isEmpty()) {
                canvas.drawBitmap(bitmap, this.mBottomDrawRect, this.mBottomViewRect, this.mBitmapPaint);
            }
        }
    }

    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mViewWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mViewHeight = measuredHeight;
        this.mTopViewRect.set(0, 0, this.mViewWidth, measuredHeight);
        this.mBottomViewRect.setEmpty();
        a aVar = this.mMeasureListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void pauseScroll() {
        if (this.mSetPicResource) {
            int i10 = this.mState;
            if (i10 == this.STATE_ANIM_START || i10 == this.STATE_ANIMING) {
                ValueAnimator valueAnimator = this.mScrollAnim;
                if (valueAnimator != null) {
                    valueAnimator.pause();
                }
                this.mState = this.STATE_ANIM_PAUSE;
            }
        }
    }

    public final void resumeScroll() {
        int i10;
        if (this.mSetPicResource && (i10 = this.mState) != this.STATE_ANIM_START && i10 != this.STATE_ANIMING) {
            if (i10 == this.STATE_NORMAL || i10 == this.STATE_ANIM_DESTROY) {
                registerScheduleScroll();
                return;
            }
            ValueAnimator valueAnimator = this.mScrollAnim;
            if (valueAnimator != null) {
                valueAnimator.resume();
            }
        }
    }

    public final void setImageInputStream(InputStream inputStream) {
        i.g(inputStream, "imageIs");
        try {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            Bitmap bitmap = null;
            BitmapFactory.decodeStream(inputStream, (Rect) null, options2);
            this.mImageWidth = options2.outWidth;
            this.mImageHeight = options2.outHeight;
            BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
            Rect rect = new Rect(0, 0, this.mImageWidth, this.mImageHeight);
            if (newInstance != null) {
                bitmap = newInstance.decodeRegion(rect, this.options);
            }
            this.mLongPicBitmap = bitmap;
            this.mSetPicResource = true;
        } catch (IOException e10) {
            e10.printStackTrace();
        } finally {
            j.a(inputStream);
        }
    }

    public final void startScroll() {
        if (this.mSetPicResource) {
            registerScheduleScroll();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
        i.g(context, f.X);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.g(context, f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.STATE_ANIM_START = 1;
        this.STATE_ANIMING = 2;
        this.STATE_ANIM_PAUSE = 3;
        this.STATE_ANIM_DESTROY = 4;
        this.DURATING_SCROLL_ANIM = 40000;
        this.COLOR_FILTER = "#80121418";
        this.mTopViewRect = new Rect();
        this.mBottomViewRect = new Rect();
        this.mTopDrawRect = new Rect();
        this.mBottomDrawRect = new Rect();
        Paint paint = new Paint(1);
        this.mBitmapPaint = paint;
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        this.options = options2;
        this.mState = this.STATE_NORMAL;
        options2.inPreferredConfig = Bitmap.Config.RGB_565;
        paint.setFlags(6);
        paint.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#80121418"), PorterDuff.Mode.SRC_OVER));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollableImageView(Context context, AttributeSet attributeSet, int i10, int i11, g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
