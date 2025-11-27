package com.raizlabs.android.dbflow.sql.language;

import com.raizlabs.android.dbflow.structure.BaseModel;

public interface Actionable {
    BaseModel.Action getPrimaryAction();
}
