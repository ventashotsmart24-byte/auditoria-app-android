package com.efs.sdk.h5pagesdk;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.observer.IConfigCallback;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil;
import java.util.Map;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

public class H5ConfigMananger {
    private final String TAG = "H5ConfigMananger";

    /* renamed from: a  reason: collision with root package name */
    private final int f5331a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EfsReporter f5332b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f5333c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f5334d = false;
    private Context mContext;

    public H5ConfigMananger(Context context, EfsReporter efsReporter) {
        this.mContext = context;
        this.f5332b = efsReporter;
        efsReporter.getAllSdkConfig(new String[]{"apm_native_h5perf_sampling_rate"}, new IConfigCallback() {
            public final void onChange(Map<String, Object> map) {
                try {
                    Object obj = map.get("apm_native_h5perf_sampling_rate");
                    if (obj != null) {
                        int unused = H5ConfigMananger.this.f5333c = Integer.parseInt(obj.toString());
                        H5ConfigMananger h5ConfigMananger = H5ConfigMananger.this;
                        boolean unused2 = h5ConfigMananger.f5334d = H5ConfigMananger.a(h5ConfigMananger.f5333c);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public String generateLaunchOptions() {
        if (this.f5334d || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sample", this.f5333c);
                if (this.f5334d) {
                    jSONObject.put("sampleResult", "Y");
                } else {
                    jSONObject.put("sampleResult", "N");
                }
                Context context = this.mContext;
                if (context != null) {
                    jSONObject.put(DispatchConstants.APP_NAME, context.getApplicationInfo().packageName);
                }
                jSONObject.put("bridgeVersion", 1);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            return jSONObject.toString();
        } else if (!H5Manager.isDebug) {
            return "";
        } else {
            Log.e("H5ConfigMananger", "采样未命中，并且不处于集成测试模式");
            return "";
        }
    }

    public boolean isH5TracerEnable() {
        return this.f5334d;
    }

    public void sendData(final String str) {
        if (this.f5334d || IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
            a.execute(new Runnable() {
                public final void run() {
                    if (H5ConfigMananger.this.f5332b != null) {
                        EfsJSONLog efsJSONLog = new EfsJSONLog("nativeh5perf");
                        efsJSONLog.put("wk_native_h5log", str);
                        H5ConfigMananger.this.f5332b.send(efsJSONLog);
                    }
                }
            });
        }
    }

    public static /* synthetic */ boolean a(int i10) {
        if (SamplingWhiteListUtil.isHitWL()) {
            return true;
        }
        if (i10 == 0) {
            return false;
        }
        if (i10 != 100 && new Random().nextInt(100) > i10) {
            return false;
        }
        return true;
    }
}
