package com.mobile.brasiltv.view;

import h9.t;
import java.util.ArrayList;
import s9.l;
import t9.i;
import t9.j;

public final class MsgNotifyDialog$requestCalendarPermission$3 extends j implements l {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$requestCalendarPermission$3(MsgNotifyDialog msgNotifyDialog) {
        super(1);
        this.this$0 = msgNotifyDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<Boolean>) (ArrayList) obj);
        return t.f17319a;
    }

    public final void invoke(ArrayList<Boolean> arrayList) {
        Boolean bool = arrayList.get(0);
        i.f(bool, "it[0]");
        if (bool.booleanValue()) {
            this.this$0.dismiss();
        }
    }
}
