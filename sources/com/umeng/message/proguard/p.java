package com.umeng.message.proguard;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import com.hpplay.cybergarage.soap.SOAP;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.json.JSONObject;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    Boolean f15993a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f15994b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f15995c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final String f15996a;

        /* renamed from: b  reason: collision with root package name */
        final String f15997b;

        /* renamed from: c  reason: collision with root package name */
        final long f15998c;

        /* renamed from: d  reason: collision with root package name */
        final int f15999d;

        /* renamed from: e  reason: collision with root package name */
        final int f16000e;

        /* renamed from: f  reason: collision with root package name */
        final long f16001f;

        public a(long j10, int i10, long j11, int i11, String str, String str2) {
            this.f15999d = i11;
            this.f15996a = str;
            this.f15997b = str2;
            this.f15998c = j10;
            this.f16000e = i10;
            this.f16001f = j11;
        }
    }

    public class c implements Handler.Callback {

        /* renamed from: b  reason: collision with root package name */
        private long f16007b = 0;

        /* renamed from: c  reason: collision with root package name */
        private PrintWriter f16008c;

        /* renamed from: d  reason: collision with root package name */
        private final DateFormat f16009d;

        /* renamed from: e  reason: collision with root package name */
        private final DateFormat f16010e;

        /* renamed from: f  reason: collision with root package name */
        private final File f16011f;

        /* renamed from: g  reason: collision with root package name */
        private String f16012g;

        public c() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            this.f16009d = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault());
            this.f16010e = simpleDateFormat2;
            simpleDateFormat2.setTimeZone(TimeZone.getDefault());
            Application a10 = y.a();
            this.f16011f = new File(a10.getFilesDir(), ".upush_log");
            String a11 = f.a((Context) a10);
            this.f16012g = a11;
            int lastIndexOf = a11.lastIndexOf(SOAP.DELIM);
            if (lastIndexOf >= 0) {
                this.f16012g = this.f16012g.substring(lastIndexOf + 1) + "_";
                return;
            }
            this.f16012g = "";
        }

        private void a() {
            PrintWriter printWriter = this.f16008c;
            if (printWriter != null) {
                try {
                    printWriter.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f16008c = null;
        }

        public final boolean handleMessage(Message message) {
            String str;
            try {
                int i10 = message.what;
                if (i10 == 1) {
                    if (!this.f16011f.exists()) {
                        this.f16011f.mkdirs();
                    }
                    a aVar = (a) message.obj;
                    String format = String.format("%s%s", new Object[]{this.f16012g, this.f16009d.format(Long.valueOf(aVar.f15998c))});
                    int i11 = aVar.f15999d;
                    if (i11 == 3) {
                        str = "D";
                    } else if (i11 == 4) {
                        str = "I";
                    } else if (i11 == 5) {
                        str = "W";
                    } else if (i11 == 6) {
                        str = "E";
                    } else {
                        str = "U";
                    }
                    String format2 = String.format("%s %s-%s %s %s %s", new Object[]{this.f16010e.format(Long.valueOf(aVar.f15998c)), Integer.valueOf(aVar.f16000e), Long.valueOf(aVar.f16001f), str, aVar.f15996a, aVar.f15997b});
                    File file = new File(this.f16011f, format + ".log");
                    if (file.exists() && file.length() + ((long) format2.length()) > com.hpplay.logwriter.b.f10579a) {
                        File file2 = new File(this.f16011f, format + ".bak");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        file.renameTo(file2);
                        file.delete();
                    }
                    if (!file.exists()) {
                        a();
                    }
                    if (this.f16008c == null) {
                        this.f16008c = new PrintWriter(new FileWriter(file, true));
                    }
                    this.f16008c.println(format2);
                    this.f16008c.flush();
                    p.this.b().removeMessages(2);
                    p.this.b().sendEmptyMessageDelayed(2, 5000);
                    return true;
                } else if (i10 != 2) {
                    return true;
                } else {
                    a();
                    long currentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
                    if (Math.abs(currentTimeMillis - this.f16007b) > 86400000) {
                        this.f16007b = currentTimeMillis;
                        File[] listFiles = this.f16011f.listFiles();
                        if (listFiles != null) {
                            for (File file3 : listFiles) {
                                long lastModified = file3.lastModified() / 86400000;
                                Long.signum(lastModified);
                                if (Math.abs(currentTimeMillis - (lastModified * 86400000)) > 86400000) {
                                    file3.delete();
                                }
                            }
                        }
                    }
                    return true;
                }
            } catch (Throwable th) {
                UPLog.d("Log", UPLog.getStackTrace(th));
            }
        }
    }

    public final boolean a() {
        if (!f.f15950b) {
            return false;
        }
        if (this.f15993a == null) {
            this.f15993a = Boolean.valueOf(MessageSharedPrefs.getInstance(y.a()).m());
        }
        return this.f15993a.booleanValue();
    }

    public final Handler b() {
        Handler handler;
        Handler handler2 = this.f15995c;
        if (handler2 != null) {
            return handler2;
        }
        synchronized (this) {
            if (this.f15995c == null) {
                try {
                    HandlerThread handlerThread = new HandlerThread("upush_log", 10);
                    handlerThread.start();
                    this.f15995c = new Handler(handlerThread.getLooper(), new c());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            handler = this.f15995c;
        }
        return handler;
    }

    public final void a(int i10, String str, String str2) {
        Handler b10;
        if (i10 >= 4 && str2 != null && (b10 = b()) != null) {
            b10.obtainMessage(1, new a(System.currentTimeMillis(), Process.myPid(), Thread.currentThread().getId(), i10, str, str2)).sendToTarget();
        }
    }

    public static class b {
        public static JSONObject a(String str, String str2, String str3) {
            String str4;
            try {
                Application a10 = y.a();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put("appkey", str);
                jSONObject.put("device_token", str2);
                jSONObject.put("android_id", str3);
                jSONObject.put("utdid", d.o(a10));
                jSONObject.put(bt.f13913g, d.k(a10));
                try {
                    str4 = UMUtils.getZid(a10);
                    try {
                        jSONObject.put("oaid", DeviceConfig.getOaid(a10));
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str4 = null;
                }
                jSONObject.put(bt.al, str4);
                jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                return g.a(jSONObject, "https://offmsg.umeng.com/log/switch", str, true);
            } catch (Throwable th) {
                UPLog.i("Log", UPLog.getStackTrace(th));
                return null;
            }
        }

        public final void a(File file, File file2) {
            File[] listFiles;
            if (file.exists() && (listFiles = file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    if (file.isDirectory() || file.length() > com.hpplay.logwriter.b.f10579a) {
                        return false;
                    }
                    String name = file.getName();
                    if (name.endsWith(".log") || name.endsWith(".bak")) {
                        return true;
                    }
                    return false;
                }
            })) != null && listFiles.length != 0) {
                if (listFiles.length > 8) {
                    File[] fileArr = new File[8];
                    System.arraycopy(listFiles, 0, fileArr, 0, 8);
                    listFiles = fileArr;
                }
                ZipOutputStream zipOutputStream = null;
                try {
                    ZipOutputStream zipOutputStream2 = new ZipOutputStream(new FileOutputStream(file2));
                    try {
                        for (File file3 : listFiles) {
                            a(file3, zipOutputStream2);
                            file3.delete();
                        }
                        zipOutputStream2.finish();
                        f.a((Closeable) zipOutputStream2);
                    } catch (Throwable th) {
                        th = th;
                        zipOutputStream = zipOutputStream2;
                        try {
                            UPLog.i("Log", UPLog.getStackTrace(th));
                        } finally {
                            f.a((Closeable) zipOutputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.i("Log", UPLog.getStackTrace(th));
                }
            }
        }

        private static void a(File file, ZipOutputStream zipOutputStream) {
            if (file.exists() && file.length() >= 256) {
                FileInputStream fileInputStream = null;
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read != -1) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                zipOutputStream.closeEntry();
                                f.a((Closeable) fileInputStream2);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        try {
                            UPLog.i("Log", UPLog.getStackTrace(th));
                        } finally {
                            f.a((Closeable) fileInputStream);
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    UPLog.i("Log", UPLog.getStackTrace(th));
                }
            }
        }
    }
}
