package n6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import t9.i;

public final class k extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    public Context f19040a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f19041b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public int f19042c;

    /* renamed from: d  reason: collision with root package name */
    public a f19043d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f19044e = true;

    public interface a {
        void a(int i10, Object obj);
    }

    public final class b extends RecyclerView.d0 {

        /* renamed from: a  reason: collision with root package name */
        public AutoFrameLayout f19045a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f19046b;

        /* renamed from: c  reason: collision with root package name */
        public AutoLinearLayout f19047c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f19048d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ k f19049e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k kVar, View view) {
            super(view);
            i.g(view, "itemView");
            this.f19049e = kVar;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f19045a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f19046b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mLlName);
            i.f(findViewById3, "itemView.findViewById(R.id.mLlName)");
            this.f19047c = (AutoLinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSelected);
            i.f(findViewById4, "itemView.findViewById(R.id.mIvSelected)");
            this.f19048d = (ImageView) findViewById4;
        }

        public final ImageView b() {
            return this.f19048d;
        }

        public final AutoFrameLayout c() {
            return this.f19045a;
        }

        public final AutoLinearLayout d() {
            return this.f19047c;
        }

        public final TextView e() {
            return this.f19046b;
        }
    }

    public k(Context context) {
        i.g(context, "mContext");
        this.f19040a = context;
    }

    public static final void c(k kVar, int i10, View view) {
        i.g(kVar, "this$0");
        kVar.g(i10);
        a aVar = kVar.f19043d;
        if (aVar != null) {
            aVar.a(i10, kVar.f19041b.get(i10));
        }
    }

    /* renamed from: b */
    public void onBindViewHolder(b bVar, int i10) {
        boolean z10;
        String str;
        i.g(bVar, "holder");
        if (this.f19041b.get(i10) instanceof String) {
            bVar.e().setText(String.valueOf(this.f19041b.get(i10)));
            bVar.c().setEnabled(this.f19044e);
            bVar.e().setEnabled(this.f19044e);
            bVar.b().setEnabled(this.f19044e);
        } else if (this.f19041b.get(i10) instanceof SubtitleStyleBean) {
            Object obj = this.f19041b.get(i10);
            i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubtitleStyleBean");
            SubtitleStyleBean subtitleStyleBean = (SubtitleStyleBean) obj;
            bVar.e().setText(this.f19040a.getString(R.string.Aa));
            bVar.d().setBackgroundColor(subtitleStyleBean.getBackgrounrd());
            bVar.e().setTextColor(subtitleStyleBean.getColor());
            bVar.d().setEnabled(this.f19044e);
            bVar.c().setEnabled(this.f19044e);
            bVar.e().setEnabled(this.f19044e);
            bVar.b().setEnabled(this.f19044e);
            String.valueOf(this.f19044e);
        } else if (this.f19041b.get(i10) instanceof SubTitleData) {
            Object obj2 = this.f19041b.get(i10);
            i.e(obj2, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubTitleData");
            SubTitleData subTitleData = (SubTitleData) obj2;
            if (subTitleData instanceof NoSubTitleData) {
                bVar.e().setText(this.f19040a.getResources().getString(R.string.vod_no_subtitle));
            } else if (subTitleData instanceof OffSubTitleData) {
                bVar.e().setText(this.f19040a.getResources().getString(R.string.vod_disable_subtitle));
            } else {
                TextView e10 = bVar.e();
                String language = subTitleData.getLanguage();
                int hashCode = language.hashCode();
                if (hashCode != 3241) {
                    if (hashCode != 3246) {
                        if (hashCode == 3588 && language.equals("pt")) {
                            str = this.f19040a.getResources().getString(R.string.subtitle_language_pt);
                            e10.setText(str);
                        }
                    } else if (language.equals("es")) {
                        str = this.f19040a.getResources().getString(R.string.subtitle_language_es);
                        e10.setText(str);
                    }
                } else if (language.equals(XML.DEFAULT_CONTENT_LANGUAGE)) {
                    str = this.f19040a.getResources().getString(R.string.subtitle_language_en);
                    e10.setText(str);
                }
                str = subTitleData.getLanguage();
                e10.setText(str);
            }
        } else if (this.f19041b.get(i10) instanceof AudioTrackBean) {
            Object obj3 = this.f19041b.get(i10);
            i.e(obj3, "null cannot be cast to non-null type com.mobile.brasiltv.bean.AudioTrackBean");
            String realAudio = ((AudioTrackBean) obj3).getRealAudio();
            if (realAudio.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 || i.b(realAudio, "und")) {
                if (i10 == 0) {
                    realAudio = this.f19040a.getResources().getString(R.string.def);
                    i.f(realAudio, "{\n                    mC…ng.def)\n                }");
                } else {
                    realAudio = this.f19040a.getResources().getString(R.string.def) + i10;
                }
            }
            bVar.e().setText(SubtitleManager.INSTANCE.getTranslateString(this.f19040a, realAudio));
        }
        if (this.f19042c == i10) {
            bVar.b().setVisibility(0);
            bVar.e().setSelected(true);
        } else {
            bVar.b().setVisibility(8);
            bVar.e().setSelected(false);
        }
        bVar.c().setOnClickListener(new j(this, i10));
    }

    /* renamed from: d */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f19040a).inflate(R.layout.item_subtitle_pop_window, viewGroup, false);
        i.f(inflate, "view");
        return new b(this, inflate);
    }

    public final void e(ArrayList arrayList) {
        i.g(arrayList, "data");
        this.f19041b.clear();
        this.f19041b.addAll(arrayList);
    }

    public final void f(a aVar) {
        i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f19043d = aVar;
    }

    public final void g(int i10) {
        this.f19042c = i10;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.f19041b.size();
    }

    public final void h(boolean z10) {
        if ((this.f19041b.get(0) instanceof String) && this.f19044e != z10) {
            this.f19044e = z10;
            notifyDataSetChanged();
        }
        if ((this.f19041b.get(0) instanceof SubtitleStyleBean) && this.f19044e != z10) {
            this.f19044e = z10;
            notifyDataSetChanged();
        }
    }
}
