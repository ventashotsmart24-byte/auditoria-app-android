package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.umeng.message.proguard.bx;

public final class cm extends cn {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f15627c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f15628d;

    public cm(Context context, cl clVar) {
        super(context, clVar);
    }

    public final void a(Bitmap bitmap) {
        this.f15628d = bitmap;
    }

    public final void b() {
        ImageView imageView = new ImageView(this.f15629a);
        this.f15627c = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f15627c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    public final void c() {
        boolean z10;
        int i10;
        int i11;
        ImageView imageView = this.f15627c;
        if (imageView != null) {
            imageView.setImageBitmap(this.f15628d);
            if (bt.a(this.f15630b.f15625a) == bx.c.INTERSTITIAL && this.f15628d.getHeight() != 0) {
                DisplayMetrics displayMetrics = this.f15629a.getResources().getDisplayMetrics();
                if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                float width = (((float) this.f15628d.getWidth()) * 1.0f) / ((float) this.f15628d.getHeight());
                int a10 = ed.a(72.0f);
                int a11 = ed.a(144.0f);
                if (z10) {
                    i11 = displayMetrics.widthPixels - a10;
                    i10 = (int) (((float) i11) / width);
                    int i12 = displayMetrics.heightPixels;
                    if (i10 > i12 - a11) {
                        i10 = i12 - a11;
                        i11 = (int) (((float) i10) * width);
                    }
                } else {
                    i11 = displayMetrics.heightPixels - a11;
                    int i13 = (int) (((float) i11) * width);
                    int i14 = displayMetrics.widthPixels;
                    if (i13 > i14 - a10) {
                        int i15 = i14 - a10;
                        i10 = i11;
                        i11 = i15;
                    } else {
                        i10 = i11;
                        if (i11 < i13) {
                            i11 = i13;
                        }
                    }
                }
                ViewGroup.LayoutParams layoutParams = this.f15627c.getLayoutParams();
                layoutParams.width = i11;
                layoutParams.height = i10;
                this.f15627c.setLayoutParams(layoutParams);
            }
        }
    }

    public final void d() {
        try {
            Bitmap bitmap = this.f15628d;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.f15628d.recycle();
            }
        } catch (Throwable unused) {
        }
    }

    public final View a() {
        return this.f15627c;
    }
}
