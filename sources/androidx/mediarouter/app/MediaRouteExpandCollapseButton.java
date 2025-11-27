package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.n;
import androidx.mediarouter.R$drawable;
import androidx.mediarouter.R$string;

class MediaRouteExpandCollapseButton extends n {

    /* renamed from: a  reason: collision with root package name */
    public final AnimationDrawable f2456a;

    /* renamed from: b  reason: collision with root package name */
    public final AnimationDrawable f2457b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2458c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2459d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2460e;

    /* renamed from: f  reason: collision with root package name */
    public View.OnClickListener f2461f;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton = MediaRouteExpandCollapseButton.this;
            boolean z10 = !mediaRouteExpandCollapseButton.f2460e;
            mediaRouteExpandCollapseButton.f2460e = z10;
            if (z10) {
                mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f2456a);
                MediaRouteExpandCollapseButton.this.f2456a.start();
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton2 = MediaRouteExpandCollapseButton.this;
                mediaRouteExpandCollapseButton2.setContentDescription(mediaRouteExpandCollapseButton2.f2459d);
            } else {
                mediaRouteExpandCollapseButton.setImageDrawable(mediaRouteExpandCollapseButton.f2457b);
                MediaRouteExpandCollapseButton.this.f2457b.start();
                MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton3 = MediaRouteExpandCollapseButton.this;
                mediaRouteExpandCollapseButton3.setContentDescription(mediaRouteExpandCollapseButton3.f2458c);
            }
            View.OnClickListener onClickListener = MediaRouteExpandCollapseButton.this.f2461f;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
        }
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f2461f = onClickListener;
    }

    public MediaRouteExpandCollapseButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        AnimationDrawable animationDrawable = (AnimationDrawable) p.a.getDrawable(context, R$drawable.mr_group_expand);
        this.f2456a = animationDrawable;
        AnimationDrawable animationDrawable2 = (AnimationDrawable) p.a.getDrawable(context, R$drawable.mr_group_collapse);
        this.f2457b = animationDrawable2;
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i.f(context, i10), PorterDuff.Mode.SRC_IN);
        animationDrawable.setColorFilter(porterDuffColorFilter);
        animationDrawable2.setColorFilter(porterDuffColorFilter);
        String string = context.getString(R$string.mr_controller_expand_group);
        this.f2458c = string;
        this.f2459d = context.getString(R$string.mr_controller_collapse_group);
        setImageDrawable(animationDrawable.getFrame(0));
        setContentDescription(string);
        super.setOnClickListener(new a());
    }
}
