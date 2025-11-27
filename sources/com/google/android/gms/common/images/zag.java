package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

public abstract class zag {
    final zad zaa;
    protected int zab = 0;

    public zag(Uri uri, int i10) {
        this.zaa = new zad(uri);
        this.zab = i10;
    }

    public abstract void zaa(Drawable drawable, boolean z10, boolean z11, boolean z12);

    public final void zab(Context context, zam zam, boolean z10) {
        Drawable drawable;
        int i10 = this.zab;
        if (i10 != 0) {
            drawable = context.getResources().getDrawable(i10);
        } else {
            drawable = null;
        }
        zaa(drawable, z10, false, false);
    }

    public final void zac(Context context, Bitmap bitmap, boolean z10) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
