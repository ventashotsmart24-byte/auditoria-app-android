package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

public class MicroAppInfoBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<MicroAppInfoBean> CREATOR = new Parcelable.Creator<MicroAppInfoBean>() {
        public MicroAppInfoBean createFromParcel(Parcel parcel) {
            return new MicroAppInfoBean(parcel);
        }

        public MicroAppInfoBean[] newArray(int i10) {
            return new MicroAppInfoBean[i10];
        }
    };
    public String appid;
    public String loginInfos;
    public int manifestVer;
    public String pluginProof;
    public String pluginUrl;
    public int type;

    public MicroAppInfoBean() {
    }

    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", this.manifestVer);
            jSONObject.put("type", this.type);
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, this.appid);
            jSONObject.put("pluginUrl", this.pluginUrl);
            jSONObject.put("pluginProof", this.pluginProof);
            jSONObject.put("loginInfos", this.loginInfos);
        } catch (Exception e10) {
            SourceLog.w("MicroAppInfoBean", (Throwable) e10);
        }
        return jSONObject;
    }

    public String getAppid() {
        return this.appid;
    }

    public String getLoginInfos() {
        return this.loginInfos;
    }

    public String getPluginProof() {
        return this.pluginProof;
    }

    public String getPluginUrl() {
        return this.pluginUrl;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setLoginInfos(String str) {
        this.loginInfos = str;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
    }

    public void setPluginProof(String str) {
        this.pluginProof = str;
    }

    public void setPluginUrl(String str) {
        this.pluginUrl = str;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.appid);
        parcel.writeInt(this.type);
        parcel.writeString(this.pluginUrl);
        parcel.writeString(this.pluginProof);
        parcel.writeString(this.loginInfos);
    }

    public MicroAppInfoBean(Parcel parcel) {
        this.appid = parcel.readString();
        this.type = parcel.readInt();
        this.pluginUrl = parcel.readString();
        this.pluginProof = parcel.readString();
        this.loginInfos = parcel.readString();
    }

    public MicroAppInfoBean clone() {
        try {
            MicroAppInfoBean microAppInfoBean = new MicroAppInfoBean();
            microAppInfoBean.manifestVer = this.manifestVer;
            microAppInfoBean.appid = this.appid;
            microAppInfoBean.type = this.type;
            microAppInfoBean.pluginUrl = this.pluginUrl;
            microAppInfoBean.pluginProof = this.pluginProof;
            microAppInfoBean.loginInfos = this.loginInfos;
            return microAppInfoBean;
        } catch (Exception e10) {
            SourceLog.w("Micro", (Throwable) e10);
            return null;
        }
    }
}
