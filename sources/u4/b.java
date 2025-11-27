package u4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Handler f19618a = new a(Looper.getMainLooper());

    /* renamed from: b  reason: collision with root package name */
    public final x4.b f19619b;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            y4.a aVar = (y4.a) message.obj;
            switch (aVar.k()) {
                case 1:
                    if (aVar.d() != null) {
                        aVar.d().onStart();
                        return;
                    }
                    return;
                case 2:
                    if (aVar.d() != null) {
                        aVar.d().d(aVar.i(), aVar.j());
                        return;
                    }
                    return;
                case 3:
                    if (aVar.d() != null) {
                        aVar.d().c();
                        return;
                    }
                    return;
                case 4:
                    if (aVar.d() != null) {
                        aVar.d().a();
                        return;
                    }
                    return;
                case 5:
                    if (aVar.d() != null) {
                        aVar.d().b();
                        return;
                    }
                    return;
                case 6:
                    if (aVar.d() != null) {
                        aVar.d().e(aVar.f());
                        return;
                    }
                    return;
                case 7:
                    if (aVar.d() != null) {
                        aVar.d().f();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public b(x4.b bVar) {
        this.f19619b = bVar;
    }

    public void a(y4.a aVar) {
        if (aVar.k() != 7) {
            this.f19619b.e(aVar);
            if (aVar.e() != null) {
                for (y4.b f10 : aVar.e()) {
                    this.f19619b.f(f10);
                }
            }
        }
        Message obtainMessage = this.f19618a.obtainMessage(aVar.g().hashCode());
        obtainMessage.obj = aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.f19618a.handleMessage(obtainMessage);
        } else {
            obtainMessage.sendToTarget();
        }
    }

    public void b(y4.a aVar, z4.a aVar2) {
        if (aVar2.a() != 7) {
            aVar.C(6);
            aVar.x(aVar2);
            a(aVar);
        }
    }
}
