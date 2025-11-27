package v2;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

public abstract class a implements Observer {
    public final void a(Throwable th) {
        try {
            th.printStackTrace();
        } catch (Throwable unused) {
        }
    }

    public abstract void b(String str);

    public void onComplete() {
    }

    public void onError(Throwable th) {
        if (th instanceof TimeoutException) {
            b("50010");
        } else if (th instanceof ConnectException) {
            b("50011");
        } else if (th instanceof SocketTimeoutException) {
            b("50012");
        } else if (th instanceof HttpException) {
            b(((HttpException) th).code() + "");
        } else if (th instanceof UnknownHostException) {
            b("50014");
        } else {
            a(th);
            try {
                th.printStackTrace();
            } catch (Throwable unused) {
            }
        }
    }

    public void onSubscribe(Disposable disposable) {
    }
}
