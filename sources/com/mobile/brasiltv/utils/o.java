package com.mobile.brasiltv.utils;

import android.app.UiModeManager;
import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class o {

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f12603a = {"sh", "-c", "cd /sys && find . -name state"};

    public static boolean a(Context context) {
        Object systemService;
        if (Build.VERSION.SDK_INT < 23 || (systemService = context.getSystemService("audio")) == null) {
            return false;
        }
        for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) systemService).getDevices(2)) {
            if (audioDeviceInfo.getType() == 9 || audioDeviceInfo.getType() == 10) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(File file) {
        if (!file.exists()) {
            return false;
        }
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                String readLine = bufferedReader2.readLine();
                if (TextUtils.isEmpty(readLine) || (!TextUtils.equals("1", readLine) && !TextUtils.equals("hdmi=1", readLine.toLowerCase()))) {
                    j.a(bufferedReader2);
                    return false;
                }
                j.a(bufferedReader2);
                return true;
            } catch (Exception e10) {
                e = e10;
                bufferedReader = bufferedReader2;
                try {
                    e.printStackTrace();
                    j.a(bufferedReader);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    j.a(bufferedReader);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                j.a(bufferedReader);
                throw th;
            }
        } catch (Exception e11) {
            e = e11;
            e.printStackTrace();
            j.a(bufferedReader);
            return false;
        }
    }

    public static boolean c(Context context) {
        BufferedReader bufferedReader;
        IOException e10;
        if (a(context) || d(context)) {
            return true;
        }
        File file = new File("/sys/devices/virtual/switch/hdmi/state");
        if (!file.exists()) {
            file = new File("/sys/class/switch/hdmi/state");
        }
        if (file.exists() && b(file)) {
            return true;
        }
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(f12603a).getInputStream()));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        j.a(bufferedReader);
                        break;
                    } else if (readLine.endsWith("/hdmi/state")) {
                        if (b(new File("/sys/" + readLine))) {
                            j.a(bufferedReader);
                            return true;
                        }
                    }
                } catch (IOException e11) {
                    e10 = e11;
                    try {
                        e10.printStackTrace();
                        j.a(bufferedReader);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        j.a(bufferedReader);
                        throw th;
                    }
                }
            }
        } catch (IOException e12) {
            bufferedReader = null;
            e10 = e12;
            e10.printStackTrace();
            j.a(bufferedReader);
            return false;
        } catch (Throwable th2) {
            bufferedReader = null;
            th = th2;
            j.a(bufferedReader);
            throw th;
        }
        return false;
    }

    public static boolean d(Context context) {
        Object systemService = context.getSystemService("uimode");
        if (systemService != null && ((UiModeManager) systemService).getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }
}
