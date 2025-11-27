package com.mobile.brasiltv.bean.event;

import t9.g;

public final class LoginSuccessEvent {
    private String heartBeatTime;

    public LoginSuccessEvent() {
        this((String) null, 1, (g) null);
    }

    public final String getHeartBeatTime() {
        return this.heartBeatTime;
    }

    public final void setHeartBeatTime(String str) {
        this.heartBeatTime = str;
    }

    public LoginSuccessEvent(String str) {
        this.heartBeatTime = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LoginSuccessEvent(String str, int i10, g gVar) {
        this((i10 & 1) != 0 ? null : str);
    }
}
