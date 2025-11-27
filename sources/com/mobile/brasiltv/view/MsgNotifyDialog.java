package com.mobile.brasiltv.view;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.e;
import c8.b;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import s9.l;
import s9.p;
import t9.g;
import t9.i;

public final class MsgNotifyDialog extends Dialog {
    public static final Companion Companion = new Companion((g) null);
    public static final int TYPE_CALENDAR = 1;
    public static final int TYPE_NOTIFICATION = 2;
    private Activity activity;
    private final Handler mHandler;
    private final int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MsgNotifyDialog(Activity activity2, int i10, int i11, g gVar) {
        this(activity2, (i11 & 2) != 0 ? 1 : i10);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(MsgNotifyDialog msgNotifyDialog, View view) {
        i.g(msgNotifyDialog, "this$0");
        if (msgNotifyDialog.type == 1) {
            msgNotifyDialog.checkCalendarPermission();
        } else {
            q5.i.f19305a.l(msgNotifyDialog.activity);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(MsgNotifyDialog msgNotifyDialog, View view) {
        i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
        if (msgNotifyDialog.type == 1) {
            App.f6050e.a().j().o(System.currentTimeMillis());
        }
    }

    private final void checkCalendarPermission() {
        Activity activity2 = this.activity;
        i.e(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        new b((e) activity2).s(this.activity, "android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR").subscribe(new q(new MsgNotifyDialog$checkCalendarPermission$1(this)), new r(MsgNotifyDialog$checkCalendarPermission$2.INSTANCE));
    }

    /* access modifiers changed from: private */
    public static final void checkCalendarPermission$lambda$7(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void checkCalendarPermission$lambda$8(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    private final void recheckPermission() {
        int i10 = this.type;
        boolean z10 = true;
        if (i10 == 1) {
            Activity activity2 = this.activity;
            i.e(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            b bVar = new b((e) activity2);
            boolean i11 = bVar.i("android.permission.READ_CALENDAR");
            boolean i12 = bVar.i("android.permission.WRITE_CALENDAR");
            StringBuilder sb = new StringBuilder();
            sb.append("recheckPermission: type: 1 result: ");
            if (!i11 || !i12) {
                z10 = false;
            }
            sb.append(z10);
            b0.U(this, sb.toString());
            if (i11 && i12) {
                this.mHandler.postDelayed(new u(this), 600);
            }
        } else if (i10 == 2) {
            q5.i iVar = q5.i.f19305a;
            Activity activity3 = this.activity;
            i.d(activity3);
            if (iVar.j(activity3)) {
                b0.U(this, "recheckPermission: type: 2 result: true");
                this.mHandler.postDelayed(new v(this), 600);
            }
            b0.U(this, "recheckPermission: type: 2 result: false");
        }
    }

    /* access modifiers changed from: private */
    public static final void recheckPermission$lambda$10(MsgNotifyDialog msgNotifyDialog) {
        i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void recheckPermission$lambda$9(MsgNotifyDialog msgNotifyDialog) {
        i.g(msgNotifyDialog, "this$0");
        msgNotifyDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public final void requestCalendarPermission() {
        Activity activity2 = this.activity;
        i.e(activity2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        new b((e) activity2).p("android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR").collect(new w(), new x(new MsgNotifyDialog$requestCalendarPermission$2(this))).subscribe(new y(new MsgNotifyDialog$requestCalendarPermission$3(this)), new z(MsgNotifyDialog$requestCalendarPermission$4.INSTANCE));
    }

    /* access modifiers changed from: private */
    public static final ArrayList requestCalendarPermission$lambda$3() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(Boolean.TRUE);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$4(p pVar, Object obj, Object obj2) {
        i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    /* access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$5(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void requestCalendarPermission$lambda$6(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public void onBackPressed() {
    }

    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        b0.U(this, "MsgNotifyDialog focus: " + z10);
        if (z10) {
            recheckPermission();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MsgNotifyDialog(Activity activity2, int i10) {
        super(activity2, R.style.OptionDialog);
        i.d(activity2);
        this.activity = activity2;
        this.type = i10;
        this.mHandler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.dialog_msg_notify);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        if (i10 == 1) {
            ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setText(getContext().getResources().getString(R.string.open_msg_notify_calendar));
        } else {
            ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setText(getContext().getResources().getString(R.string.open_msg_notify_mobile));
            ((TextView) findViewById(R$id.mTvHint)).setVisibility(0);
        }
        ((KoocanButton) findViewById(R$id.mButtonEnableFunc)).setOnClickListener(new s(this));
        ((KoocanButton) findViewById(R$id.mButtonNotNeed)).setOnClickListener(new t(this));
        setCanceledOnTouchOutside(false);
    }
}
