package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.shortvideo.TikTokView;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import h9.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelvePoster;
import mobile.com.requestframe.utils.response.ShortAssetData;
import s9.l;
import t9.i;
import t9.j;
import t9.z;

public final class v3 extends androidx.viewpager.widget.a {

    /* renamed from: a  reason: collision with root package name */
    public List f17145a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17146b = v3.class.getClass().getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f17147c = new ArrayList();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f17148a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f17149b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17150c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f17151d;

        /* renamed from: e  reason: collision with root package name */
        public TikTokView f17152e;

        /* renamed from: f  reason: collision with root package name */
        public AutoLinearLayout f17153f;

        /* renamed from: g  reason: collision with root package name */
        public AutoFrameLayout f17154g;

        public a(View view) {
            i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTiktokView);
            i.f(findViewById, "itemView.findViewById(R.id.mTiktokView)");
            TikTokView tikTokView = (TikTokView) findViewById;
            this.f17152e = tikTokView;
            View findViewById2 = tikTokView.findViewById(R.id.mTvTitle);
            i.f(findViewById2, "mTikTokView.findViewById(R.id.mTvTitle)");
            this.f17149b = (TextView) findViewById2;
            View findViewById3 = this.f17152e.findViewById(R.id.mTvAuthor);
            i.f(findViewById3, "mTikTokView.findViewById(R.id.mTvAuthor)");
            this.f17150c = (TextView) findViewById3;
            View findViewById4 = this.f17152e.findViewById(R.id.mIvThumb);
            i.f(findViewById4, "mTikTokView.findViewById(R.id.mIvThumb)");
            this.f17151d = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mLayoutFullVideo);
            i.f(findViewById5, "itemView.findViewById(R.id.mLayoutFullVideo)");
            this.f17153f = (AutoLinearLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.mContainer);
            i.f(findViewById6, "itemView.findViewById(R.id.mContainer)");
            this.f17154g = (AutoFrameLayout) findViewById6;
            view.setTag(this);
        }

        public final TextView a() {
            return this.f17150c;
        }

        public final AutoLinearLayout b() {
            return this.f17153f;
        }

        public final int c() {
            return this.f17148a;
        }

        public final ImageView d() {
            return this.f17151d;
        }

        public final TextView e() {
            return this.f17149b;
        }

        public final void f(int i10) {
            this.f17148a = i10;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f17155a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f17156b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context, a aVar) {
            super(1);
            this.f17155a = context;
            this.f17156b = aVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context context = this.f17155a;
            i.f(context, f.X);
            eVar.b(context, shelvePoster.getFileUrl(), this.f17156b.d(), 0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f17157a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(1);
            this.f17157a = aVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f17157a.d().setImageResource(0);
        }
    }

    public v3(List list) {
        i.g(list, "mVideoBeans");
        this.f17145a = list;
    }

    public static final void d(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void f(Context context, ShortAssetData shortAssetData, View view) {
        i.g(shortAssetData, "$item");
        i1.J(context, shortAssetData.getName());
        d dVar = d.f10697a;
        String o10 = dVar.o(shortAssetData.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.t((f5.c) context, shortAssetData.getType(), "", shortAssetData.getResourceId(), EnterType.HOME, shortAssetData.getAlias(), false, false, 0, "short/detail", o10, 224, (Object) null);
    }

    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        i.g(viewGroup, "container");
        i.g(obj, "object");
        View view = (View) obj;
        viewGroup.removeView(view);
        ShortAssetData shortAssetData = (ShortAssetData) this.f17145a.get(i10);
        b0.U(this, "取消预加载...position:" + i10);
        this.f17147c.add(view);
    }

    public int getCount() {
        return this.f17145a.size();
    }

    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        View view;
        a aVar;
        i.g(viewGroup, "container");
        Context context = viewGroup.getContext();
        int i11 = 0;
        if (this.f17147c.size() > 0) {
            view = (View) this.f17147c.get(0);
            this.f17147c.remove(0);
        } else {
            view = null;
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_tik_tok, viewGroup, false);
            aVar = new a(view);
        } else {
            Object tag = view.getTag();
            i.e(tag, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.TiktokAdapter.ViewHolder");
            aVar = (a) tag;
        }
        ShortAssetData shortAssetData = (ShortAssetData) this.f17145a.get(i10);
        b0.U(this, "开始预加载...position:" + i10);
        d dVar = d.f10697a;
        dVar.l(shortAssetData.getPosterList(), dVar.g()).subscribe(new s3(new b(context, aVar)), new t3(new c(aVar)));
        b0.d(aVar.e(), shortAssetData.getAlias(), shortAssetData.getName());
        TextView a10 = aVar.a();
        z zVar = z.f19601a;
        String string = context.getString(R.string.short_video_update_by);
        i.f(string, "context.getString(R.string.short_video_update_by)");
        boolean z10 = true;
        String format = String.format(string, Arrays.copyOf(new Object[]{shortAssetData.getDirector()}, 1));
        i.f(format, "format(format, *args)");
        a10.setText(format);
        AutoLinearLayout b10 = aVar.b();
        String resourceId = shortAssetData.getResourceId();
        if (!(resourceId == null || resourceId.length() == 0)) {
            z10 = false;
        }
        if (z10) {
            i11 = 8;
        }
        b10.setVisibility(i11);
        aVar.b().setOnClickListener(new u3(context, shortAssetData));
        aVar.f(i10);
        viewGroup.addView(view);
        i.d(view);
        return view;
    }

    public boolean isViewFromObject(View view, Object obj) {
        i.g(view, "view");
        i.g(obj, "any");
        return i.b(view, obj);
    }
}
