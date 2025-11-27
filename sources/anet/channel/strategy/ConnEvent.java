package anet.channel.strategy;

public class ConnEvent {
    public long connTime = Long.MAX_VALUE;
    public boolean isAccs = false;
    public boolean isSuccess = false;

    public String toString() {
        if (this.isSuccess) {
            return "ConnEvent#Success";
        }
        return "ConnEvent#Fail";
    }
}
