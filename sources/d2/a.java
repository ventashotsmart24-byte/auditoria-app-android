package d2;

import a2.b;
import ba.t;
import com.bigbee.bean.request.BBEventRequestBean;
import com.bigbee.bean.request.CustomizeEventBean;
import com.bigbee.db.EventDbModel;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.utl.BaseMonitor;
import f2.d;
import f2.e;
import i2.f;
import i2.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Dns;
import okhttp3.Interceptor;
import t9.i;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public b f6198a;

    /* renamed from: b  reason: collision with root package name */
    public final Dns f6199b;

    /* renamed from: c  reason: collision with root package name */
    public final Interceptor f6200c;

    /* renamed from: d  reason: collision with root package name */
    public final String f6201d;

    /* renamed from: e  reason: collision with root package name */
    public Gson f6202e = new Gson();

    /* renamed from: d2.a$a  reason: collision with other inner class name */
    public static final class C0077a implements f2.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f6203a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f6204b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f6205c;

        public C0077a(a aVar, List list, b bVar) {
            this.f6203a = aVar;
            this.f6204b = list;
            this.f6205c = bVar;
        }

        public void a(d dVar, g2.a aVar) {
            i.g(dVar, "request");
            i.g(aVar, "response");
            b bVar = this.f6205c;
            if (bVar != null) {
                bVar.a(aVar.a());
            }
            List list = this.f6204b;
            if (list != null && list.size() > 998) {
                this.f6203a.e();
            }
            if (!aVar.d()) {
                if (!(aVar.c() == 200 || aVar.c() == 304 || aVar.c() == 403 || b2.a.f4202d == null)) {
                    t2.a aVar2 = t2.a.f9350a;
                    DomainInfo domainInfo = b2.a.f4202d;
                    i.f(domainInfo, "TDC");
                    aVar2.q(domainInfo, "key_tdc");
                }
                this.f6203a.f6198a.f(this.f6204b, false);
                return;
            }
            this.f6203a.f6198a.b(this.f6204b);
        }

        public void b(d dVar, Exception exc) {
            i.g(dVar, "request");
            i.g(exc, "e");
            this.f6203a.f6198a.f(this.f6204b, false);
            List list = this.f6204b;
            if (list != null && list.size() > 998) {
                this.f6203a.e();
            }
            if (b2.a.f4202d != null) {
                t2.a aVar = t2.a.f9350a;
                DomainInfo domainInfo = b2.a.f4202d;
                i.f(domainInfo, "TDC");
                aVar.q(domainInfo, "key_tdc");
            }
        }
    }

    public a(b bVar, Dns dns, Interceptor interceptor) {
        i.g(bVar, "mCollector");
        i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f6198a = bVar;
        this.f6199b = dns;
        this.f6200c = interceptor;
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "this.javaClass.simpleName");
        this.f6201d = simpleName;
    }

    public void a(EventDbModel eventDbModel) {
        i.g(eventDbModel, "dbModel");
        this.f6198a.d(eventDbModel);
    }

    public void b(EventDbModel eventDbModel) {
        i.g(eventDbModel, "dbModel");
        this.f6198a.e(eventDbModel);
    }

    public void c(b bVar) {
        BBEventRequestBean a10;
        String str;
        List g10 = g();
        if (g10 != null && !g.b(g10) && (a10 = this.f6198a.a(f(g10))) != null) {
            ArrayList<CustomizeEventBean> event = a10.getEvent();
            boolean z10 = false;
            if (event != null && g.b(event)) {
                z10 = true;
            }
            if (!z10) {
                String json = this.f6202e.toJson((Object) a10);
                if (!g.a(json)) {
                    f fVar = f.f7018a;
                    String str2 = b2.a.f4203e;
                    i.f(str2, "URL_HOST_MAIN");
                    if (fVar.b(str2)) {
                        str = "http://";
                    } else {
                        str = "https://";
                    }
                    f2.a e10 = new f2.a().i(str + b2.a.f4203e + b2.a.f4201c + b2.a.f4199a, str + b2.a.f4204f + b2.a.f4201c + b2.a.f4199a).h(e.POST).e("Content-Type", "application/json;charset=utf-8");
                    StringBuilder sb = new StringBuilder();
                    sb.append("{\"data\":");
                    sb.append(json);
                    sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
                    e2.a.f6467b.a().c(e10.g(sb.toString()).f(this.f6200c).b(this.f6199b).a(new C0077a(this, g10, bVar)));
                }
            }
        }
    }

    public final void e() {
        i2.a aVar = i2.a.f6993a;
        if (aVar.b()) {
            this.f6198a.c();
        }
        aVar.i(false);
    }

    public final List f(List list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EventDbModel eventDbModel = (EventDbModel) it.next();
            if (!i.b(eventDbModel.eventId, "app_cast")) {
                arrayList.add(eventDbModel);
            } else {
                String str = eventDbModel.reserveA;
                i.f(str, "it.reserveA");
                if (t.o(str, "\"errorCode\",\"value\":\"\"", false, 2, (Object) null)) {
                    String str2 = eventDbModel.reserveA;
                    i.f(str2, "it.reserveA");
                    int y10 = t.y(str2, "transId", 0, false, 6, (Object) null);
                    String str3 = eventDbModel.reserveA;
                    i.f(str3, "it.reserveA");
                    int y11 = t.y(str3, "currId", 0, false, 6, (Object) null);
                    String str4 = eventDbModel.reserveA;
                    i.f(str4, "it.reserveA");
                    String substring = str4.substring(y10 + 18, y10 + 54);
                    i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String str5 = eventDbModel.reserveA;
                    i.f(str5, "it.reserveA");
                    String substring2 = str5.substring(y11 + 17, y11 + 18);
                    i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (hashMap.get(substring) != null) {
                        String str6 = (String) hashMap2.get(substring);
                        if (str6 == null) {
                            str6 = "0";
                        }
                        if (str6.compareTo(substring2) >= 0) {
                        }
                    }
                    hashMap.put(substring, eventDbModel);
                    hashMap2.put(substring, substring2);
                } else {
                    arrayList.add(eventDbModel);
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (Map.Entry value : hashMap.entrySet()) {
                arrayList.add(value.getValue());
            }
        }
        return arrayList;
    }

    public List g() {
        List g10;
        synchronized (this) {
            g10 = this.f6198a.g();
            h9.t tVar = h9.t.f17319a;
        }
        return g10;
    }
}
