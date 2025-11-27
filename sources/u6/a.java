package u6;

import android.os.SystemClock;
import c2.e;
import com.taobao.accs.common.Constants;
import i2.f;
import java.util.HashMap;
import t9.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19631a = new a();

    public final void a(String str, String str2, String str3, long j10, int i10, String str4, Long l10, String str5) {
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        String str9 = str4;
        String str10 = str5;
        i.g(str6, "eCode");
        i.g(str7, "uri");
        i.g(str8, Constants.KEY_HOST);
        HashMap hashMap = new HashMap();
        hashMap.put("eCode", str6);
        hashMap.put("uri", str7);
        hashMap.put(Constants.KEY_HOST, str8);
        hashMap.put("duration", Long.valueOf(j10));
        hashMap.put("resumeCount", Integer.valueOf(i10));
        if (str9 != null) {
            hashMap.put("filePath", str9);
        }
        if (l10 != null) {
            hashMap.put("fileSize", Long.valueOf(l10.longValue()));
        }
        if (str10 != null) {
            hashMap.put("apkMd5", str10);
        }
        hashMap.put("availableSize", Long.valueOf(f.f7018a.a()));
        e.b(e.f4622a, "app_update", hashMap, SystemClock.elapsedRealtime(), 0, false, true, 24, (Object) null);
    }

    public final void b(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        i.g(str9, "mCode");
        i.g(str10, Constants.KEY_HOST);
        i.g(str11, "bussType");
        i.g(str12, "cdnType");
        i.g(str13, "title");
        i.g(str14, "castMode");
        i.g(str15, "castDevice");
        i.g(str8, "eventId");
        HashMap hashMap = new HashMap();
        hashMap.put("mCode", str9);
        hashMap.put("cdnType", str12);
        hashMap.put("bussType", str11);
        hashMap.put("castMode", str14);
        hashMap.put("castDevice", str15);
        hashMap.put("title", str13);
        hashMap.put(Constants.KEY_HOST, str10);
        e.b(e.f4622a, str8, hashMap, SystemClock.elapsedRealtime(), 0, false, false, 56, (Object) null);
    }
}
