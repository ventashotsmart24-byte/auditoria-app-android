package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.i;

public final class n0 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f17009a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17010b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f17011c;

    /* renamed from: d  reason: collision with root package name */
    public int f17012d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17013a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.g(view, "itemView");
            AutoUtils.autoSize(view);
            setIsRecyclable(false);
            View findViewById = view.findViewById(R.id.mTextSortName);
            i.f(findViewById, "itemView.findViewById(R.id.mTextSortName)");
            this.f17013a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f17013a;
        }
    }

    public n0(Context context, ArrayList arrayList, ArrayList arrayList2) {
        i.g(context, f.X);
        i.g(arrayList, "data");
        this.f17009a = context;
        this.f17010b = arrayList;
        this.f17011c = arrayList2;
    }

    public static final void e(n0 n0Var, int i10, View view) {
        i.g(n0Var, "this$0");
        view.setSelected(true);
        n0Var.getClass();
    }

    public final ChildColumnList b() {
        ArrayList arrayList = this.f17011c;
        if (arrayList != null) {
            return (ChildColumnList) arrayList.get(this.f17012d);
        }
        return null;
    }

    public final void c(int i10, String str) {
        i.g(str, "sort");
        if (!this.f17010b.contains(str)) {
            if (this.f17010b.size() >= i10) {
                this.f17010b.add(i10, str);
            } else {
                this.f17010b.add(str);
            }
            notifyDataSetChanged();
        }
    }

    /* renamed from: d */
    public void onBindViewHolder(a aVar, int i10) {
        i.g(aVar, "holder");
        aVar.itemView.setSelected(false);
        Object obj = this.f17010b.get(i10);
        i.f(obj, "mData[position]");
        if (!t.o((CharSequence) obj, Operator.Operation.DIVISION, false, 2, (Object) null)) {
            aVar.b().setText((CharSequence) this.f17010b.get(i10));
            if (!b0.G(this.f17011c)) {
                ArrayList arrayList = this.f17011c;
                i.d(arrayList);
                if (i.b(((ChildColumnList) arrayList.get(i10)).getFree(), "1")) {
                    aVar.b().setTextColor(this.f17009a.getResources().getColor(R.color.color_ffbf00));
                }
            }
            aVar.b().setTextColor(this.f17009a.getResources().getColor(R.color.color_ffffff));
        } else if (i10 == 0) {
            aVar.b().setText(this.f17009a.getResources().getString(R.string.today));
        } else {
            Object obj2 = this.f17010b.get(i10);
            i.f(obj2, "mData[position]");
            String substring = ((String) obj2).substring(5);
            i.f(substring, "this as java.lang.String).substring(startIndex)");
            aVar.b().setText(s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, (Object) null));
        }
        if (i10 == this.f17012d) {
            aVar.itemView.setSelected(true);
        }
        aVar.itemView.setOnClickListener(new m0(this, i10));
    }

    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17009a).inflate(R.layout.adapter_live_sort_vertical, viewGroup, false);
        i.f(inflate, "view");
        return new a(inflate);
    }

    public final void g(String str) {
        i.g(str, "sort");
        if (this.f17010b.contains(str)) {
            this.f17010b.remove(str);
            notifyDataSetChanged();
        }
    }

    public int getItemCount() {
        return this.f17010b.size();
    }

    public long getItemId(int i10) {
        return (long) i10;
    }

    public final void h(int i10) {
        this.f17012d = i10;
        notifyDataSetChanged();
    }
}
