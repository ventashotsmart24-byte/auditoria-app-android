package org.simpleframework.xml.core;

import java.lang.reflect.Method;
import java.util.Map;

class Function {
    private final boolean contextual;
    private final Method method;

    public Function(Method method2) {
        this(method2, false);
    }

    public Object call(Context context, Object obj) {
        if (obj == null) {
            return null;
        }
        Map map = context.getSession().getMap();
        if (!this.contextual) {
            return this.method.invoke(obj, new Object[0]);
        }
        return this.method.invoke(obj, new Object[]{map});
    }

    public Function(Method method2, boolean z10) {
        this.contextual = z10;
        this.method = method2;
    }
}
