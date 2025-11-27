package com.mobile.brasiltv.bean.event;

import t9.i;

public final class SubTitleDownloadFinishEvent {
    private String contentId;

    public SubTitleDownloadFinishEvent(String str) {
        i.g(str, "contentId");
        this.contentId = str;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }
}
