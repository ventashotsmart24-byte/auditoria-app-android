package com.hpplay.sdk.source.bean;

public class StrategyBean {
    static StrategyBean instance = new StrategyBean();
    int cumulativeNumber = 5;
    long duration = 300000;
    int intervalCount = 8;
    long timeout = 1000;
    int toastStatus = 0;

    public static StrategyBean getInstance() {
        return instance;
    }

    public int getCumulativeNumber() {
        return this.cumulativeNumber;
    }

    public long getDuration() {
        return this.duration;
    }

    public int getIntervalCount() {
        return this.intervalCount;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public int getToastStatus() {
        return this.toastStatus;
    }

    public void setCumulativeNumber(int i10) {
        this.cumulativeNumber = i10;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setIntervalCount(int i10) {
        this.intervalCount = i10;
    }

    public void setTimeout(long j10) {
        this.timeout = j10;
    }

    public void setToastStatus(int i10) {
        this.toastStatus = i10;
    }
}
