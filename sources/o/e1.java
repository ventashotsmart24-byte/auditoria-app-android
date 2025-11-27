package o;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.appcompat.app.m;
import androidx.collection.b;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o.s;

public class e1 implements r {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8320a;

    /* renamed from: b  reason: collision with root package name */
    public final Notification.Builder f8321b;

    /* renamed from: c  reason: collision with root package name */
    public final s.e f8322c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f8323d;

    /* renamed from: e  reason: collision with root package name */
    public RemoteViews f8324e;

    /* renamed from: f  reason: collision with root package name */
    public final List f8325f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public final Bundle f8326g = new Bundle();

    /* renamed from: h  reason: collision with root package name */
    public int f8327h;

    /* renamed from: i  reason: collision with root package name */
    public RemoteViews f8328i;

    public e1(s.e eVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        Icon icon;
        List<String> list;
        List e10;
        this.f8322c = eVar;
        this.f8320a = eVar.f8385a;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f8321b = new Notification.Builder(eVar.f8385a, eVar.L);
        } else {
            this.f8321b = new Notification.Builder(eVar.f8385a);
        }
        Notification notification = eVar.R;
        Notification.Builder lights = this.f8321b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, eVar.f8393i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z10);
        if ((notification.flags & 8) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z11);
        if ((notification.flags & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z12).setDefaults(notification.defaults).setContentTitle(eVar.f8389e).setContentText(eVar.f8390f).setContentInfo(eVar.f8395k).setContentIntent(eVar.f8391g).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = eVar.f8392h;
        if ((notification.flags & 128) != 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z13).setLargeIcon(eVar.f8394j).setNumber(eVar.f8396l).setProgress(eVar.f8405u, eVar.f8406v, eVar.f8407w);
        if (i10 < 21) {
            this.f8321b.setSound(notification.sound, notification.audioStreamType);
        }
        this.f8321b.setSubText(eVar.f8402r).setUsesChronometer(eVar.f8399o).setPriority(eVar.f8397m);
        Iterator it = eVar.f8386b.iterator();
        while (it.hasNext()) {
            b((s.a) it.next());
        }
        Bundle bundle = eVar.E;
        if (bundle != null) {
            this.f8326g.putAll(bundle);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 20) {
            if (eVar.A) {
                this.f8326g.putBoolean("android.support.localOnly", true);
            }
            String str = eVar.f8408x;
            if (str != null) {
                this.f8326g.putString("android.support.groupKey", str);
                if (eVar.f8409y) {
                    this.f8326g.putBoolean("android.support.isGroupSummary", true);
                } else {
                    this.f8326g.putBoolean("android.support.useSideChannel", true);
                }
            }
            String str2 = eVar.f8410z;
            if (str2 != null) {
                this.f8326g.putString("android.support.sortKey", str2);
            }
        }
        this.f8323d = eVar.I;
        this.f8324e = eVar.J;
        this.f8321b.setShowWhen(eVar.f8398n);
        if (i11 < 21 && (e10 = e(g(eVar.f8387c), eVar.U)) != null && !e10.isEmpty()) {
            this.f8326g.putStringArray("android.people", (String[]) e10.toArray(new String[e10.size()]));
        }
        if (i11 >= 20) {
            Notification.Builder unused = this.f8321b.setLocalOnly(eVar.A).setGroup(eVar.f8408x).setGroupSummary(eVar.f8409y).setSortKey(eVar.f8410z);
            this.f8327h = eVar.P;
        }
        if (i11 >= 21) {
            Notification.Builder unused2 = this.f8321b.setCategory(eVar.D).setColor(eVar.F).setVisibility(eVar.G).setPublicVersion(eVar.H).setSound(notification.sound, notification.audioAttributes);
            if (i11 < 28) {
                list = e(g(eVar.f8387c), eVar.U);
            } else {
                list = eVar.U;
            }
            if (list != null && !list.isEmpty()) {
                for (String a10 : list) {
                    Notification.Builder unused3 = this.f8321b.addPerson(a10);
                }
            }
            this.f8328i = eVar.K;
            if (eVar.f8388d.size() > 0) {
                Bundle bundle2 = eVar.e().getBundle("android.car.EXTENSIONS");
                bundle2 = bundle2 == null ? new Bundle() : bundle2;
                Bundle bundle3 = new Bundle(bundle2);
                Bundle bundle4 = new Bundle();
                for (int i12 = 0; i12 < eVar.f8388d.size(); i12++) {
                    bundle4.putBundle(Integer.toString(i12), f1.b((s.a) eVar.f8388d.get(i12)));
                }
                bundle2.putBundle("invisible_actions", bundle4);
                bundle3.putBundle("invisible_actions", bundle4);
                eVar.e().putBundle("android.car.EXTENSIONS", bundle2);
                this.f8326g.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 23 && (icon = eVar.T) != null) {
            Notification.Builder unused4 = this.f8321b.setSmallIcon(icon);
        }
        if (i13 >= 24) {
            Notification.Builder unused5 = this.f8321b.setExtras(eVar.E).setRemoteInputHistory(eVar.f8404t);
            RemoteViews remoteViews = eVar.I;
            if (remoteViews != null) {
                Notification.Builder unused6 = this.f8321b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = eVar.J;
            if (remoteViews2 != null) {
                Notification.Builder unused7 = this.f8321b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = eVar.K;
            if (remoteViews3 != null) {
                Notification.Builder unused8 = this.f8321b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i13 >= 26) {
            Notification.Builder unused9 = this.f8321b.setBadgeIconType(eVar.M).setSettingsText(eVar.f8403s).setShortcutId(eVar.N).setTimeoutAfter(eVar.O).setGroupAlertBehavior(eVar.P);
            if (eVar.C) {
                Notification.Builder unused10 = this.f8321b.setColorized(eVar.B);
            }
            if (!TextUtils.isEmpty(eVar.L)) {
                this.f8321b.setSound((Uri) null).setDefaults(0).setLights(0, 0, 0).setVibrate((long[]) null);
            }
        }
        if (i13 >= 28) {
            Iterator it2 = eVar.f8387c.iterator();
            if (it2.hasNext()) {
                m.a(it2.next());
                throw null;
            }
        }
        if (i13 >= 29) {
            Notification.Builder unused11 = this.f8321b.setAllowSystemGeneratedContextualActions(eVar.Q);
            Notification.Builder unused12 = this.f8321b.setBubbleMetadata(s.d.a((s.d) null));
        }
        if (eVar.S) {
            if (this.f8322c.f8409y) {
                this.f8327h = 2;
            } else {
                this.f8327h = 1;
            }
            this.f8321b.setVibrate((long[]) null);
            this.f8321b.setSound((Uri) null);
            int i14 = notification.defaults & -2 & -3;
            notification.defaults = i14;
            this.f8321b.setDefaults(i14);
            if (i13 >= 26) {
                if (TextUtils.isEmpty(this.f8322c.f8408x)) {
                    Notification.Builder unused13 = this.f8321b.setGroup("silent");
                }
                Notification.Builder unused14 = this.f8321b.setGroupAlertBehavior(this.f8327h);
            }
        }
    }

    public static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    public static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        m.a(it.next());
        throw null;
    }

    public Notification.Builder a() {
        return this.f8321b;
    }

    public final void b(s.a aVar) {
        Notification.Action.Builder builder;
        Bundle bundle;
        int i10;
        Icon icon;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 20) {
            IconCompat f10 = aVar.f();
            if (i11 >= 23) {
                if (f10 != null) {
                    icon = f10.u();
                } else {
                    icon = null;
                }
                builder = new Notification.Action.Builder(icon, aVar.j(), aVar.a());
            } else {
                if (f10 != null) {
                    i10 = f10.g();
                } else {
                    i10 = 0;
                }
                builder = new Notification.Action.Builder(i10, aVar.j(), aVar.a());
            }
            if (aVar.g() != null) {
                for (RemoteInput a10 : j1.b(aVar.g())) {
                    Notification.Action.Builder unused = builder.addRemoteInput(a10);
                }
            }
            if (aVar.d() != null) {
                bundle = new Bundle(aVar.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 24) {
                Notification.Action.Builder unused2 = builder.setAllowGeneratedReplies(aVar.b());
            }
            bundle.putInt("android.support.action.semanticAction", aVar.h());
            if (i12 >= 28) {
                Notification.Action.Builder unused3 = builder.setSemanticAction(aVar.h());
            }
            if (i12 >= 29) {
                Notification.Action.Builder unused4 = builder.setContextual(aVar.k());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", aVar.i());
            Notification.Action.Builder unused5 = builder.addExtras(bundle);
            Notification.Builder unused6 = this.f8321b.addAction(builder.build());
            return;
        }
        this.f8325f.add(f1.e(this.f8321b, aVar));
    }

    public Notification c() {
        RemoteViews remoteViews;
        Bundle a10;
        RemoteViews k10;
        RemoteViews i10;
        s.f fVar = this.f8322c.f8401q;
        if (fVar != null) {
            fVar.b(this);
        }
        if (fVar != null) {
            remoteViews = fVar.j(this);
        } else {
            remoteViews = null;
        }
        Notification d10 = d();
        if (remoteViews != null) {
            d10.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f8322c.I;
            if (remoteViews2 != null) {
                d10.contentView = remoteViews2;
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (!(fVar == null || (i10 = fVar.i(this)) == null)) {
            d10.bigContentView = i10;
        }
        if (!(i11 < 21 || fVar == null || (k10 = this.f8322c.f8401q.k(this)) == null)) {
            d10.headsUpContentView = k10;
        }
        if (!(fVar == null || (a10 = s.a(d10)) == null)) {
            fVar.a(a10);
        }
        return d10;
    }

    public Notification d() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            return this.f8321b.build();
        }
        if (i10 >= 24) {
            Notification build = this.f8321b.build();
            if (this.f8327h != 0) {
                if (!(build.getGroup() == null || (build.flags & 512) == 0 || this.f8327h != 2)) {
                    h(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f8327h == 1) {
                    h(build);
                }
            }
            return build;
        } else if (i10 >= 21) {
            this.f8321b.setExtras(this.f8326g);
            Notification build2 = this.f8321b.build();
            RemoteViews remoteViews = this.f8323d;
            if (remoteViews != null) {
                build2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f8324e;
            if (remoteViews2 != null) {
                build2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f8328i;
            if (remoteViews3 != null) {
                build2.headsUpContentView = remoteViews3;
            }
            if (this.f8327h != 0) {
                if (!(build2.getGroup() == null || (build2.flags & 512) == 0 || this.f8327h != 2)) {
                    h(build2);
                }
                if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f8327h == 1) {
                    h(build2);
                }
            }
            return build2;
        } else if (i10 >= 20) {
            this.f8321b.setExtras(this.f8326g);
            Notification build3 = this.f8321b.build();
            RemoteViews remoteViews4 = this.f8323d;
            if (remoteViews4 != null) {
                build3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f8324e;
            if (remoteViews5 != null) {
                build3.bigContentView = remoteViews5;
            }
            if (this.f8327h != 0) {
                if (!(build3.getGroup() == null || (build3.flags & 512) == 0 || this.f8327h != 2)) {
                    h(build3);
                }
                if (build3.getGroup() != null && (build3.flags & 512) == 0 && this.f8327h == 1) {
                    h(build3);
                }
            }
            return build3;
        } else {
            SparseArray a10 = f1.a(this.f8325f);
            if (a10 != null) {
                this.f8326g.putSparseParcelableArray("android.support.actionExtras", a10);
            }
            this.f8321b.setExtras(this.f8326g);
            Notification build4 = this.f8321b.build();
            RemoteViews remoteViews6 = this.f8323d;
            if (remoteViews6 != null) {
                build4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f8324e;
            if (remoteViews7 != null) {
                build4.bigContentView = remoteViews7;
            }
            return build4;
        }
    }

    public Context f() {
        return this.f8320a;
    }

    public final void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & -2 & -3;
    }
}
