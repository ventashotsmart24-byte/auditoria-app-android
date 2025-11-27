package com.umeng.message.proguard;

import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;
import org.json.JSONObject;

public final class j {

    /* renamed from: b  reason: collision with root package name */
    private static final j f15967b = new j();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Vector<String> f15968a = new Vector<>();

    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final UMessage f15969a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<String> f15970b;

        /* renamed from: c  reason: collision with root package name */
        private final int f15971c;

        public a(UMessage uMessage) {
            this.f15969a = uMessage;
            ArrayList<String> arrayList = new ArrayList<>();
            this.f15970b = arrayList;
            if (uMessage.isLargeIconFromInternet()) {
                arrayList.add(uMessage.getLargeIconUrl());
            }
            if (uMessage.isSoundFromInternet()) {
                arrayList.add(uMessage.getSoundUri());
            }
            if (!TextUtils.isEmpty(uMessage.getBarImageUrl())) {
                arrayList.add(uMessage.getBarImageUrl());
            }
            if (uMessage.hasBackgroundImage()) {
                arrayList.add(uMessage.getBackgroundImageUrl());
            }
            if (!TextUtils.isEmpty(uMessage.getBigImage())) {
                arrayList.add(uMessage.getBigImage());
            }
            this.f15971c = 3;
        }

        private static boolean a(String str) {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Application a10 = y.a();
                File file = new File(f.g(a10), UMUtils.MD5(str));
                File file2 = new File(f.g(a10), UMUtils.MD5(str) + ".tmp");
                if (file.exists()) {
                    f.a((Closeable) null);
                    f.a((Closeable) null);
                    return true;
                }
                if (file2.exists()) {
                    file2.delete();
                }
                InputStream openStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e10) {
                    e = e10;
                    fileOutputStream = null;
                    inputStream = openStream;
                    e = e;
                    try {
                        UPLog.e("DownloadResource", (Throwable) e);
                        f.a((Closeable) inputStream);
                        f.a((Closeable) fileOutputStream);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        f.a((Closeable) inputStream);
                        f.a((Closeable) fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                    inputStream = openStream;
                    th = th;
                    f.a((Closeable) inputStream);
                    f.a((Closeable) fileOutputStream);
                    throw th;
                }
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = openStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            file2.renameTo(file);
                            f.a((Closeable) openStream);
                            f.a((Closeable) fileOutputStream);
                            return true;
                        }
                    }
                } catch (Exception e11) {
                    e = e11;
                    inputStream = openStream;
                    e = e;
                    UPLog.e("DownloadResource", (Throwable) e);
                    f.a((Closeable) inputStream);
                    f.a((Closeable) fileOutputStream);
                    return false;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = openStream;
                    th = th;
                    f.a((Closeable) inputStream);
                    f.a((Closeable) fileOutputStream);
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
                fileOutputStream = null;
                UPLog.e("DownloadResource", (Throwable) e);
                f.a((Closeable) inputStream);
                f.a((Closeable) fileOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                f.a((Closeable) inputStream);
                f.a((Closeable) fileOutputStream);
                throw th;
            }
        }

        public final void run() {
            try {
                j.a(f.g(y.a()));
                int i10 = 0;
                boolean z10 = true;
                do {
                    i10++;
                    Iterator<String> it = this.f15970b.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        boolean a10 = a(next);
                        if (!a10) {
                            UPLog.i("DownloadResource", "download fail:", next);
                        }
                        z10 &= a10;
                    }
                    if (z10) {
                        break;
                    }
                } while (i10 >= this.f15971c);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            j.a().f15968a.remove(this.f15969a.getMsgId());
            Application a11 = y.a();
            UPushMessageHandler messageHandler = PushAgent.getInstance(a11).getMessageHandler();
            if (messageHandler != null) {
                messageHandler.handleMessage(a11, this.f15969a);
            }
        }
    }

    public static j a() {
        return f15967b;
    }

    public final boolean a(Intent intent) {
        String stringExtra;
        if (!(intent == null || (stringExtra = intent.getStringExtra("body")) == null || stringExtra.length() == 0)) {
            try {
                UMessage uMessage = new UMessage(new JSONObject(stringExtra));
                if (this.f15968a.contains(uMessage.getMsgId())) {
                    return true;
                }
                this.f15968a.add(uMessage.getMsgId());
                b.c(new a(uMessage));
                return true;
            } catch (Throwable th) {
                UPLog.e("DownloadResource", th);
            }
        }
        return false;
    }

    public static /* synthetic */ void a(File file) {
        try {
            if (file.exists()) {
                long j10 = 0;
                if (file.exists()) {
                    if (!file.isDirectory()) {
                        j10 = file.length();
                    } else {
                        LinkedList linkedList = new LinkedList();
                        linkedList.push(file);
                        while (!linkedList.isEmpty()) {
                            File[] listFiles = ((File) linkedList.pop()).listFiles();
                            if (listFiles != null) {
                                for (File file2 : listFiles) {
                                    if (file2.isDirectory()) {
                                        linkedList.push(file2);
                                    } else {
                                        j10 += file2.length();
                                    }
                                }
                            }
                        }
                    }
                }
                if (j10 > 1048576) {
                    bm.a(file.getPath(), new FileFilter() {
                        public final boolean accept(File file) {
                            if (System.currentTimeMillis() - file.lastModified() > 86400000) {
                                return true;
                            }
                            return false;
                        }
                    });
                }
            }
        } catch (Throwable th) {
            UPLog.e("DownloadResource", th);
        }
    }
}
