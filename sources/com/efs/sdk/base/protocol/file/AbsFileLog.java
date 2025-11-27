package com.efs.sdk.base.protocol.file;

import com.efs.sdk.base.protocol.AbsLog;

public abstract class AbsFileLog extends AbsLog {
    public AbsFileLog(String str) {
        super(str);
    }

    public int getBodyType() {
        return 0;
    }

    public String getFilePath() {
        return null;
    }

    public byte getLogProtocol() {
        return 2;
    }
}
