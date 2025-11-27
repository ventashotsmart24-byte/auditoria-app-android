package com.taobao.agoo;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.k;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.util.Iterator;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.MsgDO;
import org.android.agoo.control.AgooFactory;
import org.android.agoo.control.NotifManager;
import org.android.agoo.message.MessageService;

public abstract class BaseNotifyClick {
    private static final String TAG = "BaseNotifyClick";
    /* access modifiers changed from: private */
    public AgooFactory agooFactory;
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public String msgSource;
    /* access modifiers changed from: private */
    public NotifManager notifyManager;

    private void buildMessage(Intent intent) {
        ThreadPoolExecutorFactory.execute(new a(this, intent));
    }

    /* access modifiers changed from: private */
    public String parseMsgByThirdPush(Intent intent) {
        String str;
        Set<BaseNotifyClickActivity.INotifyListener> set = BaseNotifyClickActivity.notifyListeners;
        if (set != null && set.size() > 0) {
            Iterator<BaseNotifyClickActivity.INotifyListener> it = BaseNotifyClickActivity.notifyListeners.iterator();
            str = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BaseNotifyClickActivity.INotifyListener next = it.next();
                String parseMsgFromIntent = next.parseMsgFromIntent(intent);
                if (!TextUtils.isEmpty(parseMsgFromIntent)) {
                    this.msgSource = next.getMsgSource();
                    str = parseMsgFromIntent;
                    break;
                }
                str = parseMsgFromIntent;
            }
        } else {
            ALog.e(TAG, "no impl, try use default impl to parse intent!", new Object[0]);
            BaseNotifyClickActivity.INotifyListener bVar = new b();
            String parseMsgFromIntent2 = bVar.parseMsgFromIntent(intent);
            if (TextUtils.isEmpty(parseMsgFromIntent2)) {
                bVar = new f();
                parseMsgFromIntent2 = bVar.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent2)) {
                bVar = new d();
                parseMsgFromIntent2 = bVar.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent2)) {
                bVar = new e();
                parseMsgFromIntent2 = bVar.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(parseMsgFromIntent2)) {
                bVar = new c();
                parseMsgFromIntent2 = bVar.parseMsgFromIntent(intent);
            }
            if (TextUtils.isEmpty(str)) {
                k.a("accs", "error", "parse 3push error", 0.0d);
            } else {
                this.msgSource = bVar.getMsgSource();
                k.a("accs", "error", "parse 3push default " + this.msgSource, 0.0d);
            }
        }
        ALog.i(TAG, "parseMsgByThirdPush", "result", str, "msgSource", this.msgSource);
        return str;
    }

    /* access modifiers changed from: private */
    public void reportClickNotifyMsg(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("id");
            String stringExtra2 = intent.getStringExtra(AgooConstants.MESSAGE_SOURCE);
            String stringExtra3 = intent.getStringExtra(AgooConstants.MESSAGE_REPORT);
            String stringExtra4 = intent.getStringExtra(AgooConstants.MESSAGE_EXT);
            MsgDO msgDO = new MsgDO();
            msgDO.msgIds = stringExtra;
            msgDO.extData = stringExtra4;
            msgDO.messageSource = stringExtra2;
            msgDO.reportStr = stringExtra3;
            msgDO.msgStatus = MessageService.MSG_ACCS_NOTIFY_CLICK;
            ALog.i(TAG, "reportClickNotifyMsg messageId:" + stringExtra + " source:" + stringExtra2 + " reportStr:" + stringExtra3 + " status:" + msgDO.msgStatus, new Object[0]);
            this.notifyManager.report(msgDO, (TaoBaseService.ExtraInfo) null);
        } catch (Exception e10) {
            ALog.e(TAG, "reportClickNotifyMsg exception: " + e10, new Object[0]);
        }
    }

    public void onCreate(Context context2, Intent intent) {
        ALog.i(TAG, "onCreate", new Object[0]);
        this.context = context2;
        buildMessage(intent);
    }

    public abstract void onMessage(Intent intent);

    public void onNewIntent(Intent intent) {
        ALog.i(TAG, "onNewIntent", new Object[0]);
        buildMessage(intent);
    }
}
