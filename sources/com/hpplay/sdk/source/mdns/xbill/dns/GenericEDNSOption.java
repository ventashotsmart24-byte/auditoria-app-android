package com.hpplay.sdk.source.mdns.xbill.dns;

import com.hpplay.sdk.source.mdns.xbill.dns.utils.base16;
import com.raizlabs.android.dbflow.sql.language.Operator;

public class GenericEDNSOption extends EDNSOption {
    private byte[] data;

    public GenericEDNSOption(int i10) {
        super(i10);
    }

    public void optionFromWire(DNSInput dNSInput) {
        this.data = dNSInput.readByteArray();
    }

    public String optionToString() {
        return Operator.Operation.LESS_THAN + base16.toString(this.data) + Operator.Operation.GREATER_THAN;
    }

    public void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeByteArray(this.data);
    }

    public GenericEDNSOption(int i10, byte[] bArr) {
        super(i10);
        this.data = Record.checkByteArrayLength("option data", bArr, Message.MAXLENGTH);
    }
}
