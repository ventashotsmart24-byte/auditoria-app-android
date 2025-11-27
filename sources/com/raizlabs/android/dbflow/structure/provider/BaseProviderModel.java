package com.raizlabs.android.dbflow.structure.provider;

import android.database.Cursor;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public abstract class BaseProviderModel extends BaseModel implements ModelProvider {
    public boolean delete() {
        if (ContentUtils.delete(getDeleteUri(), this) > 0) {
            return true;
        }
        return false;
    }

    public boolean exists() {
        boolean z10 = false;
        Cursor query = ContentUtils.query(FlowManager.getContext().getContentResolver(), getQueryUri(), getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
        if (query != null && query.getCount() > 0) {
            z10 = true;
        }
        if (query != null) {
            query.close();
        }
        return z10;
    }

    public long insert() {
        ContentUtils.insert(getInsertUri(), this);
        return 0;
    }

    public void load(OperatorGroup operatorGroup, String str, String... strArr) {
        FlowCursor from = FlowCursor.from(ContentUtils.query(FlowManager.getContext().getContentResolver(), getQueryUri(), operatorGroup, str, strArr));
        if (from != null && from.moveToFirst()) {
            getModelAdapter().loadFromCursor(from, this);
            from.close();
        }
    }

    public boolean save() {
        int update = ContentUtils.update(getUpdateUri(), this);
        if (update == 0) {
            if (ContentUtils.insert(getInsertUri(), this) != null) {
                return true;
            }
            return false;
        } else if (update > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean update() {
        if (ContentUtils.update(getUpdateUri(), this) > 0) {
            return true;
        }
        return false;
    }

    public void load() {
        load(getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
    }
}
