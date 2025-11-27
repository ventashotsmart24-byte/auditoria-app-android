package r3;

import c4.n;
import c4.o;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Objects;
import k3.j;
import r3.f0;

public abstract class z {
    public static n a(Method method, j jVar, f0 f0Var) {
        j k10;
        TypeVariable b10;
        TypeVariable[] typeParameters = method.getTypeParameters();
        if (typeParameters.length == 0 || jVar.j().n()) {
            return null;
        }
        Type genericReturnType = method.getGenericReturnType();
        if (!(genericReturnType instanceof ParameterizedType)) {
            return null;
        }
        ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
        if (!Objects.equals(jVar.q(), parameterizedType.getRawType())) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        ArrayList arrayList = new ArrayList(typeParameters.length);
        ArrayList arrayList2 = new ArrayList(typeParameters.length);
        for (int i10 = 0; i10 < actualTypeArguments.length; i10++) {
            TypeVariable d10 = d(actualTypeArguments[i10]);
            if (d10 != null) {
                String name = d10.getName();
                if (name == null || (k10 = jVar.j().k(i10)) == null || (b10 = b(typeParameters, name)) == null) {
                    return null;
                }
                if (!g(f0Var, k10, b10.getBounds())) {
                    continue;
                } else {
                    int indexOf = arrayList.indexOf(name);
                    if (indexOf != -1) {
                        j jVar2 = (j) arrayList2.get(indexOf);
                        if (k10.equals(jVar2)) {
                            continue;
                        } else {
                            boolean N = jVar2.N(k10.q());
                            boolean N2 = k10.N(jVar2.q());
                            if (!N && !N2) {
                                return null;
                            }
                            if ((N ^ N2) && N2) {
                                arrayList2.set(indexOf, k10);
                            }
                        }
                    } else {
                        arrayList.add(name);
                        arrayList2.add(k10);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return n.f(arrayList, arrayList2);
    }

    public static TypeVariable b(TypeVariable[] typeVariableArr, String str) {
        if (!(typeVariableArr == null || str == null)) {
            for (TypeVariable typeVariable : typeVariableArr) {
                if (str.equals(typeVariable.getName())) {
                    return typeVariable;
                }
            }
        }
        return null;
    }

    public static ParameterizedType c(Type type) {
        if (type instanceof ParameterizedType) {
            return (ParameterizedType) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return c(upperBounds[0]);
            }
        }
        return null;
    }

    public static TypeVariable d(Type type) {
        if (type instanceof TypeVariable) {
            return (TypeVariable) type;
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return null;
            }
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length == 1) {
                return d(upperBounds[0]);
            }
        }
        return null;
    }

    public static f0 e(Method method, j jVar, o oVar, f0 f0Var) {
        n a10 = a(method, jVar, f0Var);
        if (a10 == null) {
            return f0Var;
        }
        return new f0.a(oVar, a10);
    }

    public static boolean f(f0 f0Var, j jVar, Type type) {
        if (!jVar.N(f0Var.a(type).q())) {
            return false;
        }
        ParameterizedType c10 = c(type);
        if (c10 == null || !Objects.equals(jVar.q(), c10.getRawType())) {
            return true;
        }
        Type[] actualTypeArguments = c10.getActualTypeArguments();
        n j10 = jVar.j();
        if (j10.o() != actualTypeArguments.length) {
            return false;
        }
        for (int i10 = 0; i10 < j10.o(); i10++) {
            if (!f(f0Var, j10.k(i10), actualTypeArguments[i10])) {
                return false;
            }
        }
        return true;
    }

    public static boolean g(f0 f0Var, j jVar, Type[] typeArr) {
        for (Type f10 : typeArr) {
            if (!f(f0Var, jVar, f10)) {
                return false;
            }
        }
        return true;
    }
}
