package com.google.android.gms.cast.framework.media.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import java.util.ArrayList;
import java.util.List;

public class CastSeekBar extends View {
    public zze zza;
    public zzc zzb;
    @RecentlyNullable
    public List<zzb> zzc;
    public zzd zzd;
    private boolean zze;
    private Integer zzf;
    private final float zzg;
    private final float zzh;
    private final float zzi;
    private final float zzj;
    private final float zzk;
    private final Paint zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private int[] zzq;
    private Point zzr;
    private Runnable zzs;

    public CastSeekBar(@RecentlyNonNull Context context) {
        this(context, (AttributeSet) null);
    }

    private final int zzf(int i10) {
        double d10 = (double) i10;
        double measuredWidth = (double) ((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        Double.isNaN(d10);
        Double.isNaN(measuredWidth);
        double d11 = d10 / measuredWidth;
        double d12 = (double) this.zza.zzb;
        Double.isNaN(d12);
        return (int) (d11 * d12);
    }

    private final void zzg(Canvas canvas, int i10, int i11, int i12, int i13, int i14) {
        this.zzl.setColor(i14);
        float f10 = (float) i12;
        float f11 = (float) i13;
        float f12 = this.zzi;
        canvas.drawRect((((float) i10) / f10) * f11, -f12, (((float) i11) / f10) * f11, f12, this.zzl);
    }

    /* access modifiers changed from: private */
    public final void zzh(int i10) {
        zze zze2 = this.zza;
        if (zze2.zzf) {
            this.zzf = Integer.valueOf(CastUtils.zza(i10, zze2.zzd, zze2.zze));
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
            }
            Runnable runnable = this.zzs;
            if (runnable == null) {
                this.zzs = new zza(this);
            } else {
                removeCallbacks(runnable);
            }
            postDelayed(this.zzs, 200);
            postInvalidate();
        }
    }

    /* access modifiers changed from: private */
    public final void zzi() {
        this.zze = true;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzb(this);
        }
    }

    /* access modifiers changed from: private */
    public final void zzj() {
        this.zze = false;
        zzd zzd2 = this.zzd;
        if (zzd2 != null) {
            zzd2.zzc(this);
        }
    }

    public int getMaxProgress() {
        return this.zza.zzb;
    }

    public int getProgress() {
        Integer num = this.zzf;
        if (num != null) {
            return num.intValue();
        }
        return this.zza.zza;
    }

    public void onDetachedFromWindow() {
        Runnable runnable = this.zzs;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        super.onDetachedFromWindow();
    }

    public void onDraw(@RecentlyNonNull Canvas canvas) {
        int i10;
        float f10;
        float f11;
        Canvas canvas2 = canvas;
        int save = canvas.save();
        canvas2.translate((float) getPaddingLeft(), (float) getPaddingTop());
        zzc zzc2 = this.zzb;
        if (zzc2 == null) {
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = getMeasuredHeight();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int progress = getProgress();
            int save2 = canvas.save();
            canvas2.translate(0.0f, (float) (((measuredHeight - paddingTop) - paddingBottom) / 2));
            zze zze2 = this.zza;
            if (zze2.zzf) {
                int i11 = zze2.zzd;
                if (i11 > 0) {
                    zzg(canvas, 0, i11, zze2.zzb, measuredWidth, this.zzo);
                }
                zze zze3 = this.zza;
                int i12 = zze3.zzd;
                if (progress > i12) {
                    zzg(canvas, i12, progress, zze3.zzb, measuredWidth, this.zzm);
                }
                zze zze4 = this.zza;
                int i13 = zze4.zze;
                if (i13 > progress) {
                    zzg(canvas, progress, i13, zze4.zzb, measuredWidth, this.zzn);
                }
                zze zze5 = this.zza;
                int i14 = zze5.zzb;
                int i15 = zze5.zze;
                if (i14 > i15) {
                    zzg(canvas, i15, i14, i14, measuredWidth, this.zzo);
                }
            } else {
                int max = Math.max(zze2.zzc, 0);
                if (max > 0) {
                    zzg(canvas, 0, max, this.zza.zzb, measuredWidth, this.zzo);
                }
                if (progress > max) {
                    zzg(canvas, max, progress, this.zza.zzb, measuredWidth, this.zzm);
                }
                int i16 = this.zza.zzb;
                if (i16 > progress) {
                    zzg(canvas, progress, i16, i16, measuredWidth, this.zzo);
                }
            }
            canvas2.restoreToCount(save2);
            List<zzb> list = this.zzc;
            if (list != null && !list.isEmpty()) {
                this.zzl.setColor(this.zzp);
                int measuredWidth2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                int measuredHeight2 = getMeasuredHeight();
                int paddingTop2 = getPaddingTop();
                int paddingBottom2 = getPaddingBottom();
                int save3 = canvas.save();
                canvas2.translate(0.0f, (float) (((measuredHeight2 - paddingTop2) - paddingBottom2) / 2));
                for (zzb next : list) {
                    if (next != null) {
                        int min = Math.min(next.zza, this.zza.zzb);
                        if (next.zzc) {
                            i10 = next.zzb;
                        } else {
                            i10 = 1;
                        }
                        float f12 = (float) measuredWidth2;
                        float f13 = (float) this.zza.zzb;
                        float f14 = (((float) min) * f12) / f13;
                        float f15 = (((float) (min + i10)) * f12) / f13;
                        float f16 = this.zzk;
                        if (f15 - f14 < f16) {
                            f15 = f14 + f16;
                        }
                        if (f15 > f12) {
                            f10 = f12;
                        } else {
                            f10 = f15;
                        }
                        if (f10 - f14 < f16) {
                            f11 = f10 - f16;
                        } else {
                            f11 = f14;
                        }
                        float f17 = this.zzi;
                        canvas.drawRect(f11, -f17, f10, f17, this.zzl);
                    }
                }
                canvas2.restoreToCount(save3);
            }
            if (isEnabled() && this.zza.zzf) {
                this.zzl.setColor(this.zzm);
                int measuredWidth3 = getMeasuredWidth();
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int measuredHeight3 = getMeasuredHeight();
                int paddingTop3 = getPaddingTop();
                int paddingBottom3 = getPaddingBottom();
                int progress2 = getProgress();
                int i17 = this.zza.zzb;
                int save4 = canvas.save();
                double d10 = (double) progress2;
                double d11 = (double) i17;
                Double.isNaN(d10);
                Double.isNaN(d11);
                double d12 = (double) ((measuredWidth3 - paddingLeft) - paddingRight);
                Double.isNaN(d12);
                canvas2.drawCircle((float) ((int) ((d10 / d11) * d12)), ((float) ((measuredHeight3 - paddingTop3) - paddingBottom3)) / 2.0f, this.zzj, this.zzl);
                canvas2.restoreToCount(save4);
            }
        } else {
            int measuredWidth4 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight4 = getMeasuredHeight();
            int paddingTop4 = getPaddingTop();
            int paddingBottom4 = getPaddingBottom();
            int save5 = canvas.save();
            canvas2.translate(0.0f, (float) (((measuredHeight4 - paddingTop4) - paddingBottom4) / 2));
            Canvas canvas3 = canvas;
            int i18 = measuredWidth4;
            zzg(canvas3, 0, zzc2.zza, zzc2.zzb, i18, this.zzp);
            int i19 = zzc2.zza;
            int i20 = zzc2.zzb;
            zzg(canvas3, i19, i20, i20, i18, this.zzo);
            canvas2.restoreToCount(save5);
        }
        canvas2.restoreToCount(save);
    }

