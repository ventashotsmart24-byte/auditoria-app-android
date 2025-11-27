package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import org.android.agoo.common.AgooConstants;

public class e implements BaseNotifyClickActivity.INotifyListener {
    public String getMsgSource() {
        return "vivo";
    }

    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra(AgooConstants.MESSAGE_VIVO_PAYLOAD);
        } catch (Throwable th) {
            ALog.e("DefaultVivo", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
