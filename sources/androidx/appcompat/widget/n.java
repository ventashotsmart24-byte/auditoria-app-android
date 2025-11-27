package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.R$attr;
import androidx.core.widget.h0;
import b0.g0;

public class n extends ImageButton implements g0, h0 {
    private final f mBackgroundTintHelper;
    private final p mImageHelper;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.imageButtonStyle);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.b();
        }
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        p pVar = this.mImageHelper;
        if (pVar != null) {
            return pVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        p pVar = this.mImageHelper;
        if (pVar != null) {
            return pVar.d();
        }
        return null;
    }

    public boolean hasOverlappingRendering() {
        if (!this.mImageHelper.e() || !super.hasOverlappingRendering()) {
            return false;
        }
        return true;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.f(drawable);
        }
    }

    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.g(i10);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.b();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.b();
        }
    }

    public void setImageResource(int i10) {
        this.mImageHelper.g(i10);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.mBackgroundTintHelper;
        if (fVar != null) {
            fVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        p pVar = this.mImageHelper;
        if (pVar != null) {
            pVar.i(mode);
        }
    }

    public n(Context context, AttributeSet attributeSet, int i10) {
        super(o2.b(context), attributeSet, i10);
        f fVar = new f(this);
        this.mBackgroundTintHelper = fVar;
        fVar.e(attributeSet, i10);
        p pVar = new p(this);
        this.mImageHelper = pVar;
        pVar.f(attributeSet, i10);
    }
}
