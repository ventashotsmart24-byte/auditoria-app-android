package com.mobile.brasiltv.view;

import android.content.Intent;
import android.net.Uri;
import com.mobile.brasiltv.utils.b0;
import h9.t;
import s9.l;
import t9.i;
import t9.j;

public final class MsgNotifyDialog$checkCalendarPermission$1 extends j implements l {
    final /* synthetic */ MsgNotifyDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog$checkCalendarPermission$1(MsgNotifyDialog msgNotifyDialog) {
        super(1);
        this.this$0 = msgNotifyDialog;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return t.f17319a;
    }

    public final void invoke(Boolean bool) {
        MsgNotifyDialog msgNotifyDialog = this.this$0;
        b0.U(msgNotifyDialog, "check calendar permission: " + bool);
        i.f(bool, "it");
        if (bool.booleanValue()) {
            this.this$0.requestCalendarPermission();
            return;
        }
        this.this$0.getContext().startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + this.this$0.getContext().getPackageName())));
    }
}
