package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.zzas;

public final class zzad extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    private Activity zzb;
    private int zzc;
    private boolean zzd;
    private IntroductoryOverlay.OnOverlayDismissedListener zze;
    private final zzac zzf;

    public zzad(IntroductoryOverlay.Builder builder, AttributeSet attributeSet, int i10) {
        super(builder.zzc(), (AttributeSet) null, i10);
        this.zzb = builder.zzc();
        this.zza = builder.zzh();
        this.zze = builder.zze();
        TypedArray obtainStyledAttributes = this.zzb.getTheme().obtainStyledAttributes((AttributeSet) null, R.styleable.CastIntroOverlay, i10, R.style.CastIntroOverlay);
        if (builder.zzd() != null) {
            Rect rect = new Rect();
            builder.zzd().getGlobalVisibleRect(rect);
            zzac zzac = new zzac((zzab) null);
            this.zzf = zzac;
            zzac.zza = rect.centerX();
            zzac.zzb = rect.centerY();
            PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAlpha(0);
            paint.setXfermode(porterDuffXfermode);
            paint.setAntiAlias(true);
            zzac.zzc = paint;
            float zza2 = builder.zza();
            zzac.zzd = zza2;
            if (zza2 == 0.0f) {
                zzac.zzd = obtainStyledAttributes.getDimension(R.styleable.CastIntroOverlay_castFocusRadius, 0.0f);
            }
        } else {
            this.zzf = null;
        }
        LayoutInflater.from(this.zzb).inflate(R.layout.cast_intro_overlay, this);
        int zzb2 = builder.zzb();
        this.zzc = zzb2;
        if (zzb2 == 0) {
            this.zzc = obtainStyledAttributes.getColor(R.styleable.CastIntroOverlay_castBackgroundColor, Color.argb(0, 0, 0, 0));
        }
        TextView textView = (TextView) findViewById(R.id.textTitle);
        if (!TextUtils.isEmpty(builder.zzg())) {
            textView.setText(builder.zzg());
            int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastIntroOverlay_castTitleTextAppearance, 0);
            if (resourceId != 0) {
                textView.setTextAppearance(this.zzb, resourceId);
            }
        }
        String zzf2 = builder.zzf();
        zzf2 = TextUtils.isEmpty(zzf2) ? obtainStyledAttributes.getString(R.styleable.CastIntroOverlay_castButtonText) : zzf2;
        int color = obtainStyledAttributes.getColor(R.styleable.CastIntroOverlay_castButtonBackgroundColor, Color.argb(0, 0, 0, 0));
        Button button = (Button) findViewById(R.id.button);
        button.setText(zzf2);
        button.getBackground().setColorFilter(color, PorterDuff.Mode.MULTIPLY);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.CastIntroOverlay_castButtonTextAppearance, 0);
        if (resourceId2 != 0) {
            button.setTextAppearance(this.zzb, resourceId2);
        }
        button.setOnClickListener(new zzaa(this));
        obtainStyledAttributes.recycle();
        setFitsSystemWindows(true);
    }

    public static /* bridge */ /* synthetic */ void zza(zzad zzad) {
        zzas.zza(zzad.zzb);
        IntroductoryOverlay.OnOverlayDismissedListener onOverlayDismissedListener = zzad.zze;
        if (onOverlayDismissedListener != null) {
            onOverlayDismissedListener.onOverlayDismissed();
            zzad.zze = null;
        }
        Activity activity = zzad.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(zzad);
            zzad.zzb = null;
        }
        zzad.zze = null;
    }

    public final void dispatchDraw(Canvas canvas) {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap);
        canvas2.drawColor(this.zzc);
        zzac zzac = this.zzf;
        if (zzac != null) {
            canvas2.drawCircle((float) zzac.zza, (float) zzac.zzb, zzac.zzd, zzac.zzc);
        }
        canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
        createBitmap.recycle();
        super.dispatchDraw(canvas);
    }

    public final void onDetachedFromWindow() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        super.onDetachedFromWindow();
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public final void remove() {
        Activity activity = this.zzb;
        if (activity != null) {
            ((ViewGroup) activity.getWindow().getDecorView()).removeView(this);
            this.zzb = null;
        }
        this.zze = null;
    }

    public final void show() {
        Activity activity = this.zzb;
        if (activity == null || zzy.zzf(activity)) {
            return;
        }
        if (this.zza && zzas.zzb(this.zzb)) {
            this.zzb = null;
            this.zze = null;
        } else if (!this.zzd) {
            this.zzd = true;
            ((ViewGroup) this.zzb.getWindow().getDecorView()).addView(this);
        }
    }
}
