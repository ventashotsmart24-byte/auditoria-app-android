package com.hpplay.component.protocol.mirror.rtsp;

import android.os.Build;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.mirror.VideoSender;
import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSNumber;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

public class LelinkRtspClient extends RtspClient {
    private static final String HAPPY_CAST = "Happycast/1.0";
    private static final String HAPPY_VALUE = "happyplay";
    private static final String TAG = "LelinkRtspClient";
    int cseq = 0;
    private String mDeviceId;
    private String mDeviceName;
    private boolean mEncrypt;
    private String mIp;
    private String mLocalip;
    private int mMirrorPort = 0;
    private ProtocolSender mProtocolSender;
    private double mRefreshRate = 60.0d;
    private int mRepoPort;
    private String mScreenCode;
    private String mSinkName;
    private int mUdpServerPort = 0;
    private String mUri;
    private VideoSender mVideoDataSender;
    private String versoinName;

    public LelinkRtspClient(ParamsMap paramsMap) {
        String str;
        this.mScreenCode = paramsMap.getStringParam("screencode");
        if (TextUtils.isEmpty(paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_RAOP_PORT))) {
            str = "0";
        } else {
            str = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_RAOP_PORT);
        }
        this.mRepoPort = Integer.parseInt(str);
        this.mUri = paramsMap.getStringParam("uri");
        try {
            this.mIDWidth = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH));
            this.mIDHeight = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT));
        } catch (Exception e10) {
            this.mIDWidth = 1080;
            this.mIDHeight = 1920;
            CLog.w(TAG, (Throwable) e10);
        }
        this.versoinName = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_CHANNEL_VERSION);
        this.mSinkName = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SINK_NAME);
        this.mDeviceId = "0x" + paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_MAC);
        this.mIp = paramsMap.getStringParam("ip");
        CLog.d(TAG, " report  " + this.mRepoPort);
        this.mDeviceName = DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel();
        this.mMirrorPort = Integer.parseInt(paramsMap.getParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT, "0").toString());
    }

    private void parseMirrorPort(byte[] bArr) {
        NSArray nSArray;
        NSDictionary nSDictionary;
        if (bArr != null) {
            CLog.d(TAG, "------->" + new String(bArr));
            try {
                NSDictionary nSDictionary2 = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(bArr));
                if (nSDictionary2 != null && (nSArray = (NSArray) nSDictionary2.objectForKey("streams")) != null && (nSDictionary = (NSDictionary) nSArray.objectAtIndex(0)) != null) {
                    NSNumber nSNumber = (NSNumber) nSDictionary.objectForKey("dataPort");
                    if (nSNumber != null) {
                        this.mMirrorPort = nSNumber.intValue();
                    } else {
                        this.mMirrorPort = 7100;
                    }
                }
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
                this.mMirrorPort = 7100;
            }
        }
    }

    public int exeLelinkRtsp(boolean z10, String... strArr) {
        int i10 = 0;
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            CLog.i(TAG, "start  running");
            try {
                if (!sendRequestGetMirrorPort()) {
                    return ParamsMap.MirrorParams.MIRROR_ERROR_GET_PORT;
                }
                CLog.i(TAG, "start  get mirror info");
                try {
                    if (sendRequestGetMirrorInfo() == 10) {
                        return 211026;
                    }
                    try {
                        boolean sendRequestAnnounce = sendRequestAnnounce();
                        CLog.i(TAG, "Announce" + sendRequestAnnounce);
                        i10 = sendRequestVideoSetup(parseInt, 0);
                        CLog.i(TAG, "Video Setup" + sendRequestAnnounce);
                        if (z10) {
                            boolean sendRequestAudioSetup = sendRequestAudioSetup();
                            CLog.i(TAG, "AudioSetup" + sendRequestAudioSetup);
                            if (!sendRequestAudioSetup) {
                                return ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                            }
                        }
                        i10 = ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                        boolean sendRequestRecord = sendRequestRecord();
                        CLog.i(TAG, "tRecord" + sendRequestRecord);
                        if (!sendRequestRecord) {
                            return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                        }
                        boolean sendRequestGetParamter = sendRequestGetParamter();
                        CLog.i(TAG, "GetParameter" + sendRequestGetParamter);
                        if (!sendRequestGetParamter) {
                            return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                        }
                        boolean sendRequestSetParamter = sendRequestSetParamter();
                        CLog.i(TAG, "SetParameter start " + sendRequestSetParamter);
                        if (sendRequestSetParamter) {
                            return 1;
                        }
                        return i10;
                    } catch (Exception e10) {
                        e = e10;
                        i10 = ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                        CLog.w(TAG, (Throwable) e);
                        this.mErrorMsg = CLog.getExceptionStr(e);
                        return i10;
                    }
                } catch (Exception e11) {
                    e = e11;
                    i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_INFO;
                    CLog.w(TAG, (Throwable) e);
                    this.mErrorMsg = CLog.getExceptionStr(e);
                    return i10;
                }
            } catch (Exception e12) {
                e = e12;
                i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_PORT;
                CLog.w(TAG, (Throwable) e);
                this.mErrorMsg = CLog.getExceptionStr(e);
                return i10;
            }
        } catch (Exception e13) {
            e = e13;
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
        return this.mVideoDataSender;
    }

    public boolean isEncrypt() {
        return this.mEncrypt;
    }

    public int parseMirrorInfo(String str) {
        String str2 = str.split("\r\n")[0];
        if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
            if (str.contains("happycast")) {
                this.mEncrypt = true;
            }
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(str.getBytes()));
                if (nSDictionary != null) {
                    this.mTvWidth = ((NSNumber) nSDictionary.objectForKey("width")).intValue();
                    this.mTvHeight = ((NSNumber) nSDictionary.objectForKey("height")).intValue();
                    adjustScreenSize();
                    try {
                        double doubleValue = ((NSNumber) nSDictionary.objectForKey("refreshRate")).doubleValue();
                        if (doubleValue < 1.0d) {
                            doubleValue = 1.0d / doubleValue;
                        }
                        this.mRefreshRate = doubleValue;
                    } catch (Exception e10) {
                        CLog.w(TAG, (Throwable) e10);
                    }
                    CLog.i(TAG, "" + this.mTvWidth + "x" + this.mTvHeight + "@" + this.mRefreshRate);
                    return 1;
                }
            } catch (Exception e11) {
                CLog.w(TAG, (Throwable) e11);
            }
        } else if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SCREENCODE)) {
            String[] split = str.split("\r\n");
            if (split == null || split.length <= 0) {
                return 10;
            }
            String str3 = split[split.length - 1];
            if (TextUtils.isEmpty(str3)) {
                return 10;
            }
            int indexOf = str3.indexOf(Operator.Operation.EQUALS);
            int indexOf2 = str3.indexOf(",");
            String replace = str3.substring(indexOf + 1, indexOf2 - 1).replace("\"", "");
            String substring = str3.substring(indexOf2 + 1);
            String replace2 = substring.substring(substring.indexOf(Operator.Operation.EQUALS) + 1).replace("\"", "");
            ProtocolBuilder.mRealm = replace;
            ProtocolBuilder.mNonce = replace2;
            CLog.d(TAG, "author  :  " + str3);
            return 10;
        }
        return 0;
    }

    public void release() {
        VideoSender videoSender = this.mVideoDataSender;
        if (videoSender != null) {
            videoSender.release();
        }
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
        }
    }

    public boolean sendRequestAnnounce() {
        this.mLocalip = ProtocolUtils.getLoaclIp();
        this.cseq = 0;
        String sdp = new ProtocolBuilder().getSdp(this.mLocalip, this.mDeviceName);
        StringBuilder sb = new StringBuilder();
        ProtocolBuilder lelinkClientName = new ProtocolBuilder().getAunounce(this.mLocalip).setLelinkClientName(this.mDeviceName);
        ProtocolBuilder contentType = lelinkClientName.setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentType(ProtocolBuilder.VALUE_SDP_TYPE);
        sb.append(contentType.setContentLength(sdp.length() + "").setUserAgent("AirPlay/150.33").getString(true));
        sb.append(sdp);
        String sb2 = sb.toString();
        CLog.d(TAG, "------announce ---" + sb2);
        this.cseq = this.cseq + 1;
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData(sb2.getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        if (bArr != null) {
            return true;
        }
        this.mProtocolSender.release();
        return false;
    }

    public boolean sendRequestAudioSetup() {
        ProtocolBuilder transport = new ProtocolBuilder().getAudioSetUpCmd(this.mLocalip).setTransport(ProtocolBuilder.VALUE_AUDIO_TRANSPORT);
        StringBuilder sb = new StringBuilder();
        sb.append(this.cseq);
        String str = "";
        sb.append(str);
        byte[] protocal = transport.setRtspSeq(sb.toString()).setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setContentLength("0").setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true);
        CLog.i(TAG, "1 --- > \n\n " + new String(protocal) + "   \n\n " + protocal.length);
        byte[] interactiveData = this.mProtocolSender.interactiveData(protocal);
        if (interactiveData != null) {
            str = new String(interactiveData, 0, interactiveData.length);
            CLog.i(TAG, "SETUP audio = \r\n" + str);
        }
        CLog.i(TAG, "SETUP call back" + str);
        String substring = str.substring(0, str.indexOf("\r\n\r\n"));
        RTSPPacket rTSPPacket = new RTSPPacket();
        rTSPPacket.parseRTSPPacket(substring, (byte[]) null, substring.length());
        rTSPPacket.valueOfHeader("Transport");
        Pattern.compile(";control_port=(\\d+)").matcher(substring);
        Pattern.compile(";timing_port=(\\d+)").matcher(substring);
        Matcher matcher = Pattern.compile(";server_port=(\\d+)").matcher(substring);
        if (matcher.find()) {
            try {
                this.mUdpServerPort = Integer.valueOf(matcher.group(1)).intValue();
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
        }
        Pattern.compile(";mode=(\\w+)").matcher(substring);
        return true;
    }

    public int sendRequestGetMirrorInfo() {
        String str;
        byte[] bArr;
        if (this.mVideoDataSender != null) {
            ProtocolSender protocolSender = new ProtocolSender();
            this.mProtocolSender = protocolSender;
            protocolSender.setConnectInfo(this.mIp, this.mRepoPort);
            boolean connectServer = this.mProtocolSender.connectServer();
            CLog.d(TAG, "create socket " + connectServer);
            if (connectServer) {
                byte[] protocal = new ProtocolBuilder().getMirrorPortCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setContentLength("0").setHapplay(HAPPY_VALUE).getProtocal(true);
                byte[] bArr2 = new byte[0];
                try {
                    bArr2 = this.mProtocolSender.interactiveData(protocal);
                } catch (Exception e10) {
                    CLog.w(TAG, (Throwable) e10);
                }
                if (bArr2 != null) {
                    parseMirrorPort(bArr2);
                }
            }
            if (!connectServer) {
                return 0;
            }
            return 1;
        }
        VideoSender videoSender = new VideoSender();
        this.mVideoDataSender = videoSender;
        if (!videoSender.connect(this.mIp, this.mMirrorPort, 2)) {
            return 0;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            str = ProtocolUtils.getDateTime(System.currentTimeMillis());
        } else {
            str = "20180319000900";
        }
        this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt(HAPPY_CAST), ProtocolUtils.Encrypt(str));
        if (!TextUtils.isEmpty(this.mScreenCode)) {
            this.mScreenCode = ProtocolBuilder.makeAuthorization(this.mScreenCode);
        } else {
            this.mScreenCode = null;
        }
        if (this.versoinName.contains("5.3.2.9")) {
            bArr = new ProtocolBuilder().getMirrorInfoCmd().setLelinkDeviceId(this.mDeviceId).setLelinkDevNameCmd(this.mDeviceName).setLelinkprotocolVersion("0").setLelinkClientName(this.mSinkName).setStreamTime(str).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true);
        } else {
            bArr = new ProtocolBuilder().getMirrorInfoCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setStreamTime(str).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true);
        }
        byte[] interactiveData = this.mVideoDataSender.interactiveData(bArr);
        if (interactiveData != null) {
            return parseMirrorInfo(new String(interactiveData));
        }
        return 0;
    }

    public boolean sendRequestGetMirrorPort() {
        boolean connect;
        String str;
        byte[] bArr;
        if (this.mMirrorPort == 0) {
            ProtocolSender protocolSender = new ProtocolSender();
            this.mProtocolSender = protocolSender;
            protocolSender.setConnectInfo(this.mIp, this.mRepoPort);
            connect = this.mProtocolSender.connectServer();
            CLog.d(TAG, "create socket " + connect);
            if (connect) {
                byte[] protocal = new ProtocolBuilder().getMirrorPortCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mDeviceName).setContentLength("0").setHapplay(HAPPY_VALUE).getProtocal(true);
                byte[] interactiveData = this.mProtocolSender.interactiveData(protocal);
                if (interactiveData == null) {
                    return false;
                }
                parseMirrorPort(interactiveData);
                return true;
            }
        } else {
            VideoSender videoSender = new VideoSender();
            this.mVideoDataSender = videoSender;
            connect = videoSender.connect(this.mIp, this.mMirrorPort, 2);
            if (Build.VERSION.SDK_INT >= 24) {
                str = ProtocolUtils.getDateTime(System.currentTimeMillis());
            } else {
                str = "20180319000900";
            }
            this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt(HAPPY_CAST), ProtocolUtils.Encrypt(str));
            if (this.versoinName.contains("5.3.2.9")) {
                bArr = new ProtocolBuilder().getMirrorInfoCmd().setLelinkDeviceId(this.mDeviceId).setLelinkDevNameCmd(this.mDeviceName).setLelinkprotocolVersion("0").setLelinkClientName(this.mSinkName).setStreamTime(str).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true);
            } else {
                bArr = new ProtocolBuilder().getMirrorInfoCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setStreamTime(str).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true);
            }
            byte[] interactiveData2 = this.mVideoDataSender.interactiveData(bArr);
            if (interactiveData2 == null || parseMirrorInfo(new String(interactiveData2)) != 1) {
                return false;
            }
        }
        return connect;
    }

    public boolean sendRequestGetParamter() {
        this.cseq++;
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData((new ProtocolBuilder().getParameterCmd(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength(MessageService.MSG_ACCS_NOTIFY_CLICK).setUserAgent("AirPlay/150.33").getString(true) + PlistBuilder.VALUE_TYPE_VOLUME + "\r\n").getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        if (bArr == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, "GET_PARAMETER call back ----->" + new String(bArr));
        return true;
    }

    public boolean sendRequestRecord() {
        this.cseq++;
        byte[] interactiveData = this.mProtocolSender.interactiveData(new ProtocolBuilder().getRecordCmd(this.mLocalip).setRange(ProtocolBuilder.VALUE_NTP).setRtpinfo(ProtocolBuilder.VALUE_RTPINFO).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true));
        if (interactiveData == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, " RECORD call back  ----->" + new String(interactiveData));
        return true;
    }

    public boolean sendRequestSetOptions() {
        this.cseq++;
        byte[] protocal = new ProtocolBuilder().getOptionsCmd().setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength("0").setUserAgent("AirPlay/150.33").getProtocal(true);
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender == null) {
            return false;
        }
        byte[] bArr = new byte[0];
        try {
            bArr = protocolSender.interactiveData(protocal);
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        if (bArr == null) {
            CLog.i(TAG, "Session End");
        } else {
            try {
                CLog.i(TAG, "startCapture in options exe keep-alive-->" + new String(bArr));
            } catch (Exception e11) {
                CLog.w(TAG, (Throwable) e11);
            }
        }
        return true;
    }

    public boolean sendRequestSetParamter() {
        this.cseq++;
        String str = new ProtocolBuilder().getSetParameterCmd(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength("19").setUserAgent("AirPlay/150.33").getString(true) + "volume: -3.000000" + "\r\n";
        CLog.i(TAG, "SET_PARAMETER call back ----->" + new String(str));
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData(str.getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, (Throwable) e10);
        }
        if (bArr != null) {
            return true;
        }
        this.mProtocolSender.release();
        return false;
    }

    public boolean sendRequestSetTeardown() {
        if (this.mProtocolSender != null) {
            this.cseq++;
            byte[] bArr = new byte[0];
            try {
                bArr = this.mProtocolSender.interactiveData(new ProtocolBuilder().getTearDown(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setUserAgent("AirPlay/150.33").getProtocal(true));
            } catch (Exception e10) {
                CLog.w(TAG, (Throwable) e10);
            }
            if (bArr != null) {
                CLog.i(TAG, "sendRequestSetTeardown result -->" + new String(bArr));
            }
            release();
        }
        return true;
    }

    public int sendRequestVideoSetup(int i10, int i11) {
        this.cseq++;
        byte[] interactiveData = this.mProtocolSender.interactiveData(new ProtocolBuilder().getVideoSetUpCmd(this.mLocalip).setTransport(ProtocolBuilder.VALUE_VIDEO_TRANSPORT).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setContentLength("0").setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true));
        if (interactiveData == null) {
            this.mProtocolSender.release();
            return 0;
        }
        CLog.i(TAG, "SETUP call back agin ----->" + new String(interactiveData));
        return 1;
    }

    public boolean setMirrorMode(String str) {
        return false;
    }

    public void setSinkHeight(int i10) {
        this.mHeight = i10;
    }

    public void setSinkWidth(int i10) {
        this.mWidth = i10;
    }
}
