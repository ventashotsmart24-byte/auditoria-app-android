package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.g;
import com.msandroid.mobile.R;
import com.titan.cast.bean.Device;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.List;
import t9.i;
import t9.w;

public final class t extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17111a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17112b;

    /* renamed from: c  reason: collision with root package name */
    public a f17113c;

    public interface a {
        void a(Device device, int i10);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoRelativeLayout f17114a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17115b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17116c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17117d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mLayoutDevice);
            i.f(findViewById, "itemView.findViewById(R.id.mLayoutDevice)");
            this.f17114a = (AutoRelativeLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvDeviceName);
            i.f(findViewById2, "itemView.findViewById(R.id.mTvDeviceName)");
            this.f17115b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTvLastTime);
            i.f(findViewById3, "itemView.findViewById(R.id.mTvLastTime)");
            this.f17116c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvConnectLoad);
            i.f(findViewById4, "itemView.findViewById(R.id.mIvConnectLoad)");
            this.f17117d = (ImageView) findViewById4;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f17115b;
        }

        public final TextView c() {
            return this.f17116c;
        }
    }

    public t(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "serviceInfoList");
        this.f17111a = context;
        this.f17112b = arrayList;
    }

    public static final void d(t tVar, w wVar, int i10, View view) {
        i.g(tVar, "this$0");
        i.g(wVar, "$serviceInfo");
        a aVar = tVar.f17113c;
        if (aVar != null) {
            aVar.a((Device) wVar.f19600a, i10);
        }
    }

    public final void b(List list) {
        i.g(list, "serviceInfoList");
        this.f17112b.clear();
        this.f17112b.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: c */
    public void onBindViewHolder(b bVar, int i10) {
        i.g(bVar, "holder");
        w wVar = new w();
        Object obj = this.f17112b.get(i10);
        i.f(obj, "serviceInfoList[position]");
        wVar.f19600a = obj;
        b0.U(this, "CastDevice serviceInfo: " + wVar.f19600a);
        bVar.b().setText(((Device) wVar.f19600a).getFriendly_name());
        if (g.f12519a.k((Device) wVar.f19600a)) {
            bVar.c().setVisibility(0);
        } else {
            bVar.c().setVisibility(8);
        }
        bVar.b().setOnClickListener(new s(this, wVar, i10));
    }

    /* renamed from: e */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17111a).inflate(R.layout.adapter_cast_device_item, viewGroup, false);
        i.f(inflate, "view");
        return new b(inflate);
    }

    public final void f(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17113c = aVar;
    }

    public int getItemCount() {
        return this.f17112b.size();
    }
}
