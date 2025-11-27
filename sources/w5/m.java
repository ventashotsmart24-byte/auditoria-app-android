package w5;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.business.message.db.MessageDao;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.titans.entity.CdnType;
import h9.k;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ma.q;
import s9.l;
import t9.i;
import t9.j;
import x5.p;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f19701a = new m();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19702b = "1";

    /* renamed from: c  reason: collision with root package name */
    public static final String f19703c = "2";

    /* renamed from: d  reason: collision with root package name */
    public static final String f19704d = "0";

    /* renamed from: e  reason: collision with root package name */
    public static final String f19705e = "1";

    /* renamed from: f  reason: collision with root package name */
    public static final String f19706f = "2";

    /* renamed from: g  reason: collision with root package name */
    public static final String f19707g = "3";

    /* renamed from: h  reason: collision with root package name */
    public static final String f19708h = "4";

    /* renamed from: i  reason: collision with root package name */
    public static final String f19709i = CdnType.DIGITAL_TYPE_PCDN;

    /* renamed from: j  reason: collision with root package name */
    public static final k f19710j = new k("1", "1");

    /* renamed from: k  reason: collision with root package name */
    public static final k f19711k = new k("1", "2");

    /* renamed from: l  reason: collision with root package name */
    public static final k f19712l = new k("1", "3");

    /* renamed from: m  reason: collision with root package name */
    public static final k f19713m = new k("1", "4");

    /* renamed from: n  reason: collision with root package name */
    public static final k f19714n = new k("1", CdnType.DIGITAL_TYPE_PCDN);

    /* renamed from: o  reason: collision with root package name */
    public static final k f19715o = new k("2", "0");

    /* renamed from: p  reason: collision with root package name */
    public static boolean f19716p;

    /* renamed from: q  reason: collision with root package name */
    public static String f19717q;

    /* renamed from: r  reason: collision with root package name */
    public static List f19718r;

    /* renamed from: s  reason: collision with root package name */
    public static MessageDao f19719s;

    /* renamed from: t  reason: collision with root package name */
    public static n f19720t;

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final a f19721a = new a();

        public a() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            b0.U(m.f19701a, "delete in-app get cashback message success.");
        }
    }

    public static final class b extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final b f19722a = new b();

        public b() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19701a, "delete in-app get cashback message failure.");
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final c f19723a = new c();

        public c() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f17319a;
        }

        public final void invoke(Boolean bool) {
            b0.U(m.f19701a, "delete in-app message success.");
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final d f19724a = new d();

        public d() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19701a, "delete in-app message failure.");
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f19725a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(l lVar) {
            super(1);
            this.f19725a = lVar;
        }

        public final void b(List list) {
            m mVar = m.f19701a;
            b0.U(mVar, "query in-app message list success and result size is " + list.size() + '.');
            l lVar = this.f19725a;
            i.f(list, "it");
            lVar.invoke(list);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f17319a;
        }
    }

    public static final class f extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final f f19726a = new f();

        public f() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19701a, "query in-app message list failure.");
        }
    }

    public static final class g extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final g f19727a = new g();

        public g() {
            super(1);
        }

        public final void b(InAppMsg inAppMsg) {
            n m10;
            b0.U(m.f19701a, "save in-app message success.");
            if (inAppMsg != null && (m10 = m.f19720t) != null) {
                m10.a(inAppMsg);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((InAppMsg) obj);
            return t.f17319a;
        }
    }

    public static final class h extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final h f19728a = new h();

        public h() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19701a, "save in-app message failure.");
        }
    }

    public static final void N(List list, String str, ObservableEmitter observableEmitter) {
        List<InAppMsg> queryInAppMsgList;
        i.g(list, "$types");
        i.g(str, "$userId");
        i.g(observableEmitter, "emitter");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            String str2 = (String) kVar.c();
            String str3 = f19703c;
            if (i.b(str2, str3)) {
                List<InAppMsg> queryInAppMsgByMsgType = f19701a.C().queryInAppMsgByMsgType(str, str3);
                if (queryInAppMsgByMsgType != null && b0.I(queryInAppMsgByMsgType)) {
                    arrayList.addAll(queryInAppMsgByMsgType);
                }
            } else {
                String str4 = f19702b;
                if (i.b(str2, str4) && (queryInAppMsgList = f19701a.C().queryInAppMsgList(str, str4, (String) kVar.d())) != null && b0.I(queryInAppMsgList)) {
                    arrayList.addAll(queryInAppMsgList);
                }
            }
            if (b0.I(arrayList)) {
                observableEmitter.onNext(arrayList);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final void O(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void T(InAppMsg inAppMsg, ObservableEmitter observableEmitter) {
        i.g(inAppMsg, "$msg");
        i.g(observableEmitter, "it");
        m mVar = f19701a;
        if (mVar.w(inAppMsg)) {
            observableEmitter.onComplete();
            return;
        }
        mVar.C().addInAppMsg(inAppMsg);
        observableEmitter.onNext(inAppMsg);
        observableEmitter.onComplete();
    }

    public static final void U(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void V(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(ObservableEmitter observableEmitter) {
        i.g(observableEmitter, "it");
        f19701a.C().deleteInAppMsgByType(f19702b, f19708h);
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    public static final void p(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(InAppMsg inAppMsg, ObservableEmitter observableEmitter) {
        i.g(inAppMsg, "$msg");
        i.g(observableEmitter, "it");
        f19701a.C().deleteInAppMsg(inAppMsg);
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    public static final void t(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final k A() {
        return f19712l;
    }

    public final k B() {
        return f19711k;
    }

    public final MessageDao C() {
        if (f19719s == null) {
            f19719s = new MessageDao(App.f6050e.a());
        }
        MessageDao messageDao = f19719s;
        i.d(messageDao);
        return messageDao;
    }

    public final String D() {
        return f19703c;
    }

    public final String E() {
        return f19705e;
    }

    public final String F() {
        return f19708h;
    }

    public final String G() {
        return f19709i;
    }

    public final String H() {
        return f19707g;
    }

    public final String I() {
        return f19706f;
    }

    public final String J() {
        return f19702b;
    }

    public final boolean K(String str, String str2) {
        if ((!i.b(str, f19702b) || (!i.b(str2, f19705e) && !i.b(str2, f19706f) && !i.b(str2, f19707g) && !i.b(str2, f19708h))) && !i.b(str, f19703c)) {
            return false;
        }
        return true;
    }

    public final InAppMsg L(Map map) {
        InAppMsg inAppMsg = new InAppMsg();
        String str = (String) map.get("messageType");
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        inAppMsg.setMessageType(str);
        String str3 = (String) map.get("type");
        if (str3 == null) {
            str3 = str2;
        }
        inAppMsg.setType(str3);
        String str4 = (String) map.get("userId");
        if (str4 == null) {
            str4 = str2;
        }
        inAppMsg.setUserId(str4);
        String str5 = (String) map.get("title");
        if (str5 == null) {
            str5 = str2;
        }
        inAppMsg.setTitle(str5);
        String str6 = (String) map.get(ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        if (str6 == null) {
            str6 = str2;
        }
        inAppMsg.setText(str6);
        String str7 = (String) map.get("orderId");
        if (str7 == null) {
            str7 = str2;
        }
        inAppMsg.setOrderId(str7);
        String str8 = (String) map.get("url");
        if (str8 == null) {
            str8 = str2;
        }
        inAppMsg.setUrl(str8);
        String str9 = (String) map.get("avaliableCoin");
        if (str9 == null) {
            str9 = str2;
        }
        inAppMsg.setAvaliableCoin(str9);
        String str10 = (String) map.get("minCoin");
        if (str10 != null) {
            str2 = str10;
        }
        inAppMsg.setMinCoin(str2);
        return inAppMsg;
    }

    public final void M(l lVar) {
        boolean z10;
        i.g(lVar, SearchIntents.EXTRA_QUERY);
        String str = f19717q;
        boolean z11 = false;
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            List list = f19718r;
            if (list == null || list.isEmpty()) {
                z11 = true;
            }
            if (!z11) {
                String str2 = f19717q;
                i.d(str2);
                List list2 = f19718r;
                i.d(list2);
                Observable.create(new i(list2, str2)).compose(q.b()).subscribe(new j(new e(lVar)), new k(f.f19726a));
            }
        }
    }

    public final void Q(Map map) {
        i.g(map, "data");
        InAppMsg L = L(map);
        b0.U(this, "in-app msg that parsed is " + L);
        if (L == null || !K(L.getMessageType(), L.getType()) || b0.J(L.getUserId())) {
            b0.U(this, "find unsupported msg data.");
        } else {
            S(L);
        }
    }

    public final void R(n nVar) {
        i.g(nVar, "callback");
        f19720t = nVar;
    }

    public final void S(InAppMsg inAppMsg) {
        Observable.create(new f(inAppMsg)).compose(q.b()).subscribe(new g(g.f19727a), new h(h.f19728a));
    }

    public final void W(Context context, InAppMsg inAppMsg) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(inAppMsg, Constant.KEY_MSG);
        if (i.b(inAppMsg.getMessageType(), f19702b)) {
            String type = inAppMsg.getType();
            if (i.b(type, f19705e)) {
                b0.S(new x5.f(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_COUPON_BENEFITS);
            } else if (i.b(type, f19706f)) {
                b0.S(new x5.l(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_SERVICE_EFFECT);
            } else if (i.b(type, f19707g)) {
                b0.S(new x5.j(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_ORDER_PAY_FAILURE);
            } else if (i.b(type, f19708h)) {
                b0.S(new p(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_GET_CASHBACK);
            } else if (i.b(type, f19709i)) {
                b0.U(this, "Friend invitation pop-up is not supported at the moment.");
            }
        } else if (i.b(inAppMsg.getMessageType(), f19703c)) {
            b0.S(new x5.c(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_ACTIVITY_REMIND);
        }
    }

    public final void X() {
        f19720t = null;
    }

    public final void Y(boolean z10) {
        f19716p = z10;
    }

    public final void Z(String str, List list) {
        i.g(str, "userId");
        i.g(list, "types");
        f19717q = str;
        f19718r = list;
    }

    public final void n() {
        Observable.create(new a()).compose(q.a()).subscribe(new d(a.f19721a), new e(b.f19722a));
    }

    public final void r(InAppMsg inAppMsg) {
        i.g(inAppMsg, Constant.KEY_MSG);
        Observable.create(new l(inAppMsg)).compose(q.a()).subscribe(new b(c.f19723a), new c(d.f19724a));
    }

    public final boolean v(InAppMsg inAppMsg, k kVar) {
        i.g(inAppMsg, Constant.KEY_MSG);
        i.g(kVar, "msgType");
        if (!i.b(inAppMsg.getMessageType(), kVar.c()) || (!i.b(f19704d, kVar.d()) && !i.b(inAppMsg.getType(), kVar.d()))) {
            return false;
        }
        return true;
    }

    public final boolean w(InAppMsg inAppMsg) {
        if (!i.b(inAppMsg.getMessageType(), f19702b) || !i.b(inAppMsg.getType(), f19708h)) {
            return false;
        }
        if (b0.X(inAppMsg.getMinCoin()) <= 0.0f) {
            return true;
        }
        if (b0.X(inAppMsg.getAvaliableCoin()) < b0.X(inAppMsg.getMinCoin())) {
            u5.a.f19630a.b(App.f6050e.a(), "dont_remind", Boolean.FALSE);
            n();
            return true;
        }
        boolean booleanValue = ((Boolean) u5.a.f19630a.a(App.f6050e.a(), "dont_remind", Boolean.FALSE)).booleanValue();
        if (f19716p || booleanValue) {
            return true;
        }
        return false;
    }

    public final k x() {
        return f19715o;
    }

    public final k y() {
        return f19710j;
    }

    public final k z() {
        return f19713m;
    }
}
