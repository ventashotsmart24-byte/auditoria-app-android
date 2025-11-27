package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.g;
import t9.i;
import t9.j;
import t9.w;
import t9.z;

public final class n2 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17016a;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n2 f17017a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ w f17018b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(n2 n2Var, w wVar) {
            super(1);
            this.f17017a = n2Var;
            this.f17018b = wVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context c10 = this.f17017a.f17016a;
            String fileUrl = shelvePoster.getFileUrl();
            Object obj = this.f17018b.f19600a;
            i.f(obj, "mIvPoster");
            eVar.b(c10, fileUrl, (ImageView) obj, R.drawable.special_cloumn_img_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f17019a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(w wVar) {
            super(1);
            this.f17019a = wVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f17019a.f19600a).setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public n2(Context context) {
        super(R.layout.adapter_top_ten_new_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f17016a = context;
    }

    public static final void e(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void f(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* renamed from: d */
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        String str;
        String str2;
        i.g(baseViewHolder, "holder");
        i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvCovered);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.mTvProgramName);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.mIvTs);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.mIvTop);
        w wVar = new w();
        wVar.f19600a = baseViewHolder.getView(R.id.mIvPoster);
        boolean z10 = true;
        if (i.b(shelveAsset.getType(), "0")) {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                z zVar = z.f19601a;
                String string = this.f17016a.getResources().getString(R.string.recommend_episodes_all);
                i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                str2 = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                i.f(str2, "format(format, *args)");
            } else {
                z zVar2 = z.f19601a;
                String string2 = this.f17016a.getResources().getString(R.string.recommend_episodes);
                i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                str2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                i.f(str2, "format(format, *args)");
            }
            textView.setText(str2);
            textView.setVisibility(0);
            imageView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            imageView.setVisibility(8);
        }
        i.f(textView2, "mTvProgramName");
        String alias = shelveAsset.getAlias();
        if (alias != null) {
            str = ba.t.W(alias).toString();
        } else {
            str = null;
        }
        b0.d(textView2, str, ba.t.W(shelveAsset.getName()).toString());
        String contentType = shelveAsset.getContentType();
        if (!(contentType == null || contentType.length() == 0)) {
            z10 = false;
        }
        if (z10 || !i.b(shelveAsset.getContentType(), "1")) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        switch (baseViewHolder.getAdapterPosition()) {
            case 0:
                imageView3.setImageResource(R.drawable.icon_top_1);
                break;
            case 1:
                imageView3.setImageResource(R.drawable.icon_top_2);
                break;
            case 2:
                imageView3.setImageResource(R.drawable.icon_top_3);
                break;
            case 3:
                imageView3.setImageResource(R.drawable.icon_top_4);
                break;
            case 4:
                imageView3.setImageResource(R.drawable.icon_top_5);
                break;
            case 5:
                imageView3.setImageResource(R.drawable.icon_top_6);
                break;
            case 6:
                imageView3.setImageResource(R.drawable.icon_top_7);
                break;
            case 7:
                imageView3.setImageResource(R.drawable.icon_top_8);
                break;
            case 8:
                imageView3.setImageResource(R.drawable.icon_top_9);
                break;
            case 9:
                imageView3.setImageResource(R.drawable.icon_top_10);
                break;
        }
        d dVar = d.f10697a;
        dVar.l(shelveAsset.getPosterList(), dVar.g()).subscribe(new l2(new a(this, wVar)), new m2(new b(wVar)));
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
