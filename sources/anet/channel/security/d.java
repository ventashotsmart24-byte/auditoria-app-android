package anet.channel.security;

final class d implements ISecurityFactory {
    public ISecurity createNonSecurity(String str) {
        return new a(str);
    }

    public ISecurity createSecurity(String str) {
        return new b(str);
    }
}
