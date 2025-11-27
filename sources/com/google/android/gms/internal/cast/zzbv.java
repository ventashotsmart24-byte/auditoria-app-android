package com.google.android.gms.internal.cast;

import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.R;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.uicontroller.zza;
import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

public final class zzbv extends zzbp {
    private final RelativeLayout zza;
    private final TextView zzb;
    private final CastSeekBar zzc;
    private final zza zzd;

    public zzbv(RelativeLayout relativeLayout, CastSeekBar castSeekBar, zza zza2) {
        this.zza = relativeLayout;
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tooltip);
        this.zzb = textView;
        this.zzc = castSeekBar;
        this.zzd = zza2;
        TypedArray obtainStyledAttributes = textView.getContext().obtainStyledAttributes((AttributeSet) null, R.styleable.CastExpandedController, R.attr.castExpandedControllerStyle, R.style.CastExpandedController);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.CastExpandedController_castSeekBarTooltipBackgroundColor, 0);
        obtainStyledAttributes.recycle();
        textView.getBackground().setColorFilter(textView.getContext().getResources().getColor(resourceId), PorterDuff.Mode.SRC_IN);
    }

    public final void onMediaStatusUpdated() {
        zzd();
    }

    public final void onSessionConnected(CastSession castSession) {
        super.onSessionConnected(castSession);
        zzd();
    }

    public final void onSessionEnded() {
        super.onSessionEnded();
        zzd();
    }

    public final void zza(boolean z10) {
        super.zza(z10);
        zzd();
    }

    public final void zzb(long j10) {
        zzd();
    }

    public final void zzd() {
        RemoteMediaClient remoteMediaClient = getRemoteMediaClient();
        if (remoteMediaClient == null || !remoteMediaClient.hasMediaSession() || zzc()) {
            this.zza.setVisibility(8);
            return;
        }
        this.zza.setVisibility(0);
        TextView textView = this.zzb;
        zza zza2 = this.zzd;
        textView.setText(zza2.zzl(((long) this.zzc.getProgress()) + zza2.zze()));
        int measuredWidth = (this.zzc.getMeasuredWidth() - this.zzc.getPaddingLeft()) - this.zzc.getPaddingRight();
        this.zzb.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredWidth2 = this.zzb.getMeasuredWidth();
        double progress = (double) this.zzc.getProgress();
        double maxProgress = (double) this.zzc.getMaxProgress();
        Double.isNaN(progress);
        Double.isNaN(maxProgress);
        double d10 = progress / maxProgress;
        double d11 = (double) measuredWidth;
        Double.isNaN(d11);
        int min = Math.min(Math.max(0, ((int) (d10 * d11)) - (measuredWidth2 / 2)), measuredWidth - measuredWidth2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.zzb.getLayoutParams();
        layoutParams.leftMargin = min;
        this.zzb.setLayoutParams(layoutParams);
    }
}
