package j1;

import a1.s;
import android.database.Cursor;
import android.os.CancellationSignal;
import com.hpplay.component.protocol.push.IPushHandler;
import com.raizlabs.android.dbflow.sql.language.Operator;
import j1.p;
import java.util.ArrayList;
import java.util.List;
import q0.k;

public final class r implements q {

    /* renamed from: a  reason: collision with root package name */
    public final q0.e f7109a;

    /* renamed from: b  reason: collision with root package name */
    public final q0.b f7110b;

    /* renamed from: c  reason: collision with root package name */
    public final k f7111c;

    /* renamed from: d  reason: collision with root package name */
    public final k f7112d;

    /* renamed from: e  reason: collision with root package name */
    public final k f7113e;

    /* renamed from: f  reason: collision with root package name */
    public final k f7114f;

    /* renamed from: g  reason: collision with root package name */
    public final k f7115g;

    /* renamed from: h  reason: collision with root package name */
    public final k f7116h;

    /* renamed from: i  reason: collision with root package name */
    public final k f7117i;

    /* renamed from: j  reason: collision with root package name */
    public final k f7118j;

    public class a extends q0.b {
        public a(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`out_of_quota_policy`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* renamed from: i */
        public void g(t0.f fVar, p pVar) {
            String str = pVar.f7089a;
            if (str == null) {
                fVar.bindNull(1);
            } else {
                fVar.bindString(1, str);
            }
            fVar.bindLong(2, (long) v.j(pVar.f7090b));
            String str2 = pVar.f7091c;
            if (str2 == null) {
                fVar.bindNull(3);
            } else {
                fVar.bindString(3, str2);
            }
            String str3 = pVar.f7092d;
            if (str3 == null) {
                fVar.bindNull(4);
            } else {
                fVar.bindString(4, str3);
            }
            byte[] k10 = androidx.work.b.k(pVar.f7093e);
            if (k10 == null) {
                fVar.bindNull(5);
            } else {
                fVar.bindBlob(5, k10);
            }
            byte[] k11 = androidx.work.b.k(pVar.f7094f);
            if (k11 == null) {
                fVar.bindNull(6);
            } else {
                fVar.bindBlob(6, k11);
            }
            fVar.bindLong(7, pVar.f7095g);
            fVar.bindLong(8, pVar.f7096h);
            fVar.bindLong(9, pVar.f7097i);
            fVar.bindLong(10, (long) pVar.f7099k);
            fVar.bindLong(11, (long) v.a(pVar.f7100l));
            fVar.bindLong(12, pVar.f7101m);
            fVar.bindLong(13, pVar.f7102n);
            fVar.bindLong(14, pVar.f7103o);
            fVar.bindLong(15, pVar.f7104p);
            fVar.bindLong(16, pVar.f7105q ? 1 : 0);
            fVar.bindLong(17, (long) v.i(pVar.f7106r));
            a1.b bVar = pVar.f7098j;
            if (bVar != null) {
                fVar.bindLong(18, (long) v.h(bVar.b()));
                fVar.bindLong(19, bVar.g() ? 1 : 0);
                fVar.bindLong(20, bVar.h() ? 1 : 0);
                fVar.bindLong(21, bVar.f() ? 1 : 0);
                fVar.bindLong(22, bVar.i() ? 1 : 0);
                fVar.bindLong(23, bVar.c());
                fVar.bindLong(24, bVar.d());
                byte[] c10 = v.c(bVar.a());
                if (c10 == null) {
                    fVar.bindNull(25);
                } else {
                    fVar.bindBlob(25, c10);
                }
            } else {
                fVar.bindNull(18);
                fVar.bindNull(19);
                fVar.bindNull(20);
                fVar.bindNull(21);
                fVar.bindNull(22);
                fVar.bindNull(23);
                fVar.bindNull(24);
                fVar.bindNull(25);
            }
        }
    }

    public class b extends k {
        public b(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM workspec WHERE id=?";
        }
    }

    public class c extends k {
        public c(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET output=? WHERE id=?";
        }
    }

    public class d extends k {
        public d(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET period_start_time=? WHERE id=?";
        }
    }

    public class e extends k {
        public e(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
        }
    }

