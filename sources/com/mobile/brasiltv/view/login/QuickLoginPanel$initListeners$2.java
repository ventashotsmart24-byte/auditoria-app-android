package com.mobile.brasiltv.view.login;

import com.mobile.brasiltv.db.SwitchAccountBean;
import h9.t;
import s9.p;
import t9.i;
import t9.j;

public final class QuickLoginPanel$initListeners$2 extends j implements p {
    final /* synthetic */ QuickLoginPanel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickLoginPanel$initListeners$2(QuickLoginPanel quickLoginPanel) {
        super(2);
        this.this$0 = quickLoginPanel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (SwitchAccountBean) obj2);
        return t.f17319a;
    }

    public final void invoke(int i10, SwitchAccountBean switchAccountBean) {
        i.g(switchAccountBean, "bean");
        IQuickLoginCallback access$getMQuickLoginCallback$p = this.this$0.mQuickLoginCallback;
        if (access$getMQuickLoginCallback$p != null) {
            access$getMQuickLoginCallback$p.onRemoveAccount(i10, switchAccountBean);
        }
    }
}
