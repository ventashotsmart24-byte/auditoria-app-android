package com.hpplay.sdk.source.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.log.SourceLog;
import org.json.JSONObject;

public class ReceiverProperties implements Parcelable {
    public static final Parcelable.Creator<ReceiverProperties> CREATOR = new Parcelable.Creator<ReceiverProperties>() {
        public ReceiverProperties createFromParcel(Parcel parcel) {
            return new ReceiverProperties(parcel);
        }

        public ReceiverProperties[] newArray(int i10) {
            return new ReceiverProperties[i10];
        }
    };
    private static final String TAG = "ReceiverProperties";
    public int isSupport;
    public int playMode;
    public int player;
    public int rotateAngle;

    public ReceiverProperties() {
    }

    public static ReceiverProperties fromJson(String str) {
        ReceiverProperties receiverProperties = new ReceiverProperties();
        try {
            JSONObject jSONObject = new JSONObject(str);
            receiverProperties.isSupport = jSONObject.optInt("isSupport");
            receiverProperties.player = jSONObject.optInt("player");
            receiverProperties.playMode = jSONObject.optInt("playMode");
            receiverProperties.rotateAngle = jSONObject.optInt("rotateAngle");
            return receiverProperties;
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ReceiverProperties{isSupport=" + this.isSupport + ", player=" + this.player + ", playMode=" + this.playMode + ", rotateAngle=" + this.rotateAngle + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.player);
        parcel.writeInt(this.playMode);
        parcel.writeInt(this.rotateAngle);
        parcel.writeInt(this.isSupport);
    }

    public ReceiverProperties(Parcel parcel) {
        this.player = parcel.readInt();
        this.playMode = parcel.readInt();
        this.rotateAngle = parcel.readInt();
        this.isSupport = parcel.readInt();
    }
}
