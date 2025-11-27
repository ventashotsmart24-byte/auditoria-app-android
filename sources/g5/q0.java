package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import t9.i;

public final class q0 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f17045a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17046b;

    /* renamed from: c  reason: collision with root package name */
    public b f17047c;

    /* renamed from: d  reason: collision with root package name */
    public int f17048d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17049a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.g(view, "itemView");
            AutoUtils.autoSize(view);
            setIsRecyclable(false);
            View findViewById = view.findViewById(R.id.mTextSortName);
            i.f(findViewById, "itemView.findViewById(R.id.mTextSortName)");
            this.f17049a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f17049a;
        }
    }

    public interface b {
        void a(String str, int i10);
    }

    public q0(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "data");
        this.f17045a = context;
        this.f17046b = arrayList;
    }

    public static final void d(q0 q0Var, int i10, View view) {
        i.g(q0Var, "this$0");
        view.setSelected(true);
        b bVar = q0Var.f17047c;
        if (bVar != null) {
            Object obj = q0Var.f17046b.get(i10);
            i.f(obj, "mData[position]");
            bVar.a((String) obj, i10);
        }
    }

    public final String b() {
        Object obj = this.f17046b.get(this.f17048d);
        i.f(obj, "mData[mClickedPosition]");
        return (String) obj;
    }

    /* renamed from: c */
    public void onBindViewHolder(a aVar, int i10) {
        i.g(aVar, "holder");
        aVar.itemView.setSelected(false);
        if (i10 == 0) {
            aVar.b().setText(this.f17045a.getResources().getString(R.string.today));
        } else {
            Object obj = this.f17046b.get(i10);
            i.f(obj, "mData[position]");
            String substring = ((String) obj).substring(5);
            i.f(substring, "this as java.lang.String).substring(startIndex)");
            aVar.b().setText(s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, (Object) null));
        }
        if (i10 == this.f17048d) {
            aVar.itemView.setSelected(true);
        }
        aVar.itemView.setOnClickListener(new p0(this, i10));
    }

    /* renamed from: e */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17045a).inflate(R.layout.adapter_live_sort_vertical, viewGroup, false);
        i.f(inflate, "view");
        return new a(inflate);
    }

    public final void f(int i10) {
        this.f17048d = i10;
        notifyDataSetChanged();
    }

    public final void g(b bVar) {
        i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17047c = bVar;
    }

    public int getItemCount() {
        return this.f17046b.size();
    }

    public long getItemId(int i10) {
        return (long) i10;
    }
}
