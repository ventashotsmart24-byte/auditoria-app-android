package ua;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import wa.b;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public String f19646a;

    /* renamed from: b  reason: collision with root package name */
    public String f19647b;

    /* renamed from: c  reason: collision with root package name */
    public String f19648c;

    /* renamed from: d  reason: collision with root package name */
    public Class f19649d;

    /* renamed from: e  reason: collision with root package name */
    public Field f19650e;

    /* renamed from: f  reason: collision with root package name */
    public Method f19651f;

    /* renamed from: g  reason: collision with root package name */
    public Method f19652g;

    public String a() {
        return this.f19647b;
    }

    public Class b() {
        return this.f19649d;
    }

    public String c() {
        return this.f19648c;
    }

    public Object d(Object obj) {
        Method method;
        if (obj == null || (method = this.f19651f) == null) {
            return null;
        }
        try {
            return method.invoke(obj, new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void e(String str) {
        this.f19647b = str;
    }

    public void f(Class cls) {
        this.f19649d = cls;
    }

    public void g(String str) {
        this.f19648c = str;
    }

    public void h(Field field) {
        this.f19650e = field;
    }

    public void i(String str) {
        this.f19646a = str;
    }

    public void j(Method method) {
        this.f19651f = method;
    }

    public void k(Method method) {
        this.f19652g = method;
    }

    public void l(Object obj, Object obj2) {
        Method method = this.f19652g;
        if (method == null || obj2 == null) {
            try {
                this.f19650e.setAccessible(true);
                this.f19650e.set(obj, obj2);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        } else {
            try {
                Class<Boolean> cls = this.f19649d;
                if (cls == String.class) {
                    method.invoke(obj, new Object[]{obj2.toString()});
                    return;
                }
                if (cls != Integer.TYPE) {
                    if (cls != Integer.class) {
                        if (cls != Float.TYPE) {
                            if (cls != Float.class) {
                                if (cls != Double.TYPE) {
                                    if (cls != Double.class) {
                                        if (cls != Long.TYPE) {
                                            if (cls != Long.class) {
                                                if (cls != Date.class) {
                                                    if (cls != java.sql.Date.class) {
                                                        if (cls != Boolean.TYPE) {
                                                            if (cls != Boolean.class) {
                                                                method.invoke(obj, new Object[]{obj2});
                                                                return;
                                                            }
                                                        }
                                                        method.invoke(obj, new Object[]{Boolean.valueOf("1".equals(obj2.toString()))});
                                                        return;
                                                    }
                                                }
                                                method.invoke(obj, new Object[]{b.m(obj2.toString())});
                                                return;
                                            }
                                        }
                                        method.invoke(obj, new Object[]{Long.valueOf(Long.parseLong(obj2.toString()))});
                                        return;
                                    }
                                }
                                method.invoke(obj, new Object[]{Double.valueOf(Double.parseDouble(obj2.toString()))});
                                return;
                            }
                        }
                        method.invoke(obj, new Object[]{Float.valueOf(Float.parseFloat(obj2.toString()))});
                        return;
                    }
                }
                method.invoke(obj, new Object[]{Integer.valueOf(Integer.parseInt(obj2.toString()))});
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
