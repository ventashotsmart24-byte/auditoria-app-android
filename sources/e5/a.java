package e5;

import android.content.Context;
import android.os.Environment;
import com.umeng.analytics.pro.f;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import s6.b;
import t9.i;

public final class a extends b {
    public String b() {
        return "3";
    }

    public String c() {
        return "es";
    }

    public String d() {
        return "Mobile.apk";
    }

    public String e() {
        return "www.magistvec.com/download";
    }

    public String f(Context context) {
        i.g(context, f.X);
        StringBuilder sb = new StringBuilder();
        File externalCacheDir = context.getExternalCacheDir();
        i.d(externalCacheDir);
        sb.append(externalCacheDir.getAbsolutePath());
        sb.append("/sub/%s/%s/%s.srt");
        return sb.toString();
    }

    public String g() {
        return "27";
    }

    public String h() {
        return "www.magis4K.com";
    }

    public String i() {
        return "https://www.magistvec.com/download";
    }

    public String j() {
        return "05fe10da-f5c8-4a31-acbe-4ea02c5841e3";
    }

    public String k() {
        return "c6768bbe-189f-4d9d-b35c-f235a9fd7587";
    }

    public String l() {
        return "nsmm";
    }

    public String m() {
        return "system_m";
    }

    public List n() {
        ArrayList arrayList = new ArrayList();
        String path = Environment.getExternalStorageDirectory().getPath();
        arrayList.add(path + "/Android/.MMMobile/.sys");
        arrayList.add(path + "/Android/.MMconfig");
        arrayList.add(path + "/.MMMobile/.sys");
        return arrayList;
    }

    public boolean o() {
        return false;
    }

    public boolean p() {
        return true;
    }

    public boolean q() {
        return true;
    }

    public boolean r() {
        return false;
    }

    public boolean s() {
        return false;
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return false;
    }
}
