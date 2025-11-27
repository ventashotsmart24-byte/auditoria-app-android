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
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import t9.i;
import t9.z;

public final class r2 extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public final int f17089a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17090b = 1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f17091c;

    /* renamed from: d  reason: collision with root package name */
    public Context f17092d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f17093e;

    /* renamed from: f  reason: collision with root package name */
    public a f17094f;

    public interface a {
        void a(Album album, int i10);

        void b(int i10, int i11);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public TextView f17095a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTvTimeLabel);
            i.f(findViewById, "itemView.findViewById(R.id.mTvTimeLabel)");
            this.f17095a = (TextView) findViewById;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f17095a;
        }
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public ImageView f17096a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17097b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17098c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17099d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mImagePoster);
            i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f17096a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTextTime);
            i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f17097b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTextProgramName);
            i.e(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.f17098c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSingleCb);
            i.f(findViewById4, "itemView.findViewById(R.id.mIvSingleCb)");
            this.f17099d = (ImageView) findViewById4;
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f17096a;
        }

        public final ImageView c() {
            return this.f17099d;
        }

        public final TextView d() {
            return this.f17098c;
        }

        public final TextView e() {
            return this.f17097b;
        }
    }

    public r2(Context context, ArrayList arrayList) {
        i.g(context, f.X);
        i.g(arrayList, "data");
        this.f17092d = context;
        this.f17093e = arrayList;
    }

    public static final void f(r2 r2Var, Album album, c cVar, int i10, View view) {
        i.g(r2Var, "this$0");
        i.g(album, "$album");
        i.g(cVar, "$holder");
        if (r2Var.f17091c) {
            if (album.isSelect()) {
                cVar.c().setImageResource(R.drawable.icon_no_select);
            } else {
                cVar.c().setImageResource(R.drawable.icon_select);
            }
            album.setSelect(!album.isSelect());
            r2Var.c();
            return;
        }
        a aVar = r2Var.f17094f;
        if (aVar != null) {
            aVar.a(album, i10);
        }
    }

    public final void b(List list) {
        i.g(list, "data");
        this.f17093e = e((ArrayList) list);
        this.f17091c = false;
        notifyDataSetChanged();
    }

    public final void c() {
        Iterator it = this.f17093e.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Album) {
                i11++;
                if (((Album) next).isSelect()) {
                    i10++;
                }
            }
        }
        a aVar = this.f17094f;
        if (aVar != null) {
            aVar.b(i10, i11);
        }
    }

    public final ArrayList d() {
        return this.f17093e;
    }

    public final ArrayList e(ArrayList arrayList) {
        String f10 = y6.a.f(7);
        String f11 = y6.a.f(90);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (it.hasNext()) {
            Album album = (Album) it.next();
            String str = "";
            if (!z10) {
                String saveTime = album.getSaveTime();
                if (saveTime != null) {
                    str = saveTime;
                }
                if (f10.compareTo(str) <= 0) {
                    String string = this.f17092d.getResources().getString(R.string.history_last_week);
                    i.e(string, "null cannot be cast to non-null type java.lang.Object");
                    arrayList2.add(string);
                    z10 = true;
                }
            } else if (!z11) {
                String saveTime2 = album.getSaveTime();
                if (saveTime2 == null) {
                    saveTime2 = str;
                }
                if (f10.compareTo(saveTime2) > 0) {
                    String saveTime3 = album.getSaveTime();
                    if (saveTime3 != null) {
                        str = saveTime3;
                    }
                    if (f11.compareTo(str) <= 0) {
                        String string2 = this.f17092d.getResources().getString(R.string.history_last_three_months);
                        i.e(string2, "null cannot be cast to non-null type java.lang.Object");
                        arrayList2.add(string2);
                        z11 = true;
                    }
                }
            }
            i.e(album, "null cannot be cast to non-null type java.lang.Object");
            arrayList2.add(album);
            if (z11) {
                break;
            }
        }
        return arrayList2;
    }

    public final void g(boolean z10) {
        Iterator it = this.f17093e.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Album) {
                ((Album) next).setSelect(z10);
            }
        }
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f17093e.size();
    }

    public int getItemViewType(int i10) {
        if (this.f17093e.get(i10) instanceof Album) {
            return this.f17090b;
        }
        return this.f17089a;
    }

    public final void h(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17094f = aVar;
    }

    public final void i(boolean z10) {
        this.f17091c = z10;
        if (!z10) {
            g(false);
        } else {
            notifyDataSetChanged();
        }
    }

    public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
        i.g(d0Var, "viewHolder");
        if (!(this.f17093e.get(i10) instanceof Album)) {
            Object obj = this.f17093e.get(i10);
            i.e(obj, "null cannot be cast to non-null type kotlin.String");
            ((b) d0Var).b().setText((String) obj);
            return;
        }
        Object obj2 = this.f17093e.get(i10);
        i.e(obj2, "null cannot be cast to non-null type com.mobile.brasiltv.db.Album");
        Album album = (Album) obj2;
        c cVar = (c) d0Var;
        e.f10706a.b(this.f17092d, album.getPosterUrl(), cVar.b(), R.drawable.special_cloumn_img_placeholder);
        cVar.d().setText(b0.e(album.getAlias(), album.getName()));
        if (i.b(album.getType(), "0")) {
            TextView e10 = cVar.e();
            z zVar = z.f19601a;
            String format = String.format(b0.A(this.f17092d, R.string.watched_episodes), Arrays.copyOf(new Object[]{Integer.valueOf(album.getSeriesNumber())}, 1));
            i.f(format, "format(format, *args)");
            e10.setText(format);
            cVar.e().setVisibility(0);
        } else if (i.b(album.getType(), "1")) {
            long j10 = (long) 1000;
            long j11 = (long) 60;
            if ((album.getPlayTime() / j10) / j11 < 1) {
                cVar.e().setText(b0.A(this.f17092d, R.string.less_than_minutes));
            } else {
                TextView e11 = cVar.e();
                z zVar2 = z.f19601a;
                String format2 = String.format(b0.A(this.f17092d, R.string.watched_minutes), Arrays.copyOf(new Object[]{Long.valueOf((album.getPlayTime() / j10) / j11)}, 1));
                i.f(format2, "format(format, *args)");
                e11.setText(format2);
            }
            cVar.e().setVisibility(0);
        }
        if (this.f17091c) {
            cVar.c().setVisibility(0);
            if (album.isSelect()) {
                cVar.c().setImageResource(R.drawable.icon_select);
            } else {
                cVar.c().setImageResource(R.drawable.icon_no_select);
            }
        } else {
            cVar.c().setVisibility(8);
        }
        cVar.itemView.setOnClickListener(new q2(this, album, cVar, i10));
    }

    public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(this.f17092d);
        if (i10 == this.f17089a) {
            View inflate = from.inflate(R.layout.adapter_record_label_item, viewGroup, false);
            AutoUtils.autoSize(inflate);
            i.f(inflate, "view");
            return new b(inflate);
        }
        View inflate2 = from.inflate(R.layout.adapter_record_item, viewGroup, false);
        AutoUtils.autoSize(inflate2);
        i.f(inflate2, "view");
        return new c(inflate2);
    }
}
