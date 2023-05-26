package com.damonyuan.statepattern.redux.interfaces;

public interface Action<P> {
    String getName();

    P getPayload();
}
