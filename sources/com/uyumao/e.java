package com.uyumao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public static Context f16271a;

    /* renamed from: b  reason: collision with root package name */
    public static WeakReference<Future<?>> f16272b;

    /* renamed from: c  reason: collision with root package name */
    public static WeakReference<Future<?>> f16273c;

    public static Context a() {
        return f16271a;
    }

    public static Boolean b() {
        Boolean bool = Boolean.FALSE;
        Class<UMConfigure> cls = UMConfigure.class;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            Method declaredMethod = cls.getDeclaredMethod("isInForeground", new Class[0]);
            if (declaredMethod == null) {
                return bool;
            }
            declaredMethod.setAccessible(true);
            return (Boolean) declaredMethod.invoke(cls, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return bool;
        }
    }

    public static String[] c(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                    strArr[0] = "mobile_network";
                    strArr[1] = networkInfo2.getSubtypeName();
                }
                return strArr;
            }
            strArr[0] = "Wi-Fi";
            return strArr;
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                return telephonyManager.getNetworkOperatorName();
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static JSONArray e(Context context) {
        WifiInfo wifiInfo;
        WifiManager wifiManager;
        if (context == null || !h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                wifiInfo = null;
            } else {
                wifiInfo = wifiManager.getConnectionInfo();
            }
            if (wifiInfo == null) {
                return null;
            }
            String bssid = wifiInfo.getBSSID();
            String replace = wifiInfo.getSSID().replace("\"", "");
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("bssid", bssid);
            jSONObject.put(BrowserInfo.KEY_SSID, replace);
            jSONObject.put("ts", currentTimeMillis);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray f(Context context) {
        List<ScanResult> scanResults;
        if (!h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && a(context, "android.permission.ACCESS_WIFI_STATE") && a(context, "android.permission.ACCESS_FINE_LOCATION") && (scanResults = wifiManager.getScanResults()) != null) {
                int size = scanResults.size();
                if (size > 100) {
                    size = 100;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    ScanResult scanResult = scanResults.get(i10);
                    if (scanResult != null) {
                        String str = scanResult.BSSID;
                        String str2 = scanResult.SSID;
                        String valueOf = String.valueOf(scanResult.level);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bssid", str);
                        jSONObject.put(BrowserInfo.KEY_SSID, str2);
                        jSONObject.put("rssi", valueOf);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String[] g(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String[] strArr = {"", ""};
        try {
            if (a(context, "android.permission.ACCESS_WIFI_STATE") && a(context, "android.permission.ACCESS_COARSE_LOCATION") && a(context, "android.permission.ACCESS_FINE_LOCATION") && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                String bssid = connectionInfo.getBSSID();
                if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
                    strArr[0] = ssid.substring(1, ssid.length() - 1);
                }
                if (bssid != null) {
                    strArr[1] = bssid;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return strArr;
    }

    public static boolean h(Context context) {
        int i10;
        WifiManager wifiManager;
        if (context == null) {
            return false;
        }
        try {
            if (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) {
                i10 = -1;
            } else {
                i10 = wifiManager.getWifiState();
            }
            if (3 == i10) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0)) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & UnsignedBytes.MAX_VALUE));
            }
        }
        return bArr;
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z10) {
        SystemClock.elapsedRealtime();
        return new JSONObject(a(jSONObject.toString(), (HttpURLConnection) new URL(str).openConnection(), str2));
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    str = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("efs.util.file", "read file error", th);
                        a((Closeable) fileInputStream);
                        return str;
                    } catch (Throwable th2) {
                        a((Closeable) fileInputStream);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
                Log.e("efs.util.file", "read file error", th);
                a((Closeable) fileInputStream);
                return str;
            }
            a((Closeable) fileInputStream);
        }
        return str;
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    outputStream.write(bArr2, 0, read);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPInputStream = null;
        }
        n.a((Closeable) gZIPInputStream);
    }

    /* JADX INFO: finally extract failed */
    public static boolean a(File file, byte[] bArr, boolean z10) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z10);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                a((Closeable) fileOutputStream);
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    a((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    a((Closeable) fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
            a((Closeable) fileOutputStream);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        if (r4.contains(r0) != false) goto L_0x003b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject b(android.content.Context r13) {
        /*
            java.lang.String r0 = "network"
            java.lang.String r1 = "gps"
            r2 = 0
            if (r13 != 0) goto L_0x0008
            return r2
        L_0x0008:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = a((android.content.Context) r13, (java.lang.String) r4)     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x0086
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = a((android.content.Context) r13, (java.lang.String) r4)     // Catch:{ all -> 0x0086 }
            if (r4 == 0) goto L_0x0086
            java.lang.String r4 = "location"
            java.lang.Object r13 = r13.getSystemService(r4)     // Catch:{ all -> 0x0086 }
            android.location.LocationManager r13 = (android.location.LocationManager) r13     // Catch:{ all -> 0x0086 }
            if (r13 != 0) goto L_0x0028
            return r2
        L_0x0028:
            r4 = 1
            java.util.List r4 = r13.getProviders(r4)     // Catch:{ all -> 0x0086 }
            boolean r5 = r4.contains(r1)     // Catch:{ all -> 0x0086 }
            if (r5 == 0) goto L_0x0035
            r0 = r1
            goto L_0x003b
        L_0x0035:
            boolean r1 = r4.contains(r0)     // Catch:{ all -> 0x0086 }
            if (r1 == 0) goto L_0x0086
        L_0x003b:
            android.location.Location r13 = r13.getLastKnownLocation(r0)     // Catch:{ all -> 0x0086 }
            if (r13 == 0) goto L_0x0086
            r13.getLatitude()     // Catch:{ all -> 0x0086 }
            r13.getLongitude()     // Catch:{ all -> 0x0086 }
            double r0 = r13.getLatitude()     // Catch:{ all -> 0x0086 }
            double r4 = r13.getLongitude()     // Catch:{ all -> 0x0086 }
            boolean r6 = r13.hasAltitude()     // Catch:{ all -> 0x0086 }
            r7 = 0
            if (r6 == 0) goto L_0x005c
            double r9 = r13.getAltitude()     // Catch:{ all -> 0x0086 }
            goto L_0x005d
        L_0x005c:
            r9 = r7
        L_0x005d:
            boolean r6 = r13.hasSpeed()     // Catch:{ all -> 0x0086 }
            if (r6 == 0) goto L_0x0068
            float r6 = r13.getSpeed()     // Catch:{ all -> 0x0086 }
            double r7 = (double) r6     // Catch:{ all -> 0x0086 }
        L_0x0068:
            long r11 = r13.getTime()     // Catch:{ all -> 0x0086 }
            java.lang.String r13 = "c_lat"
            r3.put(r13, r0)     // Catch:{ all -> 0x0086 }
            java.lang.String r13 = "c_lng"
            r3.put(r13, r4)     // Catch:{ all -> 0x0086 }
            java.lang.String r13 = "c_alt"
            r3.put(r13, r9)     // Catch:{ all -> 0x0086 }
            java.lang.String r13 = "c_acc"
            r3.put(r13, r7)     // Catch:{ all -> 0x0086 }
            java.lang.String r13 = "c_lts"
            r3.put(r13, r11)     // Catch:{ all -> 0x0086 }
            return r3
        L_0x0086:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.b(android.content.Context):org.json.JSONObject");
    }

    /* JADX INFO: finally extract failed */
    public static String a(String str, HttpURLConnection httpURLConnection, String str2) {
        GZIPOutputStream gZIPOutputStream;
        InputStream inputStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = str.getBytes();
        OutputStream outputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a((Closeable) gZIPOutputStream);
        byte[] a10 = a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a10.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStream.write(a10);
            n.a((Closeable) outputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                inputStream = httpURLConnection.getInputStream();
            } else {
                inputStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                        n.a((Closeable) inputStream);
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a11 = a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                a(a11, (OutputStream) byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } catch (Throwable th) {
            n.a((Closeable) outputStream);
            throw th;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(3:9|10|11)|12|13|(3:15|(4:18|(8:20|21|(5:23|24|(4:26|27|28|29)(2:30|(1:32))|59|68)|33|34|(4:36|37|(1:39)(1:40)|41)(2:42|(3:44|(1:46)(1:47)|48)(2:49|(1:51)(2:52|(3:54|(1:56)(1:57)|58))))|59|68)(1:67)|65|16)|66)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033 A[Catch:{ all -> 0x0270 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONArray a(android.content.Context r16) {
        /*
            r0 = r16
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            r2 = 0
            if (r0 != 0) goto L_0x000b
            return r2
        L_0x000b:
            java.lang.String r3 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r3 = a((android.content.Context) r0, (java.lang.String) r3)     // Catch:{ all -> 0x0270 }
            if (r3 == 0) goto L_0x026f
            java.lang.String r3 = "phone"
            java.lang.Object r0 = r0.getSystemService(r3)     // Catch:{ all -> 0x0270 }
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0     // Catch:{ all -> 0x0270 }
            java.lang.String r3 = r0.getNetworkOperator()     // Catch:{ all -> 0x0270 }
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0270 }
            if (r4 != 0) goto L_0x002d
            r4 = 0
            r5 = 3
            r3.substring(r4, r5)     // Catch:{ all -> 0x002d }
            r3.substring(r5)     // Catch:{ all -> 0x002d }
        L_0x002d:
            java.util.List r0 = r0.getAllCellInfo()     // Catch:{ all -> 0x0270 }
            if (r0 == 0) goto L_0x026f
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0270 }
        L_0x0037:
            boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0270 }
            if (r3 == 0) goto L_0x026f
            java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0270 }
            android.telephony.CellInfo r3 = (android.telephony.CellInfo) r3     // Catch:{ all -> 0x0270 }
            boolean r4 = r3.isRegistered()     // Catch:{ all -> 0x0270 }
            if (r4 == 0) goto L_0x0037
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0270 }
            r5 = 29
            java.lang.String r6 = "tac"
            java.lang.String r7 = "pci"
            java.lang.String r8 = "lac"
            java.lang.String r9 = "cid"
            java.lang.String r10 = "ts"
            java.lang.String r11 = "mcc"
            java.lang.String r12 = "mnc"
            java.lang.String r13 = "nt"
            if (r4 < r5) goto L_0x00ec
            boolean r5 = w8.a.a(r3)     // Catch:{ all -> 0x0270 }
            if (r5 == 0) goto L_0x00ac
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0270 }
            r4.<init>()     // Catch:{ all -> 0x0270 }
            android.telephony.CellInfoNr r3 = w8.c.a(r3)     // Catch:{ all -> 0x0270 }
            android.telephony.CellIdentity r3 = r3.getCellIdentity()     // Catch:{ all -> 0x0270 }
            android.telephony.CellIdentityNr r3 = w8.g.a(r3)     // Catch:{ all -> 0x0270 }
            int r5 = r3.getPci()     // Catch:{ all -> 0x0270 }
            long r8 = r3.getNci()     // Catch:{ all -> 0x0270 }
            int r14 = r3.getTac()     // Catch:{ all -> 0x0270 }
            java.lang.String r15 = r3.getMncString()     // Catch:{ all -> 0x0270 }
            java.lang.String r3 = r3.getMccString()     // Catch:{ all -> 0x0270 }
            java.lang.String r2 = "Nr"
            r4.put(r13, r2)     // Catch:{ all -> 0x026d }
            r4.put(r7, r5)     // Catch:{ all -> 0x026d }
            java.lang.String r2 = "nci"
            r4.put(r2, r8)     // Catch:{ all -> 0x026d }
            r4.put(r6, r14)     // Catch:{ all -> 0x026d }
            r4.put(r12, r15)     // Catch:{ all -> 0x026d }
            r4.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r4.put(r10, r2)     // Catch:{ all -> 0x026d }
            r1.put(r4)     // Catch:{ all -> 0x026d }
            goto L_0x026a
        L_0x00ac:
            boolean r2 = w8.n.a(r3)     // Catch:{ all -> 0x026d }
            if (r2 == 0) goto L_0x00ec
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x026d }
            r2.<init>()     // Catch:{ all -> 0x026d }
            android.telephony.CellInfoTdscdma r3 = w8.l.a(r3)     // Catch:{ all -> 0x026d }
            android.telephony.CellIdentityTdscdma r3 = r3.getCellIdentity()     // Catch:{ all -> 0x026d }
            int r4 = r3.getCid()     // Catch:{ all -> 0x026d }
            int r5 = r3.getLac()     // Catch:{ all -> 0x026d }
            java.lang.String r6 = r3.getMncString()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = r3.getMccString()     // Catch:{ all -> 0x026d }
            java.lang.String r7 = "Tdscdma"
            r2.put(r13, r7)     // Catch:{ all -> 0x026d }
            r2.put(r9, r4)     // Catch:{ all -> 0x026d }
            r2.put(r8, r5)     // Catch:{ all -> 0x026d }
            r2.put(r12, r6)     // Catch:{ all -> 0x026d }
            r2.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r2.put(r10, r3)     // Catch:{ all -> 0x026d }
            r1.put(r2)     // Catch:{ all -> 0x026d }
            goto L_0x026a
        L_0x00ec:
            boolean r2 = r3 instanceof android.telephony.CellInfoLte     // Catch:{ all -> 0x026d }
            java.lang.String r5 = "00"
            r14 = 28
            if (r2 == 0) goto L_0x0158
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x026d }
            r2.<init>()     // Catch:{ all -> 0x026d }
            android.telephony.CellInfoLte r3 = (android.telephony.CellInfoLte) r3     // Catch:{ all -> 0x026d }
            android.telephony.CellIdentityLte r3 = r3.getCellIdentity()     // Catch:{ all -> 0x026d }
            int r8 = r3.getPci()     // Catch:{ all -> 0x026d }
            int r9 = r3.getTac()     // Catch:{ all -> 0x026d }
            if (r4 < r14) goto L_0x0112
            java.lang.String r4 = r3.getMncString()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = r3.getMccString()     // Catch:{ all -> 0x026d }
            goto L_0x013b
        L_0x0112:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026d }
            r4.<init>()     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            int r5 = r3.getMnc()     // Catch:{ all -> 0x026d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x026d }
            int r5 = r4.length()     // Catch:{ all -> 0x026d }
            int r5 = r5 + -2
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x026d }
            int r3 = r3.getMcc()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x026d }
        L_0x013b:
            java.lang.String r5 = "Lte"
            r2.put(r13, r5)     // Catch:{ all -> 0x026d }
            r2.put(r7, r8)     // Catch:{ all -> 0x026d }
            r2.put(r6, r9)     // Catch:{ all -> 0x026d }
            r2.put(r12, r4)     // Catch:{ all -> 0x026d }
            r2.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r2.put(r10, r3)     // Catch:{ all -> 0x026d }
            r1.put(r2)     // Catch:{ all -> 0x026d }
            goto L_0x026a
        L_0x0158:
            boolean r2 = r3 instanceof android.telephony.CellInfoWcdma     // Catch:{ all -> 0x026d }
            if (r2 == 0) goto L_0x01c0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x026d }
            r2.<init>()     // Catch:{ all -> 0x026d }
            android.telephony.CellInfoWcdma r3 = (android.telephony.CellInfoWcdma) r3     // Catch:{ all -> 0x026d }
            android.telephony.CellIdentityWcdma r3 = r3.getCellIdentity()     // Catch:{ all -> 0x026d }
            int r6 = r3.getCid()     // Catch:{ all -> 0x026d }
            int r7 = r3.getLac()     // Catch:{ all -> 0x026d }
            if (r4 < r14) goto L_0x017a
            java.lang.String r4 = r3.getMncString()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = r3.getMccString()     // Catch:{ all -> 0x026d }
            goto L_0x01a3
        L_0x017a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026d }
            r4.<init>()     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            int r5 = r3.getMnc()     // Catch:{ all -> 0x026d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x026d }
            int r5 = r4.length()     // Catch:{ all -> 0x026d }
            int r5 = r5 + -2
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x026d }
            int r3 = r3.getMcc()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x026d }
        L_0x01a3:
            java.lang.String r5 = "Wcdma"
            r2.put(r13, r5)     // Catch:{ all -> 0x026d }
            r2.put(r9, r6)     // Catch:{ all -> 0x026d }
            r2.put(r8, r7)     // Catch:{ all -> 0x026d }
            r2.put(r12, r4)     // Catch:{ all -> 0x026d }
            r2.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r2.put(r10, r3)     // Catch:{ all -> 0x026d }
            r1.put(r2)     // Catch:{ all -> 0x026d }
            goto L_0x026a
        L_0x01c0:
            boolean r2 = r3 instanceof android.telephony.CellInfoCdma     // Catch:{ all -> 0x026d }
            if (r2 == 0) goto L_0x0204
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x026d }
            r2.<init>()     // Catch:{ all -> 0x026d }
            android.telephony.CellInfoCdma r3 = (android.telephony.CellInfoCdma) r3     // Catch:{ all -> 0x026d }
            android.telephony.CellIdentityCdma r3 = r3.getCellIdentity()     // Catch:{ all -> 0x026d }
            int r4 = r3.getBasestationId()     // Catch:{ all -> 0x026d }
            int r5 = r3.getNetworkId()     // Catch:{ all -> 0x026d }
            int r3 = r3.getSystemId()     // Catch:{ all -> 0x026d }
            java.lang.String r6 = "Cdma"
            r2.put(r13, r6)     // Catch:{ all -> 0x026d }
            java.lang.String r6 = "bid"
            r2.put(r6, r4)     // Catch:{ all -> 0x026d }
            java.lang.String r4 = "nid"
            r2.put(r4, r5)     // Catch:{ all -> 0x026d }
            java.lang.String r4 = "sid"
            r2.put(r4, r3)     // Catch:{ all -> 0x026d }
            java.lang.String r3 = "03"
            r2.put(r12, r3)     // Catch:{ all -> 0x026d }
            java.lang.String r3 = "460"
            r2.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r2.put(r10, r3)     // Catch:{ all -> 0x026d }
            r1.put(r2)     // Catch:{ all -> 0x026d }
            goto L_0x026a
        L_0x0204:
            boolean r2 = r3 instanceof android.telephony.CellInfoGsm     // Catch:{ all -> 0x026d }
            if (r2 == 0) goto L_0x026a
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x026d }
            r2.<init>()     // Catch:{ all -> 0x026d }
            android.telephony.CellInfoGsm r3 = (android.telephony.CellInfoGsm) r3     // Catch:{ all -> 0x026d }
            android.telephony.CellIdentityGsm r3 = r3.getCellIdentity()     // Catch:{ all -> 0x026d }
            int r6 = r3.getCid()     // Catch:{ all -> 0x026d }
            int r7 = r3.getLac()     // Catch:{ all -> 0x026d }
            if (r4 < r14) goto L_0x0226
            java.lang.String r4 = r3.getMncString()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = r3.getMccString()     // Catch:{ all -> 0x026d }
            goto L_0x024f
        L_0x0226:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x026d }
            r4.<init>()     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            int r5 = r3.getMnc()     // Catch:{ all -> 0x026d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x026d }
            r4.append(r5)     // Catch:{ all -> 0x026d }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x026d }
            int r5 = r4.length()     // Catch:{ all -> 0x026d }
            int r5 = r5 + -2
            java.lang.String r4 = r4.substring(r5)     // Catch:{ all -> 0x026d }
            int r3 = r3.getMcc()     // Catch:{ all -> 0x026d }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x026d }
        L_0x024f:
            java.lang.String r5 = "Gsm"
            r2.put(r13, r5)     // Catch:{ all -> 0x026d }
            r2.put(r9, r6)     // Catch:{ all -> 0x026d }
            r2.put(r8, r7)     // Catch:{ all -> 0x026d }
            r2.put(r12, r4)     // Catch:{ all -> 0x026d }
            r2.put(r11, r3)     // Catch:{ all -> 0x026d }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x026d }
            r2.put(r10, r3)     // Catch:{ all -> 0x026d }
            r1.put(r2)     // Catch:{ all -> 0x026d }
        L_0x026a:
            r2 = 0
            goto L_0x0037
        L_0x026d:
            r0 = 0
            goto L_0x0271
        L_0x026f:
            return r1
        L_0x0270:
            r0 = r2
        L_0x0271:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.a(android.content.Context):org.json.JSONArray");
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ec A[SYNTHETIC, Splitter:B:50:0x00ec] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(org.json.JSONObject r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r0 = r8.toString()
            byte[] r1 = r10.getBytes()
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            byte[] r0 = r0.getBytes()
            r3 = 0
            java.util.zip.GZIPOutputStream r4 = new java.util.zip.GZIPOutputStream     // Catch:{ all -> 0x001b }
            r4.<init>(r2)     // Catch:{ all -> 0x001b }
            r4.write(r0)     // Catch:{ all -> 0x001c }
            goto L_0x001c
        L_0x001b:
            r4 = r3
        L_0x001c:
            com.uyumao.n.a((java.io.Closeable) r4)
            byte[] r0 = r2.toByteArray()
            byte[] r0 = a((byte[]) r0, (byte[]) r1)
            android.os.SystemClock.elapsedRealtime()
            java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x00e1 }
            r4.<init>(r9)     // Catch:{ all -> 0x00e1 }
            java.net.URLConnection r9 = r4.openConnection()     // Catch:{ all -> 0x00e1 }
            java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ all -> 0x00e1 }
            java.lang.String r4 = "POST"
            r9.setRequestMethod(r4)     // Catch:{ all -> 0x00de }
            r4 = 60000(0xea60, float:8.4078E-41)
            r9.setReadTimeout(r4)     // Catch:{ all -> 0x00de }
            r9.setConnectTimeout(r4)     // Catch:{ all -> 0x00de }
            java.lang.String r4 = "Content-Type"
            java.lang.String r5 = "application/octet-stream"
            r9.addRequestProperty(r4, r5)     // Catch:{ all -> 0x00de }
            java.lang.String r4 = "appkey"
            r9.addRequestProperty(r4, r10)     // Catch:{ all -> 0x00de }
            java.lang.String r10 = "uuid"
            java.lang.String r8 = r8.optString(r10)     // Catch:{ all -> 0x00de }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00de }
            r10 = 0
            r4 = 1
            if (r8 != 0) goto L_0x0066
            java.lang.String r8 = "Rich-Resp-Code"
            java.lang.String r5 = "1"
            r9.addRequestProperty(r8, r5)     // Catch:{ all -> 0x00de }
            r8 = 0
            goto L_0x0067
        L_0x0066:
            r8 = 1
        L_0x0067:
            int r5 = r0.length     // Catch:{ all -> 0x00de }
            r9.setFixedLengthStreamingMode(r5)     // Catch:{ all -> 0x00de }
            r9.setDoOutput(r4)     // Catch:{ all -> 0x00de }
            java.io.OutputStream r4 = r9.getOutputStream()     // Catch:{ all -> 0x00de }
            r4.write(r0)     // Catch:{ all -> 0x00dc }
            int r0 = r9.getResponseCode()     // Catch:{ all -> 0x00dc }
            r5 = 400(0x190, float:5.6E-43)
            if (r0 >= r5) goto L_0x0082
            java.io.InputStream r3 = r9.getInputStream()     // Catch:{ all -> 0x00dc }
            goto L_0x0086
        L_0x0082:
            java.io.InputStream r3 = r9.getErrorStream()     // Catch:{ all -> 0x00dc }
        L_0x0086:
            r2.reset()     // Catch:{ all -> 0x00dc }
            if (r3 == 0) goto L_0x009a
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r5 = new byte[r5]     // Catch:{ all -> 0x00dc }
        L_0x008f:
            int r6 = r3.read(r5)     // Catch:{ all -> 0x00dc }
            r7 = -1
            if (r6 == r7) goto L_0x009a
            r2.write(r5, r10, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x008f
        L_0x009a:
            com.uyumao.n.a((java.io.Closeable) r4)
            com.uyumao.n.a((java.io.Closeable) r3)
            r9.disconnect()     // Catch:{ all -> 0x00a4 }
            goto L_0x00a5
        L_0x00a4:
        L_0x00a5:
            r9 = 200(0xc8, float:2.8E-43)
            if (r0 != r9) goto L_0x00c2
            byte[] r10 = r2.toByteArray()
            byte[] r10 = a((byte[]) r10, (byte[]) r1)
            r2.reset()
            if (r8 == 0) goto L_0x00bd
            a((byte[]) r10, (java.io.OutputStream) r2)
            r2.toString()
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r10)
        L_0x00c2:
            if (r0 != r9) goto L_0x00c5
            return
        L_0x00c5:
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "response code "
            r9.append(r10)
            r9.append(r0)
            java.lang.String r9 = r9.toString()
            r8.<init>(r9)
            throw r8
        L_0x00dc:
            r8 = move-exception
            goto L_0x00e4
        L_0x00de:
            r8 = move-exception
            r4 = r3
            goto L_0x00e4
        L_0x00e1:
            r8 = move-exception
            r9 = r3
            r4 = r9
        L_0x00e4:
            com.uyumao.n.a((java.io.Closeable) r4)
            com.uyumao.n.a((java.io.Closeable) r3)
            if (r9 == 0) goto L_0x00ef
            r9.disconnect()     // Catch:{ all -> 0x00ef }
        L_0x00ef:
            goto L_0x00f1
        L_0x00f0:
            throw r8
        L_0x00f1:
            goto L_0x00f0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    public static void a(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File a10 : listFiles) {
                            a(a10);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static String a(NetworkInfo networkInfo) {
        try {
            int subtype = networkInfo.getSubtype();
            if (subtype == 20) {
                return "5G";
            }
            switch (subtype) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3G";
                case 13:
                    return "4G";
                default:
                    String subtypeName = networkInfo.getSubtypeName();
                    if (TextUtils.isEmpty(subtypeName)) {
                        return "";
                    }
                    if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) {
                        return "3G";
                    }
                    return subtypeName;
            }
            th.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            r3 = 1
            if (r1 < r2) goto L_0x002e
            java.lang.String r1 = "android.content.Context"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ all -> 0x003d }
            java.lang.String r2 = "checkSelfPermission"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x003d }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ all -> 0x003d }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch:{ all -> 0x003d }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x003d }
            r2[r0] = r7     // Catch:{ all -> 0x003d }
            java.lang.Object r6 = r1.invoke(r6, r2)     // Catch:{ all -> 0x003d }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x003d }
            int r6 = r6.intValue()     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x003d
            goto L_0x003c
        L_0x002e:
            android.content.pm.PackageManager r1 = r6.getPackageManager()
            java.lang.String r6 = r6.getPackageName()
            int r6 = r1.checkPermission(r7, r6)
            if (r6 != 0) goto L_0x003d
        L_0x003c:
            r0 = 1
        L_0x003d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.a(android.content.Context, java.lang.String):boolean");
    }

    public static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArray;
        JSONObject jSONObject3;
        if (jSONObject != null && jSONObject2 != null) {
            try {
                jSONObject3 = new JSONObject(jSONObject.toString());
                if (jSONObject2.length() > 0) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject2.get(next));
                    }
                }
                jSONArray = new JSONArray();
            } catch (Throwable unused) {
                return null;
            }
            try {
                jSONArray.put(jSONObject3);
            } catch (Throwable unused2) {
            }
        } else if (jSONObject != null) {
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray2.put(jSONObject);
                return jSONArray2;
            } catch (Throwable unused3) {
                return jSONArray2;
            }
        } else {
            jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }
}
