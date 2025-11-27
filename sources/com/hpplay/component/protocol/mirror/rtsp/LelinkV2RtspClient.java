package com.hpplay.component.protocol.mirror.rtsp;

import android.os.Build;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.mirror.VideoSender;
import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSNumber;
import com.hpplay.component.protocol.plist.NSObject;
import com.hpplay.component.protocol.plist.PropertyListParser;

public class LelinkV2RtspClient extends RtspClient {
    private static final int AUDIO_MODEL = 96;
    private static final String TAG = "LelinkV2RtspClient";
    private static final int VIDEO_MODEL = 97;
    public static int mMirrorPort;
    private int cseq = 0;
    private boolean isUseAudio = false;
    private int mAtv = 0;
    private String mDeviceId;
    private String mDeviceName;
    private boolean mEncrypt;
    private String mIp;
    private LelinkEncrypt mLelinkEncrypt;
    private String mLocalip;
    private String mMac;
    private VideoSender mMirrorDataSender;
    private String mMst;
    private ProtocolSender mProtocolSender;
    private double mRefreshRate = 60.0d;
    private int mRudpPort;
    private String mScreenCode;
    private String mSessionId;
    private int mUdpServerPort = 0;
    private String mUid;
    private String mUri;
    private int mlelinkPort;

    public LelinkV2RtspClient(ParamsMap paramsMap) {
        this.mScreenCode = String.valueOf(paramsMap.getParam("screencode", "000000"));
        this.mUri = paramsMap.getStringParam("uri");
        try {
            this.mIDWidth = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH));
            this.mIDHeight = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT));
        } catch (Exception unused) {
            this.mIDWidth = 1080;
            this.mIDHeight = 1920;
        }
        this.mMac = (String) paramsMap.getParam(ParamsMap.DeviceParams.KEY_MAC, "000000000000");
        this.mDeviceId = "0x" + this.mMac;
        this.mSessionId = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SESSION_ID);
        this.mIp = paramsMap.getStringParam("ip");
        this.mUid = paramsMap.getCuid();
        String atv = paramsMap.getATV();
        if (!TextUtils.isEmpty(atv)) {
            this.mAtv = Integer.valueOf(atv).intValue();
        }
        this.mlelinkPort = Integer.parseInt(paramsMap.getParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, "0").toString());
        this.mDeviceName = Build.MANUFACTURER + " " + Build.MODEL;
        ProtocolSender protocolSender = new ProtocolSender();
        this.mProtocolSender = protocolSender;
        protocolSender.setConnectInfo(this.mIp, this.mlelinkPort);
        this.mLocalip = ProtocolUtils.getLoaclIp();
        this.mMirrorDataSender = new VideoSender();
    }

    private String buildHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        NLProtocolBuiler contentType = nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewLelinkClientId(this.mDeviceId).setNewSessionId(this.mSessionId).setNewClientUid(this.mUid).setContentType(NLProtocolBuiler.CONTENT_TYPE_PLIST);
        NLProtocolBuiler newCSEQ = contentType.setNewCSEQ(this.cseq + "");
        return newCSEQ.setContentLength(i10 + "").getString(true);
    }

    private String getTeardownData(int i10) {
        String potocol = new PlistBuilder().createIPlistArray("streams", 1).addIntagerToArray("streams", 0, "type", i10).addArrayToRoot("streams").getPotocol();
        NLProtocolBuiler nLProtocolBuiler = new NLProtocolBuiler();
        String str = this.mLocalip;
        String buildHeader = buildHeader(nLProtocolBuiler.getTearDownCmd(str, System.currentTimeMillis() + ""), potocol.length());
        return buildHeader + potocol;
    }

    public int exeLelinkRtsp(boolean z10, String... strArr) {
        int sendRequestGetMirrorInfo;
        int i10 = 0;
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            String str = strArr[1];
            try {
                sendRequestGetMirrorInfo = sendRequestGetMirrorInfo();
            } catch (Exception e10) {
                e = e10;
                i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_INFO;
                CLog.w(TAG, (Throwable) e);
                this.mErrorMsg = CLog.getExceptionStr(e);
                return i10;
            }
            try {
                CLog.i(TAG, " sendRequestGetMirrorInfo ");
                if (sendRequestGetMirrorInfo == 0) {
                    return sendRequestGetMirrorInfo;
                }
                if (sendRequestGetMirrorInfo == 10) {
                    return 211026;
                }
                if (sendRequestGetMirrorInfo == 12) {
                    return 211027;
                }
                try {
                    int sendRequestVideoSetup = sendRequestVideoSetup(parseInt, Integer.parseInt(strArr[2]));
                    if (sendRequestVideoSetup == 12) {
                        return ParamsMap.MirrorParams.MIRROR_ERROR_UNSUPPORT_PREEMPT;
                    }
                    if (sendRequestVideoSetup == 0) {
                        return ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                    }
                    if (sendRequestVideoSetup == 13) {
                        return ParamsMap.MirrorParams.MIRROR_ERROR_FORBIDDEN;
                    }
                    if (z10) {
                        try {
                            boolean sendRequestAudioSetup = sendRequestAudioSetup();
                            CLog.i(TAG, "AudioSetup" + sendRequestAudioSetup);
                        } catch (Exception e11) {
                            e = e11;
                            i10 = sendRequestVideoSetup;
                        }
                    }
                    try {
                        boolean sendRequestRecord = sendRequestRecord();
                        setMirrorMode(str);
                        CLog.i(TAG, "tRecord" + sendRequestRecord);
                        if (sendRequestRecord) {
                            return 1;
                        }
                        return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                    } catch (Exception e12) {
                        e = e12;
                        i10 = ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                        CLog.w(TAG, (Throwable) e);
                        this.mErrorMsg = CLog.getExceptionStr(e);
                        return i10;
                    }
                } catch (Exception e13) {
                    e = e13;
                    i10 = ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                    CLog.w(TAG, (Throwable) e);
                    this.mErrorMsg = CLog.getExceptionStr(e);
                    return i10;
                }
            } catch (Exception e14) {
                e = e14;
                i10 = sendRequestGetMirrorInfo;
                CLog.w(TAG, (Throwable) e);
                this.mErrorMsg = CLog.getExceptionStr(e);
                return i10;
            }
        } catch (Exception e15) {
            e = e15;
            CLog.w(TAG, (Throwable) e);
            this.mErrorMsg = CLog.getExceptionStr(e);
            return i10;
        }
    }

    public int getAudioPort() {
        return this.mUdpServerPort;
    }

    public String getAudioServerIp() {
        return this.mIp;
    }

    public int getBitRate() {
        return this.mBitrate;
    }

    public String getEncodeType() {
        return this.mEncodeType;
    }

    public double getRefreshRate() {
        return this.mRefreshRate;
    }

    public int getSinkHeight() {
        return this.mHeight;
    }

    public int getSinkWidth() {
        return this.mWidth;
    }

    public int getTvHeight() {
        return this.mTvHeight;
    }

    public int getTvWidth() {
        return this.mTvWidth;
    }

    public VideoSender getVideoDataSender() {
        return this.mMirrorDataSender;
    }

    public boolean isEncrypt() {
        return this.mEncrypt;
    }

    public boolean parseMirrorInfo(String str) {
        String str2 = str.split("\r\n")[0];
        if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
            this.mEncrypt = true;
            byte[] removeHeader = ProtocolUtils.removeHeader(str.getBytes());
            try {
                CLog.i(TAG, "parseMirrorInfo --->" + new String(removeHeader));
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(removeHeader);
                if (nSDictionary != null) {
                    if (nSDictionary.containsKey(PlistBuilder.KEY_MIRROR_SOCKET_TYPE)) {
                        this.mMst = nSDictionary.get((Object) PlistBuilder.KEY_MIRROR_SOCKET_TYPE).toString();
                    }
                    if (nSDictionary.containsKey(PlistBuilder.KEY_AUDIO_SOCKET_TYPE)) {
                        this.mAst = nSDictionary.get((Object) PlistBuilder.KEY_AUDIO_SOCKET_TYPE).toString();
                        CLog.i(TAG, "mAst++++++" + this.mAst);
                    }
                    if (nSDictionary.containsKey(PlistBuilder.KEY_DISPLAYS)) {
                        NSArray nSArray = (NSArray) nSDictionary.get((Object) PlistBuilder.KEY_DISPLAYS);
                        if (nSArray != null) {
                            for (NSObject nSObject : nSArray.getArray()) {
                                NSDictionary nSDictionary2 = (NSDictionary) nSObject;
                                for (int i10 = 0; i10 < nSDictionary2.allKeys().length; i10++) {
                                    if (TextUtils.equals(nSDictionary2.allKeys()[i10], "width")) {
                                        this.mTvWidth = Integer.valueOf(nSDictionary2.get((Object) "width").toString()).intValue();
                                    } else if (TextUtils.equals(nSDictionary2.allKeys()[i10], "height")) {
                                        this.mTvHeight = Integer.valueOf(nSDictionary2.get((Object) "height").toString()).intValue();
                                    } else if (TextUtils.equals(nSDictionary2.allKeys()[i10], PlistBuilder.KEY_REFRESH_RATE)) {
                                        try {
                                            double floatValue = (double) Float.valueOf(nSDictionary2.get((Object) PlistBuilder.KEY_REFRESH_RATE).toString()).floatValue();
                                            if (floatValue < 1.0d) {
                                                Double.isNaN(floatValue);
                                                floatValue = 1.0d / floatValue;
                                            }
                                            this.mRefreshRate = floatValue;
                                        } catch (Exception e10) {
                                            CLog.w(TAG, (Throwable) e10);
                                        }
                                    }
                                }
                            }
                        }
                        CLog.i(TAG, "" + this.mTvWidth + "x" + this.mTvHeight + "@" + this.mRefreshRate);
                        adjustScreenSize();
                        return true;
                    }
                }
            } catch (Exception e11) {
                CLog.w(TAG, (Throwable) e11);
            }
        }
        return false;
    }

    public void release() {
        CLog.d(TAG, " New LelinkRtspClient stopTask ");
        if (this.mProtocolSender != null) {
            CLog.d(TAG, "close mProtocalSender");
            this.mProtocolSender.release();
            this.mProtocolSender = null;
        }
        if (this.mMirrorDataSender != null) {
            CLog.d(TAG, "close mMirrorDataSender");
            this.mMirrorDataSender.release();
        }
        LelinkEncrypt lelinkEncrypt = this.mLelinkEncrypt;
        if (lelinkEncrypt != null) {
            lelinkEncrypt.release();
            this.mLelinkEncrypt = null;
        }
    }

    public boolean sendRequestAnnounce() {
        return true;
    }

    public boolean sendRequestAudioSetup() {
        int i10;
        NSArray nSArray;
        this.cseq++;
        this.isUseAudio = true;
        if (!TextUtils.isEmpty(this.mAst)) {
            i10 = Integer.parseInt(this.mAst);
        } else {
            i10 = 0;
        }
        String potocol = new PlistBuilder().addIntagerToRoot(PlistBuilder.KEY_TIMING_PORT, 0).addIntagerToRoot(PlistBuilder.KEY_AUDIO_SOCKET_TYPE, i10).createIPlistArray("streams", 1).addStringToRoot("uuid", this.mUri).addIntagerToArray("streams", 0, "type", 96).addBlooeanToArray("streams", 0, PlistBuilder.KEY_PLAYMODE, true).addIntagerToArray("streams", 0, PlistBuilder.KEY_SF, 212).addIntagerToArray("streams", 0, PlistBuilder.KEY_SR, 44100).addIntagerToArray("streams", 0, PlistBuilder.KEY_CONTROL_PORT, 0).addIntagerToArray("streams", 0, PlistBuilder.KEY_LATENCYMAX, 3750).addIntagerToArray("streams", 0, PlistBuilder.KEY_LATENCYMIN, 3750).addArrayToRoot("streams").getPotocol();
        byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData((buildHeader(new NLProtocolBuiler().getAudioSetUpCmd(this.mLocalip, System.currentTimeMillis() + ""), potocol.length()) + potocol).getBytes())));
        if (decryptData != null && decryptData.length > 0) {
            CLog.i(TAG, "sendRequestAudioSetup----->" + new String(decryptData));
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(decryptData));
            if (nSDictionary.containsKey("streams") && (nSArray = (NSArray) nSDictionary.get((Object) "streams")) != null) {
                int i11 = 0;
                while (i11 < nSArray.getArray().length) {
                    NSDictionary nSDictionary2 = (NSDictionary) nSArray.getArray()[i11];
                    if (nSDictionary2 == null || nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT) == null) {
                        i11++;
                    } else {
                        this.mUdpServerPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT).toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int sendRequestGetMirrorInfo() {
        try {
            if (this.mProtocolSender == null) {
                ProtocolSender protocolSender = new ProtocolSender();
                this.mProtocolSender = protocolSender;
                protocolSender.setConnectInfo(this.mIp, this.mlelinkPort);
            }
            if (!this.mProtocolSender.connectServer()) {
                return 0;
            }
            LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(this.mSessionId);
            this.mLelinkEncrypt = lelinkEncrypt;
            lelinkEncrypt.setSrpPassword(this.mScreenCode);
            if (this.mProtocolSender.checkEncrypt(this.mLelinkEncrypt, TAG)) {
                this.cseq = 0 + 1;
                NLProtocolBuiler newClientVersion = new NLProtocolBuiler().getActionInfoCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewClientDid(this.mDeviceId).setNewSessionId(this.mSessionId).setNewClientName(this.mDeviceName).setNewClientAppid(this.mMac).setNewClientVersion("5.5");
                NLProtocolBuiler newClientCU = newClientVersion.setNewClientDid("0x" + this.mMac).setNewClientCU(this.mUid);
                byte[] protocal = newClientCU.setNewCSEQ(this.cseq + "").setContentLength("0").getProtocal(true);
                byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(protocal)));
                if (decryptData == null || decryptData.length <= 0 || !parseMirrorInfo(new String(decryptData))) {
                    return 0;
                }
                return 1;
            } else if (this.mLelinkEncrypt.getEncryptState().equals(ProtocolBuilder.LELINK_AUTH_ERROR)) {
                return 10;
            } else {
                if (this.mLelinkEncrypt.getEncryptState().equals(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
                    return 12;
                }
                return 0;
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
            throw e10;
        }
    }

    public boolean sendRequestGetMirrorPort() {
        return true;
    }

    public boolean sendRequestGetParamter() {
        return true;
    }

    public boolean sendRequestRecord() {
        this.cseq++;
        byte[] interactiveEncryptData = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(buildHeader(new NLProtocolBuiler().getRecordCmd(this.mLocalip, System.currentTimeMillis() + ""), 0).getBytes()));
        if (interactiveEncryptData == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, "RECORD call back  ----->" + new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
        return true;
    }

    public boolean sendRequestSetOptions() {
        try {
            this.cseq++;
            byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(buildHeader(new NLProtocolBuiler().getRtspFeedbackCmd(), 0).getBytes())));
            if (decryptData == null || decryptData.length <= 0) {
                return false;
            }
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
    }

    public boolean sendRequestSetParamter() {
        return true;
    }

    public synchronized boolean sendRequestSetTeardown() {
        boolean z10;
        boolean z11;
        Exception e10;
        LelinkEncrypt lelinkEncrypt;
        z10 = false;
        try {
            this.cseq++;
            String teardownData = getTeardownData(97);
            CLog.i(TAG, "start  send teardown \n" + teardownData);
            ProtocolSender protocolSender = this.mProtocolSender;
            if (!(protocolSender == null || (lelinkEncrypt = this.mLelinkEncrypt) == null)) {
                byte[] interactiveEncryptData = protocolSender.interactiveEncryptData(lelinkEncrypt.buildEncryptData(teardownData.getBytes()));
                if (interactiveEncryptData == null || interactiveEncryptData.length <= 0) {
                    z11 = false;
                } else {
                    try {
                        CLog.i(TAG, "start  send teardown  resutlt : \n" + new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
                        z11 = true;
                    } catch (Exception e11) {
                        e10 = e11;
                        z11 = true;
                        CLog.w(TAG, (Throwable) e10);
                        z10 = z11;
                        return z10;
                    }
                }
                try {
                    if (this.isUseAudio) {
                        byte[] interactiveEncryptData2 = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(getTeardownData(96).getBytes()));
                        if (interactiveEncryptData2 != null && interactiveEncryptData2.length > 0) {
                            z10 = true;
                            CLog.d(TAG, "start stopTask");
                        }
                    }
                    z10 = z11;
                } catch (Exception e12) {
                    e10 = e12;
                    CLog.w(TAG, (Throwable) e10);
                    z10 = z11;
                    return z10;
                }
                try {
                    CLog.d(TAG, "start stopTask");
                } catch (Exception e13) {
                    Exception exc = e13;
                    z11 = z10;
                    e10 = exc;
                    CLog.w(TAG, (Throwable) e10);
                    z10 = z11;
                    return z10;
                }
            }
            release();
        } catch (Exception e14) {
            e10 = e14;
            z11 = false;
            CLog.w(TAG, (Throwable) e10);
            z10 = z11;
            return z10;
        }
        return z10;
    }

    public int sendRequestVideoSetup(int i10, int i11) {
        String str;
        NSArray nSArray;
        NSNumber nSNumber;
        this.cseq++;
        if (Build.VERSION.SDK_INT >= 24) {
            str = ProtocolUtils.getDateTime(System.currentTimeMillis());
        } else {
            str = "20180319000900";
        }
        this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt("HappyCast5,0/500.0"), ProtocolUtils.Encrypt(str));
        String potocol = new PlistBuilder().addIntagerToRoot(PlistBuilder.KEY_EVENT_PORT, i10).addIntagerToRoot(PlistBuilder.KEY_TIMING_PORT, 0).addStringToRoot("uuid", this.mUri).addIntagerToRoot(PlistBuilder.KEY_MIRROR_SOCKET_TYPE, i11).addStringToRoot(PlistBuilder.KEY_STREAM_TIME, str).createIPlistArray("streams", 1).addIntagerToArray("streams", 0, "type", 97).addArrayToRoot("streams").getPotocol();
        CLog.i(TAG, "=============>> " + potocol + "   " + i10 + "  " + i11);
        byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData((buildHeader(new NLProtocolBuiler().getVideoSetUpCmd(this.mLocalip, System.currentTimeMillis() + ""), potocol.length()) + potocol).getBytes())));
        if (decryptData != null && decryptData.length > 0) {
            CLog.i(TAG, "=======================================----->\r\n" + new String(decryptData));
            String header = ProtocolUtils.getHeader(decryptData);
            if (!TextUtils.isEmpty(header)) {
                String str2 = header.split("\r\n")[0];
                CLog.i(TAG, "the header first line ----->" + str2);
                if (str2.contains(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
                    return 12;
                }
                if (str2.contains(ProtocolBuilder.LELINK_UNSUPPORT_FORBIDDEN)) {
                    return 13;
                }
            }
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(decryptData));
            if (nSDictionary.containsKey(PlistBuilder.KEY_TIMING_PORT) && (nSNumber = (NSNumber) nSDictionary.get((Object) PlistBuilder.KEY_TIMING_PORT)) != null) {
                nSNumber.intValue();
            }
            if (nSDictionary.containsKey("streams") && (nSArray = (NSArray) nSDictionary.get((Object) "streams")) != null) {
                boolean z10 = false;
                for (int i12 = 0; i12 < nSArray.count(); i12++) {
                    NSDictionary nSDictionary2 = (NSDictionary) nSArray.getArray()[i12];
                    if (!(nSDictionary2 == null || nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT) == null)) {
                        mMirrorPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT).toString());
                    }
                    if (!(nSDictionary2 == null || nSDictionary2.get((Object) PlistBuilder.KEY_UDP_DATAPORT) == null)) {
                        this.mRudpPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_UDP_DATAPORT).toString());
                    }
                    int i13 = this.mRudpPort;
                    if (i13 > 0) {
                        z10 = this.mMirrorDataSender.connect(this.mIp, i13, 1);
                        this.mBitrate = this.mMirrorDataSender.getInitBitrate();
                    }
                }
                if (!z10) {
                    z10 = this.mMirrorDataSender.connect(this.mIp, mMirrorPort, 2);
                }
                if (z10) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public boolean setMirrorMode(String str) {
        boolean z10;
        try {
            if (this.mProtocolSender != null && !TextUtils.isEmpty(str)) {
                NLProtocolBuiler mirrorMode = new NLProtocolBuiler().getMirrorModeCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewClientDid(this.mDeviceId).setNewSessionId(this.mSessionId).setMirrorMode(str);
                byte[] protocal = mirrorMode.setNewCSEQ(this.cseq + "").setContentLength("0").getProtocal(true);
                byte[] interactiveEncryptData = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(protocal));
                StringBuilder sb = new StringBuilder();
                sb.append("   send mirror mode ");
                if (interactiveEncryptData != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                sb.append(z10);
                CLog.i(TAG, sb.toString());
                if (interactiveEncryptData != null) {
                    CLog.d(TAG, new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
                }
                return true;
            }
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        return false;
    }

    public void setSinkHeight(int i10) {
        this.mHeight = i10;
    }

    public void setSinkWidth(int i10) {
        this.mWidth = i10;
    }
}
