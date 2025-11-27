package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

final class zzr extends zzp<Bundle> {
    public zzr(int i10, int i11, Bundle bundle) {
        super(i10, 1, bundle);
    }

    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zzd(bundle2);
    }

    public final boolean zzb() {
        return false;
    }
}
