package n6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ProgramSeason;
import t9.i;

public final class g extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f19019a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f19020b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f19021c;

    /* renamed from: d  reason: collision with root package name */
    public a f19022d;

    public interface a {
        void a(int i10, ProgramSeason programSeason);
    }

    public final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoFrameLayout f19023a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f19025c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, View view) {
            super(view);
            i.g(view, "itemView");
            this.f19025c = gVar;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f19023a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvSeason);
            i.f(findViewById2, "itemView.findViewById(R.id.mTvSeason)");
            this.f19024b = (TextView) findViewById2;
        }

        public final AutoFrameLayout b() {
            return this.f19023a;
        }

        public final TextView c() {
            return this.f19024b;
        }
    }

    public g(Context context) {
        i.g(context, "mContext");
        this.f19019a = context;
    }

    public static final void c(g gVar, int i10, View view) {
        i.g(gVar, "this$0");
        gVar.g(i10);
        a aVar = gVar.f19022d;
        if (aVar != null) {
            Object obj = gVar.f19020b.get(i10);
            i.f(obj, "mData[position]");
            aVar.a(i10, (ProgramSeason) obj);
        }
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i10) {
        i.g(bVar, "holder");
        Object obj = this.f19020b.get(i10);
        i.f(obj, "mData[position]");
        boolean z10 = true;
        bVar.c().setText(this.f19019a.getString(R.string.vod_season, new Object[]{Integer.valueOf(((ProgramSeason) obj).getSeasonNumber())}));
        TextView c10 = bVar.c();
        if (this.f19021c != i10) {
            z10 = false;
        }
        c10.setSelected(z10);
        bVar.b().setOnClickListener(new f(this, i10));
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f19019a).inflate(R.layout.item_season_pop_window, viewGroup, false);
        i.f(inflate, "view");
        return new b(this, inflate);
    }

    public final void e(ArrayList arrayList) {
        i.g(arrayList, "data");
        this.f19020b.clear();
        this.f19020b.addAll(arrayList);
    }

    public final void f(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f19022d = aVar;
    }

    public final void g(int i10) {
        this.f19021c = i10;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f19020b.size();
    }
}
