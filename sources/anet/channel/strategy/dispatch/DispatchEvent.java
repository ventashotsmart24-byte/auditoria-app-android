package anet.channel.strategy.dispatch;

public class DispatchEvent {
    public static final int DNSFAIL = 0;
    public static final int DNSSUCCESS = 1;
    public final int eventType;
    public final Object extraObject;

    public DispatchEvent(int i10, Object obj) {
        this.eventType = i10;
        this.extraObject = obj;
    }
}
