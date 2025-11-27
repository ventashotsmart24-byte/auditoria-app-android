package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.dcs.bean.DomainInfo;
import com.google.gson.Gson;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import java.util.Locale;
import k7.f;

public abstract class CheckNoticeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static DomainInfo f12489a;

    public class NoteInfo {
        private long duration;
        private String info;
        private List<NoteInner> inner;
        private int showModel = 1;
        private String status;
        final /* synthetic */ CheckNoticeUtils this$0;

        public NoteInfo(CheckNoticeUtils checkNoticeUtils) {
        }

        public long getDuration() {
            return this.duration;
        }

        public String getInfo() {
            return this.info;
        }

        public List<NoteInner> getInner() {
            return this.inner;
        }

        public int getShowModel() {
            return this.showModel;
        }

        public String getStatus() {
            return this.status;
        }

        public void setDuration(long j10) {
            this.duration = j10;
        }

        public void setInfo(String str) {
            this.info = str;
        }

        public void setInner(List<NoteInner> list) {
            this.inner = list;
        }

        public void setShowModel(int i10) {
            this.showModel = i10;
        }

        public void setStatus(String str) {
            this.status = str;
        }

        public String toString() {
            return "NoteInfo{status='" + this.status + '\'' + ", info='" + this.info + '\'' + ", duration=" + this.duration + ", inner=" + this.inner + ", showModel=" + this.showModel + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }
    }

    public class NoteInner {
        private List<String> channels;
        private long duration;
        private String info;
        final /* synthetic */ CheckNoticeUtils this$0;

        public NoteInner(CheckNoticeUtils checkNoticeUtils) {
        }

        public List<String> getChannels() {
            return this.channels;
        }

        public long getDuration() {
            return this.duration;
        }

        public String getInfo() {
            return this.info;
        }

        public void setChannels(List<String> list) {
            this.channels = list;
        }

        public void setDuration(long j10) {
            this.duration = j10;
        }

        public void setInfo(String str) {
            this.info = str;
        }
    }

    public class a implements Predicate {
        /* renamed from: a */
        public boolean test(NoteInfo noteInfo) {
            if (noteInfo == null) {
                return false;
            }
            return "1".equals(noteInfo.getStatus());
        }
    }

    public class b implements Function {
        /* renamed from: a */
        public NoteInfo apply(String str) {
            Gson gson = new Gson();
            f.b("noteInfo:" + str);
            return (NoteInfo) gson.fromJson(str, NoteInfo.class);
        }
    }

    public class c implements Function {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f12490a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f12491b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f12492c;

        public c(Context context, String str, String str2) {
            this.f12490a = context;
            this.f12491b = str;
            this.f12492c = str2;
        }

        /* renamed from: a */
        public String apply(String str) {
            String a10 = c7.a.a(CheckNoticeUtils.c(this.f12490a, this.f12491b, this.f12492c, CheckNoticeUtils.f12489a.getFirst()));
            if (TextUtils.isEmpty(a10)) {
                a10 = c7.a.a(CheckNoticeUtils.c(this.f12490a, this.f12491b, this.f12492c, CheckNoticeUtils.f12489a.getSecond()));
            }
            if (a10 == null) {
                t2.a.f9350a.q(CheckNoticeUtils.f12489a, "key_notice");
            }
            return a10;
        }
    }

    public static Observable b(Context context, String str, String str2) {
        f12489a = t2.a.f9350a.b(m7.c.h().first.toString(), m7.c.h().second.toString(), "key_notice");
        return Observable.just("start get notice...").map(new c(context, str, str2)).map(new b()).filter(new a()).compose(p0.b());
    }

    public static String c(Context context, String str, String str2, String str3) {
        String language = Locale.getDefault().getLanguage();
        return String.format(Locale.US, "http://%s/notice/api/get_notice?pkg=%s&v=%s&language=%s&sn=%s&userId=%s", new Object[]{str3, context.getPackageName(), e.a(context), language, str, str2});
    }
}
