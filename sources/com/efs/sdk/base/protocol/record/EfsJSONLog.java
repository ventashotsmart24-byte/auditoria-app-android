package com.efs.sdk.base.protocol.record;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.config.GlobalInfo;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import org.json.JSONObject;

public class EfsJSONLog extends AbsRecordLog {
    private long beginTime;
    private long endTime;

    public EfsJSONLog(String str) {
        super(str);
        put("type", str);
    }

    public byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    public String generateString() {
        return new JSONObject(this.dataMap).toString();
    }

    public String getLinkId() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_ID)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_ID));
        }
        return null;
    }

    public String getLinkKey() {
        if (this.dataMap.containsKey(Constants.LOG_KEY_LINK_KEY)) {
            return String.valueOf(this.dataMap.get(Constants.LOG_KEY_LINK_KEY));
        }
        return null;
    }

    public long getLogBeginTime() {
        return this.beginTime;
    }

    public long getLogEndTime() {
        return this.endTime;
    }

    public void insertGlobal(GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    public void setLogBeginTime(long j10) {
        this.beginTime = j10;
    }

    public void setLogEndTime(long j10) {
        this.endTime = j10;
    }
}
