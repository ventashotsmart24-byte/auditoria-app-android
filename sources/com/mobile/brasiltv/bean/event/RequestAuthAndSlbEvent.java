package com.mobile.brasiltv.bean.event;

import mobile.com.requestframe.utils.response.UserData;
import t9.g;

public final class RequestAuthAndSlbEvent {
    private boolean isNeedGetAuthInfo;
    private UserData userData;

    public RequestAuthAndSlbEvent() {
        this(false, (UserData) null, 3, (g) null);
    }

    public final UserData getUserData() {
        return this.userData;
    }

    public final boolean isNeedGetAuthInfo() {
        return this.isNeedGetAuthInfo;
    }

    public final void setNeedGetAuthInfo(boolean z10) {
        this.isNeedGetAuthInfo = z10;
    }

    public final void setUserData(UserData userData2) {
        this.userData = userData2;
    }

    public RequestAuthAndSlbEvent(boolean z10, UserData userData2) {
        this.isNeedGetAuthInfo = z10;
        this.userData = userData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RequestAuthAndSlbEvent(boolean z10, UserData userData2, int i10, g gVar) {
        this((i10 & 1) != 0 ? true : z10, (i10 & 2) != 0 ? null : userData2);
    }
}
