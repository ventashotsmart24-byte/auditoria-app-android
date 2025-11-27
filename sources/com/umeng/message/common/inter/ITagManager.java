package com.umeng.message.common.inter;

import com.umeng.analytics.pro.bt;
import org.json.JSONObject;

public interface ITagManager {
    public static final String FAIL = "fail";
    public static final String SUCCESS = "ok";

    public static class Result {
        public String errors = "";
        public long interval = 0;
        public String jsonString = "";
        public int remain = 0;
        public String status = ITagManager.FAIL;

        public Result() {
        }

        public void setErrors(String str) {
            this.errors = str;
        }

        public String toString() {
            return this.jsonString;
        }

        public Result(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.jsonString = jSONObject.toString();
                this.status = jSONObject.optString("success", ITagManager.FAIL);
                this.remain = jSONObject.optInt("remain", 0);
                this.interval = jSONObject.optLong(bt.f13907ba, 0);
                this.errors = jSONObject.optString("errors");
            }
        }
    }
}
