package com.damonyuan.statepattern.machine.interfaces;


public interface Action<P> {
    String getName();

    P getPayload();
}
