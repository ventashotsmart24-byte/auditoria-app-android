package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import t9.i;

public final class c extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16865a;

    /* renamed from: b  reason: collision with root package name */
    public a f16866b;

    /* renamed from: c  reason: collision with root package name */
    public String f16867c = "";

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList f16868d = new ArrayList();

    public interface a {
        void onClick(String str);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public TextView f16869a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mEmailInfo);
            i.f(findViewById, "itemView.findViewById(R.id.mEmailInfo)");
            this.f16869a = (TextView) findViewById;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f16869a;
        }
    }

    public c(Context context) {
        this.f16865a = context;
    }

    public static final void c(c cVar, b bVar, View view) {
        i.g(cVar, "this$0");
        i.g(bVar, "$holder");
        a aVar = cVar.f16866b;
        if (aVar != null) {
            aVar.onClick(bVar.b().getText().toString());
        }
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i10) {
        i.g(bVar, "holder");
        if (this.f16865a != null) {
            TextView b10 = bVar.b();
            b10.setText(this.f16867c + ((String) this.f16868d.get(i10)));
            bVar.itemView.setOnClickListener(new b(this, bVar));
        }
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f16865a).inflate(R.layout.item_email, viewGroup, false);
        i.f(inflate, "view");
        return new b(inflate);
    }

    public final void e(ArrayList arrayList) {
        i.g(arrayList, "emailSuffixs");
        this.f16868d.clear();
        this.f16868d.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void f(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f16866b = aVar;
    }

    public final void g(String str) {
        i.g(str, "prefix");
        this.f16867c = str;
    }

    public int getItemCount() {
        return this.f16868d.size();
    }
}
