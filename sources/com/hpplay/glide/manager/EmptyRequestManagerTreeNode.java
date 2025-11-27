package com.hpplay.glide.manager;

import com.hpplay.glide.RequestManager;
import java.util.Collections;
import java.util.Set;

final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    public Set<RequestManager> getDescendants() {
        return Collections.emptySet();
    }
}
