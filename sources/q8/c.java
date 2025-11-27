package q8;

import android.content.SharedPreferences;
import android.os.Build;
import com.titans.entity.RangerPlayTag;
import i8.b;
import java.util.HashMap;
import t9.i;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f19355a = new c();

    /* renamed from: b  reason: collision with root package name */
    public static final String f19356b = "MediaPlayerSwitchUtils";

    /* renamed from: c  reason: collision with root package name */
    public static int f19357c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f19358d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static HashMap f19359e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    public static b f19360f;

    /* renamed from: g  reason: collision with root package name */
    public static SharedPreferences f19361g;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19362a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                i8.b[] r0 = i8.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                i8.b r1 = i8.b.NATIVE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                i8.b r1 = i8.b.IJK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                i8.b r1 = i8.b.EXO     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f19362a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: q8.c.a.<clinit>():void");
        }
    }

    public final b a(String str) {
        i.g(str, "channelCode");
        Integer num = (Integer) f19359e.get(str);
        if (num == null) {
            SharedPreferences sharedPreferences = f19361g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            num = Integer.valueOf(sharedPreferences.getInt("MediaPlayerTypeKey" + str, -1));
            if (num.intValue() == -1) {
                if (Build.VERSION.SDK_INT > 22) {
                    num = 2;
                } else {
                    num = 1;
                }
            }
            f19359e.put(str, num);
        }
        return i(num.intValue());
    }

    public final b b() {
        return f19360f;
    }

    public final b c(String str, String str2) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        if (i.b(str, RangerPlayTag.VOD.getValue())) {
            return e();
        }
        if (i.b(str, RangerPlayTag.RECORD.getValue())) {
            return d();
        }
        return a(str2);
    }

    public final b d() {
        int i10;
        if (f19358d == -1) {
            SharedPreferences sharedPreferences = f19361g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            int i11 = sharedPreferences.getInt("MediaPlayerTypeKey" + RangerPlayTag.RECORD.getValue(), -1);
            f19358d = i11;
            if (i11 == -1) {
                if (Build.VERSION.SDK_INT > 22) {
                    i10 = 2;
                } else {
                    i10 = 1;
                }
                f19358d = i10;
            }
        }
        return i(f19358d);
    }

    public final b e() {
        int i10;
        if (f19357c == -1) {
            SharedPreferences sharedPreferences = f19361g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            int i11 = sharedPreferences.getInt("MediaPlayerTypeKey" + RangerPlayTag.VOD.getValue(), -1);
            f19357c = i11;
            if (i11 == -1) {
                if (Build.VERSION.SDK_INT > 22) {
                    i10 = 2;
                } else {
                    i10 = 1;
                }
                f19357c = i10;
            }
        }
        return i(f19357c);
    }

    public final void f(String str, String str2) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        RangerPlayTag rangerPlayTag = RangerPlayTag.VOD;
        SharedPreferences sharedPreferences = null;
        if (i.b(str, rangerPlayTag.getValue())) {
            SharedPreferences sharedPreferences2 = f19361g;
            if (sharedPreferences2 == null) {
                i.w("mSp");
            } else {
                sharedPreferences = sharedPreferences2;
            }
            sharedPreferences.edit().putInt("MediaPlayerTypeKey" + rangerPlayTag.getValue(), f19357c).apply();
            return;
        }
        RangerPlayTag rangerPlayTag2 = RangerPlayTag.RECORD;
        if (i.b(str, rangerPlayTag2.getValue())) {
            SharedPreferences sharedPreferences3 = f19361g;
            if (sharedPreferences3 == null) {
                i.w("mSp");
            } else {
                sharedPreferences = sharedPreferences3;
            }
            sharedPreferences.edit().putInt("MediaPlayerTypeKey" + rangerPlayTag2.getValue(), f19358d).apply();
            return;
        }
        SharedPreferences sharedPreferences4 = f19361g;
        if (sharedPreferences4 == null) {
            i.w("mSp");
        } else {
            sharedPreferences = sharedPreferences4;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str3 = "MediaPlayerTypeKey" + str2;
        Integer num = (Integer) f19359e.get(str2);
        if (num == null) {
            num = -1;
        }
        edit.putInt(str3, num.intValue()).apply();
    }

    public final void g(b bVar) {
        f19360f = bVar;
    }

    public final void h(String str, String str2, b bVar) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        i.g(bVar, "playerType");
        if (i.b(str, RangerPlayTag.VOD.getValue())) {
            f19357c = j(bVar);
        } else if (i.b(str, RangerPlayTag.RECORD.getValue())) {
            f19358d = j(bVar);
        } else {
            f19359e.put(str2, Integer.valueOf(j(bVar)));
        }
    }

    public final b i(int i10) {
        if (i10 == 1) {
            return b.NATIVE;
        }
        if (i10 == 2) {
            return b.IJK;
        }
        if (i10 != 3) {
            return b.IJK;
        }
        return b.EXO;
    }

    public final int j(b bVar) {
        int i10 = a.f19362a[bVar.ordinal()];
        if (i10 == 1) {
            return 1;
        }
        if (i10 == 2 || i10 != 3) {
            return 2;
        }
        return 3;
    }
}
