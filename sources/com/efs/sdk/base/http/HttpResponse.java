package com.efs.sdk.base.http;

import android.text.TextUtils;
import com.efs.sdk.base.core.model.c;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse extends c<Map<String, String>> {
    private static final String KEY_BIZ_CODE = "biz_code";
    private static final String KEY_REQUEST_URL = "req_url";
    public static final int REQUEST_ERROR_DEFAULT = -1;
    public static final int REQUEST_ERROR_NETWORK_DISCONNECT = -2;
    public static final int REQUEST_ERROR_SOCKET_TIMEOUT = -3;

    public HttpResponse() {
        this.extra = new HashMap();
    }

    public String getBizCode() {
        if (!((Map) this.extra).containsKey(KEY_BIZ_CODE)) {
            return "";
        }
        return (String) ((Map) this.extra).get(KEY_BIZ_CODE);
    }

    public int getHttpCode() {
        return this.code;
    }

    public String getReqUrl() {
        if (!((Map) this.extra).containsKey(KEY_REQUEST_URL)) {
            return "";
        }
        return (String) ((Map) this.extra).get(KEY_REQUEST_URL);
    }

    public void setBizCode(String str) {
        ((Map) this.extra).put(KEY_BIZ_CODE, str);
    }

    public void setHttpCode(int i10) {
        boolean z10;
        if ((i10 < 200 || i10 >= 300) && i10 != 304) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.succ = z10;
        this.code = i10;
    }

    public void setReqUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.contains(Operator.Operation.EMPTY_PARAM)) {
            str = str.substring(0, str.indexOf(Operator.Operation.EMPTY_PARAM));
        }
        ((Map) this.extra).put(KEY_REQUEST_URL, str);
    }

    public String toString() {
        return "HttpResponse {succ=" + this.succ + ", code=" + this.code + ", data='" + this.data + '\'' + ", extra=" + this.extra + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
