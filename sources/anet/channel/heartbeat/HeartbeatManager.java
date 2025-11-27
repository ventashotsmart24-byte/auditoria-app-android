package anet.channel.heartbeat;

public class HeartbeatManager {
    public static IHeartbeat getDefaultBackgroundAccsHeartbeat() {
        return new a();
    }

    public static IHeartbeat getDefaultHeartbeat() {
        return new b();
    }
}
