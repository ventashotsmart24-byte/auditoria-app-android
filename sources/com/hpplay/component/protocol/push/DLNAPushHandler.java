package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.xml.XML;
import java.net.URLDecoder;
import org.json.JSONException;
import org.json.JSONObject;

public class DLNAPushHandler extends IPushHandler {
    private static final String CMD_TAG = "LLL@BBB";
    private static final String TAG = "DLNAPushHandler";

    public DLNAPushHandler(ParamsMap paramsMap) {
        super(paramsMap);
    }

    private String getMetaData(String str, String str2) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (str.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            str = str.substring(0, str.length() - 1);
        }
        if (!TextUtils.isEmpty(this.mediaAssetName)) {
            str3 = this.mediaAssetName;
        } else {
            str3 = "DLNA-Video";
        }
        try {
            str = URLDecoder.decode(str, XML.CHARSET_UTF8);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        try {
            str = (String) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_ESCAPEXMLCHARS, str);
        } catch (Exception e11) {
            CLog.w(TAG, (Throwable) e11);
        }
        String str7 = "0";
        if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_VIDEO)) {
            ProtocolBuilder dlnaContentUri = new ProtocolBuilder().setDlnaContentUri(this.mPushUri);
            if (TextUtils.isEmpty(this.dlnaID)) {
                str6 = str7;
            } else {
                str6 = this.dlnaID;
            }
            str7 = dlnaContentUri.setId(str6).setDcTitle(str3).setArtist(this.dlnaArtist).setCreator(this.dlnaCreator).setSize(this.dlnaSize).setChannelId(this.mAppid).setParentId(this.parentId).setDuration(this.dlnaDuration).setResolution(this.dlnaResolution).setDlnaUid(this.mUid).setDlnaSessionId(this.mSessionId).setParentId(this.parentId).setRestricted(str7).setUPNPclass(ProtocolBuilder.UPNP_VIDEO_ITEM_CLASS).setProtocolInfo(ProtocolBuilder.PROTOCOLINFO_VIDEO_VALUE).setPath(str).getVideoMetaData().getString(false);
        } else if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_IMAGE)) {
            str7 = new ProtocolBuilder().setDlnaContentUri(this.mPushUri).setDlnaSessionId(this.mSessionId).setPath(str).setSize(0).getImageMetaData().getString(false);
        } else if (str2.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
            if (!TextUtils.isEmpty(this.mediaAssetName)) {
                str4 = this.mediaAssetName;
            } else {
                str4 = "DLNA-Music";
            }
            String str8 = null;
            if (!TextUtils.isEmpty(this.dlnaAlbumUrl)) {
                try {
                    str8 = URLDecoder.decode(this.dlnaAlbumUrl, XML.CHARSET_UTF8);
                } catch (Exception e12) {
                    CLog.w(TAG, (Throwable) e12);
                }
                try {
                    str8 = (String) ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_ESCAPEXMLCHARS, str8);
                } catch (Exception e13) {
                    CLog.w(TAG, (Throwable) e13);
                }
            }
            ProtocolBuilder dlnaContentUri2 = new ProtocolBuilder().setDlnaContentUri(this.mPushUri);
            if (TextUtils.isEmpty(this.dlnaID)) {
                str5 = str7;
            } else {
                str5 = this.dlnaID;
            }
            str7 = dlnaContentUri2.setId(str5).setDcTitle(str4).setAlbum(this.dlnaAlbum).setChannelId(this.mAppid).setParentId(this.parentId).setAlbumUrl(str8).setArtist(this.dlnaArtist).setCreator(this.dlnaCreator).setSize(this.dlnaSize).setDuration(this.dlnaDuration).setDlnaUid(this.mUid).setDlnaSessionId(this.mSessionId).setParentId(str7).setRestricted(str7).setUPNPclass(ProtocolBuilder.UPNP_AUDIO_ITEM_CLASS).setProtocolInfo(ProtocolBuilder.PROTOCOLINFO_AUDIO_VALUE).setPath(str).getAudioMetaData().getString(false);
        }
        CLog.i(TAG, "metaData---> " + str7);
        return str7;
    }

    public String buildDecreaseVolume() {
        return IDLNAController.DEC_VOLUME;
    }

    public String buildGetPlayInfo() {
        return IDLNAController.GET_POSITION_INFO;
    }

    public String buildGetStateInfo() {
        return IDLNAController.GET_TRANSPORT_INFO;
    }

    public String buildIncreaseVolume() {
        return IDLNAController.INC_VOLUME;
    }

    public String buildPause() {
        return IDLNAController.PAUSE;
    }

    public String buildPush(String str, ParamsMap paramsMap) {
        String str2 = (String) paramsMap.get(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        String stringParam = paramsMap.getStringParam(ParamsMap.PushParams.KEY_DLNA_META_DATA);
        if (paramsMap.containsKey(ParamsMap.PushParams.KEY_START_POSITION)) {
            this.mStartPosition = Integer.parseInt(paramsMap.get(ParamsMap.PushParams.KEY_START_POSITION).toString());
        }
        if (TextUtils.isEmpty(stringParam)) {
            stringParam = getMetaData(str, str2);
        }
        return "PlayLLL@BBB" + str + CMD_TAG + stringParam + CMD_TAG + this.mStartPosition;
    }

    public String buildResume() {
        return IDLNAController.RESUME;
    }

    public String buildSeekTo(int i10) {
        return "SeekLLL@BBB" + i10;
    }

    public String buildStopPlay() {
        return IDLNAController.STOP;
    }

    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            protocolListener.onResult(i10, jSONObject.optString("duration"), jSONObject.optString("position"), jSONObject.optString("url"));
            return true;
        } catch (JSONException e10) {
            CLog.w(TAG, (Throwable) e10);
            return false;
        }
    }

    public void retryHttp(boolean z10) {
        try {
            ModuleLinker.getInstance().callMethod(ModuleIds.METHOD_DLNACONTROLLERIMP_RETRYHTTP, Boolean.valueOf(z10));
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public String setVolume(int i10) {
        return "SetVolumeLLL@BBB" + i10;
    }
}
