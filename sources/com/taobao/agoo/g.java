package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.b;
import com.taobao.accs.base.AccsDataListener;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.l;
import com.taobao.agoo.a.a.c;
import java.util.Map;
import org.android.agoo.common.Config;

final class g implements IAgooAppReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f13287a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Context f13288b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ IRegister f13289c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ String f13290d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ String f13291e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ b f13292f;

    public g(Context context, Context context2, IRegister iRegister, String str, String str2, b bVar) {
        this.f13287a = context;
        this.f13288b = context2;
        this.f13289c = iRegister;
        this.f13290d = str;
        this.f13291e = str2;
        this.f13292f = bVar;
    }

    public Map<String, String> getAllServices() {
        return null;
    }

    public String getAppkey() {
        return this.f13290d;
    }

    public String getService(String str) {
        return null;
    }

    public void onBindApp(int i10) {
    }

    public void onBindUser(String str, int i10) {
    }

    public void onData(String str, String str2, byte[] bArr) {
    }

    public void onSendData(String str, int i10) {
    }

    public void onUnbindApp(int i10) {
    }

    public void onUnbindUser(int i10) {
    }

    public void onBindApp(int i10, String str) {
        try {
            ALog.i("TaobaoRegister", "onBindApp", "errorCode", Integer.valueOf(i10));
            if (i10 == 200) {
                if (TaobaoRegister.mRequestListener == null) {
                    com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.f13287a);
                }
                GlobalClientInfo.getInstance(this.f13288b).registerListener("AgooDeviceCmd", (AccsDataListener) TaobaoRegister.mRequestListener);
                if (!Config.a() && com.taobao.agoo.a.b.f13285b.b(this.f13287a.getPackageName()) && !UtilityImpl.b(Constants.SP_CHANNEL_FILE_NAME, this.f13288b)) {
                    String g10 = Config.g(this.f13287a);
                    if (!TextUtils.isEmpty(g10)) {
                        boolean unused2 = TaobaoRegister.isRegisterSuccess = true;
                        l.a().b();
                        ALog.i("TaobaoRegister", "agoo already Registered return ", new Object[0]);
                        IRegister iRegister = this.f13289c;
                        if (iRegister != null) {
                            iRegister.onSuccess(g10);
                            return;
                        }
                        return;
                    }
                }
                byte[] a10 = c.a(this.f13287a, this.f13290d, this.f13291e);
                if (a10 == null) {
                    IRegister iRegister2 = this.f13289c;
                    if (iRegister2 != null) {
                        iRegister2.onFailure("503.1", "req data null");
                        return;
                    }
                    return;
                }
                String b10 = this.f13292f.b(this.f13287a, new ACCSManager.AccsRequest((String) null, "AgooDeviceCmd", a10, (String) null));
                if (TextUtils.isEmpty(b10)) {
                    IRegister iRegister3 = this.f13289c;
                    if (iRegister3 != null) {
                        iRegister3.onFailure("503.1", "accs channel disabled!");
                    }
                } else if (this.f13289c != null) {
                    TaobaoRegister.mRequestListener.f13286a.put(b10, this.f13289c);
                }
            } else {
                IRegister iRegister4 = this.f13289c;
                if (iRegister4 != null) {
                    iRegister4.onFailure(String.valueOf(i10), "accs bindapp error!");
                }
            }
        } catch (Throwable th) {
            ALog.e("TaobaoRegister", "register onBindApp", th, new Object[0]);
        }
    }
}
