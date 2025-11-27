package g5;

import android.content.Context;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import j5.a;
import java.util.List;
import t9.g;
import t9.i;

public final class v2 extends a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f17144a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v2(Context context) {
        super(R.layout.adapter_search_history_item, (List) null, 2, (g) null);
        i.g(context, f.X);
        this.f17144a = context;
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        i.g(baseViewHolder, "helper");
        i.g(str, PlistBuilder.KEY_ITEM);
        baseViewHolder.setText((int) R.id.tv_history_title, (CharSequence) str);
    }

    public int getItemCount() {
        int itemCount = super.getItemCount();
        if (itemCount > 6) {
            return 6;
        }
        return itemCount;
    }
}
