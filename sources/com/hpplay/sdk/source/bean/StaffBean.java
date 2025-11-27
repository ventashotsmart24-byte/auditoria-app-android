package com.hpplay.sdk.source.bean;

import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.log.SourceLog;
import java.net.URLEncoder;

@Deprecated
public class StaffBean {
    private static String TAG = "StaffBean";
    public String department;
    public String jobNumber;
    public String mirrorUri;

    public void setDepartment(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.department = URLEncoder.encode(str, XML.CHARSET_UTF8);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }

    public void setJobNumber(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.jobNumber = URLEncoder.encode(str, XML.CHARSET_UTF8);
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        }
    }
}
