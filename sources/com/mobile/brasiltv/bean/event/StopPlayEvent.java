package com.mobile.brasiltv.bean.event;

import com.hpplay.component.protocol.push.IPushHandler;
import t9.i;

public final class StopPlayEvent {
    private Reason reason;

    public enum Reason {
        SCREEN_OFF,
        PRESS_HOME
    }

    public StopPlayEvent(Reason reason2) {
        i.g(reason2, IPushHandler.REASON);
        this.reason = reason2;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final void setReason(Reason reason2) {
        i.g(reason2, "<set-?>");
        this.reason = reason2;
    }
}
