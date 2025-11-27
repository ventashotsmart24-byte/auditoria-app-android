package com.hpplay.sdk.source.pass.bean;

import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

public class RateQueryBean extends BaseBean {
    private static final String TAG = "RateQueryBean";

    public RateQueryBean() {
        this.manifestVer = 1;
    }

    public String toJson() {
        try {
            new JSONObject().put("manifestVer", this.manifestVer);
            return null;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
