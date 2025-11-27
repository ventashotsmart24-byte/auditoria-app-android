package i2;

import android.content.Context;
import android.content.SharedPreferences;
import h9.h;
import t9.g;
import t9.i;
import t9.j;

public final class e {

    /* renamed from: b  reason: collision with root package name */
    public static final b f7014b = new b((g) null);

    /* renamed from: c  reason: collision with root package name */
    public static final h9.g f7015c = h.b(a.f7017a);

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f7016a;

    public static final class a extends j implements s9.a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f7017a = new a();

        public a() {
            super(0);
        }

        /* renamed from: b */
        public final e invoke() {
            return new e("bbconfig", (g) null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final e a() {
            return (e) e.f7015c.getValue();
        }
    }

    public /* synthetic */ e(String str, g gVar) {
        this(str);
    }

    public final Object b(String str, Object obj) {
        i.g(str, "key");
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f7016a.getInt(str, ((Number) obj).intValue()));
        }
        if (obj instanceof String) {
            return this.f7016a.getString(str, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f7016a.getFloat(str, ((Number) obj).floatValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f7016a.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f7016a.getLong(str, ((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("不支持该类型的数据");
    }

    public final void c(String str, Object obj) {
        i.g(str, "key");
        SharedPreferences.Editor edit = this.f7016a.edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Number) obj).longValue());
        } else {
            throw new IllegalArgumentException("不支持该类型的数据");
        }
        edit.apply();
    }

    public e(String str) {
        Context j10 = c2.i.f4633q.a().j();
        i.d(j10);
        SharedPreferences sharedPreferences = j10.getSharedPreferences(str, 0);
        i.f(sharedPreferences, "BigBee.mInstance.mContex…me, Context.MODE_PRIVATE)");
        this.f7016a = sharedPreferences;
    }
}
