package com.taobao.agoo;

import android.content.Intent;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;

public class b implements BaseNotifyClickActivity.INotifyListener {
    public String getMsgSource() {
        return "huawei";
    }

    public String parseMsgFromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            return intent.getStringExtra("extras");
        } catch (Throwable th) {
            ALog.e("DefaultHuaWei", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
