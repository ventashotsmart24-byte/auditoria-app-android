package com.efs.sdk.base.core.d;

import com.efs.sdk.base.core.a.a;
import com.efs.sdk.base.core.config.GlobalInfo;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.protocol.record.AbsRecordLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class b extends AbsRecordLog {

    /* renamed from: a  reason: collision with root package name */
    private String f5252a;

    /* renamed from: b  reason: collision with root package name */
    private String f5253b;

    /* renamed from: c  reason: collision with root package name */
    private String f5254c;

    /* renamed from: d  reason: collision with root package name */
    private String f5255d;

    /* renamed from: e  reason: collision with root package name */
    private long f5256e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f5257f = 0;

    public b(String str, String str2, String str3) {
        super("wa");
        this.f5252a = str;
        this.f5253b = str2;
        this.f5255d = str3;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS", Locale.CHINA);
        a.a();
        this.f5254c = simpleDateFormat.format(new Date(a.b()));
    }

    public final byte[] generate() {
        String generateString = generateString();
        if (ControllerCenter.getGlobalEnvStruct().isPrintLogDetail()) {
            Log.i("efs.base", generateString);
        }
        return generateString.getBytes();
    }

    public final String generateString() {
        StringBuilder sb = new StringBuilder();
        sb.append("lt=event`");
        sb.append("ev_ct=");
        sb.append(this.f5252a);
        sb.append("`");
        sb.append("ev_ac=");
        sb.append(this.f5253b);
        sb.append("`");
        sb.append("tm=");
        sb.append(this.f5254c);
        sb.append("`");
        sb.append("dn=");
        sb.append(this.f5255d);
        sb.append("`");
        for (Map.Entry next : this.dataMap.entrySet()) {
            sb.append((String) next.getKey());
            sb.append(Operator.Operation.EQUALS);
            sb.append(next.getValue());
            sb.append("`");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    public final String getLinkId() {
        return "";
    }

    public final String getLinkKey() {
        return "";
    }

    public final long getLogBeginTime() {
        return this.f5256e;
    }

    public final long getLogEndTime() {
        return this.f5257f;
    }

    public final void insertGlobal(GlobalInfo globalInfo) {
        this.dataMap.putAll(globalInfo.getGlobalInfoMap());
        this.dataMap.putAll(ControllerCenter.getGlobalEnvStruct().getPublicParamMap());
    }

    public final void setLogBeginTime(long j10) {
        this.f5256e = j10;
    }

    public final void setLogEndTime(long j10) {
        this.f5257f = j10;
    }
}
