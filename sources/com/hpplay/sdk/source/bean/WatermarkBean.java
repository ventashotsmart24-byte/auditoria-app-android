package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WatermarkBean implements Parcelable {
    public static final Parcelable.Creator<WatermarkBean> CREATOR = new Parcelable.Creator<WatermarkBean>() {
        public WatermarkBean createFromParcel(Parcel parcel) {
            return new WatermarkBean(parcel);
        }

        public WatermarkBean[] newArray(int i10) {
            return new WatermarkBean[i10];
        }
    };
    private static final String TAG = "WatermarkBean";
    public int sourceId = -1;
    public String sourcePath;
    public float xPositionRatio = -1.0f;
    public float yPositionRatio = -1.0f;

    public WatermarkBean() {
    }

    public static WatermarkBean formJson(String str) {
        try {
            WatermarkBean watermarkBean = new WatermarkBean();
            JSONObject jSONObject = new JSONObject(str);
            watermarkBean.xPositionRatio = (float) jSONObject.optDouble("xPositionRatio");
            watermarkBean.yPositionRatio = (float) jSONObject.optDouble("yPositionRatio");
            watermarkBean.sourceId = jSONObject.optInt("sourceId");
            watermarkBean.sourcePath = jSONObject.optString("sourcePath");
            return watermarkBean;
        } catch (JSONException e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toJson() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("xPositionRatio", (double) this.xPositionRatio);
            jSONObject.put("yPositionRatio", (double) this.yPositionRatio);
            jSONObject.put("sourceId", this.sourceId);
            jSONObject.put("sourcePath", this.sourcePath);
            return jSONObject.toString();
        } catch (JSONException e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return "";
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.xPositionRatio);
        parcel.writeFloat(this.yPositionRatio);
        parcel.writeInt(this.sourceId);
        parcel.writeString(this.sourcePath);
    }

    public WatermarkBean(Parcel parcel) {
        this.xPositionRatio = parcel.readFloat();
        this.yPositionRatio = parcel.readFloat();
        this.sourceId = parcel.readInt();
        this.sourcePath = parcel.readString();
    }
}
