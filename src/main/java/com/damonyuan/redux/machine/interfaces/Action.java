package com.damonyuan.redux.machine.interfaces;


public interface Action<P> {
    String getName();

    P getPayload();
}
