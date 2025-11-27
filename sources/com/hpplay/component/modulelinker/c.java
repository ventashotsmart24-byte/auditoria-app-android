package com.hpplay.component.modulelinker;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.modulelinker.api.IModuleLinker;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

public class c implements IModuleLinker {

    /* renamed from: a  reason: collision with root package name */
    public static final String f10555a = "ModuleLinkerImp";

    /* renamed from: b  reason: collision with root package name */
    public static final String f10556b = "com.hpplay.component.common.utils";

    /* renamed from: c  reason: collision with root package name */
    private String f10557c = "";

    /* renamed from: d  reason: collision with root package name */
    private LinkedList<String> f10558d = new LinkedList<>();

    public c(boolean z10) {
        if (z10) {
            this.f10557c = String.valueOf(System.currentTimeMillis());
        }
    }

    private void a(String str, Object obj) {
        b a10 = b.a();
        a10.a(this.f10557c + str, obj);
    }

    private Object b(String str) {
        b a10 = b.a();
        return a10.b(this.f10557c + str);
    }

    private JSONArray c() {
        return b.a().f();
    }

    private JSONArray d() {
        return b.a().g();
    }

    public synchronized Object callMethod(String str, Object... objArr) {
        String str2;
        String str3;
        String str4;
        if (b().length() == 0 || TextUtils.isEmpty(str)) {
            throw new Exception(" no marked functions !!!");
        }
        int i10 = 0;
        while (true) {
            if (i10 >= c().length()) {
                str2 = null;
                str3 = null;
                str4 = null;
                break;
            }
            JSONArray jSONArray = new JSONArray(c().get(i10).toString());
            if (jSONArray.optString(0).equals(str)) {
                str2 = jSONArray.optString(1);
                str3 = jSONArray.optString(2);
                str4 = jSONArray.optString(3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str4)) {
            throw new Exception(" the function does not exist  !!!");
        } else if (TextUtils.isEmpty(str3) || !str3.equals("static")) {
            Object loadModule = loadModule(str4);
            if (loadModule != null) {
                return d.a(loadModule, str2, objArr);
            }
            throw new Exception("failed to get module interface");
        } else {
            return d.a(a().get(str4), str2, objArr);
        }
    }

    public String getClassName(String str) {
        return b.a().c(str);
    }

    public Context getContext() {
        return b.a().c();
    }

    public Object getModule(String str) {
        return b.a().b().get(str);
    }

    public Object getParameter(String str) {
        String str2;
        String[] c10 = c(str);
        String str3 = c10[0];
        if (str3 == null || (str2 = c10[1]) == null) {
            return Boolean.FALSE;
        }
        String str4 = c10[2];
        if (str3.equals("static")) {
            return d.a(a().get(str4), str2);
        }
        Object loadModule = loadModule(str4);
        if (loadModule != null) {
            return d.a(loadModule, str2);
        }
        throw new Exception("failed to get module interface");
    }

    public boolean hotFix(String str) {
        return false;
    }

    public synchronized void init(Context context, String... strArr) {
        init(context, (ClassLoader) null, (String) null, (String[]) null, strArr);
    }

    public synchronized Object loadModule(String str) {
        return loadModule(str, null);
    }

    public void putLinkInfo(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            b.a().a(str, str2);
        }
    }

    public void removeObjOfMemory(String str) {
        b(str);
    }

    public boolean setParameter(String str, Object obj) {
        String str2;
        String[] c10 = c(str);
        String str3 = c10[0];
        if (str3 == null || (str2 = c10[1]) == null) {
            return false;
        }
        String str4 = c10[2];
        if (str3.equals("static")) {
            d.a(a().get(str4), str2, obj);
            return true;
        }
        Object loadModule = loadModule(str4);
        if (loadModule != null) {
            d.a(loadModule, str2, obj);
            return true;
        }
        throw new Exception("failed to get module interface");
    }

