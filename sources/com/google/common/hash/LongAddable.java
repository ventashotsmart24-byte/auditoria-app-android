package com.google.common.hash;

@ElementTypesAreNonnullByDefault
interface LongAddable {
    void add(long j10);

    void increment();

    long sum();
}
