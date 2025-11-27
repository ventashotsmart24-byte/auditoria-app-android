package com.hpplay.sdk.source.mdns.xbill.dns;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientSubnetOption extends EDNSOption {
    private static final long serialVersionUID = -3868158449890266347L;
    private InetAddress address;
    private int family;
    private int scopeNetmask;
    private int sourceNetmask;

    public ClientSubnetOption() {
        super(8);
    }

    public InetAddress getAddress() {
        return this.address;
    }

    public void optionFromWire(DNSInput dNSInput) {
        int readU16 = dNSInput.readU16();
        this.family = readU16;
        if (readU16 == 1 || readU16 == 2) {
            int readU8 = dNSInput.readU8();
            this.sourceNetmask = readU8;
            if (readU8 <= Address.addressLength(this.family) * 8) {
                int readU82 = dNSInput.readU8();
                this.scopeNetmask = readU82;
                if (readU82 <= Address.addressLength(this.family) * 8) {
                    byte[] readByteArray = dNSInput.readByteArray();
                    if (readByteArray.length == (this.sourceNetmask + 7) / 8) {
                        byte[] bArr = new byte[Address.addressLength(this.family)];
                        System.arraycopy(readByteArray, 0, bArr, 0, readByteArray.length);
                        try {
                            InetAddress byAddress = InetAddress.getByAddress(bArr);
                            this.address = byAddress;
                            if (!Address.truncate(byAddress, this.sourceNetmask).equals(this.address)) {
                                throw new Exception("invalid padding");
                            }
                        } catch (UnknownHostException e10) {
                            throw new Exception("invalid address", e10);
                        }
                    } else {
                        throw new Exception("invalid address");
                    }
                } else {
                    throw new Exception("invalid scope netmask");
                }
            } else {
                throw new Exception("invalid source netmask");
            }
        } else {
            throw new Exception("unknown address family");
        }
    }

    public String optionToString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.address.getHostAddress());
        stringBuffer.append(Operator.Operation.DIVISION);
        stringBuffer.append(this.sourceNetmask);
        stringBuffer.append(", scope netmask ");
        stringBuffer.append(this.scopeNetmask);
        return stringBuffer.toString();
    }

    public void optionToWire(DNSOutput dNSOutput) {
        dNSOutput.writeU16(this.family);
        dNSOutput.writeU8(this.sourceNetmask);
        dNSOutput.writeU8(this.scopeNetmask);
        dNSOutput.writeByteArray(this.address.getAddress(), 0, (this.sourceNetmask + 7) / 8);
    }
}