    private Object a(String str) {
        b a10 = b.a();
        return a10.a(this.f10557c + str);
    }

    private JSONArray b() {
        return b.a().e();
    }

    private String[] c(String str) {
        String str2;
        String str3;
        String str4;
        if (b().length() == 0 || TextUtils.isEmpty(str)) {
            throw new Exception(" no marked functions !!!");
        }
        int i10 = 0;
        while (true) {
            if (i10 >= d().length()) {
                str2 = null;
                str3 = null;
                str4 = null;
                break;
            }
            JSONArray jSONArray = new JSONArray(d().get(i10).toString());
            if (jSONArray.optString(0).equals(str)) {
                str2 = jSONArray.optString(1);
                str3 = jSONArray.optString(2);
                str4 = jSONArray.optString(3);
                break;
            }
            i10++;
        }
        if (!TextUtils.isEmpty(str4)) {
            return new String[]{str3, str2, str4};
        }
        throw new Exception(" the function does not exist  !!!");
    }

    public boolean hotFix(String str, String str2) {
        return false;
    }

    public synchronized Object loadModule(String str, Object... objArr) {
        Object[] objArr2;
        Class[] clsArr;
        Object obj;
        if (a().size() == 0) {
            if (d.c() != null) {
                init(d.c(), new String[0]);
            }
            if (a().size() == 0) {
                throw new Exception(" Modulelinker init failed !!!");
            }
        }
        if (!TextUtils.isEmpty(a().get(str))) {
            if (objArr == null || objArr.length <= 1) {
                clsArr = null;
                objArr2 = null;
            } else {
                clsArr = new Class[(objArr.length / 2)];
                objArr2 = new Object[(objArr.length / 2)];
                for (int i10 = 0; i10 < objArr.length; i10++) {
                    if (i10 % 2 == 0) {
                        if (i10 == 0) {
                            objArr2[0] = objArr[0];
                        } else {
                            objArr2[i10] = objArr[i10 - 1];
                        }
                    } else if (i10 == 1) {
                        clsArr[0] = objArr[i10];
                    } else {
                        clsArr[i10] = objArr[i10 - 2];
                    }
                }
            }
            if (a(str) == null) {
                String str2 = "";
                for (int i11 = 0; i11 < b().length(); i11++) {
                    JSONArray jSONArray = new JSONArray(b().get(i11).toString());
                    if (jSONArray.optString(0).equals(str)) {
                        str2 = jSONArray.optString(1);
                    }
                }
                if (!str2.equals("new")) {
                    obj = d.a(a().get(str), str2, clsArr, objArr2);
                } else {
                    obj = d.a(a().get(str), (Class<?>[]) clsArr, objArr2);
                }
                if (obj != null) {
                    a(str, obj);
                } else {
                    throw new Exception(" the class does not exist !!!");
                }
            }
        } else {
            throw new Exception("This module is not loaded !!!");
        }
        return a(str);
    }

    private Map<String, String> a() {
        return b.a().d();
    }

    public void init(Context context, String[] strArr, String... strArr2) {
        init(context, (ClassLoader) null, (String) null, strArr, strArr2);
    }

    public void init(Context context, ClassLoader classLoader, String[] strArr, String... strArr2) {
        init(context, classLoader, (String) null, strArr, strArr2);
    }

    public void init(Context context, ClassLoader classLoader, String str, String[] strArr, String... strArr2) {
        if (strArr2 != null && strArr2.length > 0) {
            this.f10558d.addAll(Arrays.asList(strArr2));
        }
        if (!this.f10558d.contains(f10556b)) {
            this.f10558d.add(f10556b);
        }
        if (b.a().b() == null || b.a().b().size() == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (classLoader != null) {
                d.a(classLoader);
            }
            b.a().a(context.getApplicationContext(), str, this.f10558d, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(" init time  ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" =====> ");
            sb2.append(a().size());
        }
    }
}
