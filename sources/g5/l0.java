package g5;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b6.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.f0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import com.zhy.autolayout.utils.AutoUtils;
import d6.a;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.EpgResultData;
import t9.i;
import t9.z;

public final class l0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16984a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16985b;

    /* renamed from: c  reason: collision with root package name */
    public int f16986c = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l0(Context context) {
        super(R.layout.adapter_live_info_item, (List) null);
        i.g(context, f.X);
        this.f16984a = context;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, Channel channel) {
        i.g(baseViewHolder, "helper");
        i.g(channel, PlistBuilder.KEY_ITEM);
        int layoutPosition = baseViewHolder.getLayoutPosition();
        z zVar = z.f19601a;
        String format = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(layoutPosition + 1)}, 1));
        i.f(format, "format(format, *args)");
        if (layoutPosition == this.f16986c) {
            e(baseViewHolder);
        } else {
            f(baseViewHolder);
        }
        baseViewHolder.setText((int) R.id.mTextChannel, (CharSequence) format + 12288 + b(channel));
        e eVar = e.f10706a;
        Context context = this.f16984a;
        String posterUrl = channel.getPosterUrl();
        View view = baseViewHolder.getView(R.id.mIvChannelLogo);
        i.f(view, "helper.getView(R.id.mIvChannelLogo)");
        eVar.b(context, posterUrl, (ImageView) view, R.drawable.icon_channel_default_logo);
        if (this.f16985b) {
            baseViewHolder.setVisible(R.id.mFavWrapper, true);
            if (a.f16338a.l(channel.getChannelCode())) {
                baseViewHolder.setGone(R.id.mIvFav, false);
                baseViewHolder.setGone(R.id.mPbUnfav, true);
            } else {
                baseViewHolder.setGone(R.id.mIvFav, true);
                baseViewHolder.setGone(R.id.mPbUnfav, false);
            }
        } else {
            baseViewHolder.setGone(R.id.mFavWrapper, false);
        }
        r0.a aVar = r0.A;
        if (aVar.d().isEmpty()) {
            baseViewHolder.setText((int) R.id.mTextEpgName, (CharSequence) this.f16984a.getResources().getString(R.string.live_get_show));
        } else if (aVar.d().containsKey(channel.getChannelCode())) {
            Object obj = aVar.d().get(channel.getChannelCode());
            i.d(obj);
            baseViewHolder.setText((int) R.id.mTextEpgName, (CharSequence) ((EpgResultData) obj).getTitle());
            baseViewHolder.setGone(R.id.mTextEpgName, true);
        } else {
            baseViewHolder.setText((int) R.id.mTextEpgName, (CharSequence) "");
            baseViewHolder.setGone(R.id.mTextEpgName, false);
        }
        baseViewHolder.addOnClickListener(R.id.mImageEpg);
        baseViewHolder.addOnClickListener(R.id.mFavWrapper);
        baseViewHolder.addOnClickListener(R.id.mLayoutProgram);
    }

    public final String b(Channel channel) {
        if (f0.b() || TextUtils.isEmpty(channel.getAlias())) {
            return channel.getName();
        }
        String alias = channel.getAlias();
        i.d(alias);
        return alias;
    }

    public final void c(int i10) {
        this.f16986c = i10;
    }

    public final void d(boolean z10) {
        this.f16985b = z10;
    }

    public final void e(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextChannel, this.f16984a.getResources().getColor(R.color.color_important));
        baseViewHolder.setTextColor(R.id.mTextEpgName, this.f16984a.getResources().getColor(R.color.color_important));
        baseViewHolder.setBackgroundColor(R.id.live_info_item_rl, this.f16984a.getResources().getColor(R.color.color_161720));
        ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(true);
    }

    public final void f(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextChannel, this.f16984a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setTextColor(R.id.mTextEpgName, this.f16984a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setBackgroundColor(R.id.live_info_item_rl, this.f16984a.getResources().getColor(R.color.color_1f202a));
        ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(false);
    }

    public final void g(String str, int i10) {
        i.g(str, "channelCode");
        if (this.mData.size() > i10 && i.b(((Channel) this.mData.get(i10)).getChannelCode(), str)) {
            notifyItemChanged(i10);
        }
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
