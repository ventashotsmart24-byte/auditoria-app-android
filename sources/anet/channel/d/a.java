package anet.channel.d;

import anet.channel.util.ALog;
import com.taobao.tlog.adapter.AdapterForTLog;

public class a implements ALog.ILog {
    private int a(char c10) {
        if (c10 == 'D') {
            return 1;
        }
        if (c10 == 'E') {
            return 4;
        }
        if (c10 == 'I') {
            return 2;
        }
        if (c10 != 'V') {
            return c10 != 'W' ? 5 : 3;
        }
        return 0;
    }

    public void d(String str, String str2) {
        AdapterForTLog.logd(str, str2);
    }

    public void e(String str, String str2) {
        AdapterForTLog.loge(str, str2);
    }

    public void i(String str, String str2) {
        AdapterForTLog.logi(str, str2);
    }

    public boolean isPrintLog(int i10) {
        if (i10 >= a(AdapterForTLog.getLogLevel().charAt(0))) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        return AdapterForTLog.isValid();
    }

    public void setLogLevel(int i10) {
    }

    public void w(String str, String str2) {
        AdapterForTLog.logw(str, str2);
    }

    public void e(String str, String str2, Throwable th) {
        AdapterForTLog.loge(str, str2, th);
    }

    public void w(String str, String str2, Throwable th) {
        AdapterForTLog.logw(str, str2, th);
    }
}
