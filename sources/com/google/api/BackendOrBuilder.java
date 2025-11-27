package com.google.api;

import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface BackendOrBuilder extends MessageLiteOrBuilder {
    BackendRule getRules(int i10);

    int getRulesCount();

    List<BackendRule> getRulesList();
}
