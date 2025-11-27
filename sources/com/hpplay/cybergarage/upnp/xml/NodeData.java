package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.xml.Node;

public class NodeData {
    private Node node;

    public NodeData() {
        setNode((Node) null);
    }

    public Node getNode() {
        return this.node;
    }

    public void setNode(Node node2) {
        this.node = node2;
    }
}
