package d6;

import android.text.TextUtils;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.bean.event.AlreadyQueryFavEvent;
import com.mobile.brasiltv.bean.event.UpdateFavStatusEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.msandroid.mobile.R;
import h9.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mobile.com.requestframe.utils.response.AddFavorite;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.GetFavoriteDate;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import s9.l;
import t9.g;
import t9.i;
import t9.j;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16338a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList f16339b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static ArrayList f16340c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static HashMap f16341d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public static ArrayList f16342e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public static int f16343f = 1;

    /* renamed from: d6.a$a  reason: collision with other inner class name */
    public static final class C0214a extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Channel f16344a;

        /* renamed from: d6.a$a$a  reason: collision with other inner class name */
        public static final class C0215a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f16345a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0215a(String str) {
                super(1);
                this.f16345a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f16345a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public C0214a(Channel channel) {
            this.f16344a = channel;
        }

        /* renamed from: f */
        public void onNext(AddFavoriteResult addFavoriteResult) {
            i.g(addFavoriteResult, "it");
            List<AddFavorite> favoriteList = addFavoriteResult.getData().getFavoriteList();
            i.d(favoriteList);
            Favorite favorite = new Favorite(favoriteList.get(0).getFavoriteId(), this.f16344a.getChannelCode(), this.f16344a.getName(), "2", (Integer) null, this.f16344a.getAlias(), (Float) null, (Integer) null, (Integer) null, (String) null, (List) null, this.f16344a.getPosterUrl(), false, 4096, (g) null);
            if (!a.f16340c.contains(this.f16344a.getChannelCode())) {
                a.f16339b.add(0, favorite);
                a.f16340c.add(0, this.f16344a.getChannelCode());
                HashMap d10 = a.f16341d;
                String channelCode = this.f16344a.getChannelCode();
                Integer id = favorite.getId();
                i.d(id);
                d10.put(channelCode, id);
            }
            if (a.f16342e.contains(this.f16344a.getChannelCode())) {
                a.f16342e.remove(this.f16344a.getChannelCode());
            }
            xa.c.c().j(new UpdateFavStatusEvent(this.f16344a.getChannelCode(), true));
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            if (a.f16342e.contains(this.f16344a.getChannelCode())) {
                a.f16342e.remove(this.f16344a.getChannelCode());
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            if (TextUtils.equals("portal100061", str)) {
                f1.a.j(f1.f12517a, App.f6050e.a(), R.string.vod_fav_limit, 0, 4, (Object) null);
            } else {
                x.f12622a.w(App.f6050e.a(), new C0215a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Channel f16346a;

        /* renamed from: d6.a$b$a  reason: collision with other inner class name */
        public static final class C0216a extends j implements l {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f16347a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0216a(String str) {
                super(1);
                this.f16347a = str;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f17319a;
            }

            public final void invoke(String str) {
                f1.f12517a.x(y.p(y.f12639a, this.f16347a, (String) null, (String) null, 6, (Object) null));
            }
        }

        public b(Channel channel) {
            this.f16346a = channel;
        }

        /* renamed from: f */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            i.g(delFavoriteResult, "it");
            if (a.f16340c.contains(this.f16346a.getChannelCode())) {
                a.f16340c.remove(this.f16346a.getChannelCode());
                a.f16341d.remove(this.f16346a.getChannelCode());
            }
            ArrayList b10 = a.f16339b;
            Channel channel = this.f16346a;
            int i10 = -1;
            int i11 = 0;
            for (Object next : b10) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (i.b(((Favorite) next).getContentId(), channel.getChannelCode())) {
                    i10 = i11;
                }
                i11 = i12;
            }
            if (i10 >= 0) {
                a.f16339b.remove(i10);
            }
            if (a.f16342e.contains(this.f16346a.getChannelCode())) {
                a.f16342e.remove(this.f16346a.getChannelCode());
            }
            xa.c.c().j(new UpdateFavStatusEvent(this.f16346a.getChannelCode(), false));
        }

        public void onError(Throwable th) {
            i.g(th, "e");
            super.onError(th);
            if (a.f16342e.contains(this.f16346a.getChannelCode())) {
                a.f16342e.remove(this.f16346a.getChannelCode());
            }
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            x.f12622a.w(App.f6050e.a(), new C0216a(str));
        }
    }

    public static final class c extends ha.a {
        /* renamed from: f */
        public void onNext(GetFavoriteResult getFavoriteResult) {
            i.g(getFavoriteResult, "it");
            a.f16338a.n(3);
            a.f16339b.clear();
            a.f16340c.clear();
            a.f16341d.clear();
            if (getFavoriteResult.getData() != null) {
                GetFavoriteDate data = getFavoriteResult.getData();
                i.d(data);
                if (b0.I(data.getFavoriteList())) {
                    ArrayList b10 = a.f16339b;
                    GetFavoriteDate data2 = getFavoriteResult.getData();
                    i.d(data2);
                    List<Favorite> favoriteList = data2.getFavoriteList();
                    i.d(favoriteList);
                    b10.addAll(favoriteList);
                    GetFavoriteDate data3 = getFavoriteResult.getData();
                    i.d(data3);
                    List<Favorite> favoriteList2 = data3.getFavoriteList();
                    i.d(favoriteList2);
                    for (Favorite favorite : favoriteList2) {
                        ArrayList c10 = a.f16340c;
                        String contentId = favorite.getContentId();
                        i.d(contentId);
                        c10.add(contentId);
                        HashMap d10 = a.f16341d;
                        String contentId2 = favorite.getContentId();
                        i.d(contentId2);
                        Integer id = favorite.getId();
                        i.d(id);
                        d10.put(contentId2, id);
                    }
                }
            }
            xa.c.c().j(new AlreadyQueryFavEvent());
        }

        public void showErrorHint(String str) {
            i.g(str, "returnCode");
            a.f16338a.n(1);
        }
    }

    public final void e(Channel channel) {
        i.g(channel, "channel");
        w6.i.c1(w6.i.f9510g.b(), "2", i9.i.b(channel.getChannelCode()), false, 4, (Object) null).compose(p0.b()).subscribe(new C0214a(channel));
    }

    public final void f(String str) {
        i.g(str, "channelCode");
        f16342e.add(str);
    }

    public final boolean g(Channel channel) {
        i.g(channel, "channel");
        return f16340c.contains(channel.getChannelCode());
    }

    public final void h(Channel channel) {
        i.g(channel, "channel");
        if (!f16340c.contains(channel.getChannelCode()) || !f16341d.containsKey(channel.getChannelCode())) {
            xa.c.c().j(new UpdateFavStatusEvent(channel.getChannelCode(), false));
            return;
        }
        Object obj = f16341d.get(channel.getChannelCode());
        i.d(obj);
        w6.i.f9510g.b().o1(new int[]{((Number) obj).intValue()}).compose(p0.b()).subscribe(new b(channel));
    }

    public final ArrayList i() {
        return f16339b;
    }

    public final int j() {
        return f16343f;
    }

    public final void k() {
        f16343f = 1;
    }

    public final boolean l(String str) {
        i.g(str, "channelCode");
        return f16342e.contains(str);
    }

    public final void m() {
        f16343f = 2;
        w6.i.v1(w6.i.f9510g.b(), "live", (String) null, 2, (Object) null).compose(p0.b()).subscribe(new c());
    }

    public final void n(int i10) {
        f16343f = i10;
    }
}
