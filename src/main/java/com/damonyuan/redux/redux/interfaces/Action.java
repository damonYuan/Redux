package com.damonyuan.redux.redux.interfaces;

public interface Action<P> {
    String getName();

    P getPayload();
}
