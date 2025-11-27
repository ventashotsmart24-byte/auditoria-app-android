package com.hpplay.sdk.source.pass.sinktouch;

import com.hpplay.sdk.source.bean.SinkTouchEvent;

public interface ISinkTouchEventCallback {
    void onEventReceived(SinkTouchEvent sinkTouchEvent);
}
