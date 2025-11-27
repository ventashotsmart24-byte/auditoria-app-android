package com.hpplay.component.protocol.server;

public interface IRequstManager {
    void closeAll();

    void closed(IRequestHandler iRequestHandler);

    void exec(IRequestHandler iRequestHandler);
}
