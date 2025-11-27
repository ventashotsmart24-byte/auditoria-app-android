package g5;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobile.brasiltv.utils.f0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import d6.a;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;
import t9.z;

public final class j0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f16941a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16942b;

    /* renamed from: c  reason: collision with root package name */
    public int f16943c = -1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(Context context) {
        super((int) R.layout.adapter_live_channel_item);
        i.g(context, f.X);
        this.f16941a = context;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, Channel channel) {
        i.g(baseViewHolder, "helper");
        i.g(channel, "bean");
        int layoutPosition = baseViewHolder.getLayoutPosition();
        z zVar = z.f19601a;
        String format = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(layoutPosition + 1)}, 1));
        i.f(format, "format(format, *args)");
        baseViewHolder.setText((int) R.id.mTextChannel, (CharSequence) format + 12288 + b(channel));
        e eVar = e.f10706a;
        Context context = this.f16941a;
        String posterUrl = channel.getPosterUrl();
        View view = baseViewHolder.getView(R.id.mIvChannelLogo);
        i.f(view, "helper.getView(R.id.mIvChannelLogo)");
        eVar.b(context, posterUrl, (ImageView) view, R.drawable.icon_channel_default_logo);
        if (this.f16942b) {
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
        if (this.f16943c == baseViewHolder.getLayoutPosition()) {
            baseViewHolder.setTextColor(R.id.mTextChannel, this.mContext.getResources().getColor(R.color.color_important));
            baseViewHolder.setBackgroundColor(R.id.mLayout, this.mContext.getResources().getColor(R.color.color_80000000));
            ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(true);
        } else {
            baseViewHolder.setTextColor(R.id.mTextChannel, -1);
            baseViewHolder.setBackgroundColor(R.id.mLayout, this.mContext.getResources().getColor(R.color.color_33000000));
            ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(false);
        }
        baseViewHolder.addOnClickListener(R.id.mFavWrapper);
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
        this.f16943c = i10;
        notifyDataSetChanged();
    }

    public final void d(boolean z10) {
        this.f16942b = z10;
    }

    public final void e(String str, int i10) {
        i.g(str, "channelCode");
        if (this.mData.size() > i10 && i.b(((Channel) this.mData.get(i10)).getChannelCode(), str)) {
            notifyItemChanged(i10);
        }
    }
}
