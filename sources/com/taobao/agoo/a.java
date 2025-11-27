package com.taobao.agoo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Intent f13252a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ BaseNotifyClick f13253b;

    public a(BaseNotifyClick baseNotifyClick, Intent intent) {
        this.f13253b = baseNotifyClick;
        this.f13252a = intent;
    }

    public void run() {
        Intent intent = null;
        try {
            Intent intent2 = this.f13252a;
            if (intent2 != null) {
                String access$000 = this.f13253b.parseMsgByThirdPush(intent2);
                if (TextUtils.isEmpty(access$000) || TextUtils.isEmpty(this.f13253b.msgSource)) {
                    ALog.e("BaseNotifyClick", "parseMsgFromNotifyListener null!!", "source", this.f13253b.msgSource);
                } else {
                    if (this.f13253b.notifyManager == null) {
                        NotifManager unused = this.f13253b.notifyManager = new NotifManager();
                    }
                    if (this.f13253b.agooFactory == null) {
                        AgooFactory unused2 = this.f13253b.agooFactory = new AgooFactory();
                        this.f13253b.agooFactory.init(this.f13253b.context, this.f13253b.notifyManager, (MessageService) null);
                    }
                    Bundle msgReceiverPreHandler = this.f13253b.agooFactory.msgReceiverPreHandler(access$000.getBytes("UTF-8"), this.f13253b.msgSource, (TaoBaseService.ExtraInfo) null, false);
                    String string = msgReceiverPreHandler.getString("body");
                    ALog.i("BaseNotifyClick", "begin parse EncryptedMsg", new Object[0]);
                    String parseEncryptedMsg = AgooFactory.parseEncryptedMsg(string);
                    int i10 = msgReceiverPreHandler.getInt("channel", -1);
                    if (!TextUtils.isEmpty(parseEncryptedMsg)) {
                        msgReceiverPreHandler.putString("body", parseEncryptedMsg);
                        msgReceiverPreHandler.putInt("channel", i10);
                    } else {
                        ALog.e("BaseNotifyClick", "parse EncryptedMsg fail, empty", new Object[0]);
                    }
                    Intent intent3 = new Intent();
                    try {
                        intent3.putExtras(msgReceiverPreHandler);
                        this.f13253b.agooFactory.saveMsg(access$000.getBytes("UTF-8"), "2");
                        this.f13253b.reportClickNotifyMsg(intent3);
                        intent = intent3;
                    } catch (Throwable th) {
                        intent = intent3;
                        th = th;
                        try {
                            ALog.e("BaseNotifyClick", "buildMessage", th, new Object[0]);
                            try {
                                this.f13253b.onMessage(intent);
                                return;
                            } catch (Throwable th2) {
                                ALog.e("BaseNotifyClick", "onMessage", th2, new Object[0]);
                                return;
                            }
                        } catch (Throwable th3) {
                            ALog.e("BaseNotifyClick", "onMessage", th3, new Object[0]);
                        }
                    }
                }
            }
            try {
                this.f13253b.onMessage(intent);
                return;
            } catch (Throwable th4) {
                ALog.e("BaseNotifyClick", "onMessage", th4, new Object[0]);
                return;
            }
        } catch (Throwable th5) {
            th = th5;
            ALog.e("BaseNotifyClick", "buildMessage", th, new Object[0]);
            this.f13253b.onMessage(intent);
            return;
        }
        throw th;
    }
}
