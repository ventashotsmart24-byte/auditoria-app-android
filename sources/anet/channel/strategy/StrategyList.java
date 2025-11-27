package anet.channel.strategy;

import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.taobao.accs.common.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

class StrategyList implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private List<IPConnStrategy> f3901a = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Map<Integer, ConnHistoryItem> f3902b = new SerialLruCache(40);

    /* renamed from: c  reason: collision with root package name */
    private boolean f3903c = false;

    /* renamed from: d  reason: collision with root package name */
    private transient Comparator<IPConnStrategy> f3904d = null;

    public interface Predicate<T> {
        boolean apply(T t10);
    }

    public StrategyList() {
    }

    public void checkInit() {
        if (this.f3901a == null) {
            this.f3901a = new ArrayList();
        }
        if (this.f3902b == null) {
            this.f3902b = new SerialLruCache(40);
        }
        Iterator<Map.Entry<Integer, ConnHistoryItem>> it = this.f3902b.entrySet().iterator();
        while (it.hasNext()) {
            if (((ConnHistoryItem) it.next().getValue()).d()) {
                it.remove();
            }
        }
        for (IPConnStrategy next : this.f3901a) {
            if (!this.f3902b.containsKey(Integer.valueOf(next.getUniqueId()))) {
                this.f3902b.put(Integer.valueOf(next.getUniqueId()), new ConnHistoryItem());
            }
        }
        Collections.sort(this.f3901a, a());
    }

    public List<IConnStrategy> getStrategyList() {
        if (this.f3901a.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        LinkedList linkedList = null;
        for (IPConnStrategy next : this.f3901a) {
            ConnHistoryItem connHistoryItem = this.f3902b.get(Integer.valueOf(next.getUniqueId()));
            if (connHistoryItem == null || !connHistoryItem.c()) {
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(next);
            } else {
                ALog.i("awcn.StrategyList", "strategy ban!", (String) null, Constants.KEY_STRATEGY, next);
            }
        }
        if (linkedList == null) {
            return Collections.EMPTY_LIST;
        }
        return linkedList;
    }

    public void notifyConnEvent(IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if ((iConnStrategy instanceof IPConnStrategy) && this.f3901a.indexOf(iConnStrategy) != -1) {
            this.f3902b.get(Integer.valueOf(((IPConnStrategy) iConnStrategy).getUniqueId())).a(connEvent.isSuccess);
            Collections.sort(this.f3901a, this.f3904d);
        }
    }

    public boolean shouldRefresh() {
        boolean z10 = true;
        boolean z11 = true;
        for (IPConnStrategy next : this.f3901a) {
            if (!this.f3902b.get(Integer.valueOf(next.getUniqueId())).b()) {
                if (next.f3881a == 0) {
                    z10 = false;
                }
                z11 = false;
            }
        }
        if ((!this.f3903c || !z10) && !z11) {
            return false;
        }
        return true;
    }

    public String toString() {
        return new ArrayList(this.f3901a).toString();
    }

    public void update(l.b bVar) {
        int i10;
        for (IPConnStrategy iPConnStrategy : this.f3901a) {
            iPConnStrategy.f3883c = true;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < bVar.f3966h.length; i12++) {
            int i13 = 0;
            while (true) {
                String[] strArr = bVar.f3964f;
                if (i13 >= strArr.length) {
                    break;
                }
                a(strArr[i13], 1, bVar.f3966h[i12]);
                i13++;
            }
            if (bVar.f3965g != null) {
                this.f3903c = true;
                int i14 = 0;
                while (true) {
                    String[] strArr2 = bVar.f3965g;
                    if (i14 >= strArr2.length) {
                        break;
                    }
                    a(strArr2[i14], 0, bVar.f3966h[i12]);
                    i14++;
                }
            } else {
                this.f3903c = false;
            }
        }
        if (bVar.f3967i != null) {
            while (true) {
                l.e[] eVarArr = bVar.f3967i;
                if (i11 >= eVarArr.length) {
                    break;
                }
                l.e eVar = eVarArr[i11];
                String str = eVar.f3981a;
                if (d.c(str)) {
                    i10 = -1;
                } else {
                    i10 = 1;
                }
                a(str, i10, eVar.f3982b);
                i11++;
            }
        }
        ListIterator<IPConnStrategy> listIterator = this.f3901a.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f3883c) {
                listIterator.remove();
            }
        }
        Collections.sort(this.f3901a, a());
    }

    private void a(String str, int i10, l.a aVar) {
        int a10 = a(this.f3901a, new j(this, aVar, str, ConnProtocol.valueOf(aVar)));
        if (a10 != -1) {
            IPConnStrategy iPConnStrategy = this.f3901a.get(a10);
            iPConnStrategy.cto = aVar.f3953c;
            iPConnStrategy.rto = aVar.f3954d;
            iPConnStrategy.heartbeat = aVar.f3956f;
            iPConnStrategy.f3881a = i10;
            iPConnStrategy.f3882b = 0;
            iPConnStrategy.f3883c = false;
            return;
        }
        IPConnStrategy a11 = IPConnStrategy.a(str, aVar);
        if (a11 != null) {
            a11.f3881a = i10;
            a11.f3882b = 0;
            if (!this.f3902b.containsKey(Integer.valueOf(a11.getUniqueId()))) {
                this.f3902b.put(Integer.valueOf(a11.getUniqueId()), new ConnHistoryItem());
            }
            this.f3901a.add(a11);
        }
    }

    public StrategyList(List<IPConnStrategy> list) {
        this.f3901a = list;
    }

    private Comparator a() {
        if (this.f3904d == null) {
            this.f3904d = new k(this);
        }
        return this.f3904d;
    }

    private static <T> int a(Collection<T> collection, Predicate<T> predicate) {
        if (collection == null) {
            return -1;
        }
        Iterator<T> it = collection.iterator();
        int i10 = 0;
        while (it.hasNext() && !predicate.apply(it.next())) {
            i10++;
        }
        if (i10 == collection.size()) {
            return -1;
        }
        return i10;
    }
}
