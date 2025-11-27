package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.List;

public abstract class e {
    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return ("" + context.getPackageManager().getPackageInfo(packageName, 64).versionCode).trim();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("System fault!!!", e10);
        }
    }

    public static String b(Context context) {
        String packageName = context.getPackageName();
        try {
            return ("" + context.getPackageManager().getPackageInfo(packageName, 64).versionName).trim();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("System fault!!!", e10);
        }
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static boolean d(Context context) {
        int myPid = Process.myPid();
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid && next.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }
}
