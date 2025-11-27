package com.hpplay.sdk.source.bean;

import com.hpplay.sdk.source.log.SourceLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SinkServerDeviceBean {
    public static String TAG = "SinkServerDeviceBean";
    public String dlna_model_description;
    public String dlna_model_name;
    public String dlna_uuid;
    public String receiver_lebo_uuid;
    public String receiver_manufacturer;
    public String receiver_sdk_channel;
    public String receiver_sdk_user_id;
    public String receiver_sdk_version;

    public static String listToJsonString(List<SinkServerDeviceBean> list) {
        if (list == null || list.size() < 1) {
            SourceLog.w(TAG, "listToJsonString,value is invalid");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (SinkServerDeviceBean next : list) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("receiver_sdk_channel", next.receiver_sdk_channel);
                jSONObject.put("receiver_sdk_user_id", next.receiver_sdk_user_id);
                jSONObject.put("receiver_sdk_version", next.receiver_sdk_version);
                jSONObject.put("receiver_lebo_uuid", next.receiver_lebo_uuid);
                jSONObject.put("receiver_manufacturer", next.receiver_manufacturer);
                jSONObject.put("dlna_model_description", next.dlna_model_description);
                jSONObject.put("dlna_uuid", next.dlna_uuid);
                jSONObject.put("dlna_model_name", next.dlna_model_name);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }
}
