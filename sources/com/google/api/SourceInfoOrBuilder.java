package com.google.api;

import com.google.protobuf.Any;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

public interface SourceInfoOrBuilder extends MessageLiteOrBuilder {
    Any getSourceFiles(int i10);

    int getSourceFilesCount();

    List<Any> getSourceFilesList();
}
