package l6;

import android.content.Context;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.entity.RangerPlayTag;
import com.umeng.analytics.pro.bd;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import j6.f;
import j6.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.q;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.LiveAddress;
import mobile.com.requestframe.utils.response.PosterList;
import org.android.agoo.common.AgooConstants;
import r5.k;
import s9.l;
import s9.p;
import t9.i;
import t9.j;

public final class g0 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final b6.f f18415a;

    /* renamed from: b  reason: collision with root package name */
    public final g f18416b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f18417c;

    /* renamed from: d  reason: collision with root package name */
    public o6.a f18418d;

    /* renamed from: e  reason: collision with root package name */
    public List f18419e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public Disposable f18420f;

    /* renamed from: g  reason: collision with root package name */
    public ArrayList f18421g = new ArrayList();

    public static final class a extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f18422a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f18423b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Channel f18424c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g0 g0Var, List list, Channel channel) {
            super(1);
            this.f18422a = g0Var;
            this.f18423b = list;
            this.f18424c = channel;
        }

        /* renamed from: b */
        public final Media invoke(o6.a aVar) {
            i.g(aVar, "it");
            Object obj = aVar.e().get(0);
            i.f(obj, "it.liveAddressList[0]");
            LiveAddress liveAddress = (LiveAddress) obj;
            g0 g0Var = this.f18422a;
            List list = this.f18423b;
            i.d(list);
            String c10 = aVar.c();
            String supportVideoType = this.f18424c.getSupportVideoType();
            if (supportVideoType == null) {
                supportVideoType = "";
            }
            return g0Var.p(list, liveAddress, c10, supportVideoType);
        }
    }

    public static final class b extends j implements p {

        /* renamed from: a  reason: collision with root package name */
        public static final b f18425a = new b();

        public b() {
            super(2);
        }

        public final void b(ArrayList arrayList, Media media) {
            if (media != null) {
                arrayList.add(media);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Media) obj2);
            return t.f17319a;
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f18426a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Channel f18427b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g0 g0Var, Channel channel) {
            super(1);
            this.f18426a = g0Var;
            this.f18427b = channel;
        }

        /* renamed from: b */
        public final Program invoke(ArrayList arrayList) {
            i.g(arrayList, "it");
            k7.f.e("media size: " + arrayList.size(), new Object[0]);
            return this.f18426a.q(this.f18427b, arrayList);
        }
    }

    public static final class d extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f18428a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Channel f18429b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(g0 g0Var, Channel channel) {
            super(1);
            this.f18428a = g0Var;
            this.f18429b = channel;
        }

        public final void b(Program program) {
            g0 g0Var = this.f18428a;
            b0.U(g0Var, "program info is " + program);
            g x10 = this.f18428a.x();
            Channel channel = this.f18429b;
            i.f(program, "it");
            x10.C0(channel, program);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Program) obj);
            return t.f17319a;
        }
    }

    public static final class e extends j implements l {

        /* renamed from: a  reason: collision with root package name */
        public static final e f18430a = new e();

        public e() {
            super(1);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f17319a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public g0(b6.f fVar, g gVar) {
        i.g(fVar, "frag");
        i.g(gVar, "view");
        this.f18415a = fVar;
        this.f18416b = gVar;
    }

    public static final ArrayList A() {
        return new ArrayList();
    }

    public static final void B(p pVar, Object obj, Object obj2) {
        i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final Program C(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (Program) lVar.invoke(obj);
    }

    public static final void D(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final Media z(l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        return (Media) lVar.invoke(obj);
    }

    public void F(boolean z10) {
        this.f18417c = z10;
    }

    public void G(Channel channel) {
        List<LiveAddress> liveAddressList;
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        if (!(channel == null || (liveAddressList = channel.getLiveAddressList()) == null || !liveAddressList.isEmpty())) {
            z10 = true;
        }
        if (z10) {
            this.f18419e = arrayList;
            return;
        }
        o6.a aVar = new o6.a(o6.c.c().a(), o6.c.c().c(), o6.c.c().d(), new ArrayList());
        o6.a aVar2 = new o6.a(o6.c.b().a(), o6.c.b().c(), o6.c.b().d(), new ArrayList());
        o6.a aVar3 = new o6.a(o6.c.a().a(), o6.c.a().c(), o6.c.a().d(), new ArrayList());
        i.d(channel);
        List<LiveAddress> liveAddressList2 = channel.getLiveAddressList();
        if (liveAddressList2 != null) {
            for (LiveAddress liveAddress : liveAddressList2) {
                if (b0.J(liveAddress.getQuality()) || i.b(liveAddress.getQuality(), "1")) {
                    aVar.e().add(liveAddress);
                } else if (i.b(liveAddress.getQuality(), "2")) {
                    aVar2.e().add(liveAddress);
                } else if (i.b(liveAddress.getQuality(), "3")) {
                    aVar3.e().add(liveAddress);
                }
            }
        }
        if (!aVar3.e().isEmpty()) {
            arrayList.add(aVar3);
        }
        if (!aVar2.e().isEmpty()) {
            arrayList.add(aVar2);
        }
        if (!aVar.e().isEmpty()) {
            arrayList.add(aVar);
        }
        this.f18419e = arrayList;
    }

    public void b(Channel channel, String str) {
        boolean z10;
        String str2;
        String str3;
        String str4;
        boolean z11;
        i.g(str, "slbHost");
        t();
        if (channel != null) {
            b0.U(this, "channel: " + channel);
            r5.i iVar = r5.i.f19378a;
            List x10 = iVar.x(k.LIVE);
            boolean z12 = false;
            if (x10 == null || x10.isEmpty()) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                b0.U(this, "live cdn list");
                str3 = iVar.z();
                if (str3.length() == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    str3 = "20900";
                }
                str2 = y.f12639a.c(str3);
            } else {
                str3 = "";
                str2 = str3;
            }
            List<LiveAddress> liveAddressList = channel.getLiveAddressList();
            if (liveAddressList == null || liveAddressList.isEmpty()) {
                z12 = true;
            }
            if (z12) {
                b0.U(this, "live address list is empty");
                str2 = "EC21";
                str3 = AgooConstants.REPORT_MESSAGE_NULL;
            }
            String str5 = str3;
            String str6 = str2;
            if (!i.b(str6, "")) {
                c2.d.f4594a.g(channel.getChannelCode(), channel.getName(), str, y.f12639a.h(), "", str6, str5, "apk");
                g gVar = this.f18416b;
                StringBuilder sb = new StringBuilder();
                sb.append(str6);
                sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
                Context context = this.f18415a.getContext();
                if (context != null) {
                    str4 = x.f12622a.y(context, R.string.failed_ec5);
                } else {
                    str4 = null;
                }
                sb.append(str4);
                gVar.z0(sb.toString());
                return;
            }
            b0.U(this, "live cdn tag list: " + x10);
            this.f18420f = Observable.fromIterable(this.f18419e).map(new a0(new a(this, x10, channel))).collect(new b0(), new c0(b.f18425a)).map(new d0(new c(this, channel))).compose(q.c()).compose(this.f18415a.O2()).subscribe(new e0(new d(this, channel)), new f0(e.f18430a));
        }
    }

    public void e() {
    }

    public void g() {
    }

    public final Media p(List list, LiveAddress liveAddress, String str, String str2) {
        boolean z10;
        String str3;
        String playCode = liveAddress.getPlayCode();
        if (playCode == null || playCode.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 || !list.contains(liveAddress.getTag())) {
            return null;
        }
        String playCode2 = liveAddress.getPlayCode();
        i.d(playCode2);
        String license = liveAddress.getLicense();
        if (b0.K(liveAddress.getAVFormat())) {
            str3 = liveAddress.getAVFormat();
        } else {
            str3 = "";
        }
        return new Media(playCode2, license, "", str, str2, str3);
    }

    public final Program q(Channel channel, List list) {
        return new Program(channel.getChannelCode(), RangerPlayTag.LIVE.getValue(), channel.getName(), "-1", this.f18416b.Z0(), bd.f13853m, list, "", 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: o6.a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: o6.a} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r() {
        /*
            r8 = this;
            java.util.List r0 = r8.f18419e
            boolean r0 = r0.isEmpty()
            r1 = 0
            if (r0 == 0) goto L_0x000c
            r8.f18418d = r1
            return
        L_0x000c:
            java.util.List r0 = r8.f18419e
            boolean r2 = r0 instanceof java.util.Collection
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x001c
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x003e
        L_0x001c:
            java.util.Iterator r0 = r0.iterator()
        L_0x0020:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r0.next()
            o6.a r2 = (o6.a) r2
            int r2 = r2.b()
            com.mobile.brasiltv.activity.MainAty$a r5 = com.mobile.brasiltv.activity.MainAty.A
            int r5 = r5.d()
            if (r2 != r5) goto L_0x003a
            r2 = 1
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            if (r2 == 0) goto L_0x0020
            r0 = 1
        L_0x003e:
            if (r0 == 0) goto L_0x006b
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0065
            java.lang.Object r2 = r0.next()
            r5 = r2
            o6.a r5 = (o6.a) r5
            int r5 = r5.b()
            com.mobile.brasiltv.activity.MainAty$a r6 = com.mobile.brasiltv.activity.MainAty.A
            int r6 = r6.d()
            if (r5 != r6) goto L_0x0061
            r5 = 1
            goto L_0x0062
        L_0x0061:
            r5 = 0
        L_0x0062:
            if (r5 == 0) goto L_0x0046
            r1 = r2
        L_0x0065:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            goto L_0x0299
        L_0x006b:
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            int r0 = r0.d()
            java.lang.String r2 = "1080p"
            java.lang.String r5 = "720p"
            if (r0 == r3) goto L_0x01e7
            r6 = 2
            java.lang.String r7 = "480p"
            if (r0 == r6) goto L_0x0134
            r2 = 3
            if (r0 == r2) goto L_0x0081
            goto L_0x0299
        L_0x0081:
            java.util.List r0 = r8.f18419e
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x008f
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x008f
        L_0x008d:
            r0 = 0
            goto L_0x00aa
        L_0x008f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x008d
            java.lang.Object r2 = r0.next()
            o6.a r2 = (o6.a) r2
            java.lang.String r2 = r2.c()
            boolean r2 = t9.i.b(r2, r5)
            if (r2 == 0) goto L_0x0093
            r0 = 1
        L_0x00aa:
            if (r0 == 0) goto L_0x00db
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x00b2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00ca
            java.lang.Object r2 = r0.next()
            r3 = r2
            o6.a r3 = (o6.a) r3
            java.lang.String r3 = r3.c()
            boolean r3 = t9.i.b(r3, r5)
            if (r3 == 0) goto L_0x00b2
            r1 = r2
        L_0x00ca:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
            return
        L_0x00db:
            java.util.List r0 = r8.f18419e
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L_0x00e9
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x00e9
        L_0x00e7:
            r3 = 0
            goto L_0x0103
        L_0x00e9:
            java.util.Iterator r0 = r0.iterator()
        L_0x00ed:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00e7
            java.lang.Object r2 = r0.next()
            o6.a r2 = (o6.a) r2
            java.lang.String r2 = r2.c()
            boolean r2 = t9.i.b(r2, r7)
            if (r2 == 0) goto L_0x00ed
        L_0x0103:
            if (r3 == 0) goto L_0x0299
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x010b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0123
            java.lang.Object r2 = r0.next()
            r3 = r2
            o6.a r3 = (o6.a) r3
            java.lang.String r3 = r3.c()
            boolean r3 = t9.i.b(r3, r7)
            if (r3 == 0) goto L_0x010b
            r1 = r2
        L_0x0123:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
            return
        L_0x0134:
            java.util.List r0 = r8.f18419e
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L_0x0142
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x0142
        L_0x0140:
            r0 = 0
            goto L_0x015d
        L_0x0142:
            java.util.Iterator r0 = r0.iterator()
        L_0x0146:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x0140
            java.lang.Object r5 = r0.next()
            o6.a r5 = (o6.a) r5
            java.lang.String r5 = r5.c()
            boolean r5 = t9.i.b(r5, r7)
            if (r5 == 0) goto L_0x0146
            r0 = 1
        L_0x015d:
            if (r0 == 0) goto L_0x018e
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x0165:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x017d
            java.lang.Object r2 = r0.next()
            r3 = r2
            o6.a r3 = (o6.a) r3
            java.lang.String r3 = r3.c()
            boolean r3 = t9.i.b(r3, r7)
            if (r3 == 0) goto L_0x0165
            r1 = r2
        L_0x017d:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
            return
        L_0x018e:
            java.util.List r0 = r8.f18419e
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L_0x019c
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x019c
        L_0x019a:
            r3 = 0
            goto L_0x01b6
        L_0x019c:
            java.util.Iterator r0 = r0.iterator()
        L_0x01a0:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x019a
            java.lang.Object r5 = r0.next()
            o6.a r5 = (o6.a) r5
            java.lang.String r5 = r5.c()
            boolean r5 = t9.i.b(r5, r2)
            if (r5 == 0) goto L_0x01a0
        L_0x01b6:
            if (r3 == 0) goto L_0x0299
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x01be:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x01d6
            java.lang.Object r3 = r0.next()
            r4 = r3
            o6.a r4 = (o6.a) r4
            java.lang.String r4 = r4.c()
            boolean r4 = t9.i.b(r4, r2)
            if (r4 == 0) goto L_0x01be
            r1 = r3
        L_0x01d6:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
            return
        L_0x01e7:
            java.util.List r0 = r8.f18419e
            boolean r6 = r0 instanceof java.util.Collection
            if (r6 == 0) goto L_0x01f5
            boolean r6 = r0.isEmpty()
            if (r6 == 0) goto L_0x01f5
        L_0x01f3:
            r0 = 0
            goto L_0x0210
        L_0x01f5:
            java.util.Iterator r0 = r0.iterator()
        L_0x01f9:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x01f3
            java.lang.Object r6 = r0.next()
            o6.a r6 = (o6.a) r6
            java.lang.String r6 = r6.c()
            boolean r6 = t9.i.b(r6, r5)
            if (r6 == 0) goto L_0x01f9
            r0 = 1
        L_0x0210:
            if (r0 == 0) goto L_0x0241
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x0218:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0230
            java.lang.Object r2 = r0.next()
            r3 = r2
            o6.a r3 = (o6.a) r3
            java.lang.String r3 = r3.c()
            boolean r3 = t9.i.b(r3, r5)
            if (r3 == 0) goto L_0x0218
            r1 = r2
        L_0x0230:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
            return
        L_0x0241:
            java.util.List r0 = r8.f18419e
            boolean r5 = r0 instanceof java.util.Collection
            if (r5 == 0) goto L_0x024f
            boolean r5 = r0.isEmpty()
            if (r5 == 0) goto L_0x024f
        L_0x024d:
            r3 = 0
            goto L_0x0269
        L_0x024f:
            java.util.Iterator r0 = r0.iterator()
        L_0x0253:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x024d
            java.lang.Object r5 = r0.next()
            o6.a r5 = (o6.a) r5
            java.lang.String r5 = r5.c()
            boolean r5 = t9.i.b(r5, r2)
            if (r5 == 0) goto L_0x0253
        L_0x0269:
            if (r3 == 0) goto L_0x0299
            java.util.List r0 = r8.f18419e
            java.util.Iterator r0 = r0.iterator()
        L_0x0271:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0289
            java.lang.Object r3 = r0.next()
            r4 = r3
            o6.a r4 = (o6.a) r4
            java.lang.String r4 = r4.c()
            boolean r4 = t9.i.b(r4, r2)
            if (r4 == 0) goto L_0x0271
            r1 = r3
        L_0x0289:
            o6.a r1 = (o6.a) r1
            r8.f18418d = r1
            com.mobile.brasiltv.activity.MainAty$a r0 = com.mobile.brasiltv.activity.MainAty.A
            t9.i.d(r1)
            int r1 = r1.b()
            r0.m(r1)
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.g0.r():void");
    }

    public void s() {
        this.f18418d = null;
        MainAty.A.m(1);
    }

    public final void t() {
        Disposable disposable = this.f18420f;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (!z10) {
            Disposable disposable2 = this.f18420f;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f18420f = null;
        }
    }

    public final ArrayList u() {
        if (this.f18421g == null) {
            this.f18421g = new ArrayList();
        }
        this.f18421g.clear();
        d6.a aVar = d6.a.f16338a;
        if (aVar.j() == 3 && aVar.i().size() > 0) {
            Iterator it = aVar.i().iterator();
            while (it.hasNext()) {
                Favorite favorite = (Favorite) it.next();
                ArrayList arrayList = this.f18421g;
                String contentId = favorite.getContentId();
                i.d(contentId);
                String name = favorite.getName();
                i.d(name);
                Iterator it2 = it;
                Channel channel = r4;
                Channel channel2 = new Channel(contentId, name, favorite.getAlias(), 0, favorite.getPosterUrl(), (String) null, "0", (String) null, (String) null, (List<? extends PosterList>) null, (List<LiveAddress>) null);
                arrayList.add(channel);
                it = it2;
            }
        }
        return this.f18421g;
    }

    public o6.a v() {
        return this.f18418d;
    }

    public final ArrayList w() {
        return this.f18421g;
    }

    public final g x() {
        return this.f18416b;
    }

    public boolean y() {
        return this.f18417c;
    }
}
