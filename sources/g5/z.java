package g5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import mobile.com.requestframe.utils.response.QuestionBean;
import s9.l;
import t9.i;

public final class z extends BaseQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public l f17192a;

    /* renamed from: b  reason: collision with root package name */
    public int f17193b;

    public z() {
        super((int) R.layout.item_feedback_item);
    }

    public static final void c(z zVar, BaseViewHolder baseViewHolder, View view) {
        i.g(zVar, "this$0");
        i.g(baseViewHolder, "$helper");
        zVar.f(baseViewHolder.getAdapterPosition() - zVar.getHeaderLayoutCount());
    }

    /* renamed from: b */
    public void convert(BaseViewHolder baseViewHolder, QuestionBean questionBean) {
        boolean z10;
        i.g(baseViewHolder, "helper");
        i.g(questionBean, PlistBuilder.KEY_ITEM);
        baseViewHolder.setText((int) R.id.tvName, (CharSequence) questionBean.getName());
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivChoose);
        if (this.f17193b == baseViewHolder.getAdapterPosition() - getHeaderLayoutCount()) {
            z10 = true;
        } else {
            z10 = false;
        }
        imageView.setSelected(z10);
        ((ImageView) baseViewHolder.getView(R.id.ivChoose)).setOnClickListener(new y(this, baseViewHolder));
    }

    public final QuestionBean d() {
        return (QuestionBean) getItem(this.f17193b);
    }

    public final void e(l lVar) {
        this.f17192a = lVar;
    }

    public final void f(int i10) {
        this.f17193b = i10;
        l lVar = this.f17192a;
        if (lVar != null) {
            boolean z10 = true;
            if (i10 != ((getItemCount() - getFooterLayoutCount()) - getHeaderLayoutCount()) - 1) {
                z10 = false;
            }
            lVar.invoke(Boolean.valueOf(z10));
        }
        notifyDataSetChanged();
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.itemView);
        return onCreateViewHolder;
    }
}
