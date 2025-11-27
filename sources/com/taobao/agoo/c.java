package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

public class c implements BaseNotifyClickActivity.INotifyListener {
    public String getMsgSource() {
        return "meizu";
    }

    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(AgooConstants.MESSAGE_MEIZU_PAYLOAD);
        } catch (Throwable th) {
            ALog.e("DefaultMeizu", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
