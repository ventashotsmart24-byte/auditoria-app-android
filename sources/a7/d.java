package a7;

import com.hpplay.cybergarage.upnp.Icon;
import io.jsonwebtoken.Claims;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.ShelvePoster;
import t9.i;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f10697a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final String f10698b = "poster";

    /* renamed from: c  reason: collision with root package name */
    public static final String f10699c = "special_topic";

    /* renamed from: d  reason: collision with root package name */
    public static final String f10700d = "banner";

    /* renamed from: e  reason: collision with root package name */
    public static final String f10701e = Icon.ELEM_NAME;

    /* renamed from: f  reason: collision with root package name */
    public static final String f10702f = "background";

    /* renamed from: g  reason: collision with root package name */
    public static final String f10703g = "stage";

    /* renamed from: h  reason: collision with root package name */
    public static final String f10704h = "special_topic_banner";

    /* renamed from: i  reason: collision with root package name */
    public static final String f10705i = "logo";

    public static final void d(List list, String str, ObservableEmitter observableEmitter) {
        boolean z10;
        i.g(str, "$type");
        i.g(observableEmitter, Claims.SUBJECT);
        if (list == null || list.isEmpty()) {
            observableEmitter.onError(new Exception("图片不存在"));
            return;
        }
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            observableEmitter.onNext(list.get(0));
            observableEmitter.onComplete();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PosterList posterList = (PosterList) it.next();
            if (i.b(str, posterList.getFileType())) {
                observableEmitter.onNext(posterList);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onError(new Exception("图片不存在"));
    }

    public static final void m(List list, String str, ObservableEmitter observableEmitter) {
        boolean z10;
        i.g(str, "$type");
        i.g(observableEmitter, Claims.SUBJECT);
        if (list == null || list.isEmpty()) {
            observableEmitter.onError(new Exception("图片不存在"));
            return;
        }
        if (str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            observableEmitter.onNext(list.get(0));
            observableEmitter.onComplete();
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShelvePoster shelvePoster = (ShelvePoster) it.next();
            if (i.b(str, shelvePoster.getFileType())) {
                observableEmitter.onNext(shelvePoster);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onError(new Exception("图片不存在"));
    }

    public final Observable c(List list, String str) {
        i.g(str, "type");
        Observable create = Observable.create(new c(list, str));
        i.f(create, "create { sub ->\n        …ption(\"图片不存在\"))\n        }");
        return create;
    }

    public final String e() {
        return f10702f;
    }

    public final String f() {
        return f10700d;
    }

    public final String g() {
        return f10701e;
    }

    public final String h() {
        return f10705i;
    }

    public final String i() {
        return f10698b;
    }

    public final String j() {
        return f10704h;
    }

    public final String k() {
        return f10703g;
    }

    public final Observable l(List list, String str) {
        i.g(str, "type");
        Observable create = Observable.create(new b(list, str));
        i.f(create, "create { sub ->\n        …ption(\"图片不存在\"))\n        }");
        return create;
    }

    public final String n(List list, String str) {
        i.g(str, "type");
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PosterList posterList = (PosterList) it.next();
            if (str.equals(posterList.getFileType())) {
                return posterList.getFileUrl();
            }
        }
        return null;
    }

    public final String o(List list, String str) {
        String str2;
        i.g(str, "type");
        if (list == null) {
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ShelvePoster shelvePoster = (ShelvePoster) it.next();
            if (shelvePoster != null) {
                str2 = shelvePoster.getFileType();
            } else {
                str2 = null;
            }
            if (str.equals(str2)) {
                return shelvePoster.getFileUrl();
            }
        }
        return null;
    }
}
