package org.android.agoo.control;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Base64;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.j;
import javax.crypto.spec.SecretKeySpec;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.common.MsgDO;
import org.android.agoo.message.MessageService;
import org.android.agoo.service.SendMessage;

public class AgooFactory {
    private static final String DEAL_MESSAGE = "accs.msgRecevie";
    private static final String TAG = "AgooFactory";
    /* access modifiers changed from: private */
    public static Context mContext;
    /* access modifiers changed from: private */
    public MessageService messageService = null;
    protected NotifManager notifyManager = null;

    public static class a implements ServiceConnection {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Intent f8585a;

        /* renamed from: b  reason: collision with root package name */
        private String f8586b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public SendMessage f8587c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public ServiceConnection f8588d = this;

        public a(String str, Intent intent) {
            this.f8586b = str;
            this.f8585a = intent;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ALog.d(AgooFactory.TAG, "MessageConnection conneted:" + componentName, new Object[0]);
            this.f8587c = SendMessage.Stub.asInterface(iBinder);
            ALog.d(AgooFactory.TAG, "onConnected current tid:" + Thread.currentThread().getId(), new Object[0]);
            ALog.d(AgooFactory.TAG, "MessageConnection sent:" + this.f8585a, new Object[0]);
            if (this.f8587c != null) {
                ThreadPoolExecutorFactory.execute(new f(this));
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            ALog.d(AgooFactory.TAG, "MessageConnection disConnected", new Object[0]);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f8590b;

        /* renamed from: c  reason: collision with root package name */
        private Intent f8591c;

        public b(String str, Intent intent) {
            this.f8590b = str;
            this.f8591c = intent;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(2:8|13)(1:12)) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0063 */
        /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x00bf A[Catch:{ all -> 0x00c7 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r6 = this;
                java.lang.String r0 = "AgooFactory"
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                r2.<init>()     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = "running tid:"
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00c7 }
                long r3 = r3.getId()     // Catch:{ all -> 0x00c7 }
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = ",pack="
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = r6.f8590b     // Catch:{ all -> 0x00c7 }
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c7 }
                java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r2, r3)     // Catch:{ all -> 0x00c7 }
                android.content.Context r2 = org.android.agoo.control.AgooFactory.mContext     // Catch:{ all -> 0x00c7 }
                android.content.Intent r3 = r6.f8591c     // Catch:{ all -> 0x00c7 }
                r2.sendBroadcast(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                r2.<init>()     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = "SendMessageRunnable for accs,pack="
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = r6.f8590b     // Catch:{ all -> 0x00c7 }
                r2.append(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00c7 }
                java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r2, r3)     // Catch:{ all -> 0x00c7 }
                android.content.Intent r2 = r6.f8591c     // Catch:{ all -> 0x0063 }
                java.lang.String r3 = r6.f8590b     // Catch:{ all -> 0x0063 }
                r2.setPackage(r3)     // Catch:{ all -> 0x0063 }
                android.content.Intent r2 = r6.f8591c     // Catch:{ all -> 0x0063 }
                java.lang.String r3 = "org.agoo.android.intent.action.RECEIVE"
                r2.setAction(r3)     // Catch:{ all -> 0x0063 }
                android.content.Context r2 = org.android.agoo.control.AgooFactory.mContext     // Catch:{ all -> 0x0063 }
                android.content.Intent r3 = r6.f8591c     // Catch:{ all -> 0x0063 }
                com.taobao.accs.a.a.a(r2, r3)     // Catch:{ all -> 0x0063 }
            L_0x0063:
                android.content.Intent r2 = new android.content.Intent     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = "org.android.agoo.client.MessageReceiverService"
                r2.<init>(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = r6.f8590b     // Catch:{ all -> 0x00c7 }
                r2.setPackage(r3)     // Catch:{ all -> 0x00c7 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                r3.<init>()     // Catch:{ all -> 0x00c7 }
                java.lang.String r4 = "this message pack:"
                r3.append(r4)     // Catch:{ all -> 0x00c7 }
                java.lang.String r4 = r6.f8590b     // Catch:{ all -> 0x00c7 }
                r3.append(r4)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c7 }
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r3, r4)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = "start to service..."
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r3, r4)     // Catch:{ all -> 0x00c7 }
                org.android.agoo.control.AgooFactory$a r3 = new org.android.agoo.control.AgooFactory$a     // Catch:{ all -> 0x00c7 }
                android.content.Intent r4 = r6.f8591c     // Catch:{ all -> 0x00c7 }
                java.lang.String r5 = "id"
                java.lang.String r4 = r4.getStringExtra(r5)     // Catch:{ all -> 0x00c7 }
                android.content.Intent r5 = r6.f8591c     // Catch:{ all -> 0x00c7 }
                r3.<init>(r4, r5)     // Catch:{ all -> 0x00c7 }
                android.content.Context r4 = org.android.agoo.control.AgooFactory.mContext     // Catch:{ all -> 0x00c7 }
                r5 = 17
                boolean r2 = r4.bindService(r2, r3, r5)     // Catch:{ all -> 0x00c7 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c7 }
                r3.<init>()     // Catch:{ all -> 0x00c7 }
                java.lang.String r4 = "start service ret:"
                r3.append(r4)     // Catch:{ all -> 0x00c7 }
                r3.append(r2)     // Catch:{ all -> 0x00c7 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c7 }
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r3, r4)     // Catch:{ all -> 0x00c7 }
                if (r2 != 0) goto L_0x00e2
                java.lang.String r2 = "SendMessageRunnable is error"
                java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch:{ all -> 0x00c7 }
                com.taobao.accs.utl.ALog.d(r0, r2, r3)     // Catch:{ all -> 0x00c7 }
                goto L_0x00e2
            L_0x00c7:
                r2 = move-exception
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "SendMessageRunnable is error,e="
                r3.append(r4)
                java.lang.String r2 = r2.toString()
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                java.lang.Object[] r1 = new java.lang.Object[r1]
                com.taobao.accs.utl.ALog.e(r0, r2, r1)
            L_0x00e2:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory.b.run():void");
        }
    }

    private static final boolean checkPackage(Context context, String str) {
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
        }
    }

    private static Bundle getFlag(long j10, MsgDO msgDO) {
        Bundle bundle = new Bundle();
        try {
            char[] charArray = Long.toBinaryString(j10).toCharArray();
            if (charArray != null && 8 <= charArray.length) {
                if (8 <= charArray.length) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(Integer.parseInt("" + charArray[1] + charArray[2] + charArray[3] + charArray[4], 2));
                    bundle.putString(AgooConstants.MESSAGE_ENCRYPTED, sb.toString());
                    if (charArray[6] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_REPORT, "1");
                        msgDO.reportStr = "1";
                    }
                    if (charArray[7] == '1') {
                        bundle.putString(AgooConstants.MESSAGE_NOTIFICATION, "1");
                    }
                }
                if (9 <= charArray.length && charArray[8] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_HAS_TEST, "1");
                }
                if (10 <= charArray.length && charArray[9] == '1') {
                    bundle.putString(AgooConstants.MESSAGE_DUPLICATE, "1");
                }
                if (11 <= charArray.length && charArray[10] == '1') {
                    bundle.putInt(AgooConstants.MESSAGE_POPUP, 1);
                }
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static String parseEncryptedMsg(String str) {
        byte[] bArr;
        String str2 = null;
        try {
            String a10 = Config.a(mContext);
            String b10 = Config.b(mContext);
            String j10 = UtilityImpl.j(mContext);
            if (!TextUtils.isEmpty(b10)) {
                bArr = org.android.agoo.common.a.a(b10.getBytes(XML.CHARSET_UTF8), (a10 + j10).getBytes(XML.CHARSET_UTF8));
            } else {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
                bArr = null;
            }
            if (bArr == null || bArr.length <= 0) {
                ALog.e(TAG, "aesDecrypt key is null!", new Object[0]);
            } else {
                str2 = new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArr), "AES"), org.android.agoo.common.a.a(a10.getBytes(XML.CHARSET_UTF8))), XML.CHARSET_UTF8);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "parseEncryptedMsg failure: ", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str2)) {
            return parseEncryptedMsgByOldDid(str);
        }
        return str2;
    }

    private static String parseEncryptedMsgByOldDid(String str) {
        byte[] bArr;
        try {
            String d10 = UtilityImpl.d(Constants.SP_FILE_NAME, mContext);
            if (TextUtils.isEmpty(d10) || TextUtils.equals(d10, UtilityImpl.j(mContext))) {
                return null;
            }
            String a10 = Config.a(mContext);
            String b10 = Config.b(mContext);
            if (!TextUtils.isEmpty(b10)) {
                bArr = org.android.agoo.common.a.a(b10.getBytes(XML.CHARSET_UTF8), (a10 + d10).getBytes(XML.CHARSET_UTF8));
            } else {
                ALog.e(TAG, "oldDid getAppsign secret null", new Object[0]);
                bArr = null;
            }
            if (bArr != null && bArr.length > 0) {
                return new String(org.android.agoo.common.a.a(Base64.decode(str, 8), new SecretKeySpec(org.android.agoo.common.a.a(bArr), "AES"), org.android.agoo.common.a.a(a10.getBytes(XML.CHARSET_UTF8))), XML.CHARSET_UTF8);
            }
            ALog.e(TAG, "oldDid aesDecrypt key is null!", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "oldDid parseEncryptedMsg failure: ", th, new Object[0]);
            return null;
        }
    }

    private void sendMsgByBindService(String str, Intent intent) {
        try {
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.d(TAG, "onHandleMessage current tid:" + Thread.currentThread().getId(), new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(str, intent));
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgByBindService error >>", th, new Object[0]);
        }
    }

    private void sendMsgToBussiness(Context context, String str, Bundle bundle, boolean z10, String str2, TaoBaseService.ExtraInfo extraInfo) {
        Intent intent = new Intent();
        intent.setAction(AgooConstants.INTENT_FROM_AGOO_MESSAGE);
        intent.setPackage(str);
        intent.putExtras(bundle);
        intent.putExtra("type", "common-push");
        intent.putExtra(AgooConstants.MESSAGE_SOURCE, str2);
        intent.addFlags(32);
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putSerializable(AgooConstants.MESSAGE_ACCS_EXTRA, extraInfo);
            intent.putExtra(AgooConstants.MESSAGE_AGOO_BUNDLE, bundle2);
        } catch (Throwable th) {
            ALog.e(TAG, "sendMsgToBussiness", th, new Object[0]);
        }
        if (ALog.isPrintLog(ALog.Level.I)) {
            ALog.i(TAG, "sendMsgToBussiness intent:" + bundle.toString() + ",utdid=" + j.b(context) + ",pack=" + str + ",agooFlag=" + z10, new Object[0]);
        }
        if (z10) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, DEAL_MESSAGE, j.b(context), "agooMsg", AgooConstants.ACK_PACK_ERROR);
            sendMsgByBindService(str, intent);
            return;
        }
        intent.setClassName(str, com.taobao.accs.client.a.b());
        com.taobao.accs.a.a.a(context, intent);
    }

    public void init(Context context, NotifManager notifManager, MessageService messageService2) {
        mContext = context.getApplicationContext();
        this.notifyManager = notifManager;
        if (notifManager == null) {
            this.notifyManager = new NotifManager();
        }
        this.notifyManager.init(mContext);
        this.messageService = messageService2;
        if (messageService2 == null) {
            this.messageService = new MessageService();
        }
        this.messageService.a(mContext);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:52|53|(1:55)) */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x021c, code lost:
        if (com.taobao.accs.utl.ALog.isPrintLog(com.taobao.accs.utl.ALog.Level.I) != false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x021e, code lost:
        com.taobao.accs.utl.ALog.i(TAG, "agoo msg has no time", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x0216 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.os.Bundle msgReceiverPreHandler(byte[] r36, java.lang.String r37, com.taobao.accs.base.TaoBaseService.ExtraInfo r38, boolean r39) {
        /*
            r35 = this;
            r8 = r35
            r0 = r36
            r9 = r37
            r10 = r38
            java.lang.String r11 = ","
            java.lang.String r12 = "ext"
            java.lang.String r1 = "accs.msgRecevie"
            r2 = 66002(0x101d2, float:9.2489E-41)
            r13 = 0
            java.lang.String r14 = "AgooFactory"
            r15 = 0
            if (r0 == 0) goto L_0x02c7
            int r3 = r0.length     // Catch:{ all -> 0x02f5 }
            if (r3 > 0) goto L_0x001c
            goto L_0x02c7
        L_0x001c:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = "utf-8"
            r7.<init>(r0, r3)     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog$Level r0 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x02f5 }
            boolean r0 = com.taobao.accs.utl.ALog.isPrintLog(r0)     // Catch:{ all -> 0x02f5 }
            if (r0 == 0) goto L_0x004f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r0.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = "msgRecevie,message--->["
            r0.append(r3)     // Catch:{ all -> 0x02f5 }
            r0.append(r7)     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = "],utdid="
            r0.append(r3)     // Catch:{ all -> 0x02f5 }
            android.content.Context r3 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = com.taobao.accs.utl.j.b(r3)     // Catch:{ all -> 0x02f5 }
            r0.append(r3)     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f5 }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.i(r14, r0, r3)     // Catch:{ all -> 0x02f5 }
        L_0x004f:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02f5 }
            if (r0 == 0) goto L_0x0081
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x02f5 }
            android.content.Context r3 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = com.taobao.accs.utl.j.b(r3)     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = "message==null"
            r0.commitEvent(r2, r1, r3, r4)     // Catch:{ all -> 0x02f5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r0.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = "handleMessage message==null,utdid="
            r0.append(r1)     // Catch:{ all -> 0x02f5 }
            android.content.Context r1 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = com.taobao.accs.utl.j.b(r1)     // Catch:{ all -> 0x02f5 }
            r0.append(r1)     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f5 }
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.i(r14, r0, r1)     // Catch:{ all -> 0x02f5 }
            return r13
        L_0x0081:
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ all -> 0x02f5 }
            r0.<init>(r7)     // Catch:{ all -> 0x02f5 }
            int r6 = r0.length()     // Catch:{ all -> 0x02f5 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r5.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r4.<init>()     // Catch:{ all -> 0x02f5 }
            r1 = r13
            r2 = r1
            r3 = 0
        L_0x0097:
            if (r3 >= r6) goto L_0x02a2
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x02f5 }
            r1.<init>()     // Catch:{ all -> 0x02f5 }
            org.json.JSONObject r13 = r0.getJSONObject(r3)     // Catch:{ all -> 0x02f5 }
            if (r13 != 0) goto L_0x00b4
            r36 = r0
            r15 = r3
            r0 = r4
            r13 = r5
            r16 = r6
            r17 = r7
            r27 = r11
            r26 = r12
            r11 = r1
            goto L_0x028f
        L_0x00b4:
            org.android.agoo.common.MsgDO r15 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x02f5 }
            r15.<init>()     // Catch:{ all -> 0x02f5 }
            r36 = r0
            java.lang.String r0 = "p"
            java.lang.String r0 = r13.getString(r0)     // Catch:{ all -> 0x02f5 }
            r16 = r2
            java.lang.String r2 = "i"
            java.lang.String r2 = r13.getString(r2)     // Catch:{ all -> 0x02f5 }
            r22 = r7
            java.lang.String r7 = "b"
            java.lang.String r7 = r13.getString(r7)     // Catch:{ all -> 0x02f5 }
            r23 = r1
            java.lang.String r1 = "f"
            r25 = r4
            r24 = r5
            long r4 = r13.getLong(r1)     // Catch:{ all -> 0x02f5 }
            boolean r1 = r13.isNull(r12)     // Catch:{ all -> 0x02f5 }
            if (r1 != 0) goto L_0x00ea
            java.lang.String r1 = r13.getString(r12)     // Catch:{ all -> 0x02f5 }
            r26 = r12
            goto L_0x00ee
        L_0x00ea:
            r26 = r12
            r1 = r16
        L_0x00ee:
            java.lang.String r12 = "c"
            r27 = r11
            r11 = -1
            int r11 = r13.optInt(r12, r11)     // Catch:{ all -> 0x02f5 }
            int r12 = r6 + -1
            r15.msgIds = r2     // Catch:{ all -> 0x02f5 }
            r15.extData = r1     // Catch:{ all -> 0x02f5 }
            r15.removePacks = r0     // Catch:{ all -> 0x02f5 }
            r15.messageSource = r9     // Catch:{ all -> 0x02f5 }
            boolean r16 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x02f5 }
            if (r16 == 0) goto L_0x011e
            java.lang.String r0 = "11"
            r15.errorCode = r0     // Catch:{ all -> 0x02f5 }
            org.android.agoo.control.NotifManager r0 = r8.notifyManager     // Catch:{ all -> 0x02f5 }
            r0.handlerACKMessage(r15, r10)     // Catch:{ all -> 0x02f5 }
        L_0x0110:
            r12 = r1
            r15 = r3
            r16 = r6
            r17 = r22
            r11 = r23
            r13 = r24
            r0 = r25
            goto L_0x028e
        L_0x011e:
            boolean r16 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02f5 }
            if (r16 == 0) goto L_0x012e
            java.lang.String r0 = "12"
            r15.errorCode = r0     // Catch:{ all -> 0x02f5 }
            org.android.agoo.control.NotifManager r0 = r8.notifyManager     // Catch:{ all -> 0x02f5 }
            r0.handlerACKMessage(r15, r10)     // Catch:{ all -> 0x02f5 }
            goto L_0x0110
        L_0x012e:
            r16 = -1
            int r18 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r18 != 0) goto L_0x013e
            java.lang.String r0 = "13"
            r15.errorCode = r0     // Catch:{ all -> 0x02f5 }
            org.android.agoo.control.NotifManager r0 = r8.notifyManager     // Catch:{ all -> 0x02f5 }
            r0.handlerACKMessage(r15, r10)     // Catch:{ all -> 0x02f5 }
            goto L_0x0110
        L_0x013e:
            r28 = r6
            android.content.Context r6 = mContext     // Catch:{ all -> 0x02f5 }
            boolean r6 = checkPackage(r6, r0)     // Catch:{ all -> 0x02f5 }
            if (r6 != 0) goto L_0x01a3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r4.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.String r5 = "msgRecevie checkpackage is del,pack="
            r4.append(r5)     // Catch:{ all -> 0x02f5 }
            r4.append(r0)     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x02f5 }
            r5 = 0
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.d(r14, r4, r6)     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.UTMini r16 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x02f5 }
            r17 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r18 = "accs.msgRecevie"
            android.content.Context r4 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r19 = com.taobao.accs.utl.j.b(r4)     // Catch:{ all -> 0x02f5 }
            java.lang.String r20 = "deletePack"
            r21 = r0
            r16.commitEvent(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x02f5 }
            r6 = r25
            r6.append(r0)     // Catch:{ all -> 0x02f5 }
            r0 = r24
            r0.append(r2)     // Catch:{ all -> 0x02f5 }
            if (r3 >= r12) goto L_0x0197
            r12 = r27
            r6.append(r12)     // Catch:{ all -> 0x02f5 }
            r0.append(r12)     // Catch:{ all -> 0x02f5 }
            r13 = r0
            r15 = r3
            r0 = r6
            r27 = r12
        L_0x018e:
            r17 = r22
            r11 = r23
            r16 = r28
            r12 = r1
            goto L_0x028e
        L_0x0197:
            r13 = r0
            r12 = r1
            r15 = r3
            r0 = r6
            r17 = r22
            r11 = r23
            r16 = r28
            goto L_0x028e
        L_0x01a3:
            r16 = r24
            r6 = r25
            r12 = r27
            android.os.Bundle r4 = getFlag(r4, r15)     // Catch:{ all -> 0x02f5 }
            java.lang.String r5 = "encrypted"
            java.lang.String r5 = r4.getString(r5)     // Catch:{ all -> 0x02f5 }
            android.content.Context r17 = mContext     // Catch:{ all -> 0x02f5 }
            r18 = r3
            java.lang.String r3 = r17.getPackageName()     // Catch:{ all -> 0x02f5 }
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x02f5 }
            if (r3 == 0) goto L_0x01fd
            r3 = 4
            java.lang.String r3 = java.lang.Integer.toString(r3)     // Catch:{ all -> 0x02f5 }
            boolean r3 = android.text.TextUtils.equals(r5, r3)     // Catch:{ all -> 0x02f5 }
            if (r3 == 0) goto L_0x01ce
            r5 = 0
            goto L_0x01ff
        L_0x01ce:
            java.lang.String r0 = "msgRecevie msg encrypted flag not exist, cannot prase!!!"
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.e(r14, r0, r3)     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.UTMini r29 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x02f5 }
            r30 = 66002(0x101d2, float:9.2489E-41)
            java.lang.String r31 = "accs.msgRecevie"
            android.content.Context r0 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r32 = com.taobao.accs.utl.j.b(r0)     // Catch:{ all -> 0x02f5 }
            java.lang.String r33 = "encrypted!=4"
            java.lang.String r34 = "15"
            r29.commitEvent(r30, r31, r32, r33, r34)     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = "24"
            r15.errorCode = r0     // Catch:{ all -> 0x02f5 }
            org.android.agoo.control.NotifManager r0 = r8.notifyManager     // Catch:{ all -> 0x02f5 }
            r0.handlerACKMessage(r15, r10)     // Catch:{ all -> 0x02f5 }
            r0 = r6
            r27 = r12
            r13 = r16
            r15 = r18
            goto L_0x018e
        L_0x01fd:
            r3 = 1
            r5 = 1
        L_0x01ff:
            r3 = r23
            r3.putAll(r4)     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = "t"
            java.lang.String r4 = r13.getString(r4)     // Catch:{ all -> 0x0216 }
            boolean r13 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0216 }
            if (r13 != 0) goto L_0x0226
            java.lang.String r13 = "time"
            r3.putString(r13, r4)     // Catch:{ all -> 0x0216 }
            goto L_0x0226
        L_0x0216:
            com.taobao.accs.utl.ALog$Level r4 = com.taobao.accs.utl.ALog.Level.I     // Catch:{ all -> 0x02f5 }
            boolean r4 = com.taobao.accs.utl.ALog.isPrintLog(r4)     // Catch:{ all -> 0x02f5 }
            if (r4 == 0) goto L_0x0226
            java.lang.String r4 = "agoo msg has no time"
            r13 = 0
            java.lang.Object[] r15 = new java.lang.Object[r13]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.i(r14, r4, r15)     // Catch:{ all -> 0x02f5 }
        L_0x0226:
            java.lang.String r4 = "trace"
            r27 = r12
            long r12 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02f5 }
            r3.putLong(r4, r12)     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = "id"
            r3.putString(r4, r2)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "body"
            r3.putString(r2, r7)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "source"
            r3.putString(r2, r0)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "fromAppkey"
            android.content.Context r4 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = org.android.agoo.common.Config.a(r4)     // Catch:{ all -> 0x02f5 }
            r3.putString(r2, r4)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "extData"
            r3.putString(r2, r1)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "oriData"
            r7 = r22
            r3.putString(r2, r7)     // Catch:{ all -> 0x02f5 }
            java.lang.String r2 = "channel"
            r3.putInt(r2, r11)     // Catch:{ all -> 0x02f5 }
            if (r39 == 0) goto L_0x0277
            android.content.Context r2 = mContext     // Catch:{ all -> 0x02f5 }
            r12 = r1
            r11 = r3
            r1 = r35
            r15 = r18
            r3 = r0
            r0 = r6
            r4 = r11
            r13 = r16
            r16 = r28
            r6 = r37
            r17 = r7
            r7 = r38
            r1.sendMsgToBussiness(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x02f5 }
            goto L_0x028e
        L_0x0277:
            r12 = r1
            r11 = r3
            r0 = r6
            r17 = r7
            r13 = r16
            r15 = r18
            r16 = r28
            java.lang.String r1 = "type"
            java.lang.String r2 = "common-push"
            r11.putString(r1, r2)     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = "message_source"
            r11.putString(r1, r9)     // Catch:{ all -> 0x02f5 }
        L_0x028e:
            r2 = r12
        L_0x028f:
            int r3 = r15 + 1
            r4 = r0
            r1 = r11
            r5 = r13
            r6 = r16
            r7 = r17
            r12 = r26
            r11 = r27
            r13 = 0
            r15 = 0
            r0 = r36
            goto L_0x0097
        L_0x02a2:
            r0 = r4
            r13 = r5
            int r2 = r0.length()     // Catch:{ all -> 0x02f5 }
            if (r2 <= 0) goto L_0x02c6
            org.android.agoo.common.MsgDO r2 = new org.android.agoo.common.MsgDO     // Catch:{ all -> 0x02f5 }
            r2.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = r13.toString()     // Catch:{ all -> 0x02f5 }
            r2.msgIds = r3     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f5 }
            r2.removePacks = r0     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = "10"
            r2.errorCode = r0     // Catch:{ all -> 0x02f5 }
            r2.messageSource = r9     // Catch:{ all -> 0x02f5 }
            org.android.agoo.control.NotifManager r0 = r8.notifyManager     // Catch:{ all -> 0x02f5 }
            r0.handlerACKMessage(r2, r10)     // Catch:{ all -> 0x02f5 }
        L_0x02c6:
            return r1
        L_0x02c7:
            com.taobao.accs.utl.UTMini r0 = com.taobao.accs.utl.UTMini.getInstance()     // Catch:{ all -> 0x02f5 }
            android.content.Context r3 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r3 = com.taobao.accs.utl.j.b(r3)     // Catch:{ all -> 0x02f5 }
            java.lang.String r4 = "data==null"
            r0.commitEvent(r2, r1, r3, r4)     // Catch:{ all -> 0x02f5 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x02f5 }
            r0.<init>()     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = "handleMessage data==null,utdid="
            r0.append(r1)     // Catch:{ all -> 0x02f5 }
            android.content.Context r1 = mContext     // Catch:{ all -> 0x02f5 }
            java.lang.String r1 = com.taobao.accs.utl.j.b(r1)     // Catch:{ all -> 0x02f5 }
            r0.append(r1)     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02f5 }
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch:{ all -> 0x02f5 }
            com.taobao.accs.utl.ALog.i(r14, r0, r2)     // Catch:{ all -> 0x02f5 }
            r1 = 0
            return r1
        L_0x02f5:
            r0 = move-exception
            com.taobao.accs.utl.ALog$Level r1 = com.taobao.accs.utl.ALog.Level.E
            boolean r1 = com.taobao.accs.utl.ALog.isPrintLog(r1)
            if (r1 == 0) goto L_0x0315
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "msgRecevie is error,e="
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.taobao.accs.utl.ALog.e(r14, r0, r1)
        L_0x0315:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory.msgReceiverPreHandler(byte[], java.lang.String, com.taobao.accs.base.TaoBaseService$ExtraInfo, boolean):android.os.Bundle");
    }

    public void msgRecevie(byte[] bArr, String str) {
        msgRecevie(bArr, str, (TaoBaseService.ExtraInfo) null);
    }

    public void reportCacheMsg() {
        try {
            ThreadPoolExecutorFactory.execute(new c(this));
        } catch (Throwable th) {
            ALog.e(TAG, "reportCacheMsg fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr) {
        saveMsg(bArr, (String) null);
    }

    public void updateMsg(byte[] bArr, boolean z10) {
        ThreadPoolExecutorFactory.execute(new d(this, bArr, z10));
    }

    public void updateMsgStatus(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                if (ALog.isPrintLog(ALog.Level.I)) {
                    ALog.i(TAG, "updateNotifyMsg begin,messageId=" + str + ",status=" + str2 + ",reportTimes=" + Config.f(mContext), new Object[0]);
                }
                if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    this.messageService.a(str, "2");
                } else if (TextUtils.equals(str2, MessageService.MSG_ACCS_NOTIFY_DISMISS)) {
                    this.messageService.a(str, "3");
                }
            }
        } catch (Throwable th) {
            ALog.e(TAG, "updateNotifyMsg e=" + th.toString(), new Object[0]);
        }
    }

    public void updateNotifyMsg(String str, String str2) {
        ThreadPoolExecutorFactory.execute(new e(this, str, str2));
    }

    public void msgRecevie(byte[] bArr, String str, TaoBaseService.ExtraInfo extraInfo) {
        try {
            if (ALog.isPrintLog(ALog.Level.I)) {
                ALog.i(TAG, "into--[AgooFactory,msgRecevie]:messageSource=" + str, new Object[0]);
            }
            ThreadPoolExecutorFactory.execute(new b(this, bArr, str, extraInfo));
        } catch (Throwable th) {
            ALog.e(TAG, "serviceImpl init task fail:" + th.toString(), new Object[0]);
        }
    }

    public void saveMsg(byte[] bArr, String str) {
        if (bArr != null && bArr.length > 0) {
            ThreadPoolExecutorFactory.execute(new a(this, bArr, str));
        }
    }
}
