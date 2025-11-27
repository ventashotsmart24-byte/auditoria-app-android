package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import org.json.JSONObject;

public class AesBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AesBean> CREATOR = new Parcelable.Creator<AesBean>() {
        public AesBean createFromParcel(Parcel parcel) {
            return new AesBean(parcel);
        }

        public AesBean[] newArray(int i10) {
            return new AesBean[i10];
        }
    };
    private static final String TAG = "AesBean";
    private String iv;
    private String key;
    private int mode;

    public AesBean() {
    }

    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.KEY_MODE, this.mode);
            jSONObject.put("key", this.key);
            jSONObject.put("iv", this.iv);
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
        return jSONObject;
    }

    public String getIv() {
        return this.iv;
    }

    public String getKey() {
        return this.key;
    }

    public int getMode() {
        return this.mode;
    }

    public void setIv(String str) {
        this.iv = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMode(int i10) {
        this.mode = i10;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mode);
        parcel.writeString(this.key);
        parcel.writeString(this.iv);
    }

    public AesBean(Parcel parcel) {
        this.mode = parcel.readInt();
        this.key = parcel.readString();
        this.iv = parcel.readString();
    }

    public AesBean clone() {
        try {
            AesBean aesBean = new AesBean();
            aesBean.mode = this.mode;
            aesBean.key = this.key;
            aesBean.iv = this.iv;
            return aesBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
