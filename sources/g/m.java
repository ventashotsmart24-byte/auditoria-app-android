package g;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public abstract class m implements Window.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final Window.Callback f6688a;

    public m(Window.Callback callback) {
        if (callback != null) {
            this.f6688a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    public final Window.Callback a() {
        return this.f6688a;
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f6688a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f6688a.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f6688a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f6688a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.f6688a.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f6688a.dispatchTrackballEvent(motionEvent);
    }

    public void onActionModeFinished(ActionMode actionMode) {
        this.f6688a.onActionModeFinished(actionMode);
    }

    public void onActionModeStarted(ActionMode actionMode) {
        this.f6688a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f6688a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f6688a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i10, Menu menu) {
        return this.f6688a.onCreatePanelMenu(i10, menu);
    }

    public View onCreatePanelView(int i10) {
        return this.f6688a.onCreatePanelView(i10);
    }

    public void onDetachedFromWindow() {
        this.f6688a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        return this.f6688a.onMenuItemSelected(i10, menuItem);
    }

    public boolean onMenuOpened(int i10, Menu menu) {
        return this.f6688a.onMenuOpened(i10, menu);
    }

    public void onPanelClosed(int i10, Menu menu) {
        this.f6688a.onPanelClosed(i10, menu);
    }

    public void onPointerCaptureChanged(boolean z10) {
        this.f6688a.onPointerCaptureChanged(z10);
    }

    public boolean onPreparePanel(int i10, View view, Menu menu) {
        return this.f6688a.onPreparePanel(i10, view, menu);
    }

    public void onProvideKeyboardShortcuts(List list, Menu menu, int i10) {
        this.f6688a.onProvideKeyboardShortcuts(list, menu, i10);
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.f6688a.onSearchRequested(searchEvent);
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f6688a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z10) {
        this.f6688a.onWindowFocusChanged(z10);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f6688a.onWindowStartingActionMode(callback);
    }

    public boolean onSearchRequested() {
        return this.f6688a.onSearchRequested();
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
        return this.f6688a.onWindowStartingActionMode(callback, i10);
    }
}
