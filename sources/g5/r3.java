package g5;

import android.view.ViewGroup;
import ba.t;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import j5.a;
import java.util.List;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.pushMsg;
import t9.g;
import t9.i;
import y6.b;

public final class r3 extends a {
    public r3() {
        super(R.layout.item_sys_msg, (List) null, 2, (g) null);
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, Msg msg) {
        String str;
        String str2;
        boolean z10;
        i.g(baseViewHolder, "helper");
        i.g(msg, PlistBuilder.KEY_ITEM);
        baseViewHolder.setGone(R.id.mVRedDot, false);
        pushMsg content = msg.getContent();
        if (content == null || (str = content.getTitle()) == null) {
            str = "";
        }
        baseViewHolder.setText((int) R.id.mTvTitle, (CharSequence) str);
        pushMsg content2 = msg.getContent();
        if (content2 == null || (str2 = content2.getText()) == null) {
            str2 = "";
        }
        baseViewHolder.setText((int) R.id.mTvContent, (CharSequence) str2);
        String e10 = b.e(msg.getCreateTime(), "yyyy-MM-dd'T'HH:mm:ss", "M-d HH:mm");
        if (e10 == null || e10.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            baseViewHolder.setText((int) R.id.mTvDate, (CharSequence) "");
            baseViewHolder.setText((int) R.id.mTvTime, (CharSequence) "");
            return;
        }
        i.f(e10, "date");
        List M = t.M(e10, new String[]{" "}, false, 0, 6, (Object) null);
        baseViewHolder.setText((int) R.id.mTvDate, (CharSequence) M.get(0));
        baseViewHolder.setText((int) R.id.mTvTime, (CharSequence) M.get(1));
    }

    public BaseViewHolder onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        BaseViewHolder onCreateDefViewHolder = super.onCreateDefViewHolder(viewGroup, i10);
        ((AutoCardView) onCreateDefViewHolder.getView(R.id.mAcvCard)).setRadius((float) AutoUtils.getPercentWidthSize(10));
        i.f(onCreateDefViewHolder, "holder");
        return onCreateDefViewHolder;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
