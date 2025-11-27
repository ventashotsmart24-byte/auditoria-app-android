package com.hpplay.component.protocol.push;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.hpplay.sdk.source.bean.DramaInfoBean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LelinkV2PushHandler extends IPushHandler {
    private static final String TAG = "LelinkV2PushHandler";
    public static final int TYPE_APPEND_PLAYLIST = 2;
    public static final int TYPE_CLEAR_PLAYLIST = 3;
    public static final int TYPE_PLAY_ASSIGN = 6;
    public static final int TYPE_PLAY_NEXT = 5;
    public static final int TYPE_PLAY_PRE = 4;
    public static final int TYPE_SET_PLAYLIST = 1;
    private int cseq = -1;
    private String currentMediaType;

    public LelinkV2PushHandler(ParamsMap paramsMap) {
        super(paramsMap);
    }

    private String buildActionContent(ParamsMap paramsMap, int i10) {
        String str;
        String str2;
        int i11;
        int i12;
        ParamsMap paramsMap2 = paramsMap;
        int i13 = i10;
        PlistBuilder plistBuilder = new PlistBuilder();
        String str3 = "";
        if (i13 == 1) {
            str = "set-playlist";
        } else if (i13 == 2) {
            str = DramaInfoBean.APPEND_PLAY_LIST;
        } else if (i13 == 3) {
            str = DramaInfoBean.CLEAR_PLAY_LIST;
        } else if (i13 == 4) {
            str = "play_prev";
        } else if (i13 == 5) {
            str = "play_next";
        } else if (i13 == 6) {
            str = "play_assign";
        } else {
            str = str3;
        }
        plistBuilder.addStringToRoot(PlistBuilder.KEY_PROP_TYPE, str);
        if (paramsMap2 != null) {
            str3 = paramsMap2.getStringParam("category");
        }
        if (i13 == 2 || i13 == 1) {
            plistBuilder.addStringToRoot("curplayid", paramsMap2.getStringParam("curplayid")).addIntagerToRoot("period", paramsMap2.getIntParam("period")).addStringToRoot("category", str3).addIntagerToRoot(ParamsMap.PushParams.KEY_HEAD_DURATION, paramsMap2.getIntParam(ParamsMap.PushParams.KEY_HEAD_DURATION)).addIntagerToRoot(ParamsMap.PushParams.KEY_TAIL_DURATION, paramsMap2.getIntParam(ParamsMap.PushParams.KEY_TAIL_DURATION)).addStringToRoot("uuid", this.mPushUri);
            if (paramsMap2.getStringParam(ParamsMap.PushParams.KEY_MEDIA_TYPE).equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
                str2 = PlistBuilder.TYPE_AUDIO;
            } else {
                str2 = "video";
            }
            this.currentMediaType = str2;
            try {
                JSONArray jSONArray = ((JSONObject) paramsMap2.get(ParamsMap.PushParams.KEY_PLAY_LIST_JSON)).getJSONArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON);
                plistBuilder.createIPlistArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, jSONArray.length());
                int i14 = 0;
                while (i14 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i14);
                    plistBuilder.addStringToArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, i14, "name", jSONObject.optString("name"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("urls");
                    plistBuilder.createIPlistArray("urls", jSONArray2.length());
                    int i15 = 0;
                    while (i15 < jSONArray2.length()) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i15);
                        int optInt = jSONObject2.optInt("width");
                        JSONArray jSONArray3 = jSONArray;
                        int optInt2 = jSONObject2.optInt("height");
                        String optString = jSONObject2.optString("url");
                        JSONArray jSONArray4 = jSONArray2;
                        String optString2 = jSONObject2.optString("playid");
                        String optString3 = jSONObject2.optString("category");
                        plistBuilder.addIntagerToArray("urls", i15, "width", optInt);
                        plistBuilder.addIntagerToArray("urls", i15, "height", optInt2);
                        plistBuilder.addStringToArray("urls", i15, "url", optString);
                        plistBuilder.addStringToArray("urls", i15, "id", optString2);
                        plistBuilder.addStringToArray("urls", i15, "category", optString3);
                        i15++;
                        jSONArray = jSONArray3;
                        jSONArray2 = jSONArray4;
                    }
                    plistBuilder.addArrayToArray(ParamsMap.PushParams.KEY_PLAY_LIST_JSON, i14, "urls");
                    i14++;
                    jSONArray = jSONArray;
                }
                plistBuilder.addArrayToRoot(ParamsMap.PushParams.KEY_PLAY_LIST_JSON);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        } else if (i13 == 6) {
            String stringParam = paramsMap2.getStringParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME);
            String stringParam2 = paramsMap2.getStringParam("curplayid");
            String stringParam3 = paramsMap2.getStringParam("url");
            try {
                i11 = ((Integer) paramsMap2.get("width")).intValue();
                try {
                    i12 = ((Integer) paramsMap2.get("height")).intValue();
                } catch (Exception e11) {
                    e = e11;
                    CLog.w(TAG, (Throwable) e);
                    i12 = 0;
                    plistBuilder.addStringToRoot("name", stringParam);
                    plistBuilder.addStringToRoot("curplayid", stringParam2);
                    plistBuilder.addStringToRoot("url", stringParam3);
                    plistBuilder.addIntagerToRoot("width", i11);
                    plistBuilder.addIntagerToRoot("height", i12);
                    String potocol = plistBuilder.getPotocol();
                    CLog.i(TAG, " content : " + potocol);
                    return potocol;
                }
            } catch (Exception e12) {
                e = e12;
                i11 = 0;
                CLog.w(TAG, (Throwable) e);
                i12 = 0;
                plistBuilder.addStringToRoot("name", stringParam);
                plistBuilder.addStringToRoot("curplayid", stringParam2);
                plistBuilder.addStringToRoot("url", stringParam3);
                plistBuilder.addIntagerToRoot("width", i11);
                plistBuilder.addIntagerToRoot("height", i12);
                String potocol2 = plistBuilder.getPotocol();
                CLog.i(TAG, " content : " + potocol2);
                return potocol2;
            }
            plistBuilder.addStringToRoot("name", stringParam);
            plistBuilder.addStringToRoot("curplayid", stringParam2);
            plistBuilder.addStringToRoot("url", stringParam3);
            plistBuilder.addIntagerToRoot("width", i11);
            plistBuilder.addIntagerToRoot("height", i12);
        }
        String potocol22 = plistBuilder.getPotocol();
        CLog.i(TAG, " content : " + potocol22);
        return potocol22;
    }

    private String buildPlayContent(String str, ParamsMap paramsMap) {
        String str2;
        String str3;
        String stringParam = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_TYPE);
        String stringParam2 = paramsMap.getStringParam(ParamsMap.PushParams.KEY_MEDIA_ASSET_NAME);
        String stringParam3 = paramsMap.getStringParam("category");
        String stringParam4 = paramsMap.getStringParam("playid");
        if (stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO) || stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_VIDEO)) {
            if (stringParam.equals(ParamsMap.PushParams.MEDIA_TYPE_AUDIO)) {
                str3 = PlistBuilder.TYPE_AUDIO;
            } else {
                str3 = "video";
            }
            str2 = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, str3).createIPlistArray("items", 1).addIntagerToArray("items", 0, PlistBuilder.KEY_START_POSITION, this.mStartPosition).addStringToArray("items", 0, "uuid", this.mPushUri).addStringToArray("items", 0, PlistBuilder.KEY_CONTENT_LOCATION, str).addStringToArray("items", 0, "name", stringParam2).addStringToArray("items", 0, "category", stringParam3).addStringToArray("items", 0, "playid", stringParam4).addArrayToRoot("items").getPotocol();
        } else {
            PlistBuilder plistBuilder = new PlistBuilder();
            str3 = PlistBuilder.TYPE_IMAGE;
            str2 = plistBuilder.addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, str3).createIPlistArray("items", 1).addStringToArray("items", 0, "uuid", this.mPushUri).addStringToArray("items", 0, PlistBuilder.KEY_CONTENT_LOCATION, str).addArrayToRoot("items").getPotocol();
        }
        this.currentMediaType = str3;
        return str2;
    }

    public String buildAddPlayList(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 2);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildAudiotrack(int i10) {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_PROP_TYPE, PlistBuilder.VALUE_TYPE_AUDIOTRACK).addIntagerToRoot("value", i10).addStringToRoot("uuid", this.mPushUri).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getSetHttpProperty(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildClearList() {
        String buildActionContent = buildActionContent((ParamsMap) null, 3);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildDecreaseVolume() {
        String potocol = new PlistBuilder().addStringToRoot("type", PlistBuilder.VALUE_TYPE_VOLUME).addStringToRoot("event", PlistBuilder.VALUE_TYPE_DECREASE).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewLelinkVolumeContr(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildGetPlayInfo() {
        return builderHeader(new NLProtocolBuiler().getNewLeinkPlayBackInfoCmd(), 0);
    }

    public String buildGetStateInfo() {
        return null;
    }

    public String buildIncreaseVolume() {
        String potocol = new PlistBuilder().addStringToRoot("type", PlistBuilder.VALUE_TYPE_VOLUME).addStringToRoot("event", PlistBuilder.VALUE_TYPE_INCREASE).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewLelinkVolumeContr(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildPause() {
        String potocol = new PlistBuilder().addStringToRoot("uuid", this.mPushUri).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewLeinkPuase(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildPlayNext() {
        String buildActionContent = buildActionContent((ParamsMap) null, 5);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildPlayPre() {
        String buildActionContent = buildActionContent((ParamsMap) null, 4);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildPush(String str, ParamsMap paramsMap) {
        String buildPlayContent = buildPlayContent(str, paramsMap);
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewLeinkPlayCmd(), buildPlayContent.length());
        return builderHeader + buildPlayContent;
    }

    public String buildResume() {
        String potocol = new PlistBuilder().addStringToRoot("uuid", this.mPushUri).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewResumeCmd(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildSeekTo(int i10) {
        String potocol = new PlistBuilder().addStringToRoot("type", "position").addStringToRoot("uuid", this.mPushUri).addIntagerToRoot(PlistBuilder.KEY_SEEK_POSTION, i10).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getNewLelinkSeekToScrubCmd(), potocol.length());
        return builderHeader + potocol;
    }

    public String buildSelectPlay(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 6);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildSetPlayList(ParamsMap paramsMap) {
        String buildActionContent = buildActionContent(paramsMap, 1);
        String builderHeader = builderHeader(new NLProtocolBuiler().getPlayActionCmd(), buildActionContent.length());
        return builderHeader + buildActionContent;
    }

    public String buildStopPlay() {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_MEDIA_TYPE, this.currentMediaType).addStringToRoot("uuid", this.mPushUri).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getStopCmd(), potocol.length());
        return builderHeader + potocol;
    }

    public String builderHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        this.cseq++;
        return nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setContentType(NLProtocolBuiler.CONTENT_TYPE_PLIST).setNewLelinkClientId("0x" + this.mMac).setNewSessionId(this.mSessionId).setNewClientUid(this.mUid).setNewCSEQ(String.valueOf(this.cseq)).setContentLength(i10 + "").getString(true);
    }

    public String getReverseData() {
        NLProtocolBuiler userAgent = new NLProtocolBuiler().getReverseCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0");
        return userAgent.setNewLelinkClientId("0x" + this.mMac).setNewSessionId(this.mSessionId).setPurposeKey("event").setConnectionKey("Upgrade").setContentLength("0").getString(true);
    }

    public boolean parsePlayBackInfo(int i10, String str, ProtocolListener protocolListener) {
        String str2;
        if (!TextUtils.isEmpty(str)) {
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(str.getBytes()));
                String str3 = "";
                if (nSDictionary.containsKey("duration")) {
                    if (nSDictionary.containsKey("uuid")) {
                        str2 = nSDictionary.objectForKey("uuid").toString();
                    } else {
                        str2 = str3;
                    }
                    String obj = nSDictionary.objectForKey("duration").toString();
                    String obj2 = nSDictionary.objectForKey("position").toString();
                    if (nSDictionary.containsKey("playid")) {
                        str3 = nSDictionary.objectForKey("playid").toString();
                    }
                    if (protocolListener != null) {
                        protocolListener.onResult(i10, obj, obj2, str2, str3);
                    }
                    return true;
                } else if (nSDictionary.containsKey("playid")) {
                    if (nSDictionary.containsKey("uuid")) {
                        str3 = nSDictionary.objectForKey("uuid").toString();
                    }
                    String obj3 = nSDictionary.objectForKey("playid").toString();
                    if (protocolListener != null) {
                        protocolListener.onResult(i10, "curPlayInfo", obj3, str3);
                    }
                    return true;
                }
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        return false;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0164, code lost:
        if (r4.equals("stopped") == false) goto L_0x0130;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl r10, java.lang.String... r11) {
        /*
            r9 = this;
            if (r11 == 0) goto L_0x0211
            r0 = 0
            r11 = r11[r0]
            if (r11 != 0) goto L_0x0009
            goto L_0x0211
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "---------------->"
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "LelinkV2PushHandler"
            com.hpplay.component.common.utils.CLog.d(r2, r1)
            java.lang.String r1 = "Switching Protocols"
            boolean r1 = r11.contains(r1)
            if (r1 == 0) goto L_0x0028
            return
        L_0x0028:
            java.lang.String r1 = "photohide"
            boolean r1 = r11.contains(r1)
            r3 = 16
            if (r1 == 0) goto L_0x0042
            if (r10 == 0) goto L_0x0042
            java.lang.String r11 = "on PHOTO_HIDE"
            com.hpplay.component.common.utils.CLog.d(r2, r11)
            r10.disConnect()
            java.lang.String[] r11 = new java.lang.String[r0]
            r10.eventCallback(r3, r11)
            return
        L_0x0042:
            byte[] r11 = r11.getBytes()     // Catch:{ Exception -> 0x020d }
            com.hpplay.component.protocol.plist.NSObject r11 = com.hpplay.component.protocol.plist.PropertyListParser.parse((byte[]) r11)     // Catch:{ Exception -> 0x020d }
            com.hpplay.component.protocol.plist.NSDictionary r11 = (com.hpplay.component.protocol.plist.NSDictionary) r11     // Catch:{ Exception -> 0x020d }
            if (r11 == 0) goto L_0x020c
            java.lang.String r1 = "playid"
            boolean r4 = r11.containsKey((java.lang.String) r1)
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x0061
            com.hpplay.component.protocol.plist.NSObject r1 = r11.objectForKey(r1)
            java.lang.String r1 = r1.toString()
            goto L_0x0062
        L_0x0061:
            r1 = r5
        L_0x0062:
            java.lang.String r4 = "uuid"
            boolean r6 = r11.containsKey((java.lang.String) r4)
            if (r6 == 0) goto L_0x0072
            com.hpplay.component.protocol.plist.NSObject r4 = r11.objectForKey(r4)
            java.lang.String r5 = r4.toString()
        L_0x0072:
            java.lang.String r4 = "duration"
            boolean r6 = r11.containsKey((java.lang.String) r4)
            java.lang.String r7 = "0"
            if (r6 == 0) goto L_0x0085
            com.hpplay.component.protocol.plist.NSObject r4 = r11.objectForKey(r4)
            java.lang.String r4 = r4.toString()
            goto L_0x0086
        L_0x0085:
            r4 = r7
        L_0x0086:
            java.lang.String r6 = "position"
            boolean r8 = r11.containsKey((java.lang.String) r6)
            if (r8 == 0) goto L_0x0096
            com.hpplay.component.protocol.plist.NSObject r6 = r11.objectForKey(r6)
            java.lang.String r7 = r6.toString()
        L_0x0096:
            java.lang.String r6 = "readyToPlay"
            boolean r6 = r11.containsKey((java.lang.String) r6)
            if (r6 == 0) goto L_0x009f
            return
        L_0x009f:
            int r6 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x00d3 }
            if (r6 <= 0) goto L_0x00d7
            int r6 = java.lang.Integer.parseInt(r7)     // Catch:{ Exception -> 0x00d3 }
            if (r6 <= 0) goto L_0x00d7
            if (r10 == 0) goto L_0x00d7
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d3 }
            r6.<init>()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r8 = "reverse to uiduration : "
            r6.append(r8)     // Catch:{ Exception -> 0x00d3 }
            r6.append(r4)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r8 = "position : "
            r6.append(r8)     // Catch:{ Exception -> 0x00d3 }
            r6.append(r7)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00d3 }
            com.hpplay.component.common.utils.CLog.d(r2, r6)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String[] r4 = new java.lang.String[]{r4, r7, r5}     // Catch:{ Exception -> 0x00d3 }
            r6 = 17
            r10.eventCallback(r6, r4)     // Catch:{ Exception -> 0x00d3 }
            return
        L_0x00d3:
            r4 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r4)
        L_0x00d7:
            java.lang.String r4 = "stoptype"
            boolean r6 = r11.containsKey((java.lang.String) r4)
            r7 = 12
            if (r6 == 0) goto L_0x0113
            if (r10 == 0) goto L_0x0113
            com.hpplay.component.protocol.plist.NSObject r11 = r11.objectForKey(r4)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "media_completion"
            boolean r0 = android.text.TextUtils.equals(r11, r0)
            if (r0 == 0) goto L_0x00fb
            java.lang.String[] r11 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r7, r11)
            goto L_0x010f
        L_0x00fb:
            java.lang.String r0 = "phonevideohide"
            boolean r11 = android.text.TextUtils.equals(r11, r0)
            if (r11 == 0) goto L_0x010f
            java.lang.String[] r11 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r3, r11)
            java.lang.String r11 = "on stop"
            com.hpplay.component.common.utils.CLog.d(r2, r11)
        L_0x010f:
            r10.disConnect()
            return
        L_0x0113:
            java.lang.String r4 = "state"
            boolean r6 = r11.containsKey((java.lang.String) r4)
            if (r6 == 0) goto L_0x020c
            if (r10 == 0) goto L_0x020c
            com.hpplay.component.protocol.plist.NSObject r4 = r11.objectForKey(r4)
            java.lang.String r4 = r4.toString()
            r4.hashCode()
            int r6 = r4.hashCode()
            r8 = -1
            switch(r6) {
                case -1884319283: goto L_0x015e;
                case -995321554: goto L_0x0153;
                case -493563858: goto L_0x0148;
                case 96784904: goto L_0x013d;
                case 336650556: goto L_0x0132;
                default: goto L_0x0130;
            }
        L_0x0130:
            r0 = -1
            goto L_0x0167
        L_0x0132:
            java.lang.String r0 = "loading"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x013b
            goto L_0x0130
        L_0x013b:
            r0 = 4
            goto L_0x0167
        L_0x013d:
            java.lang.String r0 = "error"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0146
            goto L_0x0130
        L_0x0146:
            r0 = 3
            goto L_0x0167
        L_0x0148:
            java.lang.String r0 = "playing"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0151
            goto L_0x0130
        L_0x0151:
            r0 = 2
            goto L_0x0167
        L_0x0153:
            java.lang.String r0 = "paused"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x015c
            goto L_0x0130
        L_0x015c:
            r0 = 1
            goto L_0x0167
        L_0x015e:
            java.lang.String r6 = "stopped"
            boolean r4 = r4.equals(r6)
            if (r4 != 0) goto L_0x0167
            goto L_0x0130
        L_0x0167:
            switch(r0) {
                case 0: goto L_0x01b9;
                case 1: goto L_0x0199;
                case 2: goto L_0x018a;
                case 3: goto L_0x017c;
                case 4: goto L_0x016c;
                default: goto L_0x016a;
            }
        L_0x016a:
            goto L_0x020c
        L_0x016c:
            r11 = 14
            java.lang.String[] r0 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r11, r0)
            java.lang.String r10 = "LOADING"
            com.hpplay.component.common.utils.CLog.i(r2, r10)
            goto L_0x020c
        L_0x017c:
            java.lang.String r11 = "ERROR"
            com.hpplay.component.common.utils.CLog.d(r2, r11)
            java.lang.String[] r11 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r3, r11)
            goto L_0x020c
        L_0x018a:
            r11 = 13
            java.lang.String[] r0 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r11, r0)
            java.lang.String r10 = "--- PLAYING ---"
            com.hpplay.component.common.utils.CLog.i(r2, r10)
            goto L_0x020c
        L_0x0199:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r0 = "PAUSED "
            r11.append(r0)
            boolean r0 = r9.isPlaying
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            com.hpplay.component.common.utils.CLog.i(r2, r11)
            r11 = 15
            java.lang.String[] r0 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r11, r0)
            goto L_0x020c
        L_0x01b9:
            java.lang.String r0 = "reason"
            boolean r4 = r11.containsKey((java.lang.String) r0)
            if (r4 == 0) goto L_0x01fd
            com.hpplay.component.protocol.plist.NSObject r11 = r11.objectForKey(r0)
            java.lang.String r11 = r11.toString()
            java.lang.String r0 = "ended"
            boolean r0 = android.text.TextUtils.equals(r11, r0)
            if (r0 == 0) goto L_0x01d9
            java.lang.String[] r11 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r7, r11)
            return
        L_0x01d9:
            java.lang.String r0 = "episode_stopped"
            boolean r0 = android.text.TextUtils.equals(r11, r0)
            if (r0 == 0) goto L_0x01eb
            r11 = 26
            java.lang.String[] r0 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r11, r0)
            return
        L_0x01eb:
            java.lang.String r0 = "preempt_stopped"
            boolean r11 = android.text.TextUtils.equals(r11, r0)
            if (r11 == 0) goto L_0x01fd
            r11 = 28
            java.lang.String[] r0 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r11, r0)
            return
        L_0x01fd:
            java.lang.String[] r11 = new java.lang.String[]{r5, r1}
            r10.eventCallback(r3, r11)
            r10.disConnect()
            java.lang.String r10 = "state on stop---------"
            com.hpplay.component.common.utils.CLog.i(r2, r10)
        L_0x020c:
            return
        L_0x020d:
            r10 = move-exception
            com.hpplay.component.common.utils.CLog.w((java.lang.String) r2, (java.lang.Throwable) r10)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.push.LelinkV2PushHandler.parseReversePlist(com.hpplay.component.protocol.push.PushControllerImpl, java.lang.String[]):void");
    }

    public String setVolume(int i10) {
        String potocol = new PlistBuilder().addStringToRoot(PlistBuilder.KEY_PROP_TYPE, PlistBuilder.VALUE_TYPE_VOLUME).addIntagerToRoot("value", i10).getPotocol();
        String builderHeader = builderHeader(new NLProtocolBuiler().getSetHttpProperty(), potocol.length());
        return builderHeader + potocol;
    }
}
