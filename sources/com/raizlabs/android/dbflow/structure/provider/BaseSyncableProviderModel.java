package com.raizlabs.android.dbflow.structure.provider;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.OperatorGroup;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.raizlabs.android.dbflow.structure.database.FlowCursor;

public abstract class BaseSyncableProviderModel extends BaseModel implements ModelProvider {
    public boolean delete() {
        if (!super.delete() || ContentUtils.delete(getDeleteUri(), this) <= 0) {
            return false;
        }
        return true;
    }

    public long insert() {
        long insert = super.insert();
        ContentUtils.insert(getInsertUri(), this);
        return insert;
    }

    public void load(OperatorGroup operatorGroup, String str, String... strArr) {
        FlowCursor from = FlowCursor.from(ContentUtils.query(FlowManager.getContext().getContentResolver(), getQueryUri(), operatorGroup, str, strArr));
        if (from != null && from.moveToFirst()) {
            getModelAdapter().loadFromCursor(from, this);
            from.close();
        }
    }

    public boolean save() {
        if (exists()) {
            if (!super.save() || ContentUtils.update(getUpdateUri(), this) <= 0) {
                return false;
            }
            return true;
        } else if (!super.save() || ContentUtils.insert(getInsertUri(), this) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean update() {
        if (!super.update() || ContentUtils.update(getUpdateUri(), this) <= 0) {
            return false;
        }
        return true;
    }

    public void load() {
        load(getModelAdapter().getPrimaryConditionClause(this), "", new String[0]);
    }
}
