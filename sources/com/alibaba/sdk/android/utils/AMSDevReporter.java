package com.alibaba.sdk.android.utils;

import android.content.Context;
import com.hpplay.cybergarage.http.HTTP;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AMSDevReporter {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<AMSSdkTypeEnum, AMSReportStatusEnum> f5050a = new ConcurrentHashMap<>();

    public enum AMSReportStatusEnum {
        UNREPORTED,
        REPORTED
    }

    public enum AMSSdkExtInfoKeyEnum {
        AMS_EXTINFO_KEY_VERSION("SdkVersion"),
        AMS_EXTINFO_KEY_PACKAGE("PackageName");
        
        private String description;

        private AMSSdkExtInfoKeyEnum(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    public enum AMSSdkTypeEnum {
        AMS_MAN(HTTP.MAN),
        AMS_HTTPDNS("HTTPDNS"),
        AMS_MPUSH("MPUSH"),
        AMS_MAC("MAC"),
        AMS_API("API"),
        AMS_HOTFIX("HOTFIX"),
        AMS_FEEDBACK("FEEDBACK"),
        AMS_IM("IM");
        
        private String description;

        private AMSSdkTypeEnum(String str) {
            this.description = str;
        }

        public String toString() {
            return this.description;
        }
    }

    static {
        for (AMSSdkTypeEnum put : AMSSdkTypeEnum.values()) {
            f5050a.put(put, AMSReportStatusEnum.REPORTED);
        }
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum) {
        b.a("Utils:DataTracker", "no man, do nothing");
    }

    public static AMSReportStatusEnum getReportStatus(AMSSdkTypeEnum aMSSdkTypeEnum) {
        return f5050a.get(aMSSdkTypeEnum);
    }

    public static void setLogEnabled(boolean z10) {
        b.setLogEnabled(z10);
    }

    public static void asyncReport(Context context, AMSSdkTypeEnum aMSSdkTypeEnum, Map<String, Object> map) {
        b.a("Utils:DataTracker", "no man, do nothing");
    }
}
