package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.soap.SOAP;
import org.json.JSONObject;

public class LelinkPushHandler extends IPushHandler {
    private static final String TAG = "LelinkPushHandler";

    public LelinkPushHandler(ParamsMap paramsMap) {
        super(paramsMap);
    }

    public String buildDecreaseVolume() {
        return new ProtocolBuilder().getsubVolumeCmd().setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setContentLength("0").setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String buildGetPlayInfo() {
        return new ProtocolBuilder().getPositionCmd().setContentType(ProtocolBuilder.CONTENT_APPLE_PLAYLIST_TYPE).setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String buildGetStateInfo() {
        return null;
    }

    public String buildIncreaseVolume() {
        return new ProtocolBuilder().getaddVolumeCmd().setUserAgent(ProtocolBuilder.HAPPYCAST_AGENT).setContentLength("0").setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String buildPause() {
        return new ProtocolBuilder().getPauseCmd().setContentLength("0").setUserAgent(this.mUserAgent).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String buildPush(String str, ParamsMap paramsMap) {
        String str2;
        String str3;
        String str4 = str;
        ParamsMap paramsMap2 = paramsMap;
        CLog.i(TAG, "start ----------->" + this.mSessionId);
        if (paramsMap2.containsKey("screencode")) {
            str2 = (String) paramsMap2.get("screencode");
        } else {
            str2 = "";
        }
        if (paramsMap2.containsKey("header")) {
            str3 = (String) paramsMap2.get("header");
        } else {
            str3 = "";
        }
        String str5 = (String) paramsMap2.get(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        TextUtils.isEmpty(str2);
        ProtocolBuilder contentLocation = new ProtocolBuilder().setContentLocation(str4);
        String string = contentLocation.setStartPosition(this.mStartPosition + "").setContentUri(this.mPushUri).getString(true);
        ProtocolBuilder contentType = new ProtocolBuilder().getPlayCmd().setContentType(ProtocolBuilder.CONTENT_TEXT_TYPE);
        ProtocolBuilder contentLength = contentType.setContentLength(string.getBytes().length + "");
        boolean equals = str5.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO);
        String str6 = ProtocolBuilder.HAPPYCAST_AUDIO_AGENT;
        ProtocolBuilder platfrom = contentLength.setUserAgent(equals ? str6 : ProtocolBuilder.MEDIACONTROL_AGENT).setAutorization(str2).setUserLelinkSessionId(this.mSessionId).setPlatfrom();
        String string2 = platfrom.setMobileDeviceName(DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel()).setDevicesIMEI(this.mImei).setMobileDeviceChannel(this.mAppid).setLelinkDeviceId(this.mHid).setMobileDevCu(this.mUid).setDeviceType("Android").getString(true);
        if (!TextUtils.isEmpty(str3)) {
            JSONObject jSONObject = new JSONObject();
            String str7 = string2;
            try {
                jSONObject.put("mStartPosition", this.mStartPosition);
                jSONObject.put("playUrl", str4);
                jSONObject.put("urlId", this.mPushUri);
                jSONObject.put("header", str3);
                string = jSONObject.toString();
                try {
                    ProtocolBuilder contentType2 = new ProtocolBuilder().getSendVideoInfoCmd().setContentType(ProtocolBuilder.CONTENT_TEXT_TYPE);
                    ProtocolBuilder contentLength2 = contentType2.setContentLength(string.getBytes().length + "");
                    if (!str5.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
                        str6 = ProtocolBuilder.MEDIACONTROL_AGENT;
                    }
                    ProtocolBuilder platfrom2 = contentLength2.setUserAgent(str6).setUserLelinkSessionId(this.mSessionId).setPlatfrom();
                    string2 = platfrom2.setMobileDeviceName(DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel()).setDevicesIMEI(this.mImei).setMobileDeviceChannel(this.mAppid).setLelinkDeviceId(this.mHid).setMobileDevCu(this.mUid).setDeviceType("Android").getString(true);
                } catch (Exception e10) {
                    e = e10;
                    CLog.w(TAG, (Throwable) e);
                    string2 = str7;
                    return string2 + string;
                }
            } catch (Exception e11) {
                e = e11;
                string = string;
                CLog.w(TAG, (Throwable) e);
                string2 = str7;
                return string2 + string;
            }
        } else {
            String str8 = string2;
            String str9 = string;
        }
        return string2 + string;
    }

    public String buildResume() {
        return new ProtocolBuilder().getRecoverPlayCmd().setContentLength("0").setUserAgent(this.mUserAgent).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String buildSeekTo(int i10) {
        return String.format(new ProtocolBuilder().getSetPositionCmd().setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true), new Object[]{Integer.valueOf(i10)});
    }

    public String buildStopPlay() {
        CLog.i(TAG, "----------->" + this.mSessionId);
        return new ProtocolBuilder().getStopCmd().setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public String getReverseData() {
        return new ProtocolBuilder().getReverseCmd().setUpgradeKey(ProtocolBuilder.UPGRADE_PTTH).setConnectionKey("Upgrade").setApplePurposeKey("event").setContentLength("0").setUserAgent(ProtocolBuilder.MEDIACONTROL_AGENT).setUserLelinkSessionId(this.mSessionId).getString(true);
    }

    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        if (str.contains("duration:") && str.contains("position:")) {
            try {
                String trim = str.substring(str.lastIndexOf(SOAP.DELIM) + 1).trim();
                String substring = str.substring(0, str.lastIndexOf("position"));
                String trim2 = substring.substring(substring.lastIndexOf(SOAP.DELIM) + 1).trim();
                if (protocolListener != null) {
                    protocolListener.onResult(i10, trim2, trim);
                }
                return true;
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01db, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0156, code lost:
        r9 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0157, code lost:
        if (r9 == 0) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0159, code lost:
        if (r9 == 1) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015b, code lost:
        if (r9 == 2) goto L_0x018f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x015f, code lost:
        if (r9 == 3) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0161, code lost:
        if (r9 == 4) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0164, code lost:
        com.hpplay.component.common.utils.CLog.d(TAG, com.google.android.gms.cast.MediaError.ERROR_TYPE_ERROR);
        r8.disConnect();
        r8.eventCallback(16, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0176, code lost:
        r8.disConnect();
        com.hpplay.component.common.utils.CLog.d(TAG, "STOPPED ");
        r8.eventCallback(16, r3);
        com.hpplay.component.common.utils.CLog.d(TAG, "state on stop---------");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x018f, code lost:
        com.hpplay.component.common.utils.CLog.d(TAG, "PAUSED ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0198, code lost:
        if (r7.isPlaying == false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x019a, code lost:
        r8.eventCallback(15, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01a3, code lost:
        r7.isPlaying = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01a6, code lost:
        com.hpplay.component.common.utils.CLog.d(TAG, "LOADING");
        r8.eventCallback(14, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b9, code lost:
        if (r7.isPlaying != false) goto L_0x01c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01bb, code lost:
        r7.isPlaying = true;
        r8.eventCallback(13, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01c6, code lost:
        com.hpplay.component.common.utils.CLog.d(TAG, com.hpplay.component.dlna.DLNAControllerImp.PLAYING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ce, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl r8, java.lang.String... r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r9 == 0) goto L_0x01da
            r0 = 0
            r9 = r9[r0]     // Catch:{ all -> 0x01d7 }
            if (r9 != 0) goto L_0x000a
            goto L_0x01da
        L_0x000a:
            java.lang.String r1 = "LelinkPushHandler"
            com.hpplay.component.common.utils.CLog.d(r1, r9)     // Catch:{ all -> 0x01d7 }
            java.lang.String r1 = "Switching Protocols"
            boolean r1 = r9.contains(r1)     // Catch:{ all -> 0x01d7 }
            if (r1 == 0) goto L_0x0019
            monitor-exit(r7)
            return
        L_0x0019:
            java.lang.String r1 = "photohide"
            boolean r1 = r9.contains(r1)     // Catch:{ all -> 0x01d7 }
            if (r1 == 0) goto L_0x002d
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r0 = "on PHOTO_HIDE"
            com.hpplay.component.common.utils.CLog.d(r9, r0)     // Catch:{ all -> 0x01d7 }
            r8.disConnect()     // Catch:{ all -> 0x01d7 }
            monitor-exit(r7)
            return
        L_0x002d:
            byte[] r9 = r9.getBytes()     // Catch:{ Exception -> 0x01cf }
            com.hpplay.component.protocol.plist.NSObject r9 = com.hpplay.component.protocol.plist.PropertyListParser.parse((byte[]) r9)     // Catch:{ Exception -> 0x01cf }
            com.hpplay.component.protocol.plist.NSDictionary r9 = (com.hpplay.component.protocol.plist.NSDictionary) r9     // Catch:{ Exception -> 0x01cf }
            if (r9 == 0) goto L_0x01cd
            java.lang.String r1 = "0"
            java.lang.String r2 = "0"
            java.lang.String r3 = ""
            java.lang.String r4 = "urlID"
            boolean r4 = r9.containsKey((java.lang.String) r4)     // Catch:{ all -> 0x01d7 }
            if (r4 == 0) goto L_0x0051
            java.lang.String r3 = "urlID"
            com.hpplay.component.protocol.plist.NSObject r3 = r9.objectForKey(r3)     // Catch:{ all -> 0x01d7 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x01d7 }
        L_0x0051:
            java.lang.String r4 = "duration"
            java.lang.String r4 = r7.upperFirstChar(r4)     // Catch:{ all -> 0x01d7 }
            java.lang.String r5 = "position"
            java.lang.String r5 = r7.upperFirstChar(r5)     // Catch:{ all -> 0x01d7 }
            boolean r6 = r9.containsKey((java.lang.String) r4)     // Catch:{ all -> 0x01d7 }
            if (r6 == 0) goto L_0x006b
            com.hpplay.component.protocol.plist.NSObject r1 = r9.objectForKey(r4)     // Catch:{ all -> 0x01d7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d7 }
        L_0x006b:
            boolean r4 = r9.containsKey((java.lang.String) r5)     // Catch:{ all -> 0x01d7 }
            if (r4 == 0) goto L_0x0079
            com.hpplay.component.protocol.plist.NSObject r2 = r9.objectForKey(r5)     // Catch:{ all -> 0x01d7 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01d7 }
        L_0x0079:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00b5 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00b5 }
            if (r4 <= 0) goto L_0x00bb
            java.lang.Integer r4 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x00b5 }
            int r4 = r4.intValue()     // Catch:{ Exception -> 0x00b5 }
            if (r4 <= 0) goto L_0x00bb
            java.lang.String r4 = "LelinkPushHandler"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b5 }
            r5.<init>()     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r6 = "reverse to uiduration : "
            r5.append(r6)     // Catch:{ Exception -> 0x00b5 }
            r5.append(r1)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r6 = "position : "
            r5.append(r6)     // Catch:{ Exception -> 0x00b5 }
            r5.append(r2)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x00b5 }
            com.hpplay.component.common.utils.CLog.d(r4, r5)     // Catch:{ Exception -> 0x00b5 }
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3}     // Catch:{ Exception -> 0x00b5 }
            r2 = 17
            r8.eventCallback(r2, r1)     // Catch:{ Exception -> 0x00b5 }
            goto L_0x00bb
        L_0x00b5:
            r1 = move-exception
            java.lang.String r2 = "LelinkPushHandler"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r1)     // Catch:{ all -> 0x01d7 }
        L_0x00bb:
            java.lang.String r1 = "stoptype"
            boolean r1 = r9.containsKey((java.lang.String) r1)     // Catch:{ all -> 0x01d7 }
            if (r1 == 0) goto L_0x0106
            java.lang.String r1 = "stoptype"
            com.hpplay.component.protocol.plist.NSObject r1 = r9.objectForKey(r1)     // Catch:{ all -> 0x01d7 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01d7 }
            java.lang.String r2 = "media_completion"
            boolean r2 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x01d7 }
            if (r2 == 0) goto L_0x00ea
            r8.disConnect()     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r0 = 12
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
            java.lang.String r8 = "LelinkPushHandler"
            java.lang.String r9 = "on completion"
            com.hpplay.component.common.utils.CLog.d(r8, r9)     // Catch:{ all -> 0x01d7 }
            monitor-exit(r7)
            return
        L_0x00ea:
            java.lang.String r2 = "phonevideohide"
            boolean r1 = android.text.TextUtils.equals(r1, r2)     // Catch:{ all -> 0x01d7 }
            if (r1 == 0) goto L_0x0106
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r0 = "on stop"
            com.hpplay.component.common.utils.CLog.d(r9, r0)     // Catch:{ all -> 0x01d7 }
            r8.disConnect()     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r0 = 7
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
            monitor-exit(r7)
            return
        L_0x0106:
            java.lang.String r1 = "state"
            boolean r1 = r9.containsKey((java.lang.String) r1)     // Catch:{ all -> 0x01d7 }
            if (r1 == 0) goto L_0x01cd
            java.lang.String r1 = "state"
            com.hpplay.component.protocol.plist.NSObject r9 = r9.objectForKey(r1)     // Catch:{ all -> 0x01d7 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x01d7 }
            int r1 = r9.hashCode()     // Catch:{ all -> 0x01d7 }
            r2 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1884319283: goto L_0x014c;
                case -995321554: goto L_0x0142;
                case -493563858: goto L_0x0138;
                case 96784904: goto L_0x012e;
                case 336650556: goto L_0x0124;
                default: goto L_0x0123;
            }     // Catch:{ all -> 0x01d7 }
        L_0x0123:
            goto L_0x0156
        L_0x0124:
            java.lang.String r1 = "loading"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x0156
            r9 = 1
            goto L_0x0157
        L_0x012e:
            java.lang.String r1 = "error"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x0156
            r9 = 4
            goto L_0x0157
        L_0x0138:
            java.lang.String r1 = "playing"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x0156
            r9 = 0
            goto L_0x0157
        L_0x0142:
            java.lang.String r1 = "paused"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x0156
            r9 = 2
            goto L_0x0157
        L_0x014c:
            java.lang.String r1 = "stopped"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x0156
            r9 = 3
            goto L_0x0157
        L_0x0156:
            r9 = -1
        L_0x0157:
            if (r9 == 0) goto L_0x01b7
            if (r9 == r6) goto L_0x01a6
            if (r9 == r5) goto L_0x018f
            r0 = 16
            if (r9 == r4) goto L_0x0176
            if (r9 == r2) goto L_0x0164
            goto L_0x01cd
        L_0x0164:
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r1 = "ERROR"
            com.hpplay.component.common.utils.CLog.d(r9, r1)     // Catch:{ all -> 0x01d7 }
            r8.disConnect()     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
            goto L_0x01cd
        L_0x0176:
            r8.disConnect()     // Catch:{ all -> 0x01d7 }
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r1 = "STOPPED "
            com.hpplay.component.common.utils.CLog.d(r9, r1)     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
            java.lang.String r8 = "LelinkPushHandler"
            java.lang.String r9 = "state on stop---------"
            com.hpplay.component.common.utils.CLog.d(r8, r9)     // Catch:{ all -> 0x01d7 }
            goto L_0x01cd
        L_0x018f:
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r1 = "PAUSED "
            com.hpplay.component.common.utils.CLog.d(r9, r1)     // Catch:{ all -> 0x01d7 }
            boolean r9 = r7.isPlaying     // Catch:{ all -> 0x01d7 }
            if (r9 == 0) goto L_0x01a3
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r1 = 15
            r8.eventCallback(r1, r9)     // Catch:{ all -> 0x01d7 }
        L_0x01a3:
            r7.isPlaying = r0     // Catch:{ all -> 0x01d7 }
            goto L_0x01cd
        L_0x01a6:
            java.lang.String r9 = "LelinkPushHandler"
            java.lang.String r0 = "LOADING"
            com.hpplay.component.common.utils.CLog.d(r9, r0)     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r0 = 14
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
            goto L_0x01cd
        L_0x01b7:
            boolean r9 = r7.isPlaying     // Catch:{ all -> 0x01d7 }
            if (r9 != 0) goto L_0x01c6
            r7.isPlaying = r6     // Catch:{ all -> 0x01d7 }
            java.lang.String[] r9 = new java.lang.String[]{r3}     // Catch:{ all -> 0x01d7 }
            r0 = 13
            r8.eventCallback(r0, r9)     // Catch:{ all -> 0x01d7 }
        L_0x01c6:
            java.lang.String r8 = "LelinkPushHandler"
            java.lang.String r9 = "PLAYING"
            com.hpplay.component.common.utils.CLog.d(r8, r9)     // Catch:{ all -> 0x01d7 }
        L_0x01cd:
            monitor-exit(r7)
            return
        L_0x01cf:
            r8 = move-exception
            java.lang.String r9 = "LelinkPushHandler"
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r9, (java.lang.Throwable) r8)     // Catch:{ all -> 0x01d7 }
            monitor-exit(r7)
            return
        L_0x01d7:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        L_0x01da:
            monitor-exit(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.push.LelinkPushHandler.parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl, java.lang.String[]):void");
    }

    public String setVolume(int i10) {
        return null;
    }

    public String upperFirstChar(String str) {
        if (str == null || "".equals(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 == 0) {
                stringBuffer.append(String.valueOf(charArray[0]).toUpperCase());
            } else {
                stringBuffer.append(charArray[i10]);
            }
        }
        return stringBuffer.toString();
    }
}
