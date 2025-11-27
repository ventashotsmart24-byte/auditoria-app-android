package io.jsonwebtoken;

import io.jsonwebtoken.JweHeaderMutator;

public interface JweHeaderMutator<T extends JweHeaderMutator<T>> extends ProtectedHeaderMutator<T> {
    T agreementPartyUInfo(String str);

    T agreementPartyUInfo(byte[] bArr);

    T agreementPartyVInfo(String str);

    T agreementPartyVInfo(byte[] bArr);

    T pbes2Count(int i10);
}
