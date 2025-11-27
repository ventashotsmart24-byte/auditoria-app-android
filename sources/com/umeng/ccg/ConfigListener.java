package com.umeng.ccg;

import org.json.JSONObject;

public interface ConfigListener {
    void onConfigReady(JSONObject jSONObject);
}
