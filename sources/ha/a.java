package ha;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hpplay.component.common.ParamsMap;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import ma.e;
import ma.g;
import ma.k;
import ma.n;
import ma.p;
import ma.s;
import ma.u;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.bean.ResultException;
import org.json.JSONObject;
import retrofit2.HttpException;
import xa.c;

public abstract class a implements Observer {
    public final Gson a() {
        return new GsonBuilder().disableHtmlEscaping().create();
    }

    public final boolean b(ResultException resultException) {
        if (resultException == null || TextUtils.isEmpty(resultException.getReturnCode())) {
            return true;
        }
        return false;
    }

    public final void c(String str, String str2, String str3) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -396103091:
                if (str.equals("portal100024")) {
                    c10 = 0;
                    break;
                }
                break;
            case -396102939:
                if (str.equals("portal100071")) {
                    c10 = 1;
                    break;
                }
                break;
            case -338366875:
                if (str.equals("aaa100027")) {
                    c10 = 2;
                    break;
                }
                break;
            case -338366874:
                if (str.equals("aaa100028")) {
                    c10 = 3;
                    break;
                }
                break;
            case -338366873:
                if (str.equals("aaa100029")) {
                    c10 = 4;
                    break;
                }
                break;
            case -338366851:
                if (str.equals("aaa100030")) {
                    c10 = 5;
                    break;
                }
                break;
            case -338366694:
                if (str.equals("aaa100082")) {
                    c10 = 6;
                    break;
                }
                break;
            case -338366693:
                if (str.equals("aaa100083")) {
                    c10 = 7;
                    break;
                }
                break;
            case -338366664:
                if (str.equals("aaa100091")) {
                    c10 = 8;
                    break;
                }
                break;
            case -338366661:
                if (str.equals("aaa100094")) {
                    c10 = 9;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                c.c().j(new e());
                return;
            case 1:
                handleGoogleAccountNotBind(str, str3);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                c.c().j(new g());
                return;
            case 6:
                handleNeedToLogin(str);
                return;
            case 7:
                c.c().j(new g());
                d(str3);
                return;
            case 8:
                handleVerifyTokenError();
                return;
            case 9:
                handleLoginNumberLimit(str, str3);
                return;
            default:
                return;
        }
    }

    public final void d(String str) {
        RemoteLoginAndMsgEvent remoteLoginAndMsgEvent;
        try {
            remoteLoginAndMsgEvent = (RemoteLoginAndMsgEvent) a().fromJson(str, RemoteLoginAndMsgEvent.class);
        } catch (Exception e10) {
            RemoteLoginAndMsgEvent remoteLoginAndMsgEvent2 = new RemoteLoginAndMsgEvent("unknown", "unknown", "unknown", "unknown");
            e10.printStackTrace();
            remoteLoginAndMsgEvent = remoteLoginAndMsgEvent2;
        }
        if (remoteLoginAndMsgEvent != null) {
            sendRemoteLoginEvent(remoteLoginAndMsgEvent);
        }
    }

    public final void e(Throwable th) {
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    public void handleGoogleAccountNotBind(String str, String str2) {
    }

    public void handleLoginNumberLimit(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str2);
            c.c().j(new k(jSONObject.optString(ParamsMap.DeviceParams.KEY_AUTH_TOKEN), jSONObject.optString("userId")));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void handleNeedToLogin(String str) {
        c.c().j(new n());
    }

    public void handleTokenInvalid(String str) {
        c.c().j(new s());
    }

    public void handleVerifyTokenError() {
        c.c().j(new u());
    }

    public void onComplete() {
    }

    public void onError(Throwable th) {
        if (th instanceof ResultException) {
            ResultException resultException = (ResultException) th;
            if (b(resultException)) {
                p.c("CustomPortalSubscriber", "find exception obj and obj or obj.field is null.");
                return;
            }
            c(resultException.getReturnCode(), resultException.getErrorMessage(), resultException.getErrorData());
            showErrorHint(resultException.getReturnCode());
        } else if (th instanceof TimeoutException) {
            showErrorHint("50010");
        } else if (th instanceof ConnectException) {
            showErrorHint("50011");
        } else if (th instanceof SocketTimeoutException) {
            showErrorHint("50012");
        } else if (th instanceof HttpException) {
            showErrorHint(((HttpException) th).code() + "");
        } else if (th instanceof UnknownHostException) {
            showErrorHint("50014");
        } else {
            e(th);
            try {
                th.printStackTrace();
            } catch (Throwable unused) {
            }
        }
    }

    public void onNext(Object obj) {
    }

    public void onSubscribe(Disposable disposable) {
    }

    public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        c.c().j(remoteLoginAndMsgEvent);
    }

    public abstract void showErrorHint(String str);
}
