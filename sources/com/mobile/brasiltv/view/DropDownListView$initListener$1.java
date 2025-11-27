package com.mobile.brasiltv.view;

import android.content.Context;
import android.widget.TextView;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.view.DropDownPop;
import com.mobile.brasiltv.view.dialog.AccountRemoveDialog;
import com.umeng.analytics.pro.f;
import t9.i;

public final class DropDownListView$initListener$1 implements DropDownPop.OnItemClickListener {
    final /* synthetic */ DropDownListView this$0;

    public DropDownListView$initListener$1(DropDownListView dropDownListView) {
        this.this$0 = dropDownListView;
    }

    public void onItemClick(int i10, SwitchAccountBean switchAccountBean) {
        i.g(switchAccountBean, "bean");
        this.this$0.mSelectPos = i10;
        TextView access$getMTextView$p = this.this$0.mTextView;
        if (access$getMTextView$p == null) {
            i.w("mTextView");
            access$getMTextView$p = null;
        }
        access$getMTextView$p.setText(switchAccountBean.getShowName());
    }

    public void onItemRemoveClick(int i10, String str, SwitchAccountBean switchAccountBean) {
        i.g(str, "account");
        i.g(switchAccountBean, "bean");
        Context context = this.this$0.getContext();
        i.f(context, f.X);
        new AccountRemoveDialog(context, str, new DropDownListView$initListener$1$onItemRemoveClick$1(this.this$0, i10, switchAccountBean), DropDownListView$initListener$1$onItemRemoveClick$2.INSTANCE).show();
    }
}
