package f6;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.GetExchangeOrderData;
import t9.i;
import t9.z;
import y6.b;

public final class k extends BaseQuickAdapter {
    public k() {
        super((int) R.layout.adapter_redemption);
    }

    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, GetExchangeOrderData getExchangeOrderData) {
        String str;
        i.g(baseViewHolder, "helper");
        i.g(getExchangeOrderData, PlistBuilder.KEY_ITEM);
        z zVar = z.f19601a;
        String string = this.mContext.getResources().getString(R.string.order_exchange_code);
        i.f(string, "mContext.resources.getSt…ring.order_exchange_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getExchangeOrderData.getExchangeCode()}, 1));
        i.f(format, "format(format, *args)");
        baseViewHolder.setText((int) R.id.tvExchangeCode, (CharSequence) format);
        if (TextUtils.isEmpty(getExchangeOrderData.getUsingTime()) || getExchangeOrderData.getUsingTime().length() < 16) {
            String c10 = b.c();
            i.f(c10, "getLocalUTCTime()");
            str = s.j(c10, Operator.Operation.MINUS, ".", false, 4, (Object) null);
        } else {
            str = b.e(getExchangeOrderData.getUsingTime(), "yyyy-MM-dd HH:mm:SS", "yyyy.MM.dd HH:mm");
        }
        String string2 = this.mContext.getResources().getString(R.string.order_time_of_use);
        i.f(string2, "mContext.resources.getSt…string.order_time_of_use)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
        i.f(format2, "format(format, *args)");
        baseViewHolder.setText((int) R.id.tvTimeOfUse, (CharSequence) format2);
    }

    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            getRecyclerView().setAdapter(this);
        } else {
            super.bindToRecyclerView(recyclerView);
        }
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.itemView);
        return onCreateViewHolder;
    }
}
