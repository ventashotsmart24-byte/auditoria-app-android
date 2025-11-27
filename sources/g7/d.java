package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;
import t9.i;

public final class d extends b {

    /* renamed from: b  reason: collision with root package name */
    public final String f17216b;

    /* renamed from: c  reason: collision with root package name */
    public final BaseQuickAdapter f17217c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Activity activity, String str, BaseQuickAdapter baseQuickAdapter) {
        super(activity);
        i.g(activity, "activity");
        i.g(str, "mTitleStr");
        i.g(baseQuickAdapter, "mAdapter");
        this.f17216b = str;
        this.f17217c = baseQuickAdapter;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_bottom, (ViewGroup) null);
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rvList);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(str);
        ((ImageView) inflate.findViewById(R.id.ivClose)).setOnClickListener(new c(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(baseQuickAdapter);
    }

    public static final void g(d dVar, View view) {
        i.g(dVar, "this$0");
        dVar.dismiss();
    }
}
