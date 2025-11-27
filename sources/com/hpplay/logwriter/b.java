package com.hpplay.logwriter;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import io.jsonwebtoken.Header;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final long f10579a = 5242880;

    /* renamed from: b  reason: collision with root package name */
    public static final long f10580b = 4194304;

    /* renamed from: c  reason: collision with root package name */
    public static final int f10581c = 6;

    /* renamed from: d  reason: collision with root package name */
    public static final String f10582d = ".txt";

    /* renamed from: e  reason: collision with root package name */
    public static final String f10583e = ".zip";

    /* renamed from: f  reason: collision with root package name */
    private static final String f10584f = "hpplay-java:Cache";

    /* renamed from: g  reason: collision with root package name */
    private String f10585g;

    /* renamed from: h  reason: collision with root package name */
    private File f10586h = null;

    /* renamed from: i  reason: collision with root package name */
    private FileOutputStream f10587i = null;

    /* renamed from: j  reason: collision with root package name */
    private String f10588j;

    /* renamed from: k  reason: collision with root package name */
    private File f10589k = null;

    /* renamed from: l  reason: collision with root package name */
    private FileOutputStream f10590l = null;

    public void a(String str) {
        if (str.endsWith(Operator.Operation.DIVISION)) {
            this.f10585g = str + "0";
            this.f10588j = str + "1";
        } else {
            this.f10585g = str + "/0";
            this.f10588j = str + "/1";
        }
        a(this.f10585g, false);
        a(this.f10588j, true);
    }

    public void b(byte[] bArr) {
        String str = this.f10588j;
        if (str != null) {
            b(str);
            a(this.f10588j, this.f10589k, this.f10590l, true);
            a(bArr, (OutputStream) this.f10590l);
        }
    }

    private String b(String str, boolean z10) {
        String str2;
        if (z10) {
            str2 = "1-" + h.a() + f10582d;
        } else {
            str2 = "0-" + h.a() + f10582d;
        }
        if (str.endsWith(Operator.Operation.DIVISION)) {
            return str + str2;
        }
        return str + Operator.Operation.DIVISION + str2;
    }

    private void a(String str, boolean z10) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            a(file, z10);
        }
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            a(file);
        }
    }

    private void a(File file, boolean z10) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            int length = listFiles.length;
            int i10 = 0;
            while (i10 < length) {
                if (listFiles[i10].getName() == null || listFiles[i10].getName().equalsIgnoreCase(Header.COMPRESSION_ALGORITHM) || listFiles[i10].length() >= f10580b) {
                    i10++;
                } else if (z10) {
                    try {
                        this.f10589k = listFiles[i10];
                        this.f10590l = new FileOutputStream(this.f10589k, true);
                        return;
                    } catch (Exception e10) {
                        g.a(f10584f, e10);
                        return;
                    }
                } else {
                    this.f10586h = listFiles[i10];
                    this.f10587i = new FileOutputStream(this.f10586h, true);
                    return;
                }
            }
        }
    }

    public void a(byte[] bArr) {
        String str = this.f10585g;
        if (str != null) {
            b(str);
            a(this.f10585g, this.f10586h, this.f10587i, false);
            a(bArr, (OutputStream) this.f10587i);
        }
    }

    private void a(byte[] bArr, OutputStream outputStream) {
        if (bArr != null && outputStream != null) {
            try {
                outputStream.write(bArr);
                outputStream.flush();
            } catch (Exception e10) {
                g.a(f10584f, e10);
                try {
                    outputStream.flush();
                    outputStream.close();
                } catch (Exception e11) {
                    g.a(f10584f, e11);
                }
            }
        }
    }

    private void a(String str, File file, FileOutputStream fileOutputStream, boolean z10) {
        String str2;
        if (file == null || fileOutputStream == null) {
            a(str, fileOutputStream, z10);
        } else if (file.length() >= f10579a) {
            if (!TextUtils.isEmpty(file.getName())) {
                str2 = file.getName().replace(f10582d, f10583e);
            } else {
                str2 = h.a();
            }
            if (!str.endsWith(Operator.Operation.DIVISION)) {
                str = str + Operator.Operation.DIVISION;
            }
            a((OutputStream) fileOutputStream);
            e.a(file.getAbsolutePath(), str + str2);
            e.a(file.getAbsolutePath());
            a(str, fileOutputStream, z10);
        }
    }

    private void a(String str, FileOutputStream fileOutputStream, boolean z10) {
        a((OutputStream) fileOutputStream);
        String b10 = b(str, z10);
        if (z10) {
            try {
                File file = new File(b10);
                this.f10589k = file;
                file.createNewFile();
                this.f10590l = new FileOutputStream(this.f10589k, true);
            } catch (Exception e10) {
                g.a(f10584f, e10);
            }
        } else {
            File file2 = new File(b10);
            this.f10586h = file2;
            file2.createNewFile();
            this.f10587i = new FileOutputStream(this.f10586h, true);
        }
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length >= 6) {
            ArrayList arrayList = new ArrayList();
            for (File add : listFiles) {
                arrayList.add(add);
            }
            Collections.sort(arrayList, new d());
            for (int i10 = 0; i10 < (arrayList.size() - 6) + 1; i10++) {
                try {
                    ((File) arrayList.get(i10)).delete();
                } catch (Exception e10) {
                    g.a(f10584f, e10);
                }
            }
        }
    }

    private void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception e10) {
                g.a(f10584f, e10);
            }
        }
    }

    public void a() {
        a((OutputStream) this.f10587i);
        this.f10587i = null;
        this.f10586h = null;
        a((OutputStream) this.f10590l);
        this.f10590l = null;
        this.f10589k = null;
    }
}
