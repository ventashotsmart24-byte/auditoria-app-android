package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.a;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import com.taobao.accs.utl.o;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.r;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class Message implements Serializable {
    public static int CONTROL_MAX_RETRY_TIMES = 5;
    public static final int EXT_HEADER_VALUE_MAX_LEN = 1023;
    public static final int FLAG_ACK_TYPE = 32;
    public static final int FLAG_BIZ_RET = 64;
    public static final int FLAG_DATA_TYPE = 32768;
    public static final int FLAG_ERR = 4096;
    public static final int FLAG_REQ_BIT1 = 16384;
    public static final int FLAG_REQ_BIT2 = 8192;
    public static final int FLAG_RET = 2048;
    public static final String KEY_BINDAPP = "ctrl_bindapp";
    public static final String KEY_BINDSERVICE = "ctrl_bindservice";
    public static final String KEY_BINDUSER = "ctrl_binduser";
    public static final String KEY_UNBINDAPP = "ctrl_unbindapp";
    public static final String KEY_UNBINDSERVICE = "ctrl_unbindservice";
    public static final String KEY_UNBINDUSER = "ctrl_unbinduser";
    public static final int MAX_RETRY_TIMES = 3;

    /* renamed from: a  reason: collision with root package name */
    static long f12930a = 1;
    String A = null;
    String B = null;
    String C = null;
    byte[] D;
    int E;
    long F;
    transient NetPerformanceMonitor G;
    String H = null;
    Id I;
    public String appSign = null;

    /* renamed from: b  reason: collision with root package name */
    byte f12931b = 0;
    public String bizId = null;

    /* renamed from: c  reason: collision with root package name */
    byte f12932c = 0;
    public Integer command = null;
    public String cunstomDataId;

    /* renamed from: d  reason: collision with root package name */
    short f12933d;
    public String dataId;
    public long delyTime = 0;

    /* renamed from: e  reason: collision with root package name */
    short f12934e;

    /* renamed from: f  reason: collision with root package name */
    short f12935f;
    public boolean force = false;

    /* renamed from: g  reason: collision with root package name */
    byte f12936g;

    /* renamed from: h  reason: collision with root package name */
    byte f12937h;
    public URL host;

    /* renamed from: i  reason: collision with root package name */
    String f12938i;
    public boolean isAck = false;
    public boolean isCancel = false;

    /* renamed from: j  reason: collision with root package name */
    String f12939j;

    /* renamed from: k  reason: collision with root package name */
    int f12940k = -1;

    /* renamed from: l  reason: collision with root package name */
    Map<Integer, String> f12941l;

    /* renamed from: m  reason: collision with root package name */
    String f12942m = null;

    /* renamed from: n  reason: collision with root package name */
    Integer f12943n = 0;

    /* renamed from: o  reason: collision with root package name */
    String f12944o = null;

    /* renamed from: p  reason: collision with root package name */
    Integer f12945p = null;

    /* renamed from: q  reason: collision with root package name */
    String f12946q = null;

    /* renamed from: r  reason: collision with root package name */
    String f12947r = null;
    public int retryTimes = 0;

    /* renamed from: s  reason: collision with root package name */
    String f12948s = null;
    public String serviceId = null;
    public long startSendTime;

    /* renamed from: t  reason: collision with root package name */
    String f12949t = null;
    public int timeout = a.ACCS_RECEIVE_TIMEOUT;

    /* renamed from: u  reason: collision with root package name */
    String f12950u = null;
    public String userinfo = null;

    /* renamed from: v  reason: collision with root package name */
    Integer f12951v = null;

    /* renamed from: w  reason: collision with root package name */
    String f12952w = null;

    /* renamed from: x  reason: collision with root package name */
    String f12953x = null;

    /* renamed from: y  reason: collision with root package name */
    String f12954y = null;

    /* renamed from: z  reason: collision with root package name */
    String f12955z = null;

    public static class Id implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        private int f12956a;

        /* renamed from: b  reason: collision with root package name */
        private String f12957b;

        public Id(int i10, String str) {
            this.f12956a = i10;
            this.f12957b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Id id = (Id) obj;
            if (this.f12956a == id.getId() || this.f12957b.equals(id.getDataId())) {
                return true;
            }
            return false;
        }

        public String getDataId() {
            return this.f12957b;
        }

        public int getId() {
            return this.f12956a;
        }

        public int hashCode() {
            return this.f12957b.hashCode();
        }
    }

    public static class MsgResType implements Serializable {
        public static final int INVALID = -1;
        public static final int NEED_ACK = 1;
        public static final int NO_ACK = 0;

        public static String name(int i10) {
            return i10 != 0 ? i10 != 1 ? "INVALID" : "NEED_ACK" : "NO_ACK";
        }

        public static int valueOf(int i10) {
            return i10 != 0 ? 1 : 0;
        }
    }

    public static class MsgType implements Serializable {
        public static final int CONTROL = 0;
        public static final int DATA = 1;
        public static final int HANDSHAKE = 3;
        public static final int INVALID = -1;
        public static final int PING = 2;

        public static String name(int i10) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "INVALID" : "HANDSHAKE" : "PING" : "DATA" : "CONTROL";
        }

        public static int valueOf(int i10) {
            int i11 = 1;
            if (i10 != 1) {
                i11 = 2;
                if (i10 != 2) {
                    i11 = 3;
                    if (i10 != 3) {
                        return 0;
                    }
                }
            }
            return i11;
        }
    }

    public enum ReqType {
        DATA,
        ACK,
        REQ,
        RES;

        public static ReqType valueOf(int i10) {
            if (i10 == 0) {
                return DATA;
            }
            if (i10 == 1) {
                return ACK;
            }
            if (i10 == 2) {
                return REQ;
            }
            if (i10 != 3) {
                return DATA;
            }
            return RES;
        }
    }

    private Message() {
        synchronized (Message.class) {
            this.startSendTime = System.currentTimeMillis();
            String str = this.startSendTime + "." + f12930a;
            this.dataId = str;
            long j10 = f12930a;
            f12930a = 1 + j10;
            this.I = new Id((int) j10, str);
        }
    }

    public static Message BuildPing(boolean z10, int i10) {
        Message message = new Message();
        message.f12940k = 2;
        message.command = 201;
        message.force = z10;
        message.delyTime = (long) i10;
        return message;
    }

    public static Message buildBackground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f12938i = Constants.TARGET_BACK;
        a(str, message);
        return message;
    }

    @Deprecated
    public static Message buildBindApp(a aVar, Context context, Intent intent) {
        return buildBindApp(aVar.b((String) null), aVar.f13037m, context, intent);
    }

    @Deprecated
    public static Message buildBindService(a aVar, Context context, Intent intent) {
        return buildBindService(aVar.b((String) null), aVar.f13037m, intent);
    }

    @Deprecated
    public static Message buildBindUser(a aVar, Context context, Intent intent) {
        return buildBindUser(aVar.b((String) null), aVar.f13037m, intent);
    }

    public static Message buildErrorReportMessage(String str, String str2, String str3, int i10) {
        Message message = new Message();
        try {
            message.host = new URL(str3);
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
        }
        message.f12938i = Constants.TARGET_SERVICE_ST;
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.D = (0 + "|" + i10 + "|" + str + "|" + j.b(GlobalClientInfo.getContext()) + "|" + str2).getBytes();
        return message;
    }

    public static Message buildForeground(String str) {
        Message message = new Message();
        message.a(1, ReqType.DATA, 0);
        message.command = 100;
        message.f12938i = Constants.TARGET_FORE;
        a(str, message);
        return message;
    }

    public static Message buildHandshake(String str) {
        Message message = new Message();
        message.a(3, ReqType.DATA, 1);
        message.f12942m = str;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 200;
        return message;
    }

    public static Message buildParameterError(String str, int i10) {
        Message message = new Message();
        message.a(1, ReqType.ACK, 0);
        message.command = Integer.valueOf(i10);
        message.f12942m = str;
        return message;
    }

    @Deprecated
    public static Message buildPushAck(a aVar, String str, String str2, String str3, boolean z10, short s10, String str4, Map<Integer, String> map) {
        return buildPushAck(aVar.b((String) null), aVar.f13037m, str, str2, str3, z10, s10, str4, map);
    }

    @Deprecated
    public static Message buildRequest(a aVar, Context context, String str, String str2, String str3, ACCSManager.AccsRequest accsRequest, boolean z10) {
        return buildRequest(context, aVar.b((String) null), aVar.f13037m, aVar.f13033i.getStoreId(), str, str2, accsRequest, z10);
    }

    @Deprecated
    public static Message buildSendData(a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(aVar.b((String) null), aVar.f13037m, aVar.f13033i.getStoreId(), context, str, accsRequest, true);
    }

    @Deprecated
    public static Message buildUnbindApp(a aVar, Context context, Intent intent) {
        return buildUnbindApp(aVar.b((String) null), intent);
    }

    @Deprecated
    public static Message buildUnbindService(a aVar, Context context, Intent intent) {
        return buildUnbindService(aVar.b((String) null), aVar.f13037m, intent);
    }

    @Deprecated
    public static Message buildUnbindUser(a aVar, Context context, Intent intent) {
        return buildUnbindUser(aVar.b((String) null), aVar.f13037m, intent);
    }

    private String c() {
        return "Msg" + "_" + this.H;
    }

    public short a(Map<Integer, String> map) {
        short s10 = 0;
        if (map != null) {
            try {
                for (Integer intValue : map.keySet()) {
                    String str = map.get(Integer.valueOf(intValue.intValue()));
                    if (!TextUtils.isEmpty(str)) {
                        s10 = (short) (s10 + ((short) (str.getBytes(XML.CHARSET_UTF8).length & EXT_HEADER_VALUE_MAX_LEN)) + 2);
                    }
                }
            } catch (Exception e10) {
                e10.toString();
            }
        }
        return s10;
    }

    public void b() {
        Integer num;
        Integer num2 = this.command;
        if (num2 != null && num2.intValue() != 100 && this.command.intValue() != 102) {
            p.a aVar = new p.a();
            if (this.command.intValue() == 100) {
                num = null;
            } else {
                num = this.command;
            }
            this.D = aVar.a("command", num).a(Constants.KEY_APP_KEY, this.f12944o).a(Constants.KEY_OS_TYPE, this.f12945p).a("sign", this.appSign).a(Constants.KEY_SDK_VERSION, this.f12951v).a("appVersion", this.f12950u).a(Constants.KEY_TTID, this.f12952w).a(Constants.KEY_MODEL, this.f12954y).a(Constants.KEY_BRAND, this.f12955z).a("imei", this.A).a(Constants.KEY_IMSI, this.B).a(Constants.KYE_MAC_ADDRESS, this.f12953x).a("os", this.f12946q).a(Constants.KEY_EXTS, this.f12949t).a().toString().getBytes(XML.CHARSET_UTF8);
        }
    }

    public byte[] build(Context context, int i10) {
        String str;
        byte[] bArr;
        int i11;
        try {
            b();
        } catch (JSONException e10) {
            ALog.e(c(), "build1", e10, new Object[0]);
        } catch (UnsupportedEncodingException e11) {
            ALog.e(c(), "build2", e11, new Object[0]);
        }
        byte[] bArr2 = this.D;
        if (bArr2 != null) {
            str = new String(bArr2);
        } else {
            str = "";
        }
        a();
        if (!this.isAck) {
            StringBuilder sb = new StringBuilder();
            sb.append(UtilityImpl.j(context));
            sb.append("|");
            sb.append(this.f12942m);
            sb.append("|");
            String str2 = this.serviceId;
            if (str2 == null) {
                str2 = "";
            }
            sb.append(str2);
            sb.append("|");
            String str3 = this.userinfo;
            if (str3 == null) {
                str3 = "";
            }
            sb.append(str3);
            this.f12939j = sb.toString();
        }
        try {
            bArr = (this.dataId + "").getBytes(XML.CHARSET_UTF8);
            this.f12937h = (byte) this.f12939j.getBytes(XML.CHARSET_UTF8).length;
            this.f12936g = (byte) this.f12938i.getBytes(XML.CHARSET_UTF8).length;
        } catch (Exception e12) {
            e12.printStackTrace();
            ALog.e(c(), "build3", e12, new Object[0]);
            bArr = (this.dataId + "").getBytes();
            this.f12937h = (byte) this.f12939j.getBytes().length;
            this.f12936g = (byte) this.f12938i.getBytes().length;
        }
        short a10 = a(this.f12941l);
        int length = this.f12936g + 3 + 1 + this.f12937h + 1 + bArr.length;
        byte[] bArr3 = this.D;
        if (bArr3 == null) {
            i11 = 0;
        } else {
            i11 = bArr3.length;
        }
        short s10 = (short) (length + i11 + a10 + 2);
        this.f12934e = s10;
        this.f12933d = (short) (s10 + 2);
        r rVar = new r(this.f12933d + 2 + 4);
        ALog.Level level = ALog.Level.D;
        if (ALog.isPrintLog(level)) {
            ALog.d(c(), "Build Message", Constants.KEY_DATA_ID, new String(bArr));
        }
        try {
            rVar.a((byte) (this.f12931b | 32));
            if (ALog.isPrintLog(level)) {
                String c10 = c();
                ALog.d(c10, "\tversion:2 compress:" + this.f12931b, new Object[0]);
            }
            if (i10 == 0) {
                rVar.a((byte) UnsignedBytes.MAX_POWER_OF_TWO);
                if (ALog.isPrintLog(level)) {
                    ALog.d(c(), "\tflag: 0x80", new Object[0]);
                }
            } else {
                rVar.a((byte) SignedBytes.MAX_POWER_OF_TWO);
                if (ALog.isPrintLog(level)) {
                    ALog.d(c(), "\tflag: 0x40", new Object[0]);
                }
            }
            rVar.a(this.f12933d);
            if (ALog.isPrintLog(level)) {
                String c11 = c();
                ALog.d(c11, "\ttotalLength:" + this.f12933d, new Object[0]);
            }
            rVar.a(this.f12934e);
            if (ALog.isPrintLog(level)) {
                String c12 = c();
                ALog.d(c12, "\tdataLength:" + this.f12934e, new Object[0]);
            }
            rVar.a(this.f12935f);
            if (ALog.isPrintLog(level)) {
                String c13 = c();
                ALog.d(c13, "\tflags:" + Integer.toHexString(this.f12935f), new Object[0]);
            }
            rVar.a(this.f12936g);
            if (ALog.isPrintLog(level)) {
                String c14 = c();
                ALog.d(c14, "\ttargetLength:" + this.f12936g, new Object[0]);
            }
            rVar.write(this.f12938i.getBytes(XML.CHARSET_UTF8));
            if (ALog.isPrintLog(level)) {
                String c15 = c();
                ALog.d(c15, "\ttarget:" + this.f12938i, new Object[0]);
            }
            rVar.a(this.f12937h);
            if (ALog.isPrintLog(level)) {
                String c16 = c();
                ALog.d(c16, "\tsourceLength:" + this.f12937h, new Object[0]);
            }
            rVar.write(this.f12939j.getBytes(XML.CHARSET_UTF8));
            if (ALog.isPrintLog(level)) {
                String c17 = c();
                ALog.d(c17, "\tsource:" + this.f12939j, new Object[0]);
            }
            rVar.a((byte) bArr.length);
            if (ALog.isPrintLog(level)) {
                String c18 = c();
                ALog.d(c18, "\tdataIdLength:" + bArr.length, new Object[0]);
            }
            rVar.write(bArr);
            if (ALog.isPrintLog(level)) {
                String c19 = c();
                ALog.d(c19, "\tdataId:" + new String(bArr), new Object[0]);
            }
            rVar.a(a10);
            if (ALog.isPrintLog(level)) {
                String c20 = c();
                ALog.d(c20, "\textHeader len:" + a10, new Object[0]);
            }
            Map<Integer, String> map = this.f12941l;
            if (map != null) {
                for (Integer intValue : map.keySet()) {
                    int intValue2 = intValue.intValue();
                    String str4 = this.f12941l.get(Integer.valueOf(intValue2));
                    if (!TextUtils.isEmpty(str4)) {
                        rVar.a((short) ((((short) intValue2) << 10) | ((short) (str4.getBytes(XML.CHARSET_UTF8).length & EXT_HEADER_VALUE_MAX_LEN))));
                        rVar.write(str4.getBytes(XML.CHARSET_UTF8));
                        if (ALog.isPrintLog(ALog.Level.D)) {
                            String c21 = c();
                            ALog.d(c21, "\textHeader key:" + intValue2 + " value:" + str4, new Object[0]);
                        }
                    }
                }
            }
            byte[] bArr4 = this.D;
            if (bArr4 != null) {
                rVar.write(bArr4);
            }
            if (ALog.isPrintLog(ALog.Level.D)) {
                String c22 = c();
                ALog.d(c22, "\toriData:" + str, new Object[0]);
            }
            rVar.flush();
        } catch (IOException e13) {
            ALog.e(c(), "build4", e13, new Object[0]);
        }
        byte[] byteArray = rVar.toByteArray();
        try {
            rVar.close();
        } catch (IOException e14) {
            ALog.e(c(), "build5", e14, new Object[0]);
        }
        return byteArray;
    }

    public String getDataId() {
        return this.dataId;
    }

    public long getDelyTime() {
        return this.delyTime;
    }

    public Id getMsgId() {
        return this.I;
    }

    public NetPerformanceMonitor getNetPermanceMonitor() {
        return this.G;
    }

    public int getNode() {
        return this.E;
    }

    public String getPackageName() {
        String str = this.f12942m;
        if (str == null) {
            return "";
        }
        return str;
    }

    public int getRetryTimes() {
        return this.retryTimes;
    }

    public int getType() {
        return this.f12940k;
    }

    public boolean isControlFrame() {
        return Constants.TARGET_CONTROL.equals(this.f12938i);
    }

    public boolean isTimeOut() {
        boolean z10;
        if ((System.currentTimeMillis() - this.startSendTime) + this.delyTime >= ((long) this.timeout)) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            String c10 = c();
            ALog.e(c10, "delay time:" + this.delyTime + " beforeSendTime:" + (System.currentTimeMillis() - this.startSendTime) + " timeout" + this.timeout, new Object[0]);
        }
        return z10;
    }

    public void setSendTime(long j10) {
        this.F = j10;
    }

    public static Message buildBindApp(String str, String str2, Context context, Intent intent) {
        Message message = null;
        try {
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            Context context2 = context;
            String str3 = str2;
            message = buildBindApp(context2, str3, intent.getStringExtra(Constants.KEY_APP_KEY), intent.getStringExtra("app_sercet"), stringExtra, intent.getStringExtra(Constants.KEY_TTID), intent.getStringExtra("appVersion"));
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindApp", e10.getMessage());
            return message;
        }
    }

    public static Message buildBindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindService", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildBindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildBindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_USER_ID));
            if (message != null) {
                message.H = str2;
                a(str, message);
            }
        } catch (Exception e10) {
            ALog.e("Msg", "buildBindUser", e10, new Object[0]);
            e10.printStackTrace();
        }
        return message;
    }

    public static Message buildPushAck(String str, String str2, String str3, String str4, String str5, boolean z10, short s10, String str6, Map<Integer, String> map) {
        Message message = new Message();
        message.E = 1;
        message.a(s10, z10);
        message.f12939j = str3;
        message.f12938i = str4;
        message.dataId = str5;
        message.isAck = true;
        message.f12941l = map;
        try {
            if (TextUtils.isEmpty(str6)) {
                message.host = new URL(str);
            } else {
                message.host = new URL(str6);
            }
            message.H = str2;
            if (message.host == null) {
                try {
                    message.host = new URL(str);
                } catch (MalformedURLException e10) {
                    e10.printStackTrace();
                }
            }
        } catch (Throwable th) {
            if (message.host == null) {
                try {
                    message.host = new URL(str);
                } catch (MalformedURLException e11) {
                    e11.printStackTrace();
                }
            }
            throw th;
        }
        return message;
    }

    public static Message buildRequest(Context context, String str, String str2, String str3, String str4, String str5, ACCSManager.AccsRequest accsRequest, boolean z10) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.REQ, 1);
        message.command = 100;
        message.f12942m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str6 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(str5);
        sb.append(str6);
        sb.append("|");
        String str7 = accsRequest.target;
        if (str7 == null) {
            str7 = "";
        }
        sb.append(str7);
        message.f12938i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        message.H = str2;
        int i10 = accsRequest.timeout;
        if (i10 > 0) {
            message.timeout = i10;
        }
        if (z10) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f12901c, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.G = netPerformanceMonitor;
        netPerformanceMonitor.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    @Deprecated
    public static Message buildSendData(a aVar, Context context, String str, String str2, ACCSManager.AccsRequest accsRequest, boolean z10) {
        return buildSendData(aVar.b((String) null), aVar.f13037m, aVar.f13033i.getStoreId(), context, str, accsRequest, z10);
    }

    public static Message buildUnbindApp(String str, Intent intent) {
        ALog.e("Msg", "buildUnbindApp1" + UtilityImpl.a((Throwable) new Exception()), new Object[0]);
        Message message = null;
        try {
            message = buildUnbindApp(str, intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindApp1", e10.getMessage());
            return message;
        }
    }

    public static Message buildUnbindService(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindService(intent.getStringExtra(Constants.KEY_PACKAGE_NAME), intent.getStringExtra(Constants.KEY_SERVICE_ID));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindService", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildUnbindUser(String str, String str2, Intent intent) {
        Message message = null;
        try {
            message = buildUnbindUser(intent.getStringExtra(Constants.KEY_PACKAGE_NAME));
            message.H = str2;
            a(str, message);
            return message;
        } catch (Exception e10) {
            ALog.e("Msg", "buildUnbindUser", e10, new Object[0]);
            e10.printStackTrace();
            return message;
        }
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest) {
        return buildSendData(str, str2, str3, context, str4, accsRequest, true);
    }

    public static Message buildSendData(String str, String str2, String str3, Context context, String str4, ACCSManager.AccsRequest accsRequest, boolean z10) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.command = 100;
        message.f12942m = str4;
        message.serviceId = accsRequest.serviceId;
        message.userinfo = accsRequest.userId;
        message.D = accsRequest.data;
        String str5 = TextUtils.isEmpty(accsRequest.targetServiceName) ? accsRequest.serviceId : accsRequest.targetServiceName;
        StringBuilder sb = new StringBuilder();
        sb.append(Constants.TARGET_SERVICE_PRE);
        sb.append(str5);
        sb.append("|");
        String str6 = accsRequest.target;
        if (str6 == null) {
            str6 = "";
        }
        sb.append(str6);
        message.f12938i = sb.toString();
        if (TextUtils.isEmpty(accsRequest.dataId)) {
            accsRequest.dataId = message.getMsgId().getDataId();
        }
        message.cunstomDataId = accsRequest.dataId;
        message.bizId = accsRequest.businessId;
        int i10 = accsRequest.timeout;
        if (i10 > 0) {
            message.timeout = i10;
        }
        if (z10) {
            a(str, message, accsRequest);
        } else {
            message.host = accsRequest.host;
        }
        a(message, GlobalClientInfo.getInstance(context).getSid(str2), GlobalClientInfo.getInstance(context).getUserId(str2), str3, GlobalClientInfo.f12901c, accsRequest.businessId, accsRequest.tag);
        NetPerformanceMonitor netPerformanceMonitor = new NetPerformanceMonitor();
        message.G = netPerformanceMonitor;
        netPerformanceMonitor.setMsgType(0);
        message.G.setDataId(accsRequest.dataId);
        message.G.setServiceId(accsRequest.serviceId);
        message.G.setHost(message.host.toString());
        message.H = str2;
        return message;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.util.zip.GZIPOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004b A[SYNTHETIC, Splitter:B:25:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r6 = this;
            r0 = 0
            byte[] r1 = r6.D     // Catch:{ all -> 0x0037 }
            if (r1 != 0) goto L_0x0006
            return
        L_0x0006:
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0037 }
            r1.<init>()     // Catch:{ all -> 0x0037 }
            java.util.zip.GZIPOutputStream r2 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x0032 }
            r2.<init>(r1)     // Catch:{ all -> 0x0032 }
            byte[] r0 = r6.D     // Catch:{ all -> 0x0030 }
            r2.write(r0)     // Catch:{ all -> 0x0030 }
            r2.finish()     // Catch:{ all -> 0x0030 }
            byte[] r0 = r1.toByteArray()     // Catch:{ all -> 0x0030 }
            if (r0 == 0) goto L_0x0029
            int r3 = r0.length     // Catch:{ all -> 0x0030 }
            byte[] r4 = r6.D     // Catch:{ all -> 0x0030 }
            int r4 = r4.length     // Catch:{ all -> 0x0030 }
            if (r3 >= r4) goto L_0x0029
            r6.D = r0     // Catch:{ all -> 0x0030 }
            r0 = 1
            r6.f12931b = r0     // Catch:{ all -> 0x0030 }
        L_0x0029:
            r2.close()     // Catch:{ Exception -> 0x0051 }
        L_0x002c:
            r1.close()     // Catch:{ Exception -> 0x0051 }
            goto L_0x0051
        L_0x0030:
            r0 = move-exception
            goto L_0x003b
        L_0x0032:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x003b
        L_0x0037:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x003b:
            java.lang.String r3 = r6.c()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r0.toString()     // Catch:{ all -> 0x0052 }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x0052 }
            r0.printStackTrace()     // Catch:{ all -> 0x0052 }
            if (r2 == 0) goto L_0x004e
            r2.close()     // Catch:{ Exception -> 0x0051 }
        L_0x004e:
            if (r1 == 0) goto L_0x0051
            goto L_0x002c
        L_0x0051:
            return
        L_0x0052:
            r0 = move-exception
            if (r2 == 0) goto L_0x0058
            r2.close()     // Catch:{ Exception -> 0x005d }
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            r1.close()     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            goto L_0x005f
        L_0x005e:
            throw r0
        L_0x005f:
            goto L_0x005e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.Message.a():void");
    }

    @Deprecated
    public static Message buildUnbindApp(a aVar, Context context, String str, String str2, String str3, String str4) {
        return buildUnbindApp(aVar.b((String) null), str);
    }

    public static Message buildUnbindApp(String str, String str2) {
        Message message = null;
        try {
            ALog.d("Msg", "buildUnbindApp", new Object[0]);
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            Message message2 = new Message();
            try {
                message2.E = 1;
                message2.a(1, ReqType.DATA, 1);
                message2.f12942m = str2;
                message2.f12938i = Constants.TARGET_CONTROL;
                message2.command = 2;
                message2.f12942m = str2;
                message2.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
                message2.cunstomDataId = KEY_UNBINDAPP;
                a(str, message2);
                return message2;
            } catch (Exception e10) {
                e = e10;
                message = message2;
            }
        } catch (Exception e11) {
            e = e11;
            ALog.e("Msg", "buildUnbindApp", e.getMessage());
            return message;
        }
    }

    @Deprecated
    public static Message buildUnbindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildUnbindUser(str);
    }

    @Deprecated
    public static Message buildBindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildBindService(str, str3);
    }

    @Deprecated
    public static Message buildBindUser(Context context, String str, String str2, String str3, String str4, String str5) {
        return buildBindUser(str, str4);
    }

    @Deprecated
    public static Message buildUnbindService(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        return buildUnbindService(str, str3);
    }

    public static Message buildUnbindUser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f12942m = str;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 4;
        message.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDUSER;
        return message;
    }

    @Deprecated
    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        return buildBindApp(context, str, str2, str3, str4, str5, str6);
    }

    public static Message buildBindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f12942m = str;
        message.serviceId = str2;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 5;
        message.f12942m = str;
        message.serviceId = str2;
        message.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDSERVICE;
        return message;
    }

    public static Message buildBindUser(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f12942m = str;
        message.userinfo = str2;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 3;
        message.f12942m = str;
        message.userinfo = str2;
        message.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_BINDUSER;
        return message;
    }

    public static Message buildUnbindService(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f12942m = str;
        message.serviceId = str2;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 6;
        message.f12942m = str;
        message.serviceId = str2;
        message.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.cunstomDataId = KEY_UNBINDSERVICE;
        return message;
    }

    public static Message buildBindApp(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        if (TextUtils.isEmpty(str4)) {
            return null;
        }
        Message message = new Message();
        message.E = 1;
        message.a(1, ReqType.DATA, 1);
        message.f12945p = 1;
        message.f12946q = Build.VERSION.SDK_INT + "";
        message.f12942m = str4;
        message.f12938i = Constants.TARGET_CONTROL;
        message.command = 1;
        message.f12944o = str2;
        message.appSign = UtilityImpl.a(str2, str3, UtilityImpl.j(context));
        message.f12951v = Integer.valueOf(Constants.SDK_VERSION_CODE);
        message.f12950u = str6;
        message.f12942m = str4;
        message.f12952w = str5;
        message.f12954y = Build.MODEL;
        message.f12955z = Build.BRAND;
        message.cunstomDataId = KEY_BINDAPP;
        message.H = str;
        p.a aVar = new p.a();
        aVar.a("notifyEnable", UtilityImpl.o(context));
        aVar.a("romInfo", new o().a());
        message.f12949t = aVar.a().toString();
        UtilityImpl.a(context, Constants.SP_FILE_NAME, UtilityImpl.o(context));
        return message;
    }

    private static void a(String str, Message message, ACCSManager.AccsRequest accsRequest) {
        URL url = accsRequest.host;
        if (url == null) {
            try {
                message.host = new URL(str);
            } catch (MalformedURLException e10) {
                ALog.e("Msg", "setUnit", e10, new Object[0]);
                e10.printStackTrace();
            }
        } else {
            message.host = url;
        }
    }

    private static void a(String str, Message message) {
        try {
            message.host = new URL(str);
        } catch (Exception e10) {
            ALog.e("Msg", "setControlHost", e10, new Object[0]);
        }
    }

    private static void a(Message message, String str, String str2, String str3, String str4, String str5, String str6) {
        if (!TextUtils.isEmpty(str5) || !TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str6) || str4 != null) {
            message.f12941l = new HashMap();
            if (str5 != null && UtilityImpl.a(str5) <= 1023) {
                message.f12941l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()), str5);
            }
            if (str != null && UtilityImpl.a(str) <= 1023) {
                message.f12941l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_SID.ordinal()), str);
            }
            if (str2 != null && UtilityImpl.a(str2) <= 1023) {
                message.f12941l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_USERID.ordinal()), str2);
            }
            if (str6 != null && UtilityImpl.a(str6) <= 1023) {
                message.f12941l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_TAG.ordinal()), str6);
            }
            if (str4 != null && UtilityImpl.a(str4) <= 1023) {
                message.f12941l.put(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_COOKIE.ordinal()), str4);
            }
            if (str3 != null && UtilityImpl.a(str3) <= 1023) {
                message.f12941l.put(19, str3);
            }
        }
    }

    private void a(int i10, ReqType reqType, int i11) {
        this.f12940k = i10;
        if (i10 != 2) {
            this.f12935f = (short) (((((i10 & 1) << 4) | (reqType.ordinal() << 2)) | i11) << 11);
        }
    }

    private void a(short s10, boolean z10) {
        this.f12940k = 1;
        short s11 = (short) (((short) (((short) (((short) (s10 & -16385)) | 8192)) & -2049)) & -65);
        this.f12935f = s11;
        if (z10) {
            this.f12935f = (short) (s11 | 32);
        }
    }
}
