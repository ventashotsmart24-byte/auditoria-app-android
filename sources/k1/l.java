package k1;

import androidx.work.WorkerParameters;
import b1.j;

public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public j f7249a;

    /* renamed from: b  reason: collision with root package name */
    public String f7250b;

    /* renamed from: c  reason: collision with root package name */
    public WorkerParameters.a f7251c;

    public l(j jVar, String str, WorkerParameters.a aVar) {
        this.f7249a = jVar;
        this.f7250b = str;
        this.f7251c = aVar;
    }

    public void run() {
        this.f7249a.l().k(this.f7250b, this.f7251c);
    }
}
