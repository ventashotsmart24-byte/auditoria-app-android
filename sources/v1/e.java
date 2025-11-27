package v1;

import android.content.Context;
import ba.s;
import com.advertlib.bean.AdInfo;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import t9.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f9472a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f9473b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public AdInfo f9474c;

    public final AdInfo a(Context context, String str, List list, String str2, String str3, long j10, boolean z10, String str4) {
        boolean z11;
        List list2;
        String str5 = str;
        String str6 = str2;
        i.g(context, f.X);
        i.g(str, "adType");
        i.g(list, "adInfos");
        String str7 = str3;
        i.g(str7, "userIdentity");
        String str8 = str4;
        i.g(str8, "hasPay");
        ArrayList c10 = y1.f.f9867a.c(context, str, list, str7, j10, z10, str8);
        if (c10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (str6 == null || str2.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            String str9 = str + str6;
            List list3 = (List) this.f9473b.get(str9);
            if (list3 == null) {
                list3 = new ArrayList();
                this.f9473b.put(str9, list3);
            }
            list2 = list3;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = c10.iterator();
            while (it.hasNext()) {
                AdInfo adInfo = (AdInfo) it.next();
                if (s.f(str6, adInfo.getMedia_type(), true)) {
                    i.f(adInfo, PlistBuilder.KEY_ITEM);
                    arrayList2.add(adInfo);
                    if (!list2.contains(adInfo.getAd_id())) {
                        arrayList.add(adInfo);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
                list2.clear();
                if (this.f9474c != null && arrayList.size() > 1) {
                    AdInfo adInfo2 = this.f9474c;
                    i.d(adInfo2);
                    arrayList.remove(adInfo2);
                    AdInfo adInfo3 = this.f9474c;
                    i.d(adInfo3);
                    list2.add(adInfo3.getAd_id());
                }
            }
        } else if (c10.size() == 1) {
            return (AdInfo) c10.get(0);
        } else {
            list2 = (List) this.f9473b.get(str);
            if (list2 == null) {
                list2 = new ArrayList();
                this.f9473b.put(str, list2);
            }
            Iterator it2 = c10.iterator();
            while (it2.hasNext()) {
                AdInfo adInfo4 = (AdInfo) it2.next();
                if (!list2.contains(adInfo4.getAd_id())) {
                    i.f(adInfo4, PlistBuilder.KEY_ITEM);
                    arrayList.add(adInfo4);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(c10);
                list2.clear();
                if (this.f9474c != null && arrayList.size() > 1) {
                    AdInfo adInfo5 = this.f9474c;
                    i.d(adInfo5);
                    arrayList.remove(adInfo5);
                    AdInfo adInfo6 = this.f9474c;
                    i.d(adInfo6);
                    list2.add(adInfo6.getAd_id());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AdInfo adInfo7 = (AdInfo) arrayList.get(new Random().nextInt(arrayList.size()));
        list2.add(adInfo7.getAd_id());
        this.f9474c = adInfo7;
        return adInfo7;
    }
}
