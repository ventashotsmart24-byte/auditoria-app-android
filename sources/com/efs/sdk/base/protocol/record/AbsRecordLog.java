package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.protocol.AbsLog;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsRecordLog extends AbsLog {
    protected HashMap<String, Object> dataMap = new HashMap<>();

    public AbsRecordLog(String str) {
        super(str);
    }

    public int getBodyType() {
        return 0;
    }

    public String getFilePath() {
        return null;
    }

    public byte getLogProtocol() {
        return 1;
    }

    public void put(String str, Object obj) {
        this.dataMap.put(str, obj);
    }

    public void putMap(Map<String, Object> map) {
        this.dataMap.putAll(map);
    }

    public void putNum(String str, long j10) {
        this.dataMap.put(ILogProtocol.KEY_PREFIX_NUM.concat(String.valueOf(str)), Long.valueOf(j10));
    }

    public void putString(String str, String str2) {
        this.dataMap.put(ILogProtocol.KEY_PREFIX_STRING.concat(String.valueOf(str)), str2);
    }

    public void putTimestamp(String str, long j10) {
        this.dataMap.put(ILogProtocol.KEY_PREFIX_TIMESTAMP.concat(String.valueOf(str)), Long.valueOf(j10));
    }
}
