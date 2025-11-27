package com.umeng.message.api;

import android.content.Context;
import com.umeng.message.entity.UMessage;

public interface UPushInAppMessageCallback {
    void onClick(Context context, UMessage uMessage);

    void onDismiss(Context context, UMessage uMessage);

    void onShow(Context context, UMessage uMessage);
}
