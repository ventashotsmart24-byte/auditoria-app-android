package com.efs.sdk.base.protocol;

public abstract class AbsLog implements ILogProtocol {
    private String cp = "none";
    private byte de = 1;
    private String logType;

    public AbsLog(String str) {
        this.logType = str;
    }

    public String getLogType() {
        return this.logType;
    }

    public boolean isCp() {
        if (!this.cp.equals("none")) {
            return true;
        }
        return false;
    }

    public boolean isDe() {
        if (this.de != 1) {
            return true;
        }
        return false;
    }

    public void setCp(String str) {
        this.cp = str;
    }

    public void setDe(byte b10) {
        this.de = b10;
    }
}
