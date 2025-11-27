package anet.channel.fulltrace;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile IFullTraceAnalysis f3715a = new C0062a((IFullTraceAnalysis) null);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3716b = false;

    /* renamed from: anet.channel.fulltrace.a$a  reason: collision with other inner class name */
    public static class C0062a implements IFullTraceAnalysis {

        /* renamed from: a  reason: collision with root package name */
        private IFullTraceAnalysis f3717a;

        public C0062a(IFullTraceAnalysis iFullTraceAnalysis) {
            this.f3717a = iFullTraceAnalysis;
            boolean unused = a.f3716b = true;
        }

        public void commitRequest(String str, RequestStatistic requestStatistic) {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (a.f3716b && (iFullTraceAnalysis = this.f3717a) != null) {
                try {
                    iFullTraceAnalysis.commitRequest(str, requestStatistic);
                } catch (Throwable th) {
                    boolean unused = a.f3716b = false;
                    ALog.e("anet.AnalysisFactory", "fulltrace commit fail.", (String) null, th, new Object[0]);
                }
            }
        }

        public String createRequest() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f3716b || (iFullTraceAnalysis = this.f3717a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.createRequest();
            } catch (Throwable th) {
                boolean unused = a.f3716b = false;
                ALog.e("anet.AnalysisFactory", "createRequest fail.", (String) null, th, new Object[0]);
                return null;
            }
        }

        public b getSceneInfo() {
            IFullTraceAnalysis iFullTraceAnalysis;
            if (!a.f3716b || (iFullTraceAnalysis = this.f3717a) == null) {
                return null;
            }
            try {
                return iFullTraceAnalysis.getSceneInfo();
            } catch (Throwable th) {
                boolean unused = a.f3716b = false;
                ALog.e("anet.AnalysisFactory", "getSceneInfo fail", (String) null, th, new Object[0]);
                return null;
            }
        }
    }

    public static IFullTraceAnalysis a() {
        return f3715a;
    }

    public static void a(IFullTraceAnalysis iFullTraceAnalysis) {
        f3715a = new C0062a(iFullTraceAnalysis);
    }
}
