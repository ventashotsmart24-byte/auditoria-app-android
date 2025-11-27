package q1;

import android.content.Context;
import anet.channel.entity.ENV;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static ENV f8930a = ENV.ONLINE;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicBoolean f8931b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public static Context f8932c;

    /* renamed from: d  reason: collision with root package name */
    public static HashMap f8933d = null;

    public static Context a() {
        return f8932c;
    }
}
