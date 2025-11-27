package org.simpleframework.xml.stream;

interface EventReader {
    EventNode next();

    EventNode peek();
}