    public class f extends k {
        public f(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
        }
    }

    public class g extends k {
        public g(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
        }
    }

    public class h extends k {
        public h(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
        }
    }

    public class i extends k {
        public i(q0.e eVar) {
            super(eVar);
        }

        public String d() {
            return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
        }
    }

    public r(q0.e eVar) {
        this.f7109a = eVar;
        this.f7110b = new a(eVar);
        this.f7111c = new b(eVar);
        this.f7112d = new c(eVar);
        this.f7113e = new d(eVar);
        this.f7114f = new e(eVar);
        this.f7115g = new f(eVar);
        this.f7116h = new g(eVar);
        this.f7117i = new h(eVar);
        this.f7118j = new i(eVar);
    }

    public void a(String str) {
        this.f7109a.b();
        t0.f a10 = this.f7111c.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f7109a.c();
        try {
            a10.executeUpdateDelete();
            this.f7109a.r();
        } finally {
            this.f7109a.g();
            this.f7111c.f(a10);
        }
    }

    public List b(long j10) {
        q0.h hVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE period_start_time >= ? AND state IN (2, 3, 5) ORDER BY period_start_time DESC", 1);
        c10.bindLong(1, j10);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f7090b = v.g(b10.getInt(b20));
                    pVar.f7092d = b10.getString(b22);
                    pVar.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f7094f = androidx.work.b.g(b10.getBlob(i16));
                    int i17 = b25;
                    int i18 = i14;
                    i10 = i16;
                    pVar.f7095g = b10.getLong(i17);
                    int i19 = b22;
                    int i20 = b26;
                    pVar.f7096h = b10.getLong(i20);
                    int i21 = i17;
                    int i22 = b14;
                    int i23 = b27;
                    pVar.f7097i = b10.getLong(i23);
                    int i24 = b28;
                    pVar.f7099k = b10.getInt(i24);
                    int i25 = b29;
                    int i26 = i20;
                    pVar.f7100l = v.d(b10.getInt(i25));
                    b27 = i23;
                    int i27 = i22;
                    int i28 = b30;
                    pVar.f7101m = b10.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = b31;
                    pVar.f7102n = b10.getLong(i31);
                    int i32 = i28;
                    b31 = i31;
                    int i33 = b32;
                    pVar.f7103o = b10.getLong(i33);
                    int i34 = i29;
                    int i35 = b33;
                    pVar.f7104p = b10.getLong(i35);
                    int i36 = b34;
                    if (b10.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar.f7105q = z14;
                    int i37 = b35;
                    int i38 = i35;
                    pVar.f7106r = v.f(b10.getInt(i37));
                    pVar.f7098j = bVar;
                    arrayList.add(pVar);
                    b12 = i18;
                    b35 = i37;
                    b22 = i19;
                    b25 = i21;
                    b26 = i26;
                    b28 = i34;
                    b33 = i38;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i36;
                    b32 = i33;
                    b13 = i15;
                    int i39 = i30;
                    b30 = i32;
                    b14 = i27;
                    b29 = i39;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public List c() {
        q0.h hVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f7090b = v.g(b10.getInt(b20));
                    pVar.f7092d = b10.getString(b22);
                    pVar.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f7094f = androidx.work.b.g(b10.getBlob(i16));
                    int i17 = i14;
                    i10 = i16;
                    int i18 = b25;
                    pVar.f7095g = b10.getLong(i18);
                    int i19 = b23;
                    int i20 = b26;
                    pVar.f7096h = b10.getLong(i20);
                    int i21 = i18;
                    int i22 = b14;
                    int i23 = b27;
                    pVar.f7097i = b10.getLong(i23);
                    int i24 = b28;
                    pVar.f7099k = b10.getInt(i24);
                    int i25 = b29;
                    int i26 = i20;
                    pVar.f7100l = v.d(b10.getInt(i25));
                    b27 = i23;
                    int i27 = i22;
                    int i28 = b30;
                    pVar.f7101m = b10.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = b31;
                    pVar.f7102n = b10.getLong(i31);
                    int i32 = i28;
                    b31 = i31;
                    int i33 = b32;
                    pVar.f7103o = b10.getLong(i33);
                    int i34 = i29;
                    int i35 = b33;
                    pVar.f7104p = b10.getLong(i35);
                    int i36 = b34;
                    if (b10.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar.f7105q = z14;
                    int i37 = b35;
                    int i38 = i35;
                    pVar.f7106r = v.f(b10.getInt(i37));
                    pVar.f7098j = bVar;
                    arrayList.add(pVar);
                    b35 = i37;
                    b12 = i17;
                    b23 = i19;
                    b25 = i21;
                    b26 = i26;
                    b28 = i34;
                    b33 = i38;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i36;
                    b32 = i33;
                    b13 = i15;
                    int i39 = i30;
                    b30 = i32;
                    b14 = i27;
                    b29 = i39;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public int d(s sVar, String... strArr) {
        this.f7109a.b();
        StringBuilder b10 = s0.e.b();
        b10.append("UPDATE workspec SET state=");
        b10.append(Operator.Operation.EMPTY_PARAM);
        b10.append(" WHERE id IN (");
        s0.e.a(b10, strArr.length);
        b10.append(")");
        t0.f d10 = this.f7109a.d(b10.toString());
        d10.bindLong(1, (long) v.j(sVar));
        int i10 = 2;
        for (String str : strArr) {
            if (str == null) {
                d10.bindNull(i10);
            } else {
                d10.bindString(i10, str);
            }
            i10++;
        }
        this.f7109a.c();
        try {
            int executeUpdateDelete = d10.executeUpdateDelete();
            this.f7109a.r();
            return executeUpdateDelete;
        } finally {
            this.f7109a.g();
        }
    }

    public void e(p pVar) {
        this.f7109a.b();
        this.f7109a.c();
        try {
            this.f7110b.h(pVar);
            this.f7109a.r();
        } finally {
            this.f7109a.g();
        }
    }

    public List f(String str) {
        q0.h c10 = q0.h.c("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(b10.getString(0));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public s g(String str) {
        q0.h c10 = q0.h.c("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7109a.b();
        s sVar = null;
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst()) {
                sVar = v.g(b10.getInt(0));
            }
            return sVar;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public p h(String str) {
        q0.h hVar;
        p pVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        String str2 = str;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE id=?", 1);
        if (str2 == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str2);
        }
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                if (b10.moveToFirst()) {
                    String string = b10.getString(b19);
                    String string2 = b10.getString(b21);
                    int i10 = b35;
                    a1.b bVar = new a1.b();
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar2 = new p(string, string2);
                    pVar2.f7090b = v.g(b10.getInt(b20));
                    pVar2.f7092d = b10.getString(b22);
                    pVar2.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    pVar2.f7094f = androidx.work.b.g(b10.getBlob(b24));
                    pVar2.f7095g = b10.getLong(b25);
                    pVar2.f7096h = b10.getLong(b26);
                    pVar2.f7097i = b10.getLong(b27);
                    pVar2.f7099k = b10.getInt(b28);
                    pVar2.f7100l = v.d(b10.getInt(b29));
                    pVar2.f7101m = b10.getLong(b30);
                    pVar2.f7102n = b10.getLong(b31);
                    pVar2.f7103o = b10.getLong(b32);
                    pVar2.f7104p = b10.getLong(b33);
                    if (b10.getInt(b34) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar2.f7105q = z14;
                    pVar2.f7106r = v.f(b10.getInt(i10));
                    pVar2.f7098j = bVar;
                    pVar = pVar2;
                } else {
                    pVar = null;
                }
                b10.close();
                hVar.release();
                return pVar;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public List i(String str) {
        q0.h c10 = q0.h.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                arrayList.add(androidx.work.b.g(b10.getBlob(0)));
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public List j(int i10) {
        q0.h hVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        c10.bindLong(1, (long) i10);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i11 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i12 = b19;
                    String string2 = b10.getString(b21);
                    int i13 = b21;
                    a1.b bVar = new a1.b();
                    int i14 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    int i15 = b12;
                    int i16 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f7090b = v.g(b10.getInt(b20));
                    pVar.f7092d = b10.getString(b22);
                    pVar.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    int i17 = i11;
                    pVar.f7094f = androidx.work.b.g(b10.getBlob(i17));
                    int i18 = i15;
                    i11 = i17;
                    int i19 = b25;
                    pVar.f7095g = b10.getLong(i19);
                    int i20 = b22;
                    int i21 = b26;
                    pVar.f7096h = b10.getLong(i21);
                    int i22 = i19;
                    int i23 = b14;
                    int i24 = b27;
                    pVar.f7097i = b10.getLong(i24);
                    int i25 = b28;
                    pVar.f7099k = b10.getInt(i25);
                    int i26 = b29;
                    int i27 = i21;
                    pVar.f7100l = v.d(b10.getInt(i26));
                    b27 = i24;
                    int i28 = i23;
                    int i29 = b30;
                    pVar.f7101m = b10.getLong(i29);
                    int i30 = i25;
                    int i31 = i26;
                    int i32 = b31;
                    pVar.f7102n = b10.getLong(i32);
                    int i33 = i29;
                    b31 = i32;
                    int i34 = b32;
                    pVar.f7103o = b10.getLong(i34);
                    int i35 = i30;
                    int i36 = b33;
                    pVar.f7104p = b10.getLong(i36);
                    int i37 = b34;
                    if (b10.getInt(i37) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar.f7105q = z14;
                    int i38 = b35;
                    int i39 = i36;
                    pVar.f7106r = v.f(b10.getInt(i38));
                    pVar.f7098j = bVar;
                    arrayList.add(pVar);
                    b35 = i38;
                    b12 = i18;
                    b22 = i20;
                    b25 = i22;
                    b26 = i27;
                    b28 = i35;
                    b33 = i39;
                    b19 = i12;
                    b21 = i13;
                    b11 = i14;
                    b34 = i37;
                    b32 = i34;
                    b13 = i16;
                    int i40 = i31;
                    b30 = i33;
                    b14 = i28;
                    b29 = i40;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public int k() {
        this.f7109a.b();
        t0.f a10 = this.f7117i.a();
        this.f7109a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f7109a.r();
            return executeUpdateDelete;
        } finally {
            this.f7109a.g();
            this.f7117i.f(a10);
        }
    }

    public int l(String str, long j10) {
        this.f7109a.b();
        t0.f a10 = this.f7116h.a();
        a10.bindLong(1, j10);
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f7109a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f7109a.r();
            return executeUpdateDelete;
        } finally {
            this.f7109a.g();
            this.f7116h.f(a10);
        }
    }

    public List m(String str) {
        q0.h c10 = q0.h.c("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            c10.bindNull(1);
        } else {
            c10.bindString(1, str);
        }
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "id");
            int b12 = s0.b.b(b10, IPushHandler.STATE);
            ArrayList arrayList = new ArrayList(b10.getCount());
            while (b10.moveToNext()) {
                p.b bVar = new p.b();
                bVar.f7107a = b10.getString(b11);
                bVar.f7108b = v.g(b10.getInt(b12));
                arrayList.add(bVar);
            }
            return arrayList;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public List n(int i10) {
        q0.h hVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        c10.bindLong(1, (long) i10);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i11 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i12 = b19;
                    String string2 = b10.getString(b21);
                    int i13 = b21;
                    a1.b bVar = new a1.b();
                    int i14 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    int i15 = b12;
                    int i16 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f7090b = v.g(b10.getInt(b20));
                    pVar.f7092d = b10.getString(b22);
                    pVar.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    int i17 = i11;
                    pVar.f7094f = androidx.work.b.g(b10.getBlob(i17));
                    int i18 = i15;
                    i11 = i17;
                    int i19 = b25;
                    pVar.f7095g = b10.getLong(i19);
                    int i20 = b22;
                    int i21 = b26;
                    pVar.f7096h = b10.getLong(i21);
                    int i22 = i19;
                    int i23 = b14;
                    int i24 = b27;
                    pVar.f7097i = b10.getLong(i24);
                    int i25 = b28;
                    pVar.f7099k = b10.getInt(i25);
                    int i26 = b29;
                    int i27 = i21;
                    pVar.f7100l = v.d(b10.getInt(i26));
                    b27 = i24;
                    int i28 = i23;
                    int i29 = b30;
                    pVar.f7101m = b10.getLong(i29);
                    int i30 = i25;
                    int i31 = i26;
                    int i32 = b31;
                    pVar.f7102n = b10.getLong(i32);
                    int i33 = i29;
                    b31 = i32;
                    int i34 = b32;
                    pVar.f7103o = b10.getLong(i34);
                    int i35 = i30;
                    int i36 = b33;
                    pVar.f7104p = b10.getLong(i36);
                    int i37 = b34;
                    if (b10.getInt(i37) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar.f7105q = z14;
                    int i38 = b35;
                    int i39 = i36;
                    pVar.f7106r = v.f(b10.getInt(i38));
                    pVar.f7098j = bVar;
                    arrayList.add(pVar);
                    b35 = i38;
                    b12 = i18;
                    b22 = i20;
                    b25 = i22;
                    b26 = i27;
                    b28 = i35;
                    b33 = i39;
                    b19 = i12;
                    b21 = i13;
                    b11 = i14;
                    b34 = i37;
                    b32 = i34;
                    b13 = i16;
                    int i40 = i31;
                    b30 = i33;
                    b14 = i28;
                    b29 = i40;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public void o(String str, androidx.work.b bVar) {
        this.f7109a.b();
        t0.f a10 = this.f7112d.a();
        byte[] k10 = androidx.work.b.k(bVar);
        if (k10 == null) {
            a10.bindNull(1);
        } else {
            a10.bindBlob(1, k10);
        }
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f7109a.c();
        try {
            a10.executeUpdateDelete();
            this.f7109a.r();
        } finally {
            this.f7109a.g();
            this.f7112d.f(a10);
        }
    }

    public List p() {
        q0.h hVar;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        q0.h c10 = q0.h.c("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground`, `WorkSpec`.`out_of_quota_policy` AS `out_of_quota_policy` FROM workspec WHERE state=1", 0);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            int b11 = s0.b.b(b10, "required_network_type");
            int b12 = s0.b.b(b10, "requires_charging");
            int b13 = s0.b.b(b10, "requires_device_idle");
            int b14 = s0.b.b(b10, "requires_battery_not_low");
            int b15 = s0.b.b(b10, "requires_storage_not_low");
            int b16 = s0.b.b(b10, "trigger_content_update_delay");
            int b17 = s0.b.b(b10, "trigger_max_content_delay");
            int b18 = s0.b.b(b10, "content_uri_triggers");
            int b19 = s0.b.b(b10, "id");
            int b20 = s0.b.b(b10, IPushHandler.STATE);
            int b21 = s0.b.b(b10, "worker_class_name");
            int b22 = s0.b.b(b10, "input_merger_class_name");
            int b23 = s0.b.b(b10, "input");
            int b24 = s0.b.b(b10, "output");
            hVar = c10;
            try {
                int b25 = s0.b.b(b10, "initial_delay");
                int b26 = s0.b.b(b10, "interval_duration");
                int b27 = s0.b.b(b10, "flex_duration");
                int b28 = s0.b.b(b10, "run_attempt_count");
                int b29 = s0.b.b(b10, "backoff_policy");
                int b30 = s0.b.b(b10, "backoff_delay_duration");
                int b31 = s0.b.b(b10, "period_start_time");
                int b32 = s0.b.b(b10, "minimum_retention_duration");
                int b33 = s0.b.b(b10, "schedule_requested_at");
                int b34 = s0.b.b(b10, "run_in_foreground");
                int b35 = s0.b.b(b10, "out_of_quota_policy");
                int i10 = b24;
                ArrayList arrayList = new ArrayList(b10.getCount());
                while (b10.moveToNext()) {
                    String string = b10.getString(b19);
                    int i11 = b19;
                    String string2 = b10.getString(b21);
                    int i12 = b21;
                    a1.b bVar = new a1.b();
                    int i13 = b11;
                    bVar.k(v.e(b10.getInt(b11)));
                    if (b10.getInt(b12) != 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    bVar.m(z10);
                    if (b10.getInt(b13) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    bVar.n(z11);
                    if (b10.getInt(b14) != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    bVar.l(z12);
                    if (b10.getInt(b15) != 0) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    bVar.o(z13);
                    int i14 = b12;
                    int i15 = b13;
                    bVar.p(b10.getLong(b16));
                    bVar.q(b10.getLong(b17));
                    bVar.j(v.b(b10.getBlob(b18)));
                    p pVar = new p(string, string2);
                    pVar.f7090b = v.g(b10.getInt(b20));
                    pVar.f7092d = b10.getString(b22);
                    pVar.f7093e = androidx.work.b.g(b10.getBlob(b23));
                    int i16 = i10;
                    pVar.f7094f = androidx.work.b.g(b10.getBlob(i16));
                    int i17 = i14;
                    i10 = i16;
                    int i18 = b25;
                    pVar.f7095g = b10.getLong(i18);
                    int i19 = b23;
                    int i20 = b26;
                    pVar.f7096h = b10.getLong(i20);
                    int i21 = i18;
                    int i22 = b14;
                    int i23 = b27;
                    pVar.f7097i = b10.getLong(i23);
                    int i24 = b28;
                    pVar.f7099k = b10.getInt(i24);
                    int i25 = b29;
                    int i26 = i20;
                    pVar.f7100l = v.d(b10.getInt(i25));
                    b27 = i23;
                    int i27 = i22;
                    int i28 = b30;
                    pVar.f7101m = b10.getLong(i28);
                    int i29 = i24;
                    int i30 = i25;
                    int i31 = b31;
                    pVar.f7102n = b10.getLong(i31);
                    int i32 = i28;
                    b31 = i31;
                    int i33 = b32;
                    pVar.f7103o = b10.getLong(i33);
                    int i34 = i29;
                    int i35 = b33;
                    pVar.f7104p = b10.getLong(i35);
                    int i36 = b34;
                    if (b10.getInt(i36) != 0) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    pVar.f7105q = z14;
                    int i37 = b35;
                    int i38 = i35;
                    pVar.f7106r = v.f(b10.getInt(i37));
                    pVar.f7098j = bVar;
                    arrayList.add(pVar);
                    b35 = i37;
                    b12 = i17;
                    b23 = i19;
                    b25 = i21;
                    b26 = i26;
                    b28 = i34;
                    b33 = i38;
                    b19 = i11;
                    b21 = i12;
                    b11 = i13;
                    b34 = i36;
                    b32 = i33;
                    b13 = i15;
                    int i39 = i30;
                    b30 = i32;
                    b14 = i27;
                    b29 = i39;
                }
                b10.close();
                hVar.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b10.close();
                hVar.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            hVar = c10;
            b10.close();
            hVar.release();
            throw th;
        }
    }

    public boolean q() {
        boolean z10 = false;
        q0.h c10 = q0.h.c("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
        this.f7109a.b();
        Cursor b10 = s0.c.b(this.f7109a, c10, false, (CancellationSignal) null);
        try {
            if (b10.moveToFirst() && b10.getInt(0) != 0) {
                z10 = true;
            }
            return z10;
        } finally {
            b10.close();
            c10.release();
        }
    }

    public int r(String str) {
        this.f7109a.b();
        t0.f a10 = this.f7115g.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f7109a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f7109a.r();
            return executeUpdateDelete;
        } finally {
            this.f7109a.g();
            this.f7115g.f(a10);
        }
    }

    public int s(String str) {
        this.f7109a.b();
        t0.f a10 = this.f7114f.a();
        if (str == null) {
            a10.bindNull(1);
        } else {
            a10.bindString(1, str);
        }
        this.f7109a.c();
        try {
            int executeUpdateDelete = a10.executeUpdateDelete();
            this.f7109a.r();
            return executeUpdateDelete;
        } finally {
            this.f7109a.g();
            this.f7114f.f(a10);
        }
    }

    public void t(String str, long j10) {
        this.f7109a.b();
        t0.f a10 = this.f7113e.a();
        a10.bindLong(1, j10);
        if (str == null) {
            a10.bindNull(2);
        } else {
            a10.bindString(2, str);
        }
        this.f7109a.c();
        try {
            a10.executeUpdateDelete();
            this.f7109a.r();
        } finally {
            this.f7109a.g();
            this.f7113e.f(a10);
        }
    }
}
