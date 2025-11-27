package com.umeng.message.tag;

import android.app.Application;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushTagCallback;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import com.umeng.message.proguard.b;
import com.umeng.message.proguard.be;
import com.umeng.message.proguard.bi;
import com.umeng.message.proguard.d;
import com.umeng.message.proguard.e;
import com.umeng.message.proguard.f;
import com.umeng.message.proguard.g;
import com.umeng.message.proguard.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONObject;

public class TagManager {

    /* renamed from: b  reason: collision with root package name */
    private static volatile TagManager f16111b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final be f16112a = new be();

    @Deprecated
    public interface TCallBack extends UPushTagCallback<ITagManager.Result> {
    }

    @Deprecated
    public interface TagListCallBack extends UPushTagCallback<List<String>> {
    }

    private TagManager() {
    }

    public static /* synthetic */ boolean b() {
        boolean z10;
        if (MessageSharedPrefs.getInstance(y.a()).f15211b.b("tag_send_policy", -1) == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            UPLog.i("TagManager", "tag server disable!");
        }
        return z10;
    }

    public static /* synthetic */ JSONObject d() {
        Application a10 = y.a();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", e.a());
        jSONObject.put("utdid", d.o(a10));
        jSONObject.put("device_token", MessageSharedPrefs.getInstance(a10).l());
        jSONObject.put("ts", System.currentTimeMillis());
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static ITagManager.Result e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", ITagManager.SUCCESS);
            jSONObject.put("remain", MessageSharedPrefs.getInstance(y.a()).d());
        } catch (Exception e10) {
            UPLog.e("TagManager", (Throwable) e10);
        }
        return new ITagManager.Result(jSONObject);
    }

    public static TagManager getInstance() {
        if (f16111b == null) {
            synchronized (TagManager.class) {
                if (f16111b == null) {
                    f16111b = new TagManager();
                }
            }
        }
        return f16111b;
    }

    public void addTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() {
            public final void run() {
                Throwable th;
                ITagManager.Result result;
                boolean z10;
                ITagManager.Result result2 = new ITagManager.Result();
                try {
                    String[] strArr = strArr;
                    if (strArr != null) {
                        if (strArr.length != 0) {
                            if (TagManager.a()) {
                                UPLog.e("TagManager", "No utdid or device_token");
                                result2.setErrors("No utdid or device_token");
                                try {
                                    uPushTagCallback.onMessage(false, result2);
                                    return;
                                } catch (Throwable th2) {
                                    UPLog.e("TagManager", th2);
                                    return;
                                }
                            } else if (TagManager.b()) {
                                UPLog.e("TagManager", "Tag api is disabled by the server");
                                result2.setErrors("Tag api is disabled by the server");
                                try {
                                    uPushTagCallback.onMessage(false, result2);
                                    return;
                                } catch (Throwable th3) {
                                    UPLog.e("TagManager", th3);
                                    return;
                                }
                            } else {
                                Application a10 = y.a();
                                ArrayList arrayList = new ArrayList();
                                Set<String> b10 = MessageSharedPrefs.getInstance(a10).f15211b.b("tags", (Set<String>) new HashSet());
                                for (String str : strArr) {
                                    if (!b10.contains(str) && !arrayList.contains(str)) {
                                        byte[] bytes = str.getBytes();
                                        if (bytes == null || bytes.length > 128 || bytes.length <= 0) {
                                            UPLog.e("TagManager", "tag length must be 1~128 byte");
                                            result2.setErrors("tag length must be 1~128 byte");
                                            try {
                                                uPushTagCallback.onMessage(false, result2);
                                                return;
                                            } catch (Throwable th4) {
                                                UPLog.e("TagManager", th4);
                                                return;
                                            }
                                        } else {
                                            arrayList.add(str);
                                        }
                                    }
                                }
                                if (arrayList.size() > MessageSharedPrefs.getInstance(a10).d()) {
                                    UPLog.e("TagManager", "tag count limit");
                                    result2.setErrors("tag count limit");
                                    try {
                                        uPushTagCallback.onMessage(false, result2);
                                        return;
                                    } catch (Throwable th5) {
                                        UPLog.e("TagManager", th5);
                                        return;
                                    }
                                } else if (!MessageSharedPrefs.getInstance(a10).a("tag_add_")) {
                                    UPLog.e("TagManager", "interval limit");
                                    result2.setErrors("interval limit");
                                    try {
                                        uPushTagCallback.onMessage(false, result2);
                                        return;
                                    } catch (Throwable th6) {
                                        UPLog.e("TagManager", th6);
                                        return;
                                    }
                                } else if (arrayList.size() == 0) {
                                    try {
                                        uPushTagCallback.onMessage(true, TagManager.e());
                                        return;
                                    } catch (Throwable th7) {
                                        UPLog.e("TagManager", th7);
                                        return;
                                    }
                                } else {
                                    try {
                                        JSONObject d10 = TagManager.d();
                                        d10.put("tags", bi.a(arrayList));
                                        be unused = TagManager.this.f16112a;
                                        String[] strArr2 = strArr;
                                        Application a11 = y.a();
                                        result = new ITagManager.Result(g.a(d10, "https://msg.umengcloud.com/v3/tag/add", UMUtils.getAppkey(a11)));
                                        if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
                                            MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a11);
                                            instance.a(strArr2);
                                            instance.a(result.remain);
                                            instance.a("tag_add_", result.interval);
                                        }
                                    } catch (Exception e10) {
                                        e = e10;
                                        UPLog.e("TagManager", (Throwable) e);
                                        result = result2;
                                        z10 = false;
                                        uPushTagCallback.onMessage(z10, result);
                                        return;
                                    }
                                    try {
                                        z10 = result.status.equals(ITagManager.SUCCESS);
                                    } catch (Exception e11) {
                                        e = e11;
                                        result2 = result;
                                        UPLog.e("TagManager", (Throwable) e);
                                        result = result2;
                                        z10 = false;
                                        uPushTagCallback.onMessage(z10, result);
                                        return;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        result2 = result;
                                        try {
                                            UPLog.e("TagManager", th);
                                            try {
                                                uPushTagCallback.onMessage(false, result2);
                                                return;
                                            } catch (Throwable th9) {
                                                UPLog.e("TagManager", th9);
                                                return;
                                            }
                                        } catch (Throwable th10) {
                                            UPLog.e("TagManager", th10);
                                        }
                                    }
                                    try {
                                        uPushTagCallback.onMessage(z10, result);
                                        return;
                                    } catch (Throwable th11) {
                                        UPLog.e("TagManager", th11);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    UPLog.e("TagManager", "No tags");
                    result2.setErrors("No tags");
                    try {
                        uPushTagCallback.onMessage(false, result2);
                        return;
                    } catch (Throwable th12) {
                        UPLog.e("TagManager", th12);
                        return;
                    }
                } catch (Throwable th13) {
                    th = th13;
                    UPLog.e("TagManager", th);
                    uPushTagCallback.onMessage(false, result2);
                    return;
                }
                throw th;
            }
        });
    }

    public void deleteTags(final UPushTagCallback<ITagManager.Result> uPushTagCallback, final String... strArr) {
        b.b(new Runnable() {
            public final void run() {
                ITagManager.Result result;
                String str;
                ITagManager.Result result2 = new ITagManager.Result();
                boolean z10 = false;
                Application a10 = y.a();
                String[] strArr = strArr;
                if (strArr != null && strArr.length > 0) {
                    int length = strArr.length;
                    int i10 = 0;
                    while (i10 < length) {
                        byte[] bytes = strArr[i10].getBytes();
                        if (bytes != null && bytes.length <= 128) {
                            if (bytes.length > 0) {
                                i10++;
                            }
                        }
                        result2.setErrors("tag length must be 1~128 byte.");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th) {
                            UPLog.e("TagManager", th);
                            return;
                        }
                    }
                }
                try {
                    if (!MessageSharedPrefs.getInstance(a10).a("tag_del_")) {
                        UPLog.e("TagManager", "interval limit");
                        result2.setErrors("interval limit");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    } else if (TagManager.b()) {
                        result2.setErrors("tag server disable.");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th3) {
                            UPLog.e("TagManager", th3);
                            return;
                        }
                    } else if (TagManager.a()) {
                        result2.setErrors("check request failed.");
                        try {
                            uPushTagCallback.onMessage(false, result2);
                            return;
                        } catch (Throwable th4) {
                            UPLog.e("TagManager", th4);
                            return;
                        }
                    } else {
                        String[] strArr2 = strArr;
                        if (strArr2 == null || strArr2.length == 0) {
                            UPLog.e("TagManager", "No tags.");
                            result2.setErrors("No tags.");
                            try {
                                uPushTagCallback.onMessage(true, result2);
                                return;
                            } catch (Throwable th5) {
                                UPLog.e("TagManager", th5);
                                return;
                            }
                        } else {
                            try {
                                JSONObject d10 = TagManager.d();
                                String[] strArr3 = strArr;
                                if (strArr3 == null) {
                                    str = "";
                                } else {
                                    str = bi.a(Arrays.asList(strArr3));
                                }
                                d10.put("tags", str);
                                be unused = TagManager.this.f16112a;
                                String[] strArr4 = strArr;
                                Application a11 = y.a();
                                result = new ITagManager.Result(g.a(d10, "https://msg.umengcloud.com/v3/tag/delete", UMUtils.getAppkey(a11)));
                                if (TextUtils.equals(result.status, ITagManager.SUCCESS)) {
                                    MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a11);
                                    if (strArr4 != null) {
                                        if (strArr4.length != 0) {
                                            Set<String> b10 = instance.f15211b.b("tags", (Set<String>) new HashSet());
                                            for (String remove : strArr4) {
                                                b10.remove(remove);
                                            }
                                            instance.f15211b.a("tags", b10);
                                        }
                                    }
                                    instance.a(result.remain);
                                    instance.a("tag_del_", result.interval);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                UPLog.e("TagManager", (Throwable) e);
                                result = result2;
                                uPushTagCallback.onMessage(z10, result);
                                return;
                            }
                            try {
                                z10 = result.status.equals(ITagManager.SUCCESS);
                            } catch (Exception e11) {
                                e = e11;
                                result2 = result;
                                UPLog.e("TagManager", (Throwable) e);
                                result = result2;
                                uPushTagCallback.onMessage(z10, result);
                                return;
                            } catch (Throwable th6) {
                                th = th6;
                                result2 = result;
                                try {
                                    UPLog.e("TagManager", th);
                                    try {
                                        uPushTagCallback.onMessage(false, result2);
                                        return;
                                    } catch (Throwable th7) {
                                        UPLog.e("TagManager", th7);
                                        return;
                                    }
                                } catch (Throwable th8) {
                                    UPLog.e("TagManager", th8);
                                }
                            }
                            try {
                                uPushTagCallback.onMessage(z10, result);
                                return;
                            } catch (Throwable th9) {
                                UPLog.e("TagManager", th9);
                                return;
                            }
                        }
                    }
                } catch (Throwable th10) {
                    th = th10;
                    UPLog.e("TagManager", th);
                    uPushTagCallback.onMessage(false, result2);
                    return;
                }
                throw th;
            }
        });
    }

    public void getTags(final UPushTagCallback<List<String>> uPushTagCallback) {
        b.b(new Runnable() {
            public final void run() {
                boolean z10;
                Pair pair;
                ArrayList arrayList = new ArrayList();
                boolean z11 = false;
                try {
                    if (!MessageSharedPrefs.getInstance(y.a()).a("tag_add_")) {
                        UPLog.e("TagManager", "interval limit");
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th) {
                            UPLog.e("TagManager", th);
                            return;
                        }
                    } else if (TagManager.b()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th2) {
                            UPLog.e("TagManager", th2);
                            return;
                        }
                    } else if (TagManager.a()) {
                        try {
                            uPushTagCallback.onMessage(false, arrayList);
                            return;
                        } catch (Throwable th3) {
                            UPLog.e("TagManager", th3);
                            return;
                        }
                    } else {
                        try {
                            be unused = TagManager.this.f16112a;
                            JSONObject d10 = TagManager.d();
                            Application a10 = y.a();
                            JSONObject a11 = g.a(d10, "https://msg.umengcloud.com/v3/tag/get", UMUtils.getAppkey(a10));
                            if (a11 == null) {
                                pair = new Pair(Boolean.FALSE, (Object) null);
                            } else {
                                ITagManager.Result result = new ITagManager.Result(a11);
                                boolean equals = TextUtils.equals(result.status, ITagManager.SUCCESS);
                                if (equals) {
                                    MessageSharedPrefs instance = MessageSharedPrefs.getInstance(a10);
                                    instance.a(result.remain);
                                    instance.a("tag_get_", result.interval);
                                    String optString = a11.optString("tags");
                                    if (optString.length() > 0) {
                                        String[] split = optString.split(",");
                                        List asList = Arrays.asList(split);
                                        instance.f15211b.a("tags");
                                        instance.a(split);
                                        pair = new Pair(Boolean.TRUE, asList);
                                    }
                                }
                                pair = new Pair(Boolean.valueOf(equals), (Object) null);
                            }
                            z10 = ((Boolean) pair.first).booleanValue();
                            try {
                                List list = (List) pair.second;
                                if (list != null && !list.isEmpty()) {
                                    arrayList.addAll(list);
                                }
                            } catch (Exception e10) {
                                e = e10;
                                try {
                                    UPLog.e("TagManager", "getTags error:", e);
                                    uPushTagCallback.onMessage(z10, arrayList);
                                    return;
                                } catch (Throwable th4) {
                                    th = th4;
                                    z11 = z10;
                                    try {
                                        UPLog.e("TagManager", th);
                                        try {
                                            uPushTagCallback.onMessage(z11, arrayList);
                                            return;
                                        } catch (Throwable th5) {
                                            UPLog.e("TagManager", th5);
                                            return;
                                        }
                                    } catch (Throwable th6) {
                                        UPLog.e("TagManager", th6);
                                    }
                                }
                            }
                        } catch (Exception e11) {
                            e = e11;
                            z10 = false;
                            UPLog.e("TagManager", "getTags error:", e);
                            uPushTagCallback.onMessage(z10, arrayList);
                            return;
                        }
                        try {
                            uPushTagCallback.onMessage(z10, arrayList);
                            return;
                        } catch (Throwable th7) {
                            UPLog.e("TagManager", th7);
                            return;
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    UPLog.e("TagManager", th);
                    uPushTagCallback.onMessage(z11, arrayList);
                    return;
                }
                throw th;
            }
        });
    }

    public static /* synthetic */ boolean a() {
        if (TextUtils.isEmpty(d.o(y.a()))) {
            UPLog.e("TagManager", "utdid empty.");
            return true;
        } else if (f.b()) {
            UPLog.i("TagManager", "check tag failed, silent mode!");
            return true;
        } else if (!TextUtils.isEmpty(PushAgent.getInstance(y.a()).getRegistrationId())) {
            return false;
        } else {
            UPLog.e("TagManager", "deviceToken empty.");
            return true;
        }
    }
}
