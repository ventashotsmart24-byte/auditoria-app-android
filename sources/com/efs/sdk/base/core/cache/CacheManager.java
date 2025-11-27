package com.efs.sdk.base.core.cache;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CacheManager {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5178a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5179b;

    /* renamed from: c  reason: collision with root package name */
    private a f5180c;

    /* renamed from: d  reason: collision with root package name */
    private a f5181d;

    /* renamed from: e  reason: collision with root package name */
    private List<File> f5182e;

    public static class a implements Comparator<File> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            long lastModified = ((File) obj).lastModified() - ((File) obj2).lastModified();
            if (lastModified > 0) {
                return 1;
            }
            if (lastModified == 0) {
                return 0;
            }
            return -1;
        }
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final CacheManager f5183a = new CacheManager((byte) 0);
    }

    public /* synthetic */ CacheManager(byte b10) {
        this();
    }

    private void a() {
        String[] list;
        LogDto logDto;
        File d10 = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (d10.exists() && d10.isDirectory() && (list = d10.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                    File file = new File(d10, str);
                    List<File> listFiles = FileUtil.listFiles(file);
                    if (!listFiles.isEmpty()) {
                        for (File next : listFiles) {
                            if (a(next.getName())) {
                                a(next);
                            } else {
                                String name = next.getName();
                                if (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                                    logDto = FileUtil.createLogDtoByName(name);
                                } else {
                                    logDto = FileUtil.createCodeLogDtoByName(name);
                                }
                                if (logDto == null) {
                                    onChangeDtoError(next);
                                } else {
                                    d a10 = this.f5180c.a(logDto.getLogProtocol());
                                    if (a10 == null) {
                                        onChangeDtoError(next);
                                    } else {
                                        a10.a(next);
                                    }
                                }
                            }
                        }
                    }
                    FileUtil.delete(file);
                }
            }
        }
    }

    private void b() {
        String[] list;
        LogDto logDto;
        File e10 = com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (e10.exists() && e10.isDirectory() && (list = e10.list()) != null && list.length > 0) {
            for (String str : list) {
                if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                    File file = new File(e10, str);
                    List<File> listFiles = FileUtil.listFiles(file);
                    if (!listFiles.isEmpty()) {
                        for (File next : listFiles) {
                            if (a(next.getName())) {
                                a(next);
                            } else {
                                String name = next.getName();
                                if (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                                    logDto = FileUtil.createLogDtoByName(name);
                                } else {
                                    logDto = FileUtil.createCodeLogDtoByName(name);
                                }
                                if (logDto == null) {
                                    onChangeDtoError(next);
                                } else {
                                    d a10 = this.f5180c.a(logDto.getLogProtocol());
                                    if (a10 == null) {
                                        onChangeDtoError(next);
                                    } else {
                                        a10.a(next);
                                    }
                                }
                            }
                        }
                    }
                    FileUtil.delete(file);
                }
            }
        }
    }

    public static CacheManager getInstance() {
        return b.f5183a;
    }

    public LogDto changeLogDto(File file) {
        LogDto logDto;
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                a(file);
                return null;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                logDto = FileUtil.createLogDtoByName(name);
            } else {
                logDto = FileUtil.createCodeLogDtoByName(name);
            }
            if (logDto == null) {
                onChangeDtoError(file);
                return null;
            }
            d a10 = this.f5180c.a(logDto.getLogProtocol());
            if (a10 == null) {
                onChangeDtoError(file);
                return null;
            } else if (a10.a(file, logDto)) {
                return logDto;
            } else {
                onChangeDtoError(file);
                return null;
            }
        } catch (Throwable th) {
            Log.w("efs.cache", th);
            onChangeDtoError(file);
            return null;
        }
    }

    public void flushImmediately(byte b10, String str) {
        d a10 = this.f5180c.a(b10);
        if (a10 != null) {
            a10.a(str);
        }
    }

    public List<File> getCodeLogList() {
        return this.f5182e;
    }

    public List<File> getFileList(int i10, IFileFilter iFileFilter) {
        a();
        File h10 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!h10.exists()) {
            return Collections.emptyList();
        }
        List<File> listFiles = FileUtil.listFiles(h10);
        if (this.f5179b) {
            f a10 = f.a.f5270a;
            int size = listFiles.size();
            if (a10.f5267b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "log_lag", a10.f5266a.f5260c);
                bVar.put("cnt", Integer.valueOf(size));
                a10.f5267b.send(bVar);
            }
            this.f5179b = false;
        }
        Collections.sort(listFiles, this.f5181d);
        ArrayList arrayList = new ArrayList(i10);
        for (int size2 = listFiles.size() - 1; size2 >= 0 && arrayList.size() < i10; size2--) {
            File file = listFiles.get(size2);
            if (file.exists() && (iFileFilter == null || !iFileFilter.filter(file))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public List<File> getFileListCodeLog(int i10, IFileFilter iFileFilter) {
        b();
        List<File> list = this.f5182e;
        if (list == null || list.isEmpty()) {
            File i11 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            if (!i11.exists()) {
                return Collections.emptyList();
            }
            List<File> listFiles = FileUtil.listFiles(i11);
            this.f5182e = listFiles;
            Collections.sort(listFiles, this.f5181d);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int size = this.f5182e.size() - 1; size >= 0 && arrayList.size() < i10; size--) {
            File file = this.f5182e.get(size);
            if (file.exists()) {
                if (iFileFilter == null || !iFileFilter.filter(file)) {
                    Log.i("efs.cache", "[-->>] add file is " + file.getName());
                    arrayList.add(file);
                } else {
                    Log.i("efs.cache", "[--xx] filter file is " + file.getName());
                }
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDto(int i10, IFileFilter iFileFilter) {
        a();
        List<File> fileList = getFileList(i10, iFileFilter);
        ArrayList arrayList = new ArrayList(i10);
        for (File next : fileList) {
            LogDto changeLogDto = changeLogDto(next);
            if (changeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + next.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDtoCodeLog(int i10, IFileFilter iFileFilter) {
        b();
        List<File> fileListCodeLog = getFileListCodeLog(i10, iFileFilter);
        ArrayList arrayList = new ArrayList(i10);
        for (File next : fileListCodeLog) {
            LogDto changeLogDto = changeLogDto(next);
            if (changeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + next.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public void onChangeDtoError(File file) {
        if (!file.getName().startsWith("wa_")) {
            f.a.f5270a.f5268c.f5262c.incrementAndGet();
        }
        FileUtil.delete(file);
    }

    public void put(LogDto logDto) {
        d a10;
        if (!"wa".equals(logDto.getLogType()) && !Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && !b.a().f5185a) {
            if (!this.f5178a) {
                f a11 = f.a.f5270a;
                int i10 = com.efs.sdk.base.core.config.remote.b.a().f5225d.mConfigVersion;
                if (a11.f5267b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    a11.f5267b.send(a11.a("disk_limit", i10));
                }
            }
            this.f5178a = true;
        } else if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && !b.a().f5186b) {
        } else {
            if ((logDto.getLogBodyType() != 0 || (logDto.getData() != null && logDto.getData().length != 0)) && (a10 = this.f5180c.a(logDto.getLogProtocol())) != null) {
                a10.a(logDto);
            }
        }
    }

    private CacheManager() {
        this.f5178a = false;
        this.f5179b = true;
        this.f5180c = new a();
        this.f5181d = new a();
    }

    public static boolean a(String str) {
        long j10;
        try {
            if (str.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                j10 = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            } else {
                j10 = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            }
            com.efs.sdk.base.core.a.a.a();
            if (Math.abs(com.efs.sdk.base.core.a.a.b() - j10) >= 604800000) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void a(File file) {
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        Log.i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            f.a.f5270a.f5268c.d();
        }
        FileUtil.delete(file);
    }
}
