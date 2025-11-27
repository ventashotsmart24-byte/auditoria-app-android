package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import ha.a;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.QuestionBean;
import mobile.com.requestframe.utils.response.TypeQuestionData;
import mobile.com.requestframe.utils.response.TypeQuestionResult;
import t9.i;

public final class FeedbackHolder$show$1 extends a {
    final /* synthetic */ FeedbackHolder this$0;

    public FeedbackHolder$show$1(FeedbackHolder feedbackHolder) {
        this.this$0 = feedbackHolder;
    }

    public void showErrorHint(String str) {
        i.g(str, "returnCode");
        this.this$0.isRequest = false;
        if (this.this$0.mIsShow) {
            this.this$0.getHost().showLoading(false);
            f1.f12517a.u(str);
        }
    }

    public void onNext(TypeQuestionResult typeQuestionResult) {
        String str;
        i.g(typeQuestionResult, "t");
        super.onNext(typeQuestionResult);
        this.this$0.isRequest = false;
        if (this.this$0.mIsShow) {
            this.this$0.getHost().showLoading(false);
            if (!i.b(typeQuestionResult.getReturnCode(), "0") || !b0.I(typeQuestionResult.getData())) {
                f1.f12517a.w(R.string.order_system_busy);
                return;
            }
            ArrayList arrayList = new ArrayList();
            List<TypeQuestionData> data = typeQuestionResult.getData();
            i.d(data);
            for (TypeQuestionData next : data) {
                if (b0.I(next.getQuestionList())) {
                    List<QuestionBean> questionList = next.getQuestionList();
                    i.d(questionList);
                    for (QuestionBean next2 : questionList) {
                        next2.setTypeId(Integer.valueOf(next.getTypeId()));
                        arrayList.add(next2);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                Context context = this.this$0.getHost().getContext();
                if (context == null || (str = context.getString(R.string.others)) == null) {
                    str = "";
                }
                QuestionBean questionBean = new QuestionBean(-1, str);
                questionBean.setTypeId(((QuestionBean) arrayList.get(0)).getTypeId());
                arrayList.add(questionBean);
                this.this$0.mAdapter.replaceData(arrayList);
            }
            FeedbackHolder$show$1.super.show(true);
        }
    }
}
