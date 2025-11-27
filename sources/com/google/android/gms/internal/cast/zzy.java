package com.google.android.gms.internal.cast;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.RelativeLayout;
import com.google.android.gms.cast.framework.IntroductoryOverlay;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.internal.featurehighlight.HelpTextView;
import com.google.android.gms.cast.framework.internal.featurehighlight.zzh;
import com.google.android.gms.cast.framework.zzas;

public final class zzy extends RelativeLayout implements IntroductoryOverlay {
    private final boolean zza;
    /* access modifiers changed from: private */
    public Activity zzb;
    /* access modifiers changed from: private */
    public IntroductoryOverlay.OnOverlayDismissedListener zzc;
    private View zzd;
    /* access modifiers changed from: private */
    public zzh zze;
    private String zzf;
    /* access modifiers changed from: private */
    public boolean zzg;
    private int zzh;

    public zzy(IntroductoryOverlay.Builder builder) {
        super(builder.zzc());
        this.zzb = builder.zzc();
        this.zza = builder.zzh();
        this.zzc = builder.zze();
        this.zzd = builder.zzd();
        this.zzf = builder.zzg();
        this.zzh = builder.zzb();
    }

    public static boolean zzf(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        if (accessibilityManager == null || !accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        removeAllViews();
        this.zzb = null;
        this.zzc = null;
        this.zzd = null;
        this.zze = null;
        this.zzf = null;
        this.zzh = 0;
        this.zzg = false;
    }

    public final void remove() {
        if (this.zzg) {
            ((ViewGroup) this.zzb.getWindow().getDecorView()).removeView(this);
            zzg();
        }
    }

    public final void show() {
        Activity activity = this.zzb;
        if (activity != null && this.zzd != null && !this.zzg && !zzf(activity)) {
            if (!this.zza || !zzas.zzb(this.zzb)) {
                zzh zzh2 = new zzh(this.zzb);
                this.zze = zzh2;
                int i10 = this.zzh;
                if (i10 != 0) {
                    zzh2.zzl(i10);
                }
                addView(this.zze);
                HelpTextView helpTextView = (HelpTextView) this.zzb.getLayoutInflater().inflate(R.layout.cast_help_text, this.zze, false);
                helpTextView.setText(this.zzf, (CharSequence) null);
                this.zze.zzp(helpTextView);
                this.zze.zzk(this.zzd, (View) null, true, new zzx(this));
                this.zzg = true;
                ((ViewGroup) this.zzb.getWindow().getDecorView()).addView(this);
                this.zze.zzn((Runnable) null);
                return;
            }
            zzg();
        }
    }
}
