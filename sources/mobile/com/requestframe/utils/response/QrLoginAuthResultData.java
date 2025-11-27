package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import java.io.Serializable;
import t9.i;

public final class QrLoginAuthResultData implements Serializable {
    private QrLoginUserInfo qrLoginUserInfo;
    private String status;

    public QrLoginAuthResultData(String str, QrLoginUserInfo qrLoginUserInfo2) {
        i.g(str, Constant.KEY_STATUS);
        i.g(qrLoginUserInfo2, "qrLoginUserInfo");
        this.status = str;
        this.qrLoginUserInfo = qrLoginUserInfo2;
    }

    public static /* synthetic */ QrLoginAuthResultData copy$default(QrLoginAuthResultData qrLoginAuthResultData, String str, QrLoginUserInfo qrLoginUserInfo2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = qrLoginAuthResultData.status;
        }
        if ((i10 & 2) != 0) {
            qrLoginUserInfo2 = qrLoginAuthResultData.qrLoginUserInfo;
        }
        return qrLoginAuthResultData.copy(str, qrLoginUserInfo2);
    }

    public final String component1() {
        return this.status;
    }

    public final QrLoginUserInfo component2() {
        return this.qrLoginUserInfo;
    }

    public final QrLoginAuthResultData copy(String str, QrLoginUserInfo qrLoginUserInfo2) {
        i.g(str, Constant.KEY_STATUS);
        i.g(qrLoginUserInfo2, "qrLoginUserInfo");
        return new QrLoginAuthResultData(str, qrLoginUserInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QrLoginAuthResultData)) {
            return false;
        }
        QrLoginAuthResultData qrLoginAuthResultData = (QrLoginAuthResultData) obj;
        return i.b(this.status, qrLoginAuthResultData.status) && i.b(this.qrLoginUserInfo, qrLoginAuthResultData.qrLoginUserInfo);
    }

    public final QrLoginUserInfo getQrLoginUserInfo() {
        return this.qrLoginUserInfo;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.qrLoginUserInfo.hashCode();
    }

    public final void setQrLoginUserInfo(QrLoginUserInfo qrLoginUserInfo2) {
        i.g(qrLoginUserInfo2, "<set-?>");
        this.qrLoginUserInfo = qrLoginUserInfo2;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public String toString() {
        return "QrLoginAuthResultData(status=" + this.status + ", qrLoginUserInfo=" + this.qrLoginUserInfo + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
