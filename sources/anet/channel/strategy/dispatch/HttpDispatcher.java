package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpDispatcher {

    /* renamed from: a  reason: collision with root package name */
    private CopyOnWriteArraySet<IDispatchEventListener> f3921a;

    /* renamed from: b  reason: collision with root package name */
    private a f3922b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3923c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f3924d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f3925e;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f3926f;

    public interface IDispatchEventListener {
        void onEvent(DispatchEvent dispatchEvent);
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        static HttpDispatcher f3927a = new HttpDispatcher();

        private a() {
        }
    }

    public static HttpDispatcher getInstance() {
        return a.f3927a;
    }

    public static void setInitHosts(List<String> list) {
        if (list != null) {
            DispatchConstants.initHostArray = (String[]) list.toArray(new String[0]);
        }
    }

    public void a(DispatchEvent dispatchEvent) {
        Iterator<IDispatchEventListener> it = this.f3921a.iterator();
        while (it.hasNext()) {
            try {
                it.next().onEvent(dispatchEvent);
            } catch (Exception unused) {
            }
        }
    }

    public synchronized void addHosts(List<String> list) {
        if (list != null) {
            this.f3925e.addAll(list);
            this.f3924d.clear();
        }
    }

    public void addListener(IDispatchEventListener iDispatchEventListener) {
        this.f3921a.add(iDispatchEventListener);
    }

    public synchronized Set<String> getInitHosts() {
        a();
        return new HashSet(this.f3925e);
    }

    public boolean isInitHostsChanged(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean contains = this.f3924d.contains(str);
        if (!contains) {
            this.f3924d.add(str);
        }
        return !contains;
    }

    public void removeListener(IDispatchEventListener iDispatchEventListener) {
        this.f3921a.remove(iDispatchEventListener);
    }

    public void sendAmdcRequest(Set<String> set, int i10) {
        if (!this.f3923c || set == null || set.isEmpty()) {
            ALog.e("awcn.HttpDispatcher", "invalid parameter", (String) null, new Object[0]);
            return;
        }
        if (ALog.isPrintLog(2)) {
            ALog.i("awcn.HttpDispatcher", "sendAmdcRequest", (String) null, DispatchConstants.HOSTS, set.toString());
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DispatchConstants.HOSTS, set);
        hashMap.put(DispatchConstants.CONFIG_VERSION, String.valueOf(i10));
        this.f3922b.a((Map<String, Object>) hashMap);
    }

    public void setEnable(boolean z10) {
        this.f3923c = z10;
    }

    public void switchENV() {
        this.f3924d.clear();
        this.f3925e.clear();
        this.f3926f.set(false);
    }

    private HttpDispatcher() {
        this.f3921a = new CopyOnWriteArraySet<>();
        this.f3922b = new a();
        this.f3923c = true;
        this.f3924d = Collections.newSetFromMap(new ConcurrentHashMap());
        this.f3925e = new TreeSet();
        this.f3926f = new AtomicBoolean();
        a();
    }

    private void a() {
        if (!this.f3926f.get() && GlobalAppRuntimeInfo.getContext() != null && this.f3926f.compareAndSet(false, true)) {
            this.f3925e.add(DispatchConstants.getAmdcServerDomain());
            if (GlobalAppRuntimeInfo.isTargetProcess()) {
                this.f3925e.addAll(Arrays.asList(DispatchConstants.initHostArray));
            }
        }
    }
}
