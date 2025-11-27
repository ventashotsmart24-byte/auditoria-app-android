package com.efs.sdk.base.core.d;

import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.efs.sdk.base.core.b.d;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.http.HttpResponse;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.HashMap;
import java.util.Map;

public final class e implements d {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse != null && !TextUtils.isEmpty(httpResponse.data)) {
            for (String split : httpResponse.data.split("`")) {
                String[] split2 = split.split(Operator.Operation.EQUALS);
                if (split2.length >= 2) {
                    if (split2[0].equalsIgnoreCase("retcode")) {
                        httpResponse.setBizCode(split2[1]);
                    } else {
                        ((Map) httpResponse.extra).put(split2[0], split2[1]);
                    }
                }
            }
        }
    }

    public final HttpResponse a(LogDto logDto, boolean z10) {
        HttpResponse httpResponse = null;
        try {
            c cVar = f.a.f5270a.f5266a;
            String valueOf = String.valueOf(System.currentTimeMillis());
            String md5 = EncodeUtil.md5(cVar.f5259b + cVar.f5260c + valueOf + "AppChk#2014");
            StringBuilder sb = new StringBuilder();
            String str = cVar.f5258a;
            if (str.startsWith(HttpConstant.HTTP)) {
                sb.append(str);
                sb.append("?chk=");
            } else {
                sb.append(str);
                sb.append("?chk=");
            }
            sb.append(md5.substring(md5.length() - 8));
            sb.append("&vno=");
            sb.append(valueOf);
            sb.append("&uuid=");
            sb.append(cVar.f5260c);
            sb.append("&app=");
            sb.append(cVar.f5259b);
            sb.append("&zip=gzip");
            String sb2 = sb.toString();
            int i10 = 0;
            byte[] bArr = new byte[0];
            if (logDto.getLogBodyType() == 0) {
                bArr = logDto.getData();
                i10 = bArr.length;
            } else if (1 == logDto.getLogBodyType()) {
                bArr = FileUtil.read(logDto.getFile().getPath());
                i10 = bArr.length;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/x-www-form-urlencoded");
            hashMap.put("Content-Length", String.valueOf(i10));
            com.efs.sdk.base.core.util.a.d a10 = new com.efs.sdk.base.core.util.a.d(sb2).a((Map<String, String>) hashMap);
            a10.f5309a.f5303c = bArr;
            httpResponse = a10.a().b();
            a(httpResponse);
            if (httpResponse.succ) {
                Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
                FileUtil.delete(logDto.getFile());
                return httpResponse;
            }
            Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
            return httpResponse;
        } catch (Throwable th) {
            if (httpResponse == null) {
                httpResponse = new HttpResponse();
            }
            Log.e("efs.wa.send", "get file size error", th);
        }
    }
}
