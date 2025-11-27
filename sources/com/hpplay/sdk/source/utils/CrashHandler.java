package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bt;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH_JAVA = "209001";
    public static final String TAG = "CrashHandlerUtil";
    private static CrashHandler mCrashHandler;
    private Map<String, String> infos = new HashMap();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private HashMap<String, String> getDeviceInfos() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("st", CdnType.DIGITAL_TYPE_PEERSTAR);
        hashMap.put("sn", "1");
        hashMap.put("et", CRASH_JAVA);
        hashMap.put("logt", "1");
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry next : this.infos.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            stringBuffer.append(str + Operator.Operation.EQUALS + str2 + "\n");
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case 2331:
                    if (str.equals("ID")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case 63370950:
                    if (str.equals("BOARD")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case 63460199:
                    if (str.equals("BRAND")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 73532169:
                    if (str.equals("MODEL")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 347933649:
                    if (str.equals("MANUFACTURER")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 408508623:
                    if (str.equals("PRODUCT")) {
                        c10 = 5;
                        break;
                    }
                    break;
                case 688906115:
                    if (str.equals("versionName")) {
                        c10 = 6;
                        break;
                    }
                    break;
                case 1704930577:
                    if (str.equals("CPU_ABI")) {
                        c10 = 7;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    hashMap.put(bt.aI, str2);
                    break;
                case 1:
                    hashMap.put("bo", str2);
                    break;
                case 2:
                    hashMap.put("br", str2);
                    break;
                case 3:
                    hashMap.put("m", str2);
                    break;
                case 4:
                    hashMap.put("mf", str2);
                    break;
                case 5:
                    hashMap.put(bt.aD, str2);
                    break;
                case 6:
                    hashMap.put("vn", str2);
                    break;
                case 7:
                    hashMap.put("ca", str2);
                    break;
            }
        }
        return hashMap;
    }

    public static CrashHandler getInstance() {
        synchronized (CrashHandler.class) {
            if (mCrashHandler == null) {
                mCrashHandler = new CrashHandler();
            }
        }
        return mCrashHandler;
    }

    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        SourceLog.w(TAG, "handleException :  " + th.toString());
        collectDeviceInfo();
        uploadToServer(th);
        return true;
    }

    private void uploadToServer(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        HashMap<String, String> deviceInfos = getDeviceInfos();
        SourceLog.i(TAG, "crashInfo  --- > " + obj);
        deviceInfos.put("cd", obj);
        SourceDataReport.getInstance().crashDataUpload(deviceInfos);
    }

    public void collectDeviceInfo() {
        try {
            this.infos.put("versionName", "4.12.14");
            for (Field field : Build.class.getDeclaredFields()) {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get((Object) null).toString());
            }
        } catch (Exception e10) {
            SourceLog.w("an error occured when collect package info", (Throwable) e10);
        }
    }

    public void init(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th != null) {
            SourceLog.i(TAG, "uncaughtException " + th.toString());
        } else {
            SourceLog.i(TAG, "uncaughtException ex is null");
        }
        if (handleException(th) || (uncaughtExceptionHandler = this.mDefaultHandler) == null) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e10) {
                SourceLog.w(TAG, "error : ", e10);
            }
            Process.killProcess(Process.myPid());
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th);
    }

    public void uploadExceptionToServer(String str) {
        HashMap<String, String> deviceInfos = getDeviceInfos();
        SourceLog.i(TAG, "crashInfo  --- > " + str);
        deviceInfos.put("cd", "Exception-----------> " + str);
        SourceDataReport.getInstance().crashDataUpload(deviceInfos);
    }
}
