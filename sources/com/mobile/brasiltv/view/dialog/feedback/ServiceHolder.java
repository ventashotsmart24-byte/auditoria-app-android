package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import g5.a0;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import mobile.com.requestframe.utils.response.WorkInfoBean;
import t9.i;
import w6.i;

public final class ServiceHolder extends BaseFeedbackHodler {
    /* access modifiers changed from: private */
    public a0 mAdapter = new a0();
    /* access modifiers changed from: private */
    public boolean mIsRequesting;
    /* access modifiers changed from: private */
    public boolean mIsShow;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ServiceHolder(RecyclerView recyclerView, IFeedbackView iFeedbackView) {
        super(recyclerView, iFeedbackView);
        i.g(recyclerView, "recyclerView");
        i.g(iFeedbackView, "dialog");
        recyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    private final void getCustomerService() {
        getHost().showLoading(true);
        w6.i.f9510g.b().k1().subscribe(new ServiceHolder$getCustomerService$1(this));
    }

    private final List<FeedBackContactData> getTestData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList2.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30", "1151555115"));
        arrayList.add(new FeedBackContactData("WhatsApp", arrayList2, ""));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList.add(new FeedBackContactData("Facebook", arrayList3, ""));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList.add(new FeedBackContactData("Facebook", arrayList4, ""));
        return arrayList;
    }

    public void clickSubmit() {
    }

    public void dialogCancel() {
        this.mIsShow = false;
    }

    public void show(boolean z10) {
        this.mIsShow = z10;
        super.show(z10);
        if (this.mIsShow && this.mAdapter.getData().size() == 0) {
            i.c cVar = w6.i.f9510g;
            if (!cVar.o().isEmpty()) {
                Context context = getHost().getContext();
                if (context != null) {
                    this.mAdapter.a(context, cVar.o());
                }
            } else if (!this.mIsRequesting) {
                this.mIsRequesting = true;
                getCustomerService();
            } else {
                getHost().showLoading(true);
            }
        }
    }
}
