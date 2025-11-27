package s1;

import com.advertlib.bean.ReportWrapperBean;
import com.advertlib.bean.TimeInfoBean;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ReportWrapperBean f9308a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TimeInfoBean f9309b;

    public /* synthetic */ o(ReportWrapperBean reportWrapperBean, TimeInfoBean timeInfoBean) {
        this.f9308a = reportWrapperBean;
        this.f9309b = timeInfoBean;
    }

    public final void run() {
        q.l(this.f9308a, this.f9309b);
    }
}
