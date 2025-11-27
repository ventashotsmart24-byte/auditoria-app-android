package com.umeng.message.api;

import android.content.Context;
import com.umeng.message.entity.UMessage;

public interface UPushMessageHandler {
    void handleMessage(Context context, UMessage uMessage);
}
