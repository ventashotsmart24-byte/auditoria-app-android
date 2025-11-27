package a2;

import android.text.TextUtils;
import c2.l;
import com.bigbee.bean.CommonParamBean;
import com.bigbee.bean.body.CustomizeBodyBean;
import com.bigbee.bean.body.KeyValueBean;
import com.bigbee.bean.request.BBEventRequestBean;
import com.bigbee.bean.request.CustomizeEventBean;
import com.bigbee.bean.request.EventNameValueBean;
import com.bigbee.db.DbOperations;
import com.bigbee.db.EventDbModel;
import com.google.gson.Gson;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.i;
import t9.j;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f147a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f148b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f149c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f150d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f151e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f152f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f153g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f154h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f155i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f156j = "";

    /* renamed from: k  reason: collision with root package name */
    public final g f157k = h.b(C0004a.f159a);

    /* renamed from: l  reason: collision with root package name */
    public Gson f158l = new Gson();

    /* renamed from: a2.a$a  reason: collision with other inner class name */
    public static final class C0004a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final C0004a f159a = new C0004a();

        public C0004a() {
            super(0);
        }

        /* renamed from: b */
        public final DbOperations invoke() {
            return new DbOperations();
        }
    }

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f147a = simpleName;
    }

    public BBEventRequestBean a(List list) {
        List<KeyValueBean> parameter;
        i.g(list, "collectInfos");
        CommonParamBean b10 = l.f4666a.b();
        if (TextUtils.isEmpty(b10.getAppId())) {
            return null;
        }
        BBEventRequestBean bBEventRequestBean = new BBEventRequestBean(b10.getSn(), b10.getAppId(), b10.getModel(), b10.getMacAddr(), b10.getReserve1(), new ArrayList());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EventDbModel eventDbModel = (EventDbModel) it.next();
            if (!TextUtils.isEmpty(eventDbModel.eventId)) {
                long j10 = eventDbModel.startTime;
                if (j10 > 0) {
                    long j11 = eventDbModel.endTime;
                    if (j11 == 0 || j11 >= j10) {
                        String str = eventDbModel.eventId;
                        i.f(str, "it.eventId");
                        String str2 = eventDbModel.appVer;
                        i.f(str2, "it.appVer");
                        CustomizeEventBean customizeEventBean = new CustomizeEventBean(str, str2, eventDbModel.sysVer, eventDbModel.startTime, eventDbModel.endTime, new ArrayList());
                        if (!TextUtils.isEmpty(eventDbModel.reserveA)) {
                            try {
                                CustomizeBodyBean customizeBodyBean = (CustomizeBodyBean) this.f158l.fromJson(eventDbModel.reserveA, CustomizeBodyBean.class);
                                if (!(customizeBodyBean == null || (parameter = customizeBodyBean.getParameter()) == null)) {
                                    i.f(parameter, "parameter");
                                    for (KeyValueBean keyValueBean : parameter) {
                                        ArrayList<EventNameValueBean> parameter2 = customizeEventBean.getParameter();
                                        if (parameter2 != null) {
                                            String name = keyValueBean.getName();
                                            i.f(name, "listParameter.name");
                                            Object value = keyValueBean.getValue();
                                            i.f(value, "listParameter.value");
                                            parameter2.add(new EventNameValueBean(name, value));
                                        }
                                    }
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                        ArrayList<CustomizeEventBean> event = bBEventRequestBean.getEvent();
                        if (event != null) {
                            event.add(customizeEventBean);
                        }
                    }
                }
            }
        }
        return bBEventRequestBean;
    }

    public void b(List list) {
        i.g(list, "t");
        h().deleteListEvent(list);
    }

    public void c() {
        h().deleteNum();
    }

    public void d(Object obj) {
        DbOperations h10 = h();
        i.e(obj, "null cannot be cast to non-null type com.bigbee.db.EventDbModel");
        h10.saveEvent((EventDbModel) obj);
    }

    public void e(Object obj) {
        DbOperations h10 = h();
        i.e(obj, "null cannot be cast to non-null type com.bigbee.db.EventDbModel");
        h10.updateEvent((EventDbModel) obj);
    }

    public void f(List list, boolean z10) {
        i.g(list, "collectInfos");
        h().updateReportingStatus(list, z10);
    }

    public List g() {
        List<EventDbModel> list;
        if (this.f148b) {
            h().updateAllReportingStatus(false);
            this.f148b = false;
        }
        i2.a aVar = i2.a.f6993a;
        if (aVar.a()) {
            aVar.h(false);
            list = h().queryAllList(false);
        } else {
            list = h().queryLimitNum(false);
        }
        i.f(list, "collectInfos");
        f(list, true);
        return list;
    }

    public final DbOperations h() {
        return (DbOperations) this.f157k.getValue();
    }
}
