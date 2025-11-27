package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import com.hpplay.sdk.source.mdns.xbill.dns.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class g implements u.a {
    private static final String ACTION_VIEW_STATES_KEY = "android:menu:actionviewstates";
    private static final String EXPANDED_ACTION_VIEW_ID = "android:menu:expandedactionview";
    private static final String PRESENTER_KEY = "android:menu:presenters";
    private static final String TAG = "MenuBuilder";
    private static final int[] sCategoryToOrder = {1, 4, 5, 3, 2, 0};
    private ArrayList<i> mActionItems;
    private a mCallback;
    private final Context mContext;
    private ContextMenu.ContextMenuInfo mCurrentMenuInfo;
    private int mDefaultShowAsAction = 0;
    private i mExpandedItem;
    private SparseArray<Parcelable> mFrozenViewStates;
    private boolean mGroupDividerEnabled = false;
    Drawable mHeaderIcon;
    CharSequence mHeaderTitle;
    View mHeaderView;
    private boolean mIsActionItemsStale;
    private boolean mIsClosing = false;
    private boolean mIsVisibleItemsStale;
    private ArrayList<i> mItems;
    private boolean mItemsChangedWhileDispatchPrevented = false;
    private ArrayList<i> mNonActionItems;
    private boolean mOptionalIconsVisible = false;
    private boolean mOverrideVisibleItems;
    private CopyOnWriteArrayList<WeakReference<m>> mPresenters = new CopyOnWriteArrayList<>();
    private boolean mPreventDispatchingItemsChanged = false;
    private boolean mQwertyMode;
    private final Resources mResources;
    private boolean mShortcutsVisible;
    private boolean mStructureChangedWhileDispatchPrevented = false;
    private ArrayList<i> mTempShortcutItemList = new ArrayList<>();
    private ArrayList<i> mVisibleItems;

    public interface a {
        boolean onMenuItemSelected(g gVar, MenuItem menuItem);

        void onMenuModeChange(g gVar);
    }

    public interface b {
        boolean b(i iVar);
    }

    public g(Context context) {
        this.mContext = context;
        this.mResources = context.getResources();
        this.mItems = new ArrayList<>();
        this.mVisibleItems = new ArrayList<>();
        this.mIsVisibleItemsStale = true;
        this.mActionItems = new ArrayList<>();
        this.mNonActionItems = new ArrayList<>();
        this.mIsActionItemsStale = true;
        j(true);
    }

    public static int f(ArrayList arrayList, int i10) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((i) arrayList.get(size)).f() <= i10) {
                return size + 1;
            }
        }
        return 0;
    }

    public static int g(int i10) {
        int i11 = (-65536 & i10) >> 16;
        if (i11 >= 0) {
            int[] iArr = sCategoryToOrder;
            if (i11 < iArr.length) {
                return (i10 & Message.MAXLENGTH) | (iArr[i11] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public final i a(int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        return new i(this, i10, i11, i12, i13, charSequence, i14);
    }

    public MenuItem add(CharSequence charSequence) {
        return addInternal(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        int i14;
        Intent intent2;
        int i15;
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        if (queryIntentActivityOptions != null) {
            i14 = queryIntentActivityOptions.size();
        } else {
            i14 = 0;
        }
        if ((i13 & 1) == 0) {
            removeGroup(i10);
        }
        for (int i16 = 0; i16 < i14; i16++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i16);
            int i17 = resolveInfo.specificIndex;
            if (i17 < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[i17];
            }
            Intent intent3 = new Intent(intent2);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent3.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            MenuItem intent4 = add(i10, i11, i12, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && (i15 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i15] = intent4;
            }
        }
        return i14;
    }

    public MenuItem addInternal(int i10, int i11, int i12, CharSequence charSequence) {
        int g10 = g(i12);
        i a10 = a(i10, i11, i12, g10, charSequence, this.mDefaultShowAsAction);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.mCurrentMenuInfo;
        if (contextMenuInfo != null) {
            a10.v(contextMenuInfo);
        }
        ArrayList<i> arrayList = this.mItems;
        arrayList.add(f(arrayList, g10), a10);
        onItemsChanged(true);
        return a10;
    }

    public void addMenuPresenter(m mVar) {
        addMenuPresenter(mVar, this.mContext);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(boolean z10) {
        if (!this.mPresenters.isEmpty()) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    mVar.updateMenuView(z10);
                }
            }
            startDispatchingItemsChanged();
        }
    }

    public final void c(Bundle bundle) {
        Parcelable parcelable;
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(PRESENTER_KEY);
        if (sparseParcelableArray != null && !this.mPresenters.isEmpty()) {
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = mVar.getId();
                    if (id > 0 && (parcelable = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        mVar.onRestoreInstanceState(parcelable);
                    }
                }
            }
        }
    }

    public void changeMenuMode() {
        a aVar = this.mCallback;
        if (aVar != null) {
            aVar.onMenuModeChange(this);
        }
    }

    public void clear() {
        i iVar = this.mExpandedItem;
        if (iVar != null) {
            collapseItemActionView(iVar);
        }
        this.mItems.clear();
        onItemsChanged(true);
    }

    public void clearAll() {
        this.mPreventDispatchingItemsChanged = true;
        clear();
        clearHeader();
        this.mPresenters.clear();
        this.mPreventDispatchingItemsChanged = false;
        this.mItemsChangedWhileDispatchPrevented = false;
        this.mStructureChangedWhileDispatchPrevented = false;
        onItemsChanged(true);
    }

    public void clearHeader() {
        this.mHeaderIcon = null;
        this.mHeaderTitle = null;
        this.mHeaderView = null;
        onItemsChanged(false);
    }

    public final void close(boolean z10) {
        if (!this.mIsClosing) {
            this.mIsClosing = true;
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    mVar.onCloseMenu(this, z10);
                }
            }
            this.mIsClosing = false;
        }
    }

    public boolean collapseItemActionView(i iVar) {
        boolean z10 = false;
        if (!this.mPresenters.isEmpty() && this.mExpandedItem == iVar) {
            stopDispatchingItemsChanged();
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    z10 = mVar.collapseItemActionView(this, iVar);
                    if (z10) {
                        break;
                    }
                }
            }
            startDispatchingItemsChanged();
            if (z10) {
                this.mExpandedItem = null;
            }
        }
        return z10;
    }

    public final void d(Bundle bundle) {
        Parcelable onSaveInstanceState;
        if (!this.mPresenters.isEmpty()) {
            SparseArray sparseArray = new SparseArray();
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    int id = mVar.getId();
                    if (id > 0 && (onSaveInstanceState = mVar.onSaveInstanceState()) != null) {
                        sparseArray.put(id, onSaveInstanceState);
                    }
                }
            }
            bundle.putSparseParcelableArray(PRESENTER_KEY, sparseArray);
        }
    }

    public boolean dispatchMenuItemSelected(g gVar, MenuItem menuItem) {
        a aVar = this.mCallback;
        if (aVar == null || !aVar.onMenuItemSelected(gVar, menuItem)) {
            return false;
        }
        return true;
    }

    public final boolean e(r rVar, m mVar) {
        boolean z10 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        if (mVar != null) {
            z10 = mVar.onSubMenuSelected(rVar);
        }
        Iterator<WeakReference<m>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null) {
                this.mPresenters.remove(next);
            } else if (!z10) {
                z10 = mVar2.onSubMenuSelected(rVar);
            }
        }
        return z10;
    }

    public boolean expandItemActionView(i iVar) {
        boolean z10 = false;
        if (this.mPresenters.isEmpty()) {
            return false;
        }
        stopDispatchingItemsChanged();
        Iterator<WeakReference<m>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar = (m) next.get();
            if (mVar == null) {
                this.mPresenters.remove(next);
            } else {
                z10 = mVar.expandItemActionView(this, iVar);
                if (z10) {
                    break;
                }
            }
        }
        startDispatchingItemsChanged();
        if (z10) {
            this.mExpandedItem = iVar;
        }
        return z10;
    }

    public int findGroupIndex(int i10) {
        return findGroupIndex(i10, 0);
    }

    public MenuItem findItem(int i10) {
        MenuItem findItem;
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.mItems.get(i11);
            if (iVar.getItemId() == i10) {
                return iVar;
            }
            if (iVar.hasSubMenu() && (findItem = iVar.getSubMenu().findItem(i10)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public int findItemIndex(int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            if (this.mItems.get(i11).getItemId() == i10) {
                return i11;
            }
        }
        return -1;
    }

    public i findItemWithShortcutForKey(int i10, KeyEvent keyEvent) {
        char c10;
        ArrayList<i> arrayList = this.mTempShortcutItemList;
        arrayList.clear();
        findItemsWithShortcutForKey(arrayList, i10, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean isQwertyMode = isQwertyMode();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = arrayList.get(i11);
            if (isQwertyMode) {
                c10 = iVar.getAlphabeticShortcut();
            } else {
                c10 = iVar.getNumericShortcut();
            }
            char[] cArr = keyData.meta;
            if ((c10 == cArr[0] && (metaState & 2) == 0) || ((c10 == cArr[2] && (metaState & 2) != 0) || (isQwertyMode && c10 == 8 && i10 == 67))) {
                return iVar;
            }
        }
        return null;
    }

    public void findItemsWithShortcutForKey(List<i> list, int i10, KeyEvent keyEvent) {
        char c10;
        int i11;
        boolean z10;
        boolean isQwertyMode = isQwertyMode();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i10 == 67) {
            int size = this.mItems.size();
            for (int i12 = 0; i12 < size; i12++) {
                i iVar = this.mItems.get(i12);
                if (iVar.hasSubMenu()) {
                    ((g) iVar.getSubMenu()).findItemsWithShortcutForKey(list, i10, keyEvent);
                }
                if (isQwertyMode) {
                    c10 = iVar.getAlphabeticShortcut();
                } else {
                    c10 = iVar.getNumericShortcut();
                }
                if (isQwertyMode) {
                    i11 = iVar.getAlphabeticModifiers();
                } else {
                    i11 = iVar.getNumericModifiers();
                }
                if ((modifiers & 69647) == (i11 & 69647)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10 && c10 != 0) {
                    char[] cArr = keyData.meta;
                    if ((c10 == cArr[0] || c10 == cArr[2] || (isQwertyMode && c10 == 8 && i10 == 67)) && iVar.isEnabled()) {
                        list.add(iVar);
                    }
                }
            }
        }
    }

    public void flagActionItems() {
        ArrayList<i> visibleItems = getVisibleItems();
        if (this.mIsActionItemsStale) {
            Iterator<WeakReference<m>> it = this.mPresenters.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                WeakReference next = it.next();
                m mVar = (m) next.get();
                if (mVar == null) {
                    this.mPresenters.remove(next);
                } else {
                    z10 |= mVar.flagActionItems();
                }
            }
            if (z10) {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                int size = visibleItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    i iVar = visibleItems.get(i10);
                    if (iVar.l()) {
                        this.mActionItems.add(iVar);
                    } else {
                        this.mNonActionItems.add(iVar);
                    }
                }
            } else {
                this.mActionItems.clear();
                this.mNonActionItems.clear();
                this.mNonActionItems.addAll(getVisibleItems());
            }
            this.mIsActionItemsStale = false;
        }
    }

    public ArrayList<i> getActionItems() {
        flagActionItems();
        return this.mActionItems;
    }

    public String getActionViewStatesKey() {
        return ACTION_VIEW_STATES_KEY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public i getExpandedItem() {
        return this.mExpandedItem;
    }

    public Drawable getHeaderIcon() {
        return this.mHeaderIcon;
    }

    public CharSequence getHeaderTitle() {
        return this.mHeaderTitle;
    }

    public View getHeaderView() {
        return this.mHeaderView;
    }

    public MenuItem getItem(int i10) {
        return this.mItems.get(i10);
    }

    public ArrayList<i> getNonActionItems() {
        flagActionItems();
        return this.mNonActionItems;
    }

    public boolean getOptionalIconsVisible() {
        return this.mOptionalIconsVisible;
    }

    public Resources getResources() {
        return this.mResources;
    }

    public g getRootMenu() {
        return this;
    }

    public ArrayList<i> getVisibleItems() {
        if (!this.mIsVisibleItemsStale) {
            return this.mVisibleItems;
        }
        this.mVisibleItems.clear();
        int size = this.mItems.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.mItems.get(i10);
            if (iVar.isVisible()) {
                this.mVisibleItems.add(iVar);
            }
        }
        this.mIsVisibleItemsStale = false;
        this.mIsActionItemsStale = true;
        return this.mVisibleItems;
    }

    public final void h(int i10, boolean z10) {
        if (i10 >= 0 && i10 < this.mItems.size()) {
            this.mItems.remove(i10);
            if (z10) {
                onItemsChanged(true);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.mOverrideVisibleItems) {
            return true;
        }
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            if (this.mItems.get(i10).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i(int i10, CharSequence charSequence, int i11, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.mHeaderView = view;
            this.mHeaderTitle = null;
            this.mHeaderIcon = null;
        } else {
            if (i10 > 0) {
                this.mHeaderTitle = resources.getText(i10);
            } else if (charSequence != null) {
                this.mHeaderTitle = charSequence;
            }
            if (i11 > 0) {
                this.mHeaderIcon = p.a.getDrawable(getContext(), i11);
            } else if (drawable != null) {
                this.mHeaderIcon = drawable;
            }
            this.mHeaderView = null;
        }
        onItemsChanged(false);
    }

    public boolean isGroupDividerEnabled() {
        return this.mGroupDividerEnabled;
    }

    public boolean isQwertyMode() {
        return this.mQwertyMode;
    }

    public boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        if (findItemWithShortcutForKey(i10, keyEvent) != null) {
            return true;
        }
        return false;
    }

    public boolean isShortcutsVisible() {
        return this.mShortcutsVisible;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0019, code lost:
        if (b0.p1.f(android.view.ViewConfiguration.get(r2.mContext), r2.mContext) != false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L_0x001c
            android.content.res.Resources r3 = r2.mResources
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.keyboard
            r0 = 1
            if (r3 == r0) goto L_0x001c
            android.content.Context r3 = r2.mContext
            android.view.ViewConfiguration r3 = android.view.ViewConfiguration.get(r3)
            android.content.Context r1 = r2.mContext
            boolean r3 = b0.p1.f(r3, r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            r2.mShortcutsVisible = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.g.j(boolean):void");
    }

    public void onItemActionRequestChanged(i iVar) {
        this.mIsActionItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemVisibleChanged(i iVar) {
        this.mIsVisibleItemsStale = true;
        onItemsChanged(true);
    }

    public void onItemsChanged(boolean z10) {
        if (!this.mPreventDispatchingItemsChanged) {
            if (z10) {
                this.mIsVisibleItemsStale = true;
                this.mIsActionItemsStale = true;
            }
            b(z10);
            return;
        }
        this.mItemsChangedWhileDispatchPrevented = true;
        if (z10) {
            this.mStructureChangedWhileDispatchPrevented = true;
        }
    }

    public boolean performIdentifierAction(int i10, int i11) {
        return performItemAction(findItem(i10), i11);
    }

    public boolean performItemAction(MenuItem menuItem, int i10) {
        return performItemAction(menuItem, (m) null, i10);
    }

    public boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        boolean z10;
        i findItemWithShortcutForKey = findItemWithShortcutForKey(i10, keyEvent);
        if (findItemWithShortcutForKey != null) {
            z10 = performItemAction(findItemWithShortcutForKey, i11);
        } else {
            z10 = false;
        }
        if ((i11 & 2) != 0) {
            close(true);
        }
        return z10;
    }

    public void removeGroup(int i10) {
        int findGroupIndex = findGroupIndex(i10);
        if (findGroupIndex >= 0) {
            int size = this.mItems.size() - findGroupIndex;
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= size || this.mItems.get(findGroupIndex).getGroupId() != i10) {
                    onItemsChanged(true);
                } else {
                    h(findGroupIndex, false);
                    i11 = i12;
                }
            }
            onItemsChanged(true);
        }
    }

    public void removeItem(int i10) {
        h(findItemIndex(i10), true);
    }

    public void removeItemAt(int i10) {
        h(i10, true);
    }

    public void removeMenuPresenter(m mVar) {
        Iterator<WeakReference<m>> it = this.mPresenters.iterator();
        while (it.hasNext()) {
            WeakReference next = it.next();
            m mVar2 = (m) next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.mPresenters.remove(next);
            }
        }
    }

    public void restoreActionViewStates(Bundle bundle) {
        MenuItem findItem;
        if (bundle != null) {
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(getActionViewStatesKey());
            int size = size();
            for (int i10 = 0; i10 < size; i10++) {
                MenuItem item = getItem(i10);
                View actionView = item.getActionView();
                if (!(actionView == null || actionView.getId() == -1)) {
                    actionView.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((r) item.getSubMenu()).restoreActionViewStates(bundle);
                }
            }
            int i11 = bundle.getInt(EXPANDED_ACTION_VIEW_ID);
            if (i11 > 0 && (findItem = findItem(i11)) != null) {
                findItem.expandActionView();
            }
        }
    }

    public void restorePresenterStates(Bundle bundle) {
        c(bundle);
    }

    public void saveActionViewStates(Bundle bundle) {
        int size = size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = getItem(i10);
            View actionView = item.getActionView();
            if (!(actionView == null || actionView.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt(EXPANDED_ACTION_VIEW_ID, item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((r) item.getSubMenu()).saveActionViewStates(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(getActionViewStatesKey(), sparseArray);
        }
    }

    public void savePresenterStates(Bundle bundle) {
        d(bundle);
    }

    public void setCallback(a aVar) {
        this.mCallback = aVar;
    }

    public void setCurrentMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mCurrentMenuInfo = contextMenuInfo;
    }

    public g setDefaultShowAsAction(int i10) {
        this.mDefaultShowAsAction = i10;
        return this;
    }

    public void setExclusiveItemChecked(MenuItem menuItem) {
        boolean z10;
        int groupId = menuItem.getGroupId();
        int size = this.mItems.size();
        stopDispatchingItemsChanged();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = this.mItems.get(i10);
            if (iVar.getGroupId() == groupId && iVar.m() && iVar.isCheckable()) {
                if (iVar == menuItem) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                iVar.s(z10);
            }
        }
        startDispatchingItemsChanged();
    }

    public void setGroupCheckable(int i10, boolean z10, boolean z11) {
        int size = this.mItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.mItems.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.t(z11);
                iVar.setCheckable(z10);
            }
        }
    }

    public void setGroupDividerEnabled(boolean z10) {
        this.mGroupDividerEnabled = z10;
    }

    public void setGroupEnabled(int i10, boolean z10) {
        int size = this.mItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.mItems.get(i11);
            if (iVar.getGroupId() == i10) {
                iVar.setEnabled(z10);
            }
        }
    }

    public void setGroupVisible(int i10, boolean z10) {
        int size = this.mItems.size();
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            i iVar = this.mItems.get(i11);
            if (iVar.getGroupId() == i10 && iVar.y(z10)) {
                z11 = true;
            }
        }
        if (z11) {
            onItemsChanged(true);
        }
    }

    public g setHeaderIconInt(Drawable drawable) {
        i(0, (CharSequence) null, 0, drawable, (View) null);
        return this;
    }

    public g setHeaderTitleInt(CharSequence charSequence) {
        i(0, charSequence, 0, (Drawable) null, (View) null);
        return this;
    }

    public g setHeaderViewInt(View view) {
        i(0, (CharSequence) null, 0, (Drawable) null, view);
        return this;
    }

    public void setOptionalIconsVisible(boolean z10) {
        this.mOptionalIconsVisible = z10;
    }

    public void setOverrideVisibleItems(boolean z10) {
        this.mOverrideVisibleItems = z10;
    }

    public void setQwertyMode(boolean z10) {
        this.mQwertyMode = z10;
        onItemsChanged(false);
    }

    public void setShortcutsVisible(boolean z10) {
        if (this.mShortcutsVisible != z10) {
            j(z10);
            onItemsChanged(false);
        }
    }

    public int size() {
        return this.mItems.size();
    }

    public void startDispatchingItemsChanged() {
        this.mPreventDispatchingItemsChanged = false;
        if (this.mItemsChangedWhileDispatchPrevented) {
            this.mItemsChangedWhileDispatchPrevented = false;
            onItemsChanged(this.mStructureChangedWhileDispatchPrevented);
        }
    }

    public void stopDispatchingItemsChanged() {
        if (!this.mPreventDispatchingItemsChanged) {
            this.mPreventDispatchingItemsChanged = true;
            this.mItemsChangedWhileDispatchPrevented = false;
            this.mStructureChangedWhileDispatchPrevented = false;
        }
    }

    public MenuItem add(int i10) {
        return addInternal(0, 0, 0, this.mResources.getString(i10));
    }

    public void addMenuPresenter(m mVar, Context context) {
        this.mPresenters.add(new WeakReference(mVar));
        mVar.initForMenu(context, this);
        this.mIsActionItemsStale = true;
    }

    public SubMenu addSubMenu(int i10) {
        return addSubMenu(0, 0, 0, (CharSequence) this.mResources.getString(i10));
    }

    public int findGroupIndex(int i10, int i11) {
        int size = size();
        if (i11 < 0) {
            i11 = 0;
        }
        while (i11 < size) {
            if (this.mItems.get(i11).getGroupId() == i10) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public boolean performItemAction(MenuItem menuItem, m mVar, int i10) {
        i iVar = (i) menuItem;
        if (iVar == null || !iVar.isEnabled()) {
            return false;
        }
        boolean k10 = iVar.k();
        b0.b a10 = iVar.a();
        boolean z10 = a10 != null && a10.b();
        if (iVar.j()) {
            k10 |= iVar.expandActionView();
            if (k10) {
                close(true);
            }
        } else if (iVar.hasSubMenu() || z10) {
            if ((i10 & 4) == 0) {
                close(false);
            }
            if (!iVar.hasSubMenu()) {
                iVar.x(new r(getContext(), this, iVar));
            }
            r rVar = (r) iVar.getSubMenu();
            if (z10) {
                a10.g(rVar);
            }
            k10 |= e(rVar, mVar);
            if (!k10) {
                close(true);
            }
        } else if ((i10 & 1) == 0) {
            close(true);
        }
        return k10;
    }

    public g setHeaderIconInt(int i10) {
        i(0, (CharSequence) null, i10, (Drawable) null, (View) null);
        return this;
    }

    public g setHeaderTitleInt(int i10) {
        i(i10, (CharSequence) null, 0, (Drawable) null, (View) null);
        return this;
    }

    public MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return addInternal(i10, i11, i12, charSequence);
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        i iVar = (i) addInternal(i10, i11, i12, charSequence);
        r rVar = new r(this.mContext, this, iVar);
        iVar.x(rVar);
        return rVar;
    }

    public MenuItem add(int i10, int i11, int i12, int i13) {
        return addInternal(i10, i11, i12, this.mResources.getString(i13));
    }

    public SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return addSubMenu(i10, i11, i12, (CharSequence) this.mResources.getString(i13));
    }

    public void close() {
        close(true);
    }
}
