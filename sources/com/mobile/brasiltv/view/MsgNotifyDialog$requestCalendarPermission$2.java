package com.mobile.brasiltv.view;

import c8.a;
import com.mobile.brasiltv.utils.b0;
import h9.t;
import java.util.ArrayList;
import s9.p;
import t9.i;
import t9.j;

public final class MsgNotifyDialog$requestCalendarPermission$2 extends j implements p {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$requestCalendarPermission$2(MsgNotifyDialog msgNotifyDialog) {
        super(2);
        this.this$0 = msgNotifyDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ArrayList<Boolean>) (ArrayList) obj, (a) obj2);
        return t.f17319a;
    }

    public final void invoke(ArrayList<Boolean> arrayList, a aVar) {
        MsgNotifyDialog msgNotifyDialog = this.this$0;
        b0.U(msgNotifyDialog, "request calendar permission result: " + aVar);
        Boolean bool = arrayList.get(0);
        i.f(bool, "t1[0]");
        arrayList.set(0, Boolean.valueOf(bool.booleanValue() && aVar.f11374b));
    }
}
