package c2;

import android.text.TextUtils;
import com.bigbee.bean.body.CustomizeBodyBean;
import com.bigbee.bean.body.EventBodyBean;
import com.bigbee.bean.body.KeyValueBean;
import com.bigbee.db.EventDbModel;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.gson.Gson;
import com.hpplay.component.common.ParamsMap;
import i2.d;
import i2.h;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import t9.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f4622a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final String f4623b = e.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public static final Gson f4624c = new Gson();

    public static final class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f4625a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f4626b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f4627c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ HashMap f4628d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f4629e;

        public a(long j10, long j11, String str, HashMap hashMap, boolean z10) {
            this.f4625a = j10;
            this.f4626b = j11;
            this.f4627c = str;
            this.f4628d = hashMap;
            this.f4629e = z10;
        }

        public void a() {
            long j10;
            h hVar = h.f7019a;
            long a10 = hVar.a();
            long j11 = this.f4625a;
            i2.a aVar = i2.a.f6993a;
            long g10 = a10 + (j11 - aVar.g());
            if (this.f4626b > 0) {
                j10 = hVar.a() + (this.f4626b - aVar.g());
            } else {
                j10 = g10;
            }
            l lVar = l.f4666a;
            if (!TextUtils.isEmpty(lVar.b().getUserName())) {
                HashMap hashMap = this.f4628d;
                String userName = lVar.b().getUserName();
                if (userName == null) {
                    userName = "";
                }
                hashMap.put("uname", userName);
            }
            i.f4633q.a().w(e.f4622a.c(this.f4627c, this.f4628d, g10, j10, this.f4629e));
        }
    }

    public static /* synthetic */ void b(e eVar, String str, HashMap hashMap, long j10, long j11, boolean z10, boolean z11, int i10, Object obj) {
        long j12;
        boolean z12;
        boolean z13;
        if ((i10 & 8) != 0) {
            j12 = 0;
        } else {
            j12 = j11;
        }
        if ((i10 & 16) != 0) {
            z12 = false;
        } else {
            z12 = z10;
        }
        if ((i10 & 32) != 0) {
            z13 = false;
        } else {
            z13 = z11;
        }
        eVar.a(str, hashMap, j10, j12, z12, z13);
    }

    public static /* synthetic */ EventDbModel d(e eVar, String str, HashMap hashMap, long j10, long j11, boolean z10, int i10, Object obj) {
        long j12;
        boolean z11;
        if ((i10 & 8) != 0) {
            j12 = 0;
        } else {
            j12 = j11;
        }
        if ((i10 & 16) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        return eVar.c(str, hashMap, j10, j12, z11);
    }

    public final synchronized void a(String str, HashMap hashMap, long j10, long j11, boolean z10, boolean z11) {
        boolean z12;
        String str2 = str;
        i.g(str, "eventId");
        HashMap hashMap2 = hashMap;
        i.g(hashMap, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        if (str.length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            d.f7007c.a().f(new a(j10, j11, str, hashMap, z10));
        }
    }

    public final EventDbModel c(String str, HashMap hashMap, long j10, long j11, boolean z10) {
        HashMap hashMap2 = hashMap;
        i.g(hashMap2, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        CustomizeBodyBean customizeBodyBean = new CustomizeBodyBean();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (!hashMap.isEmpty()) {
            for (String str2 : hashMap.keySet()) {
                if (hashMap2.get(str2) != null) {
                    copyOnWriteArrayList.add(new KeyValueBean(str2, hashMap2.get(str2)));
                }
            }
        }
        l lVar = l.f4666a;
        if (!TextUtils.isEmpty(lVar.b().getUserId())) {
            copyOnWriteArrayList.add(new KeyValueBean(ParamsMap.DeviceParams.KEY_UID, lVar.b().getUserId()));
        }
        if (!copyOnWriteArrayList.isEmpty()) {
            customizeBodyBean.setParameter(copyOnWriteArrayList);
        }
        EventDbModel eventDbModel = new EventDbModel();
        eventDbModel.notIntactEvent = z10;
        String json = f4624c.toJson((Object) customizeBodyBean);
        i.f(json, "eventGson.toJson(mCustomKeyValueBean)");
        EventDbModel transportEventDbModel = new EventBodyBean(lVar.b().getAppVer(), lVar.b().getSysVer(), j10, str, json, j11, lVar.b().getRangerVer()).transportEventDbModel(eventDbModel);
        i.f(transportEventDbModel, "mEventBodyBean.transportEventDbModel(eventDbModel)");
        return transportEventDbModel;
    }
}
