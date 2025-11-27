package ca;

import kotlinx.coroutines.internal.y;

public abstract class n1 {

    /* renamed from: a  reason: collision with root package name */
    public static final y f11527a = new y("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final y f11528b = new y("COMPLETING_WAITING_CHILDREN");

    /* renamed from: c  reason: collision with root package name */
    public static final y f11529c = new y("COMPLETING_RETRY");

    /* renamed from: d  reason: collision with root package name */
    public static final y f11530d = new y("TOO_LATE_TO_CANCEL");

    /* renamed from: e  reason: collision with root package name */
    public static final y f11531e = new y("SEALED");

    /* renamed from: f  reason: collision with root package name */
    public static final p0 f11532f = new p0(false);

    /* renamed from: g  reason: collision with root package name */
    public static final p0 f11533g = new p0(true);

    public static final Object g(Object obj) {
        if (obj instanceof a1) {
            return new b1((a1) obj);
        }
        return obj;
    }
}
