package com.google.protobuf;

import java.util.List;

public interface ListValueOrBuilder extends MessageLiteOrBuilder {
    Value getValues(int i10);

    int getValuesCount();

    List<Value> getValuesList();
}
