package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ErrorCode;
import com.taobao.accs.antibrush.AntiBrush;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.data.Message;
import com.taobao.accs.flowcontrol.FlowControl;
import com.taobao.accs.net.a;
import com.taobao.accs.ut.a.b;
import com.taobao.accs.ut.a.e;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.k;
import com.taobao.accs.utl.p;
import com.taobao.accs.utl.s;
import com.umeng.message.common.inter.ITagManager;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentMap<String, ScheduledFuture<?>> f12971a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    public int f12972b;

    /* renamed from: c  reason: collision with root package name */
    protected TrafficsMonitor f12973c;

    /* renamed from: d  reason: collision with root package name */
    public FlowControl f12974d;

    /* renamed from: e  reason: collision with root package name */
    public AntiBrush f12975e;

    /* renamed from: f  reason: collision with root package name */
    public String f12976f = "";

    /* renamed from: g  reason: collision with root package name */
    private ConcurrentMap<Message.Id, Message> f12977g = new ConcurrentHashMap();

    /* renamed from: h  reason: collision with root package name */
    private boolean f12978h = false;

    /* renamed from: i  reason: collision with root package name */
    private Context f12979i;

    /* renamed from: j  reason: collision with root package name */
    private com.taobao.accs.ut.a.d f12980j;

    /* renamed from: k  reason: collision with root package name */
    private Message f12981k;

    /* renamed from: l  reason: collision with root package name */
    private a f12982l;

    /* renamed from: m  reason: collision with root package name */
    private String f12983m = "MsgRecv_";

    /* renamed from: n  reason: collision with root package name */
    private LinkedHashMap<String, String> f12984n = new MessageHandler$1(this);

    /* renamed from: o  reason: collision with root package name */
    private Map<String, a> f12985o = new HashMap();

    /* renamed from: p  reason: collision with root package name */
    private Runnable f12986p = new f(this);

    public d(Context context, a aVar) {
        String str;
        this.f12979i = context;
        this.f12982l = aVar;
        this.f12973c = new TrafficsMonitor(context);
        this.f12974d = new FlowControl(this.f12979i);
        this.f12975e = new AntiBrush(this.f12979i);
        if (aVar == null) {
            str = this.f12983m;
        } else {
            str = this.f12983m + aVar.f13037m;
        }
        this.f12983m = str;
        i();
        h();
    }

    private boolean b(int i10) {
        return i10 == -1 || i10 == -9 || i10 == -10 || i10 == -11;
    }

    private void i() {
        try {
            File dir = this.f12979i.getDir("accs", 0);
            File file = new File(dir, Constants.SHARED_MESSAGE_ID_FILE + this.f12982l.i());
            if (!file.exists()) {
                ALog.d(this.f12983m, "message file not exist", new Object[0]);
                return;
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    this.f12984n.put(readLine, readLine);
                } else {
                    bufferedReader.close();
                    return;
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    private void j() {
        try {
            File dir = this.f12979i.getDir("accs", 0);
            FileWriter fileWriter = new FileWriter(new File(dir, Constants.SHARED_MESSAGE_ID_FILE + this.f12982l.i()));
            fileWriter.write("");
            for (String append : this.f12984n.keySet()) {
                fileWriter.append(append).append("\r\n");
            }
            fileWriter.close();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public void a(byte[] bArr) {
        a(bArr, (String) null);
    }

    public boolean c() {
        return this.f12978h;
    }

    public int d() {
        return this.f12977g.size();
    }

    public Collection<Message> e() {
        return this.f12977g.values();
    }

    public Set<Message.Id> f() {
        return this.f12977g.keySet();
    }

    public com.taobao.accs.ut.a.d g() {
        return this.f12980j;
    }

    public void h() {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(this.f12986p);
        } catch (Throwable th) {
            ALog.e(this.f12983m, "restoreTraffics", th, new Object[0]);
        }
    }

    private boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f12984n.containsKey(str);
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str) && !this.f12984n.containsKey(str)) {
            this.f12984n.put(str, str);
            j();
        }
    }

    public void a(byte[] bArr, String str) {
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(this.f12983m, "onMessage", Constants.KEY_HOST, str);
        }
        s sVar = new s(bArr);
        try {
            int a10 = sVar.a();
            int i10 = (a10 & 240) >> 4;
            ALog.Level level = ALog.Level.D;
            if (ALog.isPrintLog(level)) {
                String str2 = this.f12983m;
                ALog.d(str2, "version:" + i10, new Object[0]);
            }
            int i11 = a10 & 15;
            if (ALog.isPrintLog(level)) {
                String str3 = this.f12983m;
                ALog.d(str3, "compress:" + i11, new Object[0]);
            }
            sVar.a();
            int b10 = sVar.b();
            if (ALog.isPrintLog(level)) {
                String str4 = this.f12983m;
                ALog.d(str4, "totalLen:" + b10, new Object[0]);
            }
            int i12 = 0;
            while (i12 < b10) {
                int b11 = sVar.b();
                int i13 = i12 + 2;
                if (b11 > 0) {
                    byte[] bArr2 = new byte[b11];
                    sVar.read(bArr2);
                    if (ALog.isPrintLog(ALog.Level.D)) {
                        String str5 = this.f12983m;
                        ALog.d(str5, "buf len:" + b11, new Object[0]);
                    }
                    i12 = i13 + b11;
                    a(i11, bArr2, str, i10);
                } else {
                    throw new IOException("data format error");
                }
            }
        } catch (Throwable th) {
            sVar.close();
            throw th;
        }
        sVar.close();
    }

    public void b() {
        ALog.d(this.f12983m, "onRcvPing", new Object[0]);
        synchronized (d.class) {
            this.f12978h = false;
        }
    }

    private Intent c(Message message) {
        Intent intent = new Intent(Constants.ACTION_RECEIVE);
        intent.setPackage(message.f12942m);
        intent.putExtra("command", message.command);
        intent.putExtra(Constants.KEY_SERVICE_ID, message.serviceId);
        intent.putExtra(Constants.KEY_USER_ID, message.userinfo);
        Integer num = message.command;
        if (num != null && num.intValue() == 100) {
            intent.putExtra(Constants.KEY_DATA_ID, message.cunstomDataId);
        }
        NetPerformanceMonitor netPerformanceMonitor = message.G;
        if (netPerformanceMonitor != null) {
            intent.putExtra(Constants.KEY_MONIROT, netPerformanceMonitor);
        }
        return intent;
    }

    public void b(Message message) {
        if (this.f12977g.keySet().size() > 0) {
            for (Message.Id id : this.f12977g.keySet()) {
                Message message2 = this.f12977g.get(id);
                if (!(message2 == null || message2.command == null || !message2.getPackageName().equals(message.getPackageName()))) {
                    switch (message.command.intValue()) {
                        case 1:
                        case 2:
                            if (message2.command.intValue() == 1 || message2.command.intValue() == 2) {
                                message2.isCancel = true;
                                break;
                            }
                        case 3:
                        case 4:
                            if (message2.command.intValue() == 3 || message2.command.intValue() == 4) {
                                message2.isCancel = true;
                                break;
                            }
                        case 5:
                        case 6:
                            if (message2.command.intValue() == 5 || message2.command.intValue() == 6) {
                                message2.isCancel = true;
                                break;
                            }
                    }
                }
                if (message2 != null && message2.isCancel) {
                    ALog.e(this.f12983m, "cancelControlMessage", "command", message2.command);
                }
            }
        }
    }

    public Message b(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f12977g.remove(new Message.Id(0, str));
        }
        return null;
    }

    private void b(Message message, int i10) {
        if (message != null) {
            String j10 = UtilityImpl.j(this.f12979i);
            String str = System.currentTimeMillis() + "";
            boolean z10 = i10 == 200;
            int intValue = message.command.intValue();
            if (intValue == 1) {
                com.taobao.accs.ut.a.a aVar = new com.taobao.accs.ut.a.a();
                aVar.f13119a = j10;
                aVar.f13120b = str;
                aVar.f13121c = z10;
                aVar.a(i10);
                aVar.a();
            } else if (intValue == 3) {
                b bVar = new b();
                bVar.f13125a = j10;
                bVar.f13126b = str;
                bVar.f13127c = z10;
                bVar.f13129e = message.userinfo;
                bVar.a(i10);
                bVar.a();
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.taobao.accs.ut.a.d} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v71, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v45, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v72, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v46, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: int} */
    /* JADX WARNING: type inference failed for: r16v0, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r9v9, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r1v19, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v10 */
    /* JADX WARNING: type inference failed for: r9v11, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r5v37, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r6v20, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r3v82, types: [java.util.Map] */
    /* JADX WARNING: type inference failed for: r9v16 */
    /* JADX WARNING: type inference failed for: r9v17 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02fe A[Catch:{ Exception -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0314 A[Catch:{ Exception -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0365 A[Catch:{ Exception -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0370 A[Catch:{ Exception -> 0x0360 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x05f1 A[Catch:{ Exception -> 0x0669 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x065b A[Catch:{ Exception -> 0x069f }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:227:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0234 A[Catch:{ Exception -> 0x015b }] */
    /* JADX WARNING: Unknown variable types count: 5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r48, byte[] r49, java.lang.String r50, int r51) {
        /*
            r47 = this;
            r7 = r47
            r0 = r48
            r8 = r49
            r15 = r50
            java.lang.String r9 = "agooSend"
            java.lang.String r14 = "1"
            java.lang.String r13 = "send_fail"
            java.lang.String r12 = ""
            java.lang.String r11 = "accs"
            com.taobao.accs.utl.s r1 = new com.taobao.accs.utl.s
            r1.<init>(r8)
            int r2 = r1.b()
            long r5 = (long) r2
            com.taobao.accs.utl.ALog$Level r2 = com.taobao.accs.utl.ALog.Level.D
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r3 == 0) goto L_0x0045
            java.lang.String r3 = r7.f12983m
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r10 = "flag:"
            r4.append(r10)
            int r10 = (int) r5
            java.lang.String r10 = java.lang.Integer.toHexString(r10)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r17 = r13
            r10 = 0
            java.lang.Object[] r13 = new java.lang.Object[r10]
            com.taobao.accs.utl.ALog.d(r3, r4, r13)
            goto L_0x0047
        L_0x0045:
            r17 = r13
        L_0x0047:
            int r3 = r1.a()
            java.lang.String r10 = r1.a(r3)
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r3 == 0) goto L_0x0071
            java.lang.String r3 = r7.f12983m
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r13 = "target:"
            r4.append(r13)
            r4.append(r10)
            java.lang.String r4 = r4.toString()
            r18 = r14
            r13 = 0
            java.lang.Object[] r14 = new java.lang.Object[r13]
            com.taobao.accs.utl.ALog.d(r3, r4, r14)
            goto L_0x0073
        L_0x0071:
            r18 = r14
        L_0x0073:
            int r3 = r1.a()
            java.lang.String r13 = r1.a(r3)
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r3 == 0) goto L_0x009d
            java.lang.String r3 = r7.f12983m
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r14 = "source:"
            r4.append(r14)
            r4.append(r13)
            java.lang.String r4 = r4.toString()
            r19 = r12
            r14 = 0
            java.lang.Object[] r12 = new java.lang.Object[r14]
            com.taobao.accs.utl.ALog.d(r3, r4, r12)
            goto L_0x009f
        L_0x009d:
            r19 = r12
        L_0x009f:
            int r3 = r1.a()     // Catch:{ Exception -> 0x06e9 }
            java.lang.String r12 = r1.a(r3)     // Catch:{ Exception -> 0x06e9 }
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r2)
            if (r3 == 0) goto L_0x00c9
            java.lang.String r3 = r7.f12983m
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r14 = "dataId:"
            r4.append(r14)
            r4.append(r12)
            java.lang.String r4 = r4.toString()
            r20 = r11
            r14 = 0
            java.lang.Object[] r11 = new java.lang.Object[r14]
            com.taobao.accs.utl.ALog.d(r3, r4, r11)
            goto L_0x00cb
        L_0x00c9:
            r20 = r11
        L_0x00cb:
            java.lang.String r3 = "4|sal|st"
            boolean r3 = r13.contains(r3)
            if (r3 != 0) goto L_0x06c5
            java.lang.String r3 = "4|sal|fg"
            boolean r3 = r13.contains(r3)
            if (r3 != 0) goto L_0x06c5
            java.lang.String r3 = "4|sal|bg"
            boolean r3 = r13.contains(r3)
            if (r3 == 0) goto L_0x00e5
            goto L_0x06c5
        L_0x00e5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            r3.append(r12)
            java.lang.String r11 = r3.toString()
            int r3 = r1.available()
            r4 = 2
            r14 = 1
            if (r3 <= 0) goto L_0x0141
            r3 = r51
            if (r3 != r4) goto L_0x0124
            java.util.Map r3 = r7.a((com.taobao.accs.utl.s) r1)
            if (r3 == 0) goto L_0x0121
            r22 = 16
            java.lang.Integer r4 = java.lang.Integer.valueOf(r22)
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0121
            r4 = 17
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r3.containsKey(r4)
            if (r4 == 0) goto L_0x0121
            r4 = r3
            r3 = 1
            goto L_0x0126
        L_0x0121:
            r4 = r3
            r3 = 0
            goto L_0x0126
        L_0x0124:
            r3 = 0
            r4 = 0
        L_0x0126:
            if (r0 == 0) goto L_0x0136
            if (r3 == 0) goto L_0x012b
            goto L_0x0136
        L_0x012b:
            if (r0 != r14) goto L_0x0132
            byte[] r22 = r7.a((java.io.InputStream) r1)
            goto L_0x013a
        L_0x0132:
            r22 = r3
            r3 = 0
            goto L_0x0145
        L_0x0136:
            byte[] r22 = r1.c()
        L_0x013a:
            r46 = r22
            r22 = r3
            r3 = r46
            goto L_0x0145
        L_0x0141:
            r3 = 0
            r4 = 0
            r22 = 0
        L_0x0145:
            r1.close()
            java.lang.String r1 = "handleMessage"
            if (r3 != 0) goto L_0x0166
            java.lang.String r14 = r7.f12983m     // Catch:{ Exception -> 0x015b }
            r51 = r4
            java.lang.String r4 = "oriData is null"
            r25 = r13
            r13 = 0
            java.lang.Object[] r0 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x015b }
            com.taobao.accs.utl.ALog.d(r14, r4, r0)     // Catch:{ Exception -> 0x015b }
            goto L_0x018d
        L_0x015b:
            r0 = move-exception
            r45 = r1
        L_0x015e:
            r2 = r18
            r6 = r19
            r1 = r20
            goto L_0x06a0
        L_0x0166:
            r51 = r4
            r25 = r13
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ Exception -> 0x015b }
            if (r0 == 0) goto L_0x018d
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x015b }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x015b }
            r4.<init>()     // Catch:{ Exception -> 0x015b }
            java.lang.String r13 = "oriData:"
            r4.append(r13)     // Catch:{ Exception -> 0x015b }
            java.lang.String r13 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x015b }
            r4.append(r13)     // Catch:{ Exception -> 0x015b }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x015b }
            r13 = 0
            java.lang.Object[] r14 = new java.lang.Object[r13]     // Catch:{ Exception -> 0x015b }
            com.taobao.accs.utl.ALog.d(r0, r4, r14)     // Catch:{ Exception -> 0x015b }
        L_0x018d:
            r0 = 15
            long r13 = r5 >> r0
            r26 = 1
            long r13 = r13 & r26
            int r0 = (int) r13     // Catch:{ Exception -> 0x015b }
            int r0 = com.taobao.accs.data.Message.MsgType.valueOf(r0)     // Catch:{ Exception -> 0x015b }
            r4 = 13
            long r13 = r5 >> r4
            r28 = 3
            long r13 = r13 & r28
            int r4 = (int) r13     // Catch:{ Exception -> 0x015b }
            com.taobao.accs.data.Message$ReqType r13 = com.taobao.accs.data.Message.ReqType.valueOf((int) r4)     // Catch:{ Exception -> 0x015b }
            r4 = 12
            long r28 = r5 >> r4
            long r14 = r28 & r26
            int r4 = (int) r14     // Catch:{ Exception -> 0x015b }
            r14 = 11
            long r14 = r5 >> r14
            long r14 = r14 & r26
            int r15 = (int) r14     // Catch:{ Exception -> 0x015b }
            int r14 = com.taobao.accs.data.Message.MsgResType.valueOf(r15)     // Catch:{ Exception -> 0x015b }
            r15 = 6
            long r28 = r5 >> r15
            r30 = r5
            long r5 = r28 & r26
            int r6 = (int) r5     // Catch:{ Exception -> 0x015b }
            r5 = 1
            if (r6 != r5) goto L_0x01c6
            r6 = 1
            goto L_0x01c7
        L_0x01c6:
            r6 = 0
        L_0x01c7:
            com.taobao.accs.utl.ALog$Level r5 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ Exception -> 0x015b }
            boolean r5 = com.taobao.accs.utl.ALog.isPrintLog(r5)     // Catch:{ Exception -> 0x015b }
            java.lang.String r15 = "accs-impaas"
            java.lang.String r27 = "target"
            r28 = 5
            r29 = r11
            java.lang.String r11 = "dataId"
            if (r5 != 0) goto L_0x01e6
            boolean r5 = r10.contains(r15)     // Catch:{ Exception -> 0x015b }
            if (r5 == 0) goto L_0x01e0
            goto L_0x01e6
        L_0x01e0:
            r34 = r6
            r5 = 1
            r23 = 2
            goto L_0x022a
        L_0x01e6:
            java.lang.String r5 = r7.f12983m     // Catch:{ Exception -> 0x015b }
            r34 = r6
            r6 = 10
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x015b }
            r16 = 0
            r6[r16] = r11     // Catch:{ Exception -> 0x015b }
            r24 = 1
            r6[r24] = r12     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = "type"
            r23 = 2
            r6[r23] = r35     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = com.taobao.accs.data.Message.MsgType.name(r0)     // Catch:{ Exception -> 0x015b }
            r33 = 3
            r6[r33] = r35     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = "reqType"
            r32 = 4
            r6[r32] = r35     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = r13.name()     // Catch:{ Exception -> 0x015b }
            r6[r28] = r35     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = "resType"
            r26 = 6
            r6[r26] = r35     // Catch:{ Exception -> 0x015b }
            java.lang.String r35 = com.taobao.accs.data.Message.MsgResType.name(r14)     // Catch:{ Exception -> 0x015b }
            r36 = 7
            r6[r36] = r35     // Catch:{ Exception -> 0x015b }
            r35 = 8
            r6[r35] = r27     // Catch:{ Exception -> 0x015b }
            r35 = 9
            r6[r35] = r10     // Catch:{ Exception -> 0x015b }
            com.taobao.accs.utl.ALog.e(r5, r1, r6)     // Catch:{ Exception -> 0x015b }
            r5 = 1
        L_0x022a:
            if (r0 != r5) goto L_0x02fe
            com.taobao.accs.data.Message$ReqType r5 = com.taobao.accs.data.Message.ReqType.ACK     // Catch:{ Exception -> 0x015b }
            if (r13 == r5) goto L_0x0234
            com.taobao.accs.data.Message$ReqType r5 = com.taobao.accs.data.Message.ReqType.RES     // Catch:{ Exception -> 0x015b }
            if (r13 != r5) goto L_0x02fe
        L_0x0234:
            java.util.concurrent.ConcurrentMap<com.taobao.accs.data.Message$Id, com.taobao.accs.data.Message> r5 = r7.f12977g     // Catch:{ Exception -> 0x015b }
            com.taobao.accs.data.Message$Id r6 = new com.taobao.accs.data.Message$Id     // Catch:{ Exception -> 0x015b }
            r35 = r1
            r1 = 0
            r6.<init>(r1, r12)     // Catch:{ Exception -> 0x02f3 }
            java.lang.Object r1 = r5.remove(r6)     // Catch:{ Exception -> 0x02f3 }
            r6 = r1
            com.taobao.accs.data.Message r6 = (com.taobao.accs.data.Message) r6     // Catch:{ Exception -> 0x02f3 }
            if (r6 == 0) goto L_0x02d2
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r2)     // Catch:{ Exception -> 0x02f3 }
            if (r1 == 0) goto L_0x025a
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x02f3 }
            java.lang.String r2 = "handleMessage reqMessage not null"
            r36 = r15
            r5 = 0
            java.lang.Object[] r15 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x02f3 }
            com.taobao.accs.utl.ALog.d(r1, r2, r15)     // Catch:{ Exception -> 0x02f3 }
            goto L_0x025c
        L_0x025a:
            r36 = r15
        L_0x025c:
            r1 = 1
            if (r4 != r1) goto L_0x0274
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0271 }
            java.lang.String r2 = new java.lang.String     // Catch:{ Exception -> 0x0271 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0271 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0271 }
            java.lang.String r2 = "code"
            int r1 = r1.getInt(r2)     // Catch:{ Exception -> 0x0271 }
            r4 = r1
            goto L_0x0278
        L_0x0271:
            r1 = -3
            r4 = -3
            goto L_0x0278
        L_0x0274:
            r1 = 200(0xc8, float:2.8E-43)
            r4 = 200(0xc8, float:2.8E-43)
        L_0x0278:
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r1 = r6.getNetPermanceMonitor()     // Catch:{ Exception -> 0x02f3 }
            if (r1 == 0) goto L_0x0285
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r1 = r6.getNetPermanceMonitor()     // Catch:{ Exception -> 0x02f3 }
            r1.onRecAck()     // Catch:{ Exception -> 0x02f3 }
        L_0x0285:
            com.taobao.accs.data.Message$ReqType r1 = com.taobao.accs.data.Message.ReqType.RES     // Catch:{ Exception -> 0x02f3 }
            if (r13 != r1) goto L_0x02a8
            r15 = r35
            r1 = r47
            r2 = r6
            r35 = r3
            r3 = r4
            r5 = r51
            r51 = r15
            r15 = 2
            r4 = r13
            r23 = r5
            r37 = r30
            r5 = r35
            r15 = r6
            r39 = r34
            r6 = r23
            r1.a(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0360 }
            r5 = r23
            goto L_0x02b6
        L_0x02a8:
            r5 = r51
            r15 = r6
            r37 = r30
            r39 = r34
            r51 = r35
            r35 = r3
            r7.a((com.taobao.accs.data.Message) r15, (int) r4, (java.util.Map<java.lang.Integer, java.lang.String>) r5)     // Catch:{ Exception -> 0x0360 }
        L_0x02b6:
            com.taobao.accs.ut.monitor.TrafficsMonitor$a r6 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a     // Catch:{ Exception -> 0x0360 }
            java.lang.String r2 = r15.serviceId     // Catch:{ Exception -> 0x0360 }
            boolean r3 = anet.channel.GlobalAppRuntimeInfo.isAppBackground()     // Catch:{ Exception -> 0x0360 }
            int r1 = r8.length     // Catch:{ Exception -> 0x0360 }
            r23 = r14
            long r14 = (long) r1     // Catch:{ Exception -> 0x0360 }
            r1 = r6
            r4 = r50
            r40 = r5
            r31 = r9
            r9 = r6
            r5 = r14
            r1.<init>(r2, r3, r4, r5)     // Catch:{ Exception -> 0x0360 }
            r7.a((com.taobao.accs.ut.monitor.TrafficsMonitor.a) r9)     // Catch:{ Exception -> 0x0360 }
            goto L_0x030e
        L_0x02d2:
            r40 = r51
            r23 = r14
            r36 = r15
            r37 = r30
            r39 = r34
            r51 = r35
            r35 = r3
            r31 = r9
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r2 = "handleMessage data ack/res reqMessage is null"
            r3 = 2
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0360 }
            r3 = 0
            r4[r3] = r11     // Catch:{ Exception -> 0x0360 }
            r3 = 1
            r4[r3] = r12     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r1, r2, r4)     // Catch:{ Exception -> 0x0360 }
            goto L_0x030e
        L_0x02f3:
            r0 = move-exception
            r2 = r18
            r6 = r19
            r1 = r20
            r45 = r35
            goto L_0x06a0
        L_0x02fe:
            r40 = r51
            r51 = r1
            r35 = r3
            r23 = r14
            r36 = r15
            r37 = r30
            r39 = r34
            r31 = r9
        L_0x030e:
            if (r0 != 0) goto L_0x0365
            com.taobao.accs.data.Message$ReqType r1 = com.taobao.accs.data.Message.ReqType.RES     // Catch:{ Exception -> 0x0360 }
            if (r13 != r1) goto L_0x0365
            java.util.concurrent.ConcurrentMap<com.taobao.accs.data.Message$Id, com.taobao.accs.data.Message> r1 = r7.f12977g     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.data.Message$Id r2 = new com.taobao.accs.data.Message$Id     // Catch:{ Exception -> 0x0360 }
            r3 = 0
            r2.<init>(r3, r12)     // Catch:{ Exception -> 0x0360 }
            java.lang.Object r1 = r1.remove(r2)     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.data.Message r1 = (com.taobao.accs.data.Message) r1     // Catch:{ Exception -> 0x0360 }
            if (r1 == 0) goto L_0x032c
            r6 = r50
            r2 = r35
            r7.a((com.taobao.accs.data.Message) r1, (byte[]) r2, (byte[]) r8, (java.lang.String) r6)     // Catch:{ Exception -> 0x0360 }
            return
        L_0x032c:
            r6 = r50
            r2 = r35
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r3 = "handleMessage contorl ACK reqMessage is null"
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0360 }
            r4 = 0
            r5[r4] = r11     // Catch:{ Exception -> 0x0360 }
            r4 = 1
            r5[r4] = r12     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r1, r3, r5)     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog$Level r1 = com.taobao.accs.utl.ALog.Level.D     // Catch:{ Exception -> 0x0360 }
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r1)     // Catch:{ Exception -> 0x0360 }
            if (r1 == 0) goto L_0x0369
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r3 = "handleMessage not handled"
            r4 = 2
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0360 }
            java.lang.String r4 = "body"
            r9 = 0
            r5[r9] = r4     // Catch:{ Exception -> 0x0360 }
            java.lang.String r4 = new java.lang.String     // Catch:{ Exception -> 0x0360 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0360 }
            r9 = 1
            r5[r9] = r4     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.d(r1, r3, r5)     // Catch:{ Exception -> 0x0360 }
            goto L_0x0369
        L_0x0360:
            r0 = move-exception
            r45 = r51
            goto L_0x015e
        L_0x0365:
            r6 = r50
            r2 = r35
        L_0x0369:
            r1 = 1
            if (r0 != r1) goto L_0x06c4
            com.taobao.accs.data.Message$ReqType r0 = com.taobao.accs.data.Message.ReqType.DATA     // Catch:{ Exception -> 0x0360 }
            if (r13 != r0) goto L_0x06c4
            if (r10 != 0) goto L_0x037d
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r1 = "handleMessage target is null"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ Exception -> 0x0360 }
            return
        L_0x037d:
            java.lang.String r0 = "\\|"
            java.lang.String[] r0 = r10.split(r0)     // Catch:{ Exception -> 0x0360 }
            int r1 = r0.length     // Catch:{ Exception -> 0x0360 }
            r3 = 2
            if (r1 >= r3) goto L_0x0392
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r1 = "handleMessage target length is invalid"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ Exception -> 0x0360 }
            return
        L_0x0392:
            com.taobao.accs.utl.ALog$Level r1 = com.taobao.accs.utl.ALog.Level.D     // Catch:{ Exception -> 0x0360 }
            boolean r3 = com.taobao.accs.utl.ALog.isPrintLog(r1)     // Catch:{ Exception -> 0x0360 }
            if (r3 == 0) goto L_0x03b0
            java.lang.String r3 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r4 = "handleMessage onPush"
            r5 = 2
            java.lang.Object[] r9 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0360 }
            java.lang.String r5 = "isBurstData"
            r13 = 0
            r9[r13] = r5     // Catch:{ Exception -> 0x0360 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r22)     // Catch:{ Exception -> 0x0360 }
            r13 = 1
            r9[r13] = r5     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.d(r3, r4, r9)     // Catch:{ Exception -> 0x0360 }
        L_0x03b0:
            com.taobao.accs.ut.a.d r3 = r7.f12980j     // Catch:{ Exception -> 0x0360 }
            if (r3 == 0) goto L_0x03b7
            r3.a()     // Catch:{ Exception -> 0x0360 }
        L_0x03b7:
            com.taobao.accs.ut.a.d r3 = new com.taobao.accs.ut.a.d     // Catch:{ Exception -> 0x0360 }
            r3.<init>()     // Catch:{ Exception -> 0x0360 }
            r7.f12980j = r3     // Catch:{ Exception -> 0x0360 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0360 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ Exception -> 0x0360 }
            r3.f13145c = r4     // Catch:{ Exception -> 0x0360 }
            android.content.Context r3 = r7.f12979i     // Catch:{ Exception -> 0x0360 }
            r4 = 1
            r5 = r0[r4]     // Catch:{ Exception -> 0x0360 }
            boolean r3 = com.taobao.accs.utl.UtilityImpl.a((android.content.Context) r3, (java.lang.String) r5)     // Catch:{ Exception -> 0x0360 }
            if (r3 == 0) goto L_0x0672
            int r3 = r0.length     // Catch:{ Exception -> 0x0360 }
            r4 = 3
            if (r3 < r4) goto L_0x03dc
            r3 = 2
            r4 = r0[r3]     // Catch:{ Exception -> 0x0360 }
            r15 = r4
            goto L_0x03dd
        L_0x03dc:
            r15 = 0
        L_0x03dd:
            com.taobao.accs.ut.a.d r3 = r7.f12980j     // Catch:{ Exception -> 0x0360 }
            r3.f13147e = r15     // Catch:{ Exception -> 0x0360 }
            r3 = r31
            boolean r4 = r3.equals(r15)     // Catch:{ Exception -> 0x0360 }
            if (r4 != 0) goto L_0x0414
            r4 = r29
            boolean r5 = r7.c((java.lang.String) r4)     // Catch:{ Exception -> 0x0360 }
            if (r5 == 0) goto L_0x0416
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r1 = "handleMessage msg duplicate"
            r2 = 2
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0360 }
            r2 = 0
            r3[r2] = r11     // Catch:{ Exception -> 0x0360 }
            r2 = 1
            r3[r2] = r12     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.ut.a.d r0 = r7.f12980j     // Catch:{ Exception -> 0x0360 }
            r0.f13150h = r2     // Catch:{ Exception -> 0x0360 }
            r13 = r20
            r0 = r23
            r20 = r25
            r8 = r37
            r14 = r39
            r1 = 1
            r27 = 0
            goto L_0x05ef
        L_0x0414:
            r4 = r29
        L_0x0416:
            if (r22 == 0) goto L_0x0462
            r9 = r40
            byte[] r2 = r7.a((java.lang.String) r4, (java.util.Map<java.lang.Integer, java.lang.String>) r9, (byte[]) r2)     // Catch:{ Exception -> 0x0360 }
            if (r2 != 0) goto L_0x042b
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r1 = "handleMessage completeOriData is null"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.e(r0, r1, r3)     // Catch:{ Exception -> 0x0360 }
            return
        L_0x042b:
            r5 = r48
            r13 = 1
            if (r5 != r13) goto L_0x0464
            com.taobao.accs.utl.s r5 = new com.taobao.accs.utl.s     // Catch:{ Exception -> 0x0360 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x0360 }
            byte[] r2 = r7.a((java.io.InputStream) r5)     // Catch:{ Exception -> 0x0360 }
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r1)     // Catch:{ Exception -> 0x0360 }
            if (r1 == 0) goto L_0x045e
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0360 }
            java.lang.String r13 = "handleMessage gzip completeOriData"
            r14 = 4
            java.lang.Object[] r8 = new java.lang.Object[r14]     // Catch:{ Exception -> 0x0360 }
            r14 = 0
            r8[r14] = r11     // Catch:{ Exception -> 0x0360 }
            r14 = 1
            r8[r14] = r4     // Catch:{ Exception -> 0x0360 }
            java.lang.String r14 = "length"
            r22 = 2
            r8[r22] = r14     // Catch:{ Exception -> 0x0360 }
            int r14 = r2.length     // Catch:{ Exception -> 0x0360 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ Exception -> 0x0360 }
            r22 = 3
            r8[r22] = r14     // Catch:{ Exception -> 0x0360 }
            com.taobao.accs.utl.ALog.d(r1, r13, r8)     // Catch:{ Exception -> 0x0360 }
        L_0x045e:
            r5.close()     // Catch:{ Exception -> 0x0360 }
            goto L_0x0464
        L_0x0462:
            r9 = r40
        L_0x0464:
            boolean r1 = r3.equals(r15)     // Catch:{ Exception -> 0x0360 }
            if (r1 != 0) goto L_0x046d
            r7.d(r4)     // Catch:{ Exception -> 0x0360 }
        L_0x046d:
            r13 = r20
            boolean r1 = r13.equals(r15)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "handleMessage try deliverMsg"
            java.lang.String r4 = "serviceId"
            if (r1 == 0) goto L_0x0495
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0669 }
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0669 }
            r8 = 0
            r5[r8] = r11     // Catch:{ Exception -> 0x0669 }
            r8 = 1
            r5[r8] = r12     // Catch:{ Exception -> 0x0669 }
            r14 = 2
            r5[r14] = r27     // Catch:{ Exception -> 0x0669 }
            r14 = r0[r8]     // Catch:{ Exception -> 0x0669 }
            r8 = 3
            r5[r8] = r14     // Catch:{ Exception -> 0x0669 }
            r8 = 4
            r5[r8] = r4     // Catch:{ Exception -> 0x0669 }
            r5[r28] = r15     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.utl.ALog.e(r1, r3, r5)     // Catch:{ Exception -> 0x0669 }
            goto L_0x04b8
        L_0x0495:
            com.taobao.accs.utl.ALog$Level r1 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ Exception -> 0x0669 }
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r1)     // Catch:{ Exception -> 0x0669 }
            if (r1 == 0) goto L_0x04b8
            java.lang.String r1 = r7.f12983m     // Catch:{ Exception -> 0x0669 }
            r5 = 6
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0669 }
            r8 = 0
            r5[r8] = r11     // Catch:{ Exception -> 0x0669 }
            r8 = 1
            r5[r8] = r12     // Catch:{ Exception -> 0x0669 }
            r14 = 2
            r5[r14] = r27     // Catch:{ Exception -> 0x0669 }
            r14 = r0[r8]     // Catch:{ Exception -> 0x0669 }
            r8 = 3
            r5[r8] = r14     // Catch:{ Exception -> 0x0669 }
            r8 = 4
            r5[r8] = r4     // Catch:{ Exception -> 0x0669 }
            r5[r28] = r15     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.utl.ALog.i(r1, r3, r5)     // Catch:{ Exception -> 0x0669 }
        L_0x04b8:
            android.content.Intent r1 = new android.content.Intent     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "com.taobao.accs.intent.action.RECEIVE"
            r1.<init>(r3)     // Catch:{ Exception -> 0x0669 }
            r3 = 1
            r5 = r0[r3]     // Catch:{ Exception -> 0x0669 }
            r1.setPackage(r5)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "command"
            r5 = 101(0x65, float:1.42E-43)
            r1.putExtra(r3, r5)     // Catch:{ Exception -> 0x0669 }
            int r3 = r0.length     // Catch:{ Exception -> 0x0669 }
            r5 = 3
            if (r3 < r5) goto L_0x04d6
            r3 = 2
            r5 = r0[r3]     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r4, r5)     // Catch:{ Exception -> 0x0669 }
        L_0x04d6:
            int r3 = r0.length     // Catch:{ Exception -> 0x0669 }
            r4 = 4
            if (r3 < r4) goto L_0x04e3
            r3 = 3
            r0 = r0[r3]     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "userInfo"
            r1.putExtra(r3, r0)     // Catch:{ Exception -> 0x0669 }
            goto L_0x04e5
        L_0x04e3:
            r0 = r19
        L_0x04e5:
            java.lang.String r3 = "data"
            r1.putExtra(r3, r2)     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r11, r12)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "packageName"
            android.content.Context r4 = r7.f12979i     // Catch:{ Exception -> 0x0669 }
            java.lang.String r4 = r4.getPackageName()     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r3, r4)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "host"
            r1.putExtra(r3, r6)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "conn_type"
            int r4 = r7.f12972b     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r3, r4)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "bizAck"
            r14 = r39
            r1.putExtra(r3, r14)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "appKey"
            com.taobao.accs.net.a r4 = r7.f12982l     // Catch:{ Exception -> 0x0669 }
            java.lang.String r4 = r4.i()     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r3, r4)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "configTag"
            com.taobao.accs.net.a r4 = r7.f12982l     // Catch:{ Exception -> 0x0669 }
            java.lang.String r4 = r4.f13037m     // Catch:{ Exception -> 0x0669 }
            r1.putExtra(r3, r4)     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.ut.monitor.NetPerformanceMonitor r3 = new com.taobao.accs.ut.monitor.NetPerformanceMonitor     // Catch:{ Exception -> 0x0669 }
            r3.<init>()     // Catch:{ Exception -> 0x0669 }
            r4 = 4
            r3.setMsgType(r4)     // Catch:{ Exception -> 0x0669 }
            r3.onReceiveData()     // Catch:{ Exception -> 0x0669 }
            java.lang.String r4 = "monitor"
            r1.putExtra(r4, r3)     // Catch:{ Exception -> 0x0669 }
            r7.a((java.util.Map<java.lang.Integer, java.lang.String>) r9, (android.content.Intent) r1)     // Catch:{ Exception -> 0x0669 }
            if (r14 == 0) goto L_0x053f
            r4 = r37
            int r3 = (int) r4     // Catch:{ Exception -> 0x0669 }
            short r3 = (short) r3     // Catch:{ Exception -> 0x0669 }
            r8 = r25
            r7.a((android.content.Intent) r1, (java.lang.String) r8, (java.lang.String) r10, (short) r3)     // Catch:{ Exception -> 0x0669 }
            goto L_0x0543
        L_0x053f:
            r8 = r25
            r4 = r37
        L_0x0543:
            com.taobao.accs.data.g r3 = com.taobao.accs.data.g.a()     // Catch:{ Exception -> 0x0669 }
            r37 = r4
            android.content.Context r4 = r7.f12979i     // Catch:{ Exception -> 0x0669 }
            r3.b(r4, r1)     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.utl.UTMini r39 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ Exception -> 0x0669 }
            r40 = 66001(0x101d1, float:9.2487E-41)
            java.lang.String r41 = "MsgToBussPush"
            java.lang.String r42 = "commandId=101"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0669 }
            r1.<init>()     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = "serviceId="
            r1.append(r3)     // Catch:{ Exception -> 0x0669 }
            r1.append(r15)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = " dataId="
            r1.append(r3)     // Catch:{ Exception -> 0x0669 }
            r1.append(r12)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r43 = r1.toString()     // Catch:{ Exception -> 0x0669 }
            r1 = 221(0xdd, float:3.1E-43)
            java.lang.Integer r44 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x0669 }
            r39.commitEvent(r40, r41, r42, r43, r44)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r1 = "to_buss"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0669 }
            r3.<init>()     // Catch:{ Exception -> 0x0669 }
            java.lang.String r4 = "1commandId=101serviceId="
            r3.append(r4)     // Catch:{ Exception -> 0x0669 }
            r3.append(r15)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0669 }
            r4 = 0
            com.taobao.accs.utl.k.a(r13, r1, r3, r4)     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.ut.a.d r1 = r7.f12980j     // Catch:{ Exception -> 0x0669 }
            r1.f13144b = r12     // Catch:{ Exception -> 0x0669 }
            r1.f13151i = r0     // Catch:{ Exception -> 0x0669 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0669 }
            r0.<init>()     // Catch:{ Exception -> 0x0669 }
            if (r2 != 0) goto L_0x05a2
            r2 = 0
            goto L_0x05a3
        L_0x05a2:
            int r2 = r2.length     // Catch:{ Exception -> 0x0669 }
        L_0x05a3:
            r0.append(r2)     // Catch:{ Exception -> 0x0669 }
            r3 = r19
            r0.append(r3)     // Catch:{ Exception -> 0x0661 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0661 }
            r1.f13148f = r0     // Catch:{ Exception -> 0x0661 }
            com.taobao.accs.ut.a.d r0 = r7.f12980j     // Catch:{ Exception -> 0x0661 }
            android.content.Context r1 = r7.f12979i     // Catch:{ Exception -> 0x0661 }
            java.lang.String r1 = com.taobao.accs.utl.UtilityImpl.j(r1)     // Catch:{ Exception -> 0x0661 }
            r0.f13143a = r1     // Catch:{ Exception -> 0x0661 }
            com.taobao.accs.ut.a.d r0 = r7.f12980j     // Catch:{ Exception -> 0x0661 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0661 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0661 }
            r0.f13146d = r1     // Catch:{ Exception -> 0x0661 }
            com.taobao.accs.ut.monitor.TrafficsMonitor$a r2 = new com.taobao.accs.ut.monitor.TrafficsMonitor$a     // Catch:{ Exception -> 0x0661 }
            boolean r19 = anet.channel.GlobalAppRuntimeInfo.isAppBackground()     // Catch:{ Exception -> 0x0661 }
            r0 = r49
            int r0 = r0.length     // Catch:{ Exception -> 0x0661 }
            long r0 = (long) r0
            r25 = r0
            r0 = r2
            r1 = r15
            r6 = r2
            r2 = r19
            r19 = r3
            r3 = r50
            r27 = r4
            r20 = r8
            r40 = r9
            r8 = r37
            r4 = r25
            r0.<init>(r1, r2, r3, r4)     // Catch:{ Exception -> 0x0669 }
            r7.a((com.taobao.accs.ut.monitor.TrafficsMonitor.a) r6)     // Catch:{ Exception -> 0x0669 }
            r0 = r23
            r1 = 1
        L_0x05ef:
            if (r0 != r1) goto L_0x06c4
            boolean r0 = r13.equals(r15)     // Catch:{ Exception -> 0x0669 }
            java.lang.String r1 = "handleMessage try sendAck dataId"
            if (r0 != 0) goto L_0x0613
            r0 = r36
            boolean r0 = r0.equals(r15)     // Catch:{ Exception -> 0x0669 }
            if (r0 == 0) goto L_0x0602
            goto L_0x0613
        L_0x0602:
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0669 }
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0669 }
            r3 = 0
            r2[r3] = r11     // Catch:{ Exception -> 0x0669 }
            r3 = 1
            r2[r3] = r12     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.utl.ALog.i(r0, r1, r2)     // Catch:{ Exception -> 0x0669 }
            r3 = 0
            r4 = 1
            goto L_0x0621
        L_0x0613:
            java.lang.String r0 = r7.f12983m     // Catch:{ Exception -> 0x0669 }
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0669 }
            r3 = 0
            r2[r3] = r11     // Catch:{ Exception -> 0x0669 }
            r4 = 1
            r2[r4] = r12     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.utl.ALog.e(r0, r1, r2)     // Catch:{ Exception -> 0x0669 }
        L_0x0621:
            com.taobao.accs.net.a r0 = r7.f12982l     // Catch:{ Exception -> 0x0669 }
            r1 = 0
            java.lang.String r0 = r0.b((java.lang.String) r1)     // Catch:{ Exception -> 0x0669 }
            com.taobao.accs.net.a r1 = r7.f12982l     // Catch:{ Exception -> 0x0669 }
            java.lang.String r1 = r1.d()     // Catch:{ Exception -> 0x0669 }
            r2 = 0
            int r5 = (int) r8
            short r5 = (short) r5
            r6 = r20
            r8 = r0
            r21 = r40
            r9 = r1
            r1 = r13
            r11 = r6
            r6 = r19
            r3 = r27
            r13 = r2
            r24 = r14
            r2 = r18
            r0 = 1
            r14 = r5
            r45 = r51
            r5 = r15
            r15 = r50
            r16 = r21
            com.taobao.accs.data.Message r8 = com.taobao.accs.data.Message.buildPushAck(r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x069f }
            com.taobao.accs.net.a r9 = r7.f12982l     // Catch:{ Exception -> 0x069f }
            r9.b((com.taobao.accs.data.Message) r8, (boolean) r0)     // Catch:{ Exception -> 0x069f }
            java.lang.String r0 = r8.dataId     // Catch:{ Exception -> 0x069f }
            r7.a((java.lang.String) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x069f }
            if (r24 == 0) goto L_0x06c4
            java.lang.String r0 = "ack"
            com.taobao.accs.utl.k.a(r1, r0, r6, r3)     // Catch:{ Exception -> 0x069f }
            goto L_0x06c4
        L_0x0661:
            r0 = move-exception
            r45 = r51
            r6 = r3
            r1 = r13
            r2 = r18
            goto L_0x06a0
        L_0x0669:
            r0 = move-exception
            r45 = r51
            r1 = r13
            r2 = r18
            r6 = r19
            goto L_0x06a0
        L_0x0672:
            r45 = r51
            r2 = r18
            r6 = r19
            r1 = r20
            r3 = 1
            java.lang.String r4 = r7.f12983m     // Catch:{ Exception -> 0x069f }
            java.lang.String r5 = "handleMessage not exist, unbind it"
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x069f }
            java.lang.String r9 = "package"
            r10 = 0
            r8[r10] = r9     // Catch:{ Exception -> 0x069f }
            r9 = r0[r3]     // Catch:{ Exception -> 0x069f }
            r8[r3] = r9     // Catch:{ Exception -> 0x069f }
            com.taobao.accs.utl.ALog.e(r4, r5, r8)     // Catch:{ Exception -> 0x069f }
            com.taobao.accs.net.a r4 = r7.f12982l     // Catch:{ Exception -> 0x069f }
            r5 = 0
            java.lang.String r5 = r4.b((java.lang.String) r5)     // Catch:{ Exception -> 0x069f }
            r0 = r0[r3]     // Catch:{ Exception -> 0x069f }
            com.taobao.accs.data.Message r0 = com.taobao.accs.data.Message.buildUnbindApp((java.lang.String) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x069f }
            r4.b((com.taobao.accs.data.Message) r0, (boolean) r3)     // Catch:{ Exception -> 0x069f }
            goto L_0x06c4
        L_0x069f:
            r0 = move-exception
        L_0x06a0:
            java.lang.String r3 = r7.f12983m
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = r45
            com.taobao.accs.utl.ALog.e(r3, r5, r0, r4)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r4 = r7.f12972b
            r3.append(r4)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r3 = r17
            com.taobao.accs.utl.k.a(r1, r3, r6, r2, r0)
        L_0x06c4:
            return
        L_0x06c5:
            java.lang.String r0 = r7.f12983m
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ignore source 4|sal|sg/fg/bg message dataId:"
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            com.taobao.accs.utl.ALog.e(r0, r1, r3)
            java.util.concurrent.ConcurrentMap<com.taobao.accs.data.Message$Id, com.taobao.accs.data.Message> r0 = r7.f12977g
            com.taobao.accs.data.Message$Id r1 = new com.taobao.accs.data.Message$Id
            r1.<init>(r2, r12)
            r0.remove(r1)
            return
        L_0x06e9:
            r0 = move-exception
            r4 = r11
            r3 = r17
            r2 = r18
            r6 = r19
            java.lang.String r5 = r7.f12983m
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "dataId read error "
            r8.append(r9)
            java.lang.String r9 = r0.toString()
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            r9 = 0
            java.lang.Object[] r9 = new java.lang.Object[r9]
            com.taobao.accs.utl.ALog.e(r5, r8, r9)
            r1.close()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r5 = r7.f12972b
            r1.append(r5)
            java.lang.String r5 = "data id read error"
            r1.append(r5)
            java.lang.String r0 = r0.toString()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.taobao.accs.utl.k.a(r4, r3, r6, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.data.d.a(int, byte[], java.lang.String, int):void");
    }

    private byte[] a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = gZIPInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused) {
            }
            return byteArray;
        } catch (Exception e10) {
            String str = this.f12983m;
            ALog.e(str, "uncompress data error " + e10.toString(), new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "", "1", this.f12972b + " uncompress data error " + e10.toString());
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            return null;
        } catch (Throwable th) {
            try {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    private void a(Message message, byte[] bArr, byte[] bArr2, String str) {
        JSONArray jSONArray;
        Message message2 = message;
        int i10 = -8;
        try {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArr));
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f12983m, "handleControlMessage parse", "json", jSONObject.toString());
                }
                if (message2.command.intValue() == 100) {
                    i10 = 200;
                } else {
                    i10 = jSONObject.getInt(Constants.KEY_HTTP_CODE);
                }
                if (i10 == 200) {
                    int intValue = message2.command.intValue();
                    if (intValue == 1) {
                        UtilityImpl.c(Constants.SP_FILE_NAME, this.f12979i);
                        this.f12982l.j().a(this.f12979i.getPackageName());
                        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                        this.f12976f = p.a(jSONObject2, Constants.KEY_DEVICE_TOKEN, (String) null);
                        if (!(jSONObject2 == null || (jSONArray = jSONObject2.getJSONArray(Constants.KEY_PACKAGE_NAMES)) == null)) {
                            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                                String string = jSONArray.getString(i11);
                                if (UtilityImpl.a(this.f12979i, string)) {
                                    this.f12982l.j().a(message2.f12942m);
                                } else {
                                    ALog.d(this.f12983m, "unbind app", "pkg", string);
                                    a aVar = this.f12982l;
                                    aVar.b(Message.buildUnbindApp(aVar.b((String) null), string), true);
                                }
                            }
                        }
                    } else if (intValue == 2) {
                        this.f12982l.j().b(message2.f12942m);
                    } else if (intValue == 3) {
                        this.f12982l.j().a(message2.f12942m, message2.userinfo);
                    } else if (intValue == 4) {
                        this.f12982l.j().e(message2.f12942m);
                    } else if (intValue == 100) {
                        if ((this.f12982l instanceof com.taobao.accs.net.k) && "4|sal|accs-iot".equals(message2.f12938i)) {
                            ((com.taobao.accs.net.k) this.f12982l).a(jSONObject);
                        }
                    }
                } else if (message2.command.intValue() == 3 && i10 == 300) {
                    this.f12982l.j().b(message2.f12942m);
                }
            } catch (Throwable th) {
                th = th;
                ALog.e(this.f12983m, "handleControlMessage", th, new Object[0]);
                k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f12972b + th.toString());
            }
        } catch (Throwable th2) {
            th = th2;
            byte[] bArr3 = bArr;
            ALog.e(this.f12983m, "handleControlMessage", th, new Object[0]);
            k.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, "handleControlMessage", "", this.f12972b + th.toString());
            a(message, i10, (Message.ReqType) null, bArr, (Map<Integer, String>) null);
            a(new TrafficsMonitor.a(message2.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
        }
        a(message, i10, (Message.ReqType) null, bArr, (Map<Integer, String>) null);
        a(new TrafficsMonitor.a(message2.serviceId, GlobalAppRuntimeInfo.isAppBackground(), str, (long) bArr2.length));
    }

    private Map<Integer, String> a(s sVar) {
        HashMap hashMap = null;
        if (sVar == null) {
            return null;
        }
        try {
            int b10 = sVar.b();
            if (ALog.isPrintLog(ALog.Level.D)) {
                String str = this.f12983m;
                ALog.d(str, "extHeaderLen:" + b10, new Object[0]);
            }
            int i10 = 0;
            while (i10 < b10) {
                int b11 = sVar.b();
                int i11 = (64512 & b11) >> 10;
                int i12 = b11 & Message.EXT_HEADER_VALUE_MAX_LEN;
                String a10 = sVar.a(i12);
                i10 = i10 + 2 + i12;
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(Integer.valueOf(i11), a10);
                if (ALog.isPrintLog(ALog.Level.D)) {
                    ALog.d(this.f12983m, "", "extHeaderType", Integer.valueOf(i11), "value", a10);
                }
            }
        } catch (Exception e10) {
            ALog.e(this.f12983m, "parseExtHeader", e10, new Object[0]);
        }
        return hashMap;
    }

    public void a(Message message, int i10) {
        a(message, i10, (Message.ReqType) null, (byte[]) null, (Map<Integer, String>) null);
    }

    public void a(Message message, int i10, Map<Integer, String> map) {
        a(message, i10, (Message.ReqType) null, (byte[]) null, map);
    }

    public void a(Message message, int i10, Message.ReqType reqType, byte[] bArr, Map<Integer, String> map) {
        if (message.command == null || message.getType() < 0 || message.getType() == 2) {
            ALog.d(this.f12983m, "onError, skip ping/ack", new Object[0]);
            return;
        }
        String str = message.cunstomDataId;
        if (str != null) {
            this.f12971a.remove(str);
        }
        Message.ReqType reqType2 = null;
        if (this.f12975e.checkAntiBrush(message.host, map)) {
            i10 = ErrorCode.SERVIER_ANTI_BRUSH;
            reqType = null;
            bArr = null;
            map = null;
        }
        int a10 = this.f12974d.a(map, message.serviceId);
        if (a10 != 0) {
            r11 = a10 == 2 ? ErrorCode.SERVIER_HIGH_LIMIT : a10 == 3 ? ErrorCode.SERVIER_HIGH_LIMIT_BRUSH : ErrorCode.SERVIER_LOW_LIMIT;
            bArr = null;
            map = null;
        } else {
            reqType2 = reqType;
        }
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(this.f12983m, "onResult", "command", message.command, "erorcode", Integer.valueOf(r11));
        }
        if (message.command.intValue() != 102) {
            if (message.isCancel) {
                ALog.e(this.f12983m, "onResult message is cancel", "command", message.command);
                a(message, r11, true);
            } else if (!b(r11) || message.command.intValue() == 100 || message.retryTimes > Message.CONTROL_MAX_RETRY_TIMES) {
                a(message, r11, false);
                Intent c10 = c(message);
                c10.putExtra("errorCode", r11);
                Message.ReqType valueOf = Message.ReqType.valueOf((message.f12935f >> 13) & 3);
                if (reqType2 == Message.ReqType.RES || valueOf == Message.ReqType.REQ) {
                    c10.putExtra(Constants.KEY_SEND_TYPE, Constants.SEND_TYPE_RES);
                }
                if (r11 == 200) {
                    c10.putExtra("data", bArr);
                }
                c10.putExtra(Constants.KEY_APP_KEY, this.f12982l.f13026b);
                c10.putExtra(Constants.KEY_CONFIG_TAG, this.f12982l.f13037m);
                a(map, c10);
                g.a().b(this.f12979i, c10);
                if (!TextUtils.isEmpty(message.serviceId)) {
                    UTMini.getInstance().commitEvent(66001, "MsgToBuss0", "commandId=" + message.command, "serviceId=" + message.serviceId + " errorCode=" + r11 + " dataId=" + message.dataId, Integer.valueOf(Constants.SDK_VERSION_CODE));
                    StringBuilder sb = new StringBuilder();
                    sb.append("1commandId=");
                    sb.append(message.command);
                    sb.append("serviceId=");
                    sb.append(message.serviceId);
                    k.a("accs", BaseMonitor.COUNT_POINT_TO_BUSS, sb.toString(), 0.0d);
                }
            } else {
                message.startSendTime = System.currentTimeMillis();
                int i11 = message.retryTimes + 1;
                message.retryTimes = i11;
                ALog.d(this.f12983m, "onResult", "retryTimes", Integer.valueOf(i11));
                this.f12982l.b(message, true);
                a(message, r11, true);
            }
            b(message, r11);
        }
    }

    private void a(Message message, int i10, boolean z10) {
        boolean z11;
        try {
            NetPerformanceMonitor netPermanceMonitor = message.getNetPermanceMonitor();
            if (netPermanceMonitor != null) {
                netPermanceMonitor.onToBizDate();
                URL url = message.host;
                String url2 = url == null ? null : url.toString();
                if (i10 == 200) {
                    if (message.retryTimes > 0) {
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ", 0.0d);
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "succ_" + message.retryTimes, 0.0d);
                    } else {
                        k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url2);
                    }
                    z11 = true;
                } else {
                    if (message.retryTimes > 0) {
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, "fail＿" + i10, 0.0d);
                        k.a("accs", BaseMonitor.COUNT_POINT_RESEND, ITagManager.FAIL, 0.0d);
                    } else if (i10 != -13) {
                        String a10 = UtilityImpl.a(i10);
                        k.a("accs", BaseMonitor.ALARM_POINT_REQUEST, url2, a10, this.f12972b + message.serviceId + message.timeout);
                    }
                    netPermanceMonitor.setFailReason(i10);
                    z11 = false;
                }
                netPermanceMonitor.setRet(z11);
                if (z10) {
                    if (message.isCancel) {
                        netPermanceMonitor.setRet(false);
                        netPermanceMonitor.setFailReason("msg cancel");
                    }
                    AppMonitor.getInstance().commitStat(message.getNetPermanceMonitor());
                }
            }
        } catch (Throwable th) {
            ALog.e(this.f12983m, "monitorPerf", th, new Object[0]);
        }
    }

    public void a() {
        ALog.d(this.f12983m, "onSendPing", new Object[0]);
        synchronized (d.class) {
            this.f12978h = true;
        }
    }

    public void a(Message message) {
        String str;
        Message message2 = this.f12981k;
        if (!(message2 == null || (str = message.cunstomDataId) == null || message.serviceId == null || !message2.cunstomDataId.equals(str) || !this.f12981k.serviceId.equals(message.serviceId))) {
            UTMini.getInstance().commitEvent(66001, "SEND_REPEAT", message.serviceId, message.cunstomDataId, Long.valueOf(Thread.currentThread().getId()));
        }
        if (message.getType() != -1 && message.getType() != 2 && !message.isAck) {
            this.f12977g.put(message.getMsgId(), message);
        }
    }

    public void a(int i10) {
        this.f12978h = false;
        Message.Id[] idArr = (Message.Id[]) this.f12977g.keySet().toArray(new Message.Id[0]);
        if (idArr.length > 0) {
            ALog.d(this.f12983m, "onNetworkFail", new Object[0]);
            for (Message.Id remove : idArr) {
                Message remove2 = this.f12977g.remove(remove);
                if (remove2 != null) {
                    a(remove2, i10);
                }
            }
        }
    }

    public Message a(String str) {
        return this.f12977g.get(new Message.Id(0, str));
    }

    private byte[] a(String str, Map<Integer, String> map, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    int parseInt = Integer.parseInt(map.get(17));
                    int parseInt2 = Integer.parseInt(map.get(16));
                    if (parseInt2 <= 1) {
                        throw new RuntimeException("burstNums <= 1");
                    } else if (parseInt < 0 || parseInt >= parseInt2) {
                        throw new RuntimeException(String.format("burstNums:%s burstIndex:%s", new Object[]{Integer.valueOf(parseInt2), Integer.valueOf(parseInt)}));
                    } else {
                        String str2 = map.get(18);
                        long j10 = 0;
                        String str3 = map.get(15);
                        if (!TextUtils.isEmpty(str3)) {
                            j10 = Long.parseLong(str3);
                        }
                        a aVar = this.f12985o.get(str);
                        if (aVar == null) {
                            if (ALog.isPrintLog(ALog.Level.I)) {
                                ALog.i(this.f12983m, "putBurstMessage", Constants.KEY_DATA_ID, str, "burstLength", Integer.valueOf(parseInt2));
                            }
                            aVar = new a(str, parseInt2, str2);
                            aVar.a(j10);
                            this.f12985o.put(str, aVar);
                        }
                        return aVar.a(parseInt, parseInt2, bArr);
                    }
                }
            } catch (Throwable th) {
                ALog.w(this.f12983m, "putBurstMessage", th, new Object[0]);
                return null;
            }
        }
        throw new RuntimeException("burstLength == 0");
    }

    private void a(Map<Integer, String> map, Intent intent) {
        if (map != null && intent != null) {
            intent.putExtra(TaoBaseService.ExtraInfo.EXT_HEADER, (HashMap) map);
        }
    }

    private void a(Intent intent, String str, String str2, short s10) {
        if (intent != null) {
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("source", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("target", str2);
            }
            intent.putExtra(Constants.KEY_FLAGS, s10);
        }
    }

    private void a(String str, String str2) {
        e eVar = new e();
        eVar.f13154a = UtilityImpl.j(this.f12979i);
        eVar.f13156c = str;
        eVar.f13157d = "" + System.currentTimeMillis();
        eVar.f13159f = "";
        eVar.f13158e = str2;
        eVar.f13155b = "";
        eVar.a();
    }

    public void a(TrafficsMonitor.a aVar) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(this, aVar));
        } catch (Throwable th) {
            ALog.e(this.f12983m, "addTrafficsInfo", th, new Object[0]);
        }
    }
}
