package com.fasterxml.jackson.databind.ser.std;

import c3.h;
import c3.n;
import com.hpplay.cybergarage.soap.SOAP;
import i3.b;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import k3.c0;

public class q extends h0 {
    public q() {
        super(InetSocketAddress.class);
    }

    /* renamed from: c */
    public void serialize(InetSocketAddress inetSocketAddress, h hVar, c0 c0Var) {
        String str;
        String str2;
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            str = inetSocketAddress.getHostName();
        } else {
            str = address.toString().trim();
        }
        int indexOf = str.indexOf(47);
        if (indexOf >= 0) {
            if (indexOf == 0) {
                if (address instanceof Inet6Address) {
                    str2 = "[" + str.substring(1) + "]";
                } else {
                    str2 = str.substring(1);
                }
                str = str2;
            } else {
                str = str.substring(0, indexOf);
            }
        }
        hVar.z0(str + SOAP.DELIM + inetSocketAddress.getPort());
    }

    /* renamed from: d */
    public void serializeWithType(InetSocketAddress inetSocketAddress, h hVar, c0 c0Var, w3.h hVar2) {
        b g10 = hVar2.g(hVar, hVar2.f(inetSocketAddress, InetSocketAddress.class, n.VALUE_STRING));
        serialize(inetSocketAddress, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
