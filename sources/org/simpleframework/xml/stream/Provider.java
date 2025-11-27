package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

interface Provider {
    EventReader provide(InputStream inputStream);

    EventReader provide(Reader reader);
}
