package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import com.taobao.accs.utl.p;
import com.taobao.agoo.ICallback;
import com.taobao.agoo.IRegister;
import com.taobao.agoo.TaobaoRegister;
import com.taobao.agoo.a.a.a;
import com.taobao.agoo.a.a.c;
import com.taobao.agoo.a.a.d;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.Config;
import org.json.JSONObject;

public class b implements AccsDataListener {

    /* renamed from: b  reason: collision with root package name */
    public static a f13285b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ICallback> f13286a = new HashMap();

    public b(Context context) {
        if (f13285b == null) {
            f13285b = new a(context.getApplicationContext());
        }
    }

    private void a(JSONObject jSONObject, ICallback iCallback) {
        String a10 = p.a(jSONObject, a.JSON_PUSH_USER_TOKEN, (String) null);
        if (!TextUtils.isEmpty(a10)) {
            Config.c(GlobalClientInfo.getContext(), a10);
            if (iCallback != null) {
                iCallback.onSuccess();
                f13285b.c(iCallback.extra);
            }
        } else if (iCallback != null) {
            iCallback.onFailure("", "agoo server error-pushtoken null");
        }
    }

    public void onAntiBrush(boolean z10, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onBind(String str, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onConnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    public void onData(String str, String str2, String str3, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onDisconnected(TaoBaseService.ConnectInfo connectInfo) {
    }

    public void onResponse(String str, String str2, int i10, byte[] bArr, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if ("AgooDeviceCmd".equals(str)) {
                ICallback iCallback = this.f13286a.get(str2);
                if (i10 == 200) {
                    String str3 = new String(bArr, XML.CHARSET_UTF8);
                    ALog.i("RequestListener", "RequestListener onResponse", Constants.KEY_DATA_ID, str2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, iCallback, "json", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    String a10 = p.a(jSONObject, com.taobao.agoo.a.a.b.JSON_ERRORCODE, (String) null);
                    String a11 = p.a(jSONObject, com.taobao.agoo.a.a.b.JSON_CMD, (String) null);
                    if (!"success".equals(a10)) {
                        if (iCallback != null) {
                            iCallback.onFailure(String.valueOf(a10), "agoo server error");
                        }
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f13286a.remove(str2);
                            return;
                        }
                        return;
                    } else if (c.JSON_CMD_REGISTER.equals(a11)) {
                        String a12 = p.a(jSONObject, "deviceId", (String) null);
                        if (!TextUtils.isEmpty(a12)) {
                            TaobaoRegister.setIsRegisterSuccess(true);
                            l.a().b();
                            Config.b(GlobalClientInfo.getContext(), a12);
                            f13285b.a(GlobalClientInfo.getContext().getPackageName());
                            if (iCallback instanceof IRegister) {
                                UtilityImpl.c(Config.PREFERENCES, GlobalClientInfo.getContext());
                                ((IRegister) iCallback).onSuccess(a12);
                            }
                        } else if (iCallback != null) {
                            iCallback.onFailure("", "agoo server error deviceid null");
                        }
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f13286a.remove(str2);
                            return;
                        }
                        return;
                    } else if (a.JSON_CMD_SETALIAS.equals(a11)) {
                        a(jSONObject, iCallback);
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f13286a.remove(str2);
                            return;
                        }
                        return;
                    } else if (a.JSON_CMD_REMOVEALIAS.equals(a11)) {
                        Config.c(GlobalClientInfo.getContext(), (String) null);
                        if (iCallback != null) {
                            iCallback.onSuccess();
                        }
                        f13285b.a();
                        if ("AgooDeviceCmd".equals(str)) {
                            this.f13286a.remove(str2);
                            return;
                        }
                        return;
                    } else if ((d.JSON_CMD_ENABLEPUSH.equals(a11) || d.JSON_CMD_DISABLEPUSH.equals(a11)) && iCallback != null) {
                        iCallback.onSuccess();
                    }
                } else if (iCallback != null) {
                    iCallback.onFailure(String.valueOf(i10), "accs channel error");
                }
            }
            if (!"AgooDeviceCmd".equals(str)) {
                return;
            }
        } catch (Throwable th) {
            if ("AgooDeviceCmd".equals(str)) {
                this.f13286a.remove(str2);
            }
            throw th;
        }
        this.f13286a.remove(str2);
    }

    public void onSendData(String str, String str2, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }

    public void onUnbind(String str, int i10, TaoBaseService.ExtraInfo extraInfo) {
    }
}
