package i3;

import c3.n;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public Object f7030a;

    /* renamed from: b  reason: collision with root package name */
    public Class f7031b;

    /* renamed from: c  reason: collision with root package name */
    public Object f7032c;

    /* renamed from: d  reason: collision with root package name */
    public String f7033d;

    /* renamed from: e  reason: collision with root package name */
    public a f7034e;

    /* renamed from: f  reason: collision with root package name */
    public n f7035f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f7036g;

    public enum a {
        WRAPPER_ARRAY,
        WRAPPER_OBJECT,
        METADATA_PROPERTY,
        PAYLOAD_PROPERTY,
        PARENT_PROPERTY;

        public boolean a() {
            if (this == METADATA_PROPERTY || this == PAYLOAD_PROPERTY) {
                return true;
            }
            return false;
        }
    }

    public b(Object obj, n nVar) {
        this(obj, nVar, (Object) null);
    }

    public b(Object obj, n nVar, Object obj2) {
        this.f7030a = obj;
        this.f7032c = obj2;
        this.f7035f = nVar;
    }
}
