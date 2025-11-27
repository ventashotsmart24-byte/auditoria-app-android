package n0;

import android.content.IntentFilter;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.sdk.source.common.global.Constant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f7953a;

    /* renamed from: b  reason: collision with root package name */
    public List f7954b;

    /* renamed from: c  reason: collision with root package name */
    public List f7955c;

    public n0(Bundle bundle) {
        this.f7953a = bundle;
    }

    public static n0 d(Bundle bundle) {
        if (bundle != null) {
            return new n0(bundle);
        }
        return null;
    }

    public boolean a() {
        return this.f7953a.getBoolean("canDisconnect", false);
    }

    public void b() {
        if (this.f7955c == null) {
            ArrayList parcelableArrayList = this.f7953a.getParcelableArrayList("controlFilters");
            this.f7955c = parcelableArrayList;
            if (parcelableArrayList == null) {
                this.f7955c = Collections.emptyList();
            }
        }
    }

    public void c() {
        if (this.f7954b == null) {
            ArrayList<String> stringArrayList = this.f7953a.getStringArrayList("groupMemberIds");
            this.f7954b = stringArrayList;
            if (stringArrayList == null) {
                this.f7954b = Collections.emptyList();
            }
        }
    }

    public int e() {
        return this.f7953a.getInt("connectionState", 0);
    }

    public List f() {
        b();
        return this.f7955c;
    }

    public String g() {
        return this.f7953a.getString(Constant.KEY_STATUS);
    }

    public int h() {
        return this.f7953a.getInt("deviceType");
    }

    public Bundle i() {
        return this.f7953a.getBundle("extras");
    }

    public List j() {
        c();
        return this.f7954b;
    }

    public Uri k() {
        String string = this.f7953a.getString("iconUri");
        if (string == null) {
            return null;
        }
        return Uri.parse(string);
    }

    public String l() {
        return this.f7953a.getString("id");
    }

    public int m() {
        return this.f7953a.getInt("maxClientVersion", Integer.MAX_VALUE);
    }

    public int n() {
        return this.f7953a.getInt("minClientVersion", 1);
    }

    public String o() {
        return this.f7953a.getString("name");
    }

    public int p() {
        return this.f7953a.getInt("playbackStream", -1);
    }

    public int q() {
        return this.f7953a.getInt("playbackType", 1);
    }

    public int r() {
        return this.f7953a.getInt("presentationDisplayId", -1);
    }

    public IntentSender s() {
        return (IntentSender) this.f7953a.getParcelable("settingsIntent");
    }

    public int t() {
        return this.f7953a.getInt(PlistBuilder.VALUE_TYPE_VOLUME);
    }

    public String toString() {
        return "MediaRouteDescriptor{ " + "id=" + l() + ", groupMemberIds=" + j() + ", name=" + o() + ", description=" + g() + ", iconUri=" + k() + ", isEnabled=" + w() + ", connectionState=" + e() + ", controlFilters=" + Arrays.toString(f().toArray()) + ", playbackType=" + q() + ", playbackStream=" + p() + ", deviceType=" + h() + ", volume=" + t() + ", volumeMax=" + v() + ", volumeHandling=" + u() + ", presentationDisplayId=" + r() + ", extras=" + i() + ", isValid=" + x() + ", minClientVersion=" + n() + ", maxClientVersion=" + m() + " }";
    }

    public int u() {
        return this.f7953a.getInt("volumeHandling", 0);
    }

    public int v() {
        return this.f7953a.getInt("volumeMax");
    }

    public boolean w() {
        return this.f7953a.getBoolean("enabled", true);
    }

    public boolean x() {
        b();
        if (TextUtils.isEmpty(l()) || TextUtils.isEmpty(o()) || this.f7955c.contains((Object) null)) {
            return false;
        }
        return true;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f7956a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList f7957b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList f7958c;

        public a(String str, String str2) {
            this.f7956a = new Bundle();
            m(str);
            n(str2);
        }

        public a a(IntentFilter intentFilter) {
            if (intentFilter != null) {
                if (this.f7958c == null) {
                    this.f7958c = new ArrayList();
                }
                if (!this.f7958c.contains(intentFilter)) {
                    this.f7958c.add(intentFilter);
                }
                return this;
            }
            throw new IllegalArgumentException("filter must not be null");
        }

        public a b(Collection collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        a((IntentFilter) it.next());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("filters must not be null");
        }

        public a c(String str) {
            if (!TextUtils.isEmpty(str)) {
                if (this.f7957b == null) {
                    this.f7957b = new ArrayList();
                }
                if (!this.f7957b.contains(str)) {
                    this.f7957b.add(str);
                }
                return this;
            }
            throw new IllegalArgumentException("groupMemberId must not be empty");
        }

        public a d(Collection collection) {
            if (collection != null) {
                if (!collection.isEmpty()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        c((String) it.next());
                    }
                }
                return this;
            }
            throw new IllegalArgumentException("groupMemberIds must not be null");
        }

        public n0 e() {
            ArrayList arrayList = this.f7958c;
            if (arrayList != null) {
                this.f7956a.putParcelableArrayList("controlFilters", arrayList);
            }
            ArrayList arrayList2 = this.f7957b;
            if (arrayList2 != null) {
                this.f7956a.putStringArrayList("groupMemberIds", arrayList2);
            }
            return new n0(this.f7956a);
        }

        public a f(boolean z10) {
            this.f7956a.putBoolean("canDisconnect", z10);
            return this;
        }

        public a g(int i10) {
            this.f7956a.putInt("connectionState", i10);
            return this;
        }

        public a h(String str) {
            this.f7956a.putString(Constant.KEY_STATUS, str);
            return this;
        }

        public a i(int i10) {
            this.f7956a.putInt("deviceType", i10);
            return this;
        }

        public a j(boolean z10) {
            this.f7956a.putBoolean("enabled", z10);
            return this;
        }

        public a k(Bundle bundle) {
            this.f7956a.putBundle("extras", bundle);
            return this;
        }

        public a l(Uri uri) {
            if (uri != null) {
                this.f7956a.putString("iconUri", uri.toString());
                return this;
            }
            throw new IllegalArgumentException("iconUri must not be null");
        }

        public a m(String str) {
            this.f7956a.putString("id", str);
            return this;
        }

        public a n(String str) {
            this.f7956a.putString("name", str);
            return this;
        }

        public a o(int i10) {
            this.f7956a.putInt("playbackStream", i10);
            return this;
        }

        public a p(int i10) {
            this.f7956a.putInt("playbackType", i10);
            return this;
        }

        public a q(int i10) {
            this.f7956a.putInt("presentationDisplayId", i10);
            return this;
        }

        public a r(int i10) {
            this.f7956a.putInt(PlistBuilder.VALUE_TYPE_VOLUME, i10);
            return this;
        }

        public a s(int i10) {
            this.f7956a.putInt("volumeHandling", i10);
            return this;
        }

        public a t(int i10) {
            this.f7956a.putInt("volumeMax", i10);
            return this;
        }

        public a(n0 n0Var) {
            if (n0Var != null) {
                this.f7956a = new Bundle(n0Var.f7953a);
                if (!n0Var.j().isEmpty()) {
                    this.f7957b = new ArrayList(n0Var.j());
                }
                if (!n0Var.f().isEmpty()) {
                    this.f7958c = new ArrayList(n0Var.f7955c);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("descriptor must not be null");
        }
    }
}
