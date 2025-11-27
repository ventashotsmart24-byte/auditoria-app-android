package org.simpleframework.xml.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

class OutputStack extends ArrayList<OutputNode> {
    private final Set active;

    public class Sequence implements Iterator<OutputNode> {
        private int cursor;

        public Sequence() {
            this.cursor = OutputStack.this.size();
        }

        public boolean hasNext() {
            if (this.cursor > 0) {
                return true;
            }
            return false;
        }

        public void remove() {
            OutputStack.this.purge(this.cursor);
        }

        public OutputNode next() {
            if (!hasNext()) {
                return null;
            }
            OutputStack outputStack = OutputStack.this;
            int i10 = this.cursor - 1;
            this.cursor = i10;
            return (OutputNode) outputStack.get(i10);
        }
    }

    public OutputStack(Set set) {
        this.active = set;
    }

    public OutputNode bottom() {
        if (size() <= 0) {
            return null;
        }
        return (OutputNode) get(0);
    }

    public Iterator<OutputNode> iterator() {
        return new Sequence();
    }

    public OutputNode pop() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return purge(size - 1);
    }

    public OutputNode purge(int i10) {
        OutputNode outputNode = (OutputNode) remove(i10);
        if (outputNode != null) {
            this.active.remove(outputNode);
        }
        return outputNode;
    }

    public OutputNode push(OutputNode outputNode) {
        this.active.add(outputNode);
        add(outputNode);
        return outputNode;
    }

    public OutputNode top() {
        int size = size();
        if (size <= 0) {
            return null;
        }
        return (OutputNode) get(size - 1);
    }
}
