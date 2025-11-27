package m4;

import java.io.File;
import java.util.Comparator;

public final /* synthetic */ class c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return ((File) obj2).getName().compareTo(((File) obj).getName());
    }
}