    public synchronized void onMeasure(int i10, int i11) {
        setMeasuredDimension(View.resolveSizeAndState((int) (this.zzg + ((float) getPaddingLeft()) + ((float) getPaddingRight())), i10, 0), View.resolveSizeAndState((int) (this.zzh + ((float) getPaddingTop()) + ((float) getPaddingBottom())), i11, 0));
    }

    public boolean onTouchEvent(@RecentlyNonNull MotionEvent motionEvent) {
        if (!isEnabled() || !this.zza.zzf) {
            return false;
        }
        if (this.zzr == null) {
            this.zzr = new Point();
        }
        if (this.zzq == null) {
            this.zzq = new int[2];
        }
        getLocationOnScreen(this.zzq);
        this.zzr.set((((int) motionEvent.getRawX()) - this.zzq[0]) - getPaddingLeft(), ((int) motionEvent.getRawY()) - this.zzq[1]);
        int action = motionEvent.getAction();
        if (action == 0) {
            zzi();
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action == 1) {
            zzh(zzf(this.zzr.x));
            zzj();
            return true;
        } else if (action == 2) {
            zzh(zzf(this.zzr.x));
            return true;
        } else if (action != 3) {
            return false;
        } else {
            this.zze = false;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), true);
                this.zzd.zzc(this);
            }
            postInvalidate();
            return true;
        }
    }

    public final void zzd(@RecentlyNonNull List<zzb> list) {
        ArrayList arrayList;
        if (!Objects.equal(this.zzc, list)) {
            if (list == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(list);
            }
            this.zzc = arrayList;
            postInvalidate();
        }
    }

    public final void zze(zze zze2) {
        if (!this.zze) {
            zze zze3 = new zze();
            zze3.zza = zze2.zza;
            zze3.zzb = zze2.zzb;
            zze3.zzc = zze2.zzc;
            zze3.zzd = zze2.zzd;
            zze3.zze = zze2.zze;
            zze3.zzf = zze2.zzf;
            this.zza = zze3;
            this.zzf = null;
            zzd zzd2 = this.zzd;
            if (zzd2 != null) {
                zzd2.zza(this, getProgress(), false);
            }
            postInvalidate();
        }
    }

    public CastSeekBar(@RecentlyNonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CastSeekBar(@RecentlyNonNull Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.zzc = new ArrayList();
        setAccessibilityDelegate(new zzg(this, (zzf) null));
        Paint paint = new Paint(1);
        this.zzl = paint;
        paint.setStyle(Paint.Style.FILL);
        this.zzg = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_width);
        this.zzh = context.getResources().getDimension(R.dimen.cast_seek_bar_minimum_height);
        this.zzi = context.getResources().getDimension(R.dimen.cast_seek_bar_progress_height) / 2.0f;
        this.zzj = context.getResources().getDimension(R.dimen.cast_seek_bar_thumb_size) / 2.0f;
        this.zzk = context.getResources().getDimension(R.dimen.cast_seek_bar_ad_break_minimum_width);
        zze zze2 = new zze();
        this.zza = zze2;
        zze2.zzb = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarProgressAndThumbColor, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarSecondaryProgressColor, 0);
        int resourceId3 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarUnseekableProgressColor, 0);
        int resourceId4 = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castAdBreakMarkerColor, 0);
        this.zzm = context.getResources().getColor(resourceId);
        this.zzn = context.getResources().getColor(resourceId2);
        this.zzo = context.getResources().getColor(resourceId3);
        this.zzp = context.getResources().getColor(resourceId4);
        obtainStyledAttributes.recycle();
    }
}
