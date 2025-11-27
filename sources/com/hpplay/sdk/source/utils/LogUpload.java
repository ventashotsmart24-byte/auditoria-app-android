package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncHttpParameter;
import com.hpplay.common.asyncmanager.AsyncHttpRequestListener;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.asyncmanager.AsyncRunnableListener;
import com.hpplay.common.asyncmanager.AsyncUploadFileListener;
import com.hpplay.common.asyncmanager.AsyncUploadFileParameter;
import com.hpplay.common.asyncmanager.HttpMethod;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.common.utils.FileUtil;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.logwriter.b;
import com.hpplay.logwriter.e;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.api.IUploadLogQueryListener;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.business.cloud.SDKConfig;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.LogCache;
import com.hpplay.sdk.source.log.SourceLog;
import com.taobao.accs.common.Constants;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class LogUpload {
    private static final String TAG = "LogUpload";
    /* access modifiers changed from: private */
    public static boolean isUploadLog = false;

    private static Runnable createUploadLogRunnable(final Map<String, String> map, final UploadLogCallback uploadLogCallback, final String str) {
        return new Runnable() {
            public void run() {
                boolean unused = LogUpload.isUploadLog = true;
                if (!TextUtils.isEmpty(str)) {
                    LogUpload.upload(new String[]{str}, map, uploadLogCallback);
                } else {
                    UploadLogCallback uploadLogCallback = uploadLogCallback;
                    if (uploadLogCallback != null) {
                        uploadLogCallback.uploadStatus(5);
                    }
                }
                boolean unused2 = LogUpload.isUploadLog = false;
            }
        };
    }

    /* access modifiers changed from: private */
    public static void upload(String[] strArr, Map<String, String> map, final UploadLogCallback uploadLogCallback) {
        AsyncUploadFileParameter asyncUploadFileParameter = new AsyncUploadFileParameter(CloudAPI.sLogReportUrl, strArr, map);
        asyncUploadFileParameter.in.httpMethod = HttpMethod.POST;
        AsyncManager.getInstance().exeUploadFileTask(asyncUploadFileParameter, new AsyncUploadFileListener() {
            public void onRequestResult(AsyncUploadFileParameter asyncUploadFileParameter) {
                if (asyncUploadFileParameter.out != null) {
                    SourceLog.i(LogUpload.TAG, "upload response :" + asyncUploadFileParameter.out.getResult());
                    if (uploadLogCallback != null) {
                        try {
                            String str = (String) asyncUploadFileParameter.out.getResult();
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    String optString = new JSONObject(str).optString(Constants.KEY_HTTP_CODE);
                                    if (!TextUtils.isEmpty(optString)) {
                                        uploadLogCallback.uploadStatus(Integer.parseInt(optString));
                                    }
                                } catch (Exception e10) {
                                    uploadLogCallback.uploadStatus(-1);
                                    SourceLog.w(LogUpload.TAG, (Throwable) e10);
                                }
                            } else {
                                uploadLogCallback.uploadStatus(-1);
                            }
                        } catch (Exception e11) {
                            uploadLogCallback.uploadStatus(-1);
                            SourceLog.w(LogUpload.TAG, (Throwable) e11);
                        }
                    }
                }
            }
        });
    }

    public static void uploadErrorLogFile(String str, String str2, String str3) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.getDefault());
            Date date = new Date();
            date.setTime(System.currentTimeMillis());
            String str4 = (LogCache.getErrorLogFilePath() + File.separator + str) + "_" + simpleDateFormat.format(date);
            String str5 = str4 + b.f10582d;
            final String str6 = str4 + b.f10583e;
            FileUtil.string2File(str3, str5);
            e.a(str5, str6);
            SourceLog.i(TAG, "uploadErrorLogFile: " + str6);
            uploadLogFile(Session.getInstance().getContext(), (String) null, CreateUtil.createEid(), str, "", str2, str6, new UploadLogCallback() {
                public void uploadStatus(int i10) {
                    if (i10 != 6) {
                        FileUtil.deleteFile(str6);
                    }
                }
            });
            FileUtil.deleteFile(str5);
        } catch (Exception e10) {
            SourceLog.i(TAG, "uploadErrorLogFile: " + e10);
        }
    }

    public static void uploadLogFile(Context context, String str, String str2, String str3, String str4, UploadLogCallback uploadLogCallback) {
        String logOutputFilePath = LogCache.getLogOutputFilePath();
        SourceLog.flushLogWriter();
        if (!TextUtils.isEmpty(logOutputFilePath)) {
            f.a().c(logOutputFilePath);
        }
        uploadLogFile(context, str, str2, str3, str4, (System.currentTimeMillis() / 1000) + "", logOutputFilePath, uploadLogCallback);
    }

    public static void uploadLogFileQuery(Context context, final IUploadLogQueryListener iUploadLogQueryListener) {
        SourceLog.i(TAG, "uploadLogFileQuery");
        try {
            AsyncHttpParameter asyncHttpParameter = new AsyncHttpParameter(CloudAPI.sLogReportQueryUrl, "{}");
            AsyncHttpParameter.In in = asyncHttpParameter.in;
            if (in.requestHeaders == null) {
                in.requestHeaders = new HashMap();
            }
            asyncHttpParameter.in.requestHeaders.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            asyncHttpParameter.in.requestHeaders.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            asyncHttpParameter.in.requestMethod = 1;
            AsyncManager.getInstance().exeHttpTask(asyncHttpParameter, new AsyncHttpRequestListener() {
                public void onRequestResult(AsyncHttpParameter asyncHttpParameter) {
                    AsyncHttpParameter.Out out = asyncHttpParameter.out;
                    if (out.resultType == 0) {
                        String str = out.result;
                        IUploadLogQueryListener iUploadLogQueryListener = iUploadLogQueryListener;
                        if (iUploadLogQueryListener != null) {
                            iUploadLogQueryListener.onQueryResult(str);
                            return;
                        }
                        return;
                    }
                    IUploadLogQueryListener iUploadLogQueryListener2 = iUploadLogQueryListener;
                    if (iUploadLogQueryListener2 != null) {
                        iUploadLogQueryListener2.onError();
                    }
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, (Throwable) e10);
        }
    }

    private static void uploadLogFile(Context context, String str, String str2, String str3, String str4, String str5, String str6, UploadLogCallback uploadLogCallback) {
        if (!SDKConfig.getInstance().getUploadSwitch()) {
            SourceLog.i(TAG, "uploadLogFile ignore");
            return;
        }
        SourceLog.i(TAG, "uploadLogFile :" + str6);
        if (!isUploadLog) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("a", "2004");
                hashMap.put("aid", Session.getInstance().appKey);
                hashMap.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
                String string = FieldUtil.getString(FieldUtil.f10533m);
                Session.getInstance();
                hashMap.put(string, Session.DEFAULT_M);
                hashMap.put(ParamsMap.DeviceParams.KEY_HID, Session.getInstance().getHID());
                hashMap.put("cid", "");
                hashMap.put("j", DeviceProperties.getModel());
                hashMap.put("osv", Build.VERSION.RELEASE);
                hashMap.put("appv", HapplayUtils.getAppVersion(context) + "");
                hashMap.put("sdkv", "4.12.14");
                hashMap.put("ls", str5);
                hashMap.put("et", str3);
                hashMap.put("pn", str4);
                hashMap.put("version", "1.1");
                SourceLog.debug(TAG, "param:" + HapplayUtils.getJsonParams(hashMap));
                if (!TextUtils.isEmpty(str)) {
                    hashMap.put("eid", str);
                    AsyncManager.getInstance().exeRunnable(createUploadLogRunnable(hashMap, uploadLogCallback, str6), (AsyncRunnableListener) null);
                }
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put("euqid", str2);
                    AsyncManager.getInstance().exeRunnable(createUploadLogRunnable(hashMap, uploadLogCallback, str6), (AsyncRunnableListener) null);
                }
            } catch (Exception e10) {
                SourceLog.w(TAG, (Throwable) e10);
            }
        } else if (uploadLogCallback != null) {
            uploadLogCallback.uploadStatus(6);
        }
    }
}
