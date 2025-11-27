package com.mobile.brasiltv.view;

import com.mobile.brasiltv.db.SwitchAccountBean;
import s9.a;
import s9.p;
import t9.j;

public final class DropDownListView$initListener$1$onItemRemoveClick$1 extends j implements a {
    final /* synthetic */ SwitchAccountBean $bean;
    final /* synthetic */ int $position;
    final /* synthetic */ DropDownListView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DropDownListView$initListener$1$onItemRemoveClick$1(DropDownListView dropDownListView, int i10, SwitchAccountBean switchAccountBean) {
        super(0);
        this.this$0 = dropDownListView;
        this.$position = i10;
        this.$bean = switchAccountBean;
    }

    public final void invoke() {
        p access$getMRemoveListener$p = this.this$0.mRemoveListener;
        if (access$getMRemoveListener$p != null) {
            access$getMRemoveListener$p.invoke(Integer.valueOf(this.$position), this.$bean);
        }
        if (this.$position == this.this$0.mSelectPos) {
            this.this$0.mSelectPos = 0;
        }
        this.this$0.mPop.dismiss();
    }
}
