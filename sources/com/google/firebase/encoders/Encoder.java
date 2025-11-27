package com.google.firebase.encoders;

interface Encoder<TValue, TContext> {
    void encode(TValue tvalue, TContext tcontext);
}
