package com.google.common.reflect;

import com.google.common.base.Function;
import com.google.common.reflect.Types;
import java.lang.reflect.Type;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Types.JavaVersion f10114a;

    public /* synthetic */ d(Types.JavaVersion javaVersion) {
        this.f10114a = javaVersion;
    }

    public final Object apply(Object obj) {
        return this.f10114a.typeName((Type) obj);
    }
}
