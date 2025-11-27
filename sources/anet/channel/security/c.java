package anet.channel.security;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ISecurityFactory f3828a;

    public static ISecurityFactory a() {
        if (f3828a == null) {
            f3828a = new d();
        }
        return f3828a;
    }
}
