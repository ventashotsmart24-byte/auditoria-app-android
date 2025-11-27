package com.mobile.brasiltv.utils;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.event.SubTitleDownloadFinishEvent;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import ka.d;
import ma.m;
import ma.p;
import xa.c;

public class a1 {

    /* renamed from: a  reason: collision with root package name */
    public int f12497a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f12498b = 0;

    /* renamed from: c  reason: collision with root package name */
    public ka.b f12499c = new ka.b("", new b());

    public class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f12500a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f12501b;

        public a(String str, File file) {
            this.f12500a = str;
            this.f12501b = file;
        }

        public void onComplete() {
            a1 a1Var = a1.this;
            a1Var.f12497a = a1Var.f12497a + 1;
            if (a1.this.f12497a == a1.this.f12498b) {
                c.c().j(new SubTitleDownloadFinishEvent(this.f12500a));
            }
            p.a("DownSubTitle", "total:" + a1.this.f12498b + ",index:" + a1.this.f12497a + "," + this.f12501b.getName() + " download completed!");
        }

        public void onError(Throwable th) {
            a1 a1Var = a1.this;
            a1Var.f12497a = a1Var.f12497a + 1;
            if (a1.this.f12497a == a1.this.f12498b) {
                c.c().j(new SubTitleDownloadFinishEvent(this.f12500a));
            }
            p.a("DownSubTitle", this.f12501b.getName() + " download error!" + th.getMessage());
        }

        public void onNext(Object obj) {
            p.a("DownSubTitle", "download next!");
        }

        public void onSubscribe(Disposable disposable) {
        }
    }

    public class b implements d {
        public b() {
        }

        public void a() {
            p.a("SubtitleDownloadUtil", "onFinishDownload");
        }

        public void b(int i10) {
            p.a("SubtitleDownloadUtil", "onProgress progress= " + i10);
        }

        public void c(Exception exc) {
            p.a("SubtitleDownloadUtil", "onFail " + exc.getMessage());
        }

        public void d(long j10) {
            p.a("SubtitleDownloadUtil", "onStartDownload length = " + j10);
        }
    }

    public void d(String str, List list) {
        this.f12498b = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubTitleData subTitleData = (SubTitleData) it.next();
            String filePath = subTitleData.getFilePath();
            String subUrl = subTitleData.getSubUrl();
            if (!TextUtils.isEmpty(filePath) && !TextUtils.isEmpty(subUrl)) {
                File file = new File(filePath);
                if (!file.exists()) {
                    e(file, subUrl, str);
                } else if (file.length() == 0 || file.isDirectory()) {
                    p.a("DownSubTitle", "file don't download finish, delete it.");
                    if (file.delete()) {
                        e(file, subUrl, str);
                    } else {
                        p.a("DownSubTitle", "delete file occur error.");
                    }
                } else {
                    String b10 = m.b(file);
                    String md5 = subTitleData.getMd5();
                    p.a("DownSubTitle", "md5:" + md5 + ",fileMd5:" + b10);
                    if (TextUtils.isEmpty(b10) || !TextUtils.equals(md5, b10)) {
                        p.a("DownSubTitle", "file ms5 isn't match, delete it.");
                        if (file.delete()) {
                            e(file, subUrl, str);
                        } else {
                            p.a("DownSubTitle", "delete file occur error.");
                        }
                    } else {
                        p.a("DownSubTitle", "file exists");
                        int i10 = this.f12497a + 1;
                        this.f12497a = i10;
                        if (i10 == this.f12498b) {
                            c.c().j(new SubTitleDownloadFinishEvent(str));
                        }
                    }
                }
            }
        }
    }

    public final void e(File file, String str, String str2) {
        if (file.mkdirs()) {
            this.f12499c.b(str, file, new a(str2, file));
        }
    }
}
