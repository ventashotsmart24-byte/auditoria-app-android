package g5;

import a7.e;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.List;
import t9.i;

public final class z0 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17194a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f17195b;

    /* renamed from: c  reason: collision with root package name */
    public a f17196c;

    public interface a {
        void a(Album album, int i10);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17197a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17198b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mIvPoster);
            i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f17197a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvProgramName);
            i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f17198b = (TextView) findViewById2;
            AutoUtils.autoSize(view);
        }
    }

    public z0(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "mData");
        this.f17194a = context;
        this.f17195b = arrayList;
    }

    public static final void c(z0 z0Var, Album album, int i10, View view) {
        i.g(z0Var, "this$0");
        i.g(album, "$album");
        a aVar = z0Var.f17196c;
        if (aVar != null) {
            aVar.a(album, i10);
        }
    }

    public final void b(List list) {
        i.g(list, "data");
        this.f17195b.clear();
        this.f17195b.addAll(list);
        notifyDataSetChanged();
    }

    public final void d(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17196c = aVar;
    }

    public int getItemCount() {
        int size = this.f17195b.size();
        if (size > 10) {
            return 10;
        }
        return size;
    }

    public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
        i.g(d0Var, "holder");
        Object obj = this.f17195b.get(i10);
        i.f(obj, "mData[position]");
        Album album = (Album) obj;
        e eVar = e.f10706a;
        Context context = this.f17194a;
        String posterUrl = album.getPosterUrl();
        ImageView imageView = (ImageView) d0Var.itemView.findViewById(R$id.mIvPoster);
        i.f(imageView, "holder.itemView.mIvPoster");
        eVar.b(context, posterUrl, imageView, R.drawable.special_cloumn_img_placeholder);
        ((TextView) d0Var.itemView.findViewById(R$id.mTvProgramName)).setText(b0.e(album.getAlias(), album.getName()));
        d0Var.itemView.setOnClickListener(new y0(this, album, i10));
    }

    public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17194a).inflate(R.layout.adapter_mine_home_record_item, viewGroup, false);
        i.f(inflate, "view");
        return new b(inflate);
    }
}
