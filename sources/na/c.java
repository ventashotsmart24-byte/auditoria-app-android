package na;

import android.text.TextUtils;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;
import ma.i;

public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f19073a = "000000000000";

    /* renamed from: b  reason: collision with root package name */
    public static String f19074b = "000000000000";

    public static String a() {
        String str = null;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (!inetAddresses.hasMoreElements()) {
                        break;
                    }
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!(nextElement instanceof Inet6Address)) {
                        if (!"127.0.0.1".equals(nextElement.getHostAddress())) {
                            str = nextElement.getHostAddress();
                            break;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public static void b(String str, String str2) {
        String trim;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/net/arp"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    try {
                        String trim2 = readLine.trim();
                        if (trim2.length() >= 63) {
                            if (!trim2.toUpperCase(Locale.US).contains("IP")) {
                                String trim3 = trim2.substring(0, 17).trim();
                                trim2.substring(29, 32).trim();
                                trim = trim2.substring(41, 63).trim();
                                if (trim.contains("00:00:00:00:00:00")) {
                                    continue;
                                } else if (!TextUtils.isEmpty(trim)) {
                                    if ((!TextUtils.isEmpty(str) && str.equals(trim3)) || (!TextUtils.isEmpty(str2) && str2.equals(trim3))) {
                                        f19073a = trim.replaceAll(SOAP.DELIM, "");
                                        c();
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                break;
            }
            f19073a = trim.replaceAll(SOAP.DELIM, "");
            c();
            break;
            bufferedReader.close();
        } catch (Exception unused2) {
        }
    }

    public static void c() {
        f19074b = i.e(f19073a, "combrasiltvaslgklxckbcombrasiltv");
    }

    public static void d() {
        String a10 = a();
        if (a10 != null) {
            String[] split = a10.split("\\.");
            if (split.length >= 4) {
                split[3] = "1";
                split[3] = "254";
                b(split[0] + "." + split[1] + "." + split[2] + "." + split[3], split[0] + "." + split[1] + "." + split[2] + "." + split[3]);
            }
        }
    }
}
