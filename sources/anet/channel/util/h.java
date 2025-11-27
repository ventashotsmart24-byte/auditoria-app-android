package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import io.jsonwebtoken.Header;
import java.util.HashMap;
import java.util.Map;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, Integer> f4023a;

    static {
        HashMap hashMap = new HashMap();
        f4023a = hashMap;
        hashMap.put("tpatch", 3);
        f4023a.put("so", 3);
        f4023a.put("json", 3);
        f4023a.put("html", 4);
        f4023a.put("htm", 4);
        f4023a.put("css", 5);
        f4023a.put("js", 5);
        f4023a.put("webp", 6);
        f4023a.put("png", 6);
        f4023a.put("jpg", 6);
        f4023a.put("do", 6);
        f4023a.put(Header.COMPRESSION_ALGORITHM, Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f4023a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f4023a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    public static int a(Request request) {
        Integer num;
        if (request == null) {
            throw new NullPointerException("url is null!");
        } else if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
            return 1;
        } else {
            String trySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
            if (trySolveFileExtFromUrlPath == null || (num = f4023a.get(trySolveFileExtFromUrlPath)) == null) {
                return 6;
            }
            return num.intValue();
        }
    }
}
