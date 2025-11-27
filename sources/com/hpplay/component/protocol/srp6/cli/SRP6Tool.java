package com.hpplay.component.protocol.srp6.cli;

import com.hpplay.component.protocol.srp6.BigIntegerUtils;
import com.hpplay.component.protocol.srp6.SRP6CryptoParams;
import com.titans.entity.CdnType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public abstract class SRP6Tool {
    protected BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public SRP6CryptoParams getConfig(String str) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        println(str + "Enter prime 'N' (hex): ");
        println(str + "\t1 = select precomputed 256-bit");
        println(str + "\t2 = select precomputed 512-bit");
        println(str + "\t3 = select precomputed 768-bit");
        println(str + "\t4 = select precomputed 1024-bit");
        println(str + "\t5 = select precomputed 2048-bit");
        println(str + "\t6 = enter prime 'N' and generator 'g'");
        println();
        print(str + "Your choice [1]: ");
        String readInput = readInput("1");
        readInput.hashCode();
        boolean z10 = false;
        char c10 = 65535;
        switch (readInput.hashCode()) {
            case 49:
                if (readInput.equals("1")) {
                    c10 = 0;
                    break;
                }
                break;
            case 50:
                if (readInput.equals("2")) {
                    c10 = 1;
                    break;
                }
                break;
            case 51:
                if (readInput.equals("3")) {
                    c10 = 2;
                    break;
                }
                break;
            case 52:
                if (readInput.equals("4")) {
                    c10 = 3;
                    break;
                }
                break;
            case 53:
                if (readInput.equals(CdnType.DIGITAL_TYPE_PCDN)) {
                    c10 = 4;
                    break;
                }
                break;
            case 54:
                if (readInput.equals(CdnType.DIGITAL_TYPE_PEERSTAR)) {
                    c10 = 5;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                bigInteger2 = SRP6CryptoParams.N_256;
                bigInteger = SRP6CryptoParams.g_common;
                break;
            case 1:
                bigInteger2 = SRP6CryptoParams.N_512;
                bigInteger = SRP6CryptoParams.g_common;
                break;
            case 2:
                bigInteger2 = SRP6CryptoParams.N_768;
                bigInteger = SRP6CryptoParams.g_common;
                break;
            case 3:
                bigInteger2 = SRP6CryptoParams.N_1024;
                bigInteger = SRP6CryptoParams.g_common;
                break;
            case 4:
                bigInteger2 = SRP6CryptoParams.N_2048;
                bigInteger = SRP6CryptoParams.g_common;
                break;
            case 5:
                println();
                print(str + "Enter prime 'N' (hex): ");
                bigInteger2 = readBigInteger();
                print(str + "Enter generator 'g' (hex): ");
                bigInteger = readBigInteger();
                break;
            default:
                throw new IOException("Unknown choice");
        }
        z10 = true;
        println();
        if (z10) {
            println(str + "Selected prime 'N' (hex): " + BigIntegerUtils.toHex(bigInteger2));
            println(str + "Selected generator 'g' (hex): " + BigIntegerUtils.toHex(bigInteger));
            println();
        }
        print(str + "Enter hash algorithm 'H' [SHA-1]: ");
        String readInput2 = readInput("SHA-1");
        println();
        return new SRP6CryptoParams(bigInteger2, bigInteger, readInput2);
    }

    public void logS(String str) {
        println("\tComputed shared key 'S' (hex): " + str);
    }

    public void logShash(byte[] bArr) {
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void println(String str) {
    }

    public BigInteger readBigInteger() {
        BigInteger fromHex = BigIntegerUtils.fromHex(readInput());
        if (fromHex != null) {
            return fromHex;
        }
        throw new IOException("Bad hex encoding");
    }

    public String readInput(String str) {
        String readLine = this.console.readLine();
        if (readLine != null && !readLine.isEmpty()) {
            return readLine.trim();
        }
        if (str != null) {
            return str;
        }
        throw new IOException("Missing input");
    }

    public abstract void run();

    public void println() {
        System.out.println();
    }

    public String readInput() {
        return readInput((String) null);
    }
}
