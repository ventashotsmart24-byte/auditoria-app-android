package anet.channel;

import anet.channel.entity.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final Map<SessionRequest, List<Session>> f3679a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final ReentrantReadWriteLock f3680b;

    /* renamed from: c  reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f3681c;

    /* renamed from: d  reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f3682d;

    public e() {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f3680b = reentrantReadWriteLock;
        this.f3681c = reentrantReadWriteLock.readLock();
        this.f3682d = reentrantReadWriteLock.writeLock();
    }

    public void a(SessionRequest sessionRequest, Session session) {
        if (sessionRequest != null && sessionRequest.a() != null && session != null) {
            this.f3682d.lock();
            try {
                List list = this.f3679a.get(sessionRequest);
                if (list == null) {
                    list = new ArrayList();
                    this.f3679a.put(sessionRequest, list);
                }
                if (list.indexOf(session) == -1) {
                    list.add(session);
                    Collections.sort(list);
                    this.f3682d.unlock();
                }
            } finally {
                this.f3682d.unlock();
            }
        }
    }

    public void b(SessionRequest sessionRequest, Session session) {
        this.f3682d.lock();
        try {
            List list = this.f3679a.get(sessionRequest);
            if (list != null) {
                list.remove(session);
                if (list.size() == 0) {
                    this.f3679a.remove(sessionRequest);
                }
                this.f3682d.unlock();
            }
        } finally {
            this.f3682d.unlock();
        }
    }

    public boolean c(SessionRequest sessionRequest, Session session) {
        this.f3681c.lock();
        try {
            List list = this.f3679a.get(sessionRequest);
            boolean z10 = false;
            if (list != null) {
                if (list.indexOf(session) != -1) {
                    z10 = true;
                }
            }
            return z10;
        } finally {
            this.f3681c.unlock();
        }
    }

    public List<Session> a(SessionRequest sessionRequest) {
        this.f3681c.lock();
        try {
            List list = this.f3679a.get(sessionRequest);
            if (list != null) {
                return new ArrayList(list);
            }
            List<Session> list2 = Collections.EMPTY_LIST;
            this.f3681c.unlock();
            return list2;
        } finally {
            this.f3681c.unlock();
        }
    }

    public Session a(SessionRequest sessionRequest, int i10) {
        this.f3681c.lock();
        try {
            List list = this.f3679a.get(sessionRequest);
            Session session = null;
            if (list != null) {
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Session session2 = (Session) it.next();
                        if (session2 != null && session2.isAvailable()) {
                            if (i10 == c.f3711c || session2.f3558j.getType() == i10) {
                                session = session2;
                            }
                        }
                    }
                    this.f3681c.unlock();
                    return session;
                }
            }
            return null;
        } finally {
            this.f3681c.unlock();
        }
    }

    public List<SessionRequest> a() {
        List<SessionRequest> list = Collections.EMPTY_LIST;
        this.f3681c.lock();
        try {
            if (this.f3679a.isEmpty()) {
                return list;
            }
            ArrayList arrayList = new ArrayList(this.f3679a.keySet());
            this.f3681c.unlock();
            return arrayList;
        } finally {
            this.f3681c.unlock();
        }
    }
}
