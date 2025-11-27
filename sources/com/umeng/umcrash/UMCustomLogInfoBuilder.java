package com.umeng.umcrash;

import android.text.TextUtils;
import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;
import com.uc.crashsdk.export.CustomLogInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UMCustomLogInfoBuilder {
    public static final String LINE_SEP = "\n";
    public static final String LOG_KEY_AC = "k_ac";
    public static final String LOG_KEY_CT = "k_ct";
    private static final String LOG_KEY_STACK_FUNC = "stackFunc";
    private static final String LOG_KEY_STACK_HASH = "stackHash";
    public static final String LOG_SECTION_SEP = "--- --- --- --- --- --- --- --- --- --- --- --- --- --- --- ---";
    public static final String LOG_TYPE = "exception";
    private Map<String, String> kvInfoMap = new HashMap(20);
    private CustomLogInfo mCustomLogInfo = new CustomLogInfo(new StringBuffer(), "exception");
    private List<String> sectionList = new ArrayList(5);
    private String stack;

    public UMCustomLogInfoBuilder(String str) {
        this.kvInfoMap.put(LOG_KEY_CT, "exception");
        this.kvInfoMap.put(LOG_KEY_AC, str);
    }

    public UMCustomLogInfoBuilder addLogCat(boolean z10) {
        this.mCustomLogInfo.mAddLogcat = z10;
        return this;
    }

    public UMCustomLogInfoBuilder addSection(String str) {
        this.sectionList.add(str);
        return this;
    }

    public CustomLogInfo build() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : this.kvInfoMap.entrySet()) {
            stringBuffer.append((String) next.getKey());
            stringBuffer.append(SOAP.DELIM);
            stringBuffer.append((String) next.getValue());
            stringBuffer.append("\n");
        }
        if (!TextUtils.isEmpty(this.stack)) {
            stringBuffer.append(this.stack);
            stringBuffer.append("\n");
        }
        for (String append : this.sectionList) {
            stringBuffer.append(LOG_SECTION_SEP);
            stringBuffer.append("\n");
            stringBuffer.append(append);
            stringBuffer.append("\n");
        }
        CustomLogInfo customLogInfo = this.mCustomLogInfo;
        customLogInfo.mData = stringBuffer;
        return customLogInfo;
    }

    public UMCustomLogInfoBuilder put(String str, String str2) {
        if (!LOG_KEY_AC.equals(str) && !LOG_KEY_CT.equals(str)) {
            this.kvInfoMap.put(str, str2);
        }
        return this;
    }

    public UMCustomLogInfoBuilder stack(Throwable th, String str) {
        return stack(Log.getStackTraceString(th), str);
    }

    public UMCustomLogInfoBuilder stackFunc(String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_FUNC, str);
        return this;
    }

    public UMCustomLogInfoBuilder stackHash(String str) {
        this.kvInfoMap.put(LOG_KEY_STACK_HASH, str);
        return this;
    }

    public UMCustomLogInfoBuilder uploadNow(boolean z10) {
        this.mCustomLogInfo.mUploadNow = z10;
        return this;
    }

    public UMCustomLogInfoBuilder stack(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        this.stack = "Exception message:" + str2 + "\n" + "Back traces starts." + "\n" + str + "Back traces ends.";
        return this;
    }
}
