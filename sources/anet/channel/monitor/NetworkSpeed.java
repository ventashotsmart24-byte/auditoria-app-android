package anet.channel.monitor;

public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);
    

    /* renamed from: a  reason: collision with root package name */
    private final String f3742a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3743b;

    private NetworkSpeed(String str, int i10) {
        this.f3742a = str;
        this.f3743b = i10;
    }

    public static NetworkSpeed valueOfCode(int i10) {
        if (i10 == 1) {
            return Slow;
        }
        return Fast;
    }

    public int getCode() {
        return this.f3743b;
    }

    public String getDesc() {
        return this.f3742a;
    }
}
