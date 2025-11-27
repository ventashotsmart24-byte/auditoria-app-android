package g5;

import a7.e;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import ba.t;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.FeedBackContacTime;
import com.mobile.brasiltv.bean.FeedBackContactBean;
import com.mobile.brasiltv.bean.FeedBackTitleBean;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import i9.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import mobile.com.requestframe.utils.response.WorkInfoBean;
import t9.g;
import t9.i;

public final class a0 extends BaseMultiItemQuickAdapter {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16850a = new a((g) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public a0() {
        super(new ArrayList());
        addItemType(1, R.layout.item_feedback_service_item_title);
        addItemType(2, R.layout.item_feedback_service_item_contact);
        addItemType(3, R.layout.item_feedback_service_item_time);
    }

    public final void a(Context context, List list) {
        List<String> list2;
        Context context2 = context;
        i.g(context2, f.X);
        i.g(list, "feedBackContacts");
        List data = getData();
        i.f(data, "data");
        data.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FeedBackContactData feedBackContactData = (FeedBackContactData) it.next();
            if (!b0.J(feedBackContactData.getName()) && !b0.J(feedBackContactData.getLogo())) {
                data.add(new FeedBackTitleBean(feedBackContactData));
                int i10 = 0;
                for (T next : feedBackContactData.getWorkInfoList()) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        j.j();
                    }
                    WorkInfoBean workInfoBean = (WorkInfoBean) next;
                    if (feedBackContactData.getWorkInfoList().size() == 1) {
                        String contact = workInfoBean.getContact();
                        data.add(new FeedBackContactBean(contact, context2.getString(R.string.customer_service_land) + ": "));
                    } else {
                        String contact2 = workInfoBean.getContact();
                        data.add(new FeedBackContactBean(contact2, context2.getString(R.string.customer_service_land) + ' ' + i11 + ": "));
                    }
                    String workingTimeDesc = workInfoBean.getWorkingTimeDesc();
                    if (workingTimeDesc != null) {
                        list2 = t.M(workingTimeDesc, new String[]{","}, false, 0, 6, (Object) null);
                    } else {
                        list2 = null;
                    }
                    if (list2 != null) {
                        for (String feedBackContacTime : list2) {
                            data.add(new FeedBackContacTime(feedBackContacTime));
                        }
                    }
                    i10 = i11;
                }
            }
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        int i10;
        i.g(baseViewHolder, "helper");
        i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == 1) {
            FeedBackTitleBean feedBackTitleBean = (FeedBackTitleBean) multiItemEntity;
            View view = baseViewHolder.getView(R.id.line);
            if (baseViewHolder.getAdapterPosition() == 0) {
                i10 = 8;
            } else {
                i10 = 0;
            }
            view.setVisibility(i10);
            e eVar = e.f10706a;
            Context context = this.mContext;
            i.f(context, "mContext");
            String logo = feedBackTitleBean.getLogo();
            View view2 = baseViewHolder.getView(R.id.ivIcon);
            i.f(view2, "helper.getView(R.id.ivIcon)");
            eVar.b(context, logo, (ImageView) view2, R.mipmap.ic_logo);
            baseViewHolder.setText((int) R.id.tvName, (CharSequence) feedBackTitleBean.getName());
        } else if (itemViewType == 2) {
            FeedBackContactBean feedBackContactBean = (FeedBackContactBean) multiItemEntity;
            baseViewHolder.setText((int) R.id.tvContactName, (CharSequence) feedBackContactBean.getName()).setText((int) R.id.tvContact, (CharSequence) feedBackContactBean.getContact());
        } else if (itemViewType == 3) {
            baseViewHolder.setText((int) R.id.tvTime, (CharSequence) ((FeedBackContacTime) multiItemEntity).getTime());
        }
    }
}
