package org.repackage.com.meizu.flyme.openidsdk;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

class ValueData {

    /* renamed from: a  reason: collision with root package name */
    public String f8646a;

    /* renamed from: b  reason: collision with root package name */
    public int f8647b;

    /* renamed from: c  reason: collision with root package name */
    public long f8648c = (System.currentTimeMillis() + 86400000);

    public ValueData(String str, int i10) {
        this.f8646a = str;
        this.f8647b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f8646a + '\'' + ", code=" + this.f8647b + ", expired=" + this.f8648c + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
