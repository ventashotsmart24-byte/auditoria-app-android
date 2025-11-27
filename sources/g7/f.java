package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;
import t9.i;

public final class f extends b {

    /* renamed from: b  reason: collision with root package name */
    public final BaseQuickAdapter f17219b;

    /* renamed from: c  reason: collision with root package name */
    public final View f17220c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f17221d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f17222e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f17223f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f17224g;

    /* renamed from: h  reason: collision with root package name */
    public View.OnClickListener f17225h;

    /* renamed from: i  reason: collision with root package name */
    public final FrameLayout f17226i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Activity activity, String str, BaseQuickAdapter baseQuickAdapter) {
        super(activity);
        i.g(activity, "activity");
        i.g(str, "mTitleStr");
        i.g(baseQuickAdapter, "mAdapter");
        this.f17219b = baseQuickAdapter;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_bottom_coupon, (ViewGroup) null);
        i.f(inflate, "from(activity).inflate(R…t.pop_bottom_coupon,null)");
        this.f17220c = inflate;
        View findViewById = inflate.findViewById(R.id.tvTitle);
        i.f(findViewById, "view.findViewById(R.id.tvTitle)");
        TextView textView = (TextView) findViewById;
        this.f17221d = textView;
        View findViewById2 = inflate.findViewById(R.id.ivClose);
        i.f(findViewById2, "view.findViewById(R.id.ivClose)");
        ImageView imageView = (ImageView) findViewById2;
        this.f17222e = imageView;
        View findViewById3 = inflate.findViewById(R.id.rvList);
        i.f(findViewById3, "view.findViewById(R.id.rvList)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.f17223f = recyclerView;
        View findViewById4 = inflate.findViewById(R.id.btnTitle);
        i.f(findViewById4, "view.findViewById(R.id.btnTitle)");
        this.f17224g = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.retrieveAllLoadingLayout);
        i.f(findViewById5, "view.findViewById(R.id.retrieveAllLoadingLayout)");
        this.f17226i = (FrameLayout) findViewById5;
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        textView.setText(str);
        imageView.setOnClickListener(new e(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(baseQuickAdapter);
    }

    public static final void g(f fVar, View view) {
        i.g(fVar, "this$0");
        fVar.dismiss();
    }

    public final void h() {
        this.f17226i.setVisibility(8);
    }

    public final void i(View.OnClickListener onClickListener) {
        this.f17225h = onClickListener;
        this.f17224g.setOnClickListener(onClickListener);
    }

    public final void j() {
        ViewGroup.LayoutParams layoutParams = this.f17221d.getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(14);
        this.f17221d.setLayoutParams(layoutParams2);
    }

    public final void k(String str) {
        i.g(str, "btnTitleStr");
        View findViewById = this.f17220c.findViewById(R.id.btnTitleLayout);
        i.f(findViewById, "view.findViewById(R.id.btnTitleLayout)");
        ((RelativeLayout) findViewById).setVisibility(0);
        this.f17224g.setText(str);
    }

    public final void l() {
        View findViewById = this.f17220c.findViewById(R.id.line);
        i.f(findViewById, "view.findViewById(R.id.line)");
        findViewById.setVisibility(0);
    }

    public final void m() {
        View findViewById = this.f17220c.findViewById(R.id.titleLayout);
        i.f(findViewById, "view.findViewById(R.id.titleLayout)");
        ViewGroup.LayoutParams layoutParams = this.f17226i.getLayoutParams();
        layoutParams.height = getContentView().getMeasuredHeight() - ((RelativeLayout) findViewById).getMeasuredHeight();
        this.f17226i.setLayoutParams(layoutParams);
        this.f17226i.setVisibility(0);
    }
}
