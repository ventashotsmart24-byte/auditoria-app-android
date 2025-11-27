package com.hpplay.sdk.source.bean;

import org.json.JSONObject;

public class PassSinkAuthBean {
    public boolean cm;
    public boolean enterprise;

    public PassSinkAuthBean(JSONObject jSONObject) {
        decode(jSONObject);
    }

    public void decode(JSONObject jSONObject) {
        boolean z10;
        int optInt = jSONObject.optInt("enterprise");
        int optInt2 = jSONObject.optInt("cm");
        boolean z11 = false;
        if (optInt == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.enterprise = z10;
        if (optInt2 == 1) {
            z11 = true;
        }
        this.cm = z11;
    }
}
