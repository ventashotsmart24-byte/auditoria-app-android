package com.umeng.message.proguard;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.umeng.message.push.R;

public final class eg extends eh {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f15896a = ((ImageView) findViewById(R.id.umeng_fi_close));

    /* renamed from: b  reason: collision with root package name */
    private ImageView f15897b = ((ImageView) findViewById(R.id.umeng_fi_img));

    /* renamed from: c  reason: collision with root package name */
    private ImageView f15898c = ((ImageView) findViewById(R.id.umeng_fi_mark));

    public eg(Context context) {
        super(context);
        View.inflate(getContext(), R.layout.umeng_fi_layout, this);
    }

    public final void setAdImage(Bitmap bitmap) {
        if (bitmap != null && bitmap.getWidth() != 0) {
            ViewGroup.LayoutParams layoutParams = this.f15897b.getLayoutParams();
            int a10 = ed.a(64.0f);
            layoutParams.width = a10;
            layoutParams.height = Math.min((a10 * bitmap.getHeight()) / bitmap.getWidth(), layoutParams.width * 2);
            this.f15897b.setLayoutParams(layoutParams);
            this.f15897b.setScaleType(ImageView.ScaleType.FIT_XY);
            this.f15897b.setImageBitmap(bitmap);
        }
    }

    public final void setAdMarkVisibility(boolean z10) {
        ImageView imageView = this.f15898c;
        if (imageView == null) {
            return;
        }
        if (z10) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public final void setCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f15896a;
        if (imageView != null) {
            imageView.setTag(onClickListener);
            this.f15896a.setOnClickListener(onClickListener);
        }
    }

    public final void setIconClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f15897b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }
}
