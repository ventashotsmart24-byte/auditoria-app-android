package anet.channel.e;

import android.content.SharedPreferences;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyListener;
import anet.channel.strategy.l;

final class c implements IStrategyListener {
    public void onStrategyUpdated(l.d dVar) {
        String str;
        if (dVar != null && dVar.f3974b != null) {
            int i10 = 0;
            loop0:
            while (true) {
                l.b[] bVarArr = dVar.f3974b;
                if (i10 < bVarArr.length) {
                    l.b bVar = bVarArr[i10];
                    str = bVar.f3959a;
                    l.a[] aVarArr = bVar.f3966h;
                    if (aVarArr != null && aVarArr.length > 0) {
                        int i11 = 0;
                        while (i11 < aVarArr.length) {
                            String str2 = aVarArr[i11].f3952b;
                            if (!ConnType.HTTP3.equals(str2) && !ConnType.HTTP3_PLAIN.equals(str2)) {
                                i11++;
                            }
                        }
                        continue;
                    }
                    i10++;
                } else {
                    return;
                }
            }
            if (!str.equals(a.f3684b)) {
                String unused = a.f3684b = str;
                SharedPreferences.Editor edit = a.f3688f.edit();
                edit.putString("http3_detector_host", a.f3684b);
                edit.apply();
            }
            a.a(NetworkStatusHelper.getStatus());
        }
    }
}
