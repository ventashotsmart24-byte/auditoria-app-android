package com.mobile.brasiltv.bean.event;

import mobile.com.requestframe.utils.response.Channel;
import t9.i;

public final class ClickSearchChannelEvent {
    private Channel channel;

    public ClickSearchChannelEvent(Channel channel2) {
        i.g(channel2, "channel");
        this.channel = channel2;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final void setChannel(Channel channel2) {
        i.g(channel2, "<set-?>");
        this.channel = channel2;
    }
}
