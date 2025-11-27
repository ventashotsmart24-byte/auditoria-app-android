package com.mobile.brasiltv.bean;

import anet.channel.strategy.dispatch.DispatchConstants;
import mobile.com.requestframe.utils.response.Channel;
import t9.i;

public final class SearchBean implements Comparable<SearchBean> {
    private Channel channel;

    /* renamed from: i  reason: collision with root package name */
    private int f12267i;

    public SearchBean(int i10, Channel channel2) {
        i.g(channel2, "channel");
        this.f12267i = i10;
        this.channel = channel2;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final int getI() {
        return this.f12267i;
    }

    public final void setChannel(Channel channel2) {
        i.g(channel2, "<set-?>");
        this.channel = channel2;
    }

    public final void setI(int i10) {
        this.f12267i = i10;
    }

    public int compareTo(SearchBean searchBean) {
        i.g(searchBean, DispatchConstants.OTHER);
        return this.f12267i - searchBean.f12267i;
    }
}
