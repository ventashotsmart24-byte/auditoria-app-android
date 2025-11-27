package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.view.View;
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
import t9.z;

public final class w extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17158a;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ w f17159a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f17160b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(w wVar, BaseViewHolder baseViewHolder) {
            super(1);
            this.f17159a = wVar;
            this.f17160b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context c10 = this.f17159a.mContext;
            i.f(c10, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f17160b.getView(R.id.iv_columnImage);
            i.f(view, "helper.getView(R.id.iv_columnImage)");
            eVar.b(c10, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f17161a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f17161a = baseViewHolder;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f17161a.getView(R.id.iv_columnImage)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(R.layout.adapter_column_info_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f17158a = context;
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
        boolean z10;
        String str;
        i.g(baseViewHolder, "helper");
        i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        boolean z11 = true;
        if (i.b(shelveAsset.getType(), "0")) {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                z zVar = z.f19601a;
                String string = this.f17158a.getResources().getString(R.string.recommend_episodes_all);
                i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                i.f(str, "format(format, *args)");
            } else {
                z zVar2 = z.f19601a;
                String string2 = this.f17158a.getResources().getString(R.string.recommend_episodes);
                i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                str = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                i.f(str, "format(format, *args)");
            }
            baseViewHolder.setText((int) R.id.mTvEpisodeInfo, (CharSequence) str);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
        } else {
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            if (shelveAsset.getScore() == 0.0f) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(8);
            } else {
                ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(0);
            }
            baseViewHolder.setText((int) R.id.tv_columnScore, (CharSequence) String.valueOf(shelveAsset.getScore()));
            String contentType = shelveAsset.getContentType();
            if (!(contentType == null || contentType.length() == 0)) {
                z11 = false;
            }
            if (z11 || !i.b(shelveAsset.getContentType(), "1")) {
                ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
            } else {
                ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(0);
            }
        }
        View view = baseViewHolder.getView(R.id.tv_columnName);
        i.f(view, "helper.getView(R.id.tv_columnName)");
        b0.d((TextView) view, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        d dVar = d.f10697a;
        dVar.l(shelveAsset.getPosterList(), dVar.g()).subscribe(new u(new a(this, baseViewHolder)), new v(new b(baseViewHolder)));
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
