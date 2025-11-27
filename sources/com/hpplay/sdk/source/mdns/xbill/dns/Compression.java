package com.hpplay.sdk.source.mdns.xbill.dns;

import java.io.PrintStream;

public class Compression {
    private Entry[] table = new Entry[17];
    private boolean verbose = Options.check("verbosecompression");

    public void add(int i10, Name name) {
        if (i10 <= 16383) {
            int hashCode = (name.hashCode() & Integer.MAX_VALUE) % 17;
            Entry entry = new Entry();
            entry.name = name;
            entry.pos = i10;
            Entry[] entryArr = this.table;
            entry.next = entryArr[hashCode];
            entryArr[hashCode] = entry;
            if (this.verbose) {
                PrintStream printStream = System.err;
                printStream.println("Adding " + name + " at " + i10);
            }
        }
    }

    public int get(Name name) {
        int i10 = -1;
        for (Entry entry = this.table[(name.hashCode() & Integer.MAX_VALUE) % 17]; entry != null; entry = entry.next) {
            if (entry.name.equals(name)) {
                i10 = entry.pos;
            }
        }
        if (this.verbose) {
            PrintStream printStream = System.err;
            printStream.println("Looking for " + name + ", found " + i10);
        }
        return i10;
    }
}
