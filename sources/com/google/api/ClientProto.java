package com.google.api;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import com.google.protobuf.WireFormat;
import java.util.List;

public final class ClientProto {
    public static final int DEFAULT_HOST_FIELD_NUMBER = 1049;
    public static final int METHOD_SIGNATURE_FIELD_NUMBER = 1051;
    public static final int OAUTH_SCOPES_FIELD_NUMBER = 1050;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.ServiceOptions, String> defaultHost;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.MethodOptions, List<String>> methodSignature;
    public static final GeneratedMessageLite.GeneratedExtension<DescriptorProtos.ServiceOptions, String> oauthScopes;

    static {
        DescriptorProtos.MethodOptions defaultInstance = DescriptorProtos.MethodOptions.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.STRING;
        methodSignature = GeneratedMessageLite.newRepeatedGeneratedExtension(defaultInstance, (MessageLite) null, (Internal.EnumLiteMap<?>) null, METHOD_SIGNATURE_FIELD_NUMBER, fieldType, false, String.class);
        WireFormat.FieldType fieldType2 = fieldType;
        defaultHost = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.ServiceOptions.getDefaultInstance(), "", (MessageLite) null, (Internal.EnumLiteMap<?>) null, 1049, fieldType2, String.class);
        oauthScopes = GeneratedMessageLite.newSingularGeneratedExtension(DescriptorProtos.ServiceOptions.getDefaultInstance(), "", (MessageLite) null, (Internal.EnumLiteMap<?>) null, OAUTH_SCOPES_FIELD_NUMBER, fieldType2, String.class);
    }

    private ClientProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) methodSignature);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) defaultHost);
        extensionRegistryLite.add((GeneratedMessageLite.GeneratedExtension<?, ?>) oauthScopes);
    }
}
