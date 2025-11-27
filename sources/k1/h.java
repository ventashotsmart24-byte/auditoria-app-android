package k1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.work.impl.WorkDatabase;
import j1.d;
import t0.b;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public final WorkDatabase f7241a;

    public h(WorkDatabase workDatabase) {
        this.f7241a = workDatabase;
    }

    public static void b(Context context, b bVar) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("androidx.work.util.preferences", 0);
        if (sharedPreferences.contains("reschedule_needed") || sharedPreferences.contains("last_cancel_all_time_ms")) {
            long j10 = 0;
            long j11 = sharedPreferences.getLong("last_cancel_all_time_ms", 0);
            if (sharedPreferences.getBoolean("reschedule_needed", false)) {
                j10 = 1;
            }
            bVar.beginTransaction();
            try {
                bVar.l("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"last_cancel_all_time_ms", Long.valueOf(j11)});
                bVar.l("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", Long.valueOf(j10)});
                sharedPreferences.edit().clear().apply();
                bVar.setTransactionSuccessful();
            } finally {
                bVar.endTransaction();
            }
        }
    }

    public boolean a() {
        Long b10 = this.f7241a.x().b("reschedule_needed");
        if (b10 == null || b10.longValue() != 1) {
            return false;
        }
        return true;
    }

    public void c(boolean z10) {
        this.f7241a.x().a(new d("reschedule_needed", z10));
    }
}
