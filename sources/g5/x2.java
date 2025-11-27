package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.utils.f0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;
import t9.u;

public final class x2 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f17171a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17172b;

    /* renamed from: c  reason: collision with root package name */
    public a f17173c;

    public interface a {
        void a(Channel channel);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17174a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTextHistory);
            i.e(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f17174a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f17174a;
        }
    }

    public x2(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "data");
        this.f17171a = context;
        this.f17172b = arrayList;
    }

    public static final void c(x2 x2Var, u uVar, View view) {
        i.g(x2Var, "this$0");
        i.g(uVar, "$reverseIndex");
        a aVar = x2Var.f17173c;
        if (aVar != null && aVar != null) {
            Object obj = x2Var.f17172b.get(uVar.f19598a);
            i.f(obj, "mData[reverseIndex]");
            aVar.a((Channel) obj);
        }
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i10) {
        i.g(bVar, "holder");
        u uVar = new u();
        uVar.f19598a = (this.f17172b.size() - i10) - 1;
        if (f0.b() || TextUtils.isEmpty(((Channel) this.f17172b.get(uVar.f19598a)).getAlias())) {
            bVar.b().setText(((Channel) this.f17172b.get(uVar.f19598a)).getName());
        } else {
            bVar.b().setText(((Channel) this.f17172b.get(uVar.f19598a)).getAlias());
        }
        bVar.itemView.setOnClickListener(new w2(this, uVar));
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17171a).inflate(R.layout.adapter_search_history_live, viewGroup, false);
        i.f(inflate, "view");
        return new b(inflate);
    }

    public final void e(ArrayList arrayList) {
        i.g(arrayList, "data");
        this.f17172b = arrayList;
        notifyDataSetChanged();
    }

    public final void f(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17173c = aVar;
    }

    public int getItemCount() {
        return this.f17172b.size();
    }
}
