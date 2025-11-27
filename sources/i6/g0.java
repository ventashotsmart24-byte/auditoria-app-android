package i6;

import com.mobile.brasiltv.bean.AudioTrackBean;
import com.titan.ranger.bean.Program;
import java.util.HashMap;
import java.util.List;
import mobile.com.requestframe.utils.response.AssetData;

public interface g0 extends m5.a {

    /* renamed from: b0  reason: collision with root package name */
    public static final a f17324b0 = a.f17325a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f17325a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final String f17326b = "TDC_From";

        /* renamed from: c  reason: collision with root package name */
        public static final String f17327c = "type";

        /* renamed from: d  reason: collision with root package name */
        public static final String f17328d = "programType";

        /* renamed from: e  reason: collision with root package name */
        public static final String f17329e = "contentId";

        /* renamed from: f  reason: collision with root package name */
        public static final String f17330f = "entryType";

        /* renamed from: g  reason: collision with root package name */
        public static final String f17331g = "topicName";

        /* renamed from: h  reason: collision with root package name */
        public static final String f17332h = "topicImage";

        /* renamed from: i  reason: collision with root package name */
        public static final String f17333i = "isCr";

        /* renamed from: j  reason: collision with root package name */
        public static final String f17334j = "isFree";

        /* renamed from: k  reason: collision with root package name */
        public static final String f17335k = "parentColumnId";

        /* renamed from: l  reason: collision with root package name */
        public static final String f17336l = "is_cast";

        public final String a() {
            return f17329e;
        }

        public final String b() {
            return f17330f;
        }

        public final String c() {
            return f17333i;
        }

        public final String d() {
            return f17334j;
        }

        public final String e() {
            return f17335k;
        }

        public final String f() {
            return f17328d;
        }

        public final String g() {
            return f17326b;
        }

        public final String h() {
            return f17332h;
        }

        public final String i() {
            return f17331g;
        }

        public final String j() {
            return f17327c;
        }

        public final String k() {
            return f17336l;
        }
    }

    public static final class b {
        public static /* synthetic */ void a(g0 g0Var, String str, boolean z10, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    str = "-10000";
                }
                if ((i10 & 2) != 0) {
                    z10 = false;
                }
                g0Var.E0(str, z10);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showErrorInWindow");
        }

        public static /* synthetic */ void b(g0 g0Var, String str, int i10, Object obj) {
            if (obj == null) {
                if ((i10 & 1) != 0) {
                    str = "-10000";
                }
                g0Var.y0(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadError");
        }
    }

    void D1();

    void D2(HashMap hashMap, AudioTrackBean audioTrackBean);

    void E0(String str, boolean z10);

    void G1(List list);

    void G2();

    void I0(List list);

    void N0(AssetData assetData);

    void T1(String str, Program program);

    void W0(AssetData assetData);

    void d0(AssetData assetData);

    void d2();

    void f0(AssetData assetData);

    void g0(boolean z10);

    void i0();

    void u1(boolean z10);

    void w2();

    void y0(String str);

    long z1();
}
