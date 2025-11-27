package com.google.firebase.inappmessaging.dagger;

public interface Lazy<T> {
    T get();
}
