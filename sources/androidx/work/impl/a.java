package androidx.work.impl;

import android.content.Context;
import android.os.Build;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static r0.a f3395a = new C0057a(1, 2);

    /* renamed from: b  reason: collision with root package name */
    public static r0.a f3396b = new b(3, 4);

    /* renamed from: c  reason: collision with root package name */
    public static r0.a f3397c = new c(4, 5);

    /* renamed from: d  reason: collision with root package name */
    public static r0.a f3398d = new d(6, 7);

    /* renamed from: e  reason: collision with root package name */
    public static r0.a f3399e = new e(7, 8);

    /* renamed from: f  reason: collision with root package name */
    public static r0.a f3400f = new f(8, 9);

    /* renamed from: g  reason: collision with root package name */
    public static r0.a f3401g = new g(11, 12);

    /* renamed from: androidx.work.impl.a$a  reason: collision with other inner class name */
    public class C0057a extends r0.a {
        public C0057a(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `SystemIdInfo` (`work_spec_id` TEXT NOT NULL, `system_id` INTEGER NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
            bVar.execSQL("INSERT INTO SystemIdInfo(work_spec_id, system_id) SELECT work_spec_id, alarm_id AS system_id FROM alarmInfo");
            bVar.execSQL("DROP TABLE IF EXISTS alarmInfo");
            bVar.execSQL("INSERT OR IGNORE INTO worktag(tag, work_spec_id) SELECT worker_class_name AS tag, id AS work_spec_id FROM workspec");
        }
    }

    public class b extends r0.a {
        public b(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            if (Build.VERSION.SDK_INT >= 23) {
                bVar.execSQL("UPDATE workspec SET schedule_requested_at=0 WHERE state NOT IN (2, 3, 5) AND schedule_requested_at=-1 AND interval_duration<>0");
            }
        }
    }

    public class c extends r0.a {
        public c(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
        }
    }

    public class d extends r0.a {
        public d(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress` BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`) REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )");
        }
    }

    public class e extends r0.a {
        public e(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec` (`period_start_time`)");
        }
    }

    public class f extends r0.a {
        public f(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class g extends r0.a {
        public g(int i10, int i11) {
            super(i10, i11);
        }

        public void a(t0.b bVar) {
            bVar.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
        }
    }

    public static class h extends r0.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f3402c;

        public h(Context context, int i10, int i11) {
            super(i10, i11);
            this.f3402c = context;
        }

        public void a(t0.b bVar) {
            if (this.f8974b >= 10) {
                bVar.l("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
                return;
            }
            this.f3402c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
        }
    }

    public static class i extends r0.a {

        /* renamed from: c  reason: collision with root package name */
        public final Context f3403c;

        public i(Context context) {
            super(9, 10);
            this.f3403c = context;
        }

        public void a(t0.b bVar) {
            bVar.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
            k1.h.b(this.f3403c, bVar);
            k1.f.a(this.f3403c, bVar);
        }
    }
}
