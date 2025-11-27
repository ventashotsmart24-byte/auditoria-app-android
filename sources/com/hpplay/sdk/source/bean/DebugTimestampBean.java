package com.hpplay.sdk.source.bean;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class DebugTimestampBean {
    public AtomicInteger audioReadSerial;
    public AtomicInteger audioWriteSerial;
    private ConcurrentHashMap<Integer, DebugTimestampInfoBean> mAudioTSFrames;
    private ConcurrentHashMap<Integer, DebugTimestampInfoBean> mVideoTSFrames;
    public AtomicInteger videoReadSerial;
    public AtomicInteger videoWriteSerial;

    public DebugTimestampBean() {
        this.mAudioTSFrames = null;
        this.mVideoTSFrames = null;
        this.mAudioTSFrames = new ConcurrentHashMap<>();
        this.mVideoTSFrames = new ConcurrentHashMap<>();
        this.audioWriteSerial = new AtomicInteger();
        this.videoWriteSerial = new AtomicInteger();
        this.audioReadSerial = new AtomicInteger(1);
        this.videoReadSerial = new AtomicInteger(1);
    }

    public ConcurrentHashMap<Integer, DebugTimestampInfoBean> getAudioTSFrames() {
        return this.mAudioTSFrames;
    }

    public ConcurrentHashMap<Integer, DebugTimestampInfoBean> getVideoTSFrames() {
        return this.mVideoTSFrames;
    }
}
