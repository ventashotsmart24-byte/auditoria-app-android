package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.c;
import androidx.appcompat.view.menu.m;
import com.hpplay.sdk.source.common.global.Constant;

public class h implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, m.a {

    /* renamed from: a  reason: collision with root package name */
    public g f930a;

    /* renamed from: b  reason: collision with root package name */
    public c f931b;

    /* renamed from: c  reason: collision with root package name */
    public e f932c;

    /* renamed from: d  reason: collision with root package name */
    public m.a f933d;

    public h(g gVar) {
        this.f930a = gVar;
    }

    public boolean a(g gVar) {
        m.a aVar = this.f933d;
        if (aVar != null) {
            return aVar.a(gVar);
        }
        return false;
    }

    public void b() {
        c cVar = this.f931b;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    public void c(IBinder iBinder) {
        g gVar = this.f930a;
        c.a aVar = new c.a(gVar.getContext());
        e eVar = new e(aVar.getContext(), R$layout.abc_list_menu_item_layout);
        this.f932c = eVar;
        eVar.setCallback(this);
        this.f930a.addMenuPresenter(this.f932c);
        aVar.setAdapter(this.f932c.a(), this);
        View headerView = gVar.getHeaderView();
        if (headerView != null) {
            aVar.setCustomTitle(headerView);
        } else {
            aVar.setIcon(gVar.getHeaderIcon()).setTitle(gVar.getHeaderTitle());
        }
        aVar.setOnKeyListener(this);
        c create = aVar.create();
        this.f931b = create;
        create.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f931b.getWindow().getAttributes();
        attributes.type = Constant.STOP_FROM_SINK;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f931b.show();
    }

    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f930a.performItemAction((i) this.f932c.a().getItem(i10), 0);
    }

    public void onCloseMenu(g gVar, boolean z10) {
        if (z10 || gVar == this.f930a) {
            b();
        }
        m.a aVar = this.f933d;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f932c.onCloseMenu(this.f930a, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f931b.getWindow();
                if (!(window2 == null || (decorView2 = window2.getDecorView()) == null || (keyDispatcherState2 = decorView2.getKeyDispatcherState()) == null)) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f931b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f930a.close(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f930a.performShortcut(i10, keyEvent, 0);
    }
}
