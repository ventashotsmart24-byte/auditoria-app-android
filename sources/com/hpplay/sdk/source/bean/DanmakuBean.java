package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.log.SourceLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONObject;

public class DanmakuBean implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DanmakuBean> CREATOR = new Parcelable.Creator<DanmakuBean>() {
        public DanmakuBean createFromParcel(Parcel parcel) {
            return new DanmakuBean(parcel);
        }

        public DanmakuBean[] newArray(int i10) {
            return new DanmakuBean[i10];
        }
    };
    private static final String TAG = "DanmakuBean";
    private int columSpace;
    private String content;
    private long displayTime;
    private String fontColor;
    private int fontSize;
    private boolean immShow;

    public DanmakuBean() {
    }

    public int describeContents() {
        return 0;
    }

    public void setColumSpace(int i10) {
        this.columSpace = i10;
    }

    public void setContent(String str) {
        try {
            this.content = URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (UnsupportedEncodingException e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    public void setDisplayTime(long j10) {
        this.displayTime = j10;
    }

    public void setFontColor(String str) {
        this.fontColor = str;
    }

    public void setFontSize(int i10) {
        this.fontSize = i10;
    }

    public void setImmShow(boolean z10) {
        this.immShow = z10;
    }

    public String toJson(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("manifestVer", i10);
            jSONObject.put("danmukuId", UUID.randomUUID().toString());
            jSONObject.put("content", this.content);
            jSONObject.put("displayTime", this.displayTime);
            jSONObject.put("fontSize", this.fontSize);
            jSONObject.put("fontColor", this.fontColor);
            jSONObject.put("columSpace", this.columSpace);
            jSONObject.put("immShow", this.immShow);
            jSONObject.put("uri", str);
            SourceLog.i(TAG, jSONObject.toString());
            return jSONObject.toString();
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.content);
        parcel.writeString(this.fontColor);
        parcel.writeLong(this.displayTime);
        parcel.writeInt(this.fontSize);
        parcel.writeInt(this.columSpace);
        parcel.writeByte(this.immShow ? (byte) 1 : 0);
    }

    public DanmakuBean(Parcel parcel) {
        this.content = parcel.readString();
        this.fontColor = parcel.readString();
        this.displayTime = parcel.readLong();
        this.fontSize = parcel.readInt();
        this.columSpace = parcel.readInt();
        this.immShow = parcel.readByte() != 0;
    }

    public DanmakuBean clone() {
        try {
            DanmakuBean danmakuBean = new DanmakuBean();
            danmakuBean.content = this.content;
            danmakuBean.fontColor = this.fontColor;
            danmakuBean.displayTime = this.displayTime;
            danmakuBean.fontSize = this.fontSize;
            danmakuBean.columSpace = this.columSpace;
            danmakuBean.immShow = this.immShow;
            return danmakuBean;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }
}
