package com.google.android.gms.internal.cast;

import android.animation.ObjectAnimator;
import android.view.View;
import com.google.android.gms.common.util.PlatformVersion;

final class zzaa implements View.OnClickListener {
    final /* synthetic */ zzad zza;

    public zzaa(zzad zzad) {
        this.zza = zzad;
    }

    public final void onClick(View view) {
        if (PlatformVersion.isAtLeastJellyBean()) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f});
            ofFloat.setDuration(400).addListener(new zzz(this));
            ofFloat.start();
            return;
        }
        zzad.zza(this.zza);
    }
}
