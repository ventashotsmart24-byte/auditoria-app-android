package g5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import java.util.List;
import t9.i;

public final class v0 extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17141a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v0(Context context) {
        super(R.layout.adapter_live_tab_frag_recyclerview, (List) null);
        i.g(context, f.X);
        this.f17141a = context;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, LiveTabEntity liveTabEntity) {
        TextView textView;
        i.g(liveTabEntity, PlistBuilder.KEY_ITEM);
        if (baseViewHolder != null) {
            baseViewHolder.setText((int) R.id.name, (CharSequence) liveTabEntity.getName());
        }
        if (baseViewHolder != null) {
            textView = (TextView) baseViewHolder.getView(R.id.name);
        } else {
            textView = null;
        }
        if (liveTabEntity.isSelected()) {
            if (textView != null) {
                textView.setBackground(this.f17141a.getResources().getDrawable(R.drawable.bg_livetab_recyclerview));
            }
        } else if (textView != null) {
            textView.setBackground((Drawable) null);
        }
    }
}
