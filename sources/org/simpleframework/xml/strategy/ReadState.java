package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

class ReadState extends WeakCache<ReadGraph> {
    private final Contract contract;
    private final Loader loader = new Loader();

    public ReadState(Contract contract2) {
        this.contract = contract2;
    }

    private ReadGraph create(Object obj) {
        ReadGraph readGraph = (ReadGraph) fetch(obj);
        if (readGraph != null) {
            return readGraph;
        }
        ReadGraph readGraph2 = new ReadGraph(this.contract, this.loader);
        cache(obj, readGraph2);
        return readGraph2;
    }

    public ReadGraph find(Object obj) {
        ReadGraph readGraph = (ReadGraph) fetch(obj);
        if (readGraph != null) {
            return readGraph;
        }
        return create(obj);
    }
}
