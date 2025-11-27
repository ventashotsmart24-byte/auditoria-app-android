package n6;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import t9.g;
import t9.i;

public abstract class a extends j5.a {

    /* renamed from: a  reason: collision with root package name */
    public int f19012a = -1;

    public a(int i10) {
        super(i10, (List) null, 2, (g) null);
    }

    public final int a() {
        return this.f19012a;
    }

    public final void b(int i10) {
        this.f19012a = i10;
    }

    public void c(int i10) {
        this.f19012a = i10;
        List<SimpleProgramList> data = getData();
        i.f(data, "data");
        for (SimpleProgramList played : data) {
            played.setPlayed(false);
        }
        notifyDataSetChanged();
        if (this.f19012a != -1) {
            SimpleProgramList simpleProgramList = (SimpleProgramList) getItem(i10);
            if (simpleProgramList != null) {
                simpleProgramList.setPlayed(true);
            }
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
