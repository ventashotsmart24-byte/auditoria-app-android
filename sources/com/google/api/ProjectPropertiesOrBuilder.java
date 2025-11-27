package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface ProjectPropertiesOrBuilder extends MessageLiteOrBuilder {
    Property getProperties(int i10);

    int getPropertiesCount();

    List<Property> getPropertiesList();
}
