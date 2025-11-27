package q2;

import java.util.concurrent.ConcurrentLinkedQueue;

public class b extends ConcurrentLinkedQueue {
    public boolean add(Object obj) {
        return true;
    }

    public Object poll() {
        return null;
    }

    public boolean remove(Object obj) {
        return true;
    }
}
