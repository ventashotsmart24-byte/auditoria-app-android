package com.efs.sdk.base.core.model;

import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.efs.sdk.base.protocol.ILogProtocol;
import java.io.File;

public class LogDto {

    /* renamed from: a  reason: collision with root package name */
    private a f5276a;

    /* renamed from: b  reason: collision with root package name */
    private b f5277b = new b();

    /* renamed from: c  reason: collision with root package name */
    private byte[] f5278c;

    /* renamed from: d  reason: collision with root package name */
    private File f5279d;

    public LogDto(String str, byte b10) {
        this.f5276a = new a(str, b10);
    }

    private void a() {
        if (getLogBodyType() == 0 && getData() != null) {
            this.f5276a.f5285f = (long) getData().length;
        } else if (getLogBodyType() == 1 && getFile().exists()) {
            this.f5276a.f5285f = getFile().length();
        }
    }

    public static LogDto buildLogDto(ILogProtocol iLogProtocol) {
        LogDto logDto = null;
        try {
            LogDto logDto2 = new LogDto(iLogProtocol.getLogType(), iLogProtocol.getLogProtocol());
            try {
                int bodyType = iLogProtocol.getBodyType();
                if (bodyType == 0) {
                    logDto2.setLogBodyType(0);
                    logDto2.setData(iLogProtocol.generate());
                    if (!Constants.LOG_TYPE_CODELOGPERF.equals(logDto2.getLogType())) {
                        return logDto2;
                    }
                    logDto2.setUid(ControllerCenter.getGlobalEnvStruct().getLogUid());
                    logDto2.setDid(ControllerCenter.getGlobalEnvStruct().getLogDid());
                    logDto2.setBeginTime(iLogProtocol.getLogBeginTime());
                    logDto2.setEndTime(iLogProtocol.getLogEndTime());
                    return logDto2;
                } else if (bodyType != 1) {
                    Log.w("efs.base", "Can not support body type: " + iLogProtocol.getBodyType());
                    return logDto2;
                } else {
                    logDto2.setLogBodyType(1);
                    logDto2.setFile(new File(iLogProtocol.getFilePath()));
                    return logDto2;
                }
            } catch (Exception e10) {
                e = e10;
                logDto = logDto2;
                Log.e("efs.base", "log send error", e);
                return logDto;
            }
        } catch (Exception e11) {
            e = e11;
            Log.e("efs.base", "log send error", e);
            return logDto;
        }
    }

    public long getBeginTime() {
        return this.f5276a.f5289j;
    }

    public long getBodySize() {
        a();
        return this.f5276a.f5285f;
    }

    public String getCp() {
        return this.f5276a.f5283d;
    }

    public byte[] getData() {
        return this.f5278c;
    }

    public int getDe() {
        return this.f5276a.f5284e;
    }

    public String getDid() {
        return this.f5276a.f5288i;
    }

    public long getEndTime() {
        return this.f5276a.f5290k;
    }

    public File getFile() {
        return this.f5279d;
    }

    public int getLogBodyType() {
        return this.f5276a.f5282c;
    }

    public int getLogCnt() {
        return this.f5276a.f5286g;
    }

    public byte getLogProtocol() {
        return this.f5276a.f5281b;
    }

    public String getLogType() {
        return this.f5276a.f5280a;
    }

    public HttpResponse getResponseDto() {
        return this.f5277b.f5293c;
    }

    public String getUid() {
        return this.f5276a.f5287h;
    }

    public boolean isCp() {
        if (!"none".equals(this.f5276a.f5283d)) {
            return true;
        }
        return false;
    }

    public boolean isDe() {
        if (1 != this.f5276a.f5284e) {
            return true;
        }
        return false;
    }

    public boolean isLimitByFlow() {
        return this.f5277b.f5292b;
    }

    public boolean isSendImediately() {
        return this.f5277b.f5291a;
    }

    public void setBeginTime(long j10) {
        this.f5276a.f5289j = j10;
    }

    public void setCp(String str) {
        this.f5276a.f5283d = str;
    }

    public void setData(byte[] bArr) {
        this.f5278c = bArr;
        a();
    }

    public void setDe(int i10) {
        this.f5276a.f5284e = i10;
        a();
    }

    public void setDid(String str) {
        this.f5276a.f5288i = str;
    }

    public void setEndTime(long j10) {
        this.f5276a.f5290k = j10;
    }

    public void setFile(File file) {
        this.f5279d = file;
    }

    public void setLimitByFlow(boolean z10) {
        this.f5277b.f5292b = z10;
    }

    public void setLogBodyType(int i10) {
        this.f5276a.f5282c = i10;
    }

    public void setLogCnt(int i10) {
        this.f5276a.f5286g = i10;
    }

    public void setResponseDto(HttpResponse httpResponse) {
        this.f5277b.f5293c = httpResponse;
    }

    public void setSendImediately(boolean z10) {
        this.f5277b.f5291a = z10;
    }

    public void setUid(String str) {
        this.f5276a.f5287h = str;
    }
}
