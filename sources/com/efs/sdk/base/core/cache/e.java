package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.c.a.c;
import com.efs.sdk.base.core.c.a.d;
import com.efs.sdk.base.core.config.remote.b;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends Handler implements d {

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f5188a = new ConcurrentHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private d f5189b = new d();

    /* renamed from: c  reason: collision with root package name */
    private c f5190c = new c();

    public static class a extends FileOutputStream {

        /* renamed from: a  reason: collision with root package name */
        long f5191a = System.currentTimeMillis();

        /* renamed from: b  reason: collision with root package name */
        File f5192b;

        public a(File file) {
            super(file);
            this.f5192b = file;
        }
    }

    public e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f5313a.getLooper());
    }

    private static long b(String str) {
        Map<String, String> c10 = b.a().c();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!c10.containsKey(concat)) {
            return 60000;
        }
        String str2 = c10.get(concat);
        if (TextUtils.isEmpty(str2)) {
            return 60000;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000);
        } catch (Throwable th) {
            Log.e("efs.cache", "get cache interval error", th);
            return 60000;
        }
    }

    private void c(String str) {
        a aVar;
        if (this.f5188a.containsKey(str) && (aVar = this.f5188a.get(str)) != null) {
            try {
                aVar.flush();
                FileUtil.safeClose(aVar);
                Log.i("RecordLogCacheProcessor", "save file, type is ".concat(String.valueOf(str)));
                a(aVar.f5192b);
                this.f5188a.remove(str);
                if (!"wa".equalsIgnoreCase(str)) {
                    f.a.f5270a.f5268c.c();
                }
            } catch (Throwable th) {
                this.f5188a.remove(str);
                if (!"wa".equalsIgnoreCase(str)) {
                    f.a.f5270a.f5268c.c();
                }
                throw th;
            }
        }
    }

    public final void a(LogDto logDto) {
        Message obtain = Message.obtain();
        obtain.obj = logDto;
        obtain.what = 0;
        sendMessage(obtain);
    }

    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            LogDto logDto = (LogDto) message.obj;
            int i11 = 0;
            while (i11 < 3) {
                try {
                    a b10 = b(logDto);
                    if (b10 == null) {
                        Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                        return;
                    }
                    if (b10.getChannel().position() + ((long) logDto.getData().length) > 819200) {
                        c(logDto.getLogType());
                        b10 = b(logDto);
                        if (b10 == null) {
                            Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                            return;
                        }
                    }
                    b10.write(EncodeUtil.base64Encode(logDto.getData()));
                    b10.write("\n".getBytes());
                    return;
                } catch (Throwable th) {
                    Log.e("efs.cache", "cache file error", th);
                    i11++;
                }
            }
        } else if (i10 == 1) {
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
            }
        }
    }

    public final boolean a(File file, LogDto logDto) {
        if (!logDto.isCp()) {
            a(file);
            return false;
        } else if (!file.exists()) {
            return false;
        } else {
            logDto.setFile(file);
            logDto.setSendImediately(true);
            logDto.setLogBodyType(1);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.efs.sdk.base.core.cache.e.a b(com.efs.sdk.base.core.model.LogDto r6) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f5188a
            java.lang.String r1 = r6.getLogType()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L_0x0019
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f5188a
            java.lang.String r6 = r6.getLogType()
            java.lang.Object r6 = r0.get(r6)
            com.efs.sdk.base.core.cache.e$a r6 = (com.efs.sdk.base.core.cache.e.a) r6
            return r6
        L_0x0019:
            java.lang.String r0 = r6.getLogType()
            java.lang.String r1 = "codelogperf"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x0041
            java.lang.String r0 = com.efs.sdk.base.core.util.FileUtil.getCodelogFileName(r6)
            java.io.File r2 = new java.io.File
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r3 = r3.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r4 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r4 = r4.getAppid()
            java.io.File r3 = com.efs.sdk.base.core.util.a.g(r3, r4)
            r2.<init>(r3, r0)
            goto L_0x005c
        L_0x0041:
            java.lang.String r0 = com.efs.sdk.base.core.util.FileUtil.getFileName(r6)
            java.io.File r2 = new java.io.File
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r3 = r3.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r4 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r4 = r4.getAppid()
            java.io.File r3 = com.efs.sdk.base.core.util.a.f(r3, r4)
            r2.<init>(r3, r0)
        L_0x005c:
            r0 = 0
            com.efs.sdk.base.core.cache.e$a r3 = new com.efs.sdk.base.core.cache.e$a     // Catch:{ all -> 0x00ac }
            r3.<init>(r2)     // Catch:{ all -> 0x00ac }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f5188a     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r6.getLogType()     // Catch:{ all -> 0x00aa }
            java.lang.Object r0 = r0.putIfAbsent(r4, r3)     // Catch:{ all -> 0x00aa }
            com.efs.sdk.base.core.cache.e$a r0 = (com.efs.sdk.base.core.cache.e.a) r0     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x0077
            com.efs.sdk.base.core.util.FileUtil.safeClose(r3)     // Catch:{ all -> 0x00aa }
            com.efs.sdk.base.core.util.FileUtil.delete(r2)     // Catch:{ all -> 0x00aa }
            return r0
        L_0x0077:
            java.lang.String r0 = r6.getLogType()     // Catch:{ all -> 0x00aa }
            boolean r0 = r1.equals(r0)     // Catch:{ all -> 0x00aa }
            r1 = 1
            if (r0 == 0) goto L_0x0092
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = r6.getLogType()     // Catch:{ all -> 0x00aa }
            r0.obj = r2     // Catch:{ all -> 0x00aa }
            r0.what = r1     // Catch:{ all -> 0x00aa }
            r5.sendMessage(r0)     // Catch:{ all -> 0x00aa }
            goto L_0x00b2
        L_0x0092:
            android.os.Message r0 = android.os.Message.obtain()     // Catch:{ all -> 0x00aa }
            java.lang.String r2 = r6.getLogType()     // Catch:{ all -> 0x00aa }
            r0.obj = r2     // Catch:{ all -> 0x00aa }
            r0.what = r1     // Catch:{ all -> 0x00aa }
            java.lang.String r1 = r6.getLogType()     // Catch:{ all -> 0x00aa }
            long r1 = b((java.lang.String) r1)     // Catch:{ all -> 0x00aa }
            r5.sendMessageDelayed(r0, r1)     // Catch:{ all -> 0x00aa }
            goto L_0x00b2
        L_0x00aa:
            r0 = move-exception
            goto L_0x00af
        L_0x00ac:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L_0x00af:
            r0.printStackTrace()
        L_0x00b2:
            java.lang.String r0 = "wa"
            java.lang.String r6 = r6.getLogType()
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 != 0) goto L_0x00c7
            com.efs.sdk.base.core.d.f r6 = com.efs.sdk.base.core.d.f.a.f5270a
            com.efs.sdk.base.core.d.d r6 = r6.f5268c
            r6.b()
        L_0x00c7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.cache.e.b(com.efs.sdk.base.core.model.LogDto):com.efs.sdk.base.core.cache.e$a");
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            Message obtain = Message.obtain();
            obtain.obj = str;
            obtain.what = 1;
            sendMessage(obtain);
        }
    }

    public final void a(File file) {
        LogDto logDto;
        File file2;
        String str;
        String name = file.getName();
        if (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
            logDto = FileUtil.createLogDtoByName(name);
        } else {
            logDto = FileUtil.createCodeLogDtoByName(name);
        }
        if (logDto == null) {
            CacheManager.getInstance().onChangeDtoError(file);
        } else if (!a(logDto, file) || logDto.getData() == null || logDto.getData().length <= 0) {
            CacheManager.getInstance().onChangeDtoError(file);
        } else {
            if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
                str = FileUtil.getCodelogFileName(logDto);
                file2 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            } else {
                str = FileUtil.getFileName(logDto);
                file2 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            }
            File file3 = new File(file2, str);
            Log.i("RecordLogCacheProcessor", "upload file, name is ".concat(String.valueOf(name)));
            FileUtil.write(file3, logDto.getData());
            FileUtil.delete(file);
        }
    }

    /* JADX INFO: finally extract failed */
    private boolean a(LogDto logDto, File file) {
        BufferedReader bufferedReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader = null;
        try {
            FileReader fileReader2 = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader2);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
                fileReader = fileReader2;
                try {
                    Log.e("efs.cache", "local decode error", th);
                    FileUtil.safeClose(bufferedReader);
                    FileUtil.safeClose(fileReader);
                    return false;
                } catch (Throwable th2) {
                    FileUtil.safeClose(bufferedReader);
                    FileUtil.safeClose(fileReader);
                    throw th2;
                }
            }
            try {
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    String base64DecodeToStr = EncodeUtil.base64DecodeToStr(readLine.getBytes());
                    if (!TextUtils.isEmpty(base64DecodeToStr)) {
                        sb.append(base64DecodeToStr);
                        sb.append("\n");
                    }
                }
                logDto.setData(sb.toString().getBytes());
                logDto.setSendImediately(true);
                this.f5190c.a(logDto);
                logDto.setFile(file);
                FileUtil.safeClose(bufferedReader);
                FileUtil.safeClose(fileReader2);
                return true;
            } catch (Throwable th3) {
                th = th3;
                fileReader = fileReader2;
                Log.e("efs.cache", "local decode error", th);
                FileUtil.safeClose(bufferedReader);
                FileUtil.safeClose(fileReader);
                return false;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            Log.e("efs.cache", "local decode error", th);
            FileUtil.safeClose(bufferedReader);
            FileUtil.safeClose(fileReader);
            return false;
        }
    }
}
