package com.hpplay.glide.manager;

import com.hpplay.glide.RequestManager;
import java.util.Set;

public interface RequestManagerTreeNode {
    Set<RequestManager> getDescendants();
}
