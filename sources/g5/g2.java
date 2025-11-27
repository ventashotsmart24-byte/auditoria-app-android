package g5;

import a7.d;
import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.f0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import h9.t;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class g2 extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public Context f16921a;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g2 f16922a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageView f16923b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g2 g2Var, ImageView imageView) {
            super(1);
            this.f16922a = g2Var;
            this.f16923b = imageView;
        }

        public final void b(ShelvePoster shelvePoster) {
            e eVar = e.f10706a;
            Context f10 = this.f16922a.f();
            String fileUrl = shelvePoster.getFileUrl();
            ImageView imageView = this.f16923b;
            i.f(imageView, "mIvPoster");
            eVar.b(f10, fileUrl, imageView, R.drawable.bg_special_column_placeholder);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return t.f17319a;
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageView f16924a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f16924a = imageView;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            this.f16924a.setImageResource(R.drawable.bg_special_column_placeholder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g2(Context context) {
        super(R.layout.adapter_home_horizontal_special_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f16921a = context;
    }

    public static final void d(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* renamed from: c */
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        i.g(baseViewHolder, "helper");
        i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        if (f0.b() || TextUtils.isEmpty(shelveAsset.getAlias())) {
            baseViewHolder.setText((int) R.id.mTvEpisodeInfo, (CharSequence) shelveAsset.getName());
        } else {
            baseViewHolder.setText((int) R.id.mTvEpisodeInfo, (CharSequence) shelveAsset.getAlias());
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        d dVar = d.f10697a;
        dVar.l(shelveAsset.getPosterList(), dVar.i()).subscribe(new e2(new a(this, imageView)), new f2(new b(imageView)));
    }

    public final Context f() {
        return this.f16921a;
    }
}
